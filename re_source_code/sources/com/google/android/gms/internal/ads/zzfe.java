package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfe extends zzfk {
    private final zzeh n;
    private long o;

    public zzfe(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, zzeh zzehVar) {
        super(zzdyVar, str, str2, c0176zza, i2, 53);
        this.n = zzehVar;
        if (zzehVar != null) {
            this.o = zzehVar.d();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.n != null) {
            this.f16224j.m0(((Long) this.f16225k.invoke(null, Long.valueOf(this.o))).longValue());
        }
    }
}
