package sprint.www.news.model.newsmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("showapi_res_code")
    @Expose
    private Integer showapiResCode;
    @SerializedName("showapi_res_error")
    @Expose
    private String showapiResError;
    @SerializedName("showapi_res_body")
    @Expose
    private ResBody showapiResBody;

    /**
     * 
     * @return
     *     The showapiResCode
     */
    public Integer getShowapiResCode() {
        return showapiResCode;
    }

    /**
     * 
     * @param showapiResCode
     *     The showapi_res_code
     */
    public void setShowapiResCode(Integer showapiResCode) {
        this.showapiResCode = showapiResCode;
    }

    /**
     * 
     * @return
     *     The showapiResError
     */
    public String getShowapiResError() {
        return showapiResError;
    }

    /**
     * 
     * @param showapiResError
     *     The showapi_res_error
     */
    public void setShowapiResError(String showapiResError) {
        this.showapiResError = showapiResError;
    }

    /**
     * 
     * @return
     *     The showapiResBody
     */
    public ResBody getShowapiResBody() {
        return showapiResBody;
    }

    /**
     * 
     * @param showapiResBody
     *     The showapi_res_body
     */
    public void setShowapiResBody(ResBody showapiResBody) {
        this.showapiResBody = showapiResBody;
    }

}
