package com.example.centeredtoolbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;


/**
 * create by Rafael Claudino Garcia at 14/08/2019
 */
public class CenteredToolbar extends Toolbar {

    private View centeredView;
    private int fontFamily;

    public CenteredToolbar(Context context) {
        super(context);
    }

    public CenteredToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        checkFonts(attrs);
    }

    public CenteredToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        checkFonts(attrs);
    }

    @Override
    public void setLogo(Drawable drawable) {
        ImageView view = getImageView(drawable);
        setTitleView(view);
    }

    @Override
    public void setTitle(CharSequence title) {
        TextView view = getTextView();
        view.setText(title);
        setTitleView(view);
    }

    @Override
    public CharSequence getTitle() {
        return centeredView instanceof TextView ?
                ((TextView) centeredView).getText() : "";
    }

    @Override
    public void setTitleTextColor(int color) {
        if (centeredView instanceof TextView) {
            ((TextView) centeredView).setTextColor(color);
        }
    }

    @Override
    public void setNavigationIcon(@Nullable Drawable icon) {
        super.setNavigationIcon(icon);
        setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) CenteredToolbar.this.getContext()).onBackPressed();
            }
        });
    }

    private void checkFonts(@Nullable AttributeSet attributeSet) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.CenteredToolbar);

        if (typedArray != null) {
            fontFamily = typedArray.getResourceId(R.styleable.CenteredToolbar_titleFontFamily, 0);
            typedArray.recycle();
        }
    }

    private ImageView getImageView(Drawable drawable) {
        ImageView imageView = new ImageView(getContext());

        imageView.setImageDrawable(drawable);
        imageView.setAdjustViewBounds(true);
        imageView.setLayoutParams(getViewLayoutParams());

        imageView.setId(View.generateViewId());

        return imageView;
    }

    private TextView getTextView() {
        TextView textView = new TextView(getContext());

        textView.setId(View.generateViewId());

        textView.setTextSize(20F);
        textView.setLayoutParams(getViewLayoutParams());
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.END);

        if (fontFamily != 0) {
            textView.setTypeface(ResourcesCompat.getFont(getContext(), fontFamily));
        }

        return textView;
    }

    private LayoutParams getViewLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        return layoutParams;
    }

    public void setTitleView(View titleView) {
        if ((centeredView != null) && (findViewById(centeredView.getId()) != null)) {
            removeView(centeredView);
        }

        if (centeredView == null) {
            centeredView = titleView;
        }

        addView(centeredView);
    }
}
