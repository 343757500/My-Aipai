package mymap.my_aipai.payler;



import java.util.ArrayList;

import mymap.my_aipai.bean.VideoDetailInfo;
import mymap.my_aipai.bean.videoDetialBean;

/**
 * Created by Veigar on 16/8/8.
 */
public class VideoDetailNetEntity {

    public videoDetialBean.DataBean videoDetailInfo;
    public RecommendData recommendData;
    public ArrayList<String> videoHeadText;
    public ArrayList<ButtonIcon> buttonIcon;

    public class RecommendData {
        public VideoData videoData;

        public class VideoData {
            public ArrayList<VideoRecommendItem> recommendData;
        }
    }


}
