package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f414f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f415g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f416h;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f415g = -1;
        this.f416h = 0;
        int[] iArr = c.a.j.O0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        androidx.core.view.u.g0(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        this.f414f = typedArrayObtainStyledAttributes.getBoolean(c.a.j.P0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    private int a(int i2) {
        int childCount = getChildCount();
        while (i2 < childCount) {
            if (getChildAt(i2).getVisibility() == 0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private boolean b() {
        return getOrientation() == 1;
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View viewFindViewById = findViewById(c.a.f.G);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    @Override // android.view.View
    public int getMinimumHeight() {
        return Math.max(this.f416h, super.getMinimumHeight());
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int iMakeMeasureSpec;
        boolean z;
        int size = View.MeasureSpec.getSize(i2);
        int paddingBottom = 0;
        if (this.f414f) {
            if (size > this.f415g && b()) {
                setStacked(false);
            }
            this.f415g = size;
        }
        if (b() || View.MeasureSpec.getMode(i2) != 1073741824) {
            iMakeMeasureSpec = i2;
            z = false;
        } else {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(iMakeMeasureSpec, i3);
        if (this.f414f && !b()) {
            if ((getMeasuredWidthAndState() & (-16777216)) == 16777216) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i2, i3);
        }
        int iA = a(0);
        if (iA >= 0) {
            View childAt = getChildAt(iA);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin + 0;
            if (b()) {
                int iA2 = a(iA + 1);
                if (iA2 >= 0) {
                    paddingTop += getChildAt(iA2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                paddingBottom = paddingTop;
            } else {
                paddingBottom = paddingTop + getPaddingBottom();
            }
        }
        if (androidx.core.view.u.z(this) != paddingBottom) {
            setMinimumHeight(paddingBottom);
        }
    }

    public void setAllowStacking(boolean z) {
        if (this.f414f != z) {
            this.f414f = z;
            if (!z && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
