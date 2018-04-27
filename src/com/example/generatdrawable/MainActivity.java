package com.example.generatdrawable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView background;

	private int[] ids = { R.drawable.icon_baidu_nomal,
			R.drawable.icon_baojun_store_nomal, R.drawable.icon_calendar_nomal,
			R.drawable.icon_download_nomal, R.drawable.icon_phone_nomal,
			R.drawable.icon_qq_nomal, R.drawable.icon_qqmusic_nomal,
			R.drawable.icon_search_nomal,R.drawable.icon_search_nomal };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		background = (ImageView) findViewById(R.id.appBackGround);

		Bitmap bitmap = mergeThumbnailBitmap(BitmapFactory.decodeResource(
				getResources(), R.drawable.app_back_ground));
		background.setImageBitmap(bitmap);
	}

	private Bitmap mergeThumbnailBitmap(Bitmap backgrond) {
		// 以其中一张图片的大小作为画布的大小，或者也可以自己自定义
		Bitmap bitmap = Bitmap.createBitmap(backgrond.getWidth(),
				backgrond.getHeight(), backgrond.getConfig());
		Paint paint = new Paint();
		// 生成画布
		Canvas canvas = new Canvas(bitmap);
		Matrix matrix = new Matrix();
		canvas.drawBitmap(backgrond, matrix, paint);
		for (int i = 0; i < ids.length; i++) {
			Bitmap map = BitmapFactory.decodeResource(getResources(), ids[i]);
			matrix.reset();
			matrix.postScale(0.25f, 0.25f,0 ,0);
			int colum = i % 3;
			int raw = i / 3;
			matrix.postTranslate(25 + colum * 48, 25 + raw * 48);
			canvas.drawBitmap(map, matrix, paint);
		}
		return bitmap;
	}

	/*// 缩小图片
	private void SmallPicture() {
		Matrix matrix = new Matrix();
		// 缩放区间 0.5-1.0
		if (smallbig > 0.5f)
			smallbig = smallbig - 0.1f;
		else
			smallbig = 0.5f;
		// x y坐标同时缩放
		matrix.setScale(smallbig, smallbig, bmp.getWidth() / 2,
				bmp.getHeight() / 2);
		Bitmap createBmp = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(),
				bmp.getConfig());
		Canvas canvas = new Canvas(createBmp); // 画布 传入位图用于绘制
		Paint paint = new Paint(); // 画刷 改变颜色 对比度等属性
		canvas.drawBitmap(bmp, matrix, paint);
		imageCreate.setBackgroundColor(Color.RED);
		imageCreate.setImageBitmap(createBmp);
		textview2.setVisibility(View.VISIBLE);
	}*/
}
