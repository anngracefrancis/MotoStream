package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcoy implements zzdti<zzcow> {
    private final zzcow a;

    private zzcoy(zzcow zzcowVar) {
        this.a = zzcowVar;
    }

    public static zzcoy a(zzcow zzcowVar) {
        return new zzcoy(zzcowVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzcow zzcowVar = this.a;
        zzcowVar.getClass();
        return (zzcow) zzdto.b(zzcowVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
