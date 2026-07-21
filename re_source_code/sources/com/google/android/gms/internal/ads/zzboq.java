package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzboq implements zzdti<Runnable> {
    private final zzbop a;

    public zzboq(zzbop zzbopVar) {
        this.a = zzbopVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Runnable) zzdto.b(this.a.b(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
