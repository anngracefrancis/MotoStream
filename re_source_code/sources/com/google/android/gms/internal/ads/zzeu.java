package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzeu extends zzfk {
    private static volatile Long n;
    private static final Object o = new Object();

    public zzeu(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (n == null) {
            synchronized (o) {
                if (n == null) {
                    n = (Long) this.f16225k.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f16224j) {
            this.f16224j.O(n.longValue());
        }
    }
}
