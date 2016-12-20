package sprint.www.news.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sprint.www.news.R;
import sprint.www.news.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends BaseFragment {

    private View view;
    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null)
        {
            view = inflater.inflate(R.layout.fragment_content,container,false);
            findView();
        }
        return view;
    }

    private void findView() {

    }

    @Override
    protected void initData() {

    }
}
