package com.example.lzy.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.lzy.sdk.GlideApp;
import com.example.lzy.sdk.R;

import java.io.File;
import java.security.MessageDigest;


/**
 * Glide图片加载工具类
 *
 * Created by bullet on 2017/8/30.
 */

public class ImageUtils {

    /**
     * 根据URl 加载图片
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void loadBasicImg(Context context, String url, ImageView imageView) {


        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.img_error)
                .into(imageView);
    }


    /**
     * 根据资源ID 加载图片
     *
     * @param context
     * @param resourceId 图片id
     * @param target view
     * @param defaultId 加载图片id
     */
    public static void loadBasicImg(Context context, int resourceId, ImageView target, int defaultId) {
        GlideApp.with(context)
                .load(resourceId)
                .placeholder(defaultId)
                .transition(new DrawableTransitionOptions().crossFade(200))
                .centerCrop()
                .into(target);
    }

    /**
     * 根据图片路径 加载图片
     *
     * @param context
     * @param imgFile 图片id
     * @param target  view
     * @param defaultId  加载图片id
     */
    public static void loadBasicImg(Context context, File imgFile, ImageView target, int defaultId) {
        GlideApp.with(context)
                .load(imgFile)
                .placeholder(defaultId)
                .transition(new DrawableTransitionOptions().crossFade(200))
                .centerCrop()
                .into(target);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param imgPath
     * @param iv
     */
    public static void loadCircleImg(Context context, String imgPath, ImageView iv) {
        GlideApp.with(context)
                .load(imgPath)
                .transform(new CircleCrop())
                .into(iv);
    }

    /**
     * 加载资源id ，圆形图片
     *
     * @param context
     * @param resourceId 资源id
     * @param iv
     */
    public static void loadCircleImg(Context context, int resourceId, ImageView iv) {
        GlideApp.with(context)
                .load(resourceId)
                .transform(new CircleCrop())
                .into(iv);
    }




    /**
     * 加载圆角图片
     *
     * @param context
     * @param imgPath
     * @param iv
     * @param corners
     */
    public static void loadRoundedImg(Context context, String imgPath, ImageView iv,int corners) {
        GlideApp.with(context)
                .load(imgPath)
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.img_placeholder)
                .transform(new RoundedCorners(corners))
                //.transition(new DrawableTransitionOptions().crossFade(200)) //TODO渐显效果设置
                .into(iv);
    }



    /**
     * 加载Gif为一张静态图片
     *
     * @param context
     * @param url
     */
    public static void loadGifImg(Context context, String url, ImageView imageView) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.img_placeholder)
                .error(R.drawable.img_error)
                .into(imageView);
    }


    /**
     * 加载Gif本地资源为一张静态图片
     *
     * @param context
     *
     * @param IdResource 本地资源id
     */
    public static void loadGifImg(Context context, int IdResource, ImageView imageView) {
        GlideApp.with(context).load(IdResource).into(imageView);
    }


    /**
     * 圆形加载带边框
     *
     * @param mContext
     * @param path url
     * @param imageView view
     * @param borderWidth  边框的宽度
     * @param colorId 边框的颜色
     */
    public static void loadFrameImg(Context mContext, String path,
                                    ImageView imageView,int borderWidth,int colorId) {
        GlideApp.with(mContext).asBitmap().load(path).centerCrop()
                .transform(new GlideCircleTransform(mContext, borderWidth,
                        mContext.getResources().getColor(colorId)))
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageView);
    }


    /**
     * 圆形加载带边框
     *
     * @param mContext
     * @param path
     * @param imageview
     */
    public static void loadFrameImg(Context mContext, int path, ImageView imageview) {
        GlideApp.with(mContext).asBitmap().load(path).centerCrop()
                .transform(new GlideCircleTransform(mContext, 4, mContext.getResources().getColor(R.color.blue)))
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(imageview);
    }

    /**
     * 加载图片不需要缓存的
     *
     * @param c
     * @param url
     * @param target
     */
    public static void loadSourseImgWithNoCache(Context c, String url, ImageView target) {
        GlideApp.with(c)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .centerCrop()
                .transition(new DrawableTransitionOptions().crossFade(200))
                .into(target);
    }





    /**
     * 下载图片,耗时操作不能放在主线程中进行
     *
     * @param context
     * @param url
     */
    public static void downLoadImage(Context context, String url) {

        try {
            GlideApp.with(context).asBitmap().load(url).centerCrop().listener(new RequestListener<Bitmap>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean
                        isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource
                        dataSource, boolean isFirstResource) {
                    return false;
                }
            }).submit().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }









    static class GlideCircleTransform extends BitmapTransformation {

        private Paint mBorderPaint;
        private float mBorderWidth;

        public GlideCircleTransform(Context context) {

        }

        public GlideCircleTransform(Context context, int borderWidth, int borderColor) {

            mBorderWidth = Resources.getSystem().getDisplayMetrics().density * borderWidth;

            mBorderPaint = new Paint();
            mBorderPaint.setDither(true);
            mBorderPaint.setAntiAlias(true);
            mBorderPaint.setColor(borderColor);
            mBorderPaint.setStyle(Paint.Style.STROKE);
            mBorderPaint.setStrokeWidth(mBorderWidth);
        }


        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = (int) (Math.min(source.getWidth(), source.getHeight()) - (mBorderWidth / 2));
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            if (mBorderPaint != null) {
                float borderRadius = r - mBorderWidth / 2;
                canvas.drawCircle(r, r, borderRadius, mBorderPaint);
            }
            return result;
        }


        @Override
        public void updateDiskCacheKey(MessageDigest messageDigest) {

        }
    }




    /**
     * 清除缓存
     *
     * @param context
     */
    public void clearCache(final Context context) {
        clearMemoryCache(context);
        new Thread(new Runnable() {
            @Override
            public void run() {
                clearDiskCache(context);
            }
        }).start();
    }

    /**
     * 清除内存缓存
     *
     * @param context
     */
    public void clearMemoryCache(Context context) {
        GlideApp.get(context).clearMemory();
    }


    /**
     * 清除磁盘缓存
     *
     * @param context
     */
    public void clearDiskCache(Context context) {
        GlideApp.get(context).clearDiskCache();
    }

}
