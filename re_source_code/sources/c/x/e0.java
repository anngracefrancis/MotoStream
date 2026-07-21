package c.x;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi21.java */
/* JADX INFO: loaded from: classes.dex */
class e0 extends d0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f3560f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static boolean f3561g = true;

    e0() {
    }

    @Override // c.x.i0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f3560f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f3560f = false;
            }
        }
    }

    @Override // c.x.i0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f3561g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f3561g = false;
            }
        }
    }
}
