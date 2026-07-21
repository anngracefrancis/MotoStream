package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcea implements zzdti<zzcdp> {
    private final zzdtu<zzbri> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbse> f15118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbss> f15119c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbsv> f15120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbtp> f15121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<Executor> f15122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<zzbva> f15123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<zzbmn> f15124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzdtu<com.google.android.gms.ads.internal.zzb> f15125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzdtu<zzbry> f15126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzdtu<zzavb> f15127k;
    private final zzdtu<zzdh> l;
    private final zzdtu<zzbtl> m;

    private zzcea(zzdtu<zzbri> zzdtuVar, zzdtu<zzbse> zzdtuVar2, zzdtu<zzbss> zzdtuVar3, zzdtu<zzbsv> zzdtuVar4, zzdtu<zzbtp> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<zzbva> zzdtuVar7, zzdtu<zzbmn> zzdtuVar8, zzdtu<com.google.android.gms.ads.internal.zzb> zzdtuVar9, zzdtu<zzbry> zzdtuVar10, zzdtu<zzavb> zzdtuVar11, zzdtu<zzdh> zzdtuVar12, zzdtu<zzbtl> zzdtuVar13) {
        this.a = zzdtuVar;
        this.f15118b = zzdtuVar2;
        this.f15119c = zzdtuVar3;
        this.f15120d = zzdtuVar4;
        this.f15121e = zzdtuVar5;
        this.f15122f = zzdtuVar6;
        this.f15123g = zzdtuVar7;
        this.f15124h = zzdtuVar8;
        this.f15125i = zzdtuVar9;
        this.f15126j = zzdtuVar10;
        this.f15127k = zzdtuVar11;
        this.l = zzdtuVar12;
        this.m = zzdtuVar13;
    }

    public static zzcea a(zzdtu<zzbri> zzdtuVar, zzdtu<zzbse> zzdtuVar2, zzdtu<zzbss> zzdtuVar3, zzdtu<zzbsv> zzdtuVar4, zzdtu<zzbtp> zzdtuVar5, zzdtu<Executor> zzdtuVar6, zzdtu<zzbva> zzdtuVar7, zzdtu<zzbmn> zzdtuVar8, zzdtu<com.google.android.gms.ads.internal.zzb> zzdtuVar9, zzdtu<zzbry> zzdtuVar10, zzdtu<zzavb> zzdtuVar11, zzdtu<zzdh> zzdtuVar12, zzdtu<zzbtl> zzdtuVar13) {
        return new zzcea(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8, zzdtuVar9, zzdtuVar10, zzdtuVar11, zzdtuVar12, zzdtuVar13);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcdp(this.a.get(), this.f15118b.get(), this.f15119c.get(), this.f15120d.get(), this.f15121e.get(), this.f15122f.get(), this.f15123g.get(), this.f15124h.get(), this.f15125i.get(), this.f15126j.get(), this.f15127k.get(), this.l.get(), this.m.get());
    }
}
