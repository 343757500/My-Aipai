package mymap.my_aipai.callback;

/**
 * Created by xmx on 2017/2/5.
 */

public interface IBaseJsonParseCallback<T> {
    void onSuccess(T t);

    void onFailure(String msg);
}
