package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: compiled from: AppCompatCompoundButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
class g {
    private final CompoundButton a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f517b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f518c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f519d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f520e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f521f;

    g(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    void a() {
        Drawable drawableA = androidx.core.widget.e.a(this.a);
        if (drawableA != null) {
            if (this.f519d || this.f520e) {
                Drawable drawableMutate = androidx.core.graphics.drawable.a.r(drawableA).mutate();
                if (this.f519d) {
                    androidx.core.graphics.drawable.a.o(drawableMutate, this.f517b);
                }
                if (this.f520e) {
                    androidx.core.graphics.drawable.a.p(drawableMutate, this.f518c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(drawableMutate);
            }
        }
    }

    int b(int i2) {
        Drawable drawableA;
        return (Build.VERSION.SDK_INT >= 17 || (drawableA = androidx.core.widget.e.a(this.a)) == null) ? i2 : i2 + drawableA.getIntrinsicWidth();
    }

    ColorStateList c() {
        return this.f517b;
    }

    PorterDuff.Mode d() {
        return this.f518c;
    }

    void e(AttributeSet attributeSet, int i2) {
        boolean z;
        int iN;
        int iN2;
        Context context = this.a.getContext();
        int[] iArr = c.a.j.R0;
        q0 q0VarV = q0.v(context, attributeSet, iArr, i2, 0);
        CompoundButton compoundButton = this.a;
        androidx.core.view.u.g0(compoundButton, compoundButton.getContext(), iArr, attributeSet, q0VarV.r(), i2, 0);
        try {
            int i3 = c.a.j.T0;
            if (!q0VarV.s(i3) || (iN2 = q0VarV.n(i3, 0)) == 0) {
                z = false;
            } else {
                try {
                    CompoundButton compoundButton2 = this.a;
                    compoundButton2.setButtonDrawable(c.a.k.a.a.d(compoundButton2.getContext(), iN2));
                    z = true;
                } catch (Resources.NotFoundException unused) {
                    z = false;
                }
            }
            if (!z) {
                int i4 = c.a.j.S0;
                if (q0VarV.s(i4) && (iN = q0VarV.n(i4, 0)) != 0) {
                    CompoundButton compoundButton3 = this.a;
                    compoundButton3.setButtonDrawable(c.a.k.a.a.d(compoundButton3.getContext(), iN));
                }
            }
            int i5 = c.a.j.U0;
            if (q0VarV.s(i5)) {
                androidx.core.widget.e.c(this.a, q0VarV.c(i5));
            }
            int i6 = c.a.j.V0;
            if (q0VarV.s(i6)) {
                androidx.core.widget.e.d(this.a, y.e(q0VarV.k(i6, -1), null));
            }
        } finally {
            q0VarV.w();
        }
    }

    void f() {
        if (this.f521f) {
            this.f521f = false;
        } else {
            this.f521f = true;
            a();
        }
    }

    void g(ColorStateList colorStateList) {
        this.f517b = colorStateList;
        this.f519d = true;
        a();
    }

    void h(PorterDuff.Mode mode) {
        this.f518c = mode;
        this.f520e = true;
        a();
    }
}
