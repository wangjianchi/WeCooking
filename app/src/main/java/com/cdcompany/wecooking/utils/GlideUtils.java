package com.cdcompany.wecooking.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cdcompany.wecooking.App;
import com.cdcompany.wecooking.R;

/**
 * Created by cd14 on 2016/11/2.
 */

public class GlideUtils {
    /**
     * 正常加载图片
     * @param url
     * @param iv
     */
    public static void showImage(String url, ImageView iv){
        Glide.with(App.getAppContext())
                .load(url)
                .centerCrop()
                .crossFade()
                .error(R.drawable.placeholder)
                .into(iv);
    }

    public static void showImageSwitcher(String url, final ImageSwitcher imageSwitcher){
        Glide.with(App.getAppContext())
                .load(url)
                .asBitmap()
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        imageSwitcher.setImageDrawable(new BitmapDrawable(App.getAppContext().getResources(), resource));
                        return true;
                    }
                }).into((ImageView) imageSwitcher.getCurrentView());
    }
}
