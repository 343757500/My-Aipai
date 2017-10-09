package mymap.my_aipai.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mymap.my_aipai.R;
import mymap.my_aipai.base.BaseAdapterRV;
import mymap.my_aipai.base.BaseHolderRV;
import mymap.my_aipai.bean.HomePageDataEntity;
import mymap.my_aipai.bean.pageData;

/**
 * Created by Administrator on 2017/9/27.
 */

public class HomeShopHolder extends BaseHolderRV {

    private TextView tvTitle;

    public HomeShopHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.index_video_item_game_video);
    }

    @Override
    public void onFindViews(View itemView) {
        tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        HomePageDataEntity home = (HomePageDataEntity) bean;
        tvTitle.setText(home.getData().getVideoZoneList().get(position).getTitle());
    }
}
