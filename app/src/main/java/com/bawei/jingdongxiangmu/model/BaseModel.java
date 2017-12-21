package com.bawei.jingdongxiangmu.model;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by wsq on 2017/11/7.
 */

public class BaseModel {
    //子线程
    protected Handler handler= new Handler(Looper.getMainLooper());
}
