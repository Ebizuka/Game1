package com.example.game1;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends Activity {

	private View view;

	// ハンドラを作成
	private Handler handler = new Handler();
	// ビューの再描画間隔(ミリ秒)
	private final static long INTERVAL_TIME = 30;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new SampleView(this);
		setContentView(view);

		// ビュー再描画タイマー
		// タイマーを作成
		Timer timer = new Timer(false);
		// 「INTERVAL_TIME」ミリ秒おきにタスク(TimerTask)を実行
	    timer.schedule(new TimerTask(){
	    	public void run(){
	    		handler.post(new Runnable(){
	    			public void run(){
	    				// ビューを再描画
	    				view.invalidate();
	    			}});
	    	}
	    }, 0, INTERVAL_TIME);
	}
}
