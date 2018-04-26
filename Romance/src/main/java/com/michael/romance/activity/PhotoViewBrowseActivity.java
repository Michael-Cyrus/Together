package com.michael.romance.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.michael.common.base.BaseActivity;
import com.michael.common.widget.CenterTitleToolbar;
import com.michael.common.widget.HackyViewPager;
import com.michael.romance.R;
import com.michael.romance.bean.ImageBean;
import com.michael.romance.config.Constant;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Michael on 2018/4/16.
 */

public class PhotoViewBrowseActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    HackyViewPager viewpager;
    @BindView(R.id.toolbar)
    CenterTitleToolbar toolbar;
    @BindView(R.id.rename_pic)
    ImageView renamePic;
    @BindView(R.id.pic_count)
    TextView picCount;
    @BindView(R.id.pic_button_layout)
    RelativeLayout picButtonLayout;
    private ArrayList<ImageBean> imageList;

    public static void startActivity(Context context, ArrayList<ImageBean> imageList) {
        Intent intent = new Intent(context, PhotoViewBrowseActivity.class);
        intent.putExtra(Constant.DATA_OBJECT, imageList);
        context.startActivity(intent);
    }

    @Override
    protected void initView() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        renamePic.setVisibility(View.GONE);
        imageList = (ArrayList<ImageBean>) getIntent().getSerializableExtra(Constant.DATA_OBJECT);
        picCount.setText(1 + File.separator +imageList.size());
        viewpager.setAdapter(new PhotoAdapter());
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                ImageBean imageBean = imageList.get(position);
                toolbar.setTitle(imageBean.getFileName());
                picCount.setText(position + 1 + File.separator +imageList.size());
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_browse;
    }

    class PhotoAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageList == null ? 0 : imageList.size();
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageBean imageBean = imageList.get(position);
            PhotoView photoView = new PhotoView(mContext);
            photoView.enable();
            photoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            RequestOptions options = new RequestOptions()
                    .placeholder(R.mipmap.iv_default_pic)
                    .error(R.mipmap.iv_default_pic)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(mContext)
                    .load(imageBean.getUrl())
                    .apply(options)
                    .into(photoView);
            container.addView(photoView);
            return photoView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
}
