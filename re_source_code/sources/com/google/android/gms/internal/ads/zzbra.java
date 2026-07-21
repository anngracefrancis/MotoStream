package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbra implements zzdti<String> {
    private final zzbqy a;

    private zzbra(zzbqy zzbqyVar) {
        this.a = zzbqyVar;
    }

    public static zzbra a(zzbqy zzbqyVar) {
        return new zzbra(zzbqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return this.a.d();
    }
}
