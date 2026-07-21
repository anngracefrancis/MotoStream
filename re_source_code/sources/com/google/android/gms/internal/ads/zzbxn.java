package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxn implements zzdti<zzbzc> {
    private final zzbxk a;

    private zzbxn(zzbxk zzbxkVar) {
        this.a = zzbxkVar;
    }

    public static zzbxn a(zzbxk zzbxkVar) {
        return new zzbxn(zzbxkVar);
    }

    public static zzbzc b(zzbxk zzbxkVar) {
        return (zzbzc) zzdto.b(zzbxkVar.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return b(this.a);
    }
}
