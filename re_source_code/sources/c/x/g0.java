package c.x;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: ViewUtilsApi23.java */
/* JADX INFO: loaded from: classes.dex */
class g0 extends f0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f3563i = true;

    g0() {
    }

    @Override // c.x.i0
    @SuppressLint({"NewApi"})
    public void g(View view, int i2) {
        if (Build.VERSION.SDK_INT == 28) {
            super.g(view, i2);
        } else if (f3563i) {
            try {
                view.setTransitionVisibility(i2);
            } catch (NoSuchMethodError unused) {
                f3563i = false;
            }
        }
    }
}
