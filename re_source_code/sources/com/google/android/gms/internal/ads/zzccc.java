package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccc implements zzdti<zzccb> {
    private final zzdtu<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyn> f15044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbyt> f15045c;

    private zzccc(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        this.a = zzdtuVar;
        this.f15044b = zzdtuVar2;
        this.f15045c = zzdtuVar3;
    }

    public static zzccc a(zzdtu<String> zzdtuVar, zzdtu<zzbyn> zzdtuVar2, zzdtu<zzbyt> zzdtuVar3) {
        return new zzccc(zzdtuVar, zzdtuVar2, zzdtuVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccb(this.a.get(), this.f15044b.get(), this.f15045c.get());
    }
}
