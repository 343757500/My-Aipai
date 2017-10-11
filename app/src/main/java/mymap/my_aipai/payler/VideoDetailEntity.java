package mymap.my_aipai.payler;


import java.util.ArrayList;

import mymap.my_aipai.bean.VideoDetailInfo;
import mymap.my_aipai.bean.videoDetialBean;

/**
 * Created by Veigar on 16/8/1.
 */
public class VideoDetailEntity {

    public static final int ITEM_VIDEO_AUTHOR = 0X0100;
    public static final int ITEM_VIDEO_GIFTS = 0X0101;
    public static final int ITEM_VIDEO_ADVER = 0X0102;
    public static final int ITEM_VIDEO_RECOMMEND = 0X0103;
    public static final int ITEM_VIDEO_LIVE = 0X0104;
    public static final int ITEM_VIDEO_AUTHOR_RECOMMEND = 0X0105;
    /***
     * 暂时不做
     ***/
    public static final int ITEM_VIDEO_DECLARE = 0X0105;
    public static final int ITEM_VIDEO_DISCUSS_HEAD = 0X0106;
    public static final int ITEM_VIDEO_DISCUSS_ITEM = 0X0107;
    public static final int ITEM_VIDEO_DISCUSS_SPREAD_ITEM = 0X0108;

    public int videoItemType;

    /**
     * 作者栏
     **/
    public videoDetialBean.DataBean.UserInfoBean videoUserInfo;
    /**作者排行数据**/
   // public PersonRankData rank;
   // public PersonGuardianData guardian;
    /**福标签**/
    public String springFestivalMedal;
    /**
     * 片头文字
     **/
    public ArrayList<String> videoHeadText;
    /**
     * 工具栏
     * 包括视频信息、作者详情、礼物榜
     **/
    public VideoToolItem videoToolItem;
    /**
     * 作者作品推荐栏
     **/
    public ArrayList<VideoAuthorRecommendItem> videoAuthoerRecommendArray;
    /**
     * 视频推荐栏
     **/
    public ArrayList<VideoRecommendItem> videoRecommendArray;
    /**
     * 视频评论头部
     **/
    public VideoCommentHead videoCommentHead;
    /**
     * 视频普通评论
     **/
   // public VideoNormalCommentInfo normalCommentInfo;
    /**
     * 视频推广评论
     **/
   // public VideoSpreadCommentInfo spreadCommentInfo;
    /**
     * 直播提醒数据
     **/
  //  public VideoLiveAdEntity videoLiveAdEntity;
    /**
     * 是否神评
     **/
    public boolean isGodComment = false;
    /**
     * 是否最后一个神评
     **/
    public boolean isEndGodComment = false;
    /**
     * 是否最后一个评论
     **/
    public boolean isEndComment = false;
    /***
     * 是否加载了中部广告栏
     ***/
    public boolean isLoadAdver = false;
    /**
     * 是否有直播提醒**/
    public boolean isShowVideoLiveAd = false;

    public static class VideoToolItem {
        public boolean isClass;
        public String videoTitle;
        public long publishTime;
        public String author;
        public String gameName;
        public String videoDesc;
        public int videoLookTimes;
        public ArrayList<ButtonIcon> buttonIcon;
        //public VideoGiftListEntity videoGiftListEntity;
//        public ArrayList<VideoToolEntity> videoToolEntityArrayList = new ArrayList<VideoToolEntity>();
    }

    public static class VideoCommentHead {
        public int commentNum;
    }


}
