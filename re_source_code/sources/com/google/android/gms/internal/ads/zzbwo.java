package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwo implements zzdti<zzbgz> {
    private final zzbvz a;

    private zzbwo(zzbvz zzbvzVar) {
        this.a = zzbvzVar;
    }

    public static zzbwo a(zzbvz zzbvzVar) {
        return new zzbwo(zzbvzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return this.a.b();
    }
}
