package sprint.www.news.model.new_title_model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShowapiResBody  implements Serializable{

    private static final long serialVersionUID = -1L;

    public Integer totalNum;
    public Integer retCode;
    public List<ChannelList> channelList = new ArrayList<ChannelList>();



    public static class ChannelList implements Serializable {

        private static final long serialVersionUID = -1L;
        public String channelId;
        public String name;

        @Override
        public String toString() {
            return "ChannelList{" +
                    "channelId='" + channelId + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

}
