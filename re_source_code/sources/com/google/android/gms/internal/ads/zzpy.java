package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzpy implements zzqx {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzqx[] f16599f;

    public zzpy(zzqx[] zzqxVarArr) {
        this.f16599f = zzqxVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzqx
    public final long a() {
        long jMin = Long.MAX_VALUE;
        for (zzqx zzqxVar : this.f16599f) {
            long jA = zzqxVar.a();
            if (jA != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jA);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzqx
    public final boolean b(long j2) {
        boolean zB;
        boolean z = false;
        do {
            long jA = a();
            if (jA == Long.MIN_VALUE) {
                break;
            }
            zB = false;
            for (zzqx zzqxVar : this.f16599f) {
                if (zzqxVar.a() == jA) {
                    zB |= zzqxVar.b(j2);
                }
            }
            z |= zB;
        } while (zB);
        return z;
    }
}
