package com.bawei.jingdongxiangmu.xinjia;

import android.content.Context;
import android.widget.ImageView;

import com.youth.banner.loader.ImageLoader;

/**
 * 作者：刘雄彪
 */

public class ImgApp extends ImageLoader {

   @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
       com.nostra13.universalimageloader.core.ImageLoader.getInstance().displayImage((String) path,imageView);
    }
}
