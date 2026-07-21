package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzek extends zzfk {
    private final Activity n;
    private final View o;

    public zzek(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3, View view, Activity activity) {
        super(zzdyVar, str, str2, c0176zza, i2, 62);
        this.o = view;
        this.n = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        if (this.o == null) {
            return;
        }
        boolean zBooleanValue = ((Boolean) zzyt.e().c(zzacu.m2)).booleanValue();
        Object[] objArr = (Object[]) this.f16225k.invoke(null, this.o, this.n, Boolean.valueOf(zBooleanValue));
        synchronized (this.f16224j) {
            this.f16224j.r0(((Long) objArr[0]).longValue());
            this.f16224j.s0(((Long) objArr[1]).longValue());
            if (zBooleanValue) {
                this.f16224j.B((String) objArr[2]);
            }
        }
    }
}
