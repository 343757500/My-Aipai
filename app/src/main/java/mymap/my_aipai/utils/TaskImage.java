package mymap.my_aipai.utils;

/**
 * Created by leo on 29/6/15.
 * 试练场列表 - img数据对象
 */
public class TaskImage {
    private int status;
    private int notice;
    private String endTime;
    private String url;
    private String img;

    public void setStatus(int status) {
        this.status = status;
    }


    public void setNotice(int notice) {
        this.notice = notice;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public int getNotice() {
        return notice;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "TaskImage{" +
                "status=" + status +
                ", notice=" + notice +
                ", endTime='" + endTime + '\'' +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
