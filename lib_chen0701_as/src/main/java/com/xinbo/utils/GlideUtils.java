package com.xinbo.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.SimpleTarget;
import com.yuchen.lib.R;

/**
 * Created by admin on 2016/10/14 0014.
 * 图片加载工具 谷歌推荐使用
 */

public class GlideUtils
{
    //默认缓存
    public static void displayImage(Context context,String imageUrl,ImageView imageView)
    {
        //api里面对placeholder()、error()函 设置加载中以及加载失败图片
        Glide.with(context).load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.NORMAL)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .into(imageView);
//        all:缓存源资源和转换后的资源
//        none:不作任何磁盘缓存
//        source:缓存源资源
//        result：缓存转换后的资源
    }
    //不作任何磁盘缓存
    public static void displayNoCacheImage(Context context,String imageUrl,ImageView imageView)
    {
        //api里面对placeholder()、error()函 设置加载中以及加载失败图片
        Glide.with(context).load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .priority(Priority.NORMAL)
                .into(imageView);
    }

    //设置跳过内存缓存
    public static void displayImageSkipMemoryCache(Context context,String imageUrl,ImageView imageView)
    {
        //api里面对placeholder()、error()函 设置加载中以及加载失败图片
        Glide.with(context).load(imageUrl)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.NORMAL)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .into(imageView);
    }
    //设置下载优先级  有五个等级IMMEDIATE, HIGH,NORMAL, LOW, priority, 默认是NORMAL
    public static void displayPriorityImage(Context context,String imageUrl,ImageView imageView ,Priority priority)
    {
        //api里面对placeholder()、error()函 设置加载中以及加载失败图片
        Glide.with(context).load(imageUrl)
                .skipMemoryCache(true)
                .priority(priority) //IMMEDIATE, HIGH,NORMAL, LOW, priority,
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .into(imageView);
    }

//    设置加载动画 crossFade()
    public static void displayAnimolImage(Context context,String imageUrl,ImageView imageView )
    {
        Glide.with(context).load(imageUrl)
                .animate(R.anim.item_alpha_in)
                .priority(Priority.NORMAL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .into(imageView);
    }
//    设置加载动画 crossFade()
    public static void displayAnimolNoCacheImage(Context context,String imageUrl,ImageView imageView )
    {
        Glide.with(context).load(imageUrl)
                .skipMemoryCache(true) //跳过内存缓存
                .animate(R.anim.item_alpha_in)
                .priority(Priority.NORMAL)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .into(imageView);
    }
    //加载图片需要指定具体的宽高
    public static void displayImage(Context context,String imageUrl,ImageView imageView,int height , int width )
    {
        Glide.with(context).load(imageUrl)
                .priority(Priority.NORMAL)
                .override(height, width)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .into(imageView);
    }

    //不作任何磁盘缓存加载图片需要指定具体的宽高
    public static void displayNoCacheImage(Context context,String imageUrl,ImageView imageView,int height , int width )
    {
        //api里面对placeholder()、error()函 设置加载中以及加载失败图片
        Glide.with(context).load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(height, width)
                .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .priority(Priority.NORMAL)
                .into(imageView);
    }


    //设置动画转换
    // api提供了比如：centerCrop()、fitCenter()等函数也可以通过自定义Transformation，
//    Glide.with(this).load(imageUrl).centerCrop().into(imageView);
    public static void displayCircleImage(Context context,String imageUrl,ImageView imageView )
    {
        //api里面对placeholder()、error()函 设置加载中以及加载失败图片
        Glide.with(context).load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .centerCrop()
//                .fitCenter()
                .transform(new GlideRoundTransform(context,100000)) //设置圆角 100000 是角度
              //  .placeholder(R.drawable.ic_stub) //设置加载中
                .error(R.drawable.ic_error)//加载失败图片
                .priority(Priority.NORMAL)
                .into(imageView);
    }

//    设置要加载的内容
//    项目中有很多需要先下载图片然后再做一些合成的功能，比如项目中出现的图文混排，该如何实现目标下
    public static void getImageResource(Context context, String imageUrl, final  SimpleTarget<GlideDrawable> simpleTarget)
    {
        Glide.with(context).load(imageUrl).centerCrop().into(simpleTarget);
    }
//    new SimpleTarget<GlideDrawable>()
//    {
//        @Override
//        public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
//        mImage.setImageDrawable(resource);
//    }
//    });


 //   15.)设置动态GIF加载方式
    public static void displayBitmapGIF(Context context,String imageUrl,ImageView imageView)
    {
        Glide.with(context).load(imageUrl).asBitmap().into(imageView);//显示gif静态图片
    }
    public static void displayGIF(Context context,String imageUrl,ImageView imageView)
    {
        Glide.with(context).load(imageUrl).asGif().into(imageView);//显示gif动态图片
    }

    //设置监听的用处 可以用于监控请求发生错误来源，以及图片来源 是内存还是磁盘
    public static void displayErroryImage(Context context,String imageUrl,ImageView imageView ,RequestListener<String, GlideDrawable> listener)
    {
        Glide.with(context).load(imageUrl)
                .listener(listener).into(imageView);

//       new RequestListener<String, GlideDrawable>() {
//    @Override
//    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//        return false;
//    }
//
//    @Override
//    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target,
//                                   boolean isFromMemoryCache, boolean isFirstResource) {
//        //imageView.setImageDrawable(resource);
//        return false;
//    }
//    }

    }





    //清除磁盘缓存
    public static void clearDiskCache(Context context)
    {
        Glide.get(context).clearDiskCache();//清理磁盘缓存 需要在子线程中执行
    }
    //清除内存缓存
    public static void clearMemory(Context context)
    {
        Glide.get(context).clearMemory();//清理内存缓存  可以在UI主线程中进行
    }




}
