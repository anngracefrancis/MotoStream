package cm.aptoide.pt.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: classes.dex */
public class CustomTextInputLayout extends TextInputLayout {
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new c.n.a.a.b();
    private boolean errorEnabled;
    private CharSequence helperText;
    private int helperTextAppearance;
    private ColorStateList helperTextColor;
    private boolean helperTextEnabled;
    private TextView helperView;

    public CustomTextInputLayout(Context context) {
        super(context);
        this.errorEnabled = false;
        this.helperTextEnabled = false;
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setErrorEnabled(boolean z) {
        if (this.errorEnabled == z) {
            return;
        }
        this.errorEnabled = z;
        if (z && this.helperTextEnabled) {
            setHelperTextEnabled(false);
        }
        super.setErrorEnabled(z);
        if (z || TextUtils.isEmpty(this.helperText)) {
            return;
        }
        setHelperText(this.helperText);
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setHelperText(CharSequence charSequence) {
        this.helperText = charSequence;
        if (!this.helperTextEnabled) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setHelperTextEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.helperView.setText(charSequence);
            this.helperView.setVisibility(0);
            androidx.core.view.u.l0(this.helperView, 0.0f);
            androidx.core.view.u.c(this.helperView).a(1.0f).d(200L).e(FAST_OUT_SLOW_IN_INTERPOLATOR).f(null).j();
        } else if (this.helperView.getVisibility() == 0) {
            androidx.core.view.u.c(this.helperView).a(0.0f).d(200L).e(FAST_OUT_SLOW_IN_INTERPOLATOR).f(new androidx.core.view.a0() { // from class: cm.aptoide.pt.view.CustomTextInputLayout.1
                @Override // androidx.core.view.a0, androidx.core.view.z
                public void onAnimationEnd(View view) {
                    CustomTextInputLayout.this.helperView.setText((CharSequence) null);
                    CustomTextInputLayout.this.helperView.setVisibility(4);
                }
            }).j();
        }
        sendAccessibilityEvent(RecyclerView.l.FLAG_MOVED);
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setHelperTextColor(ColorStateList colorStateList) {
        this.helperTextColor = colorStateList;
    }

    @Override // com.google.android.material.textfield.TextInputLayout
    public void setHelperTextEnabled(boolean z) {
        if (this.helperTextEnabled == z) {
            return;
        }
        if (z && this.errorEnabled) {
            setErrorEnabled(false);
        }
        if (this.helperTextEnabled != z) {
            if (z) {
                TextView textView = new TextView(getContext());
                this.helperView = textView;
                textView.setTextSize(2, 12.0f);
                this.helperView.setTextAppearance(getContext(), this.helperTextAppearance);
                ColorStateList colorStateList = this.helperTextColor;
                if (colorStateList != null) {
                    this.helperView.setTextColor(colorStateList);
                }
                this.helperView.setText(this.helperText);
                this.helperView.setVisibility(0);
                addView(this.helperView);
                if (this.helperView != null && getEditText() != null) {
                    androidx.core.view.u.w0(this.helperView, androidx.core.view.u.D(getEditText()), 0, androidx.core.view.u.C(getEditText()), getEditText().getPaddingBottom());
                }
            } else {
                removeView(this.helperView);
                this.helperView = null;
            }
            this.helperTextEnabled = z;
        }
    }

    public CustomTextInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.errorEnabled = false;
        this.helperTextEnabled = false;
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CustomTextInputLayout, 0, 0);
        try {
            this.helperTextColor = typedArrayObtainStyledAttributes.getColorStateList(1);
            this.helperText = typedArrayObtainStyledAttributes.getText(0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
