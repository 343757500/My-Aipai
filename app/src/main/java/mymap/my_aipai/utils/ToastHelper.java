/**   
* @Title: Toasthelper.java 
* @Package com.aipai.android.tools 
* @Description: (用一句话描述该文件做什么)
* @author spy
* @date 2015-3-15 上午11:21:55 
* @version V1.0   
*/
package mymap.my_aipai.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/** 
 * @ClassName: ToastHelper 
 * @Description: http://blog.csdn.net/zhangweiwtmdbf/article/details/30031015
 * @author spy
 * @date 2015-3-15 上午11:21:55 
 * @version V1.0 
 *  
 */
public class ToastHelper {
	public static final int LENGTH_LONG = 3500;
	public static final int LENGTH_SHORT = 2000;
	private WindowManager mWindowManager;
	private WindowManager.LayoutParams mWindowParams;
	private View toastView;
	private Context mContext;
	private Handler mHandler;
	private String mToastContent = "";
	private int duration = 0;
	private int animStyleId = android.R.style.Animation_Toast;

	private final Runnable timerRunnable = new Runnable() {

		@Override
		public void run() {
			removeView();
		}
	};

	private ToastHelper(Context context) {
		// Notice: we should get application context
		// otherwise we will get error
		// "Activity has leaked window that was originally added"
		Context ctx = context.getApplicationContext();
		if (ctx == null) {
			ctx = context;
		}
		this.mContext = ctx;
		mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
		init();
	}

	private void init() {
		mWindowParams = new WindowManager.LayoutParams();
		mWindowParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
				| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		mWindowParams.alpha = 1.0f;
		mWindowParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
		mWindowParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
		mWindowParams.gravity = Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM;
		mWindowParams.format = PixelFormat.TRANSLUCENT;
		mWindowParams.type = WindowManager.LayoutParams.TYPE_TOAST;
		mWindowParams.setTitle("ToastHelper");
		mWindowParams.packageName = mContext.getPackageName();
		mWindowParams.windowAnimations = animStyleId;//
		mWindowParams.y = mContext.getResources().getDisplayMetrics().widthPixels / 5;
	}

	@SuppressLint("NewApi")
	@SuppressWarnings("deprecation")
	private View getDefaultToastView() {

		TextView view = new TextView(mContext);
		view.setText(mToastContent);
		view.setGravity(Gravity.CENTER_VERTICAL | Gravity.START);
		view.setFocusable(false);
		view.setClickable(false);
		view.setFocusableInTouchMode(false);
		view.setTextColor(android.graphics.Color.WHITE);
		Drawable drawable = mContext.getResources().getDrawable(
				android.R.drawable.toast_frame);

		if (Build.VERSION.SDK_INT < 16) {
			view.setBackgroundDrawable(drawable);
		} else {
			view.setBackground(drawable);
		}
		return view;
	}

	public void show() {
		removeView();
		if (toastView == null) {
			toastView = getDefaultToastView();
		}
		mWindowParams.gravity = android.support.v4.view.GravityCompat
				.getAbsoluteGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM,
						android.support.v4.view.ViewCompat
								.getLayoutDirection(toastView));
		removeView();
		mWindowManager.addView(toastView, mWindowParams);
		if (mHandler == null) {
			mHandler = new Handler();
		}
		mHandler.postDelayed(timerRunnable, duration);
	}

	public void removeView() {
		if (toastView != null && toastView.getParent() != null) {
			mWindowManager.removeView(toastView);
			mHandler.removeCallbacks(timerRunnable);
		}
	}

	/**
	 * @param context
	 * @param content
	 * @param duration
	 * @return
	 */
	public static ToastHelper makeText(Context context, String content,
                                       int duration) {
		ToastHelper helper = new ToastHelper(context);
		helper.setDuration(duration);
		helper.setContent(content);
		return helper;
	}

	/**
	 * @param context
	 * @param strId
	 * @param duration
	 * @return
	 */
	public static ToastHelper makeText(Context context, int strId, int duration) {
		ToastHelper helper = new ToastHelper(context);
		helper.setDuration(duration);
		helper.setContent(context.getString(strId));
		return helper;
	}

	public ToastHelper setContent(String content) {
		this.mToastContent = content;
		return this;
	}

	public ToastHelper setDuration(int duration) {
		this.duration = duration;
		return this;
	}

	public ToastHelper setAnimation(int animStyleId) {
		this.animStyleId = animStyleId;
		mWindowParams.windowAnimations = this.animStyleId;
		return this;
	}

	/**
	 * custom view
	 * @param view
	 */
	public ToastHelper setView(View view) {
		this.toastView = view;
		return this;
	}
	
	
	
	public static void showToast(final Activity ct, final String msg) {
		try {
			if (ct.getWindow().getAttributes().softInputMode == WindowManager.LayoutParams.SOFT_INPUT_STATE_UNSPECIFIED) {
				ct.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						Toast mToast = Toast.makeText(ct, msg, Toast.LENGTH_SHORT);
						mToast.setGravity(Gravity.CENTER, 0, 0);
						mToast.show();
					}
				});
			}
			
			else if (null != ct.getWindow().peekDecorView()) {
				ct.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						Toast mToast = Toast.makeText(ct, msg, Toast.LENGTH_SHORT);
						mToast.setGravity(Gravity.CENTER, 0, 0);
						mToast.show();
					}
				});
			}
			
			else if (ct.getCurrentFocus() instanceof EditText) {
				ct.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						Toast mToast = Toast.makeText(ct, msg, Toast.LENGTH_SHORT);
						mToast.setGravity(Gravity.CENTER, 0, 0);
						mToast.show();
					}
				});
			}
			
			else {
				ct.runOnUiThread(new Runnable() {
					
					@Override
					public void run() {
						Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show();
					}
				});
			}
		} catch (Exception e) {
			Toast.makeText(ct, msg, Toast.LENGTH_SHORT).show();
		}
	}


}

