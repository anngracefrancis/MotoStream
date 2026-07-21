package com.airbnb.lottie.s;

/* JADX INFO: compiled from: DocumentData.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f8688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f8689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f8690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final double f8692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f8693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f8694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final double f8696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f8697k;

    public b(String str, String str2, double d2, int i2, int i3, double d3, double d4, int i4, int i5, double d5, boolean z) {
        this.a = str;
        this.f8688b = str2;
        this.f8689c = d2;
        this.f8690d = i2;
        this.f8691e = i3;
        this.f8692f = d3;
        this.f8693g = d4;
        this.f8694h = i4;
        this.f8695i = i5;
        this.f8696j = d5;
        this.f8697k = z;
    }

    public int hashCode() {
        double dHashCode = ((this.a.hashCode() * 31) + this.f8688b.hashCode()) * 31;
        double d2 = this.f8689c;
        Double.isNaN(dHashCode);
        int i2 = (((((int) (dHashCode + d2)) * 31) + this.f8690d) * 31) + this.f8691e;
        long jDoubleToLongBits = Double.doubleToLongBits(this.f8692f);
        return (((i2 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + this.f8694h;
    }
}
