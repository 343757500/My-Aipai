package mymap.my_aipai.interfaces;

/**
 * Created by DEVIN BLUNT on 2016/5/23.
 */
public interface ILoginConcreteCallback extends ILoginCallBack {
    void onLoginCall(String url, String platform);

    /**
     * 用于新手引导,在onSuccess回调之前调用
     *
     * @param isNewBid
     */
    void onLoginSucForBid(String bid, int isNewBid);


    void onGetOathCall();

}
