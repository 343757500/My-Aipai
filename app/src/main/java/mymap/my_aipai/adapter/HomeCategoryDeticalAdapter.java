package mymap.my_aipai.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.xutils.x;

import de.hdodenhof.circleimageview.CircleImageView;
import mymap.my_aipai.R;
import mymap.my_aipai.activity.VideoDetialActivity;
import mymap.my_aipai.bean.pageData;


/**
 * @author WJQ
 */
public class HomeCategoryDeticalAdapter extends RecyclerView.Adapter<HomeCategoryDeticalAdapter.MyViewHolder>{
    private Context context;
    private   pageData.DataBean.VideoZoneListBean videoZoneListBean;
    private static final int RECOCDER_TAG = 1;//录播视频tag
    private static final int LIVE_TAG = 2;//直播视频tag

    public HomeCategoryDeticalAdapter(Context context, pageData.DataBean.VideoZoneListBean videoZoneListBean){
        this.context=context;
        this.videoZoneListBean=videoZoneListBean;
        Log.e("hei","11");
    }


    @Override
    public HomeCategoryDeticalAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.index_common_video, null,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeCategoryDeticalAdapter.MyViewHolder holder, int position) {
        //x.image().bind(holder.circleImageView,videoZoneListBean.getVideoList().get(position).getVideoEntity().getVideoPic());
         holder.tv_video_title.setText(videoZoneListBean.getVideoList().get(position).getVideoEntity().getTitle());
            x.image().bind(holder.imageViewViedo,videoZoneListBean.getVideoList().get(position).getVideoEntity().getVideoPic());
        pageData.DataBean.VideoZoneListBean.VideoListBeanX.VideoEntityBeanX videoEntity = videoZoneListBean.getVideoList().get(position).getVideoEntity();
            videwHolderOnClick(holder, videoEntity);
    }

    private void videwHolderOnClick(HomeCategoryDeticalAdapter.MyViewHolder holder, final pageData.DataBean.VideoZoneListBean.VideoListBeanX.VideoEntityBeanX videoEntity) {
        holder.ll_root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoEntity!=null&&videoZoneListBean!=null){
                    int type = videoEntity.getType();
                   switch (type){
                       case RECOCDER_TAG:
                           Intent intent=new Intent(context, VideoDetialActivity.class);
                           intent.putExtra("id",videoEntity.getId()+"");
                           context.startActivity(intent);
                           break;
                       case LIVE_TAG:

                           break;
                   }
                }

            }
        });

        holder.tv_video_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoEntity!=null&&videoEntity.getTitle()!=null){

                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return videoZoneListBean.getVideoList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final CircleImageView circleImageView;
        private final TextView tv_video_title;
        private final ImageView imageViewViedo;
        private final LinearLayout ll_root;

        public MyViewHolder(View view) {
            super(view);
            circleImageView = (CircleImageView) view.findViewById(R.id.iv_user_icon);
            tv_video_title = (TextView) view.findViewById(R.id.tv_video_title);
            imageViewViedo = (ImageView) view.findViewById(R.id.iv_video);
            ll_root = (LinearLayout) view.findViewById(R.id.ll_root);
        }
    }
}
