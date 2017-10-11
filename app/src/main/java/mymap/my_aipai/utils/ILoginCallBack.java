package mymap.my_aipai.utils;


import mymap.my_aipai.payler.UserInfo;

public interface ILoginCallBack {

    void onLoginSuccess(UserInfo userInfo, String platform);

    void onLoginFailed(String msg);
}
