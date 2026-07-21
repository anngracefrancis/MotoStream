package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzayq {
    private final String[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double[] f14282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double[] f14283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f14284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14285e;

    private zzayq(zzayt zzaytVar) {
        int size = zzaytVar.f14290b.size();
        this.a = (String[]) zzaytVar.a.toArray(new String[size]);
        this.f14282b = b(zzaytVar.f14290b);
        this.f14283c = b(zzaytVar.f14291c);
        this.f14284d = new int[size];
        this.f14285e = 0;
    }

    private static double[] b(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = list.get(i2).doubleValue();
        }
        return dArr;
    }

    public final void a(double d2) {
        this.f14285e++;
        int i2 = 0;
        while (true) {
            double[] dArr = this.f14283c;
            if (i2 >= dArr.length) {
                return;
            }
            if (dArr[i2] <= d2 && d2 < this.f14282b[i2]) {
                int[] iArr = this.f14284d;
                iArr[i2] = iArr[i2] + 1;
            }
            if (d2 < dArr[i2]) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final List<zzays> c() {
        ArrayList arrayList = new ArrayList(this.a.length);
        int i2 = 0;
        while (true) {
            String[] strArr = this.a;
            if (i2 >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i2];
            double d2 = this.f14283c[i2];
            double d3 = this.f14282b[i2];
            int[] iArr = this.f14284d;
            double d4 = iArr[i2];
            double d5 = this.f14285e;
            Double.isNaN(d4);
            Double.isNaN(d5);
            arrayList.add(new zzays(str, d2, d3, d4 / d5, iArr[i2]));
            i2++;
        }
    }
}
