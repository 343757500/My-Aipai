package mymap.my_aipai.bean;

/**
 * Created by moo on 16/5/24.
 */
public class AccountEntity {
    private String bid;
    private String email;
    private String nickname;
    private String exp;
    private String gender;
    private String sid;
    private String flower;
    private String level;
    private String clientLasttime;
    private String createTime;
    private String status;
    private String type;
    private String bookCount;
    private String achieve;
    private String vip;//1国王 2亲王 3公爵 4侯爵 5伯爵 6子爵 7男爵 0什么都不是
    private String userText;
    private String lasttime;
    private String levelName;
    private String levelCss;
    private String levelCssWebApp;
    private String expTotal;
    private String achieveName;
    private String small;
    private String middle;
    private String _48;
    private String big;
    private String normal = "";
    private String thumbFileName;
    private String url;
    private String homeUrl;
    private String firstLogin;
    private String nowTime;
    private String correctTime;
    private String mobileMdStr;//用户绑定手机号码

    public void setBid(String bid) {
        this.bid = bid;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public String getBid() {
        return bid;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getExp() {
        return exp;
    }

    public String getGender() {
        return gender;
    }

    public String getSid() {
        return sid;
    }

    public String getFlower() {
        return flower;
    }

    public String getLevel() {
        return level;
    }

    public String getClientLasttime() {
        return clientLasttime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getBookCount() {
        return bookCount;
    }

    public String getAchieve() {
        return achieve;
    }

    public String getVip() {
        return vip;
    }

    public String getUserText() {
        return userText;
    }

    public String getLasttime() {
        return lasttime;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getLevelCss() {
        return levelCss;
    }

    public String getLevelCssWebApp() {
        return levelCssWebApp;
    }

    public String getExpTotal() {
        return expTotal;
    }

    public String getAchieveName() {
        return achieveName;
    }

    public String getSmall() {
        return small;
    }

    public String getMiddle() {
        return middle;
    }

    public String get_48() {
        return _48;
    }

    public String getBig() {
        return big;
    }

    public String getNormal() {
        return normal;
    }

    public String getThumbFileName() {
        return thumbFileName;
    }

    public String getUrl() {
        return url;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public String getFirstLogin() {
        return firstLogin;
    }

    public String getNowTime() {
        return nowTime;
    }

    public String getCorrectTime() {
        return correctTime;
    }

    public String getMobileMdStr() {
        return mobileMdStr;
    }

    public void setMobileMdStr(String mobileMdStr) {
        this.mobileMdStr = mobileMdStr;
    }
}
