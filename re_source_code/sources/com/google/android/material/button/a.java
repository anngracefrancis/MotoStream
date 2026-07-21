package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.core.view.u;
import e.e.b.c.a0.g;
import e.e.b.c.a0.k;
import e.e.b.c.a0.n;
import e.e.b.c.b;
import e.e.b.c.l;
import e.e.b.c.x.c;

/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes2.dex */
class a {
    private static final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MaterialButton f18513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private k f18514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18515d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18516e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18517f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18518g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18519h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18520i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private PorterDuff.Mode f18521j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f18522k;
    private ColorStateList l;
    private ColorStateList m;
    private Drawable n;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r;
    private LayerDrawable s;

    static {
        a = Build.VERSION.SDK_INT >= 21;
    }

    a(MaterialButton materialButton, k kVar) {
        this.f18513b = materialButton;
        this.f18514c = kVar;
    }

    private void A(k kVar) {
        if (d() != null) {
            d().setShapeAppearanceModel(kVar);
        }
        if (l() != null) {
            l().setShapeAppearanceModel(kVar);
        }
        if (c() != null) {
            c().setShapeAppearanceModel(kVar);
        }
    }

    private void C() {
        g gVarD = d();
        g gVarL = l();
        if (gVarD != null) {
            gVarD.f0(this.f18520i, this.l);
            if (gVarL != null) {
                gVarL.e0(this.f18520i, this.o ? e.e.b.c.q.a.c(this.f18513b, b.o) : 0);
            }
        }
    }

    private InsetDrawable D(Drawable drawable) {
        return new InsetDrawable(drawable, this.f18515d, this.f18517f, this.f18516e, this.f18518g);
    }

    private Drawable a() {
        g gVar = new g(this.f18514c);
        gVar.N(this.f18513b.getContext());
        androidx.core.graphics.drawable.a.o(gVar, this.f18522k);
        PorterDuff.Mode mode = this.f18521j;
        if (mode != null) {
            androidx.core.graphics.drawable.a.p(gVar, mode);
        }
        gVar.f0(this.f18520i, this.l);
        g gVar2 = new g(this.f18514c);
        gVar2.setTint(0);
        gVar2.e0(this.f18520i, this.o ? e.e.b.c.q.a.c(this.f18513b, b.o) : 0);
        if (a) {
            g gVar3 = new g(this.f18514c);
            this.n = gVar3;
            androidx.core.graphics.drawable.a.n(gVar3, -1);
            RippleDrawable rippleDrawable = new RippleDrawable(e.e.b.c.y.b.d(this.m), D(new LayerDrawable(new Drawable[]{gVar2, gVar})), this.n);
            this.s = rippleDrawable;
            return rippleDrawable;
        }
        e.e.b.c.y.a aVar = new e.e.b.c.y.a(this.f18514c);
        this.n = aVar;
        androidx.core.graphics.drawable.a.o(aVar, e.e.b.c.y.b.d(this.m));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{gVar2, gVar, this.n});
        this.s = layerDrawable;
        return D(layerDrawable);
    }

    private g e(boolean z) {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return a ? (g) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0) : (g) this.s.getDrawable(!z ? 1 : 0);
    }

    private g l() {
        return e(true);
    }

    void B(int i2, int i3) {
        Drawable drawable = this.n;
        if (drawable != null) {
            drawable.setBounds(this.f18515d, this.f18517f, i3 - this.f18516e, i2 - this.f18518g);
        }
    }

    int b() {
        return this.f18519h;
    }

    public n c() {
        LayerDrawable layerDrawable = this.s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.s.getNumberOfLayers() > 2 ? (n) this.s.getDrawable(2) : (n) this.s.getDrawable(1);
    }

    g d() {
        return e(false);
    }

    ColorStateList f() {
        return this.m;
    }

    k g() {
        return this.f18514c;
    }

    ColorStateList h() {
        return this.l;
    }

    int i() {
        return this.f18520i;
    }

    ColorStateList j() {
        return this.f18522k;
    }

    PorterDuff.Mode k() {
        return this.f18521j;
    }

    boolean m() {
        return this.p;
    }

    boolean n() {
        return this.r;
    }

    void o(TypedArray typedArray) {
        this.f18515d = typedArray.getDimensionPixelOffset(l.v2, 0);
        this.f18516e = typedArray.getDimensionPixelOffset(l.w2, 0);
        this.f18517f = typedArray.getDimensionPixelOffset(l.x2, 0);
        this.f18518g = typedArray.getDimensionPixelOffset(l.y2, 0);
        int i2 = l.C2;
        if (typedArray.hasValue(i2)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i2, -1);
            this.f18519h = dimensionPixelSize;
            u(this.f18514c.w(dimensionPixelSize));
            this.q = true;
        }
        this.f18520i = typedArray.getDimensionPixelSize(l.M2, 0);
        this.f18521j = com.google.android.material.internal.k.e(typedArray.getInt(l.B2, -1), PorterDuff.Mode.SRC_IN);
        this.f18522k = c.a(this.f18513b.getContext(), typedArray, l.A2);
        this.l = c.a(this.f18513b.getContext(), typedArray, l.L2);
        this.m = c.a(this.f18513b.getContext(), typedArray, l.K2);
        this.r = typedArray.getBoolean(l.z2, false);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(l.D2, 0);
        int iD = u.D(this.f18513b);
        int paddingTop = this.f18513b.getPaddingTop();
        int iC = u.C(this.f18513b);
        int paddingBottom = this.f18513b.getPaddingBottom();
        if (typedArray.hasValue(l.u2)) {
            q();
        } else {
            this.f18513b.setInternalBackground(a());
            g gVarD = d();
            if (gVarD != null) {
                gVarD.W(dimensionPixelSize2);
            }
        }
        u.w0(this.f18513b, iD + this.f18515d, paddingTop + this.f18517f, iC + this.f18516e, paddingBottom + this.f18518g);
    }

    void p(int i2) {
        if (d() != null) {
            d().setTint(i2);
        }
    }

    void q() {
        this.p = true;
        this.f18513b.setSupportBackgroundTintList(this.f18522k);
        this.f18513b.setSupportBackgroundTintMode(this.f18521j);
    }

    void r(boolean z) {
        this.r = z;
    }

    void s(int i2) {
        if (this.q && this.f18519h == i2) {
            return;
        }
        this.f18519h = i2;
        this.q = true;
        u(this.f18514c.w(i2));
    }

    void t(ColorStateList colorStateList) {
        if (this.m != colorStateList) {
            this.m = colorStateList;
            boolean z = a;
            if (z && (this.f18513b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f18513b.getBackground()).setColor(e.e.b.c.y.b.d(colorStateList));
            } else {
                if (z || !(this.f18513b.getBackground() instanceof e.e.b.c.y.a)) {
                    return;
                }
                ((e.e.b.c.y.a) this.f18513b.getBackground()).setTintList(e.e.b.c.y.b.d(colorStateList));
            }
        }
    }

    void u(k kVar) {
        this.f18514c = kVar;
        A(kVar);
    }

    void v(boolean z) {
        this.o = z;
        C();
    }

    void w(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            C();
        }
    }

    void x(int i2) {
        if (this.f18520i != i2) {
            this.f18520i = i2;
            C();
        }
    }

    void y(ColorStateList colorStateList) {
        if (this.f18522k != colorStateList) {
            this.f18522k = colorStateList;
            if (d() != null) {
                androidx.core.graphics.drawable.a.o(d(), this.f18522k);
            }
        }
    }

    void z(PorterDuff.Mode mode) {
        if (this.f18521j != mode) {
            this.f18521j = mode;
            if (d() == null || this.f18521j == null) {
                return;
            }
            androidx.core.graphics.drawable.a.p(d(), this.f18521j);
        }
    }
}
