package com.eotech.eomessage;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EoMessageHome extends Activity implements
		ViewPager.OnPageChangeListener {

	private final static int PAGERS_COUNT = 3;
	private List<View> mTabTitle = new ArrayList<View>();
	private List<View> mTabContents = new ArrayList<View>();
	private TextView mTabMessage = null;
	private TextView mTabVIP = null;
	private TextView mTabRecommend = null;
	private ViewPager mTabContainer = null;
	private MyPagerAdapter mPagerAdapter = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eo_message_home);
		setupView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_eo_message_home, menu);
		return true;
	}

	public void setupView() {
		mTabMessage = (TextView) findViewById(R.id.home_message_title);
		mTabTitle.add(mTabMessage);
		mTabVIP = (TextView) findViewById(R.id.home_vip_title);
		mTabVIP.setTextColor(Color.GRAY);
		mTabTitle.add(mTabVIP);
		mTabRecommend = (TextView) findViewById(R.id.home_recommend_title);
		mTabRecommend.setTextColor(Color.GRAY);
		mTabTitle.add(mTabRecommend);
		mTabContainer = (ViewPager) findViewById(R.id.home_viewpager);
		initPagers_test();
		mPagerAdapter = new MyPagerAdapter();
		mTabContainer.setAdapter(mPagerAdapter);
		mTabContainer.setOnPageChangeListener(this);
		mTabContainer.setCurrentItem(0);
	}

	private void initPagers_test() {

		for (int i = 0; i < PAGERS_COUNT; i++) {
			LinearLayout layout = new LinearLayout(this);
			TextView view = new TextView(this);
			SpannableStringBuilder style = new SpannableStringBuilder(
					"ÕâÊÇPager " + i);
			style.setSpan(new ForegroundColorSpan(Color.WHITE), 1, 9,
					Spannable.SPAN_USER);
			view.setText(style);
			view.setBackgroundColor(Color.BLACK);
			mTabContents.add(view);
		}

	}

	// ÊÊÅäÆ÷
	class MyPagerAdapter extends PagerAdapter {

		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(mTabContents.get(arg1));
		}

		public void finishUpdate(View arg0) {
		}

		public int getCount() {
			return mTabContents.size();
		}

		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(mTabContents.get(arg1), 0);

			return mTabContents.get(arg1);
		}

		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == (arg1);
		}

		public void restoreState(Parcelable arg0, ClassLoader arg1) {
		}

		public Parcelable saveState() {
			return null;
		}

		@Override
		public void startUpdate(View arg0) {
		}

	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		// TODO Auto-generated method stub
		switch (arg0) {
		case 0:
			mTabMessage.setTextColor(Color.WHITE);
			mTabVIP.setTextColor(Color.GRAY);
			mTabRecommend.setTextColor(Color.GRAY);
			break;
		case 1:
			mTabMessage.setTextColor(Color.GRAY);
			mTabVIP.setTextColor(Color.WHITE);
			mTabRecommend.setTextColor(Color.GRAY);
			break;
		case 2:
			mTabMessage.setTextColor(Color.GRAY);
			mTabVIP.setTextColor(Color.GRAY);
			mTabRecommend.setTextColor(Color.WHITE);
			break;
		}
	}

}
