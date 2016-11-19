package com.yk.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.yk.adapter.ViewPagerAdapter;
import com.yk.base.BaseActivity;

import java.util.List;
import com.yk.R;

/**
 * Created by Silence on 2016/11/19.
 */

public class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    public ViewPager mViewPager;
    public List<View> mList;
    //适配器
    public ViewPagerAdapter mAdapter;
    //底部小点
    public ImageView[] dots;
    //记录当前选中位置
    public int mCurrentIndex;
    public LinearLayout mLytContent;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        initView();
        initData();
    }


    public void initView() {
        setContentView(R.layout.activity_guide);
        //加载布局
        LayoutInflater mInflater = LayoutInflater.from(this);
        mList.add(mInflater.inflate(R.layout.item_viewpager_one, null));
        mList.add(mInflater.inflate(R.layout.item_viewpager_two, null));
        mList.add(mInflater.inflate(R.layout.item_viewpager_three, null));
        mList.add(mInflater.inflate(R.layout.item_viewpager_four, null));

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        //初始化adapter
        mAdapter = new ViewPagerAdapter(mList, this);
        mViewPager.setAdapter(mAdapter);
    }


    public void initData() {
        mLytContent = (LinearLayout) findViewById(R.id.lyt_content);
        dots = new ImageView[mList.size()];
        //循环获取小点图片
        for (int i = 0; i < mList.size(); i++) {
            dots[i] = (ImageView) mLytContent.getChildAt(i);
            //都设置为灰色
            dots[i].setEnabled(true);
        }
        mCurrentIndex = 0;
        //设置为白色即为选中状态
        dots[mCurrentIndex].setEnabled(false);
    }

    /**
     * 设置点的实时位置
     */
    public void setCurrentDot(int position) {
        if (position < 0 || position > mList.size() - 1 || mCurrentIndex == position) {
            return;
        }
        dots[position].setEnabled(false);
        dots[mCurrentIndex].setEnabled(true);
        position=mCurrentIndex;

    }

    /**
     * 页面滚动时
     *
     * @param i
     * @param v
     * @param i1
     */
    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    /**
     * 页面状态改变时
     *
     * @param i
     */
    @Override
    public void onPageScrollStateChanged(int i) {

    }

    /**
     * 页面选中时
     *
     * @param i
     */
    @Override
    public void onPageSelected(int i) {
        //设置底部小点选中状态
        setCurrentDot(i);

    }
}
