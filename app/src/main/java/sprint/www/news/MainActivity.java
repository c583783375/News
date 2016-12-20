package sprint.www.news;

import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import sprint.www.news.base.BaseActivity;
import sprint.www.news.fragment.HomeFragment;
import sprint.www.news.fragment.MineFragment;
import sprint.www.news.fragment.TelFragment;
import sprint.www.news.fragment.VideoFragment;
import sprint.www.news.utils.Constants;

public class MainActivity extends BaseActivity {

    private FragmentTabHost mTabHost;
    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mTabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("one").setIndicator(getView(Constants.TabsConstants.HOME)),
                HomeFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("two").setIndicator(getView(Constants.TabsConstants.VIDEO)),
                VideoFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("three").setIndicator(getView(Constants.TabsConstants.TEL)),
                TelFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("four").setIndicator(getView(Constants.TabsConstants.MINE)),
                MineFragment.class, null);

    }

    private View getView(String str) {
        View view = getLayoutInflater().inflate(R.layout.main_tabs, null);
        ImageView mImgTitle = (ImageView) view.findViewById(R.id.img_main_tabs_title);
        TextView mTvTitle = (TextView) view.findViewById(R.id.tv_main_tabs_title);
        switch (str) {
            case Constants.TabsConstants.HOME:
                mImgTitle.setImageResource(R.drawable.icon_tabs_selector_home);
                mTvTitle.setText(R.string.tabs_news);
                break;
            case Constants.TabsConstants.VIDEO:
                mImgTitle.setImageResource(R.drawable.icon_tabs_selector_home);
                mTvTitle.setText(R.string.tabs_video);

                break;
            case Constants.TabsConstants.TEL:
                mImgTitle.setImageResource(R.drawable.icon_tabs_selector_home);
                mTvTitle.setText(R.string.tabs_tel);

                break;
            case Constants.TabsConstants.MINE:

                mImgTitle.setImageResource(R.drawable.icon_tabs_selector_home);
                mTvTitle.setText(R.string.tabs_mine);
                break;

            default:
                break;
        }
        return view;
    }

    @Override
    protected void initData() {

    }
}
