package com.bawei.jingdongxiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jingdongxiangmu.presenter.LoginPresenter;
import com.bawei.jingdongxiangmu.view.IMineView;
import com.bawei.jingdongxiangmu.xinjia.ImgApp2;

public class LoginActivity extends AppCompatActivity implements IMineView, View.OnClickListener {
    private ImageView mIvBack;
    /**
     * 手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    private ImageView mIvPwd;
    /**
     * 登陆
     */
    private Button mBtLogin;
    private Button qqbtn;
    /**
     * 请注册
     */
    private TextView mTvRegister;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mIvPwd = (ImageView) findViewById(R.id.iv_pwd);
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(this);
        qqbtn = (Button) findViewById(R.id.qq_btn);
        mIvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public String getAccount() {
        return mEtPhone.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString().trim();
    }

    @Override
    public void show(String str) {
        Toast.makeText(LoginActivity.this, str, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void toRegisterAc() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void toClassAc(int uid,String nickname) {
        ImgApp2.edit.putInt("uid",uid);
        ImgApp2.edit.putString("nickname",nickname);
        ImgApp2.edit.putBoolean("isLogin",true);
        ImgApp2.edit.commit();
        finish();
    }

    @Override
    public void shibai() {
        ImgApp2.edit.putBoolean("isLogin",false);
        ImgApp2.edit.commit();
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            default:
                break;
            case R.id.bt_login:
                loginPresenter.login();
                break;
            case R.id.tv_register:
                loginPresenter.register();
                break;

        }
    }
}
