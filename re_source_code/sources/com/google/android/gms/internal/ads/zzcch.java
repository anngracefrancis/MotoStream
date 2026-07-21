package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcch implements zzdti<zzccg> {
    private final zzdtu<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyn> f15056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbyt> f15057c;

    private zzcch(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15056b = zzdtuVar2;
        this.f15057c = zzdtuVar3;
    }

    public static zzcch a(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        return new zzcch(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccg(this.a.get(), this.f15056b.get(), this.f15057c.get());
    }
}
