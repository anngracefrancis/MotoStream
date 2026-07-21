package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzh implements zzdti<zzbyt> {
    private final zzbzf a;

    private zzbzh(zzbzf zzbzfVar) {
        this.a = zzbzfVar;
    }

    public static zzbzh a(zzbzf zzbzfVar) {
        return new zzbzh(zzbzfVar);
    }

    public static zzbyt b(zzbzf zzbzfVar) {
        return (zzbyt) zzdto.b(zzbzfVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b(this.a);
    }
}
