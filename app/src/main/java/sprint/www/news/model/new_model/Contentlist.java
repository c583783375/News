package sprint.www.news.model.new_model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Contentlist implements Serializable {

    private static final long serialVersionUID = -1L;

    private List<String> allList = new ArrayList<String>();
    private String pubDate;
    private Boolean havePic;
    private String title;
    private String channelName;
    private List<Imageurl> imageurls = new ArrayList<Imageurl>();
    private String desc;
    private String source;
    private String channelId;
    private String link;

    /**
     * 
     * @return
     *     The allList
     */
    public List<String> getAllList() {
        return allList;
    }

    /**
     * 
     * @param allList
     *     The allList
     */
    public void setAllList(List<String> allList) {
        this.allList = allList;
    }

    /**
     * 
     * @return
     *     The pubDate
     */
    public String getPubDate() {
        return pubDate;
    }

    /**
     * 
     * @param pubDate
     *     The pubDate
     */
    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    /**
     * 
     * @return
     *     The havePic
     */
    public Boolean getHavePic() {
        return havePic;
    }

    /**
     * 
     * @param havePic
     *     The havePic
     */
    public void setHavePic(Boolean havePic) {
        this.havePic = havePic;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The channelName
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     * 
     * @param channelName
     *     The channelName
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     * 
     * @return
     *     The imageurls
     */
    public List<Imageurl> getImageurls() {
        return imageurls;
    }

    /**
     * 
     * @param imageurls
     *     The imageurls
     */
    public void setImageurls(List<Imageurl> imageurls) {
        this.imageurls = imageurls;
    }

    /**
     * 
     * @return
     *     The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 
     * @param desc
     *     The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 
     * @return
     *     The source
     */
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The channelId
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 
     * @param channelId
     *     The channelId
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

}
