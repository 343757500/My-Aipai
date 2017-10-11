package mymap.my_aipai.interfaces;


import mymap.my_aipai.bean.LoginAutoInfo;

/**
 * @ClassName ILoginGetBindInfoListener
 * @Description 【获取第三方绑定的信息】
 * @Author lidongwen@aipai.com
 * @Date 2015年6月19日 下午6:59:37
 */
public interface IThirdLoginGetOathCallback {
    /**
     * @param autoInfo  第三方授权信息
     * @Title onTakeThirdInfo
     * @Description 【获取第三方绑定的信息】
     * @Author lidongwen@aipai.com
     * @Date 2015年6月19日 下午6:59:53
     * @Return void 返回类型
     */
    void onTakeThirdInfo(LoginAutoInfo autoInfo);

    void onFail();

    void onStart();
}
