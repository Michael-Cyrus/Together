package com.michael.romance.base;

import android.view.View;

import com.michael.common.base.BaseActivity;
import com.michael.common.widget.CenterTitleToolbar;

/**
 * Created by Michael on 2018/4/28.
 */

public class BasicActivity extends BaseActivity {

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    public void initToolbar(CenterTitleToolbar toolbar){
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
