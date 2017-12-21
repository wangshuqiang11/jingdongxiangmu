package com.bawei.jingdongxiangmu.faxian;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * Created by wsq on 2017/12/9.
 */

public class Models implements ModelPost {
    private VidoPresenter vidoPresenter;

    public Models(VidoPresenter vidoPresenter) {
        this.vidoPresenter = vidoPresenter;
    }
    @Override
    public void getData(Map<String, String> map) {
        Flowable<My_VideoBean<My_RetBean<List<My_ListBean>>>> flowable = RetrofitUtils.getInstance().getApiservise().getVideo(map);
        vidoPresenter.get(flowable);
    }

}
