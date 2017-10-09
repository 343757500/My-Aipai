package mymap.my_aipai.bean;

/**
 * Created by moo on 16/3/11.
 */
public class UpdateSkinEntity {
    private final String TAG = UpdateSkinEntity.class.getSimpleName();

    private String url;
    private String md5;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    @Override
    public String toString() {
        return TAG + ":{" +
                " url:" + url +
                " md5:" + md5 +
                "}";
    }
}
