package com.bawei.jingdongxiangmu.presenter;

import android.text.TextUtils;

import com.bawei.jingdongxiangmu.bean.LoginBean;
import com.bawei.jingdongxiangmu.model.ILoginModel;
import com.bawei.jingdongxiangmu.model.LoginModel;
import com.bawei.jingdongxiangmu.net.OnNetListener;
import com.bawei.jingdongxiangmu.view.IMineView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wsq on 2017/11/9.
 */

public class LoginPresenter {
    private IMineView iMineView;
    private ILoginModel iLoginModel;
    public LoginPresenter(IMineView iMineView){
        this.iMineView=iMineView;
        iLoginModel=new LoginModel();
    }
    public void login(){
        String account = iMineView.getAccount();
        String pwd = iMineView.getPwd();
        //判断账号密码是否正确

        if (checkAccount(account) && checkPwd(pwd)) {
            //去调用model，进行登陆
            iLoginModel.login(account, pwd, new OnNetListener<LoginBean>() {
                @Override
                public void onSuccess(LoginBean loginBean) {
                    //保存登陆成功后的数据，可以保存到SP,也可以保存到数据库
                    iMineView.show(loginBean.getMsg());
                    //跳转
                    iMineView.toClassAc(loginBean.getData().getUid(),loginBean.getData().getUsername());
                }

                @Override
                public void onFailure(Exception e) {
                    iMineView.shibai();
                }
            });
        }
    }
    private boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            //给用户提示，输入的账号不能为空
            iMineView.show("请输入密码");
            return false;
        }

        if (pwd.length() != 6) {
            iMineView.show("请输入6位密码");
            return false;
        }
        return true;
    }
    private boolean checkAccount(String account) {
        if (TextUtils.isEmpty(account)) {
            //给用户提示，输入的账号不能为空
            iMineView.show("请输入账号");
            return false;
        }
        if (!isMobileNO(account)) {
            iMineView.show("请输入正确的手机号");
            return false;
        }
        return true;
    }
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^(13[0-9]|14[57]|15[0-35-9]|17[6-8]|18[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
    public void register() {
        //其实就是跳转到注册页面
        iMineView.toRegisterAc();
    }
}
