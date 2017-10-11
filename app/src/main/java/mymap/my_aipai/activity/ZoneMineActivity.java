package mymap.my_aipai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import mymap.my_aipai.CodeConstants;
import mymap.my_aipai.R;
import mymap.my_aipai.fragment.FmZoneLogined;
import mymap.my_aipai.fragment.FmZoneNotLogin;
import mymap.my_aipai.utils.CLog;

/**
 * Created by Administrator on 2017/9/20.
 */

public class ZoneMineActivity extends FragmentActivity{
    private FragmentManager mFragmentManager;
    private FmZoneLogined mFmLogined;
    private FmZoneNotLogin mFmNotLogined;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_mine);

        mFragmentManager = getSupportFragmentManager();

        mFmLogined = (FmZoneLogined) mFragmentManager.findFragmentById(R.id.fm_logined);
        mFmNotLogined = (FmZoneNotLogin) mFragmentManager.findFragmentById(R.id.fm_not_login);
    }


    private void setCurrentFragment() {
     /*  *//* if (iAccountManager.isLogined()) {// 已登录
            CLog.trace("ZoneMineActivity.setCurrentFragment()--已登录");

            if (isFirstLoad || ZoneUtils.spGet(this, FmZoneLogined.SP_KEY_MYINFO, "").equals("")) {
                mFmLogined.initLoad();
                isFirstLoad = false;
            }

            mFmNotLogined.setNowNotLogin(false);
            mFmLogined.setIsNowLogined(true);*//*
            mFragmentManager.beginTransaction().hide(mFmNotLogined).show(mFmLogined).commitAllowingStateLoss();
            //OpenFeedbackManager.getFeedbackUnreadCount(this, OpenFeedbackManager.getUid());
        } else {
            CLog.trace("ZoneMineActivity.setCurrentFragment()--未登录");
           *//* isFirstLoad = true;
            mFmNotLogined.setNowNotLogin(true);
            mFmLogined.setIsNowLogined(false);*/
            mFragmentManager.beginTransaction().hide(mFmLogined).show(mFmNotLogined).commitAllowingStateLoss();
       // }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CodeConstants.REQUEST_CODE_FROM_MAIN_ACTIVITY) {
            if (data != null) {
                CLog.trace("ZoneMineActivity.onActivityResult()  code = " + data.getIntExtra("code", -1));
                if (data.getIntExtra("code", -1) == 0) {// 登录成功
                    // ZoneUtils.spInput(this, FmZoneLogined.SP_KEY_MYINFO, "");
                    setCurrentFragment();
                }
            }
        }

    }
}
