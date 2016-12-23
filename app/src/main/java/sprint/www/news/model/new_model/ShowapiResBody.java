package sprint.www.news.model.new_model;


import java.io.Serializable;

public class ShowapiResBody implements Serializable{

    private static final long serialVersionUID = -1L;

    private Integer retCode;
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
