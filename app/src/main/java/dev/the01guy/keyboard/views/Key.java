package dev.the01guy.keyboard.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import dev.the01guy.keyboard.R;

public class Key extends View {
	private Paint paint;
	private DisplayMetrics displayMetrics;
	TypedArray keyAttributes;

	private String action_type;
	private boolean multiple_flag;
	private int width, height;

	// 1 => primary, 2 => secondary
	private int width_1, height_1;
	private int width_2, height_2;
	private String type_1, type_2;
	private String text_1, text_2;
	private Drawable image_1, image_2;
	private Rect rect_1 = new Rect(), rect_2  = new Rect();
	private Rect rect = new Rect();
	private int posX, posY;

	private String text = "";
	private Drawable drawable;
	private Bitmap bitmap;
	int cx, cy;

	public Key (Context context) {
		super(context);
		init (null);
	}

	public Key (Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init (attrs);
	}

	public Key (Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init (attrs);
	}

	private void init (@Nullable AttributeSet attrs) {
		this.keyAttributes = getContext().getTheme().obtainStyledAttributes (attrs, R.styleable.key, 0, 0);
		this.prepareKeyValues();
		this.setBackgroundResource (R.drawable.key_background);

		this.paint = new Paint();
		this.paint.setAntiAlias (true);
		this.paint.setDither (true);
		this.paint.setStyle (Paint.Style.FILL_AND_STROKE);
		this.paint.setStrokeJoin (Paint.Join.ROUND);
		this.paint.setStrokeCap (Paint.Cap.ROUND);
		this.paint.setStrokeWidth (64);

		// postInvalidate();
	}

	private void prepareKeyValues () {
		this.action_type = this.keyAttributes.getString (R.styleable.key_action_type);
		this.multiple_flag = this.keyAttributes.getBoolean (R.styleable.key_multiple_flag, false);

		this.type_1 = this.keyAttributes.getString (R.styleable.key_type_1);
		if (type_1 != null && this.type_1.equals ("image")) {
			this.image_1 = this.keyAttributes.getDrawable (R.styleable.key_source_1);
		} else if (type_1 != null && this.type_1.equals ("string")) {
			this.text_1 = this.keyAttributes.getString (R.styleable.key_source_1);
		}

		/*
		if (multiple_flag) {
			this.type_2 = this.keyAttributes.getString (R.styleable.key_type_2);

			if (type_2 != null && this.type_2.equals ("image")) {
				this.img_2 = BitmapFactory.decodeResource (getResources(), this.keyAttributes.getResourceId (R.styleable.key_source_2, 0));
			} else if (type_2 != null && this.type_2.equals ("string")) {
				this.text_2 = this.keyAttributes.getString (R.styleable.key_source_2);
			}
		}
		*/
	}

	@Override
	protected void onDraw (Canvas canvas) {
		super.onDraw (canvas);

		this.setDimensions();

		// primary box
		this.paint.setStrokeWidth (1);
		this.paint.setTextSize ((int) (this.getHeight() / 2));

		if (this.type_1.equals ("image")) {
			// canvas.drawBitmap (bitmap, null, this.rect_1, this.paint);
			this.image_1.setBounds (this.rect_1);
			this.image_1.draw (canvas);
		} else if (this.type_1.equals ("string")) {
			this.paint.getTextBounds (this.text_1, 0, this.text_1.length(), this.rect);
			Log.d ("rect", this.rect.flattenToString());

			int xPos = (this.getWidth() / 2);
			int yPos = (int) ((this.getHeight() / 2) - ((paint.descent() + paint.ascent()) / 2));
			canvas.drawText(this.text_1, xPos, yPos, paint);
		}
	}

	private void setDimensions() {
		this.width = this.getWidth();
		this.height = this.getHeight();

		if (this.multiple_flag) {
			this.width_1 = (int) (this.height * 0.6);
			this.height_1 = (int) (this.height * 0.6);
			this.width_2 = (int) (this.height * 0.4);
			this.height_2 = (int) (this.height * 0.4);
		} else {
			this.width_1 = this.width;
			this.height_1 = this.height;
			this.width_2 = 0;
			this.height_2 = 0;
		}

		int[] location = new int[2];
		this.getLocationOnScreen (location);
		this.posX = location [0];
		this.posY = location [1];

		this.rect_1.set (0, this.height_2, this.width_1, this.height_1);
		this.rect_2.set (this.posX, this.posY + this.height_2, this.posX + this.width_1, this.posY + this.height_1);
	}
}