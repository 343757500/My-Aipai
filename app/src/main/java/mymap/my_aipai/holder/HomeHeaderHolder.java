package mymap.my_aipai.holder;

import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

import mymap.my_aipai.R;
import mymap.my_aipai.adapter.HomeCategoryAdapter;
import mymap.my_aipai.base.BaseAdapterRV;
import mymap.my_aipai.base.BaseHolderRV;
import mymap.my_aipai.base.Global;
import mymap.my_aipai.bean.pageData;
import mymap.my_aipai.utils.Utils;


/**
 * 列表头部显示：轮播图，促销类型，热榜数据ViewFlipper
 *
 * @author WJQ
 */
public class HomeHeaderHolder extends BaseHolderRV {

    private SliderLayout sliderLayout;
    private RecyclerView recyclerView02;
    //private ViewFlipper viewFlipper;
    private HomeCategoryAdapter gridAdapter;
    private pageData home;
    private MarqueeView marqueeView;

    public HomeHeaderHolder(Context context, ViewGroup parent,
                            BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_header);
    }

    @Override
    public void onFindViews(View itemView) {
        sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider_layout);
        //viewFlipper = (ViewFlipper) itemView.findViewById(R.id.view_flipper);
        marqueeView = (MarqueeView) itemView.findViewById(R.id.marqueeView);
        recyclerView02 = (RecyclerView) itemView.findViewById(R.id.recycler_view_02);
        // 轮播图

     /*   // 促销类型
        recyclerView02.setLayoutManager(new GridLayoutManager(
                context, 2, GridLayoutManager.HORIZONTAL, false));*/


     /*   // 热榜数据ViewFlipper
        viewFlipper.setInAnimation(AnimationUtils.loadAnimation(context,
                R.anim.push_up_in));
        viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(context,
                R.anim.push_up_out));
        viewFlipper.startFlipping();  // 开始执行动画*/
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        home = (pageData) bean;

//        private List<HotSaleListBean> hotSaleList;
//        private List<PromotionListBean> promotionList;
//        private List<PromotionTypesBean> promotionTypes;
        recyclerView02.setLayoutManager(new LinearLayoutManager(context));
        gridAdapter = new HomeCategoryAdapter(context, home);
        recyclerView02.setAdapter(gridAdapter);
        // 轮播图
        initLooperImage(home.getData().getFocusPicList());

        // 显示促销类型
       // gridAdapter.setDatas(home.getPromotionTypes());

        // 显示热榜数据ViewFlipper
        showViewFlipper(home.getData().getOperationData().getDataList());
    }

    /**
     * 显示热榜数据
     * @param hotSaleList
     */
    private void showViewFlipper(List<pageData.DataBean.OperationDataBean.DataListBean> hotSaleList) {
       // viewFlipper.removeAllViews();
        List<String> info = new ArrayList<>();
       for (pageData.DataBean.OperationDataBean.DataListBean bean : hotSaleList) {
           info.add(bean.getTitle());
        }

        marqueeView.startWithList(info);

// 在代码里设置自己的动画
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);
    }

    /** 显示轮播图*/
    private void initLooperImage(List<pageData.DataBean.FocusPicListBean> promotionList) {
        // 选删除之前的选项
        sliderLayout.removeAllSliders();
        for (final pageData.DataBean.FocusPicListBean bean : promotionList) {
            TextSliderView textSliderView = new TextSliderView(context);
            // 修正ip地址
            String imageUrl = Utils.replaceIp(bean.getImg());
            textSliderView.description(bean.getImg()).image(imageUrl);
            // 设置子界面的点击事件
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                  //  Global.showToast("111" );
                    Toast.makeText(context,bean.getImg(),Toast.LENGTH_SHORT).show();
                }
            });
            // 添加一个子界面
            sliderLayout.addSlider(textSliderView);
        }
    }

}
