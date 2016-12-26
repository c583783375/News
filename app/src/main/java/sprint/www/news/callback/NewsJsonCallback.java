package sprint.www.news.callback;

import com.lzy.okgo.callback.AbsCallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by admin on 2016/12/22 0022.
 */

public abstract class NewsJsonCallback<T> extends AbsCallback<T> {


    @Override
    public T convertSuccess(Response response) throws Exception {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        Type type = params[0];
        if (!(type instanceof ParameterizedType)) throw new IllegalStateException("没有填写泛型参数");

        NewsConvert<T> convert = NewsConvert.create();
        convert.setType((ParameterizedType) type);
        T t = convert.convertSuccess(response);
        response.close();
        return t;
    }
}
