package sprint.www.news.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import sprint.www.news.fragment.ContentFragment;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by admin on 2016/12/20 0020.
 * 设置viewpager 的适配器
 */

public class NewsPagerAdapter<T> extends FragmentStatePagerAdapter {

    private FragmentManager fm;
    private List<T> mList = null;
    private List<Fragment> mListFragment = new ArrayList();
    public NewsPagerAdapter(FragmentManager fm, List<T> mList) {
        super(fm);
        this.fm = fm;
        this.mList = mList;
    }

    @Override
    public Fragment getItem(int position) {
        mListFragment.add(position, new ContentFragment());
        return mListFragment.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = (String) mList.get(position);
        return title;
    }


}
