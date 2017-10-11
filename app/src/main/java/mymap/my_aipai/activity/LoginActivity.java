package mymap.my_aipai.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

import mymap.my_aipai.CodeConstants;
import mymap.my_aipai.R;

/**
 * Created by Administrator on 2017/10/11.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnLogin;
    public static Tencent mTencent;

    private ImageView ivClearContent0, ivClearContent1;
    private IUiListener listener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        mTencent = Tencent.createInstance("1106392335", getApplicationContext());
        initView();
    }


    private void initView() {

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setEnabled(false);
        btnLogin.setOnClickListener(this);


        findViewById(R.id.ll_qq_login).setOnClickListener(this);
        findViewById(R.id.ll_wx_login).setOnClickListener(this);
        // findViewById(R.id.ll_wx_login).setVisibility(View.GONE);
        findViewById(R.id.ll_sina_login).setOnClickListener(this);
        findViewById(R.id.tv_forget_password).setOnClickListener(this);

        ivClearContent0 = (ImageView) findViewById(R.id.iv_clear_edittext_content_0);
        ivClearContent1 = (ImageView) findViewById(R.id.iv_clear_edittext_content_1);
        ivClearContent0.setOnClickListener(this);
        ivClearContent1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login: {
              /*  String account = etAccount.getText().toString().trim();
                if (!StringUtils.isEmpty(account)) {
                    ZoneUtils.spInput(this, SP_KEY_ACCOUNT, account);
                }
                String password = etPassWord.getText().toString().trim();
                LoginManager.loginAipai(this, account, MD5.getMD5(password.getBytes()), true, this);*/
                break;
            }
            case R.id.ll_qq_login: {
               /* LoginManager loginManager = new LoginManager();*/
              /*  loginManager.loginThird(this, LoginHttpModule.LoginThirdType.QQ, mTencent, new ILoginCallBack() {
                    @Override
                    public void onLoginSuccess(String msg, IUiListener iUiListener) {
                        Toast.makeText(getApplicationContext(), "111", Toast.LENGTH_SHORT).show();
                        listener = iUiListener;
                        notifyLoginSuccess();
                    }

                    @Override
                    public void onLoginFailed(String msg, IUiListener iUiListener) {
                        Toast.makeText(getApplicationContext(), "222", Toast.LENGTH_SHORT).show();
                        listener = iUiListener;
                        //tvReturnmessage.setText(msg);

                    }
                });*/
                break;
            }
            case R.id.ll_wx_login: {
               // LoginManager.loginThird(this, LoginHttpModule.LoginThirdType.WEIXIN, true, mThirdILoginCallBack);
                break;
            }
            case R.id.ll_sina_login: {
              //  LoginManager.loginThird(this, LoginHttpModule.LoginThirdType.SINA, true, mThirdILoginCallBack);
                break;
            }
          /*  case R.id.tv_forget_password: {
                Intent intent = new Intent(this, GetPasswordActivity.class);
                intent.putExtra("findViaEmail", false);
                startActivityForResult(intent, CodeConstants.REQUEST_CODE_FROM_LOGIN_ACTIVITY);
                break;
            }
            case R.id.btn_left: {
                finish();
                break;
            }
            case R.id.btn_right: {
                Intent intent = new Intent(this, RegisterActivity2.class);
                intent.putExtra("isFromLoginActivity", true);
                startActivityForResult(intent, CodeConstants.REQUEST_CODE_FROM_LOGIN_ACTIVITY);
                break;
            }

            case R.id.iv_clear_edittext_content_0: {
                if (!isAccountExist) {
                    etAccount.setText("");
                    etAccount.setHint(etAccount.getHint());
                    etAccount.clearComposingText();
                }
                break;
            }

            case R.id.iv_clear_edittext_content_1: {
                etPassWord.setText("");
                etPassWord.setHint(etPassWord.getHint());
                etPassWord.clearComposingText();
                break;
            }*/

        }
    }


    private void notifyLoginSuccess() {

        Intent intent = new Intent();
        intent.putExtra("code", CodeConstants.CODE_LOGIN_ACTIVITY_SUC);
//        intent.putExtra("loginUserInfo", AipaiApplication.loginUserInfo);
        //intent.putExtra("isNewBid", shouldShowNoviceGuide ? 1 : 0);
        setResult(CodeConstants.RESULT_CODE_FROM_LOGIN_ACTIVITY, intent);
        finish();
    }
}
