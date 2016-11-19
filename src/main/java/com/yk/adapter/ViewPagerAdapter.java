package com.yk.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yk.R;
import com.yk.activity.MainActivity;
import com.yk.utils.SharepreferenceUtils;

import java.util.List;

/**
 * Created by Silence on 2016/11/19.
 */

public  class ViewPagerAdapter extends PagerAdapter {
    //图片集合
    public List<View>mList;
    public Activity mActivity;
    public SharepreferenceUtils mPreference;

    /**
     * 初始化
     */
  public  ViewPagerAdapter(List<View>list,Activity activity){
      this.mList=list;
      this.mActivity=activity;
      mPreference=new SharepreferenceUtils(mActivity);

    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView(mList.get(position));
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ((ViewPager) container).addView(mList.get(position), 0);
        if (position == mList.size() - 1) {
            ImageView mStartWeiboImageButton = (ImageView) container
                    .findViewById(R.id.iv_start_weibo);
            mStartWeiboImageButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // 设置已经引导
                    setGuided();
                    goHome();

                }

            });
        }
        return mList.get(position);
    }

    /**
     * 进入主页面
     */
    public void goHome(){
// 跳转
        Intent intent = new Intent(mActivity, MainActivity.class);
        mActivity.startActivity(intent);
        mActivity.finish();
    }

    /**
     * 设置引导页
     * 设置已经引导过了，下次启动不用再次引导
     */
    public void setGuided(){
        mPreference.saveIsFirst("2");

    }

    /**
     *  判断是否由对象生成界面
      */

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return (arg0 == arg1);
    }

    @Override
    public void restoreState(Parcelable arg0, ClassLoader arg1) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public void startUpdate(View arg0) {
    }
}
