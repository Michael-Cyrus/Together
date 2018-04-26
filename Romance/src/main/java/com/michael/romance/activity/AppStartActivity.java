package com.michael.romance.activity;

import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.michael.common.base.BaseActivity;
import com.michael.romance.R;

import butterknife.BindView;

/**
 * Created by Michael on 2018/3/29.
 */

public class AppStartActivity extends BaseActivity {

    @BindView(R.id.welcome_iv)
    ImageView welcomeIv;
    private Handler mHandler;

    @Override
    protected void initView() {
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1);
        alphaAnimation.setDuration(1000);
        //将alphaAnimation对象添加到AnimationSet当中

        animationSet.addAnimation(alphaAnimation);

        RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(
                0, 1f,0,1f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(1000);
        animationSet.addAnimation(scaleAnimation);

        //使用ImageView的startAnimation方法执行动画

        welcomeIv.startAnimation(animationSet);


        mHandler = new Handler();
//        GlideApp.with(this).load(R.mipmap.ic_launcher).into(welcomeIv);
        Glide.with(this).load(R.mipmap.bg_home_welcome).into(welcomeIv);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.startActivity(mContext);
                finish();
            }
        }, 2000);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_app_start;
    }

    @Override
    protected void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
