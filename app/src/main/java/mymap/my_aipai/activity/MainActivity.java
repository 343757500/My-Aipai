package mymap.my_aipai.activity;

import android.app.LocalActivityManager;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;

import mymap.my_aipai.R;
import mymap.my_aipai.base.FragmentActivityGroup;

public class MainActivity extends FragmentActivityGroup implements View.OnClickListener {

    /********
     * 主页Tab的tag
     *******/
    public static final String TABSPEC_HOT = "tab_hot";
    public static final String TABSPEC_ZHUBO = "tab_zhubo";
    public static final String TABSPEC_SEARCH = "tab_search";
    public static final String TABSPEC_MINE = "tab_mine";
    public static final String TABSPEC_DYNAMIC = "tab_dynamic";

    private TabHost mTabHost;

    private RelativeLayout mRlTabIm;
    private TextView ctvDynamic;
    private TextView ctvDiscover;
    private TextView ctvShow;
    private TextView ctvIM;
    private TextView ctvMine;
    private TextView tvImUnreadCount;
    public View newUserGiftRedPoint;

    private View dynamicCircleRedPoint;

    /********
     * 主页Tab的index
     *******/
    public static final int MAIN_DISCOVER_INDEX = 0;    //  发现
    public static final int MAIN_DYNAMIC_INDEX = 1;     //  动态
    public static final int MAIN_SHOW_INDEX = 2;//重点榜单
    public static final int MAIN_IM_INDEX = 3;          //  融云
    public static final int MAIN_MINE_INDEX = 4;        //  我的


    public static final int MAIN_INDEX = 0;
    private int currentTab = MAIN_INDEX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(savedInstanceState);

        setUpListener();
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
       // CLog.trace("onSaveInstanceState");
        outState.putInt("currentTab", mTabHost.getCurrentTab());
    }

    private void initView(Bundle savedInstanceState) {
        mRlTabIm = (RelativeLayout) findViewById(R.id.rl_tab_im);
        tvImUnreadCount = (TextView) findViewById(R.id.tv_unread_count);
        ctvDynamic = (TextView) findViewById(R.id.check_dynamic);
        ctvDiscover = (TextView) findViewById(R.id.check_discover);
        ctvShow = (TextView) findViewById(R.id.check_center_list);
        ctvIM = (TextView) findViewById(R.id.check_im);
        ctvMine = (TextView) findViewById(R.id.check_mine);
        mTabHost = (TabHost) findViewById(android.R.id.tabhost);
        newUserGiftRedPoint = findViewById(R.id.iv_new_gift_red_point);
        mTabHost.setup(getLocalActivityManager());

        dynamicCircleRedPoint = findViewById(R.id.iv_red_point);
        dynamicCircleRedPoint.setVisibility(View.GONE);

        Intent HomePageIntent = new Intent(this, HomePageActivity.class);
        Intent dynamicIntent = new Intent(this, DynamicActivity.class);
        Intent centreHtoRankIntent = new Intent(this, CentreRankActivity.class);
        Intent imMainIntent = new Intent(this, ImMainActivity.class);
        Intent zoneMineIntent = new Intent(this, ZoneMineActivity.class);


        mTabHost.addTab(mTabHost.newTabSpec(TABSPEC_HOT).setIndicator(TABSPEC_HOT).setContent(HomePageIntent));// App首页
        mTabHost.addTab(mTabHost.newTabSpec(TABSPEC_DYNAMIC).setIndicator(TABSPEC_DYNAMIC).setContent(dynamicIntent));//动态
        mTabHost.addTab(mTabHost.newTabSpec(TABSPEC_ZHUBO).setIndicator(TABSPEC_ZHUBO).setContent(centreHtoRankIntent));// //中间榜单
        mTabHost.addTab(mTabHost.newTabSpec(TABSPEC_SEARCH).setIndicator(TABSPEC_SEARCH).setContent(imMainIntent));// IM
        mTabHost.addTab(mTabHost.newTabSpec(TABSPEC_MINE).setIndicator(TABSPEC_MINE).setContent(zoneMineIntent));// 我的

        adjustCenterViewWidth();

        if (savedInstanceState != null) {
            setCurrentTab(savedInstanceState.getInt("currentTab"));
            //CLog.trace(savedInstanceState.getInt("currentTab") + "");
        }


        setCurrentTab(MAIN_INDEX);
    }

    private void adjustCenterViewWidth() {
        final View centerView = findViewById(R.id.view_center_anchor);
        centerView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onGlobalLayout() {
                if (centerView.getWidth() > 0) {
                    ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) ctvShow.getLayoutParams();
                    layoutParams.width = centerView.getWidth();
                    ctvShow.setLayoutParams(layoutParams);
                    centerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            }
        });
    }




    public void setCurrentTab(int index) {
        //CLog.trace(index + "");
        if (mTabHost != null) {
            currentTab = index;
            mTabHost.setCurrentTab(index);
            if (index == MAIN_DYNAMIC_INDEX) {
                ctvDynamic.setSelected(true);
                ctvDiscover.setSelected(false);
                ctvShow.setSelected(false);
                ctvIM.setSelected(false);
                ctvMine.setSelected(false);
            } else if (index == MAIN_DISCOVER_INDEX) {
                ctvDiscover.setSelected(true);
                ctvDynamic.setSelected(false);
                ctvShow.setSelected(false);
                ctvIM.setSelected(false);
                ctvMine.setSelected(false);
            } else if (index == MAIN_SHOW_INDEX) {
                ctvShow.setSelected(true);
                ctvDynamic.setSelected(false);
                ctvDiscover.setSelected(false);
                ctvIM.setSelected(false);
                ctvMine.setSelected(false);
            } else if (index == MAIN_IM_INDEX) {
                ctvIM.setSelected(true);
                ctvDynamic.setSelected(false);
                ctvDiscover.setSelected(false);
                ctvShow.setSelected(false);
                ctvMine.setSelected(false);
            } else if (index == MAIN_MINE_INDEX) {
                ctvMine.setSelected(true);
                ctvDynamic.setSelected(false);
                ctvDiscover.setSelected(false);
                ctvShow.setSelected(false);
                ctvIM.setSelected(false);
            }
        }
    }


    private void setUpListener() {
        ctvDynamic.setOnClickListener(this);
        ctvDiscover.setOnClickListener(this);
        ctvShow.setOnClickListener(this);
        mRlTabIm.setOnClickListener(this);
        ctvMine.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int id = v.getId();
        if (id == R.id.ibtn_pc_aipai) {
           // Intent intent = new Intent(this, PCAipaiActivity.class);
           // startActivity(intent);
        } else if (id == R.id.ibtn_more) {
          //  openMoreMenu();
        } else if ((v == ctvDynamic) && (currentTab != MAIN_DYNAMIC_INDEX)) {
            setCurrentTab(MAIN_DYNAMIC_INDEX);
        } else if ((v == ctvDiscover) && (currentTab != MAIN_DISCOVER_INDEX)) {
            setCurrentTab(MAIN_DISCOVER_INDEX);
//        } else if (v == ctvShow || v == paiMasterTipTv) {
        } else if (v == ctvShow && currentTab != MAIN_SHOW_INDEX) {
            //showPaiDashiIfRight();
            setCurrentTab(MAIN_SHOW_INDEX);
        } else if ((v == mRlTabIm) && (currentTab != MAIN_IM_INDEX)) {
           // clearUnreadCountIfNeed();
            setCurrentTab(MAIN_IM_INDEX);
        } else if ((v == ctvMine) && (currentTab != MAIN_MINE_INDEX)) {
            setCurrentTab(MAIN_MINE_INDEX);
          /*  GlobalToolsManger.getCache().set(MINE_RED_POINT_SHOW, false);
            showMineRedPoint();
            AipaiStatsManager.reportClickEvent(AipaiStatsConstants.MAIN_ACTIVITY_LIVE_BROADCAST_CLICK);*/
        }
    }
}
