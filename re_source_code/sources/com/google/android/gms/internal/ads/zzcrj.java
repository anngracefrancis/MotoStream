package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcrj implements zzdti<zzcri> {
    private final zzdtu<zzcxv> a;

    private zzcrj(zzdtu<zzcxv> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzcrj a(zzdtu<zzcxv> zzdtuVar) {
        return new zzcrj(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcri(this.a.get());
    }
}
