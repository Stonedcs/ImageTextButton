package com.stonex.imagetextbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dst on 2015/6/26.
 */
public class ImageTextButton extends LinearLayout {

    private Context mContext;
    private ImageView mImageView;
    private TextView mTextView;
    private LayoutParams mLayoutParams;

    private String mText;
    private Drawable mIcon;
    private float mTextSize;
    private Drawable mBackground;

    public ImageTextButton(Context context) {
        super(context);
    }

    public ImageTextButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ImageTextButton);
        mText = a.getString(R.styleable.ImageTextButton_text);
        mIcon = a.getDrawable(R.styleable.ImageTextButton_lefticon);
        mTextSize = a.getDimension(R.styleable.ImageTextButton_textsize, 16);
        a.recycle();

        this.mContext = context;

        init();

        mImageView = createImageView();
        mTextView = createTextView();

        mLayoutParams = createLayoutParams();

        addView(mImageView, mLayoutParams);
        addView(mTextView, mLayoutParams);
    }

    public ImageTextButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }

    private void init() {
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.CENTER);
        this.setClickable(true);
        this.setFocusable(true);
        if (this.getBackground() == null) {
            this.setBackgroundResource(R.drawable.itb_selecter);
        }
    }

    private ImageView createImageView() {
        int padding10 = getResources().getDimensionPixelSize(R.dimen.itb_padding_10);
        int padding20 = getResources().getDimensionPixelSize(R.dimen.itb_padding_20);
        ImageView imageView = new ImageView(mContext);
        imageView.setPadding(padding20, padding10, padding10, padding10);
        imageView.setImageDrawable(mIcon);
        return imageView;
    }

    private TextView createTextView() {
        int padding10 = getResources().getDimensionPixelSize(R.dimen.itb_padding_10);
        int padding20 = getResources().getDimensionPixelSize(R.dimen.itb_padding_20);
        TextView textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setLines(1);
        textView.setPadding(padding10, padding10, padding20, padding10);
        textView.setTextSize(mTextSize);
        textView.setText(mText);
        return textView;
    }

    private LayoutParams createLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        layoutParams.gravity = Gravity.CENTER;
        return layoutParams;
    }
}
