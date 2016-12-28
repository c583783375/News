package sprint.www.news.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.adapter.Call;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sprint.www.news.R;
import sprint.www.news.adapter.NewsPagerAdapter;
import sprint.www.news.base.BaseFragment;
import sprint.www.news.callback.NewTitleJsonCallback;
import sprint.www.news.model.NewsResponse;
import sprint.www.news.model.new_title_model.ShowapiResBody;
import sprint.www.news.utils.Constants;
import sprint.www.news.widget.PagerSlidingTabStrip;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment{

    @BindView(R.id.tabs) PagerSlidingTabStrip mTabs;
    @BindView(R.id.pager) ViewPager mPager;
    private List<ShowapiResBody.ChannelList> mList = new ArrayList<>();
    private View view;
    private NewsPagerAdapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null)
        {
            view = inflater.inflate(R.layout.fragment_home,container,false);
            ButterKnife.bind(this,view);
            initData();

        }
        return view;
    }

    private void initAdapter() {

        adapter = new NewsPagerAdapter(getFragmentManager(),mList);
        mPager.setAdapter(adapter);
        mPager.setOffscreenPageLimit(0);
        mTabs.setViewPager(mPager);
    }

    @Override
    protected void initData() {

        OkGo.post(Constants.Urls.NEWS_TITLE)
                .tag(this)
                .cacheKey(Constants.NEWSTITLE)
                .cacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                .params("showapi_appid", String.valueOf(Constants.NewKey.showapi_appid))
                .params("showapi_sign",Constants.NewKey.showapi_sign)
                .execute(new NewTitleJsonCallback<NewsResponse<ShowapiResBody>>() {

                    @Override
                    public void onSuccess(NewsResponse<ShowapiResBody> newsResponse, okhttp3.Call call, okhttp3.Response response) {
                        ShowapiResBody showapiResBody = newsResponse.showapi_res_body;
                        List<ShowapiResBody.ChannelList> channelList = showapiResBody.channelList;
                        mList.clear();
                        mList.addAll(channelList);

                        initAdapter();
                    }

                    @Override
                    public void onCacheSuccess(NewsResponse<ShowapiResBody> newsResponse, okhttp3.Call call) {
                        super.onCacheSuccess(newsResponse, call);
                        onSuccess(newsResponse,call,null);
                    }
                });


    }

    private Toast mToast;
    private void showToast(String str)
    {
        if(mToast == null)
        {
            mToast = Toast.makeText(getContext(),str,Toast.LENGTH_SHORT);
        }else{
            mToast.setText(str);
        }
        mToast.show();
    }


}
