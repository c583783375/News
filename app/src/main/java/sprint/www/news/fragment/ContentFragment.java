package sprint.www.news.fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;
import sprint.www.news.R;
import sprint.www.news.adapter.NewsRecycleAdapter;
import sprint.www.news.base.BaseFragment;
import sprint.www.news.callback.NewsJsonCallback;
import sprint.www.news.model.NewsResponse;
import sprint.www.news.model.new_model.Contentlist;
import sprint.www.news.model.new_model.Pagebean;
import sprint.www.news.model.new_title_model.ShowapiResBody;
import sprint.www.news.utils.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{

    @BindView(R.id.content_recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.content_swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;
    private int currentPage = 0;
    private ShowapiResBody.ChannelList mTitle;
    private View view;
    private NewsRecycleAdapter mAdapter;
    private Toast mToast;
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
        mAdapter = new NewsRecycleAdapter(R.layout.item_news,null);
        mAdapter.isFirstOnly(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        mRecyclerView.setAdapter(mAdapter);

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
                .execute(new NewsJsonCallback<NewsResponse<sprint.www.news.model.new_model.ShowapiResBody>>() {
                    @Override
                    public void onSuccess(NewsResponse<sprint.www.news.model.new_model.ShowapiResBody> newsResponse, Call call, Response response) {
                        sprint.www.news.model.new_model.ShowapiResBody showapiResBody = newsResponse.showapi_res_body;
                        if(0 == showapiResBody.getRetCode())
                        {
                            List<Contentlist> contentlist= showapiResBody.getPagebean().getContentlist();
                            currentPage = showapiResBody.getPagebean().getCurrentPage();
                            mAdapter.setNewData(contentlist);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        //网络请求失败的回调,一般会弹个Toast
                        showToast(e.getMessage());
                        Log.e("==================",e.getMessage());
                    }

                    @Override
                    public void onAfter(@Nullable NewsResponse<sprint.www.news.model.new_model.ShowapiResBody> newsResponse, @Nullable Exception e) {
                        super.onAfter(newsResponse, e);
                        //可能需要移除之前添加的布局
                        mAdapter.removeAllFooterView();
                        //最后调用结束刷新的方法
                        setRefreshing(false);
                    }
                });

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
//    private void showToast(String str)
//    {
//        if(mToast == null)
//        {
//            mToast = Toast.makeText(getContext() , str ,Toast.LENGTH_SHORT);
//        }else{
//            mToast.setText(str);
//        }
//        mToast.show();
//    }

}
