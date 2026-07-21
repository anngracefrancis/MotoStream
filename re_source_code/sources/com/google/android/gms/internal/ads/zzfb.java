package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfb extends zzfk {
    private final boolean n;

    public zzfb(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 61);
        this.n = zzdyVar.y();
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.f16225k.invoke(null, this.f16221g.a(), Boolean.valueOf(this.n))).longValue();
        synchronized (this.f16224j) {
            this.f16224j.q0(jLongValue);
        }
    }
}
