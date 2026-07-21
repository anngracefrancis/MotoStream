package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class bc extends zzcvs {
    private zzcwx a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzdtu<zzcvo> f12340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzdtu<String> f12341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzdtu<zzcvy> f12342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzdtu<zzcwc> f12343e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzdtu<zzcwj> f12344f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzdtu<Boolean> f12345g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzdtu<ApplicationInfo> f12346h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzdtu<zzcwq> f12347i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzdtu<zzcwu> f12348j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzdtu<zzcxh> f12349k;
    private zzdtu<String> l;
    private zzdtu<zzcez> m;
    private zzdtu<zzcez> n;
    private zzdtu<zzcez> o;
    private zzdtu<zzcez> p;
    private zzdtu<Map<zzczs, zzcez>> q;
    private zzdtu<Set<zzbuz<zzczz>>> r;
    private zzdtu<Set<zzbuz<zzczz>>> s;
    private zzdtu t;
    private zzdtu<zzczt> u;
    private final /* synthetic */ zzbkc v;

    private bc(zzbkc zzbkcVar, zzcwx zzcwxVar) {
        this.v = zzbkcVar;
        this.a = zzcwxVar;
        this.f12340b = new zzcvr(zzbln.a(), zzbkcVar.f14503i, zzbkcVar.f14499e, zzcyx.a());
        this.f12341c = new zzcwy(zzcwxVar);
        this.f12342d = new zzcwa(zzbjy.a(), zzbkcVar.f14503i, this.f12341c, zzcyx.a());
        this.f12343e = new zzcwe(zzblj.a(), zzcyx.a(), zzbkcVar.f14503i);
        this.f12344f = new zzcwl(zzblk.a(), zzcyx.a(), this.f12341c);
        this.f12345g = new zzcxa(zzcwxVar);
        this.f12346h = new zzcwz(zzcwxVar);
        this.f12347i = new zzcws(zzbll.a(), zzbkcVar.f14499e, this.f12345g, this.f12346h);
        this.f12348j = new zzcww(zzblm.a(), zzbkcVar.f14499e, zzbkcVar.f14503i);
        this.f12349k = new zzcxj(zzcyx.a());
        this.l = new zzcxb(zzcwxVar);
        this.m = zzdth.a(zzcet.a());
        this.n = zzdth.a(zzces.a());
        this.o = zzdth.a(zzceu.a());
        this.p = zzdth.a(zzcev.a());
        this.q = zzdtk.a(4).a(zzczs.GMS_SIGNALS, this.m).a(zzczs.BUILD_URL, this.n).a(zzczs.HTTP, this.o).a(zzczs.PRE_PROCESS, this.p).b();
        this.r = zzdth.a(new zzcew(this.l, zzbkcVar.f14503i, zzcyx.a(), this.q));
        zzdtq zzdtqVarC = zzdtq.a(0, 1).b(this.r).c();
        this.s = zzdtqVarC;
        this.t = zzdab.a(zzdtqVarC);
        this.u = zzdth.a(zzdaa.a(zzcyx.a(), zzbkcVar.f14499e, this.t));
    }

    private final zzcwn d() {
        return new zzcwn(zzbli.a(), zzcyx.b(), (List) zzdto.b(this.a.e(), "Cannot return null from a non-@Nullable @Provides method"));
    }

    private final zzcvu e() {
        return new zzcvu(zzbln.b(), zzcyx.b(), (String) zzdto.b(this.a.b(), "Cannot return null from a non-@Nullable @Provides method"), this.a.c());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzcvb<JSONObject> a() {
        return new zzcvb<>(zzcyx.b(), zzdtp.d(11).a((zzcva) zzdto.b(new zzctz(new zzcwj(zzblk.b(), zzcyx.b(), zzcwy.a(this.a)), 0L, (ScheduledExecutorService) this.v.f14499e.get()), "Cannot return null from a non-@Nullable @Provides method")).a((zzcva) zzdto.b(new zzctz(new zzcwq(zzbll.b(), (ScheduledExecutorService) this.v.f14499e.get(), this.a.d(), zzcwz.a(this.a)), ((Long) zzyt.e().c(zzacu.X2)).longValue(), (ScheduledExecutorService) this.v.f14499e.get()), "Cannot return null from a non-@Nullable @Provides method")).a((zzcva) zzdto.b(new zzctz(new zzcwu(zzblm.b(), (ScheduledExecutorService) this.v.f14499e.get(), zzbjq.a(this.v.f14496b)), ((Long) zzyt.e().c(zzacu.n3)).longValue(), (ScheduledExecutorService) this.v.f14499e.get()), "Cannot return null from a non-@Nullable @Provides method")).a((zzcva) zzdto.b(new zzctz(new zzcvo(zzbln.b(), zzbjq.a(this.v.f14496b), (ScheduledExecutorService) this.v.f14499e.get(), zzcyx.b()), 0L, (ScheduledExecutorService) this.v.f14499e.get()), "Cannot return null from a non-@Nullable @Provides method")).a((zzcva) zzdto.b(new zzctz(new zzcxh(zzcyx.b()), 0L, (ScheduledExecutorService) this.v.f14499e.get()), "Cannot return null from a non-@Nullable @Provides method")).a(zzcxe.a()).a(new zzcvy(null, zzbjq.a(this.v.f14496b), zzcwy.a(this.a), zzcyx.b())).a(new zzcwc(zzblj.b(), zzcyx.b(), zzbjq.a(this.v.f14496b))).a(d()).a(e()).a((zzcva) this.v.r.get()).c());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzcvb<JSONObject> b() {
        return zzcxf.a(this.v.r.get(), e(), d(), zzdth.b(this.f12340b), zzdth.b(this.f12342d), zzdth.b(this.f12343e), zzdth.b(this.f12344f), zzdth.b(this.f12347i), zzdth.b(this.f12348j), zzdth.b(this.f12349k), zzcyx.b());
    }

    @Override // com.google.android.gms.internal.ads.zzcvs
    public final zzczt c() {
        return this.u.get();
    }
}
