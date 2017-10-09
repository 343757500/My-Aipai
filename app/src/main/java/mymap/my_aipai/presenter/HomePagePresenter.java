package mymap.my_aipai.presenter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mymap.my_aipai.bean.pageAllGame;
import mymap.my_aipai.event.HomePageAddNewGameEvent;
import mymap.my_aipai.event.HomePageGetDataSuccessEvent;
import mymap.my_aipai.event.HomePageReSortDataEvent;
import mymap.my_aipai.module.HomePageGameEntity;
import mymap.my_aipai.presenter.homepage.IHomePagePresenter;
import mymap.my_aipai.views.IHomePageView;
import mymap.my_aipai.views.fragment.HomePageFragment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static mymap.my_aipai.bean.pageAllGame.*;

/**
 * Created by Administrator on 2017/9/21.
 */

public class HomePagePresenter implements IHomePagePresenter{
    private IHomePageView homePageView;
    private List<String> titleList = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();
    private pageAllGame pageData1= new pageAllGame();
    private static final String TAB_HOME = "热门";
    private boolean shouldRefreshDataOnResume = false;
    private ArrayList<DataBean.CommonListBean> listBeen;

    @Override
    public void resume() {
        applyAllData();
    }

    @Override
    public void pause() {

    }


    public void onEvent(HomePageAddNewGameEvent event) {
        shouldRefreshDataOnResume = true;
    }

    public void onEvent(HomePageGetDataSuccessEvent event) {
        applyAllData();
    }

    public void onEvent(HomePageReSortDataEvent event) {
        shouldRefreshDataOnResume = true;
    }



    @Override
    public void destroy() {

    }

    @Override
    public void setView(IHomePageView iHomePageView) {
        this.homePageView = iHomePageView;
    }

    @Override
    public void present() {

        applyAllData();
    }

    @Override
    public HomePageGameEntity getCurrentGameEntity(int i) {
        return null;
    }


    private void applyAllData() {

        new Thread(new Runnable() {

            private pageAllGame pageData;

            @Override
            public void run() {
                //2.1 构建一个okhttpClient
                OkHttpClient okHttpClient=new OkHttpClient();
                //2.2 准备一个request请求
                Request request=new Request.Builder().url("http://m.aipai.com/aipaiApi/indexPage/allGameData").build();
                //2.3 执行请求
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    Log.e("hei","1111111111111111");
           if(response.isSuccessful()) {

                String result = response.body().string();
               pageData1 = new Gson().fromJson(result, pageAllGame.class);
               if (!TextUtils.isEmpty(result)) {
                   listBeen = new ArrayList<>();
                   listBeen.addAll(pageData1.getData().getCommonList());


                }
            }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        setTabTitleListData(listBeen);//最新的列表顺序
        homePageView.updateFragmentList(fragmentList,titleList);
        handleEmptyDataState();
    }




    private void handleEmptyDataState() {
        titleList.clear();
        fragmentList.clear();

        titleList.add(0, TAB_HOME);
        fragmentList.add(0, new HomePageFragment());

        setupHomePageView();
    }


    private void setupHomePageView() {
        if (homePageView != null) {
            homePageView.updateFragmentList(fragmentList, titleList);
        }
    }

    private void setTabTitleListData(List<pageAllGame.DataBean.CommonListBean> titleEntityList) {
        if (titleEntityList != null && !titleEntityList.isEmpty()) {

            titleList.clear();
            fragmentList.clear();

            handleEmptyFragmentMapState(titleEntityList);

            titleList.add(0, TAB_HOME);
            fragmentList.add(0, new HomePageFragment());


            setupHomePageView();
        }

    }


    /**
     * 处理除了热门Tab外没有其他tab的时候，有新的tab进来的逻辑
     *
     * @param titleEntityList
     */
    private void handleEmptyFragmentMapState(List<pageAllGame.DataBean.CommonListBean> titleEntityList) {

        if (titleEntityList == null || titleEntityList.isEmpty()) {
            return;
        }

        for (int i = 0; i < titleEntityList.size(); i++) {
            DataBean.CommonListBean entity = titleEntityList.get(i);

            if (entity != null && !TextUtils.isEmpty(entity.getUrl()) && !TextUtils.isEmpty(entity.getGameName())) {
                titleList.add(titleEntityList.get(i).getGameName());
                Bundle bundle = getBundle(entity.getUrl());
                if (bundle != null) {
                    Fragment fragment =new  HomePageFragment();
                    fragmentList.add(fragment);
                }
            }

        }
    }

    private Bundle getBundle(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        Bundle bundle = new Bundle();
        setWebViewBundle(bundle, url);

        return bundle;
    }

    private void setWebViewBundle(Bundle bundle, String url) {
        if (bundle != null) {
            bundle.putString("1", url);//加载地址
            bundle.putBoolean("2", false);//不展示进度条
            bundle.putBoolean("3", false);//不允许重定向
        }
    }

}
