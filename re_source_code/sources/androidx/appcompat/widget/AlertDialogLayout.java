package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialogLayout extends c0 {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void A(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private static int B(View view) {
        int iZ = androidx.core.view.u.z(view);
        if (iZ > 0) {
            return iZ;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return B(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean C(int i2, int i3) {
        int iCombineMeasuredStates;
        int iB;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == c.a.f.P) {
                    view = childAt;
                } else if (id == c.a.f.f2731k) {
                    view2 = childAt;
                } else {
                    if ((id != c.a.f.m && id != c.a.f.o) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i2, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i2, 0);
            iB = B(view2);
            measuredHeight = view2.getMeasuredHeight() - iB;
            paddingTop += iB;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iB = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i2, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i5 = size - paddingTop;
        if (view2 != null) {
            int i6 = paddingTop - iB;
            int iMin = Math.min(i5, measuredHeight);
            if (iMin > 0) {
                i5 -= iMin;
                iB += iMin;
            }
            view2.measure(i2, View.MeasureSpec.makeMeasureSpec(iB, 1073741824));
            paddingTop = i6 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i5 > 0) {
            view3.measure(i2, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i5, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt2 = getChildAt(i7);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i2, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i3, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        l(childCount, i3);
        return true;
    }

    private void l(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c0.a aVar = (c0.a) childAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i3, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i5;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00a8  */
    @Override // androidx.appcompat.widget.c0, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i10 = gravity & 112;
        int i11 = gravity & 8388615;
        int paddingTop = i10 != 16 ? i10 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - measuredHeight : getPaddingTop() + (((i5 - i3) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                c0.a aVar = (c0.a) childAt.getLayoutParams();
                int i13 = aVar.f495b;
                if (i13 < 0) {
                    i13 = i11;
                }
                int iB = androidx.core.view.d.b(i13, androidx.core.view.u.y(this)) & 7;
                if (iB != 1) {
                    if (iB != 5) {
                        i8 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    } else {
                        i6 = paddingRight - measuredWidth;
                        i7 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    }
                    if (t(i12)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i14 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    A(childAt, i8, i14, measuredWidth, measuredHeight2);
                    paddingTop = i14 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                } else {
                    i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                    i7 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                }
                i8 = i6 - i7;
                if (t(i12)) {
                    paddingTop += intrinsicHeight;
                }
                int i15 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                A(childAt, i8, i15, measuredWidth, measuredHeight2);
                paddingTop = i15 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            }
        }
    }

    @Override // androidx.appcompat.widget.c0, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (C(i2, i3)) {
            return;
        }
        super.onMeasure(i2, i3);
    }
}
