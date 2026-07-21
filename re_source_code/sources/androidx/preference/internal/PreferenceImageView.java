package androidx.preference.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.preference.t;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AppCompatCustomView"})
public class PreferenceImageView extends ImageView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1847g;

    public PreferenceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.ImageView
    public int getMaxHeight() {
        return this.f1847g;
    }

    @Override // android.widget.ImageView
    public int getMaxWidth() {
        return this.f1846f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int size = View.MeasureSpec.getSize(i2);
            int maxWidth = getMaxWidth();
            if (maxWidth != Integer.MAX_VALUE && (maxWidth < size || mode == 0)) {
                i2 = View.MeasureSpec.makeMeasureSpec(maxWidth, Integer.MIN_VALUE);
            }
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            int size2 = View.MeasureSpec.getSize(i3);
            int maxHeight = getMaxHeight();
            if (maxHeight != Integer.MAX_VALUE && (maxHeight < size2 || mode2 == 0)) {
                i3 = View.MeasureSpec.makeMeasureSpec(maxHeight, Integer.MIN_VALUE);
            }
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.ImageView
    public void setMaxHeight(int i2) {
        this.f1847g = i2;
        super.setMaxHeight(i2);
    }

    @Override // android.widget.ImageView
    public void setMaxWidth(int i2) {
        this.f1846f = i2;
        super.setMaxWidth(i2);
    }

    public PreferenceImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1846f = Integer.MAX_VALUE;
        this.f1847g = Integer.MAX_VALUE;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.k1, i2, 0);
        setMaxWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(t.m1, Integer.MAX_VALUE));
        setMaxHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(t.l1, Integer.MAX_VALUE));
        typedArrayObtainStyledAttributes.recycle();
    }
}
