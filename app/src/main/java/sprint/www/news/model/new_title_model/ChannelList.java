package sprint.www.news.model.new_title_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChannelList implements Serializable{

    private static final long serialVersionUID = -1L;
    @SerializedName("channelId")
    @Expose
    public String channelId;
    @SerializedName("name")
    @Expose
    public String name;

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
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChannelList{" +
                "channelId='" + channelId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
