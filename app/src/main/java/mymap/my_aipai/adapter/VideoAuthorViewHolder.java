package mymap.my_aipai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import mymap.my_aipai.R;

/**
 * Created by Administrator on 2017/10/9.
 */

public class VideoAuthorViewHolder extends RecyclerView.ViewHolder {

    public VideoAuthorViewHolder(Context context,ViewGroup parent) {
        super(LayoutInflater.from(context).inflate(R.layout.item_video_detail_author, parent, false));
    }
}
