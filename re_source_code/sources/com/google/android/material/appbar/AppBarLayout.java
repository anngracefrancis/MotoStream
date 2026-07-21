package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.c0;
import androidx.core.view.d0.f;
import androidx.core.view.j;
import androidx.core.view.p;
import androidx.core.view.u;
import androidx.customview.view.AbsSavedState;
import e.e.b.c.a0.g;
import e.e.b.c.a0.h;
import e.e.b.c.k;
import e.e.b.c.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f18358f = k.f21035g;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f18362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18363k;
    private int l;
    private c0 m;
    private List<c> n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private int s;
    private WeakReference<View> t;
    private ValueAnimator u;
    private int[] v;
    private Drawable w;

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ int E() {
            return super.E();
        }

        @Override // com.google.android.material.appbar.c
        public /* bridge */ /* synthetic */ boolean G(int i2) {
            return super.G(i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: g0 */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2) {
            return super.l(coordinatorLayout, appBarLayout, i2);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: h0 */
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i2, int i3, int i4, int i5) {
            return super.m(coordinatorLayout, appBarLayout, i2, i3, i4, i5);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: i0 */
        public /* bridge */ /* synthetic */ void q(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int[] iArr, int i4) {
            super.q(coordinatorLayout, appBarLayout, view, i2, i3, iArr, i4);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: j0 */
        public /* bridge */ /* synthetic */ void t(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            super.t(coordinatorLayout, appBarLayout, view, i2, i3, i4, i5, i6, iArr);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: k0 */
        public /* bridge */ /* synthetic */ void x(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            super.x(coordinatorLayout, appBarLayout, parcelable);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: l0 */
        public /* bridge */ /* synthetic */ Parcelable y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            return super.y(coordinatorLayout, appBarLayout);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: m0 */
        public /* bridge */ /* synthetic */ boolean A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i2, int i3) {
            return super.A(coordinatorLayout, appBarLayout, view, view2, i2, i3);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.BaseBehavior
        /* JADX INFO: renamed from: n0 */
        public /* bridge */ /* synthetic */ void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
            super.C(coordinatorLayout, appBarLayout, view, i2);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        private static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                return ((BaseBehavior) cVarF).M();
            }
            return 0;
        }

        private void S(View view, View view2) {
            CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (cVarF instanceof BaseBehavior) {
                u.U(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) cVarF).f18364k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.l()) {
                    appBarLayout.u(appBarLayout.w(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        float J(View view) {
            int i2;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int iR = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + iR > downNestedPreScrollRange) && (i2 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (iR / i2) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.b
        int L(View view) {
            return view instanceof AppBarLayout ? ((AppBarLayout) view).getTotalScrollRange() : super.L(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.b
        /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
        public AppBarLayout H(List<View> list) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = list.get(i2);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                u.c0(coordinatorLayout, androidx.core.view.d0.c.a.m.b());
                u.c0(coordinatorLayout, androidx.core.view.d0.c.a.n.b());
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, View view, int i2) {
            return super.l(coordinatorLayout, view, i2);
        }

        @Override // com.google.android.material.appbar.b, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ boolean m(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int i5) {
            return super.m(coordinatorLayout, view, i2, i3, i4, i5);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout appBarLayoutH = H(coordinatorLayout.r(view));
            if (appBarLayoutH != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f18395d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    appBarLayoutH.r(false, !z);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.Q3);
            O(typedArrayObtainStyledAttributes.getDimensionPixelSize(l.R3, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements p {
        a() {
        }

        @Override // androidx.core.view.p
        public c0 a(View view, c0 c0Var) {
            return AppBarLayout.this.n(c0Var);
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ g a;

        b(g gVar) {
            this.a = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.W(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public interface c<T extends AppBarLayout> {
        void onOffsetChanged(T t, int i2);
    }

    public interface e extends c<AppBarLayout> {
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.a);
    }

    private void c() {
        WeakReference<View> weakReference = this.t;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.t = null;
    }

    private View d(View view) {
        int i2;
        if (this.t == null && (i2 = this.s) != -1) {
            View viewFindViewById = view != null ? view.findViewById(i2) : null;
            if (viewFindViewById == null && (getParent() instanceof ViewGroup)) {
                viewFindViewById = ((ViewGroup) getParent()).findViewById(this.s);
            }
            if (viewFindViewById != null) {
                this.t = new WeakReference<>(viewFindViewById);
            }
        }
        WeakReference<View> weakReference = this.t;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean i() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (((d) getChildAt(i2).getLayoutParams()).c()) {
                return true;
            }
        }
        return false;
    }

    private void k() {
        this.f18360h = -1;
        this.f18361i = -1;
        this.f18362j = -1;
    }

    private void s(boolean z, boolean z2, boolean z3) {
        this.l = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    private boolean t(boolean z) {
        if (this.p == z) {
            return false;
        }
        this.p = z;
        refreshDrawableState();
        return true;
    }

    private boolean v() {
        return this.w != null && getTopInset() > 0;
    }

    private boolean x() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return (childAt.getVisibility() == 8 || u.v(childAt)) ? false : true;
    }

    private void y(g gVar, boolean z) {
        float dimension = getResources().getDimension(e.e.b.c.d.a);
        float f2 = z ? 0.0f : dimension;
        if (!z) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f2, dimension);
        this.u = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(getResources().getInteger(e.e.b.c.g.a));
        this.u.setInterpolator(e.e.b.c.m.a.a);
        this.u.addUpdateListener(new b(gVar));
        this.u.start();
    }

    private void z() {
        setWillNotDraw(!v());
    }

    public void a(c cVar) {
        if (this.n == null) {
            this.n = new ArrayList();
        }
        if (cVar == null || this.n.contains(cVar)) {
            return;
        }
        this.n.add(cVar);
    }

    public void b(e eVar) {
        a(eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (v()) {
            int iSave = canvas.save();
            canvas.translate(0.0f, -this.f18359g);
            this.w.draw(canvas);
            canvas.restoreToCount(iSave);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.w;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d generateDefaultLayoutParams() {
        return new d(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public d generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT < 19 || !(layoutParams instanceof LinearLayout.LayoutParams)) {
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new d((ViewGroup.MarginLayoutParams) layoutParams) : new d(layoutParams);
        }
        return new d((LinearLayout.LayoutParams) layoutParams);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        int iMin;
        int iZ;
        int i2 = this.f18361i;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = dVar.a;
            if ((i4 & 5) != 5) {
                if (i3 > 0) {
                    break;
                }
            } else {
                int i5 = ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                if ((i4 & 8) != 0) {
                    iZ = u.z(childAt);
                } else {
                    if ((i4 & 2) != 0) {
                        iZ = measuredHeight - u.z(childAt);
                    } else {
                        iMin = i5 + measuredHeight;
                    }
                    if (childCount == 0 && u.v(childAt)) {
                        iMin = Math.min(iMin, measuredHeight - getTopInset());
                    }
                    i3 += iMin;
                }
                iMin = i5 + iZ;
                if (childCount == 0) {
                    iMin = Math.min(iMin, measuredHeight - getTopInset());
                }
                i3 += iMin;
            }
        }
        int iMax = Math.max(0, i3);
        this.f18361i = iMax;
        return iMax;
    }

    int getDownNestedScrollRange() {
        int i2 = this.f18362j;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int iZ = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
            int i4 = dVar.a;
            if ((i4 & 1) == 0) {
                break;
            }
            iZ += measuredHeight;
            if ((i4 & 2) != 0) {
                iZ -= u.z(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iZ);
        this.f18362j = iMax;
        return iMax;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.s;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int iZ = u.z(this);
        if (iZ == 0) {
            int childCount = getChildCount();
            iZ = childCount >= 1 ? u.z(getChildAt(childCount - 1)) : 0;
            if (iZ == 0) {
                return getHeight() / 3;
            }
        }
        return (iZ * 2) + topInset;
    }

    int getPendingAction() {
        return this.l;
    }

    public Drawable getStatusBarForeground() {
        return this.w;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        c0 c0Var = this.m;
        if (c0Var != null) {
            return c0Var.k();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i2 = this.f18360h;
        if (i2 != -1) {
            return i2;
        }
        int childCount = getChildCount();
        int iZ = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            d dVar = (d) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = dVar.a;
            if ((i4 & 1) == 0) {
                break;
            }
            iZ += measuredHeight + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
            if (i3 == 0 && u.v(childAt)) {
                iZ -= getTopInset();
            }
            if ((i4 & 2) != 0) {
                iZ -= u.z(childAt);
                break;
            }
        }
        int iMax = Math.max(0, iZ);
        this.f18360h = iMax;
        return iMax;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    boolean h() {
        return this.f18363k;
    }

    boolean j() {
        return getTotalScrollRange() != 0;
    }

    public boolean l() {
        return this.r;
    }

    void m(int i2) {
        this.f18359g = i2;
        if (!willNotDraw()) {
            u.Z(this);
        }
        List<c> list = this.n;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = this.n.get(i3);
                if (cVar != null) {
                    cVar.onOffsetChanged(this, i2);
                }
            }
        }
    }

    c0 n(c0 c0Var) {
        c0 c0Var2 = u.v(this) ? c0Var : null;
        if (!c.i.j.d.a(this.m, c0Var2)) {
            this.m = c0Var2;
            z();
            requestLayout();
        }
        return c0Var;
    }

    public void o(c cVar) {
        List<c> list = this.n;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i2) {
        if (this.v == null) {
            this.v = new int[4];
        }
        int[] iArr = this.v;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + iArr.length);
        boolean z = this.p;
        int i3 = e.e.b.c.b.F;
        if (!z) {
            i3 = -i3;
        }
        iArr[0] = i3;
        iArr[1] = (z && this.q) ? e.e.b.c.b.G : -e.e.b.c.b.G;
        int i4 = e.e.b.c.b.D;
        if (!z) {
            i4 = -i4;
        }
        iArr[2] = i4;
        iArr[3] = (z && this.q) ? e.e.b.c.b.C : -e.e.b.c.b.C;
        return LinearLayout.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        boolean z2 = true;
        if (u.v(this) && x()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                u.U(getChildAt(childCount), topInset);
            }
        }
        k();
        this.f18363k = false;
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            if (((d) getChildAt(i6).getLayoutParams()).b() != null) {
                this.f18363k = true;
                break;
            }
        }
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.o) {
            return;
        }
        if (!this.r && !i()) {
            z2 = false;
        }
        t(z2);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824 && u.v(this) && x()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = c.i.g.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i3));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        k();
    }

    public void p(e eVar) {
        o(eVar);
    }

    void q() {
        this.l = 0;
    }

    public void r(boolean z, boolean z2) {
        s(z, z2, true);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        h.d(this, f2);
    }

    public void setExpanded(boolean z) {
        r(z, u.O(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.r = z;
    }

    public void setLiftOnScrollTargetViewId(int i2) {
        this.s = i2;
        c();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i2) {
        if (i2 != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i2);
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.w;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.w = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.w.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.w, u.y(this));
                this.w.setVisible(getVisibility() == 0, false);
                this.w.setCallback(this);
            }
            z();
            u.Z(this);
        }
    }

    public void setStatusBarForegroundColor(int i2) {
        setStatusBarForeground(new ColorDrawable(i2));
    }

    public void setStatusBarForegroundResource(int i2) {
        setStatusBarForeground(c.a.k.a.a.d(getContext(), i2));
    }

    @Deprecated
    public void setTargetElevation(float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.e.b(this, f2);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    boolean u(boolean z) {
        if (this.q == z) {
            return false;
        }
        this.q = z;
        refreshDrawableState();
        if (!this.r || !(getBackground() instanceof g)) {
            return true;
        }
        y((g) getBackground(), z);
        return true;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.w;
    }

    boolean w(View view) {
        View viewD = d(view);
        if (viewD != null) {
            view = viewD;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    protected static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f18364k;
        private int l;
        private ValueAnimator m;
        private int n;
        private boolean o;
        private float p;
        private WeakReference<View> q;
        private d r;

        class a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ CoordinatorLayout a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f18368b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.a = coordinatorLayout;
                this.f18368b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.a, this.f18368b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        class b implements f {
            final /* synthetic */ CoordinatorLayout a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ AppBarLayout f18370b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ View f18371c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ int f18372d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i2) {
                this.a = coordinatorLayout;
                this.f18370b = appBarLayout;
                this.f18371c = view;
                this.f18372d = i2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // androidx.core.view.d0.f
            public boolean a(View view, f.a aVar) {
                BaseBehavior.this.q(this.a, this.f18370b, this.f18371c, 0, this.f18372d, new int[]{0, 0}, 1);
                return true;
            }
        }

        class c implements f {
            final /* synthetic */ AppBarLayout a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ boolean f18374b;

            c(AppBarLayout appBarLayout, boolean z) {
                this.a = appBarLayout;
                this.f18374b = z;
            }

            @Override // androidx.core.view.d0.f
            public boolean a(View view, f.a aVar) {
                this.a.setExpanded(this.f18374b);
                return true;
            }
        }

        public static abstract class d<T extends AppBarLayout> {
        }

        public BaseBehavior() {
            this.n = -1;
        }

        private void S(CoordinatorLayout coordinatorLayout, T t, View view) {
            if (M() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
                T(coordinatorLayout, t, androidx.core.view.d0.c.a.m, false);
            }
            if (M() != 0) {
                if (!view.canScrollVertically(-1)) {
                    T(coordinatorLayout, t, androidx.core.view.d0.c.a.n, true);
                    return;
                }
                int i2 = -t.getDownNestedPreScrollRange();
                if (i2 != 0) {
                    u.e0(coordinatorLayout, androidx.core.view.d0.c.a.n, null, new b(coordinatorLayout, t, view, i2));
                }
            }
        }

        private void T(CoordinatorLayout coordinatorLayout, T t, androidx.core.view.d0.c.a aVar, boolean z) {
            u.e0(coordinatorLayout, aVar, null, new c(t, z));
        }

        private void U(CoordinatorLayout coordinatorLayout, T t, int i2, float f2) {
            int iAbs = Math.abs(M() - i2);
            float fAbs = Math.abs(f2);
            V(coordinatorLayout, t, i2, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f));
        }

        private void V(CoordinatorLayout coordinatorLayout, T t, int i2, int i3) {
            int iM = M();
            if (iM == i2) {
                ValueAnimator valueAnimator = this.m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.m = valueAnimator3;
                valueAnimator3.setInterpolator(e.e.b.c.m.a.f21053e);
                this.m.addUpdateListener(new a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.m.setDuration(Math.min(i3, 600));
            this.m.setIntValues(iM, i2);
            this.m.start();
        }

        private boolean X(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.j() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        private static boolean Y(int i2, int i3) {
            return (i2 & i3) == i3;
        }

        private View Z(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if ((childAt instanceof j) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View a0(AppBarLayout appBarLayout, int i2) {
            int iAbs = Math.abs(i2);
            int childCount = appBarLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = appBarLayout.getChildAt(i3);
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int b0(T t, int i2) {
            int childCount = t.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                d dVar = (d) childAt.getLayoutParams();
                if (Y(dVar.a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) dVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) dVar).bottomMargin;
                }
                int i4 = -i2;
                if (top <= i4 && bottom >= i4) {
                    return i3;
                }
            }
            return -1;
        }

        private int e0(T t, int i2) {
            int iAbs = Math.abs(i2);
            int childCount = t.getChildCount();
            int topInset = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = t.getChildAt(i3);
                d dVar = (d) childAt.getLayoutParams();
                Interpolator interpolatorB = dVar.b();
                if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                    if (interpolatorB == null) {
                        break;
                    }
                    int iA = dVar.a();
                    if ((iA & 1) != 0) {
                        topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) dVar).topMargin + ((LinearLayout.LayoutParams) dVar).bottomMargin;
                        if ((iA & 2) != 0) {
                            topInset -= u.z(childAt);
                        }
                    }
                    if (u.v(childAt)) {
                        topInset -= t.getTopInset();
                    }
                    if (topInset <= 0) {
                        break;
                    }
                    float f2 = topInset;
                    return Integer.signum(i2) * (childAt.getTop() + Math.round(f2 * interpolatorB.getInterpolation((iAbs - childAt.getTop()) / f2)));
                }
            }
            return i2;
        }

        private boolean p0(CoordinatorLayout coordinatorLayout, T t) {
            List<View> listS = coordinatorLayout.s(t);
            int size = listS.size();
            for (int i2 = 0; i2 < size; i2++) {
                CoordinatorLayout.c cVarF = ((CoordinatorLayout.f) listS.get(i2).getLayoutParams()).f();
                if (cVarF instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) cVarF).K() != 0;
                }
            }
            return false;
        }

        private void q0(CoordinatorLayout coordinatorLayout, T t) {
            int iM = M();
            int iB0 = b0(t, iM);
            if (iB0 >= 0) {
                View childAt = t.getChildAt(iB0);
                d dVar = (d) childAt.getLayoutParams();
                int iA = dVar.a();
                if ((iA & 17) == 17) {
                    int i2 = -childAt.getTop();
                    int iZ = -childAt.getBottom();
                    if (iB0 == t.getChildCount() - 1) {
                        iZ += t.getTopInset();
                    }
                    if (Y(iA, 2)) {
                        iZ += u.z(childAt);
                    } else if (Y(iA, 5)) {
                        int iZ2 = u.z(childAt) + iZ;
                        if (iM < iZ2) {
                            i2 = iZ2;
                        } else {
                            iZ = iZ2;
                        }
                    }
                    if (Y(iA, 32)) {
                        i2 += ((LinearLayout.LayoutParams) dVar).topMargin;
                        iZ -= ((LinearLayout.LayoutParams) dVar).bottomMargin;
                    }
                    if (iM < (iZ + i2) / 2) {
                        i2 = iZ;
                    }
                    U(coordinatorLayout, t, c.i.g.a.b(i2, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void r0(CoordinatorLayout coordinatorLayout, T t) {
            u.c0(coordinatorLayout, androidx.core.view.d0.c.a.m.b());
            u.c0(coordinatorLayout, androidx.core.view.d0.c.a.n.b());
            View viewZ = Z(coordinatorLayout);
            if (viewZ == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout.f) viewZ.getLayoutParams()).f() instanceof ScrollingViewBehavior)) {
                return;
            }
            S(coordinatorLayout, t, viewZ);
        }

        private void s0(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, boolean z) {
            View viewA0 = a0(t, i2);
            if (viewA0 != null) {
                int iA = ((d) viewA0.getLayoutParams()).a();
                boolean zW = false;
                if ((iA & 1) != 0) {
                    int iZ = u.z(viewA0);
                    if (i3 <= 0 || (iA & 12) == 0 ? !((iA & 2) == 0 || (-i2) < (viewA0.getBottom() - iZ) - t.getTopInset()) : (-i2) >= (viewA0.getBottom() - iZ) - t.getTopInset()) {
                        zW = true;
                    }
                }
                if (t.l()) {
                    zW = t.w(Z(coordinatorLayout));
                }
                boolean zU = t.u(zW);
                if (z || (zU && p0(coordinatorLayout, t))) {
                    t.jumpDrawablesToCurrentState();
                }
            }
        }

        @Override // com.google.android.material.appbar.a
        int M() {
            return E() + this.f18364k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
        public boolean H(T t) {
            if (this.r != null) {
                throw null;
            }
            WeakReference<View> weakReference = this.q;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
        public int K(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
        public int L(T t) {
            return t.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
        public void N(CoordinatorLayout coordinatorLayout, T t) {
            q0(coordinatorLayout, t);
            if (t.l()) {
                t.u(t.w(Z(coordinatorLayout)));
            }
        }

        @Override // com.google.android.material.appbar.c, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, T t, int i2) {
            boolean zL = super.l(coordinatorLayout, t, i2);
            int pendingAction = t.getPendingAction();
            int i3 = this.n;
            if (i3 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i3);
                P(coordinatorLayout, t, (-childAt.getBottom()) + (this.o ? u.z(childAt) + t.getTopInset() : Math.round(childAt.getHeight() * this.p)));
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        U(coordinatorLayout, t, i4, 0.0f);
                    } else {
                        P(coordinatorLayout, t, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        U(coordinatorLayout, t, 0, 0.0f);
                    } else {
                        P(coordinatorLayout, t, 0);
                    }
                }
            }
            t.q();
            this.n = -1;
            G(c.i.g.a.b(E(), -t.getTotalScrollRange(), 0));
            s0(coordinatorLayout, t, E(), 0, true);
            t.m(E());
            r0(coordinatorLayout, t);
            return zL;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
        public boolean m(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4, int i5) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t, i2, i3, i4, i5);
            }
            coordinatorLayout.J(t, i2, i3, View.MeasureSpec.makeMeasureSpec(0, 0), i5);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
        public void q(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int[] iArr, int i4) {
            int i5;
            int downNestedPreScrollRange;
            if (i3 != 0) {
                if (i3 < 0) {
                    int i6 = -t.getTotalScrollRange();
                    i5 = i6;
                    downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i6;
                } else {
                    i5 = -t.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                if (i5 != downNestedPreScrollRange) {
                    iArr[1] = O(coordinatorLayout, t, i3, i5, downNestedPreScrollRange);
                }
            }
            if (t.l()) {
                t.u(t.w(view));
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
        public void t(CoordinatorLayout coordinatorLayout, T t, View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
            if (i5 < 0) {
                iArr[1] = O(coordinatorLayout, t, i5, -t.getDownNestedScrollRange(), 0);
            }
            if (i5 == 0) {
                r0(coordinatorLayout, t);
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
        public void x(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (!(parcelable instanceof SavedState)) {
                super.x(coordinatorLayout, t, parcelable);
                this.n = -1;
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.x(coordinatorLayout, t, savedState.a());
            this.n = savedState.f18365h;
            this.p = savedState.f18366i;
            this.o = savedState.f18367j;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable parcelableY = super.y(coordinatorLayout, t);
            int iE = E();
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int bottom = childAt.getBottom() + iE;
                if (childAt.getTop() + iE <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(parcelableY);
                    savedState.f18365h = i2;
                    savedState.f18367j = bottom == u.z(childAt) + t.getTopInset();
                    savedState.f18366i = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return parcelableY;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
        public boolean A(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i2, int i3) {
            ValueAnimator valueAnimator;
            boolean z = (i2 & 2) != 0 && (t.l() || X(coordinatorLayout, t, view));
            if (z && (valueAnimator = this.m) != null) {
                valueAnimator.cancel();
            }
            this.q = null;
            this.l = i3;
            return z;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
        public void C(CoordinatorLayout coordinatorLayout, T t, View view, int i2) {
            if (this.l == 0 || i2 == 1) {
                q0(coordinatorLayout, t);
                if (t.l()) {
                    t.u(t.w(view));
                }
            }
            this.q = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.android.material.appbar.a
        /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
        public int Q(CoordinatorLayout coordinatorLayout, T t, int i2, int i3, int i4) {
            int iM = M();
            int i5 = 0;
            if (i3 == 0 || iM < i3 || iM > i4) {
                this.f18364k = 0;
            } else {
                int iB = c.i.g.a.b(i2, i3, i4);
                if (iM != iB) {
                    int iE0 = t.h() ? e0(t, iB) : iB;
                    boolean zG = G(iE0);
                    i5 = iM - iB;
                    this.f18364k = iB - iE0;
                    if (!zG && t.h()) {
                        coordinatorLayout.f(t);
                    }
                    t.m(E());
                    s0(coordinatorLayout, t, iB, iB < iM ? -1 : 1, false);
                }
            }
            r0(coordinatorLayout, t);
            return i5;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.n = -1;
        }

        protected static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            int f18365h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            float f18366i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            boolean f18367j;

            static class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }
            }

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f18365h = parcel.readInt();
                this.f18366i = parcel.readFloat();
                this.f18367j = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i2) {
                super.writeToParcel(parcel, i2);
                parcel.writeInt(this.f18365h);
                parcel.writeFloat(this.f18366i);
                parcel.writeByte(this.f18367j ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f18358f;
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.f18360h = -1;
        this.f18361i = -1;
        this.f18362j = -1;
        this.l = 0;
        Context context2 = getContext();
        setOrientation(1);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            com.google.android.material.appbar.e.a(this);
            com.google.android.material.appbar.e.c(this, attributeSet, i2, i3);
        }
        TypedArray typedArrayH = com.google.android.material.internal.j.h(context2, attributeSet, l.f21049k, i2, i3, new int[0]);
        u.m0(this, typedArrayH.getDrawable(l.l));
        if (getBackground() instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            g gVar = new g();
            gVar.X(ColorStateList.valueOf(colorDrawable.getColor()));
            gVar.N(context2);
            u.m0(this, gVar);
        }
        int i5 = l.p;
        if (typedArrayH.hasValue(i5)) {
            s(typedArrayH.getBoolean(i5, false), false, false);
        }
        if (i4 >= 21) {
            int i6 = l.o;
            if (typedArrayH.hasValue(i6)) {
                com.google.android.material.appbar.e.b(this, typedArrayH.getDimensionPixelSize(i6, 0));
            }
        }
        if (i4 >= 26) {
            int i7 = l.n;
            if (typedArrayH.hasValue(i7)) {
                setKeyboardNavigationCluster(typedArrayH.getBoolean(i7, false));
            }
            int i8 = l.m;
            if (typedArrayH.hasValue(i8)) {
                setTouchscreenBlocksFocus(typedArrayH.getBoolean(i8, false));
            }
        }
        this.r = typedArrayH.getBoolean(l.q, false);
        this.s = typedArrayH.getResourceId(l.r, -1);
        setStatusBarForeground(typedArrayH.getDrawable(l.s));
        typedArrayH.recycle();
        u.v0(this, new a());
    }

    public static class d extends LinearLayout.LayoutParams {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f18377b;

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.u);
            this.a = typedArrayObtainStyledAttributes.getInt(l.v, 0);
            int i2 = l.w;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                this.f18377b = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i2, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public int a() {
            return this.a;
        }

        public Interpolator b() {
            return this.f18377b;
        }

        boolean c() {
            int i2 = this.a;
            return (i2 & 1) == 1 && (i2 & 10) != 0;
        }

        public d(int i2, int i3) {
            super(i2, i3);
            this.a = 1;
        }

        public d(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }

        public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
        }

        public d(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
        }
    }
}
