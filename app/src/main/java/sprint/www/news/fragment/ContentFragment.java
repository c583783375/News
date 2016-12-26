package sprint.www.news.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;
import sprint.www.news.R;
import sprint.www.news.activity.WebActivity;
import sprint.www.news.adapter.NewsRecycleAdapter;
import sprint.www.news.base.BaseFragment;
import sprint.www.news.callback.NewsJsonCallback;
import sprint.www.news.model.NewsResponse;
import sprint.www.news.model.new_title_model.ShowapiResBody;
import sprint.www.news.model.newsmodel.Contentlist;
import sprint.www.news.model.newsmodel.Pagebean;
import sprint.www.news.model.newsmodel.ResBody;
import sprint.www.news.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,BaseQuickAdapter.RequestLoadMoreListener{

    @BindView(R.id.content_recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.content_swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private int currentPage = 0;
    private ShowapiResBody.ChannelList mTitle;
    private View view;
    private   List<Contentlist> moreList = new ArrayList<>();
    private NewsRecycleAdapter mAdapter;
    private Toast mToast;
    private boolean isInitCache;
    public ContentFragment() {
        // Required empty public constructor
    }
    public static ContentFragment newInstance() {
        return new ContentFragment();
    }

    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null)
        {
            view = inflater.inflate(R.layout.fragment_content,container,false);
            ButterKnife.bind(this,view);
            initDatas();
            findView();
        }
        return view;
    }

    private void initDatas() {
        Bundle args = getArguments();
        mTitle = (ShowapiResBody.ChannelList) args.getSerializable(Constants.NEWSTITLE);
    }

    private void findView() {

        mAdapter = new NewsRecycleAdapter(R.layout.item_news,moreList);
        mAdapter.isFirstOnly(false);
        //设置动画
        mAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mAdapter.setOnLoadMoreListener(this);

      //  mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener(){
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int position) {
            }

//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                super.onItemClick(adapter, view, position);
//            }
//
//            @Override
//            public void onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
//                super.onItemLongClick(adapter, view, position);
//            }
//
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                super.onItemChildClick(adapter, view, position);
                switch (view.getId())
                {
                    case R.id.desc :
                    case R.id.title :
                        Contentlist content = (Contentlist) baseQuickAdapter.getItem(position);
                        WebActivity.runActivity(getContext(),content.getTitle(),content.getLink());
                        break;

                }

            }

//            @Override
//            public void onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
//                super.onItemChildLongClick(adapter, view, position);
//            }
        });

        mSwipeRefreshLayout.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        setRefreshing(true);
        onRefresh();
    }

    //懒加载
    @Override
    protected void initData() {}

    //下拉刷新
    @Override
    public void onRefresh() {
        currentPage = 0;
        OkGo.post(Constants.Urls.NEWS)
                .tag(this)
                .params("showapi_appid", String.valueOf(Constants.NewKey.showapi_appid))
                .params("showapi_sign",Constants.NewKey.showapi_sign)
                .params("channelId",mTitle.channelId)
                .params("channelName",mTitle.name)
                .params("page",currentPage + 1)
                .cacheKey(mTitle.channelId)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .execute(new NewsJsonCallback<NewsResponse<ResBody>>() {
                    @Override
                    public void onSuccess(NewsResponse<ResBody> newsResponse, Call call, Response response) {
                        Pagebean pagebean = newsResponse.getShowapi_res_body().getPagebean();
                        currentPage = pagebean.getCurrentPage();
                        List<Contentlist> more = pagebean.getContentlist();
                        mAdapter.setNewData(more);
                      mSwipeRefreshLayout.setRefreshing(false);
                    }

                    @Override
                    public void onCacheSuccess(NewsResponse<ResBody> resBodyNewsResponse, Call call) {
                        super.onCacheSuccess(resBodyNewsResponse, call);
                        //第一次进来才使用缓存
                        if(!isInitCache)
                        {
                            onSuccess(resBodyNewsResponse,call,null);
                            isInitCache = true;
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        showToast(e.getMessage());
                    }

                    @Override
                    public void onAfter(NewsResponse<ResBody> resBodyNewsResponse, Exception e) {
                        super.onAfter(resBodyNewsResponse, e);
                        //可能需要移除之前添加的布局
                        mAdapter.removeAllFooterView();
                        //最后调用结束刷新的方法
                        setRefreshing(false);
                    }
                });

        //TODO
//                .execute(new StringCallback() {
//                    @Override
//                    public void onSuccess(String s, Call call, Response response) {
//                        try{
//                            JSONArray object = new JSONObject(s).getJSONObject("showapi_res_body").getJSONObject("pagebean").getJSONArray("contentlist");
//                            Type newsContentType = new TypeToken<List<NewsContent>>() {}.getType();
//                            List<NewsContent> more = new Gson().fromJson(object.toString(), newsContentType);
//                            Log.e("============",more.toString());
//                            mAdapter.setNewData(more);
//                            mSwipeRefreshLayout.setRefreshing(false);
//                            currentPage++;
//                        }catch(Exception e)
//                        {
//                            showToast("解析错误！");
//                        }
//                    }
//
//                });

    }

    //放在子线程中 如果没有放在子线程中 无法看到加载的效果
    private void setRefreshing(final boolean refreshing) {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(refreshing);

            }
        });
    }

    public void showToast(String msg) {
        Snackbar.make(mRecyclerView, msg, Snackbar.LENGTH_SHORT).show();
    }

    //加载更多
    @Override
    public void onLoadMoreRequested() {
        OkGo.post(Constants.Urls.NEWS)
                .tag(this)
                .params("showapi_appid", String.valueOf(Constants.NewKey.showapi_appid))
                .params("showapi_sign",Constants.NewKey.showapi_sign)
                .params("channelId",mTitle.channelId)
                .params("channelName",mTitle.name)
                .params("page",currentPage + 1)
                .cacheKey(mTitle.channelId)
                .cacheMode(CacheMode.NO_CACHE)
                .execute(new NewsJsonCallback<NewsResponse<ResBody>>() {
                    @Override
                    public void onSuccess(NewsResponse<ResBody> newsResponse, Call call, Response response) {
                        Pagebean pagebean = newsResponse.getShowapi_res_body().getPagebean();
                        currentPage = pagebean.getCurrentPage();
                        List<Contentlist> more = pagebean.getContentlist();
                        mAdapter.addData(more);
                        mSwipeRefreshLayout.setRefreshing(false);
                        if( currentPage == pagebean.getAllPages())
                        {   //显示加载完成没有更多数据
                            mAdapter.loadComplete();
                            //自定义加载完成  布局
                            View noDataView = inflater.inflate(R.layout.item_no_data, (ViewGroup) mRecyclerView.getParent(), false);
                            mAdapter.addFooterView(noDataView);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        //显示加载失败
                        mAdapter.showLoadMoreFailedView();
                        showToast(e.getMessage());
                    }
                });
    }
}
