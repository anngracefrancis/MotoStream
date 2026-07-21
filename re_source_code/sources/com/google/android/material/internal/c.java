package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.u;

/* JADX INFO: compiled from: FlowLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends ViewGroup {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18697g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f18698h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18699i;

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int a(int i2, int i3, int i4) {
        if (i3 != Integer.MIN_VALUE) {
            return i3 != 1073741824 ? i4 : i2;
        }
        return Math.min(i4, i2);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.e.b.c.l.a2, 0, 0);
        this.f18696f = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.e.b.c.l.c2, 0);
        this.f18697g = typedArrayObtainStyledAttributes.getDimensionPixelSize(e.e.b.c.l.b2, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public int b(View view) {
        Object tag = view.getTag(e.e.b.c.f.z);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean c() {
        return this.f18698h;
    }

    protected int getItemSpacing() {
        return this.f18697g;
    }

    protected int getLineSpacing() {
        return this.f18696f;
    }

    protected int getRowCount() {
        return this.f18699i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iA;
        int iB;
        if (getChildCount() == 0) {
            this.f18699i = 0;
            return;
        }
        this.f18699i = 1;
        boolean z2 = u.y(this) == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i6 = (i4 - i2) - paddingLeft;
        int measuredWidth = paddingRight;
        int i7 = paddingTop;
        for (int i8 = 0; i8 < getChildCount(); i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(e.e.b.c.f.z, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    iB = androidx.core.view.g.b(marginLayoutParams);
                    iA = androidx.core.view.g.a(marginLayoutParams);
                } else {
                    iA = 0;
                    iB = 0;
                }
                int measuredWidth2 = measuredWidth + iB + childAt.getMeasuredWidth();
                if (!this.f18698h && measuredWidth2 > i6) {
                    i7 = this.f18696f + paddingTop;
                    this.f18699i++;
                    measuredWidth = paddingRight;
                }
                childAt.setTag(e.e.b.c.f.z, Integer.valueOf(this.f18699i - 1));
                int i9 = measuredWidth + iB;
                int measuredWidth3 = childAt.getMeasuredWidth() + i9;
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                if (z2) {
                    childAt.layout(i6 - measuredWidth3, i7, (i6 - measuredWidth) - iB, measuredHeight);
                } else {
                    childAt.layout(i9, i7, measuredWidth3, measuredHeight);
                }
                measuredWidth += iB + iA + childAt.getMeasuredWidth() + this.f18697g;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int paddingLeft;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i6 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i6 - getPaddingRight();
        int i7 = paddingTop;
        int i8 = 0;
        for (int i9 = 0; i9 < getChildCount(); i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i4 = marginLayoutParams.leftMargin + 0;
                    i5 = marginLayoutParams.rightMargin + 0;
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                int i10 = paddingLeft2;
                if (paddingLeft2 + i4 + childAt.getMeasuredWidth() <= paddingRight || c()) {
                    paddingLeft = i10;
                } else {
                    paddingLeft = getPaddingLeft();
                    i7 = this.f18696f + paddingTop;
                }
                int measuredWidth = paddingLeft + i4 + childAt.getMeasuredWidth();
                int measuredHeight = i7 + childAt.getMeasuredHeight();
                if (measuredWidth > i8) {
                    i8 = measuredWidth;
                }
                paddingLeft2 = paddingLeft + i4 + i5 + childAt.getMeasuredWidth() + this.f18697g;
                if (i9 == getChildCount() - 1) {
                    i8 += i5;
                }
                paddingTop = measuredHeight;
            }
        }
        setMeasuredDimension(a(size, mode, i8 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    protected void setItemSpacing(int i2) {
        this.f18697g = i2;
    }

    protected void setLineSpacing(int i2) {
        this.f18696f = i2;
    }

    public void setSingleLine(boolean z) {
        this.f18698h = z;
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18698h = false;
        d(context, attributeSet);
    }
}
