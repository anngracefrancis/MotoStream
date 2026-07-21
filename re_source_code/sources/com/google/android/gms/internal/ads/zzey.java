package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzey extends zzfk {
    public zzey(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.f16224j) {
            zzdl zzdlVar = new zzdl((String) this.f16225k.invoke(null, this.f16221g.a()));
            synchronized (this.f16224j) {
                this.f16224j.D(zzdlVar.f15969b);
                this.f16224j.o0(zzdlVar.f15970c);
            }
        }
    }
}
