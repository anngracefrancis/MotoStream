package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
final class fc implements zzboo {
    private zzbop a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzdtu<zzaga> f12580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzdtu<Runnable> f12581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzdtu<zzcxu> f12582d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzdtu<zzcxm> f12583e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzdtu<Set<zzbuz<zzbrx>>> f12584f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzdtu<zzbry> f12585g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzdtu<Set<zzbuz<zzbsr>>> f12586h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzdtu<zzbso> f12587i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzdtu<String> f12588j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzdtu<zzbol> f12589k;
    private final /* synthetic */ dc l;

    private fc(dc dcVar, zzbpr zzbprVar, zzbop zzbopVar) {
        this.l = dcVar;
        this.a = zzbopVar;
        this.f12580b = new zzbor(zzbopVar);
        this.f12581c = new zzboq(zzbopVar);
        this.f12582d = zzbpu.a(zzbprVar);
        this.f12583e = zzbps.a(zzbprVar);
        zzdtq zzdtqVarC = zzdtq.a(0, 2).b(dcVar.F1).b(dcVar.G1).c();
        this.f12584f = zzdtqVarC;
        this.f12585g = zzdth.a(zzbsd.a(zzdtqVarC));
        zzdtq zzdtqVarC2 = zzdtq.a(4, 3).a(dcVar.T1).a(dcVar.U1).a(dcVar.V1).b(dcVar.f2).b(dcVar.g2).b(dcVar.h2).a(dcVar.W1).c();
        this.f12586h = zzdtqVarC2;
        this.f12587i = zzdth.a(zzbsq.a(zzdtqVarC2));
        this.f12588j = zzbpt.a(zzbprVar);
        this.f12589k = zzdth.a(new zzbos(this.f12580b, this.f12581c, dcVar.n2.f14497c, this.f12582d, this.f12583e, this.f12585g, this.f12587i, this.f12588j));
    }

    @Override // com.google.android.gms.internal.ads.zzboo
    public final zzbnf a() {
        return (zzbnf) zzdto.b(this.f12589k.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
