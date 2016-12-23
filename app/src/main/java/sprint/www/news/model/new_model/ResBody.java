package sprint.www.news.model.new_model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResBody implements Serializable{

    private static final long serialVersionUID = -1L;

    public Integer retCode;
    public Pagebean pagebean;


    public static class Pagebean  implements Serializable{

        private static final long serialVersionUID = -1L;

        public Integer allPages;
        public List<Contentlist> contentlist = new ArrayList<Contentlist>();
        public Integer currentPage;
        public Integer allNum;
        public Integer maxResult;

    }


    public static class Imageurl implements Serializable{

        private static final long serialVersionUID = -1L;

        public Integer height;
        public Integer width;
        public String url;

    }
    public static class Contentlist implements Serializable {

        private static final long serialVersionUID = -1L;

        public List<String> allList = new ArrayList<String>();
        public String pubDate;
        public Boolean havePic;
        public String title;
        public String channelName;
        public List<Imageurl> imageurls = new ArrayList<Imageurl>();
        public String desc;
        public String source;
        public String channelId;
        public String link;



    }





}
