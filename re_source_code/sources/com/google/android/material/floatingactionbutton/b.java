package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.u;
import e.e.b.c.a0.n;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class b {
    static final TimeInterpolator a = e.e.b.c.m.a.f21051c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[] f18652b = {R.attr.state_pressed, R.attr.state_enabled};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int[] f18653c = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[] f18654d = {R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int[] f18655e = {R.attr.state_hovered, R.attr.state_enabled};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int[] f18656f = {R.attr.state_enabled};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int[] f18657g = new int[0];
    private int A;
    private ArrayList<Animator.AnimatorListener> C;
    private ArrayList<Animator.AnimatorListener> D;
    private ArrayList<i> E;
    final FloatingActionButton F;
    final e.e.b.c.z.b G;
    private ViewTreeObserver.OnPreDrawListener L;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    e.e.b.c.a0.k f18658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    e.e.b.c.a0.g f18659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Drawable f18660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    com.google.android.material.floatingactionbutton.a f18661k;
    Drawable l;
    boolean m;
    float o;
    float p;
    float q;
    int r;
    private final com.google.android.material.internal.f s;
    private e.e.b.c.m.h t;
    private e.e.b.c.m.h u;
    private Animator v;
    private e.e.b.c.m.h w;
    private e.e.b.c.m.h x;
    private float y;
    boolean n = true;
    private float z = 1.0f;
    private int B = 0;
    private final Rect H = new Rect();
    private final RectF I = new RectF();
    private final RectF J = new RectF();
    private final Matrix K = new Matrix();

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class a extends AnimatorListenerAdapter {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f18662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ j f18663c;

        a(boolean z, j jVar) {
            this.f18662b = z;
            this.f18663c = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.B = 0;
            b.this.v = null;
            if (this.a) {
                return;
            }
            FloatingActionButton floatingActionButton = b.this.F;
            boolean z = this.f18662b;
            floatingActionButton.b(z ? 8 : 4, z);
            j jVar = this.f18663c;
            if (jVar != null) {
                jVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.F.b(0, this.f18662b);
            b.this.B = 1;
            b.this.v = animator;
            this.a = false;
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.floatingactionbutton.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class C0199b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f18665b;

        C0199b(boolean z, j jVar) {
            this.a = z;
            this.f18665b = jVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.B = 0;
            b.this.v = null;
            j jVar = this.f18665b;
            if (jVar != null) {
                jVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.F.b(0, this.a);
            b.this.B = 2;
            b.this.v = animator;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class c extends e.e.b.c.m.g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            b.this.z = f2;
            return super.evaluate(f2, matrix, matrix2);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class d implements TypeEvaluator<Float> {
        FloatEvaluator a = new FloatEvaluator();

        d() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float evaluate(float f2, Float f3, Float f4) {
            float fFloatValue = this.a.evaluate(f2, (Number) f3, (Number) f4).floatValue();
            if (fFloatValue < 0.1f) {
                fFloatValue = 0.0f;
            }
            return Float.valueOf(fFloatValue);
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class e implements ViewTreeObserver.OnPreDrawListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            b.this.H();
            return true;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class f extends l {
        f() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            return 0.0f;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class g extends l {
        g() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            b bVar = b.this;
            return bVar.o + bVar.p;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class h extends l {
        h() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            b bVar = b.this;
            return bVar.o + bVar.q;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface i {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    interface j {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private class k extends l {
        k() {
            super(b.this, null);
        }

        @Override // com.google.android.material.floatingactionbutton.b.l
        protected float a() {
            return b.this.o;
        }
    }

    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    private abstract class l extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f18674b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f18675c;

        private l() {
        }

        protected abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.g0((int) this.f18675c);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                e.e.b.c.a0.g gVar = b.this.f18659i;
                this.f18674b = gVar == null ? 0.0f : gVar.w();
                this.f18675c = a();
                this.a = true;
            }
            b bVar = b.this;
            float f2 = this.f18674b;
            bVar.g0((int) (f2 + ((this.f18675c - f2) * valueAnimator.getAnimatedFraction())));
        }

        /* synthetic */ l(b bVar, a aVar) {
            this();
        }
    }

    b(FloatingActionButton floatingActionButton, e.e.b.c.z.b bVar) {
        this.F = floatingActionButton;
        this.G = bVar;
        com.google.android.material.internal.f fVar = new com.google.android.material.internal.f();
        this.s = fVar;
        fVar.a(f18652b, i(new h()));
        fVar.a(f18653c, i(new g()));
        fVar.a(f18654d, i(new g()));
        fVar.a(f18655e, i(new g()));
        fVar.a(f18656f, i(new k()));
        fVar.a(f18657g, i(new f()));
        this.y = floatingActionButton.getRotation();
    }

    private boolean a0() {
        return u.O(this.F) && !this.F.isInEditMode();
    }

    private void g(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.F.getDrawable();
        if (drawable == null || this.A == 0) {
            return;
        }
        RectF rectF = this.I;
        RectF rectF2 = this.J;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i2 = this.A;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.A;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    private AnimatorSet h(e.e.b.c.m.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        hVar.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        hVar.e("scale").a(objectAnimatorOfFloat2);
        h0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        hVar.e("scale").a(objectAnimatorOfFloat3);
        h0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        g(f4, this.K);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.F, new e.e.b.c.m.f(), new c(), new Matrix(this.K));
        hVar.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        e.e.b.c.m.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void h0(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new d());
    }

    private ValueAnimator i(l lVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(lVar);
        valueAnimator.addUpdateListener(lVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private e.e.b.c.m.h l() {
        if (this.u == null) {
            this.u = e.e.b.c.m.h.c(this.F.getContext(), e.e.b.c.a.a);
        }
        return (e.e.b.c.m.h) c.i.j.i.c(this.u);
    }

    private e.e.b.c.m.h m() {
        if (this.t == null) {
            this.t = e.e.b.c.m.h.c(this.F.getContext(), e.e.b.c.a.f20885b);
        }
        return (e.e.b.c.m.h) c.i.j.i.c(this.t);
    }

    private ViewTreeObserver.OnPreDrawListener r() {
        if (this.L == null) {
            this.L = new e();
        }
        return this.L;
    }

    void A() {
        this.s.c();
    }

    void B() {
        e.e.b.c.a0.g gVar = this.f18659i;
        if (gVar != null) {
            e.e.b.c.a0.h.f(this.F, gVar);
        }
        if (K()) {
            this.F.getViewTreeObserver().addOnPreDrawListener(r());
        }
    }

    void C() {
    }

    void D() {
        ViewTreeObserver viewTreeObserver = this.F.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.L;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.L = null;
        }
    }

    void E(int[] iArr) {
        this.s.d(iArr);
    }

    void F(float f2, float f3, float f4) {
        f0();
        g0(f2);
    }

    void G(Rect rect) {
        c.i.j.i.d(this.l, "Didn't initialize content background");
        if (!Z()) {
            this.G.b(this.l);
        } else {
            this.G.b(new InsetDrawable(this.l, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void H() {
        float rotation = this.F.getRotation();
        if (this.y != rotation) {
            this.y = rotation;
            d0();
        }
    }

    void I() {
        ArrayList<i> arrayList = this.E;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    void J() {
        ArrayList<i> arrayList = this.E;
        if (arrayList != null) {
            Iterator<i> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    boolean K() {
        return true;
    }

    void L(ColorStateList colorStateList) {
        e.e.b.c.a0.g gVar = this.f18659i;
        if (gVar != null) {
            gVar.setTintList(colorStateList);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f18661k;
        if (aVar != null) {
            aVar.c(colorStateList);
        }
    }

    void M(PorterDuff.Mode mode) {
        e.e.b.c.a0.g gVar = this.f18659i;
        if (gVar != null) {
            gVar.setTintMode(mode);
        }
    }

    final void N(float f2) {
        if (this.o != f2) {
            this.o = f2;
            F(f2, this.p, this.q);
        }
    }

    void O(boolean z) {
        this.m = z;
    }

    final void P(e.e.b.c.m.h hVar) {
        this.x = hVar;
    }

    final void Q(float f2) {
        if (this.p != f2) {
            this.p = f2;
            F(this.o, f2, this.q);
        }
    }

    final void R(float f2) {
        this.z = f2;
        Matrix matrix = this.K;
        g(f2, matrix);
        this.F.setImageMatrix(matrix);
    }

    final void S(int i2) {
        if (this.A != i2) {
            this.A = i2;
            e0();
        }
    }

    void T(int i2) {
        this.r = i2;
    }

    final void U(float f2) {
        if (this.q != f2) {
            this.q = f2;
            F(this.o, this.p, f2);
        }
    }

    void V(ColorStateList colorStateList) {
        Drawable drawable = this.f18660j;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, e.e.b.c.y.b.d(colorStateList));
        }
    }

    void W(boolean z) {
        this.n = z;
        f0();
    }

    final void X(e.e.b.c.a0.k kVar) {
        this.f18658h = kVar;
        e.e.b.c.a0.g gVar = this.f18659i;
        if (gVar != null) {
            gVar.setShapeAppearanceModel(kVar);
        }
        Object obj = this.f18660j;
        if (obj instanceof n) {
            ((n) obj).setShapeAppearanceModel(kVar);
        }
        com.google.android.material.floatingactionbutton.a aVar = this.f18661k;
        if (aVar != null) {
            aVar.f(kVar);
        }
    }

    final void Y(e.e.b.c.m.h hVar) {
        this.w = hVar;
    }

    boolean Z() {
        return true;
    }

    final boolean b0() {
        return !this.m || this.F.getSizeDimension() >= this.r;
    }

    void c0(j jVar, boolean z) {
        if (z()) {
            return;
        }
        Animator animator = this.v;
        if (animator != null) {
            animator.cancel();
        }
        if (!a0()) {
            this.F.b(0, z);
            this.F.setAlpha(1.0f);
            this.F.setScaleY(1.0f);
            this.F.setScaleX(1.0f);
            R(1.0f);
            if (jVar != null) {
                jVar.a();
                return;
            }
            return;
        }
        if (this.F.getVisibility() != 0) {
            this.F.setAlpha(0.0f);
            this.F.setScaleY(0.0f);
            this.F.setScaleX(0.0f);
            R(0.0f);
        }
        e.e.b.c.m.h hVarM = this.w;
        if (hVarM == null) {
            hVarM = m();
        }
        AnimatorSet animatorSetH = h(hVarM, 1.0f, 1.0f, 1.0f);
        animatorSetH.addListener(new C0199b(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.C;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetH.addListener(it.next());
            }
        }
        animatorSetH.start();
    }

    public void d(Animator.AnimatorListener animatorListener) {
        if (this.D == null) {
            this.D = new ArrayList<>();
        }
        this.D.add(animatorListener);
    }

    void d0() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.y % 90.0f != 0.0f) {
                if (this.F.getLayerType() != 1) {
                    this.F.setLayerType(1, null);
                }
            } else if (this.F.getLayerType() != 0) {
                this.F.setLayerType(0, null);
            }
        }
        e.e.b.c.a0.g gVar = this.f18659i;
        if (gVar != null) {
            gVar.d0((int) this.y);
        }
    }

    void e(Animator.AnimatorListener animatorListener) {
        if (this.C == null) {
            this.C = new ArrayList<>();
        }
        this.C.add(animatorListener);
    }

    final void e0() {
        R(this.z);
    }

    void f(i iVar) {
        if (this.E == null) {
            this.E = new ArrayList<>();
        }
        this.E.add(iVar);
    }

    final void f0() {
        Rect rect = this.H;
        s(rect);
        G(rect);
        this.G.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void g0(float f2) {
        e.e.b.c.a0.g gVar = this.f18659i;
        if (gVar != null) {
            gVar.W(f2);
        }
    }

    e.e.b.c.a0.g j() {
        return new e.e.b.c.a0.g((e.e.b.c.a0.k) c.i.j.i.c(this.f18658h));
    }

    final Drawable k() {
        return this.l;
    }

    float n() {
        return this.o;
    }

    boolean o() {
        return this.m;
    }

    final e.e.b.c.m.h p() {
        return this.x;
    }

    float q() {
        return this.p;
    }

    void s(Rect rect) {
        int sizeDimension = this.m ? (this.r - this.F.getSizeDimension()) / 2 : 0;
        float fN = this.n ? n() + this.q : 0.0f;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(fN));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(fN * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    float t() {
        return this.q;
    }

    final e.e.b.c.a0.k u() {
        return this.f18658h;
    }

    final e.e.b.c.m.h v() {
        return this.w;
    }

    void w(j jVar, boolean z) {
        if (y()) {
            return;
        }
        Animator animator = this.v;
        if (animator != null) {
            animator.cancel();
        }
        if (!a0()) {
            this.F.b(z ? 8 : 4, z);
            if (jVar != null) {
                jVar.b();
                return;
            }
            return;
        }
        e.e.b.c.m.h hVarL = this.x;
        if (hVarL == null) {
            hVarL = l();
        }
        AnimatorSet animatorSetH = h(hVarL, 0.0f, 0.0f, 0.0f);
        animatorSetH.addListener(new a(z, jVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.D;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetH.addListener(it.next());
            }
        }
        animatorSetH.start();
    }

    void x(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        e.e.b.c.a0.g gVarJ = j();
        this.f18659i = gVarJ;
        gVarJ.setTintList(colorStateList);
        if (mode != null) {
            this.f18659i.setTintMode(mode);
        }
        this.f18659i.c0(-12303292);
        this.f18659i.N(this.F.getContext());
        e.e.b.c.y.a aVar = new e.e.b.c.y.a(this.f18659i.D());
        aVar.setTintList(e.e.b.c.y.b.d(colorStateList2));
        this.f18660j = aVar;
        this.l = new LayerDrawable(new Drawable[]{(Drawable) c.i.j.i.c(this.f18659i), aVar});
    }

    boolean y() {
        if (this.F.getVisibility() == 0) {
            return this.B == 1;
        }
        return this.B != 2;
    }

    boolean z() {
        if (this.F.getVisibility() != 0) {
            return this.B == 2;
        }
        return this.B != 1;
    }
}
