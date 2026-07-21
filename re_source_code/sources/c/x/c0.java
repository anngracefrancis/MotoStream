package c.x;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
class c0 {
    private static final i0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Property<View, Float> f3545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Property<View, Rect> f3546c;

    /* JADX INFO: compiled from: ViewUtils.java */
    static class a extends Property<View, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(c0.c(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f2) {
            c0.g(view, f2.floatValue());
        }
    }

    /* JADX INFO: compiled from: ViewUtils.java */
    static class b extends Property<View, Rect> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return androidx.core.view.u.r(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            androidx.core.view.u.p0(view, rect);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            a = new h0();
        } else if (i2 >= 23) {
            a = new g0();
        } else if (i2 >= 22) {
            a = new f0();
        } else if (i2 >= 21) {
            a = new e0();
        } else if (i2 >= 19) {
            a = new d0();
        } else {
            a = new i0();
        }
        f3545b = new a(Float.class, "translationAlpha");
        f3546c = new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        a.a(view);
    }

    static b0 b(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new a0(view) : z.e(view);
    }

    static float c(View view) {
        return a.c(view);
    }

    static m0 d(View view) {
        return Build.VERSION.SDK_INT >= 18 ? new l0(view) : new k0(view.getWindowToken());
    }

    static void e(View view) {
        a.d(view);
    }

    static void f(View view, int i2, int i3, int i4, int i5) {
        a.e(view, i2, i3, i4, i5);
    }

    static void g(View view, float f2) {
        a.f(view, f2);
    }

    static void h(View view, int i2) {
        a.g(view, i2);
    }

    static void i(View view, Matrix matrix) {
        a.h(view, matrix);
    }

    static void j(View view, Matrix matrix) {
        a.i(view, matrix);
    }
}
