package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzex extends zzfk {
    private static volatile String n;
    private static final Object o = new Object();

    public zzex(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.f16224j.A0("E");
        if (n == null) {
            synchronized (o) {
                if (n == null) {
                    n = (String) this.f16225k.invoke(null, new Object[0]);
                }
            }
        }
        synchronized (this.f16224j) {
            this.f16224j.A0(n);
        }
    }
}
