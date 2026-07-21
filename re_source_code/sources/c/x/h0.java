package c.x;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi29.java */
/* JADX INFO: loaded from: classes.dex */
class h0 extends g0 {
    h0() {
    }

    @Override // c.x.d0, c.x.i0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // c.x.f0, c.x.i0
    public void e(View view, int i2, int i3, int i4, int i5) {
        view.setLeftTopRightBottom(i2, i3, i4, i5);
    }

    @Override // c.x.d0, c.x.i0
    public void f(View view, float f2) {
        view.setTransitionAlpha(f2);
    }

    @Override // c.x.g0, c.x.i0
    public void g(View view, int i2) {
        view.setTransitionVisibility(i2);
    }

    @Override // c.x.e0, c.x.i0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // c.x.e0, c.x.i0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
