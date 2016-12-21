package sprint.www.news.model;


import java.io.Serializable;

/**
 * Created by admin on 2016/12/21 0021.
 */

public class NewsResponse<T> implements Serializable {

    private static final long serialVersionUID = -7041713994407568209L;
    public int showapi_res_code;
    public String showapi_res_error;
    public T showapi_res_body;

}
