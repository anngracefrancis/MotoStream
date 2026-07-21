package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcod implements zzdti<zzcoc> {
    private final zzdtu<zzclc> a;

    private zzcod(zzdtu<zzclc> zzdtuVar) {
        this.a = zzdtuVar;
    }

    public static zzcod a(zzdtu<zzclc> zzdtuVar) {
        return new zzcod(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcoc(this.a.get());
    }
}
