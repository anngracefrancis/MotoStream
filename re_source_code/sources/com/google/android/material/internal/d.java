package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.c0;

/* JADX INFO: compiled from: ForegroundLinearLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends c0 {
    private Drawable u;
    private final Rect v;
    private final Rect w;
    private int x;
    protected boolean y;
    boolean z;

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.u;
        if (drawable != null) {
            if (this.z) {
                this.z = false;
                Rect rect = this.v;
                Rect rect2 = this.w;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.y) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.x, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f2, float f3) {
        super.drawableHotspotChanged(f2, f3);
        Drawable drawable = this.u;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.u;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.u.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.u;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.u;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.c0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.z = z | this.z;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.z = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.u;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.u);
            }
            this.u = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.x == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i2) {
        if (this.x != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.x = i2;
            if (i2 == 119 && this.u != null) {
                this.u.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.u;
    }

    public d(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.v = new Rect();
        this.w = new Rect();
        this.x = 119;
        this.y = true;
        this.z = false;
        TypedArray typedArrayH = j.h(context, attributeSet, e.e.b.c.l.f2, i2, 0, new int[0]);
        this.x = typedArrayH.getInt(e.e.b.c.l.h2, this.x);
        Drawable drawable = typedArrayH.getDrawable(e.e.b.c.l.g2);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.y = typedArrayH.getBoolean(e.e.b.c.l.i2, true);
        typedArrayH.recycle();
    }
}
