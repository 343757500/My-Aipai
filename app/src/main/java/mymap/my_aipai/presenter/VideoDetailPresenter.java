package mymap.my_aipai.presenter;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import io.vov.vitamio.Vitamio;
import mymap.my_aipai.ServerAPI;
import mymap.my_aipai.bean.VideoDetailInfo;
import mymap.my_aipai.bean.videoDetialBean;
import mymap.my_aipai.payler.ButtonIcon;
import mymap.my_aipai.payler.IVideoDetailView;
import mymap.my_aipai.payler.VideoAuthorRecommendItem;
import mymap.my_aipai.payler.VideoDetailDirectEntity;
import mymap.my_aipai.payler.VideoDetailEntity;
import mymap.my_aipai.payler.VideoDetailNetEntity;
import mymap.my_aipai.payler.VideoGiftListEntity;
import mymap.my_aipai.payler.VideoRecommendItem;
import mymap.my_aipai.utils.CLog;
import mymap.my_aipai.utils.GsonUtils;
import mymap.my_aipai.utils.StringUtils;
import mymap.my_aipai.views.IView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/9.
 */

public class VideoDetailPresenter implements IPresenter {
    private IVideoDetailView iVideoDetailView;
    private int totalCount;
    /**
     * 礼物榜赞助商数据
     **/
    private VideoGiftListEntity videoGiftListEntity;

    /**
     * 视频推荐等数据
     **/
    private VideoDetailNetEntity videoDetailNetOtherEntity;

    /**
     * 礼物榜赞助商数据
     **/
   // private VideoGiftListEntity videoGiftListEntity;
    /**
     * 视频评论数据
     **/
    private ArrayList<VideoDetailEntity> videoDetailCommentArray;

    private static int MAX_RECOMMEND = 20;
    /**
     * 视频瞬时数据
     **/
    private VideoDetailDirectEntity videoDetailDirectEntity;
    /**
     * 视频作者推荐视频数据
     **/
    private ArrayList<VideoAuthorRecommendItem> videoAuthorRecommendItemDataList=new ArrayList<>();
    /**
     * 视频主接口数据
     **/
    private VideoDetailNetEntity videoDetailNetEntity;
    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void setView(IView iView) {
        this.iVideoDetailView = (IVideoDetailView) iView;
    }

    /**
     * 视频主接口
     *
     * @param videoDetailInfo
     */
    public void getVideoDetailInfo(videoDetialBean.DataBean videoDetailInfo) {
        videoDetailNetEntity = new VideoDetailNetEntity();
        videoDetailNetEntity.videoDetailInfo = videoDetailInfo;
        iVideoDetailView.getVideoInfo(videoDetailNetEntity);
        buildUpData();
    }

    private void buildUpData() {
        /****
         * 手动生成列表信息
         */
        ArrayList<VideoDetailEntity> videoDetailEntityArray1 = new ArrayList<>();

        VideoDetailEntity videoDetailEntity2 = new VideoDetailEntity();
        videoDetailEntity2.videoItemType = VideoDetailEntity.ITEM_VIDEO_AUTHOR;
        videoDetailEntityArray1.add(videoDetailEntity2);


        VideoDetailEntity videoDetailEntity8 = new VideoDetailEntity();
        videoDetailEntity8.videoItemType = VideoDetailEntity.ITEM_VIDEO_GIFTS;
        videoDetailEntityArray1.add(videoDetailEntity8);

        VideoDetailEntity videoDetailEntity4 = new VideoDetailEntity();
        videoDetailEntity4.videoItemType = VideoDetailEntity.ITEM_VIDEO_ADVER;
        videoDetailEntityArray1.add(videoDetailEntity4);

        VideoDetailEntity videoDetailEntity5 = new VideoDetailEntity();
        videoDetailEntity5.videoItemType = VideoDetailEntity.ITEM_VIDEO_RECOMMEND;
        videoDetailEntityArray1.add(videoDetailEntity5);

        VideoDetailEntity videoDetailEntity6 = new VideoDetailEntity();
        videoDetailEntity6.videoItemType = VideoDetailEntity.ITEM_VIDEO_LIVE;
        videoDetailEntityArray1.add(videoDetailEntity6);

        iVideoDetailView.getVideoInfoSuccess(videoDetailEntityArray1, totalCount);

     /*if (!isFirstPage) {
            iVideoDetailView.getCommentSecondPageSuccess(videoDetailCommentArray, totalCount);
            return;
        }*/
        //+videoDetailNetOtherEntity.toString()+videoDetailDirectEntity.toString()+videoDetailCommentArray.toString()+videoAuthorRecommendItemDataList.toString()+videoGiftListEntity.toString()
     Log.e("hei",videoDetailNetEntity.toString());

       // Log.e("hei",videoDetailDirectEntity.toString());
       // Log.e("hei",videoDetailCommentArray.toString());
        Log.e("hei",videoAuthorRecommendItemDataList.toString());
//        Log.e("hei",videoGiftListEntity.toString());
        if (videoDetailNetEntity == null
                || videoDetailNetOtherEntity == null
                || videoDetailDirectEntity == null
                || videoDetailCommentArray == null
                || videoAuthorRecommendItemDataList == null
                || videoGiftListEntity == null) {
            return;
        }

        videoDetailNetEntity.videoHeadText = videoDetailNetOtherEntity.videoHeadText;
        videoDetailNetEntity.buttonIcon = videoDetailNetOtherEntity.buttonIcon;
        videoDetailNetEntity.recommendData = videoDetailNetOtherEntity.recommendData;

        //同步实时数据到静态数据：
        if (videoDetailNetEntity.videoDetailInfo != null) {
            videoDetialBean.DataBean.UserInfoBean userInfo = videoDetailNetEntity.videoDetailInfo.getUserInfo();
            if (userInfo != null) {
               // userInfo.setIsFans(videoDetailDirectEntity.isFans ? 1 : 0);
                userInfo.setFansCount(videoDetailDirectEntity.fansCount);
            }
        }


        if (videoDetailNetEntity.buttonIcon != null && videoDetailNetEntity.buttonIcon.size() > 0) {
            for (ButtonIcon buttonIcon : videoDetailNetEntity.buttonIcon) {
                if (buttonIcon.type == ButtonIcon.FLOWER) {
                    buttonIcon.total = StringUtils.parseDouble(videoDetailDirectEntity.flower, 0);
                }
                if (buttonIcon.type == ButtonIcon.REWARD) {
                    buttonIcon.total = StringUtils.parseDouble(videoDetailDirectEntity.rewardNew, 0);
                }
                if (buttonIcon.type == ButtonIcon.GIFT) {
                    buttonIcon.total = StringUtils.parseDouble(videoDetailDirectEntity.giftNew, 0);
                }
                if (buttonIcon.type == ButtonIcon.SHARE) {
                    buttonIcon.total = StringUtils.parseDouble(videoDetailDirectEntity.totalShareNum, 0);
                }
            }
        }


        /****
         * 手动生成列表信息
         */
        ArrayList<VideoDetailEntity> videoDetailEntityArray = new ArrayList<>();

        //用户信息
        VideoDetailEntity generateData = generateUserInfoData(videoDetailNetEntity, videoDetailDirectEntity);

        if (generateData != null) {
            videoDetailEntityArray.add(generateData);
        }
        //工具信息
        generateData = generateToolsData(videoDetailNetEntity);

        if (generateData != null) {
            videoDetailEntityArray.add(generateData);
        }
        if (videoAuthorRecommendItemDataList != null && videoAuthorRecommendItemDataList.size() >= 2) {//播放页作者更多作品
            VideoDetailEntity videoDetailEntity3 = new VideoDetailEntity();
            videoDetailEntity3.videoItemType = VideoDetailEntity.ITEM_VIDEO_AUTHOR_RECOMMEND;
            videoDetailEntity3.videoAuthoerRecommendArray = videoAuthorRecommendItemDataList;
            videoDetailEntityArray.add(videoDetailEntity3);
        }

        //推荐信息
        generateData = generateRecommendData(videoDetailNetEntity);
        Log.e("hei","22");
        if (generateData != null) {
            videoDetailEntityArray.add(generateData);
        }

        videoDetailEntityArray.addAll(videoDetailCommentArray);

        iVideoDetailView.getVideoInfoSuccess(videoDetailEntityArray, totalCount);

        videoDetailNetEntity = null;
        videoDetailNetOtherEntity = null;
        videoDetailDirectEntity = null;
        videoDetailCommentArray = null;
        videoAuthorRecommendItemDataList = null;
        //videoGiftListEntity = null;
    }



    private VideoDetailEntity generateUserInfoData(VideoDetailNetEntity entity, VideoDetailDirectEntity videoDetailDirectEntity) {
        try {
            VideoDetailEntity videoDetailEntity1 = new VideoDetailEntity();
            videoDetailEntity1.videoItemType = VideoDetailEntity.ITEM_VIDEO_AUTHOR;
            videoDetailEntity1.videoUserInfo = entity.videoDetailInfo.getUserInfo();
            videoDetailEntity1.videoHeadText = entity.videoHeadText;
           // videoDetailEntity1.rank = videoDetailDirectEntity.rank;
          //  videoDetailEntity1.guardian = videoDetailDirectEntity.guardian;
            videoDetailEntity1.springFestivalMedal = videoDetailDirectEntity.springFestivalMedal;
            return videoDetailEntity1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private VideoDetailEntity generateToolsData(VideoDetailNetEntity entity) {
        try {
            videoDetialBean.DataBean.AssetInfoBean assetInfo = entity.videoDetailInfo.getAssetInfo();
            videoDetialBean.DataBean.UserInfoBean userInfo = entity.videoDetailInfo.getUserInfo();

            VideoDetailEntity videoDetailEntity2 = new VideoDetailEntity();
            videoDetailEntity2.videoItemType = VideoDetailEntity.ITEM_VIDEO_GIFTS;
            videoDetailEntity2.videoToolItem = new VideoDetailEntity.VideoToolItem();
            videoDetailEntity2.videoToolItem.buttonIcon = entity.buttonIcon;

            videoDetailEntity2.videoToolItem.videoTitle = assetInfo.getTitle();
            videoDetailEntity2.videoToolItem.author = userInfo.getNickname();
            videoDetailEntity2.videoToolItem.publishTime = assetInfo.getSaveTime();
            videoDetailEntity2.videoToolItem.videoDesc = assetInfo.getAdwords();
            if (assetInfo.getIsClass() == 1) {
                videoDetailEntity2.videoToolItem.isClass = true;
            } else {
                videoDetailEntity2.videoToolItem.isClass = false;
            }
            /**礼物榜数据**/
            //videoDetailEntity2.videoToolItem.videoGiftListEntity = videoGiftListEntity;

            videoDetailEntity2.videoToolItem.gameName = assetInfo.getGame();


            videoDetailEntity2.videoToolItem.videoDesc = assetInfo.getAdwords();
            videoDetailEntity2.videoToolItem.videoLookTimes = assetInfo.getClick();
            return videoDetailEntity2;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    private VideoDetailEntity generateRecommendData(VideoDetailNetEntity entity) {
        Log.e("hei","22");
        if (entity.recommendData.videoData.recommendData != null && entity.recommendData.videoData.recommendData.size() > 0) {
            VideoDetailEntity videoDetailEntity4 = new VideoDetailEntity();
            videoDetailEntity4.videoItemType = VideoDetailEntity.ITEM_VIDEO_RECOMMEND;
            videoDetailEntity4.videoRecommendArray = new ArrayList<>();
            /***最多只加20个数据***/
            for (int i = 0; i < entity.recommendData.videoData.recommendData.size() && i < MAX_RECOMMEND; i++) {
                videoDetailEntity4.videoRecommendArray.add(entity.recommendData.videoData.recommendData.get(i));
            }

            if (videoDetailEntity4.videoRecommendArray.size() >= MAX_RECOMMEND) {
                VideoRecommendItem videoRecommendItem = new VideoRecommendItem();
                videoRecommendItem.showMore = true;
                videoDetailEntity4.videoRecommendArray.add(videoRecommendItem);
            }
            return videoDetailEntity4;
        }
        return null;
    }


    public void getVideoGiftListEntity(String videoId, VideoGiftListEntity entity) {
        if (entity != null) {
            videoGiftListEntity = entity;
            buildUpData();
        } else {
            videoGiftListEntity = null;
            getGiftListData(videoId, true);
        }
    }




    public void checkVideoIsCollect(String videoId) {
       /* if (iAccountManager.isLogined()) {
            final int bid = StringUtils.parseToInt(iAccountManager.getAccountBid(), 0);
            HttpRequestModule.checkVideoCollection(videoId, bid, new HttpRequestModule.DynamicAddVideoCollectionHandler() {
                @Override
                public void onSuccess(boolean isCollected, String paiListId) {
                    iVideoDetailView.changeCollectionStatus(isCollected);
                }
            });
        }*/
    }



    /**
     * 旧功能
     * 获取评论
     *
     * @param videoId
     * @param isFirst
     */
    public void requestComment(String videoId, boolean isFirst) {
        //fetcher.setFirst(isFirst);
 /*       if (isFirst) {
            String baseUrl = "http://www.aipai.com/api/aipaiApp.php?action=getCommentNew&mobile=1&type=2&spread=0&cid=" + videoId;
            baseUrl = changeUrlToStaticUrl(baseUrl);
            fetcher.setBaseUrl(baseUrl);
            fetcher.fetch(true);
        } else {
            AipaiStatsManager.reportClickEvent(AipaiStatsConstants.PLAYER_COMMENT_MORE);
            fetcher.more(true);
        }
*/


        final String url = "http://www.aipai.com/api/aipaiApp.php?action=getCommentNew&mobile=1&type=2&spread=0&cid=" + videoId;
        // 2. 采用okhttp访问网络
        //2.1 构建一个okhttpClient
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient=new OkHttpClient();
                //2.2 准备一个request请求
                Request request=new Request.Builder().url(url).build();
                //2.3 执行请求
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()) {

                        String result = response.body().string();
                        if (!TextUtils.isEmpty(result)) {
                           /* VideoAuthorRecommendItem videoAuthorRecommendItem = new Gson().fromJson(result, VideoAuthorRecommendItem.class);
                            videoAuthorRecommendItemDataList.add(videoAuthorRecommendItem);*/
                            buildUpData();
                            Log.e("hei","555");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }







    /**
     * 视频作者推荐视频数据
     *
     * @param authorId 作者bid
     * @param videoId  当前视频作品id
     */
    public void getVideoAuthorRecommendData(String authorId, String videoId) {
       /* IRequestParams params = AsyncNetClient.createParams();
        final String url = "http://m.aipai.com/mobile/apps/apps_module-auxplayer_func-userAsset_os-1_sort-id_bid-" + authorId + "_page-1.html";
        AsyncNetClient.get(url, params, new JsonResponseHandle() {
            @Override
            public void onSuccess(JSONObject jsonObject) {
                CLog.trace();
                videoAuthorRecommendItemDataList = new ArrayList<>();
                if (jsonObject != null) {
                    if (jsonObject.optInt("code") == 0) {
                        Gson gson = GsonUtils.getGson();
                        Type type = new TypeToken<ArrayList<VideoAuthorRecommendItem>>() {
                        }.getType();
                        ArrayList<VideoAuthorRecommendItem> dataList = gson.fromJson(jsonObject.optJSONArray("data").toString(), type);
                        if (dataList != null) {
                            for (int i = 0; i < dataList.size(); i++) {//如果与当前视频相同则不显示在列表中
                                if (videoId.equals(dataList.get(i).id)) {
                                    dataList.remove(i);
                                }
                            }
                            videoAuthorRecommendItemDataList = dataList;
                            buildUpData();

                        }
                    }
                }
            }

            @Override
            public void onFailure(int i, String s) {
                iVideoDetailView.getVideoInfoFail();
                CLog.trace();
            }
        });*/

        final String url = "http://m.aipai.com/mobile/apps/apps_module-auxplayer_func-userAsset_os-1_sort-id_bid-" + authorId + "_page-1.html";
        // 2. 采用okhttp访问网络
        //2.1 构建一个okhttpClient
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient=new OkHttpClient();
                //2.2 准备一个request请求
                Request request=new Request.Builder().url(url).build();
                //2.3 执行请求
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()) {

                        String result = response.body().string();
                        if (!TextUtils.isEmpty(result)) {
                            VideoAuthorRecommendItem videoAuthorRecommendItem = new Gson().fromJson(result, VideoAuthorRecommendItem.class);
                            videoAuthorRecommendItemDataList.add(videoAuthorRecommendItem);
                            buildUpData();
                            Log.e("hei","555");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }



    /**
     * 获取瞬时数据
     * 如送花打赏送礼数量
     *
     * @param videoId
     */
    public void getVideoDetailDirectData(String videoId) {
        /*videoRepository.getPlayerDetailDirectData(videoId, new AsyncCallBackAdapter<VideoDetailDirectEntity>() {
            @Override
            public void onSuccess(VideoDetailDirectEntity entity) {
                videoDetailDirectEntity = entity;
                buildUpData();
            }

            @Override
            public void onFailure(int code, String message) {
                iVideoDetailView.getVideoInfoFail();
                CLog.e("VIdeoDetailPresenter", "code = " + code + " message= " + message);
            }
        });*/
        final String url = String.format(ServerAPI.PLAYER_DETAIL_OTHER_DATA, videoId);
        // 2. 采用okhttp访问网络
        //2.1 构建一个okhttpClient
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient=new OkHttpClient();
                //2.2 准备一个request请求
                Request request=new Request.Builder().url(url).build();
                //2.3 执行请求
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()) {

                        String result = response.body().string();
                        if (!TextUtils.isEmpty(result)) {
                            videoDetailDirectEntity = new Gson().fromJson(result, VideoDetailDirectEntity.class);
                            buildUpData();
                            Log.e("hei","555");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }


    /**
     * 获取推荐视频等数据
     *
     * @param videoId
     */
    public void getVideoDetailOtherData(String videoId) {
       /* videoRepository.getPlayerDetailOtherInfo(videoId, new AsyncCallBackAdapter<VideoDetailNetEntity>() {
            @Override
            public void onSuccess(VideoDetailNetEntity entity) {
                videoDetailNetOtherEntity = entity;
                buildUpData();
            }

            @Override
            public void onFailure(int code, String message) {
                iVideoDetailView.getVideoInfoFail();
                CLog.e("VIdeoDetailPresenter", "code = " + code + " message= " + message);
            }
        });*/

        final String url = String.format(ServerAPI.PLAYER_DETAIL_OTHER_DATA, videoId);
        // 2. 采用okhttp访问网络
        //2.1 构建一个okhttpClient
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient=new OkHttpClient();
                //2.2 准备一个request请求
                Request request=new Request.Builder().url(url).build();
                //2.3 执行请求
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()) {

                        String result = response.body().string();
                        if (!TextUtils.isEmpty(result)) {
                            videoDetailNetOtherEntity = new Gson().fromJson(result, VideoDetailNetEntity.class);
                            buildUpData();
                            Log.e("hei","555");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }




    /**
     * 获取榜单数据
     *
     * @param videoId
     * @param isFirst 是否第一次请求数据
     */
    public void getGiftListData(final String videoId, boolean isFirst) {
        final String url = String.format(ServerAPI.GET_VIDEO_INFO, videoId);


     /*   VideoInfoHttpModule.requestVideoSponsorInfo(videoId, !isFirst, isFirst, new VideoInfoHttpModule.IGetVideoSponsorInfoCallback() {
            @Override
            public void onSuccess(VideoGiftListEntity listEntity) {
                if (isFirst) {
                    videoGiftListEntity = listEntity;
                    buildUpData();
                } else {
                    iVideoDetailView.getGiftsListSuccess(listEntity);
                }
            }

            @Override
            public void onFailure(int code, String msg) {
                iVideoDetailView.getVideoInfoFail();
            }
        });*/

        // 2. 采用okhttp访问网络
        //2.1 构建一个okhttpClient
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient=new OkHttpClient();
                //2.2 准备一个request请求
                Request request=new Request.Builder().url(url).build();
                //2.3 执行请求
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()) {

                        String result = response.body().string();
                        if (!TextUtils.isEmpty(result)) {
                            videoGiftListEntity = new Gson().fromJson(result, VideoGiftListEntity.class);
                            buildUpData();
                            Log.e("hei","555");
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
