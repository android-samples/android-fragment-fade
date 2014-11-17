package com.example.myfragmentfade;

import android.animation.LayoutTransition;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.os.Build;

public class MainActivity extends Activity {

	public void buttonMethod1(View button){
		// Fragment取得
		Fragment f = getFragmentManager().findFragmentById(R.id.fragment1);

		// Fragment操作の開始
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		
		// アニメーション設定
		ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

		// Fragmentの表示または非表示
		if(f.isVisible()){
			ft.hide(f);
		}
		else{
			ft.show(f);
		}
		
		// 確定
		ft.commit();
	}

	public void buttonMethod2(View button){
		// Fragment取得
		Fragment f = getFragmentManager().findFragmentById(R.id.fragment2);

		// Fragment操作の開始
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		
		// アニメーション設定
		ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

		// Fragmentの表示または非表示
		if(f.isVisible()){
			ft.hide(f);
		}
		else{
			ft.show(f);
		}
		
		// 確定
		ft.commit();
	}

	// 実験：button0のshow/hide
	public void buttonMethod3(View button){
		View v = findViewById(R.id.button0);
		LinearLayout container = (LinearLayout)findViewById(R.id.container);
		if(v.getVisibility() == View.VISIBLE){
			v.setVisibility(View.GONE);
		}
		else{
			v.setVisibility(View.VISIBLE);
		}
	}
	
	LayoutTransition mTransition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// LayoutTransitionも付けておく？
		LinearLayout container = (LinearLayout)findViewById(R.id.container);
		mTransition = new LayoutTransition();
		container.setLayoutTransition(mTransition);

		/*
		LinearLayout layout1 = (LinearLayout)findViewById(R.id.layout1);
		layout1.setLayoutTransition(new LayoutTransition());

		LinearLayout layout2 = (LinearLayout)findViewById(R.id.layout2);
		layout2.setLayoutTransition(new LayoutTransition());
		*/

		
		/*
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		*/
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class MyFragment1 extends Fragment {
		public MyFragment1() {
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	public static class MyFragment2 extends Fragment {
		public MyFragment2() {
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
}
