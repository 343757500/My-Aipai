package mymap.my_aipai.payler;

import com.google.gson.annotations.SerializedName;

/**
 * Created by PC-182 on 2016/10/10.
 */

public class VideoAuthorRecommendItem {

    /**
     * id : 43802418
     * title : 小枫枪战王者：团队9杀打爆对面
     * bid : 31181754
     * spaceUrl : http://m.aipai.com/mobile/home_action-card_bid-31181754.html
     * nickname : 欧阳子枫
     * big : http://hc31.aipai.com/user/754/31181754/6491560/card/43802418/43802418_400.jpg
     * 800fix : http://hc31.aipai.com/user/754/31181754/6491560/card/43802418/43802418_800fix.jpg
     * url : http://m.aipai.com/m31/OjwoISAnJS1qJWQqLg.html
     * class : 1
     * share : 1
     * click : 1366
     * game : 穿越火线:枪战王者
     * gameid : 52350
     * flv : http://hc31.aipai.com/user/754/31181754/6491560/card/43802418/card.mp4?l=j
     * appName : 穿越火线:枪战王者
     * appId : 12541
     * saveTime : 1475997444
     * userPic : http://fu1.aipai.com/account/754/31181754/account/31181754_normal.jpg
     * fansCount : 1993
     * adwords : 我也是第一次玩枪战王者，如果有大神看到请勿喷。可以直接关闭视频谢谢！
     */

    public String id;
    public String title;
    public String bid;
    public String spaceUrl;
    public String nickname;
    public String big;
    @SerializedName("800fix")
    public String value800fix;
    public String url;
    @SerializedName("class")
    public String classX;
    public String share;
    public String click;
    public String game;
    public String gameid;
    public String flv;
    public String appName;
    public String appId;
    public String saveTime;
    public String userPic;
    public String fansCount;
    public String adwords;


}
