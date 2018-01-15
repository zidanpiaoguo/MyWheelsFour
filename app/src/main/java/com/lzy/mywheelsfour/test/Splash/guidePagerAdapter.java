package com.lzy.mywheelsfour.test.Splash;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.lzy.sdk.utils.ToastUtils;
import com.lzy.mywheelsfour.R;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by bullet on 2017/12/22.
 */

public class guidePagerAdapter extends PagerAdapter {

    private List<View> list = new ArrayList<>();
    private Activity activity;
    public guidePagerAdapter(Activity activity ,List<Integer> imgs) {


        this.activity = activity;
        LayoutInflater layoutInflater = LayoutInflater.from(activity);
        for (int i = 0; i < imgs.size(); i++) {
            View view = layoutInflater.inflate(R.layout.activity_splash,null);
            ImageView iv_guide =  view.findViewById(R.id.iv_splash);
            iv_guide.setImageResource(imgs.get(i));
            list.add(view);
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        if(position == list.size()-1){
            list.get(position).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.makeText("我要进入登陆页面了");
                }
            });
        }
        container.addView(list.get(position));

        return list.get(position);

    }


    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView(list.get(position));
    }


}
