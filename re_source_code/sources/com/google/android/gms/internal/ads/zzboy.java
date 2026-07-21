package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzboy implements zzdti<zzbtb> {
    private final zzbox a;

    public zzboy(zzbox zzboxVar) {
        this.a = zzboxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbtb) zzdto.b(this.a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
