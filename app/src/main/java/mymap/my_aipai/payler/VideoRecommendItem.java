package mymap.my_aipai.payler;

/**
 * Created by Veigar on 16/8/8.
 */
public class VideoRecommendItem {
    public String pic;
    public String url;
    public String title;
    public String id;
    /***type=1为视频资源
     * type=2为非视频资源***/
    public String type;
    public String tagName;
    public String tagColor;
    /***url是否外链***/
    public boolean isOut;
    public boolean showMore = false;

    @Override
    public String toString() {
        return "VideoRecommendItem{" +
                "id='" + id + '\'' +
                ", pic='" + pic + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagColor='" + tagColor + '\'' +
                ", isOut=" + isOut +
                ", showMore=" + showMore +
                '}';
    }
}
