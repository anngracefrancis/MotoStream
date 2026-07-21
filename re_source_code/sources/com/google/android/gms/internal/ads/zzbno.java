package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbno implements zzdti<View> {
    private final zzbnk a;

    public zzbno(zzbnk zzbnkVar) {
        this.a = zzbnkVar;
    }

    public static View a(zzbnk zzbnkVar) {
        return (View) zzdto.b(zzbnkVar.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
