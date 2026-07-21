package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbnj implements zzdti<yc> {
    private final zzdtu<Context> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzcxn> f14580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<View> f14581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbgz> f14582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbpb> f14583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdtu<zzbzc> f14584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzdtu<zzbvd> f14585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzdtu<zzcpm> f14586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzdtu<Executor> f14587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzdtu<zzcxu> f14588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzdtu<zzcxm> f14589k;
    private final zzdtu<zzbry> l;
    private final zzdtu<zzbso> m;
    private final zzdtu<String> n;

    public zzbnj(zzdtu<Context> zzdtuVar, zzdtu<zzcxn> zzdtuVar2, zzdtu<View> zzdtuVar3, zzdtu<zzbgz> zzdtuVar4, zzdtu<zzbpb> zzdtuVar5, zzdtu<zzbzc> zzdtuVar6, zzdtu<zzbvd> zzdtuVar7, zzdtu<zzcpm> zzdtuVar8, zzdtu<Executor> zzdtuVar9, zzdtu<zzcxu> zzdtuVar10, zzdtu<zzcxm> zzdtuVar11, zzdtu<zzbry> zzdtuVar12, zzdtu<zzbso> zzdtuVar13, zzdtu<String> zzdtuVar14) {
        this.a = zzdtuVar;
        this.f14580b = zzdtuVar2;
        this.f14581c = zzdtuVar3;
        this.f14582d = zzdtuVar4;
        this.f14583e = zzdtuVar5;
        this.f14584f = zzdtuVar6;
        this.f14585g = zzdtuVar7;
        this.f14586h = zzdtuVar8;
        this.f14587i = zzdtuVar9;
        this.f14588j = zzdtuVar10;
        this.f14589k = zzdtuVar11;
        this.l = zzdtuVar12;
        this.m = zzdtuVar13;
        this.n = zzdtuVar14;
    }

    public static yc a(Context context, zzcxn zzcxnVar, View view, zzbgz zzbgzVar, zzbpb zzbpbVar, zzbzc zzbzcVar, zzbvd zzbvdVar, zzdte<zzcpm> zzdteVar, Executor executor) {
        return new yc(context, zzcxnVar, view, zzbgzVar, zzbpbVar, zzbzcVar, zzbvdVar, zzdteVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        yc ycVar = new yc(this.a.get(), this.f14580b.get(), this.f14581c.get(), this.f14582d.get(), this.f14583e.get(), this.f14584f.get(), this.f14585g.get(), zzdth.b(this.f14586h), this.f14587i.get());
        zzbql.d(ycVar, this.f14588j.get());
        zzbql.c(ycVar, this.f14589k.get());
        zzbql.a(ycVar, this.l.get());
        zzbql.b(ycVar, this.m.get());
        zzbql.e(ycVar, this.n.get());
        return ycVar;
    }
}
