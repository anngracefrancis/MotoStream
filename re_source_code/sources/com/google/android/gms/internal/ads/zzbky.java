package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbky implements zzdti<zzavd> {
    private final zzbkw a;

    public zzbky(zzbkw zzbkwVar) {
        this.a = zzbkwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzavd) zzdto.b(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
