package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.h;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.t;
import androidx.core.view.u;
import androidx.core.widget.n;
import c.i.j.i;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.j;
import com.google.android.material.internal.l;
import com.google.android.material.stateful.ExtendableSavedState;
import e.e.b.c.k;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingActionButton extends l implements t, n, e.e.b.c.u.a, e.e.b.c.a0.n, CoordinatorLayout.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f18633g = k.f21039k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f18634h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f18635i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ColorStateList f18636j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private PorterDuff.Mode f18637k;
    private ColorStateList l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    boolean r;
    final Rect s;
    private final Rect t;
    private final androidx.appcompat.widget.l u;
    private final e.e.b.c.u.b v;
    private com.google.android.material.floatingactionbutton.b w;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: E */
        public /* bridge */ /* synthetic */ boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: H */
        public /* bridge */ /* synthetic */ boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.h(coordinatorLayout, floatingActionButton, view);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: I */
        public /* bridge */ /* synthetic */ boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            return super.l(coordinatorLayout, floatingActionButton, i2);
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public /* bridge */ /* synthetic */ void g(CoordinatorLayout.f fVar) {
            super.g(fVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    class a implements com.google.android.material.floatingactionbutton.b.j {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.b.j
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.b.j
        public void b() {
            this.a.a(FloatingActionButton.this);
        }
    }

    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    private class c implements e.e.b.c.z.b {
        c() {
        }

        @Override // e.e.b.c.z.b
        public void a(int i2, int i3, int i4, int i5) {
            FloatingActionButton.this.s.set(i2, i3, i4, i5);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i2 + floatingActionButton.p, i3 + FloatingActionButton.this.p, i4 + FloatingActionButton.this.p, i5 + FloatingActionButton.this.p);
        }

        @Override // e.e.b.c.z.b
        public void b(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }

        @Override // e.e.b.c.z.b
        public boolean c() {
            return FloatingActionButton.this.r;
        }
    }

    class d<T extends FloatingActionButton> implements com.google.android.material.floatingactionbutton.b.i {
        private final e.e.b.c.m.k<T> a;

        d(e.e.b.c.m.k<T> kVar) {
            this.a = kVar;
        }

        @Override // com.google.android.material.floatingactionbutton.b.i
        public void a() {
            this.a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.b.i
        public void b() {
            this.a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).a.equals(this.a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.s);
    }

    private com.google.android.material.floatingactionbutton.b getImpl() {
        if (this.w == null) {
            this.w = h();
        }
        return this.w;
    }

    private com.google.android.material.floatingactionbutton.b h() {
        return Build.VERSION.SDK_INT >= 21 ? new com.google.android.material.floatingactionbutton.c(this, new c()) : new com.google.android.material.floatingactionbutton.b(this, new c());
    }

    private int k(int i2) {
        int i3 = this.o;
        if (i3 != 0) {
            return i3;
        }
        Resources resources = getResources();
        if (i2 != -1) {
            return i2 != 1 ? resources.getDimensionPixelSize(e.e.b.c.d.l) : resources.getDimensionPixelSize(e.e.b.c.d.f20991k);
        }
        return Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? k(1) : k(0);
    }

    private void p(Rect rect) {
        int i2 = rect.left;
        Rect rect2 = this.s;
        rect.left = i2 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void q() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f18636j;
        if (colorStateList == null) {
            androidx.core.graphics.drawable.a.c(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f18637k;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(h.e(colorForState, mode));
    }

    private static int r(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i2, size);
        }
        if (mode == 0) {
            return i2;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private com.google.android.material.floatingactionbutton.b.j u(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    @Override // e.e.b.c.u.a
    public boolean a() {
        return this.v.c();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().d(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    public void g(e.e.b.c.m.k<? extends FloatingActionButton> kVar) {
        getImpl().f(new d(kVar));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f18634h;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f18635i;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    public Drawable getContentBackground() {
        return getImpl().k();
    }

    public int getCustomSize() {
        return this.o;
    }

    public int getExpandedComponentIdHint() {
        return this.v.b();
    }

    public e.e.b.c.m.h getHideMotionSpec() {
        return getImpl().p();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.l;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.l;
    }

    public e.e.b.c.a0.k getShapeAppearanceModel() {
        return (e.e.b.c.a0.k) i.c(getImpl().u());
    }

    public e.e.b.c.m.h getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.n;
    }

    int getSizeDimension() {
        return k(this.n);
    }

    @Override // androidx.core.view.t
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.n
    public ColorStateList getSupportImageTintList() {
        return this.f18636j;
    }

    @Override // androidx.core.widget.n
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f18637k;
    }

    public boolean getUseCompatPadding() {
        return this.r;
    }

    @Deprecated
    public boolean i(Rect rect) {
        if (!u.O(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        p(rect);
        return true;
    }

    public void j(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        p(rect);
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    public void l(b bVar) {
        m(bVar, true);
    }

    void m(b bVar, boolean z) {
        getImpl().w(u(bVar), z);
    }

    public boolean n() {
        return getImpl().y();
    }

    public boolean o() {
        return getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i2, int i3) {
        int sizeDimension = getSizeDimension();
        this.p = (sizeDimension - this.q) / 2;
        getImpl().f0();
        int iMin = Math.min(r(sizeDimension, i2), r(sizeDimension, i3));
        Rect rect = this.s;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.v.d((Bundle) i.c(extendableSavedState.f18765h.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(parcelableOnSaveInstanceState);
        extendableSavedState.f18765h.put("expandableWidgetHelper", this.v.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && i(this.t) && !this.t.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void s(b bVar) {
        t(bVar, true);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f18634h != colorStateList) {
            this.f18634h = colorStateList;
            getImpl().L(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f18635i != mode) {
            this.f18635i = mode;
            getImpl().M(mode);
        }
    }

    public void setCompatElevation(float f2) {
        getImpl().N(f2);
    }

    public void setCompatElevationResource(int i2) {
        setCompatElevation(getResources().getDimension(i2));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        getImpl().Q(f2);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i2) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i2));
    }

    public void setCompatPressedTranslationZ(float f2) {
        getImpl().U(f2);
    }

    public void setCompatPressedTranslationZResource(int i2) {
        setCompatPressedTranslationZ(getResources().getDimension(i2));
    }

    public void setCustomSize(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i2 != this.o) {
            this.o = i2;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        getImpl().g0(f2);
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().o()) {
            getImpl().O(z);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i2) {
        this.v.f(i2);
    }

    public void setHideMotionSpec(e.e.b.c.m.h hVar) {
        getImpl().P(hVar);
    }

    public void setHideMotionSpecResource(int i2) {
        setHideMotionSpec(e.e.b.c.m.h.c(getContext(), i2));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().e0();
            if (this.f18636j != null) {
                q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        this.u.g(i2);
        q();
    }

    public void setRippleColor(int i2) {
        setRippleColor(ColorStateList.valueOf(i2));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().I();
    }

    public void setShadowPaddingEnabled(boolean z) {
        getImpl().W(z);
    }

    @Override // e.e.b.c.a0.n
    public void setShapeAppearanceModel(e.e.b.c.a0.k kVar) {
        getImpl().X(kVar);
    }

    public void setShowMotionSpec(e.e.b.c.m.h hVar) {
        getImpl().Y(hVar);
    }

    public void setShowMotionSpecResource(int i2) {
        setShowMotionSpec(e.e.b.c.m.h.c(getContext(), i2));
    }

    public void setSize(int i2) {
        this.o = 0;
        if (i2 != this.n) {
            this.n = i2;
            requestLayout();
        }
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f18636j != colorStateList) {
            this.f18636j = colorStateList;
            q();
        }
    }

    @Override // androidx.core.widget.n
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f18637k != mode) {
            this.f18637k = mode;
            q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.r != z) {
            this.r = z;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.l, android.widget.ImageView, android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    void t(b bVar, boolean z) {
        getImpl().c0(u(bVar), z);
    }

    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {
        private Rect a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private b f18638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f18639c;

        public BaseBehavior() {
            this.f18639c = true;
        }

        private static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i2;
            Rect rect = floatingActionButton.s;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
            int i3 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                i2 = rect.right;
            } else {
                i2 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                i3 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                i3 = -rect.top;
            }
            if (i3 != 0) {
                u.U(floatingActionButton, i3);
            }
            if (i2 != 0) {
                u.T(floatingActionButton, i2);
            }
        }

        private boolean J(View view, FloatingActionButton floatingActionButton) {
            return this.f18639c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.a == null) {
                this.a = new Rect();
            }
            Rect rect = this.a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m(this.f18638b, false);
                return true;
            }
            floatingActionButton.t(this.f18638b, false);
            return true;
        }

        private boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m(this.f18638b, false);
                return true;
            }
            floatingActionButton.t(this.f18638b, false);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.s;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!F(view)) {
                return false;
            }
            L(view, floatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i2) {
            List<View> listR = coordinatorLayout.r(floatingActionButton);
            int size = listR.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = listR.get(i3);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.I(floatingActionButton, i2);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f826h == 0) {
                fVar.f826h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.e.b.c.l.Y1);
            this.f18639c = typedArrayObtainStyledAttributes.getBoolean(e.e.b.c.l.Z1, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f18633g;
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, i3), attributeSet, i2);
        this.s = new Rect();
        this.t = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayH = j.h(context2, attributeSet, e.e.b.c.l.I1, i2, i3, new int[0]);
        this.f18634h = e.e.b.c.x.c.a(context2, typedArrayH, e.e.b.c.l.K1);
        this.f18635i = com.google.android.material.internal.k.e(typedArrayH.getInt(e.e.b.c.l.L1, -1), null);
        this.l = e.e.b.c.x.c.a(context2, typedArrayH, e.e.b.c.l.V1);
        this.n = typedArrayH.getInt(e.e.b.c.l.Q1, -1);
        this.o = typedArrayH.getDimensionPixelSize(e.e.b.c.l.P1, 0);
        this.m = typedArrayH.getDimensionPixelSize(e.e.b.c.l.M1, 0);
        float dimension = typedArrayH.getDimension(e.e.b.c.l.N1, 0.0f);
        float dimension2 = typedArrayH.getDimension(e.e.b.c.l.S1, 0.0f);
        float dimension3 = typedArrayH.getDimension(e.e.b.c.l.U1, 0.0f);
        this.r = typedArrayH.getBoolean(e.e.b.c.l.X1, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(e.e.b.c.d.M);
        this.q = typedArrayH.getDimensionPixelSize(e.e.b.c.l.T1, 0);
        e.e.b.c.m.h hVarB = e.e.b.c.m.h.b(context2, typedArrayH, e.e.b.c.l.W1);
        e.e.b.c.m.h hVarB2 = e.e.b.c.m.h.b(context2, typedArrayH, e.e.b.c.l.R1);
        e.e.b.c.a0.k kVarM = e.e.b.c.a0.k.g(context2, attributeSet, i2, i3, e.e.b.c.a0.k.a).m();
        boolean z = typedArrayH.getBoolean(e.e.b.c.l.O1, false);
        setEnabled(typedArrayH.getBoolean(e.e.b.c.l.J1, true));
        typedArrayH.recycle();
        androidx.appcompat.widget.l lVar = new androidx.appcompat.widget.l(this);
        this.u = lVar;
        lVar.f(attributeSet, i2);
        this.v = new e.e.b.c.u.b(this);
        getImpl().X(kVarM);
        getImpl().x(this.f18634h, this.f18635i, this.l, this.m);
        getImpl().T(dimensionPixelSize);
        getImpl().N(dimension);
        getImpl().Q(dimension2);
        getImpl().U(dimension3);
        getImpl().S(this.q);
        getImpl().Y(hVarB);
        getImpl().P(hVarB2);
        getImpl().O(z);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            getImpl().V(this.l);
        }
    }
}
