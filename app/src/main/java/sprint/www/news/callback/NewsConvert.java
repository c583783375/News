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
        if (rawType == NewsResponse.class) {
            NewsResponse newsResponse = Convert.fromJson(jsonReader, type);
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
