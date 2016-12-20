package sprint.www.news.entity.new_title_model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowapiResBody {

    @SerializedName("totalNum")
    @Expose
    private Integer totalNum;
    @SerializedName("ret_code")
    @Expose
    private Integer retCode;
    @SerializedName("channelList")
    @Expose
    private List<ChannelList> channelList = new ArrayList<ChannelList>();

    /**
     * 
     * @return
     *     The totalNum
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * 
     * @param totalNum
     *     The totalNum
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 
     * @return
     *     The retCode
     */
    public Integer getRetCode() {
        return retCode;
    }

    /**
     * 
     * @param retCode
     *     The ret_code
     */
    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    /**
     * 
     * @return
     *     The channelList
     */
    public List<ChannelList> getChannelList() {
        return channelList;
    }

    /**
     * 
     * @param channelList
     *     The channelList
     */
    public void setChannelList(List<ChannelList> channelList) {
        this.channelList = channelList;
    }

}
