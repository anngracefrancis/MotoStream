package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class zzrd implements zzrm {
    private final zzra a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16645b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f16646c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzlh[] f16647d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long[] f16648e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f16649f;

    public zzrd(zzra zzraVar, int... iArr) {
        int i2 = 0;
        zzsk.e(iArr.length > 0);
        this.a = (zzra) zzsk.d(zzraVar);
        int length = iArr.length;
        this.f16645b = length;
        this.f16647d = new zzlh[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.f16647d[i3] = zzraVar.a(iArr[i3]);
        }
        Arrays.sort(this.f16647d, new k30());
        this.f16646c = new int[this.f16645b];
        while (true) {
            int i4 = this.f16645b;
            if (i2 >= i4) {
                this.f16648e = new long[i4];
                return;
            } else {
                this.f16646c[i2] = zzraVar.b(this.f16647d[i2]);
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final zzra a() {
        return this.a;
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final int b(int i2) {
        return this.f16646c[0];
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final zzlh c(int i2) {
        return this.f16647d[i2];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzrd zzrdVar = (zzrd) obj;
            if (this.a == zzrdVar.a && Arrays.equals(this.f16646c, zzrdVar.f16646c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f16649f == 0) {
            this.f16649f = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.f16646c);
        }
        return this.f16649f;
    }

    @Override // com.google.android.gms.internal.ads.zzrm
    public final int length() {
        return this.f16646c.length;
    }
}
