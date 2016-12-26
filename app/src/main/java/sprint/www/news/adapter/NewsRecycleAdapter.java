package sprint.www.news.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

import sprint.www.news.R;
import sprint.www.news.model.newsmodel.Contentlist;
import sprint.www.news.model.newsmodel.Imageurl;

/**
 * Created by admin on 2016/12/22 0022.
 */

public class NewsRecycleAdapter extends BaseQuickAdapter<Contentlist> {
    public NewsRecycleAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }

    public NewsRecycleAdapter(List data) {
        super(data);
    }

    public NewsRecycleAdapter(View contentView, List data) {
        super(contentView, data);
    }


    @Override
    protected void convert(BaseViewHolder holder, Contentlist contentlist) {

        holder.setText(R.id.title,contentlist.getTitle())
                .setText(R.id.desc,contentlist.getDesc())
                .setText(R.id.pubDate,contentlist.getPubDate())
                .setText(R.id.source,contentlist.getSource())
                .addOnClickListener(R.id.desc)
                .addOnClickListener(R.id.title);



        //以下是nineGridview 的使用
        List<Imageurl> imageurls = contentlist.getImageurls();
        NineGridView nineGridView = holder.getView(R.id.nineGrid);
        ArrayList<ImageInfo> imageInfo = new ArrayList<>();
        if (imageurls != null) {
            for (Imageurl image : imageurls) {
                ImageInfo info = new ImageInfo();
                info.setThumbnailUrl(image.getUrl());
                info.setBigImageUrl(image.getUrl());
                imageInfo.add(info);
            }
        }
        nineGridView.setAdapter(new NineGridViewClickAdapter(mContext, imageInfo));
        if (imageurls != null && imageurls.size() == 1) {
            nineGridView.setSingleImageRatio(imageurls.get(0).getWidth() * 1.0f / imageurls.get(0).getHeight());
        }

    }
}
