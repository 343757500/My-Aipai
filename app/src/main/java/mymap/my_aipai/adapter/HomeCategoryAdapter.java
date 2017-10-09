package mymap.my_aipai.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import mymap.my_aipai.R;
import mymap.my_aipai.bean.pageData;


/**
 * @author WJQ
 */
public class HomeCategoryAdapter extends RecyclerView.Adapter<HomeCategoryAdapter.MyViewHolder>{
    private Context context;
    private  pageData home;

    public HomeCategoryAdapter(Context context,pageData home){
        this.context=context;
        this.home=home;
        Log.e("hei","11");
    }


    @Override
    public HomeCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.index_video_item_game_video, null,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeCategoryAdapter.MyViewHolder holder, int position) {
        pageData.DataBean.VideoZoneListBean videoZoneListBean = home.getData().getVideoZoneList().get(position);
        holder.tv.setText(videoZoneListBean.getTitle());
        holder.ryv_game_video.setLayoutManager(new GridLayoutManager(context, 2));
        HomeCategoryDeticalAdapter homeCategoryDeticalAdapter=new HomeCategoryDeticalAdapter(context,videoZoneListBean);
        holder.ryv_game_video.setAdapter(homeCategoryDeticalAdapter);
    }

    @Override
    public int getItemCount() {
        return home.getData().getVideoZoneList().size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        private  RecyclerView ryv_game_video;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_title);
            ryv_game_video = (RecyclerView) view.findViewById(R.id.ryv_game_video);
        }
    }
}
