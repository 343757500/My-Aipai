package mymap.my_aipai.utils;

/**
 * Created by leo on 29/6/15.
 * 试练场列表 - text数据对象
 */
public class TaskText {
    private String userCount;
    private String bgColor;
    private String title;
    private int status;
    private String goldCount;
    private int notice;
    private String endTime;
    private String url;

    public void setUserCount(String userCount) {
        this.userCount = userCount;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setGoldCount(String goldCount) {
        this.goldCount = goldCount;
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

    public String getUserCount() {
        return userCount;
    }

    public String getBgColor() {
        return bgColor;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getGoldCount() {
        return goldCount;
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

    @Override
    public String toString() {
        return "TaskText{" +
                "userCount='" + userCount + '\'' +
                ", bgColor='" + bgColor + '\'' +
                ", title='" + title + '\'' +
                ", status=" + status +
                ", goldCount='" + goldCount + '\'' +
                ", notice=" + notice +
                ", endTime='" + endTime + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
