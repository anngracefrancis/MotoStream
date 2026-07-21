package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: AppCompatImageHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class l {
    private final ImageView a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private o0 f573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o0 f574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private o0 f575d;

    public l(ImageView imageView) {
        this.a = imageView;
    }

    private boolean a(Drawable drawable) {
        if (this.f575d == null) {
            this.f575d = new o0();
        }
        o0 o0Var = this.f575d;
        o0Var.a();
        ColorStateList colorStateListA = androidx.core.widget.g.a(this.a);
        if (colorStateListA != null) {
            o0Var.f596d = true;
            o0Var.a = colorStateListA;
        }
        PorterDuff.Mode modeB = androidx.core.widget.g.b(this.a);
        if (modeB != null) {
            o0Var.f595c = true;
            o0Var.f594b = modeB;
        }
        if (!o0Var.f596d && !o0Var.f595c) {
            return false;
        }
        h.i(drawable, o0Var, this.a.getDrawableState());
        return true;
    }

    private boolean j() {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 > 21) {
            return this.f573b != null;
        }
        return i2 == 21;
    }

    void b() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            y.b(drawable);
        }
        if (drawable != null) {
            if (j() && a(drawable)) {
                return;
            }
            o0 o0Var = this.f574c;
            if (o0Var != null) {
                h.i(drawable, o0Var, this.a.getDrawableState());
                return;
            }
            o0 o0Var2 = this.f573b;
            if (o0Var2 != null) {
                h.i(drawable, o0Var2, this.a.getDrawableState());
            }
        }
    }

    ColorStateList c() {
        o0 o0Var = this.f574c;
        if (o0Var != null) {
            return o0Var.a;
        }
        return null;
    }

    PorterDuff.Mode d() {
        o0 o0Var = this.f574c;
        if (o0Var != null) {
            return o0Var.f594b;
        }
        return null;
    }

    boolean e() {
        return Build.VERSION.SDK_INT < 21 || !(this.a.getBackground() instanceof RippleDrawable);
    }

    public void f(AttributeSet attributeSet, int i2) {
        int iN;
        Context context = this.a.getContext();
        int[] iArr = c.a.j.R;
        q0 q0VarV = q0.v(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.a;
        androidx.core.view.u.g0(imageView, imageView.getContext(), iArr, attributeSet, q0VarV.r(), i2, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (iN = q0VarV.n(c.a.j.S, -1)) != -1 && (drawable = c.a.k.a.a.d(this.a.getContext(), iN)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                y.b(drawable);
            }
            int i3 = c.a.j.T;
            if (q0VarV.s(i3)) {
                androidx.core.widget.g.c(this.a, q0VarV.c(i3));
            }
            int i4 = c.a.j.U;
            if (q0VarV.s(i4)) {
                androidx.core.widget.g.d(this.a, y.e(q0VarV.k(i4, -1), null));
            }
        } finally {
            q0VarV.w();
        }
    }

    public void g(int i2) {
        if (i2 != 0) {
            Drawable drawableD = c.a.k.a.a.d(this.a.getContext(), i2);
            if (drawableD != null) {
                y.b(drawableD);
            }
            this.a.setImageDrawable(drawableD);
        } else {
            this.a.setImageDrawable(null);
        }
        b();
    }

    void h(ColorStateList colorStateList) {
        if (this.f574c == null) {
            this.f574c = new o0();
        }
        o0 o0Var = this.f574c;
        o0Var.a = colorStateList;
        o0Var.f596d = true;
        b();
    }

    void i(PorterDuff.Mode mode) {
        if (this.f574c == null) {
            this.f574c = new o0();
        }
        o0 o0Var = this.f574c;
        o0Var.f594b = mode;
        o0Var.f595c = true;
        b();
    }
}
