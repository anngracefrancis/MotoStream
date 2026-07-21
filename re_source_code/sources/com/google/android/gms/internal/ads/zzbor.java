package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbor implements zzdti<zzaga> {
    private final zzbop a;

    public zzbor(zzbop zzbopVar) {
        this.a = zzbopVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzaga) zzdto.b(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
