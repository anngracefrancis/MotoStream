package androidx.core.view.e0;

import android.os.Build;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* JADX INFO: compiled from: PathInterpolatorCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static Interpolator a(float f2, float f3, float f4, float f5) {
        return Build.VERSION.SDK_INT >= 21 ? new PathInterpolator(f2, f3, f4, f5) : new a(f2, f3, f4, f5);
    }
}
