package mymap.my_aipai.interfaces;


import com.tencent.tauth.IUiListener;

/**
 * Created by zsp on 2017/8/16.
 */

public interface ILoginCallBack {
    void onLoginSuccess(String msg, IUiListener iUiListener);

    void onLoginFailed(String msg, IUiListener iUiListener);
}
