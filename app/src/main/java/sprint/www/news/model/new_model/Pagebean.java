package sprint.www.news.model.new_model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pagebean  implements Serializable{

    private static final long serialVersionUID = -1L;

    private Integer allPages;
    private List<Contentlist> contentlist = new ArrayList<Contentlist>();
    private Integer currentPage;
    private Integer allNum;
    private Integer maxResult;

    /**
     * 
     * @return
     *     The allPages
     */
    public Integer getAllPages() {
        return allPages;
    }

    /**
     * 
     * @param allPages
     *     The allPages
     */
    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    /**
     * 
     * @return
     *     The contentlist
     */
    public List<Contentlist> getContentlist() {
        return contentlist;
    }

    /**
     * 
     * @param contentlist
     *     The contentlist
     */
    public void setContentlist(List<Contentlist> contentlist) {
        this.contentlist = contentlist;
    }

    /**
     * 
     * @return
     *     The currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }

    /**
     * 
     * @param currentPage
     *     The currentPage
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * 
     * @return
     *     The allNum
     */
    public Integer getAllNum() {
        return allNum;
    }

    /**
     * 
     * @param allNum
     *     The allNum
     */
    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    /**
     * 
     * @return
     *     The maxResult
     */
    public Integer getMaxResult() {
        return maxResult;
    }

    /**
     * 
     * @param maxResult
     *     The maxResult
     */
    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

}
