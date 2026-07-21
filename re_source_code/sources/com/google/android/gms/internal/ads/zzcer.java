package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcer implements zzdti<zzcep> {
    private final zzdtu<zzwj> a;

    private zzcer(zzdtu<zzwj> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzcer a(zzdtu<zzwj> zzdtuVar) {
        return new zzcer(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcep(this.a.get());
    }
}
