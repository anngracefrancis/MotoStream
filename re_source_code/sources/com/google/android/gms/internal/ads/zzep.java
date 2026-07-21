package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzep extends zzfk {
    public zzep(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 5);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.f16224j.E(-1L);
        this.f16224j.F(-1L);
        int[] iArr = (int[]) this.f16225k.invoke(null, this.f16221g.a());
        synchronized (this.f16224j) {
            this.f16224j.E(iArr[0]);
            this.f16224j.F(iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.f16224j.n0(iArr[2]);
            }
        }
    }
}
