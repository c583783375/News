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
    private List<String> mList = new ArrayList<>();
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
            findView();
        }
        return view;
    }

    private void findView() {
        adapter = new NewsPagerAdapter(getFragmentManager(),mList);
        mPager.setAdapter(adapter);
        mPager.setOffscreenPageLimit(3);
        mTabs.setViewPager(mPager);

    }

    @Override
    protected void initData() {
        for (int i = 0 ; i<20;i++){
            mList.add("tab"+i);
        }
    //    adapter.notifyDataSetChanged();

        OkGo.post(Constants.Urls.NEWS_TITLE)
                .tag(this)
                .cacheKey("newtitle")
                .params("showapi_appid", String.valueOf(Constants.NewKey.showapi_appid))
                .params("showapi_sign",Constants.NewKey.showapi_sign)
                .execute(new NewTitleJsonCallback<NewsResponse<ShowapiResBody>>() {

                    @Override
                    public void onSuccess(NewsResponse<ShowapiResBody> newsResponse, okhttp3.Call call, okhttp3.Response response) {
                        ShowapiResBody showapiResBody = newsResponse.showapi_res_body;
                        List<ShowapiResBody.ChannelList> channelList = showapiResBody.channelList;
                        Log.e("=========",channelList.toString());
                        showToast(channelList.toString());
                    }
                });


//                .execute(new NewTitleJsonCallback<NewsResponse<ShowapiResBody>>(){
//                    @Override
//                    public void onSuccess(NewsResponse<ShowapiResBody> newsResponse, Call call, Response response) {
//                        ShowapiResBody showapiResBody = newsResponse.showapi_res_body;
//                        List<ShowapiResBody.ChannelList> channelList = showapiResBody.channelList;
//                        Log.e("=========",channelList.toString());
//                        showToast(channelList.toString());
//                    }
//
//                    @Override
//                    public void onError(Call call, Response response, Exception e) {
//                        super.onError(call, response, e);
//                        //   showToast(e.getMessage());
//                        showToast("失败");
//                        Log.e("=========","-----------------------------------------"+ Constants.Urls.NEWS_TITLE);
//                        Log.e("=========",e.getMessage());
//                    }
//                });




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
