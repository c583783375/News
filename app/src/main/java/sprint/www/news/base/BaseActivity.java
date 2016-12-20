package sprint.www.news.base;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import butterknife.ButterKnife;
import sprint.www.news.utils.ActivityManage;


/**
 * Created by admin on 2016/12/12 0012.
 */

public abstract class BaseActivity  extends AppCompatActivity {

    public abstract int setLayout();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        Log.e("BaseActivity",activityManager.getRunningTasks(1).get(0).topActivity.getClassName());
        //传入一个布局
        ActivityManage.addActivity(this);
        setContentView(setLayout());
      //  setLayout(layout);
        //绑定黄牛刀
        ButterKnife.bind(this);
        initData();
        initView();
    }

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        ActivityManage.removeActivity(this);
        super.onDestroy();
    }



    protected abstract void initData();
}
