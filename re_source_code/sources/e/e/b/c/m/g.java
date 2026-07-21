package e.e.b.c.m;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* JADX INFO: compiled from: MatrixEvaluator.java */
/* JADX INFO: loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {
    private final float[] a = new float[9];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f21055b = new float[9];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Matrix f21056c = new Matrix();

    public Matrix a(float f2, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.a);
        matrix2.getValues(this.f21055b);
        for (int i2 = 0; i2 < 9; i2++) {
            float[] fArr = this.f21055b;
            float f3 = fArr[i2];
            float[] fArr2 = this.a;
            fArr[i2] = fArr2[i2] + ((f3 - fArr2[i2]) * f2);
        }
        this.f21056c.setValues(this.f21055b);
        return this.f21056c;
    }
}
