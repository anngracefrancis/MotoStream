package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxw implements zzdti<zzbpe<zzbnf>> {
    private final zzdtu<zzbjm> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdtu<zzbqy.zza> f14821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzdtu<zzbtv> f14822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzdtu<zzbxk> f14823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzdtu<zzbtb> f14824e;

    public zzbxw(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbqy.zza> zzdtuVar2, zzdtu<zzbtv> zzdtuVar3, zzdtu<zzbxk> zzdtuVar4, zzdtu<zzbtb> zzdtuVar5) {
        this.a = zzdtuVar;
        this.f14821b = zzdtuVar2;
        this.f14822c = zzdtuVar3;
        this.f14823d = zzdtuVar4;
        this.f14824e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbjm zzbjmVar = this.a.get();
        zzbqy.zza zzaVar = this.f14821b.get();
        zzbtv zzbtvVar = this.f14822c.get();
        return (zzbpe) zzdto.b(zzbjmVar.j().f(zzaVar.c()).a(zzbtvVar).g(this.f14823d.get()).e(new zzcow(null)).c(new zzbox(this.f14824e.get())).d(new zzbnc(null)).b().e(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
