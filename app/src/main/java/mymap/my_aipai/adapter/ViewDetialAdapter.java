package mymap.my_aipai.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import mymap.my_aipai.R;
import mymap.my_aipai.holder.VideoGiftsViewHolder;
import mymap.my_aipai.payler.VideoDetailEntity;
import mymap.my_aipai.utils.CLog;

/**
 * Created by Administrator on 2017/10/9.
 */

public class ViewDetialAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<VideoDetailEntity> entityList = new ArrayList<>();

    public ViewDetialAdapter(Context context,ArrayList<VideoDetailEntity> entityList){
        this.context=context;
        this.entityList=entityList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VideoDetailEntity.ITEM_VIDEO_AUTHOR: {
                return new VideoAuthorViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_GIFTS: {
                return new VideoGiftsViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_ADVER: {
                //return new VideoAdverViewHolder(activity, parent);
                return new VideoGiftsViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_AUTHOR_RECOMMEND: {
                //return new VideoAuthorRecommendViewHolder(activity, parent);
                return new VideoGiftsViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_RECOMMEND: {
               // return new VideoRecommendViewHolder(activity, parent);
                return new VideoGiftsViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_LIVE: {
                //return new VideoLiveViewHolder(activity, parent);
                return new VideoGiftsViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_DISCUSS_HEAD: {
                //return new VideoDiscussHeadViewHolder(activity, parent);
                return new VideoGiftsViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_DISCUSS_ITEM: {
                //return new VideoDiscussItemViewHolder(activity, parent);
                return new VideoGiftsViewHolder(context, parent);
            }
            case VideoDetailEntity.ITEM_VIDEO_DISCUSS_SPREAD_ITEM: {
                //return new VideoDiscussSpreadItemViewHolder(activity, parent);

                return new VideoGiftsViewHolder(context, parent);
            }
            default:
                CLog.trace("!@!@!@!@!@onCreateViewHolder");
                return new VideoAuthorViewHolder(context, parent);
        }
       /* return new VideoGiftsViewHolder(context, parent);*/
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }






    @Override
    public int getItemCount() {
    return  entityList.size() ;
    }



    @Override
    public int getItemViewType(int position) {
        return entityList.get(position).videoItemType;
    }

}
