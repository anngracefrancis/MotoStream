package com.airbnb.lottie.s.j;

/* JADX INFO: compiled from: GradientColor.java */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private final float[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f8722b;

    public c(float[] fArr, int[] iArr) {
        this.a = fArr;
        this.f8722b = iArr;
    }

    public int[] a() {
        return this.f8722b;
    }

    public float[] b() {
        return this.a;
    }

    public int c() {
        return this.f8722b.length;
    }

    public void d(c cVar, c cVar2, float f2) {
        if (cVar.f8722b.length == cVar2.f8722b.length) {
            for (int i2 = 0; i2 < cVar.f8722b.length; i2++) {
                this.a[i2] = com.airbnb.lottie.v.e.j(cVar.a[i2], cVar2.a[i2], f2);
                this.f8722b[i2] = com.airbnb.lottie.v.b.c(f2, cVar.f8722b[i2], cVar2.f8722b[i2]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.f8722b.length + " vs " + cVar2.f8722b.length + ")");
    }
}
