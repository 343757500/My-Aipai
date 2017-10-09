package mymap.my_aipai.adapter;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

import mymap.my_aipai.base.BaseAdapterRV;
import mymap.my_aipai.base.BaseHolderRV;
import mymap.my_aipai.bean.HomePageDataEntity;
import mymap.my_aipai.bean.pageData;
import mymap.my_aipai.holder.HomeHeaderHolder;
import mymap.my_aipai.holder.HomeShopHolder;

/**
 * Created by Administrator on 2017/9/26.
 */

public class HomeAdapter extends BaseAdapterRV<String> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_SHOP_LIST = 1;
    private static final int TYPE_AD = 2;


    public HomeAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<String> createViewHolder(Context context, ViewGroup parent, int viewType) {

       /* if (viewType == TYPE_HEADER) {      // 显示头部的Holder
            return new HomeHeaderHolder(context, parent, this, viewType);
        }*/

     /*   if (viewType==TYPE_SHOP_LIST){
            return new HomeShopHolder(context, parent, this, viewType);
        }*/
        /*return new HomeHolder(context, parent, this, viewType);*/
        return new HomeHeaderHolder(context, parent, this, viewType);

    }


    @Override
    public int getItemViewType(int position) {
        Object obj = getItem(position);

        if (obj instanceof pageData) {                      // 头部item
            return TYPE_HEADER;
        }


        return TYPE_SHOP_LIST;
    }
}
