package mymap.my_aipai.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import mymap.my_aipai.R;
import mymap.my_aipai.ServerAPI;
import mymap.my_aipai.bean.videoDetialBean;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/28.
 */

public class VideoDetialActivity extends Activity {
    Handler h = null;

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
                }
            }
        };

        setContentView(R.layout.activity_videodetial);

        /*if (Vitamio.initialize(this)) {
            VideoView videoView = (VideoView) findViewById(R.id.vitamio);
            videoView.setVideoURI(Uri.parse("http://ghc46.aipai.com//user//150//63932150//1006//card//46881828//card.mp4?l=q"));
            MediaController controller = new MediaController(this);
            videoView.setMediaController(controller);
            videoView.start();
        }*/

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
                            videoDetialBean videoDetialBean = new Gson().fromJson(result, videoDetialBean.class);

                            if (Vitamio.initialize(getApplicationContext())) {

                                Message message=new Message();
                                message.obj=videoDetialBean;
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


/*
        VideoDetialActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });*/


    }
}
