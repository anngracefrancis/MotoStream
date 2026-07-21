package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfd extends zzfk {
    public zzfd(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.f16224j) {
            zzdx zzdxVar = new zzdx((String) this.f16225k.invoke(null, new Object[0]));
            this.f16224j.k0(zzdxVar.f16180b.longValue());
            this.f16224j.l0(zzdxVar.f16181c.longValue());
        }
    }
}
