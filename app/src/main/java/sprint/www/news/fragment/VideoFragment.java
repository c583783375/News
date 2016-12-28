package sprint.www.news.fragment;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import sprint.www.news.R;
import sprint.www.news.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment {

    @BindView(R.id.videoView) VideoView mVideoView;
    private View view;
    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view == null)
        {
            view = inflater.inflate(R.layout.fragment_video, container, false);
            ButterKnife.bind(this,view);
            initData();
            findView();
        }

        return view;
    }

    private void findView() {
        mVideoView.setVideoURI(Uri.parse("http://video.yidianzixun.com/video/get-url?key=video/32bd3b4c90e7b02d5493fe0d4bd6b471.mp4"));
        mVideoView.setMediaController(new MediaController(getContext()));
        mVideoView.requestFocus();

    }

    @Override
    protected void initData()
    {

    }

}
