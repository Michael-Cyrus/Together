package com.michael.common.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

import com.michael.common.utils.StatusBarUtil;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;

/**
 * Created by Michael on 2018/3/29.
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    public String tag;
    protected BaseActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        tag = this.getClass().getSimpleName();
        mContext = this;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            ButterKnife.bind(this);
        }
        StatusBarUtil.setTranslucent (this);
        EventBus.getDefault().register(this);
        initView();
    }

    protected abstract void initView();

    protected abstract int getLayoutId();

    @Subscribe
    public void onEvent(Object obj) {
        Logger.d("EventUtil", "%s:%s", tag, obj.getClass().getName());
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
//        ActivityCollector.removeActivity(this);
    }

}
