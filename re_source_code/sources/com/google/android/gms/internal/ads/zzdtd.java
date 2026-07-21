package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdtd {
    public static final zzdtd a = new zzdtd(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzdtd f16158b = new zzdtd(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzdtd f16159c = new zzdtd(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzdtd f16160d = new zzdtd(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final double f16161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f16162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final double f16163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final double f16164h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final double f16165i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final double f16166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final double f16167k;
    private final double l;
    private final double m;

    private zzdtd(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.f16161e = d6;
        this.f16162f = d7;
        this.f16163g = d8;
        this.f16164h = d2;
        this.f16165i = d3;
        this.f16166j = d4;
        this.f16167k = d5;
        this.l = d9;
        this.m = d10;
    }

    public static zzdtd a(ByteBuffer byteBuffer) {
        double dE = zzbc.e(byteBuffer);
        double dE2 = zzbc.e(byteBuffer);
        double dF = zzbc.f(byteBuffer);
        return new zzdtd(dE, dE2, zzbc.e(byteBuffer), zzbc.e(byteBuffer), dF, zzbc.f(byteBuffer), zzbc.f(byteBuffer), zzbc.e(byteBuffer), zzbc.e(byteBuffer));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdtd.class != obj.getClass()) {
            return false;
        }
        zzdtd zzdtdVar = (zzdtd) obj;
        return Double.compare(zzdtdVar.f16164h, this.f16164h) == 0 && Double.compare(zzdtdVar.f16165i, this.f16165i) == 0 && Double.compare(zzdtdVar.f16166j, this.f16166j) == 0 && Double.compare(zzdtdVar.f16167k, this.f16167k) == 0 && Double.compare(zzdtdVar.l, this.l) == 0 && Double.compare(zzdtdVar.m, this.m) == 0 && Double.compare(zzdtdVar.f16161e, this.f16161e) == 0 && Double.compare(zzdtdVar.f16162f, this.f16162f) == 0 && Double.compare(zzdtdVar.f16163g, this.f16163g) == 0;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f16161e);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f16162f);
        int i2 = (((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
        long jDoubleToLongBits3 = Double.doubleToLongBits(this.f16163g);
        int i3 = (i2 * 31) + ((int) (jDoubleToLongBits3 ^ (jDoubleToLongBits3 >>> 32)));
        long jDoubleToLongBits4 = Double.doubleToLongBits(this.f16164h);
        int i4 = (i3 * 31) + ((int) (jDoubleToLongBits4 ^ (jDoubleToLongBits4 >>> 32)));
        long jDoubleToLongBits5 = Double.doubleToLongBits(this.f16165i);
        int i5 = (i4 * 31) + ((int) (jDoubleToLongBits5 ^ (jDoubleToLongBits5 >>> 32)));
        long jDoubleToLongBits6 = Double.doubleToLongBits(this.f16166j);
        int i6 = (i5 * 31) + ((int) (jDoubleToLongBits6 ^ (jDoubleToLongBits6 >>> 32)));
        long jDoubleToLongBits7 = Double.doubleToLongBits(this.f16167k);
        int i7 = (i6 * 31) + ((int) (jDoubleToLongBits7 ^ (jDoubleToLongBits7 >>> 32)));
        long jDoubleToLongBits8 = Double.doubleToLongBits(this.l);
        int i8 = (i7 * 31) + ((int) (jDoubleToLongBits8 ^ (jDoubleToLongBits8 >>> 32)));
        long jDoubleToLongBits9 = Double.doubleToLongBits(this.m);
        return (i8 * 31) + ((int) (jDoubleToLongBits9 ^ (jDoubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(a)) {
            return "Rotate 0°";
        }
        if (equals(f16158b)) {
            return "Rotate 90°";
        }
        if (equals(f16159c)) {
            return "Rotate 180°";
        }
        if (equals(f16160d)) {
            return "Rotate 270°";
        }
        double d2 = this.f16161e;
        double d3 = this.f16162f;
        double d4 = this.f16163g;
        double d5 = this.f16164h;
        double d6 = this.f16165i;
        double d7 = this.f16166j;
        double d8 = this.f16167k;
        double d9 = this.l;
        double d10 = this.m;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }
}
