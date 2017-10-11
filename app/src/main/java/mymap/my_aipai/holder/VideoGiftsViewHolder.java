package mymap.my_aipai.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import mymap.my_aipai.R;

/**
 * Created by Administrator on 2017/10/9.
 */

public class VideoGiftsViewHolder extends RecyclerView.ViewHolder {

    public VideoGiftsViewHolder(Context context,ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_video_detail_gifts,parent, false));
    }
}
