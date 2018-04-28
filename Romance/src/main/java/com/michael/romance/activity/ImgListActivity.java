package com.michael.romance.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.michael.common.widget.CenterTitleToolbar;
import com.michael.romance.R;
import com.michael.romance.adapter.ImgListAdapter;
import com.michael.romance.base.BasicActivity;

import butterknife.BindView;

/**
 * Created by Michael on 2018/4/26.
 */

public class ImgListActivity extends BasicActivity {

    @BindView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void initView() {
        initToolbar(toolbar);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        rv.setLayoutManager(manager);
        ImgListAdapter adapter = new ImgListAdapter(R.layout.item_img_list, null);
        rv.setAdapter(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_img_list;
    }

}
