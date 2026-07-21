package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbys implements zzdti<zzbyn> {
    private final zzdtu<Executor> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbyt> f14862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbzb> f14863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbzl> f14864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbyx> f14865e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzbzc> f14866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<zzccb> f14867g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<zzcbz> f14868h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzdtu<zzccg> f14869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzdtu<zzcbw> f14870j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzdtu<zzccd> f14871k;
    private final zzdtu<zzavf> l;
    private final zzdtu<zzdh> m;
    private final zzdtu<zzbai> n;
    private final zzdtu<Context> o;
    private final zzdtu<zzcxu> p;
    private final zzdtu<zzcxm> q;
    private final zzdtu<zzbry> r;
    private final zzdtu<zzbso> s;
    private final zzdtu<String> t;

    private zzbys(zzdtu<Executor> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzb> zzdtuVar3, zzdtu<zzbzl> zzdtuVar4, zzdtu<zzbyx> zzdtuVar5, zzdtu<zzbzc> zzdtuVar6, zzdtu<zzccb> zzdtuVar7, zzdtu<zzcbz> zzdtuVar8, zzdtu<zzccg> zzdtuVar9, zzdtu<zzcbw> zzdtuVar10, zzdtu<zzccd> zzdtuVar11, zzdtu<zzavf> zzdtuVar12, zzdtu<zzdh> zzdtuVar13, zzdtu<zzbai> zzdtuVar14, zzdtu<Context> zzdtuVar15, zzdtu<zzcxu> zzdtuVar16, zzdtu<zzcxm> zzdtuVar17, zzdtu<zzbry> zzdtuVar18, zzdtu<zzbso> zzdtuVar19, zzdtu<String> zzdtuVar20) {
        this.a = zzdtuVar;
        this.f14862b = zzdtuVar2;
        this.f14863c = zzdtuVar3;
        this.f14864d = zzdtuVar4;
        this.f14865e = zzdtuVar5;
        this.f14866f = zzdtuVar6;
        this.f14867g = zzdtuVar7;
        this.f14868h = zzdtuVar8;
        this.f14869i = zzdtuVar9;
        this.f14870j = zzdtuVar10;
        this.f14871k = zzdtuVar11;
        this.l = zzdtuVar12;
        this.m = zzdtuVar13;
        this.n = zzdtuVar14;
        this.o = zzdtuVar15;
        this.p = zzdtuVar16;
        this.q = zzdtuVar17;
        this.r = zzdtuVar18;
        this.s = zzdtuVar19;
        this.t = zzdtuVar20;
    }

    public static zzbys a(zzdtu<Executor> zzdtuVar, zzdtu<zzbyt> zzdtuVar2, zzdtu<zzbzb> zzdtuVar3, zzdtu<zzbzl> zzdtuVar4, zzdtu<zzbyx> zzdtuVar5, zzdtu<zzbzc> zzdtuVar6, zzdtu<zzccb> zzdtuVar7, zzdtu<zzcbz> zzdtuVar8, zzdtu<zzccg> zzdtuVar9, zzdtu<zzcbw> zzdtuVar10, zzdtu<zzccd> zzdtuVar11, zzdtu<zzavf> zzdtuVar12, zzdtu<zzdh> zzdtuVar13, zzdtu<zzbai> zzdtuVar14, zzdtu<Context> zzdtuVar15, zzdtu<zzcxu> zzdtuVar16, zzdtu<zzcxm> zzdtuVar17, zzdtu<zzbry> zzdtuVar18, zzdtu<zzbso> zzdtuVar19, zzdtu<String> zzdtuVar20) {
        return new zzbys(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8, zzdtuVar9, zzdtuVar10, zzdtuVar11, zzdtuVar12, zzdtuVar13, zzdtuVar14, zzdtuVar15, zzdtuVar16, zzdtuVar17, zzdtuVar18, zzdtuVar19, zzdtuVar20);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbyn zzbynVar = new zzbyn(this.a.get(), this.f14862b.get(), this.f14863c.get(), this.f14864d.get(), this.f14865e.get(), this.f14866f.get(), zzdth.b(this.f14867g), zzdth.b(this.f14868h), zzdth.b(this.f14869i), zzdth.b(this.f14870j), zzdth.b(this.f14871k), this.l.get(), this.m.get(), this.n.get(), this.o.get());
        zzbql.d(zzbynVar, this.p.get());
        zzbql.c(zzbynVar, this.q.get());
        zzbql.a(zzbynVar, this.r.get());
        zzbql.b(zzbynVar, this.s.get());
        zzbql.e(zzbynVar, this.t.get());
        return zzbynVar;
    }
}
