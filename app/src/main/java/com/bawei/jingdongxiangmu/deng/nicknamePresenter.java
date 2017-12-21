package com.bawei.jingdongxiangmu.deng;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.bawei.jingdongxiangmu.xinjia.AllBack;

import java.util.HashMap;



/**
 * Created by wsq on 2017/12/9.
 */

public class nicknamePresenter {
    private Context context;
    private NicknameView nicknameView;

    public nicknamePresenter(Context context, NicknameView nicknameView) {
        this.context = context;
        this.nicknameView = nicknameView;
    }

    public void Nicknames(HashMap<String,String> map){
        //                           //http://120.27.23.105/user/updateNickName
        OkHttp.getinstance().postData("http://120.27.23.105/user/updateNickName", map, new AllBack() {
            @Override
            public void onSuccess(String tag, Object o) {
                nicknameView.success(tag, o);
            }

            @Override
            public void onFailed(String tag, String e) {
                nicknameView.failed(tag, e);
            }
        }, niackanmebean.class, "");
    }
    public boolean checkData(String name) {
        if(TextUtils.isEmpty(name)){
            Toast.makeText(context,"昵称不能为空",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
