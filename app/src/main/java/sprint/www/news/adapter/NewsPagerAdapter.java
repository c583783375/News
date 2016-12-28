package sprint.www.news.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import java.util.List;

import sprint.www.news.fragment.ContentFragment;
import sprint.www.news.model.new_title_model.ShowapiResBody;
import sprint.www.news.utils.Constants;


/**
 * Created by admin on 2016/12/20 0020.
 * 设置viewpager 的适配器
 */

public class NewsPagerAdapter<T> extends FragmentStatePagerAdapter {

    private FragmentManager fm;
    private List<T> mList = null;
    public NewsPagerAdapter(FragmentManager fm, List<T> mList) {
        super(fm);
        this.fm = fm;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        ShowapiResBody.ChannelList title = (ShowapiResBody.ChannelList) mList.get(position);
        Fragment fragment =  ContentFragment.newInstance();
        Bundle args = new Bundle();
        args.putSerializable(Constants.NEWSTITLE,title);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public int getCount() {
        if(mList == null){return  0;}
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ShowapiResBody.ChannelList title = (ShowapiResBody.ChannelList) mList.get(position);

        return title.name;
    }


}
