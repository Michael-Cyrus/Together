package com.cf.hospital.activity;

import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cf.hospital.R;
import com.michael.common.base.BaseActivity;

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
        return R.layout.activity_app_start_layout;
    }

    @Override
    protected void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
        super.onDestroy();
    }
}
