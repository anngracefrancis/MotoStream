package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class zzjr implements zzjl {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzjk[] f16365d;

    public zzjr(int i2) {
        zzkh.a(true);
        this.a = 262144;
        this.f16365d = new zzjk[100];
    }

    private final synchronized int e() {
        return this.f16363b * this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzjl
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzjl
    public final synchronized zzjk b() {
        this.f16363b++;
        int i2 = this.f16364c;
        if (i2 <= 0) {
            return new zzjk(new byte[this.a], 0);
        }
        zzjk[] zzjkVarArr = this.f16365d;
        int i3 = i2 - 1;
        this.f16364c = i3;
        return zzjkVarArr[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzjl
    public final synchronized void c(zzjk zzjkVar) {
        zzkh.a(zzjkVar.a.length == this.a);
        this.f16363b--;
        int i2 = this.f16364c;
        zzjk[] zzjkVarArr = this.f16365d;
        if (i2 == zzjkVarArr.length) {
            this.f16365d = (zzjk[]) Arrays.copyOf(zzjkVarArr, zzjkVarArr.length << 1);
        }
        zzjk[] zzjkVarArr2 = this.f16365d;
        int i3 = this.f16364c;
        this.f16364c = i3 + 1;
        zzjkVarArr2[i3] = zzjkVar;
        notifyAll();
    }

    public final synchronized void d(int i2) throws InterruptedException {
        while (e() > i2) {
            wait();
        }
    }

    public final synchronized void f(int i2) {
        int iMax = Math.max(0, zzkq.g(0, this.a) - this.f16363b);
        int i3 = this.f16364c;
        if (iMax < i3) {
            Arrays.fill(this.f16365d, iMax, i3, (Object) null);
            this.f16364c = iMax;
        }
    }
}
