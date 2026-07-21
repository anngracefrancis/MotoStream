package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcca implements zzdti<zzcbz> {
    private final zzdtu<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyn> f15039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbyt> f15040c;

    private zzcca(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15039b = zzdtuVar2;
        this.f15040c = zzdtuVar3;
    }

    public static zzcca a(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        return new zzcca(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcbz(this.a.get(), this.f15039b.get(), this.f15040c.get());
    }
}
