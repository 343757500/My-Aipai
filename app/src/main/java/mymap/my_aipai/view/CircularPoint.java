package mymap.my_aipai.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import mymap.my_aipai.R;


/**
 * 纯色园点
 * @author chenweiming
 *
 */
public class CircularPoint extends View {
	private int mColor = Color.parseColor("#09c700");
	private Paint p = new Paint();
	
	public CircularPoint(Context context) {
		this(context, null);
	}
	
	public CircularPoint(Context context, AttributeSet attrs){
		this(context, attrs, 0);
	}
	
	public CircularPoint(Context context, AttributeSet attr, int defStyle){
		 super(context, attr, defStyle);
		 TypedArray a = context.obtainStyledAttributes(attr, R.styleable.CircularPoint);
		 mColor = a.getColor(R.styleable.CircularPoint_circular_point_color, mColor);
		 a.recycle();
	}
	
	public void setColor(int color){
		mColor = color;
		invalidate();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		p.setColor(mColor);
		p.setAntiAlias(true);
		int width = getWidth();
		int height = getHeight();
		int radius = Math.min(width, height) >> 1;
		canvas.drawCircle(width >> 1, height >> 1, radius, p);
	}

}
