package com.example.game1;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends Activity {

	private View view;

	// �n���h�����쐬
	private Handler handler = new Handler();
	// �r���[�̍ĕ`��Ԋu(�~���b)
	private final static long INTERVAL_TIME = 30;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = new SampleView(this);
		setContentView(view);

		// �r���[�ĕ`��^�C�}�[
		// �^�C�}�[���쐬
		Timer timer = new Timer(false);
		// �uINTERVAL_TIME�v�~���b�����Ƀ^�X�N(TimerTask)�����s
	    timer.schedule(new TimerTask(){
	    	public void run(){
	    		handler.post(new Runnable(){
	    			public void run(){
	    				// �r���[���ĕ`��
	    				view.invalidate();
	    			}});
	    	}
	    }, 0, INTERVAL_TIME);
	}
}
