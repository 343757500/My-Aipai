package mymap.my_aipai.bean;

/**
 * Created by PC-368 on 2016/8/25.
 */
public class LoginAutoInfo {

    private String openId;
    private String accessToken;
    private String refreshToken;
    private String platform;
    private long expiresIn;

    @Override
    public String toString() {
        return "LoginAutoInfo{" +
                "openId='" + openId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", platform='" + platform + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
