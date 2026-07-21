package c.x;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ViewUtilsBase.java */
/* JADX INFO: loaded from: classes.dex */
class i0 {
    private static Method a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f3569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f3570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f3571d;

    i0() {
    }

    @SuppressLint({"PrivateApi"})
    private void b() {
        if (f3569b) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            a = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i("ViewUtilsBase", "Failed to retrieve setFrame method", e2);
        }
        f3569b = true;
    }

    public void a(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(j.a, null);
        }
    }

    public float c(View view) {
        Float f2 = (Float) view.getTag(j.a);
        return f2 != null ? view.getAlpha() / f2.floatValue() : view.getAlpha();
    }

    public void d(View view) {
        int i2 = j.a;
        if (view.getTag(i2) == null) {
            view.setTag(i2, Float.valueOf(view.getAlpha()));
        }
    }

    public void e(View view, int i2, int i3, int i4, int i5) {
        b();
        Method method = a;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    public void f(View view, float f2) {
        Float f3 = (Float) view.getTag(j.a);
        if (f3 != null) {
            view.setAlpha(f3.floatValue() * f2);
        } else {
            view.setAlpha(f2);
        }
    }

    public void g(View view, int i2) {
        if (!f3571d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f3570c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f3571d = true;
        }
        Field field = f3570c;
        if (field != null) {
            try {
                f3570c.setInt(view, i2 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void h(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            h(view2, matrix);
            matrix.preTranslate(-view2.getScrollX(), -view2.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void i(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i(view2, matrix);
            matrix.postTranslate(view2.getScrollX(), view2.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }
}
