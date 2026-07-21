package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbjx implements zzdti<zzbai> {
    private final zzbjn a;

    public zzbjx(zzbjn zzbjnVar) {
        this.a = zzbjnVar;
    }

    public static zzbai a(zzbjn zzbjnVar) {
        return (zzbai) zzdto.b(zzbjnVar.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return a(this.a);
    }
}
