package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxm implements zzdti<zzbxk> {
    private final zzbxk a;

    private zzbxm(zzbxk zzbxkVar) {
        this.a = zzbxkVar;
    }

    public static zzbxm a(zzbxk zzbxkVar) {
        return new zzbxm(zzbxkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbxk zzbxkVar = this.a;
        zzbxkVar.getClass();
        return (zzbxk) zzdto.b(zzbxkVar, "Cannot return null from a non-@Nullable @Provides method");
    }
}
