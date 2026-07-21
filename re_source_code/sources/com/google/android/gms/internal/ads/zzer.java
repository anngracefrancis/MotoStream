package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzer extends zzfk {
    private long n;

    public zzer(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, long j2, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 25);
        this.n = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.f16225k.invoke(null, new Object[0])).longValue();
        synchronized (this.f16224j) {
            this.f16224j.t0(jLongValue);
            long j2 = this.n;
            if (j2 != 0) {
                this.f16224j.M(jLongValue - j2);
                this.f16224j.P(this.n);
            }
        }
    }
}
