package com.example.game1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class SampleView extends View{

	private Bitmap mBitmap;
	private Canvas mCanvas;
	private Bitmap stamp_img;
	private	Paint paint = new Paint();
	
	//private Rect rect = new Rect(10, 20, 30, 40);
	
	private int		bx = 100; //bx by は　初めの座標　または　移動している座標
	private int		by = 100; //
	private	int 	dx = 2;   //dx dy は　ベクトルを表す
	private	int 	dy = 2;   //
	private int     color =  Color.RED;  //色を指定
	private static int margin = 20; //円の半径をmarginとすることによって
	private int     speed = 10;  //　速さを指定
	
	
	
	// コンストラクタ
	public SampleView(Context context) {
		super(context);
	    stamp_img = BitmapFactory.decodeResource( getResources(), R.drawable.ic_launcher );
	}

	// 画面変更時
	protected void onSizeChanged(int w, int h, int oldw, int oldh){
	    //キャンバス作成
	    mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
	    mCanvas = new Canvas(mBitmap); // タッチされた時に呼び寄せる。
	}

	// 描画関数
	@Override
	protected void onDraw(Canvas canvas) {
	    canvas.drawBitmap(mBitmap, 0, 0, null);
	    paint.setColor(color);
	   //mCanvas.drawRect(getWidth()/2-50,getHeight()-200,getWidth()/2+50,getHeight()-160, paint);
	 
	   // Rect rect = new Rect(10, 20, 30, 40); //矩形描画canvas.drawRect(x1,y1,x2,y2,paint);は長方形
	   // canvas.drawRect(rect, paint);      //x1,y1 左上座標 x2,y2 右下座標
	    
		canvas.drawCircle(bx, by, 20, paint);
		/* 左端に来たら反転 */
	    if (bx < 0 + margin ) {
            dx = 2;
        }
        /* 右端に来たら反転 */
        if (bx > getWidth() - margin) {
            dx = -2;
        }
        /* 上端に来たら反転 */
        if (by < 0 + margin) {
            dy = 2;
        }		
        /* 右端に来たら反転 */
        if (by  > getHeight() - margin) {
            dy = -2;
        }                
        bx = bx + speed*dx;
        by = by + speed*dy;
	}
	    

	// タッチされた時
	public boolean onTouchEvent(MotionEvent event) {
			float x = event.getX();
			float y = event.getY();
			int ex = (int)event.getX();
			int ey = (int)event.getY();
			
			
			
			
			
			// mCanvas.drawCircle(ex, getWidth() -150, 100, paint);
		    mCanvas.drawRect(x,getHeight()-200,x+100,getHeight()-160, paint);
		    Paint fill_paint = new Paint();
		    fill_paint.setStyle(Paint.Style.FILL);
		    fill_paint.setColor(Color.WHITE);
			mCanvas.drawRect(x-getWidth(),getHeight()-200,x         ,getHeight()-160,fill_paint);
			mCanvas.drawRect(x+100     ,getHeight()-200,getWidth(),getHeight()-160,fill_paint);
		return true;
	}
}
