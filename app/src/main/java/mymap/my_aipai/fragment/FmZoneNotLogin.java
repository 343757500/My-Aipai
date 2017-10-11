package mymap.my_aipai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mymap.my_aipai.CodeConstants;
import mymap.my_aipai.R;
import mymap.my_aipai.activity.LoginActivity;

/**
 * Created by Administrator on 2017/10/11.
 */

public class FmZoneNotLogin extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zone_mine_not_login, container, false);
        initView(view);

        return view;
    }

    private void initView(View contentView) {
        contentView.findViewById(R.id.iv_user_pic).setOnClickListener(this);
        contentView.findViewById(R.id.img_login_now).setOnClickListener(this);
        contentView.findViewById(R.id.img_register_now).setOnClickListener(this);
        contentView.findViewById(R.id.rel_fun_most).setOnClickListener(this);
        contentView.findViewById(R.id.rl_video_history).setOnClickListener(this);
        contentView.findViewById(R.id.rel_video_offline).setOnClickListener(this);
       /* mTvOfflineCount = (TextView) contentView.findViewById(R.id.tv_offline_count);
        mTvFunTitle = (TextView) contentView.findViewById(R.id.tv_fun_title);
        findView(mView, R.id.ll_most_fun).setVisibility(View.GONE);*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_user_pic:
            case R.id.img_login_now:// 立即登录
                getActivity().startActivityForResult(new Intent(getActivity(), LoginActivity.class), CodeConstants.REQUEST_CODE_FROM_MAIN_ACTIVITY);
                break;
          /*  case R.id.img_register_now:// 注册账号
                Intent intent = new Intent(context, RegisterActivity2.class);
                intent.putExtra("isFromLoginActivity", false);
                getActivity().startActivityForResult(intent, CodeConstants.REQUEST_CODE_FROM_ZONE_MINE);
                break;
            case R.id.rel_fun_most:// 最会玩

                if (strIsEmpty(mFunUrl)) {
                    isClickLoad = true;
                    request();
                } else {
                    JumpActivityMethods.startWebViewActivity(context, mFunUrl);
                }

                break;
            case R.id.rl_video_history:// 观看历史
                startActivity(new Intent(context, PlayHistoryActivity.class));
                break;
            case R.id.rel_video_offline:// 离线视频
                startActivity(new Intent(context, OffLineDataActivity.class));
                break;

            default:
                break;*/
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
