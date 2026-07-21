package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfc extends zzfk {
    private final StackTraceElement[] n;

    public zzfc(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, StackTraceElement[] stackTraceElementArr) {
        super(zzdyVar, str, str2, c0176zza, i2, 45);
        this.n = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.n;
        if (stackTraceElementArr != null) {
            zzdw zzdwVar = new zzdw((String) this.f16225k.invoke(null, stackTraceElementArr));
            synchronized (this.f16224j) {
                this.f16224j.j0(zzdwVar.f16177b.longValue());
                if (zzdwVar.f16178c.booleanValue()) {
                    this.f16224j.y0(zzdwVar.f16179d.booleanValue() ? zzbz.ENUM_FALSE : zzbz.ENUM_TRUE);
                } else {
                    this.f16224j.y0(zzbz.ENUM_FAILURE);
                }
            }
        }
    }
}
