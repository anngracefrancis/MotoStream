package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjw implements zzdti<String> {
    private final zzbjn a;

    public zzbjw(zzbjn zzbjnVar) {
        this.a = zzbjnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.b(this.a.d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
