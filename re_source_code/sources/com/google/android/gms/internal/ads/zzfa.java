package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfa extends zzfk {
    private List<Long> n;

    public zzfa(zzdy zzdyVar, String str, String str2, zzbp.zza.C0176zza c0176zza, int i2, int i3) {
        super(zzdyVar, str, str2, c0176zza, i2, 31);
        this.n = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfk
    protected final void a() throws IllegalAccessException, InvocationTargetException {
        this.f16224j.Q(-1L);
        this.f16224j.R(-1L);
        if (this.n == null) {
            this.n = (List) this.f16225k.invoke(null, this.f16221g.a());
        }
        List<Long> list = this.n;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.f16224j) {
            this.f16224j.Q(this.n.get(0).longValue());
            this.f16224j.R(this.n.get(1).longValue());
        }
    }
}
