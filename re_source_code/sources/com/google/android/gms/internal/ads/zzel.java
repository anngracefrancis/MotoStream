package com.google.android.gms.internal.ads;

import android.provider.Settings;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzel extends zzfk {
    public zzel(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 49);
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.f16224j.x0(zzbz.ENUM_FAILURE);
        try {
            this.f16224j.x0(((Boolean) this.f16225k.invoke(null, this.f16221g.a())).booleanValue() ? zzbz.ENUM_TRUE : zzbz.ENUM_FALSE);
        } catch (InvocationTargetException e2) {
            if (!(e2.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e2;
            }
        }
    }
}
