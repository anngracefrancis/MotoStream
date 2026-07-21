package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbwr implements zzdti<zzbwq> {
    private final zzdtu<zzbsv> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbuv> f14782b;

    private zzbwr(zzdtu<zzbsv> zzdtuVar, zzdtu<zzbuv> zzdtuVar2) {
        this.a = zzdtuVar;
        this.f14782b = zzdtuVar2;
    }

    public static zzbwr a(zzdtu<zzbsv> zzdtuVar, zzdtu<zzbuv> zzdtuVar2) {
        return new zzbwr(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbwq(this.a.get(), this.f14782b.get());
    }
}
