package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcsb implements zzdti<zzcrz> {
    private final zzdtu<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<String> f15588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbqe> f15589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzcyi> f15590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzcxv> f15591e;

    private zzcsb(zzdtu<String> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbqe> zzdtuVar3, zzdtu<zzcyi> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f15588b = zzdtuVar2;
        this.f15589c = zzdtuVar3;
        this.f15590d = zzdtuVar4;
        this.f15591e = zzdtuVar5;
    }

    public static zzcsb a(zzdtu<String> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbqe> zzdtuVar3, zzdtu<zzcyi> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        return new zzcsb(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcrz(this.a.get(), this.f15588b.get(), this.f15589c.get(), this.f15590d.get(), this.f15591e.get());
    }
}
