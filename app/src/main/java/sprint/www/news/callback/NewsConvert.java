package sprint.www.news.callback;

import com.google.gson.stream.JsonReader;
import com.lzy.okgo.convert.Converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Response;
import sprint.www.news.model.NewsResponse;
import sprint.www.news.utils.Convert;

/**
 * Created by admin on 2016/12/21 0021.
 * 每次根据不同的项目模型不同进行修改
 * 由于目前新闻类项目的外围用的是用一个model 所有可以直接复用
 *
 */

public class NewsConvert<T> implements Converter {

    private ParameterizedType type;

    public static <T> NewsConvert<T> create() {
        return new NewsConvert<>();
    }

    public void setType(ParameterizedType type) {
        this.type = type;
    }
    
    @Override
    public T convertSuccess(Response response) throws Exception {
        JsonReader jsonReader = new JsonReader(response.body().charStream());
        Type rawType = type.getRawType();
        //NewsResponse.class model 类  一般修改这边
        if (rawType == NewsResponse.class) {
            NewsResponse newsResponse = Convert.fromJson(jsonReader, type);
            //如果要根据code 值进行修改可以在这边 增加分支
            if (newsResponse.showapi_res_code == 0) {
                //noinspection unchecked
                return (T) newsResponse;
            } else {
                throw new IllegalStateException(newsResponse.showapi_res_error);
            }
        }
        throw new IllegalStateException("基类错误无法解析!");
    }
}
