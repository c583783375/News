package sprint.www.news.utils;

/**
 * Created by admin on 2016/12/20 0020.
 */

public class Constants {

    public static class TabsConstants
    {
       public static final String HOME = "news";
       public static final String VIDEO = "video";
       public static final String TEL = "tel";
       public static final String MINE = "mine";
    }

    public static class Urls
    {
        private static String  newsURL = "http://route.showapi.com";
        public static String  NEWS= newsURL + "/109-35";
        public static String NEWS_TITLE = newsURL + "/109-34";
    }

    public static class NewKey
    {
        public static int showapi_appid = 29199;
        public static String showapi_sign = "da041ac7311e4324a609466a637f4691";
        public static String channelId = "5572a108b3cdc86cf39001ce";
        public static String name = "国际焦点";
    }

}
