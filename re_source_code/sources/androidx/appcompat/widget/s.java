package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: AppCompatTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
class s {
    private final TextView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o0 f622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o0 f623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o0 f624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private o0 f625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private o0 f626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private o0 f627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private o0 f628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u f629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f630j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f631k = -1;
    private Typeface l;
    private boolean m;

    /* JADX INFO: compiled from: AppCompatTextHelper.java */
    class a extends androidx.core.content.d.f.c {
        final /* synthetic */ int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ WeakReference f633c;

        a(int i2, int i3, WeakReference weakReference) {
            this.a = i2;
            this.f632b = i3;
            this.f633c = weakReference;
        }

        @Override // androidx.core.content.d.f.c
        public void d(int i2) {
        }

        @Override // androidx.core.content.d.f.c
        public void e(Typeface typeface) {
            int i2;
            if (Build.VERSION.SDK_INT >= 28 && (i2 = this.a) != -1) {
                typeface = Typeface.create(typeface, i2, (this.f632b & 2) != 0);
            }
            s.this.n(this.f633c, typeface);
        }
    }

    s(TextView textView) {
        this.a = textView;
        this.f629i = new u(textView);
    }

    private void A(int i2, float f2) {
        this.f629i.y(i2, f2);
    }

    private void B(Context context, q0 q0Var) {
        String strO;
        this.f630j = q0Var.k(c.a.j.a3, this.f630j);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            int iK = q0Var.k(c.a.j.f3, -1);
            this.f631k = iK;
            if (iK != -1) {
                this.f630j = (this.f630j & 2) | 0;
            }
        }
        int i3 = c.a.j.e3;
        if (!q0Var.s(i3) && !q0Var.s(c.a.j.g3)) {
            int i4 = c.a.j.Z2;
            if (q0Var.s(i4)) {
                this.m = false;
                int iK2 = q0Var.k(i4, 1);
                if (iK2 == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (iK2 == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else {
                    if (iK2 != 3) {
                        return;
                    }
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        int i5 = c.a.j.g3;
        if (q0Var.s(i5)) {
            i3 = i5;
        }
        int i6 = this.f631k;
        int i7 = this.f630j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = q0Var.j(i3, this.f630j, new a(i6, i7, new WeakReference(this.a)));
                if (typefaceJ != null) {
                    if (i2 < 28 || this.f631k == -1) {
                        this.l = typefaceJ;
                    } else {
                        this.l = Typeface.create(Typeface.create(typefaceJ, 0), this.f631k, (this.f630j & 2) != 0);
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (strO = q0Var.o(i3)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT < 28 || this.f631k == -1) {
            this.l = Typeface.create(strO, this.f630j);
        } else {
            this.l = Typeface.create(Typeface.create(strO, 0), this.f631k, (this.f630j & 2) != 0);
        }
    }

    private void a(Drawable drawable, o0 o0Var) {
        if (drawable == null || o0Var == null) {
            return;
        }
        h.i(drawable, o0Var, this.a.getDrawableState());
    }

    private static o0 d(Context context, h hVar, int i2) {
        ColorStateList colorStateListF = hVar.f(context, i2);
        if (colorStateListF == null) {
            return null;
        }
        o0 o0Var = new o0();
        o0Var.f596d = true;
        o0Var.a = colorStateListF;
        return o0Var;
    }

    private void x(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView = this.a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
            return;
        }
        if (drawable == null && drawable2 == null && drawable3 == null && drawable4 == null) {
            return;
        }
        if (i2 >= 17) {
            Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] != null || compoundDrawablesRelative2[2] != null) {
                TextView textView2 = this.a;
                Drawable drawable7 = compoundDrawablesRelative2[0];
                if (drawable2 == null) {
                    drawable2 = compoundDrawablesRelative2[1];
                }
                Drawable drawable8 = compoundDrawablesRelative2[2];
                if (drawable4 == null) {
                    drawable4 = compoundDrawablesRelative2[3];
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                return;
            }
        }
        Drawable[] compoundDrawables = this.a.getCompoundDrawables();
        TextView textView3 = this.a;
        if (drawable == null) {
            drawable = compoundDrawables[0];
        }
        if (drawable2 == null) {
            drawable2 = compoundDrawables[1];
        }
        if (drawable3 == null) {
            drawable3 = compoundDrawables[2];
        }
        if (drawable4 == null) {
            drawable4 = compoundDrawables[3];
        }
        textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    private void y() {
        o0 o0Var = this.f628h;
        this.f622b = o0Var;
        this.f623c = o0Var;
        this.f624d = o0Var;
        this.f625e = o0Var;
        this.f626f = o0Var;
        this.f627g = o0Var;
    }

    void b() {
        if (this.f622b != null || this.f623c != null || this.f624d != null || this.f625e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.f622b);
            a(compoundDrawables[1], this.f623c);
            a(compoundDrawables[2], this.f624d);
            a(compoundDrawables[3], this.f625e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f626f == null && this.f627g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f626f);
            a(compoundDrawablesRelative[2], this.f627g);
        }
    }

    void c() {
        this.f629i.b();
    }

    int e() {
        return this.f629i.j();
    }

    int f() {
        return this.f629i.k();
    }

    int g() {
        return this.f629i.l();
    }

    int[] h() {
        return this.f629i.m();
    }

    int i() {
        return this.f629i.n();
    }

    ColorStateList j() {
        o0 o0Var = this.f628h;
        if (o0Var != null) {
            return o0Var.a;
        }
        return null;
    }

    PorterDuff.Mode k() {
        o0 o0Var = this.f628h;
        if (o0Var != null) {
            return o0Var.f594b;
        }
        return null;
    }

    boolean l() {
        return this.f629i.s();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:47:0x0104  */
    /* JADX WARN: Code duplicated, block: B:48:0x0109  */
    /* JADX WARN: Code duplicated, block: B:50:0x010c  */
    /* JADX WARN: Code duplicated, block: B:52:0x0114  */
    /* JADX WARN: Code duplicated, block: B:53:0x0119  */
    /* JADX WARN: Code duplicated, block: B:61:0x0140  */
    /* JADX WARN: Code duplicated, block: B:80:0x0187  */
    /* JADX WARN: Code duplicated, block: B:88:0x01a6  */
    @SuppressLint({"NewApi"})
    void m(AttributeSet attributeSet, int i2) {
        String strO;
        ColorStateList colorStateListC;
        String strO2;
        boolean zA;
        ColorStateList colorStateListC2;
        ColorStateList colorStateListC3;
        boolean z;
        int i3;
        String strO3;
        h hVar;
        int i4;
        int i5;
        int i6;
        Context context = this.a.getContext();
        h hVarB = h.b();
        int[] iArr = c.a.j.a0;
        q0 q0VarV = q0.v(context, attributeSet, iArr, i2, 0);
        TextView textView = this.a;
        androidx.core.view.u.g0(textView, textView.getContext(), iArr, attributeSet, q0VarV.r(), i2, 0);
        int iN = q0VarV.n(c.a.j.b0, -1);
        int i7 = c.a.j.e0;
        if (q0VarV.s(i7)) {
            this.f622b = d(context, hVarB, q0VarV.n(i7, 0));
        }
        int i8 = c.a.j.c0;
        if (q0VarV.s(i8)) {
            this.f623c = d(context, hVarB, q0VarV.n(i8, 0));
        }
        int i9 = c.a.j.f0;
        if (q0VarV.s(i9)) {
            this.f624d = d(context, hVarB, q0VarV.n(i9, 0));
        }
        int i10 = c.a.j.d0;
        if (q0VarV.s(i10)) {
            this.f625e = d(context, hVarB, q0VarV.n(i10, 0));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 17) {
            int i12 = c.a.j.g0;
            if (q0VarV.s(i12)) {
                this.f626f = d(context, hVarB, q0VarV.n(i12, 0));
            }
            int i13 = c.a.j.h0;
            if (q0VarV.s(i13)) {
                this.f627g = d(context, hVarB, q0VarV.n(i13, 0));
            }
        }
        q0VarV.w();
        boolean z2 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iN != -1) {
            q0 q0VarT = q0.t(context, iN, c.a.j.X2);
            if (z2) {
                zA = false;
                z = false;
            } else {
                int i14 = c.a.j.i3;
                if (q0VarT.s(i14)) {
                    zA = q0VarT.a(i14, false);
                    z = true;
                } else {
                    zA = false;
                    z = false;
                }
            }
            B(context, q0VarT);
            if (i11 < 23) {
                int i15 = c.a.j.b3;
                colorStateListC = q0VarT.s(i15) ? q0VarT.c(i15) : null;
                int i16 = c.a.j.c3;
                colorStateListC2 = q0VarT.s(i16) ? q0VarT.c(i16) : null;
                int i17 = c.a.j.d3;
                colorStateListC3 = q0VarT.s(i17) ? q0VarT.c(i17) : null;
                i5 = c.a.j.j3;
                if (q0VarT.s(i5)) {
                    strO2 = q0VarT.o(i5);
                } else {
                    strO2 = null;
                }
                if (i11 >= 26) {
                    i6 = c.a.j.h3;
                    if (q0VarT.s(i6)) {
                        strO = q0VarT.o(i6);
                    } else {
                        strO = null;
                    }
                } else {
                    strO = null;
                }
                q0VarT.w();
            } else {
                colorStateListC = null;
                colorStateListC2 = null;
            }
            i5 = c.a.j.j3;
            if (q0VarT.s(i5)) {
                strO2 = q0VarT.o(i5);
            } else {
                strO2 = null;
            }
            if (i11 >= 26) {
                i6 = c.a.j.h3;
                if (q0VarT.s(i6)) {
                    strO = q0VarT.o(i6);
                } else {
                    strO = null;
                }
            } else {
                strO = null;
            }
            q0VarT.w();
        } else {
            strO = null;
            colorStateListC = null;
            strO2 = null;
            zA = false;
            colorStateListC2 = null;
            colorStateListC3 = null;
            z = false;
        }
        q0 q0VarV2 = q0.v(context, attributeSet, c.a.j.X2, i2, 0);
        if (z2) {
            i3 = 23;
        } else {
            int i18 = c.a.j.i3;
            if (q0VarV2.s(i18)) {
                zA = q0VarV2.a(i18, false);
                i3 = 23;
                z = true;
            } else {
                i3 = 23;
            }
        }
        if (i11 < i3) {
            int i19 = c.a.j.b3;
            if (q0VarV2.s(i19)) {
                colorStateListC = q0VarV2.c(i19);
            }
            int i20 = c.a.j.c3;
            if (q0VarV2.s(i20)) {
                colorStateListC2 = q0VarV2.c(i20);
            }
            int i21 = c.a.j.d3;
            if (q0VarV2.s(i21)) {
                colorStateListC3 = q0VarV2.c(i21);
            }
        }
        int i22 = c.a.j.j3;
        if (q0VarV2.s(i22)) {
            strO2 = q0VarV2.o(i22);
        }
        if (i11 >= 26) {
            int i23 = c.a.j.h3;
            if (q0VarV2.s(i23)) {
                strO3 = q0VarV2.o(i23);
            } else {
                strO3 = strO;
            }
        } else {
            strO3 = strO;
        }
        if (i11 >= 28) {
            int i24 = c.a.j.Y2;
            if (q0VarV2.s(i24)) {
                hVar = hVarB;
                if (q0VarV2.f(i24, -1) == 0) {
                    this.a.setTextSize(0, 0.0f);
                }
            } else {
                hVar = hVarB;
            }
        } else {
            hVar = hVarB;
        }
        B(context, q0VarV2);
        q0VarV2.w();
        if (colorStateListC != null) {
            this.a.setTextColor(colorStateListC);
        }
        if (colorStateListC2 != null) {
            this.a.setHintTextColor(colorStateListC2);
        }
        if (colorStateListC3 != null) {
            this.a.setLinkTextColor(colorStateListC3);
        }
        if (!z2 && z) {
            r(zA);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.f631k == -1) {
                this.a.setTypeface(typeface, this.f630j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (strO3 != null) {
            this.a.setFontVariationSettings(strO3);
        }
        if (strO2 != null) {
            if (i11 >= 24) {
                this.a.setTextLocales(LocaleList.forLanguageTags(strO2));
            } else if (i11 >= 21) {
                this.a.setTextLocale(Locale.forLanguageTag(strO2.substring(0, strO2.indexOf(44))));
            }
        }
        this.f629i.t(attributeSet, i2);
        if (androidx.core.widget.d.a && this.f629i.n() != 0) {
            int[] iArrM = this.f629i.m();
            if (iArrM.length > 0) {
                if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                    this.a.setAutoSizeTextTypeUniformWithConfiguration(this.f629i.k(), this.f629i.j(), this.f629i.l(), 0);
                } else {
                    this.a.setAutoSizeTextTypeUniformWithPresetSizes(iArrM, 0);
                }
            }
        }
        q0 q0VarU = q0.u(context, attributeSet, c.a.j.i0);
        int iN2 = q0VarU.n(c.a.j.q0, -1);
        h hVar2 = hVar;
        Drawable drawableC = iN2 != -1 ? hVar2.c(context, iN2) : null;
        int iN3 = q0VarU.n(c.a.j.v0, -1);
        Drawable drawableC2 = iN3 != -1 ? hVar2.c(context, iN3) : null;
        int iN4 = q0VarU.n(c.a.j.r0, -1);
        Drawable drawableC3 = iN4 != -1 ? hVar2.c(context, iN4) : null;
        int iN5 = q0VarU.n(c.a.j.o0, -1);
        Drawable drawableC4 = iN5 != -1 ? hVar2.c(context, iN5) : null;
        int iN6 = q0VarU.n(c.a.j.s0, -1);
        Drawable drawableC5 = iN6 != -1 ? hVar2.c(context, iN6) : null;
        int iN7 = q0VarU.n(c.a.j.p0, -1);
        x(drawableC, drawableC2, drawableC3, drawableC4, drawableC5, iN7 != -1 ? hVar2.c(context, iN7) : null);
        int i25 = c.a.j.t0;
        if (q0VarU.s(i25)) {
            androidx.core.widget.k.g(this.a, q0VarU.c(i25));
        }
        int i26 = c.a.j.u0;
        if (q0VarU.s(i26)) {
            i4 = -1;
            androidx.core.widget.k.h(this.a, y.e(q0VarU.k(i26, -1), null));
        } else {
            i4 = -1;
        }
        int iF = q0VarU.f(c.a.j.w0, i4);
        int iF2 = q0VarU.f(c.a.j.x0, i4);
        int iF3 = q0VarU.f(c.a.j.y0, i4);
        q0VarU.w();
        if (iF != i4) {
            androidx.core.widget.k.j(this.a, iF);
        }
        if (iF2 != i4) {
            androidx.core.widget.k.k(this.a, iF2);
        }
        if (iF3 != i4) {
            androidx.core.widget.k.l(this.a, iF3);
        }
    }

    void n(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.m) {
            this.l = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f630j);
            }
        }
    }

    void o(boolean z, int i2, int i3, int i4, int i5) {
        if (androidx.core.widget.d.a) {
            return;
        }
        c();
    }

    void p() {
        b();
    }

    void q(Context context, int i2) {
        String strO;
        ColorStateList colorStateListC;
        q0 q0VarT = q0.t(context, i2, c.a.j.X2);
        int i3 = c.a.j.i3;
        if (q0VarT.s(i3)) {
            r(q0VarT.a(i3, false));
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            int i5 = c.a.j.b3;
            if (q0VarT.s(i5) && (colorStateListC = q0VarT.c(i5)) != null) {
                this.a.setTextColor(colorStateListC);
            }
        }
        int i6 = c.a.j.Y2;
        if (q0VarT.s(i6) && q0VarT.f(i6, -1) == 0) {
            this.a.setTextSize(0, 0.0f);
        }
        B(context, q0VarT);
        if (i4 >= 26) {
            int i7 = c.a.j.h3;
            if (q0VarT.s(i7) && (strO = q0VarT.o(i7)) != null) {
                this.a.setFontVariationSettings(strO);
            }
        }
        q0VarT.w();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.f630j);
        }
    }

    void r(boolean z) {
        this.a.setAllCaps(z);
    }

    void s(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f629i.u(i2, i3, i4, i5);
    }

    void t(int[] iArr, int i2) throws IllegalArgumentException {
        this.f629i.v(iArr, i2);
    }

    void u(int i2) {
        this.f629i.w(i2);
    }

    void v(ColorStateList colorStateList) {
        if (this.f628h == null) {
            this.f628h = new o0();
        }
        o0 o0Var = this.f628h;
        o0Var.a = colorStateList;
        o0Var.f596d = colorStateList != null;
        y();
    }

    void w(PorterDuff.Mode mode) {
        if (this.f628h == null) {
            this.f628h = new o0();
        }
        o0 o0Var = this.f628h;
        o0Var.f594b = mode;
        o0Var.f595c = mode != null;
        y();
    }

    void z(int i2, float f2) {
        if (androidx.core.widget.d.a || l()) {
            return;
        }
        A(i2, f2);
    }
}
