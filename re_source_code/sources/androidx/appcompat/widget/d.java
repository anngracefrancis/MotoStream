package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: compiled from: AppCompatBackgroundHelper.java */
/* JADX INFO: loaded from: classes.dex */
class d {
    private final View a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o0 f498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private o0 f499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o0 f500f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f497c = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f496b = h.b();

    d(View view) {
        this.a = view;
    }

    private boolean a(Drawable drawable) {
        if (this.f500f == null) {
            this.f500f = new o0();
        }
        o0 o0Var = this.f500f;
        o0Var.a();
        ColorStateList colorStateListP = androidx.core.view.u.p(this.a);
        if (colorStateListP != null) {
            o0Var.f596d = true;
            o0Var.a = colorStateListP;
        }
        PorterDuff.Mode modeQ = androidx.core.view.u.q(this.a);
        if (modeQ != null) {
            o0Var.f595c = true;
            o0Var.f594b = modeQ;
        }
        if (!o0Var.f596d && !o0Var.f595c) {
            return false;
        }
        h.i(drawable, o0Var, this.a.getDrawableState());
        return true;
    }

    private boolean k() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 21) {
            return this.f498d != null;
        }
        return i2 == 21;
    }

    void b() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            if (k() && a(background)) {
                return;
            }
            o0 o0Var = this.f499e;
            if (o0Var != null) {
                h.i(background, o0Var, this.a.getDrawableState());
                return;
            }
            o0 o0Var2 = this.f498d;
            if (o0Var2 != null) {
                h.i(background, o0Var2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        o0 o0Var = this.f499e;
        if (o0Var != null) {
            return o0Var.a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        o0 o0Var = this.f499e;
        if (o0Var != null) {
            return o0Var.f594b;
        }
        return null;
    }

    void e(AttributeSet attributeSet, int i2) {
        Context context = this.a.getContext();
        int[] iArr = c.a.j.R3;
        q0 q0VarV = q0.v(context, attributeSet, iArr, i2, 0);
        View view = this.a;
        androidx.core.view.u.g0(view, view.getContext(), iArr, attributeSet, q0VarV.r(), i2, 0);
        try {
            int i3 = c.a.j.S3;
            if (q0VarV.s(i3)) {
                this.f497c = q0VarV.n(i3, -1);
                ColorStateList colorStateListF = this.f496b.f(this.a.getContext(), this.f497c);
                if (colorStateListF != null) {
                    h(colorStateListF);
                }
            }
            int i4 = c.a.j.T3;
            if (q0VarV.s(i4)) {
                androidx.core.view.u.n0(this.a, q0VarV.c(i4));
            }
            int i5 = c.a.j.U3;
            if (q0VarV.s(i5)) {
                androidx.core.view.u.o0(this.a, y.e(q0VarV.k(i5, -1), null));
            }
        } finally {
            q0VarV.w();
        }
    }

    void f(Drawable drawable) {
        this.f497c = -1;
        h(null);
        b();
    }

    void g(int i2) {
        this.f497c = i2;
        h hVar = this.f496b;
        h(hVar != null ? hVar.f(this.a.getContext(), i2) : null);
        b();
    }

    void h(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f498d == null) {
                this.f498d = new o0();
            }
            o0 o0Var = this.f498d;
            o0Var.a = colorStateList;
            o0Var.f596d = true;
        } else {
            this.f498d = null;
        }
        b();
    }

    void i(ColorStateList colorStateList) {
        if (this.f499e == null) {
            this.f499e = new o0();
        }
        o0 o0Var = this.f499e;
        o0Var.a = colorStateList;
        o0Var.f596d = true;
        b();
    }

    void j(PorterDuff.Mode mode) {
        if (this.f499e == null) {
            this.f499e = new o0();
        }
        o0 o0Var = this.f499e;
        o0Var.f594b = mode;
        o0Var.f595c = true;
        b();
    }
}
