package sprint.www.news.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lzy.okgo.OkGo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sprint.www.news.R;
import sprint.www.news.adapter.NewsPagerAdapter;
import sprint.www.news.base.BaseFragment;
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

//        OkGo.get(Constants.Urls.NEWS_TITLE)
//                .tag(this)
//                .params("showapi_appid",Constants.NewKey.showapi_appid)
//                .params("showapi_sign",Constants.NewKey.showapi_sign)
//                .execute(new );




    }


}
