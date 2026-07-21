package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: compiled from: LinearLayoutCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends ViewGroup {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f494k;
    private float l;
    private boolean m;
    private int[] n;
    private int[] o;
    private Drawable p;
    private int q;
    private int r;
    private int s;
    private int t;

    public c0(Context context) {
        this(context, null);
    }

    private void A(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    private void k(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewS = s(i4);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).width;
                    ((ViewGroup.MarginLayoutParams) aVar).width = viewS.getMeasuredWidth();
                    measureChildWithMargins(viewS, i3, 0, iMakeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).width = i5;
                }
            }
        }
    }

    private void l(int i2, int i3) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View viewS = s(i4);
            if (viewS.getVisibility() != 8) {
                a aVar = (a) viewS.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) aVar).width == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) aVar).height;
                    ((ViewGroup.MarginLayoutParams) aVar).height = viewS.getMeasuredHeight();
                    measureChildWithMargins(viewS, iMakeMeasureSpec, 0, i3, 0);
                    ((ViewGroup.MarginLayoutParams) aVar).height = i5;
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    void g(Canvas canvas) {
        int right;
        int left;
        int i2;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = w0.b(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View viewS = s(i3);
            if (viewS != null && viewS.getVisibility() != 8 && t(i3)) {
                a aVar = (a) viewS.getLayoutParams();
                j(canvas, zB ? viewS.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin : (viewS.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.q);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            if (viewS2 != null) {
                a aVar2 = (a) viewS2.getLayoutParams();
                if (zB) {
                    left = viewS2.getLeft() - ((ViewGroup.MarginLayoutParams) aVar2).leftMargin;
                    i2 = this.q;
                    right = left - i2;
                } else {
                    right = viewS2.getRight() + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.q;
                right = left - i2;
            }
            j(canvas, right);
        }
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.f490g < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.f490g;
        if (childCount <= i3) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i3);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f490g == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f491h;
        if (this.f492i == 1 && (i2 = this.f493j & 112) != 48) {
            if (i2 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f494k) / 2;
            } else if (i2 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f494k;
            }
        }
        return bottom + ((ViewGroup.MarginLayoutParams) ((a) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f490g;
    }

    public Drawable getDividerDrawable() {
        return this.p;
    }

    public int getDividerPadding() {
        return this.t;
    }

    public int getDividerWidth() {
        return this.q;
    }

    public int getGravity() {
        return this.f493j;
    }

    public int getOrientation() {
        return this.f492i;
    }

    public int getShowDividers() {
        return this.s;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.l;
    }

    void h(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View viewS = s(i2);
            if (viewS != null && viewS.getVisibility() != 8 && t(i2)) {
                i(canvas, (viewS.getTop() - ((ViewGroup.MarginLayoutParams) ((a) viewS.getLayoutParams())).topMargin) - this.r);
            }
        }
        if (t(virtualChildCount)) {
            View viewS2 = s(virtualChildCount - 1);
            i(canvas, viewS2 == null ? (getHeight() - getPaddingBottom()) - this.r : viewS2.getBottom() + ((ViewGroup.MarginLayoutParams) ((a) viewS2.getLayoutParams())).bottomMargin);
        }
    }

    void i(Canvas canvas, int i2) {
        this.p.setBounds(getPaddingLeft() + this.t, i2, (getWidth() - getPaddingRight()) - this.t, this.r + i2);
        this.p.draw(canvas);
    }

    void j(Canvas canvas, int i2) {
        this.p.setBounds(i2, getPaddingTop() + this.t, this.q + i2, (getHeight() - getPaddingBottom()) - this.t);
        this.p.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        int i2 = this.f492i;
        if (i2 == 0) {
            return new a(-2, -2);
        }
        if (i2 == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.p == null) {
            return;
        }
        if (this.f492i == 1) {
            h(canvas);
        } else {
            g(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.f492i == 1) {
            v(i2, i3, i4, i5);
        } else {
            u(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.f492i == 1) {
            z(i2, i3);
        } else {
            x(i2, i3);
        }
    }

    int p(View view, int i2) {
        return 0;
    }

    int q(View view) {
        return 0;
    }

    int r(View view) {
        return 0;
    }

    View s(int i2) {
        return getChildAt(i2);
    }

    public void setBaselineAligned(boolean z) {
        this.f489f = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.f490g = i2;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.p) {
            return;
        }
        this.p = drawable;
        if (drawable != null) {
            this.q = drawable.getIntrinsicWidth();
            this.r = drawable.getIntrinsicHeight();
        } else {
            this.q = 0;
            this.r = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i2) {
        this.t = i2;
    }

    public void setGravity(int i2) {
        if (this.f493j != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= 8388611;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f493j = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        int i4 = this.f493j;
        if ((8388615 & i4) != i3) {
            this.f493j = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.m = z;
    }

    public void setOrientation(int i2) {
        if (this.f492i != i2) {
            this.f492i = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.s) {
            requestLayout();
        }
        this.s = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.f493j;
        if ((i4 & 112) != i3) {
            this.f493j = i3 | (i4 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.l = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    protected boolean t(int i2) {
        if (i2 == 0) {
            return (this.s & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.s & 4) != 0;
        }
        if ((this.s & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:36:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:37:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:44:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f7  */
    void u(int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int i6;
        int i7;
        int i8;
        int baseline;
        int i9;
        int i10;
        int measuredHeight;
        boolean zB = w0.b(this);
        int paddingTop = getPaddingTop();
        int i11 = i5 - i3;
        int paddingBottom = i11 - getPaddingBottom();
        int paddingBottom2 = (i11 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i12 = this.f493j;
        int i13 = i12 & 112;
        boolean z = this.f489f;
        int[] iArr = this.n;
        int[] iArr2 = this.o;
        int iB = androidx.core.view.d.b(8388615 & i12, androidx.core.view.u.y(this));
        if (iB != 1) {
            paddingLeft = iB != 5 ? getPaddingLeft() : ((getPaddingLeft() + i4) - i2) - this.f494k;
        } else {
            paddingLeft = getPaddingLeft() + (((i4 - i2) - this.f494k) / 2);
        }
        if (zB) {
            i6 = virtualChildCount - 1;
            i7 = -1;
        } else {
            i6 = 0;
            i7 = 1;
        }
        int iP = 0;
        while (iP < virtualChildCount) {
            int i14 = i6 + (i7 * iP);
            View viewS = s(i14);
            if (viewS == null) {
                paddingLeft += y(i14);
            } else {
                if (viewS.getVisibility() != 8) {
                    int measuredWidth = viewS.getMeasuredWidth();
                    int measuredHeight2 = viewS.getMeasuredHeight();
                    a aVar = (a) viewS.getLayoutParams();
                    int i15 = iP;
                    if (z) {
                        i8 = virtualChildCount;
                        baseline = ((ViewGroup.MarginLayoutParams) aVar).height != -1 ? viewS.getBaseline() : -1;
                        i9 = aVar.f495b;
                        if (i9 < 0) {
                            i9 = i13;
                        }
                        i10 = i9 & 112;
                        if (i10 != 16) {
                            measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) aVar).topMargin) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        } else if (i10 != 48) {
                            measuredHeight = ((ViewGroup.MarginLayoutParams) aVar).topMargin + paddingTop;
                            if (baseline != -1) {
                                measuredHeight += iArr[1] - baseline;
                            }
                        } else if (i10 != 80) {
                            measuredHeight = paddingTop;
                        } else {
                            measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                            if (baseline != -1) {
                                measuredHeight -= iArr2[2] - (viewS.getMeasuredHeight() - baseline);
                            }
                        }
                        if (t(i14)) {
                            paddingLeft += this.q;
                        }
                        int i16 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                        A(viewS, i16 + q(viewS), measuredHeight, measuredWidth, measuredHeight2);
                        int iR = i16 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(viewS);
                        iP = i15 + p(viewS, i14);
                        paddingLeft = iR;
                    } else {
                        i8 = virtualChildCount;
                    }
                    i9 = aVar.f495b;
                    if (i9 < 0) {
                        i9 = i13;
                    }
                    i10 = i9 & 112;
                    if (i10 != 16) {
                        measuredHeight = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) aVar).topMargin) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                    } else if (i10 != 48) {
                        measuredHeight = ((ViewGroup.MarginLayoutParams) aVar).topMargin + paddingTop;
                        if (baseline != -1) {
                            measuredHeight += iArr[1] - baseline;
                        }
                    } else if (i10 != 80) {
                        measuredHeight = paddingTop;
                    } else {
                        measuredHeight = (paddingBottom - measuredHeight2) - ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        if (baseline != -1) {
                            measuredHeight -= iArr2[2] - (viewS.getMeasuredHeight() - baseline);
                        }
                    }
                    if (t(i14)) {
                        paddingLeft += this.q;
                    }
                    int i17 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    A(viewS, i17 + q(viewS), measuredHeight, measuredWidth, measuredHeight2);
                    int iR2 = i17 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(viewS);
                    iP = i15 + p(viewS, i14);
                    paddingLeft = iR2;
                }
                iP++;
                virtualChildCount = i8;
                i13 = i13;
                paddingTop = paddingTop;
            }
            i8 = virtualChildCount;
            iP++;
            virtualChildCount = i8;
            i13 = i13;
            paddingTop = paddingTop;
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x009f  */
    void v(int i2, int i3, int i4, int i5) {
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.f493j;
        int i11 = i10 & 112;
        int i12 = i10 & 8388615;
        if (i11 != 16) {
            paddingTop = i11 != 80 ? getPaddingTop() : ((getPaddingTop() + i5) - i3) - this.f494k;
        } else {
            paddingTop = getPaddingTop() + (((i5 - i3) - this.f494k) / 2);
        }
        int iP = 0;
        while (iP < virtualChildCount) {
            View viewS = s(iP);
            if (viewS == null) {
                paddingTop += y(iP);
            } else if (viewS.getVisibility() != 8) {
                int measuredWidth = viewS.getMeasuredWidth();
                int measuredHeight = viewS.getMeasuredHeight();
                a aVar = (a) viewS.getLayoutParams();
                int i13 = aVar.f495b;
                if (i13 < 0) {
                    i13 = i12;
                }
                int iB = androidx.core.view.d.b(i13, androidx.core.view.u.y(this)) & 7;
                if (iB != 1) {
                    if (iB != 5) {
                        i8 = ((ViewGroup.MarginLayoutParams) aVar).leftMargin + paddingLeft;
                    } else {
                        i6 = paddingRight - measuredWidth;
                        i7 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                    }
                    int i14 = i8;
                    if (t(iP)) {
                        paddingTop += this.r;
                    }
                    int i15 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                    A(viewS, i14, i15 + q(viewS), measuredWidth, measuredHeight);
                    int iR = i15 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(viewS);
                    iP += p(viewS, iP);
                    paddingTop = iR;
                } else {
                    i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
                    i7 = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                }
                i8 = i6 - i7;
                int i16 = i8;
                if (t(iP)) {
                    paddingTop += this.r;
                }
                int i17 = paddingTop + ((ViewGroup.MarginLayoutParams) aVar).topMargin;
                A(viewS, i16, i17 + q(viewS), measuredWidth, measuredHeight);
                int iR2 = i17 + measuredHeight + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(viewS);
                iP += p(viewS, iP);
                paddingTop = iR2;
            }
            iP++;
        }
    }

    void w(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* JADX WARN: Code duplicated, block: B:197:0x044d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0173  */
    /* JADX WARN: Code duplicated, block: B:67:0x0195  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d9  */
    void x(int i2, int i3) {
        int[] iArr;
        int i4;
        int iMax;
        int iMax2;
        int i5;
        int i6;
        int baseline;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        boolean z2;
        View view;
        int i11;
        boolean z3;
        int i12;
        int measuredHeight;
        int iP;
        int baseline2;
        int i13;
        this.f494k = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (this.n == null || this.o == null) {
            this.n = new int[4];
            this.o = new int[4];
        }
        int[] iArr2 = this.n;
        int[] iArr3 = this.o;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.f489f;
        boolean z5 = this.m;
        int i14 = 1073741824;
        boolean z6 = mode == 1073741824;
        float f2 = 0.0f;
        int iP2 = 0;
        int iMax3 = 0;
        int iMax4 = 0;
        int iMax5 = 0;
        int iMax6 = 0;
        boolean z7 = false;
        int iCombineMeasuredStates = 0;
        boolean z8 = true;
        boolean z9 = false;
        while (true) {
            iArr = iArr3;
            if (iP2 >= virtualChildCount) {
                break;
            }
            View viewS = s(iP2);
            if (viewS == null) {
                this.f494k += y(iP2);
            } else {
                if (viewS.getVisibility() == 8) {
                    iP2 += p(viewS, iP2);
                } else {
                    if (t(iP2)) {
                        this.f494k += this.q;
                    }
                    a aVar = (a) viewS.getLayoutParams();
                    float f3 = aVar.a;
                    float f4 = f2 + f3;
                    if (mode == i14 && ((ViewGroup.MarginLayoutParams) aVar).width == 0 && f3 > 0.0f) {
                        if (z6) {
                            this.f494k += ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                        } else {
                            int i15 = this.f494k;
                            this.f494k = Math.max(i15, ((ViewGroup.MarginLayoutParams) aVar).leftMargin + i15 + ((ViewGroup.MarginLayoutParams) aVar).rightMargin);
                        }
                        if (z4) {
                            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            viewS.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                            i10 = iP2;
                            z = z5;
                            z2 = z4;
                            view = viewS;
                        } else {
                            i10 = iP2;
                            z = z5;
                            z2 = z4;
                            view = viewS;
                            i11 = 1073741824;
                            z7 = true;
                        }
                        if (mode2 == i11 && ((ViewGroup.MarginLayoutParams) aVar).height == -1) {
                            z3 = true;
                            z9 = true;
                        } else {
                            z3 = false;
                        }
                        i12 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i12;
                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            i13 = aVar.f495b;
                            if (i13 < 0) {
                                i13 = this.f493j;
                            }
                            int i16 = (((i13 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i16] = Math.max(iArr2[i16], baseline2);
                            iArr[i16] = Math.max(iArr[i16], measuredHeight - baseline2);
                        }
                        iMax4 = Math.max(iMax4, measuredHeight);
                        if (z8 || ((ViewGroup.MarginLayoutParams) aVar).height != -1) {
                            z8 = false;
                        } else {
                            z8 = true;
                        }
                        if (aVar.a > 0.0f) {
                            if (!z3) {
                                i12 = measuredHeight;
                            }
                            iMax6 = Math.max(iMax6, i12);
                        } else {
                            int i17 = iMax6;
                            if (!z3) {
                                i12 = measuredHeight;
                            }
                            iMax5 = Math.max(iMax5, i12);
                            iMax6 = i17;
                        }
                        int i18 = i10;
                        iP = p(view, i18) + i18;
                        f2 = f4;
                    } else {
                        if (((ViewGroup.MarginLayoutParams) aVar).width != 0 || f3 <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar).width = -2;
                            i9 = 0;
                        }
                        i10 = iP2;
                        int i19 = i9;
                        z = z5;
                        z2 = z4;
                        w(viewS, i10, i2, f4 == 0.0f ? this.f494k : 0, i3, 0);
                        if (i19 != Integer.MIN_VALUE) {
                            ((ViewGroup.MarginLayoutParams) aVar).width = i19;
                        }
                        int measuredWidth = viewS.getMeasuredWidth();
                        if (z6) {
                            view = viewS;
                            this.f494k += ((ViewGroup.MarginLayoutParams) aVar).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view);
                        } else {
                            view = viewS;
                            int i20 = this.f494k;
                            this.f494k = Math.max(i20, i20 + measuredWidth + ((ViewGroup.MarginLayoutParams) aVar).leftMargin + ((ViewGroup.MarginLayoutParams) aVar).rightMargin + r(view));
                        }
                        if (z) {
                            iMax3 = Math.max(measuredWidth, iMax3);
                        }
                    }
                    i11 = 1073741824;
                    if (mode2 == i11) {
                        z3 = false;
                    } else {
                        z3 = false;
                    }
                    i12 = ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i12;
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view.getMeasuredState());
                    if (z2) {
                        i13 = aVar.f495b;
                        if (i13 < 0) {
                            i13 = this.f493j;
                        }
                        int i110 = (((i13 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i110] = Math.max(iArr2[i110], baseline2);
                        iArr[i110] = Math.max(iArr[i110], measuredHeight - baseline2);
                    }
                    iMax4 = Math.max(iMax4, measuredHeight);
                    if (z8) {
                        z8 = false;
                    } else {
                        z8 = false;
                    }
                    if (aVar.a > 0.0f) {
                        if (!z3) {
                            i12 = measuredHeight;
                        }
                        iMax6 = Math.max(iMax6, i12);
                    } else {
                        int i111 = iMax6;
                        if (!z3) {
                            i12 = measuredHeight;
                        }
                        iMax5 = Math.max(iMax5, i12);
                        iMax6 = i111;
                    }
                    int i112 = i10;
                    iP = p(view, i112) + i112;
                    f2 = f4;
                }
                iP2 = iP + 1;
                iArr3 = iArr;
                z5 = z;
                z4 = z2;
                i14 = 1073741824;
            }
            iP = iP2;
            z = z5;
            z2 = z4;
            iP2 = iP + 1;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            i14 = 1073741824;
        }
        boolean z10 = z5;
        boolean z11 = z4;
        int i21 = iMax4;
        int i22 = iMax5;
        int i23 = iMax6;
        int i24 = iCombineMeasuredStates;
        if (this.f494k > 0 && t(virtualChildCount)) {
            this.f494k += this.q;
        }
        int iMax7 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i21 : Math.max(i21, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        if (z10 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f494k = 0;
            int iP3 = 0;
            while (iP3 < virtualChildCount) {
                View viewS2 = s(iP3);
                if (viewS2 == null) {
                    this.f494k += y(iP3);
                } else if (viewS2.getVisibility() == 8) {
                    iP3 += p(viewS2, iP3);
                } else {
                    a aVar2 = (a) viewS2.getLayoutParams();
                    if (z6) {
                        this.f494k += ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + iMax3 + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(viewS2);
                    } else {
                        int i25 = this.f494k;
                        this.f494k = Math.max(i25, i25 + iMax3 + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin + r(viewS2));
                    }
                    iP3++;
                    iMax7 = iMax7;
                }
                iP3++;
                iMax7 = iMax7;
            }
        }
        int i26 = iMax7;
        int paddingLeft = this.f494k + getPaddingLeft() + getPaddingRight();
        this.f494k = paddingLeft;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, 0);
        int i27 = (16777215 & iResolveSizeAndState) - this.f494k;
        if (z7 || (i27 != 0 && f2 > 0.0f)) {
            float f5 = this.l;
            if (f5 > 0.0f) {
                f2 = f5;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f494k = 0;
            int i28 = i22;
            int iCombineMeasuredStates2 = i24;
            int iMax8 = -1;
            int i29 = 0;
            while (i29 < virtualChildCount) {
                View viewS3 = s(i29);
                if (viewS3 == null || viewS3.getVisibility() == 8) {
                    i5 = i27;
                    virtualChildCount = virtualChildCount;
                } else {
                    a aVar3 = (a) viewS3.getLayoutParams();
                    float f6 = aVar3.a;
                    if (f6 > 0.0f) {
                        int i30 = (int) ((i27 * f6) / f2);
                        float f7 = f2 - f6;
                        int i31 = i27 - i30;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin, ((ViewGroup.MarginLayoutParams) aVar3).height);
                        if (((ViewGroup.MarginLayoutParams) aVar3).width == 0) {
                            i8 = 1073741824;
                            if (mode == 1073741824) {
                                if (i30 <= 0) {
                                    i30 = 0;
                                }
                                viewS3.measure(View.MeasureSpec.makeMeasureSpec(i30, 1073741824), childMeasureSpec);
                            }
                            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewS3.getMeasuredState() & (-16777216));
                            f2 = f7;
                            i5 = i31;
                        } else {
                            i8 = 1073741824;
                        }
                        int measuredWidth2 = viewS3.getMeasuredWidth() + i30;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        viewS3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i8), childMeasureSpec);
                        iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, viewS3.getMeasuredState() & (-16777216));
                        f2 = f7;
                        i5 = i31;
                    } else {
                        i5 = i27;
                    }
                    if (z6) {
                        this.f494k += viewS3.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(viewS3);
                    } else {
                        int i32 = this.f494k;
                        this.f494k = Math.max(i32, viewS3.getMeasuredWidth() + i32 + ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin + r(viewS3));
                    }
                    boolean z12 = mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) aVar3).height == -1;
                    int i33 = ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin;
                    int measuredHeight2 = viewS3.getMeasuredHeight() + i33;
                    iMax8 = Math.max(iMax8, measuredHeight2);
                    if (!z12) {
                        i33 = measuredHeight2;
                    }
                    int iMax9 = Math.max(i28, i33);
                    if (z8) {
                        i6 = -1;
                        boolean z13 = ((ViewGroup.MarginLayoutParams) aVar3).height == -1;
                        if (z11 && (baseline = viewS3.getBaseline()) != i6) {
                            i7 = aVar3.f495b;
                            if (i7 < 0) {
                                i7 = this.f493j;
                            }
                            int i34 = (((i7 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i34] = Math.max(iArr2[i34], baseline);
                            iArr[i34] = Math.max(iArr[i34], measuredHeight2 - baseline);
                        }
                        z8 = z13;
                        i28 = iMax9;
                        f2 = f2;
                    } else {
                        i6 = -1;
                    }
                    if (z11) {
                        i7 = aVar3.f495b;
                        if (i7 < 0) {
                            i7 = this.f493j;
                        }
                        int i35 = (((i7 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i35] = Math.max(iArr2[i35], baseline);
                        iArr[i35] = Math.max(iArr[i35], measuredHeight2 - baseline);
                    }
                    z8 = z13;
                    i28 = iMax9;
                    f2 = f2;
                }
                i29++;
                i27 = i5;
                virtualChildCount = virtualChildCount;
            }
            i4 = virtualChildCount;
            this.f494k += getPaddingLeft() + getPaddingRight();
            iMax = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax8 : Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            iMax2 = i28;
            i24 = iCombineMeasuredStates2;
        } else {
            iMax2 = Math.max(i22, i23);
            if (z10 && mode != 1073741824) {
                for (int i36 = 0; i36 < virtualChildCount; i36++) {
                    View viewS4 = s(i36);
                    if (viewS4 != null && viewS4.getVisibility() != 8 && ((a) viewS4.getLayoutParams()).a > 0.0f) {
                        viewS4.measure(View.MeasureSpec.makeMeasureSpec(iMax3, 1073741824), View.MeasureSpec.makeMeasureSpec(viewS4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = virtualChildCount;
            iMax = i26;
        }
        if (z8 || mode2 == 1073741824) {
            iMax2 = iMax;
        }
        setMeasuredDimension(iResolveSizeAndState | (i24 & (-16777216)), View.resolveSizeAndState(Math.max(iMax2 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, i24 << 16));
        if (z9) {
            k(i4, i2);
        }
    }

    int y(int i2) {
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:150:0x0323  */
    /* JADX WARN: Code duplicated, block: B:156:0x0330  */
    void z(int i2, int i3) {
        int i4;
        int iCombineMeasuredStates;
        int iMax;
        int i5;
        int i6;
        int i7;
        boolean z;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        View view;
        int iMax2;
        boolean z3;
        int iMax3;
        this.f494k = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i17 = this.f490g;
        boolean z4 = this.m;
        float f2 = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int iMax4 = 0;
        int i21 = 0;
        int iP = 0;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        while (true) {
            int i22 = 8;
            int i23 = iMax4;
            if (iP >= virtualChildCount) {
                int i24 = i18;
                int i25 = i20;
                int i26 = i21;
                int i27 = virtualChildCount;
                int i28 = mode2;
                int iMax5 = i19;
                if (this.f494k > 0) {
                    i4 = i27;
                    if (t(i4)) {
                        this.f494k += this.r;
                    }
                } else {
                    i4 = i27;
                }
                if (z4 && (i28 == Integer.MIN_VALUE || i28 == 0)) {
                    this.f494k = 0;
                    int iP2 = 0;
                    while (iP2 < i4) {
                        View viewS = s(iP2);
                        if (viewS == null) {
                            this.f494k += y(iP2);
                        } else if (viewS.getVisibility() == i22) {
                            iP2 += p(viewS, iP2);
                        } else {
                            a aVar = (a) viewS.getLayoutParams();
                            int i29 = this.f494k;
                            this.f494k = Math.max(i29, i29 + i25 + ((ViewGroup.MarginLayoutParams) aVar).topMargin + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin + r(viewS));
                        }
                        iP2++;
                        i22 = 8;
                    }
                }
                int paddingTop = this.f494k + getPaddingTop() + getPaddingBottom();
                this.f494k = paddingTop;
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, 0);
                int i30 = (16777215 & iResolveSizeAndState) - this.f494k;
                if (z5 || (i30 != 0 && f2 > 0.0f)) {
                    float f3 = this.l;
                    if (f3 > 0.0f) {
                        f2 = f3;
                    }
                    this.f494k = 0;
                    int i31 = i30;
                    int i32 = i26;
                    iCombineMeasuredStates = i24;
                    int i33 = 0;
                    while (i33 < i4) {
                        View viewS2 = s(i33);
                        if (viewS2.getVisibility() == 8) {
                            i5 = i31;
                        } else {
                            a aVar2 = (a) viewS2.getLayoutParams();
                            float f4 = aVar2.a;
                            if (f4 > 0.0f) {
                                int i34 = (int) ((i31 * f4) / f2);
                                float f5 = f2 - f4;
                                i5 = i31 - i34;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin, ((ViewGroup.MarginLayoutParams) aVar2).width);
                                if (((ViewGroup.MarginLayoutParams) aVar2).height == 0) {
                                    i8 = 1073741824;
                                    if (i28 == 1073741824) {
                                        if (i34 <= 0) {
                                            i34 = 0;
                                        }
                                        viewS2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i34, 1073741824));
                                    }
                                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS2.getMeasuredState() & (-256));
                                    f2 = f5;
                                } else {
                                    i8 = 1073741824;
                                }
                                int measuredHeight = viewS2.getMeasuredHeight() + i34;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                viewS2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i8));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewS2.getMeasuredState() & (-256));
                                f2 = f5;
                            } else {
                                i5 = i31;
                            }
                            int i35 = ((ViewGroup.MarginLayoutParams) aVar2).leftMargin + ((ViewGroup.MarginLayoutParams) aVar2).rightMargin;
                            int measuredWidth = viewS2.getMeasuredWidth() + i35;
                            iMax5 = Math.max(iMax5, measuredWidth);
                            float f6 = f2;
                            if (mode != 1073741824) {
                                i6 = iCombineMeasuredStates;
                                i7 = -1;
                                z = ((ViewGroup.MarginLayoutParams) aVar2).width == -1;
                                if (!z) {
                                    i35 = measuredWidth;
                                }
                                int iMax6 = Math.max(i32, i35);
                                if (z6 || ((ViewGroup.MarginLayoutParams) aVar2).width != i7) {
                                    z2 = false;
                                } else {
                                    z2 = true;
                                }
                                int i36 = this.f494k;
                                this.f494k = Math.max(i36, viewS2.getMeasuredHeight() + i36 + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin + r(viewS2));
                                z6 = z2;
                                iCombineMeasuredStates = i6;
                                i32 = iMax6;
                                f2 = f6;
                            } else {
                                i6 = iCombineMeasuredStates;
                                i7 = -1;
                            }
                            if (!z) {
                                i35 = measuredWidth;
                            }
                            int iMax7 = Math.max(i32, i35);
                            if (z6) {
                                z2 = false;
                            } else {
                                z2 = false;
                            }
                            int i37 = this.f494k;
                            this.f494k = Math.max(i37, viewS2.getMeasuredHeight() + i37 + ((ViewGroup.MarginLayoutParams) aVar2).topMargin + ((ViewGroup.MarginLayoutParams) aVar2).bottomMargin + r(viewS2));
                            z6 = z2;
                            iCombineMeasuredStates = i6;
                            i32 = iMax7;
                            f2 = f6;
                        }
                        i33++;
                        i31 = i5;
                    }
                    this.f494k += getPaddingTop() + getPaddingBottom();
                    iMax = i32;
                } else {
                    iMax = Math.max(i26, i23);
                    if (z4 && i28 != 1073741824) {
                        for (int i38 = 0; i38 < i4; i38++) {
                            View viewS3 = s(i38);
                            if (viewS3 != null && viewS3.getVisibility() != 8 && ((a) viewS3.getLayoutParams()).a > 0.0f) {
                                viewS3.measure(View.MeasureSpec.makeMeasureSpec(viewS3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i25, 1073741824));
                            }
                        }
                    }
                    iCombineMeasuredStates = i24;
                }
                if (z6 || mode == 1073741824) {
                    iMax = iMax5;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, iCombineMeasuredStates), iResolveSizeAndState);
                if (z7) {
                    l(i4, i3);
                    return;
                }
                return;
            }
            View viewS4 = s(iP);
            if (viewS4 == null) {
                this.f494k += y(iP);
                i12 = virtualChildCount;
                i13 = mode2;
                iMax4 = i23;
            } else {
                int i39 = i18;
                if (viewS4.getVisibility() == 8) {
                    iP += p(viewS4, iP);
                    i12 = virtualChildCount;
                    iMax4 = i23;
                    i18 = i39;
                    i13 = mode2;
                } else {
                    if (t(iP)) {
                        this.f494k += this.r;
                    }
                    a aVar3 = (a) viewS4.getLayoutParams();
                    float f7 = aVar3.a;
                    float f8 = f2 + f7;
                    if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) aVar3).height == 0 && f7 > 0.0f) {
                        int i40 = this.f494k;
                        this.f494k = Math.max(i40, ((ViewGroup.MarginLayoutParams) aVar3).topMargin + i40 + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin);
                        iMax2 = i20;
                        view = viewS4;
                        i15 = i21;
                        i10 = i39;
                        i11 = i19;
                        z5 = true;
                        i12 = virtualChildCount;
                        i13 = mode2;
                        i14 = i23;
                        i16 = iP;
                    } else {
                        int i41 = i19;
                        if (((ViewGroup.MarginLayoutParams) aVar3).height != 0 || f7 <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = -2;
                            i9 = 0;
                        }
                        i10 = i39;
                        int i42 = i9;
                        i11 = i41;
                        int i43 = i20;
                        i12 = virtualChildCount;
                        i13 = mode2;
                        i14 = i23;
                        i15 = i21;
                        i16 = iP;
                        w(viewS4, iP, i2, 0, i3, f8 == 0.0f ? this.f494k : 0);
                        if (i42 != Integer.MIN_VALUE) {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = i42;
                        }
                        int measuredHeight2 = viewS4.getMeasuredHeight();
                        int i44 = this.f494k;
                        view = viewS4;
                        this.f494k = Math.max(i44, i44 + measuredHeight2 + ((ViewGroup.MarginLayoutParams) aVar3).topMargin + ((ViewGroup.MarginLayoutParams) aVar3).bottomMargin + r(view));
                        iMax2 = z4 ? Math.max(measuredHeight2, i43) : i43;
                    }
                    if (i17 >= 0 && i17 == i16 + 1) {
                        this.f491h = this.f494k;
                    }
                    if (i16 < i17 && aVar3.a > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((ViewGroup.MarginLayoutParams) aVar3).width != -1) {
                        z3 = false;
                    } else {
                        z3 = true;
                        z7 = true;
                    }
                    int i45 = ((ViewGroup.MarginLayoutParams) aVar3).leftMargin + ((ViewGroup.MarginLayoutParams) aVar3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i45;
                    int iMax8 = Math.max(i11, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i10, view.getMeasuredState());
                    z6 = z6 && ((ViewGroup.MarginLayoutParams) aVar3).width == -1;
                    if (aVar3.a > 0.0f) {
                        if (!z3) {
                            i45 = measuredWidth2;
                        }
                        iMax4 = Math.max(i14, i45);
                        iMax3 = i15;
                    } else {
                        if (!z3) {
                            i45 = measuredWidth2;
                        }
                        iMax3 = Math.max(i15, i45);
                        iMax4 = i14;
                    }
                    int iP3 = p(view, i16) + i16;
                    i20 = iMax2;
                    f2 = f8;
                    i21 = iMax3;
                    i18 = iCombineMeasuredStates2;
                    iP = iP3;
                    i19 = iMax8;
                }
            }
            iP++;
            mode2 = i13;
            virtualChildCount = i12;
        }
    }

    public c0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c0(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f489f = true;
        this.f490g = -1;
        this.f491h = 0;
        this.f493j = 8388659;
        int[] iArr = c.a.j.b1;
        q0 q0VarV = q0.v(context, attributeSet, iArr, i2, 0);
        androidx.core.view.u.g0(this, context, iArr, attributeSet, q0VarV.r(), i2, 0);
        int iK = q0VarV.k(c.a.j.d1, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = q0VarV.k(c.a.j.c1, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = q0VarV.a(c.a.j.e1, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.l = q0VarV.i(c.a.j.g1, -1.0f);
        this.f490g = q0VarV.k(c.a.j.f1, -1);
        this.m = q0VarV.a(c.a.j.j1, false);
        setDividerDrawable(q0VarV.g(c.a.j.h1));
        this.s = q0VarV.k(c.a.j.k1, 0);
        this.t = q0VarV.f(c.a.j.i1, 0);
        q0VarV.w();
    }

    /* JADX INFO: compiled from: LinearLayoutCompat.java */
    public static class a extends ViewGroup.MarginLayoutParams {
        public float a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f495b;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f495b = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.l1);
            this.a = typedArrayObtainStyledAttributes.getFloat(c.a.j.n1, 0.0f);
            this.f495b = typedArrayObtainStyledAttributes.getInt(c.a.j.m1, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(int i2, int i3) {
            super(i2, i3);
            this.f495b = -1;
            this.a = 0.0f;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f495b = -1;
        }
    }
}
