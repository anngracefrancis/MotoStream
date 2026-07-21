package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.c0;
import cm.aptoide.pt.file.CacheHelper;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    static final Handler a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f18726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f18727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f18728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ViewGroup f18729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f18730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final v f18731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.google.android.material.snackbar.a f18732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18733i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18734j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f18735k;
    private Rect m;
    private int n;
    private int o;
    private int p;
    private int q;
    private int r;
    private List<r<B>> s;
    private Behavior t;
    private final AccessibilityManager u;
    private final Runnable l = new j();
    com.google.android.material.snackbar.b.InterfaceC0201b v = new m();

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final s f18736k = new s(this);

        /* JADX INFO: Access modifiers changed from: private */
        public void P(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.f18736k.c(baseTransientBottomBar);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean E(View view) {
            return this.f18736k.a(view);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean k(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            this.f18736k.b(coordinatorLayout, view, motionEvent);
            return super.k(coordinatorLayout, view, motionEvent);
        }
    }

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.J();
        }
    }

    class b extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I(this.a);
        }
    }

    class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BaseTransientBottomBar.this.f18731g.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BaseTransientBottomBar.this.f18731g.setScaleX(fFloatValue);
            BaseTransientBottomBar.this.f18731g.setScaleY(fFloatValue);
        }
    }

    class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.J();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f18732h.a(70, 180);
        }
    }

    class f implements ValueAnimator.AnimatorUpdateListener {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f18738b;

        f(int i2) {
            this.f18738b = i2;
            this.a = i2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f18726b) {
                androidx.core.view.u.U(BaseTransientBottomBar.this.f18731g, iIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.f18731g.setTranslationY(iIntValue);
            }
            this.a = iIntValue;
        }
    }

    class g extends AnimatorListenerAdapter {
        final /* synthetic */ int a;

        g(int i2) {
            this.a = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BaseTransientBottomBar.this.I(this.a);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BaseTransientBottomBar.this.f18732h.b(0, 180);
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        private int a = 0;

        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (BaseTransientBottomBar.f18726b) {
                androidx.core.view.u.U(BaseTransientBottomBar.this.f18731g, iIntValue - this.a);
            } else {
                BaseTransientBottomBar.this.f18731g.setTranslationY(iIntValue);
            }
            this.a = iIntValue;
        }
    }

    static class i implements Handler.Callback {
        i() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                ((BaseTransientBottomBar) message.obj).Q();
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            ((BaseTransientBottomBar) message.obj).F(message.arg1);
            return true;
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int iA;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f18731g == null || baseTransientBottomBar.f18730f == null || (iA = (BaseTransientBottomBar.this.A() - BaseTransientBottomBar.this.D()) + ((int) BaseTransientBottomBar.this.f18731g.getTranslationY())) >= BaseTransientBottomBar.this.q) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = BaseTransientBottomBar.this.f18731g.getLayoutParams();
            if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                Log.w(BaseTransientBottomBar.f18728d, "Unable to apply gesture inset because layout params are not MarginLayoutParams");
                return;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin += BaseTransientBottomBar.this.q - iA;
            BaseTransientBottomBar.this.f18731g.requestLayout();
        }
    }

    class k implements androidx.core.view.p {
        k() {
        }

        @Override // androidx.core.view.p
        public c0 a(View view, c0 c0Var) {
            BaseTransientBottomBar.this.n = c0Var.h();
            BaseTransientBottomBar.this.o = c0Var.i();
            BaseTransientBottomBar.this.p = c0Var.j();
            BaseTransientBottomBar.this.W();
            return c0Var;
        }
    }

    class l extends androidx.core.view.a {
        l() {
        }

        @Override // androidx.core.view.a
        public void g(View view, androidx.core.view.d0.c cVar) {
            super.g(view, cVar);
            cVar.a(CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES);
            cVar.d0(true);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i2, Bundle bundle) {
            if (i2 != 1048576) {
                return super.j(view, i2, bundle);
            }
            BaseTransientBottomBar.this.t();
            return true;
        }
    }

    class m implements com.google.android.material.snackbar.b.InterfaceC0201b {
        m() {
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0201b
        public void a(int i2) {
            Handler handler = BaseTransientBottomBar.a;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }

        @Override // com.google.android.material.snackbar.b.InterfaceC0201b
        public void show() {
            Handler handler = BaseTransientBottomBar.a;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }
    }

    class n implements t {

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BaseTransientBottomBar.this.I(3);
            }
        }

        n() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewAttachedToWindow(View view) {
            WindowInsets rootWindowInsets;
            if (Build.VERSION.SDK_INT < 29 || (rootWindowInsets = BaseTransientBottomBar.this.f18731g.getRootWindowInsets()) == null) {
                return;
            }
            BaseTransientBottomBar.this.q = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
            BaseTransientBottomBar.this.W();
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.t
        public void onViewDetachedFromWindow(View view) {
            if (BaseTransientBottomBar.this.G()) {
                BaseTransientBottomBar.a.post(new a());
            }
        }
    }

    class o implements u {
        o() {
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.u
        public void a(View view, int i2, int i3, int i4, int i5) {
            BaseTransientBottomBar.this.f18731g.setOnLayoutChangeListener(null);
            BaseTransientBottomBar.this.R();
        }
    }

    class p implements SwipeDismissBehavior.c {
        p() {
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void a(View view) {
            view.setVisibility(8);
            BaseTransientBottomBar.this.u(0);
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior.c
        public void b(int i2) {
            if (i2 == 0) {
                com.google.android.material.snackbar.b.c().k(BaseTransientBottomBar.this.v);
            } else if (i2 == 1 || i2 == 2) {
                com.google.android.material.snackbar.b.c().j(BaseTransientBottomBar.this.v);
            }
        }
    }

    class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v vVar = BaseTransientBottomBar.this.f18731g;
            if (vVar == null) {
                return;
            }
            vVar.setVisibility(0);
            if (BaseTransientBottomBar.this.f18731g.getAnimationMode() == 1) {
                BaseTransientBottomBar.this.S();
            } else {
                BaseTransientBottomBar.this.U();
            }
        }
    }

    public static abstract class r<B> {
        public static final int DISMISS_EVENT_ACTION = 1;
        public static final int DISMISS_EVENT_CONSECUTIVE = 4;
        public static final int DISMISS_EVENT_MANUAL = 3;
        public static final int DISMISS_EVENT_SWIPE = 0;
        public static final int DISMISS_EVENT_TIMEOUT = 2;

        public void onDismissed(B b2, int i2) {
        }

        public void onShown(B b2) {
        }
    }

    public static class s {
        private com.google.android.material.snackbar.b.InterfaceC0201b a;

        public s(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.L(0.1f);
            swipeDismissBehavior.J(0.6f);
            swipeDismissBehavior.M(0);
        }

        public boolean a(View view) {
            return view instanceof v;
        }

        public void b(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                if (coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    com.google.android.material.snackbar.b.c().j(this.a);
                }
            } else if (actionMasked == 1 || actionMasked == 3) {
                com.google.android.material.snackbar.b.c().k(this.a);
            }
        }

        public void c(BaseTransientBottomBar<?> baseTransientBottomBar) {
            this.a = baseTransientBottomBar.v;
        }
    }

    protected interface t {
        void onViewAttachedToWindow(View view);

        void onViewDetachedFromWindow(View view);
    }

    protected interface u {
        void a(View view, int i2, int i3, int i4, int i5);
    }

    protected static class v extends FrameLayout {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final View.OnTouchListener f18746f = new a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private u f18747g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private t f18748h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f18749i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final float f18750j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final float f18751k;
        private ColorStateList l;
        private PorterDuff.Mode m;

        static class a implements View.OnTouchListener {
            a() {
            }

            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        protected v(Context context, AttributeSet attributeSet) {
            super(com.google.android.material.theme.a.a.c(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, e.e.b.c.l.h4);
            int i2 = e.e.b.c.l.o4;
            if (typedArrayObtainStyledAttributes.hasValue(i2)) {
                androidx.core.view.u.q0(this, typedArrayObtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.f18749i = typedArrayObtainStyledAttributes.getInt(e.e.b.c.l.k4, 0);
            this.f18750j = typedArrayObtainStyledAttributes.getFloat(e.e.b.c.l.l4, 1.0f);
            setBackgroundTintList(e.e.b.c.x.c.a(context2, typedArrayObtainStyledAttributes, e.e.b.c.l.m4));
            setBackgroundTintMode(com.google.android.material.internal.k.e(typedArrayObtainStyledAttributes.getInt(e.e.b.c.l.n4, -1), PorterDuff.Mode.SRC_IN));
            this.f18751k = typedArrayObtainStyledAttributes.getFloat(e.e.b.c.l.j4, 1.0f);
            typedArrayObtainStyledAttributes.recycle();
            setOnTouchListener(f18746f);
            setFocusable(true);
            if (getBackground() == null) {
                androidx.core.view.u.m0(this, a());
            }
        }

        private Drawable a() {
            float dimension = getResources().getDimension(e.e.b.c.d.O);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(e.e.b.c.q.a.g(this, e.e.b.c.b.o, e.e.b.c.b.l, getBackgroundOverlayColorAlpha()));
            if (this.l == null) {
                return androidx.core.graphics.drawable.a.r(gradientDrawable);
            }
            Drawable drawableR = androidx.core.graphics.drawable.a.r(gradientDrawable);
            androidx.core.graphics.drawable.a.o(drawableR, this.l);
            return drawableR;
        }

        float getActionTextColorAlpha() {
            return this.f18751k;
        }

        int getAnimationMode() {
            return this.f18749i;
        }

        float getBackgroundOverlayColorAlpha() {
            return this.f18750j;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            t tVar = this.f18748h;
            if (tVar != null) {
                tVar.onViewAttachedToWindow(this);
            }
            androidx.core.view.u.f0(this);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            t tVar = this.f18748h;
            if (tVar != null) {
                tVar.onViewDetachedFromWindow(this);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            u uVar = this.f18747g;
            if (uVar != null) {
                uVar.a(this, i2, i3, i4, i5);
            }
        }

        void setAnimationMode(int i2) {
            this.f18749i = i2;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (drawable != null && this.l != null) {
                drawable = androidx.core.graphics.drawable.a.r(drawable.mutate());
                androidx.core.graphics.drawable.a.o(drawable, this.l);
                androidx.core.graphics.drawable.a.p(drawable, this.m);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.l = colorStateList;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.o(drawableR, colorStateList);
                androidx.core.graphics.drawable.a.p(drawableR, this.m);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.m = mode;
            if (getBackground() != null) {
                Drawable drawableR = androidx.core.graphics.drawable.a.r(getBackground().mutate());
                androidx.core.graphics.drawable.a.p(drawableR, mode);
                if (drawableR != getBackground()) {
                    super.setBackgroundDrawable(drawableR);
                }
            }
        }

        void setOnAttachStateChangeListener(t tVar) {
            this.f18748h = tVar;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f18746f);
            super.setOnClickListener(onClickListener);
        }

        void setOnLayoutChangeListener(u uVar) {
            this.f18747g = uVar;
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        f18726b = i2 >= 16 && i2 <= 19;
        f18727c = new int[]{e.e.b.c.b.A};
        f18728d = BaseTransientBottomBar.class.getSimpleName();
        a = new Handler(Looper.getMainLooper(), new i());
    }

    protected BaseTransientBottomBar(ViewGroup viewGroup, View view, com.google.android.material.snackbar.a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        }
        if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.f18729e = viewGroup;
        this.f18732h = aVar;
        Context context = viewGroup.getContext();
        this.f18730f = context;
        com.google.android.material.internal.j.a(context);
        v vVar = (v) LayoutInflater.from(context).inflate(B(), viewGroup, false);
        this.f18731g = vVar;
        if (view instanceof SnackbarContentLayout) {
            ((SnackbarContentLayout) view).c(vVar.getActionTextColorAlpha());
        }
        vVar.addView(view);
        ViewGroup.LayoutParams layoutParams = vVar.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.m = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
        androidx.core.view.u.k0(vVar, 1);
        androidx.core.view.u.t0(vVar, 1);
        androidx.core.view.u.r0(vVar, true);
        androidx.core.view.u.v0(vVar, new k());
        androidx.core.view.u.i0(vVar, new l());
        this.u = (AccessibilityManager) context.getSystemService("accessibility");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A() {
        WindowManager windowManager = (WindowManager) this.f18730f.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private int C() {
        int height = this.f18731g.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f18731g.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int D() {
        int[] iArr = new int[2];
        this.f18731g.getLocationOnScreen(iArr);
        return iArr[1] + this.f18731g.getHeight();
    }

    private boolean H() {
        ViewGroup.LayoutParams layoutParams = this.f18731g.getLayoutParams();
        return (layoutParams instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams).f() instanceof SwipeDismissBehavior);
    }

    private void M(CoordinatorLayout.f fVar) {
        SwipeDismissBehavior<? extends View> swipeDismissBehaviorY = this.t;
        if (swipeDismissBehaviorY == null) {
            swipeDismissBehaviorY = y();
        }
        if (swipeDismissBehaviorY instanceof Behavior) {
            ((Behavior) swipeDismissBehaviorY).P(this);
        }
        swipeDismissBehaviorY.K(new p());
        fVar.o(swipeDismissBehaviorY);
        if (this.f18735k == null) {
            fVar.f825g = 80;
        }
    }

    private boolean O() {
        return this.q > 0 && !this.f18734j && H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R() {
        if (N()) {
            q();
        } else {
            this.f18731g.setVisibility(0);
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        ValueAnimator valueAnimatorV = v(0.0f, 1.0f);
        ValueAnimator valueAnimatorZ = z(0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(valueAnimatorV, valueAnimatorZ);
        animatorSet.setDuration(150L);
        animatorSet.addListener(new a());
        animatorSet.start();
    }

    private void T(int i2) {
        ValueAnimator valueAnimatorV = v(1.0f, 0.0f);
        valueAnimatorV.setDuration(75L);
        valueAnimatorV.addListener(new b(i2));
        valueAnimatorV.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        int iC = C();
        if (f18726b) {
            androidx.core.view.u.U(this.f18731g, iC);
        } else {
            this.f18731g.setTranslationY(iC);
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(iC, 0);
        valueAnimator.setInterpolator(e.e.b.c.m.a.f21050b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new e());
        valueAnimator.addUpdateListener(new f(iC));
        valueAnimator.start();
    }

    private void V(int i2) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, C());
        valueAnimator.setInterpolator(e.e.b.c.m.a.f21050b);
        valueAnimator.setDuration(250L);
        valueAnimator.addListener(new g(i2));
        valueAnimator.addUpdateListener(new h());
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.f18731g.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams) || (rect = this.m) == null) {
            Log.w(f18728d, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = rect.bottom + (this.f18735k != null ? this.r : this.n);
        marginLayoutParams.leftMargin = rect.left + this.o;
        marginLayoutParams.rightMargin = rect.right + this.p;
        this.f18731g.requestLayout();
        if (Build.VERSION.SDK_INT < 29 || !O()) {
            return;
        }
        this.f18731g.removeCallbacks(this.l);
        this.f18731g.post(this.l);
    }

    private void r(int i2) {
        if (this.f18731g.getAnimationMode() == 1) {
            T(i2);
        } else {
            V(i2);
        }
    }

    private int s() {
        View view = this.f18735k;
        if (view == null) {
            return 0;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i2 = iArr[1];
        int[] iArr2 = new int[2];
        this.f18729e.getLocationOnScreen(iArr2);
        return (iArr2[1] + this.f18729e.getHeight()) - i2;
    }

    private ValueAnimator v(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(e.e.b.c.m.a.a);
        valueAnimatorOfFloat.addUpdateListener(new c());
        return valueAnimatorOfFloat;
    }

    private ValueAnimator z(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(e.e.b.c.m.a.f21052d);
        valueAnimatorOfFloat.addUpdateListener(new d());
        return valueAnimatorOfFloat;
    }

    protected int B() {
        return E() ? e.e.b.c.h.n : e.e.b.c.h.f21011c;
    }

    protected boolean E() {
        TypedArray typedArrayObtainStyledAttributes = this.f18730f.obtainStyledAttributes(f18727c);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != -1;
    }

    final void F(int i2) {
        if (N() && this.f18731g.getVisibility() == 0) {
            r(i2);
        } else {
            I(i2);
        }
    }

    public boolean G() {
        return com.google.android.material.snackbar.b.c().e(this.v);
    }

    void I(int i2) {
        com.google.android.material.snackbar.b.c().h(this.v);
        List<r<B>> list = this.s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.s.get(size).onDismissed(this, i2);
            }
        }
        ViewParent parent = this.f18731g.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f18731g);
        }
    }

    void J() {
        com.google.android.material.snackbar.b.c().i(this.v);
        List<r<B>> list = this.s;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.s.get(size).onShown(this);
            }
        }
    }

    public B K(r<B> rVar) {
        List<r<B>> list;
        if (rVar == null || (list = this.s) == null) {
            return this;
        }
        list.remove(rVar);
        return this;
    }

    public B L(int i2) {
        this.f18733i = i2;
        return this;
    }

    boolean N() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.u.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public void P() {
        com.google.android.material.snackbar.b.c().m(x(), this.v);
    }

    final void Q() {
        this.f18731g.setOnAttachStateChangeListener(new n());
        if (this.f18731g.getParent() == null) {
            ViewGroup.LayoutParams layoutParams = this.f18731g.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                M((CoordinatorLayout.f) layoutParams);
            }
            this.r = s();
            W();
            this.f18731g.setVisibility(4);
            this.f18729e.addView(this.f18731g);
        }
        if (androidx.core.view.u.O(this.f18731g)) {
            R();
        } else {
            this.f18731g.setOnLayoutChangeListener(new o());
        }
    }

    public B p(r<B> rVar) {
        if (rVar == null) {
            return this;
        }
        if (this.s == null) {
            this.s = new ArrayList();
        }
        this.s.add(rVar);
        return this;
    }

    void q() {
        this.f18731g.post(new q());
    }

    public void t() {
        u(3);
    }

    protected void u(int i2) {
        com.google.android.material.snackbar.b.c().b(this.v, i2);
    }

    public Context w() {
        return this.f18730f;
    }

    public int x() {
        return this.f18733i;
    }

    protected SwipeDismissBehavior<? extends View> y() {
        return new Behavior();
    }
}
