package sprint.www.news.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/12 0012.
 * 用来保存当前打开的所有的activity
 */


public class ActivityManage {
    public static List<Activity> ActivityList =new ArrayList<Activity>();

    public static void addActivity(Activity activity)
    {
        ActivityList.add(activity);
    }
    public static void removeActivity(Activity activity)
    {
        ActivityList.remove(activity);
    }
    public static void removeActivity(int position)
    {
        ActivityList.remove(position);
    }

    //退出系统的使用关闭所有的Activity
    public static void finishActivity()
    {
        for(Activity activity:ActivityList)
        {
            activity.finish();
        }
    }


}
