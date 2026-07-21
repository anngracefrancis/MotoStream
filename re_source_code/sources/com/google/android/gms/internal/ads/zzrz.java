package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzrz implements zzrt {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f16691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzrs[] f16692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f16693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f16695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzrs[] f16696h;

    public zzrz(boolean z, int i2) {
        this(true, 65536, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final int a() {
        return this.f16690b;
    }

    public final synchronized void b() {
        if (this.a) {
            c(0);
        }
    }

    public final synchronized void c(int i2) {
        boolean z = i2 < this.f16693e;
        this.f16693e = i2;
        if (z) {
            f();
        }
    }

    public final synchronized int d() {
        return this.f16694f * this.f16690b;
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized void f() {
        int iMax = Math.max(0, zzsy.j(this.f16693e, this.f16690b) - this.f16694f);
        int i2 = this.f16695g;
        if (iMax >= i2) {
            return;
        }
        Arrays.fill(this.f16696h, iMax, i2, (Object) null);
        this.f16695g = iMax;
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized void g(zzrs[] zzrsVarArr) {
        int i2 = this.f16695g;
        int length = zzrsVarArr.length + i2;
        zzrs[] zzrsVarArr2 = this.f16696h;
        if (length >= zzrsVarArr2.length) {
            this.f16696h = (zzrs[]) Arrays.copyOf(zzrsVarArr2, Math.max(zzrsVarArr2.length << 1, i2 + zzrsVarArr.length));
        }
        for (zzrs zzrsVar : zzrsVarArr) {
            byte[] bArr = zzrsVar.a;
            zzsk.a(bArr == null || bArr.length == this.f16690b);
            zzrs[] zzrsVarArr3 = this.f16696h;
            int i3 = this.f16695g;
            this.f16695g = i3 + 1;
            zzrsVarArr3[i3] = zzrsVar;
        }
        this.f16694f -= zzrsVarArr.length;
        notifyAll();
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized zzrs h() {
        zzrs zzrsVar;
        this.f16694f++;
        int i2 = this.f16695g;
        if (i2 > 0) {
            zzrs[] zzrsVarArr = this.f16696h;
            int i3 = i2 - 1;
            this.f16695g = i3;
            zzrsVar = zzrsVarArr[i3];
            zzrsVarArr[i3] = null;
        } else {
            zzrsVar = new zzrs(new byte[this.f16690b], 0);
        }
        return zzrsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzrt
    public final synchronized void i(zzrs zzrsVar) {
        zzrs[] zzrsVarArr = this.f16692d;
        zzrsVarArr[0] = zzrsVar;
        g(zzrsVarArr);
    }

    private zzrz(boolean z, int i2, int i3) {
        zzsk.a(true);
        zzsk.a(true);
        this.a = true;
        this.f16690b = 65536;
        this.f16695g = 0;
        this.f16696h = new zzrs[100];
        this.f16691c = null;
        this.f16692d = new zzrs[1];
    }
}
