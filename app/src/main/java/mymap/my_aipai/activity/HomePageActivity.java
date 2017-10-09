package mymap.my_aipai.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import mymap.my_aipai.R;
import mymap.my_aipai.adapter.TabPagerAdapter;
import mymap.my_aipai.presenter.HomePagePresenter;
import mymap.my_aipai.presenter.homepage.IHomePagePresenter;
import mymap.my_aipai.views.IHomePageView;

/**
 * Created by zsp on 2017/9/20.
 */

public class HomePageActivity extends FragmentActivity implements IHomePageView {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout flContent;
    private View actionBarView;
    private IHomePagePresenter homePagePresenter;
    private TabPagerAdapter adapter;
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        initView();

        homePagePresenter = new HomePagePresenter();
        homePagePresenter.setView(this);
        homePagePresenter.resume();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tl_content);
        flContent = (FrameLayout) findViewById(R.id.fl_vp_content);
        actionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_home_page, null, false);
        initViewPager();

    }

    private void initViewPager() {
        //******新new一个ViewPager**********
        flContent.removeAllViews();
        viewPager = new ViewPager(this);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        flContent.addView(viewPager, params);
        viewPager.setId(R.id.home_page_view_pager);
        //*******************************

        viewPager.setOffscreenPageLimit(getOffscreenPageCount());
      /*  viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout) {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position > 0) {
                    HomePageGameEntity currentGameEntity = homePagePresenter.getCurrentGameEntity(position);
                    AipaiStatsManager.reportClickEvent(String.format(getString(R.string.home_tab_statistics_key),
                            currentGameEntity.getGameType(), currentGameEntity.getGameId()));
                } else {
                    AipaiStatsManager.reportClickEvent(AipaiStatsConstants.HOME_START);
                }
            }
        });*/
    }


    @Override
    protected void onResume() {
        super.onResume();
       /* //((MainActivity) getParent()).setActionBarView(actionBarView);
        homePagePresenter.resume();
        //showGuide();*/

    }

    @Override
    public void updateFragmentList(List<Fragment> fragmentList, List<String> titleList) {
        //CLog.trace(titleList.toString());
       destroyAllViewPagerItem();

        this.titleList.clear();
        this.fragmentList.clear();
        this.titleList.addAll(titleList);
        this.fragmentList.addAll(fragmentList);
        notifyDataChange();

    }

    @Override
    public void setSearchKey(String searchKey) {

    }


    private int getOffscreenPageCount() {
        if (Build.VERSION.SDK_INT > 19) {//20以后缓存4页
            return 3;
        } else if (Build.VERSION.SDK_INT > 17) {//18-19缓存3页
            return 2;
        }

        return 1;//16-17只缓存两页
    }


    private void notifyDataChange() {
        initViewPager();
        adapter = new TabPagerAdapter(getSupportFragmentManager(), titleList, fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        adapter.notifyDataSetChanged();

    }

    private void destroyAllViewPagerItem() {
        if (viewPager != null && adapter != null && fragmentList != null && !fragmentList.isEmpty()) {
            for (int i = 0; i < fragmentList.size(); i++) {
                adapter.destroyItem(viewPager, i, fragmentList.get(i));
                getSupportFragmentManager().beginTransaction().remove(fragmentList.get(i)).commit();
            }
        }
    }
}
