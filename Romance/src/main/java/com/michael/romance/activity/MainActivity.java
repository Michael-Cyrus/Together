package com.michael.romance.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.michael.romance.R;
import com.michael.romance.base.BasicActivity;
import com.michael.romance.config.DataServer;

import butterknife.BindView;

public class MainActivity extends BasicActivity {


    @BindView(R.id.tv)
    TextView tv;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhotoViewBrowseActivity.startActivity(mContext, DataServer.getImgData());
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
