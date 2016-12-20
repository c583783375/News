package sprint.www.news.entity.new_model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ShowapiResBody {

    @SerializedName("ret_code")
    @Expose
    private Integer retCode;
    @SerializedName("pagebean")
    @Expose
    private Pagebean pagebean;

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
     *     The pagebean
     */
    public Pagebean getPagebean() {
        return pagebean;
    }

    /**
     * 
     * @param pagebean
     *     The pagebean
     */
    public void setPagebean(Pagebean pagebean) {
        this.pagebean = pagebean;
    }

}
