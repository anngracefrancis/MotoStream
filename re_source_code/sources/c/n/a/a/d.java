package c.n.a.a;

import android.view.animation.Interpolator;

/* JADX INFO: compiled from: LookupTableInterpolator.java */
/* JADX INFO: loaded from: classes.dex */
abstract class d implements Interpolator {
    private final float[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f3357b;

    protected d(float[] fArr) {
        this.a = fArr;
        this.f3357b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f2) {
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.a;
        int iMin = Math.min((int) ((fArr.length - 1) * f2), fArr.length - 2);
        float f3 = this.f3357b;
        float f4 = (f2 - (iMin * f3)) / f3;
        float[] fArr2 = this.a;
        return fArr2[iMin] + (f4 * (fArr2[iMin + 1] - fArr2[iMin]));
    }
}
