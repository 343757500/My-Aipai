package mymap.my_aipai.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import mymap.my_aipai.R;
import mymap.my_aipai.ServerAPI;
import mymap.my_aipai.adapter.ViewDetialAdapter;
import mymap.my_aipai.bean.VideoDetailInfo;
import mymap.my_aipai.bean.videoDetialBean;
import mymap.my_aipai.payler.IVideoDetailView;
import mymap.my_aipai.payler.VideoDetailEntity;
import mymap.my_aipai.payler.VideoDetailNetEntity;
import mymap.my_aipai.payler.VideoGiftListEntity;
import mymap.my_aipai.presenter.VideoDetailPresenter;
import mymap.my_aipai.utils.CLog;
import mymap.my_aipai.views.IView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/28.
 */

public class VideoDetialActivity extends FragmentActivity implements IVideoDetailView {
    /***
     * 视频信息
     ***/
    private videoDetialBean.DataBean videoDetailInfo;
    private VideoGiftListEntity giftListEntity;
    private videoDetialBean.DataBean.AssetInfoBean assetInfo;
    private videoDetialBean.DataBean.UserInfoBean authorInfo;

    private VideoDetailPresenter videoDetailPresenter;

    /**
     * 礼物榜赞助商数据
     **/
    private VideoGiftListEntity videoGiftListEntity;



    Handler h = null;
    private RecyclerView recycle;
    private videoDetialBean videoDetialBean;
    private ArrayList<videoDetialBean> videoDetialList=new ArrayList<>();
    /***
     * 列表数据源
     ***/
    private ArrayList<VideoDetailEntity> entityList = new ArrayList<>();
    private ViewDetialAdapter viewDetialAdapter;

    public VideoDetialActivity() {
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        h = new Handler(){
            @Override
            public void handleMessage(Message msg){
                if (msg.what==1) {
                    videoDetialBean videoDetialBean = (videoDetialBean) msg.obj;
                    VideoView videoView = (VideoView) findViewById(R.id.vitamio);
                    Log.e("hei", videoDetialBean.getData().getAssetInfo().getFlv().toString());
                    videoView.setVideoURI(Uri.parse(videoDetialBean.getData().getAssetInfo().getFlv().toString()));

                    MediaController controller = new MediaController(getApplicationContext());
                    videoView.setMediaController(controller);
                    videoView.start();

                    initView();
                    resetAllVideoDetailData(videoDetailInfo, true, false);
                    present();


                }
            }
        };

        setContentView(R.layout.activity_videodetial);




        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Log.e("hei",id);

        final String url = String.format(ServerAPI.GET_VIDEO_INFO, id);


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
                            videoDetialBean = new Gson().fromJson(result, videoDetialBean.class);
                            videoDetailInfo=videoDetialBean.getData();
                            videoDetialList.add(videoDetialBean);
                            if (Vitamio.initialize(getApplicationContext())) {

                                Message message=new Message();
                                message.obj= videoDetialBean;
                                message.what=1;
                                h.sendMessage(message);
                            }
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();





    }

    private void resetAllVideoDetailData(mymap.my_aipai.bean.videoDetialBean.DataBean videoInfo, boolean b, boolean b1) {
        initVideoDetailInfo(videoInfo);//播放信息
    }


    private void initView() {
         videoDetailPresenter=new VideoDetailPresenter();
        recycle = (RecyclerView) findViewById(R.id.recycle);
        VideoView vitamio=(VideoView)findViewById(R.id.vitamio);




    }

    private void present() {
       /* if (videoDetailInfo == null || assetInfo == null) {
            loadingOrFailViewWrapper.showFailView(true);
            return;
        }
        loadingOrFailViewWrapper.showLoadingView(true);*/
        videoDetailPresenter.setView(this);

        String videoId = assetInfo.getId();


        videoDetailPresenter.getVideoDetailInfo(videoDetailInfo);
        videoDetailPresenter.getVideoGiftListEntity(videoId, giftListEntity);
        videoDetailPresenter.getVideoDetailOtherData(videoId);
        videoDetailPresenter.getVideoDetailDirectData(videoId);
        videoDetailPresenter.getVideoAuthorRecommendData(authorInfo.getBid(), videoId);
        videoDetailPresenter.requestComment(videoId, true);
        videoDetailPresenter.checkVideoIsCollect(videoId);

        viewDetialAdapter = new ViewDetialAdapter(getApplicationContext(),entityList);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(viewDetialAdapter);
    }


    @Override
    public void getVideoInfo(VideoDetailNetEntity entity) {

    }

    @Override
    public void getVideoInfoSuccess(ArrayList<VideoDetailEntity> videoDetailList, int commentTotal) {
        entityList.clear();
        entityList.addAll(videoDetailList);
        //isDataEnd = false;
    }

    private void initVideoDetailInfo(videoDetialBean.DataBean info) {
        if (isValidateVideoDetailInfo(info)) {
            this.videoDetailInfo = info;
            assetInfo = videoDetailInfo.getAssetInfo();
            authorInfo = videoDetailInfo.getUserInfo();
            CLog.trace();
           /// VideoPlayDurationStatisticsNew.getInstant().handlerChangeVideo();
        }
    }


    private boolean isValidateVideoDetailInfo(videoDetialBean.DataBean info) {
        //特殊情况下需要刷新视频
//        if (isSpecialNotify) {
//            isSpecialNotify = false;
//            return true;
//        }

        //内容空
        if (info == null || info.getAssetInfo() == null || info.getUserInfo() == null) {
            return false;
        }

        //没有视频id
        if (TextUtils.isEmpty(info.getAssetInfo().getId())) {
            return false;
        }

        //跟当前的视频同一个id
//        if (assetInfo != null && assetInfo.getId().equals(info.getAssetInfo().getId())) {
//            return false;
//        }

        return true;
    }




}
