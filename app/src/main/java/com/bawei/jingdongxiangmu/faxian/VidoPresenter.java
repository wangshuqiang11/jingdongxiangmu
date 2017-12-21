package com.bawei.jingdongxiangmu.faxian;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by wsq on 2017/12/9.
 */

public class VidoPresenter implements PresenterPost {
    private Iview iview;
    private DisposableSubscriber<My_VideoBean<My_RetBean<List<My_ListBean>>>> subscriber;

    public VidoPresenter(Iview iview) {
        this.iview = iview;
    }
    public void detachView() {
        if (iview != null) {
            iview = null;
        }
    }
    @Override
    public void getData(Map<String, String> map) {
        Models model = new Models(this);
        model.getData(map);
    }

    public void get(Flowable<My_VideoBean<My_RetBean<List<My_ListBean>>>> flowable){
        subscriber = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<My_VideoBean<My_RetBean<List<My_ListBean>>>>() {
                    @Override
                    public void onNext(My_VideoBean<My_RetBean<List<My_ListBean>>> retBeanVideoBean) {
                        List<My_ListBean> list = retBeanVideoBean.getRet().getList();
                        iview.onSuccess(list);
                    }

                    @Override
                    public void onError(Throwable t) {
                        iview.onFailed(new Exception(t));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
