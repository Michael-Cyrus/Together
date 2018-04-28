package com.michael.romance.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Michael on 2018/4/28.
 */

public class ImgListAdapter extends BaseQuickAdapter {

    public ImgListAdapter(int layoutResId, @Nullable List data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Object item) {

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }
}
