package mymap.my_aipai.payler;



import java.util.ArrayList;

import mymap.my_aipai.views.IView;

/**
 * Created by Veigar on 16/8/1.
 */
public interface IVideoDetailView extends IView {
    void getVideoInfo(VideoDetailNetEntity entity);
   /* void showToast(String toastStr);
    void goToLogin(int requestCode);
    void addIdolSuccess();
    void cancelIdolSuccess();
    void doCommentSuccess();
//    void getVideoInfoSuccess(ArrayList<VideoDetailEntity> videoDetailList,VideoDetailNetEntity entity);
    void getVideoInfoSuccess(ArrayList<VideoDetailEntity> videoDetailList, int commentTotal);
    void getCommentSecondPageSuccess(ArrayList<VideoDetailEntity> videoDetailList, int commentTotal);
    void getVideoInfoFail();
    void getCommentSecondPageFail();
    void changeCollectionStatus(boolean isCollectAction);
    void doPraiseSuccess(CommentPraiseRequest commentPraiseRequest);
    void doPraiseFail();
    void reportSuccess();
    void reportFail();
    void backShowGiftToPlayer(List<PlayerShowGiftEntity> showGiftEntity);
    void showWorldBanner(WorldBannerEntity worldBannerEntity);
    void getGiftsListSuccess(VideoGiftListEntity videoGiftListEntity);
    void showSpringFestivalRedPacketDialog(CommonRedPacketEntity entity);
    void getVideoLiveAdSuccess(VideoLiveAdEntity videoLiveAdEntity);*/

    void getVideoInfoSuccess(ArrayList<VideoDetailEntity> videoDetailList, int commentTotal);
}
