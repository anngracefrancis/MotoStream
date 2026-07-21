package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class lc extends zzcdc {
    private zzdtu<zzbxg> A;
    private zzdtu<zzbuz<zzbrl>> B;
    private zzdtu<Set<zzbuz<zzbrl>>> C;
    private zzdtu<zzbse> D;
    private zzdtu<zzbuz<zzxr>> E;
    private zzdtu<Set<zzbuz<zzxr>>> F;
    private zzdtu<zzbri> G;
    private zzdtu<zzbvh> H;
    private zzdtu<zzbuz<zzbvg>> I;
    private zzdtu<Set<zzbuz<zzbvg>>> J;
    private zzdtu<zzbvd> K;
    private zzdtu<zzbuz<zzbsr>> L;
    private zzdtu<zzbgz> M;
    private zzdtu<zzbxa> N;
    private zzdtu<zzbuz<zzbsr>> O;
    private zzdtu<zzbuz<zzbsr>> P;
    private zzdtu<Set<zzbuz<zzbsr>>> Q;
    private zzdtu<zzbso> R;
    private zzdtu<zzbpv> S;
    private zzdtu<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>> T;
    private zzdtu<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> U;
    private zzdtu<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>> V;
    private zzdtu<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> W;
    private zzdtu<zzbsv> X;
    private zzdtu<Set<zzbuz<VideoController.VideoLifecycleCallbacks>>> Y;
    private zzdtu<zzbvq> Z;
    private zzbqo a;
    private zzdtu<Set<zzbuz<zzbrs>>> a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzcdd f12923b;
    private zzdtu<zzbrp> b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbpr f12924c;
    private zzdtu<zzbxe> c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbqm f12925d;
    private zzdtu<Set<zzbuz<zzbuu>>> d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzbrg f12926e;
    private zzdtu<Set<zzbuz<zzbuu>>> e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzdtu<zzaly> f12927f;
    private zzdtu<zzbuv> f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzdtu<zzcxm> f12928g;
    private zzdtu<zzbwq> g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzdtu<JSONObject> f12929h;
    private zzdtu<zzccz> h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzdtu<zzty> f12930i;
    private zzdtu<zzbuz<zzahy>> i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzdtu<zzbml> f12931j;
    private zzdtu<Set<zzbuz<zzahy>>> j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzdtu<zzbmg> f12932k;
    private zzdtu<zzbvj> k0;
    private zzdtu<zzbmn> l;
    private zzdtu<Set<zzbuz<zzue>>> l0;
    private zzdtu<Set<zzbuz<zzbrx>>> m;
    private zzdtu<Set<zzbuz<zzue>>> m0;
    private zzdtu<Set<zzbuz<zzbrx>>> n;
    private zzdtu<zzbva> n0;
    private zzdtu<zzbry> o;
    private zzdtu<zzavb> o0;
    private zzdtu<zzcxu> p;
    private zzdtu<com.google.android.gms.ads.internal.zzb> p0;
    private zzdtu<zzbme> q;
    private zzdtu<zzbuz<zzbto>> q0;
    private zzdtu<zzbuz<zzbrl>> r;
    private zzdtu<Set<zzbuz<zzbto>>> r0;
    private zzdtu<zzbuz<zzbrw>> s;
    private zzdtu<zzbtl> s0;
    private zzdtu<Set<zzbuz<zzbrw>>> t;
    private zzdtu<zzcdp> t0;
    private zzdtu<Set<zzbuz<zzbrw>>> u;
    private zzdtu<zzcni> u0;
    private zzdtu<zzbrt> v;
    private final /* synthetic */ kc v0;
    private zzdtu<zzbxc> w;
    private zzdtu<Set<zzbuz<zzbrl>>> x;
    private zzdtu<zzavf> y;
    private zzdtu<View> z;

    private lc(kc kcVar, zzbpr zzbprVar, zzcdd zzcddVar) {
        this.v0 = kcVar;
        this.a = new zzbqo();
        this.f12923b = zzcddVar;
        this.f12924c = zzbprVar;
        this.f12925d = new zzbqm();
        this.f12926e = new zzbrg();
        this.f12927f = zzdth.a(zzbmu.a(kcVar.b2.I));
        zzbps zzbpsVarA = zzbps.a(zzbprVar);
        this.f12928g = zzbpsVarA;
        this.f12929h = zzdth.a(zzbnb.a(zzbpsVarA));
        this.f12930i = zzdth.a(zzbmt.a(this.f12928g, kcVar.b2.f14504j, this.f12929h, zzcdl.a()));
        this.f12931j = zzdth.a(zzbmm.a(kcVar.f12864c, this.f12930i));
        this.f12932k = zzdth.a(zzbmr.a(this.f12930i, this.f12927f, zzcyx.a()));
        zzdtu<zzbmn> zzdtuVarA = zzdth.a(zzbmq.a(this.f12927f, this.f12931j, kcVar.b2.f14497c, this.f12932k, kcVar.b2.f14501g));
        this.l = zzdtuVarA;
        this.m = zzdth.a(zzbmv.a(zzdtuVarA, zzcyx.a(), this.f12929h));
        zzdtq zzdtqVarC = zzdtq.a(0, 3).b(kcVar.v1).b(kcVar.w1).b(this.m).c();
        this.n = zzdtqVarC;
        this.o = zzdth.a(zzbsd.a(zzdtqVarC));
        zzbpu zzbpuVarA = zzbpu.a(zzbprVar);
        this.p = zzbpuVarA;
        zzdtu<zzbme> zzdtuVarA2 = zzdth.a(zzbmf.a(zzbpuVarA, this.f12928g, kcVar.t));
        this.q = zzdtuVarA2;
        this.r = zzbqi.a(zzdtuVarA2, zzcyx.a());
        this.s = zzbqj.a(this.q, zzcyx.a());
        this.t = zzdth.a(zzbms.a(this.l, zzcyx.a(), this.f12929h));
        zzdtq zzdtqVarC2 = zzdtq.a(3, 3).a(kcVar.C1).a(kcVar.D1).b(kcVar.E1).b(kcVar.F1).a(this.s).b(this.t).c();
        this.u = zzdtqVarC2;
        zzdtu<zzbrt> zzdtuVarA3 = zzdth.a(zzbrv.a(zzdtqVarC2));
        this.v = zzdtuVarA3;
        zzdtu<zzbxc> zzdtuVarA4 = zzdth.a(zzbxd.a(zzdtuVarA3, this.f12928g));
        this.w = zzdtuVarA4;
        this.x = zzbwe.a(zzcddVar, zzdtuVarA4);
        this.y = zzbwj.a(zzcddVar, kcVar.f12864c, kcVar.p);
        this.z = zzbwc.a(zzcddVar);
        zzdtu<zzbxg> zzdtuVarA5 = zzdth.a(zzbxh.a(this.y, kcVar.f12864c, kcVar.b2.C, this.z, zzcdk.a()));
        this.A = zzdtuVarA5;
        this.B = zzbwl.a(zzcddVar, zzdtuVarA5, zzcyx.a());
        zzdtq zzdtqVarC3 = zzdtq.a(4, 3).a(kcVar.x1).b(kcVar.y1).b(kcVar.z1).a(kcVar.B1).a(this.r).b(this.x).a(this.B).c();
        this.C = zzdtqVarC3;
        this.D = zzdth.a(zzbsl.a(zzdtqVarC3));
        this.E = zzbqh.a(this.q, zzcyx.a());
        zzdtq zzdtqVarC4 = zzdtq.a(3, 2).a(kcVar.G1).a(kcVar.H1).b(kcVar.I1).b(kcVar.J1).a(this.E).c();
        this.F = zzdtqVarC4;
        this.G = zzdth.a(zzbrk.a(zzdtqVarC4));
        zzdtu<zzbvh> zzdtuVarA6 = zzdth.a(zzbvi.a(this.f12928g, kcVar.t));
        this.H = zzdtuVarA6;
        this.I = zzbqg.a(zzdtuVarA6, zzcyx.a());
        zzdtq zzdtqVarC5 = zzdtq.a(1, 1).b(kcVar.K1).a(this.I).c();
        this.J = zzdtqVarC5;
        this.K = zzdth.a(zzbvf.a(zzdtqVarC5));
        this.L = zzbqk.b(this.q, zzcyx.a());
        this.M = zzbwo.a(zzcddVar);
        zzdtu<zzbxa> zzdtuVarA7 = zzdth.a(zzbxb.a(kcVar.f12864c, this.M, this.f12928g, kcVar.b2.f14504j, zzcdk.a()));
        this.N = zzdtuVarA7;
        this.O = zzbwg.a(zzcddVar, zzdtuVarA7);
        this.P = zzbwd.a(zzcddVar, kcVar.l, kcVar.b2.f14504j, this.f12928g, kcVar.p);
        zzdtq zzdtqVarC6 = zzdtq.a(7, 3).a(kcVar.L1).a(kcVar.M1).a(kcVar.N1).b(kcVar.O1).b(kcVar.P1).b(kcVar.Q1).a(kcVar.R1).a(this.L).a(this.O).a(this.P).c();
        this.Q = zzdtqVarC6;
        this.R = zzdth.a(zzbsq.a(zzdtqVarC6));
        zzdtu<zzbpv> zzdtuVarA8 = zzdth.a(zzbpw.a(this.D));
        this.S = zzdtuVarA8;
        this.T = zzbqp.a(this.a, zzdtuVarA8);
        this.U = zzdth.a(zzbmx.a(this.l, zzcyx.a(), this.f12929h));
        this.V = zzbwh.a(zzcddVar, this.N);
        zzdtq zzdtqVarC7 = zzdtq.a(2, 2).b(kcVar.W1).a(this.T).b(this.U).a(this.V).c();
        this.W = zzdtqVarC7;
        this.X = zzdth.a(zzbta.a(zzdtqVarC7));
        zzdtq zzdtqVarC8 = zzdtq.a(0, 1).b(kcVar.X1).c();
        this.Y = zzdtqVarC8;
        this.Z = zzdth.a(zzbvw.a(zzdtqVarC8));
        zzdtq zzdtqVarC9 = zzdtq.a(0, 1).b(kcVar.Y1).c();
        this.a0 = zzdtqVarC9;
        this.b0 = zzdth.a(new zzbrr(zzdtqVarC9));
        zzdtu<zzbxe> zzdtuVarA9 = zzdth.a(zzbxf.a(this.o));
        this.c0 = zzdtuVarA9;
        this.d0 = zzbwm.a(zzdtuVarA9);
        zzdtq zzdtqVarC10 = zzdtq.a(0, 1).b(this.d0).c();
        this.e0 = zzdtqVarC10;
        zzdtu<zzbuv> zzdtuVarA10 = zzdth.a(zzbuy.a(zzdtqVarC10));
        this.f0 = zzdtuVarA10;
        this.g0 = zzdth.a(zzbwr.a(this.X, zzdtuVarA10));
        zzdtu<zzccz> zzdtuVarA11 = zzdth.a(new zzcda(this.D, this.f12928g));
        this.h0 = zzdtuVarA11;
        this.i0 = new zzbwi(zzcddVar, zzdtuVarA11);
        zzdtq zzdtqVarC11 = zzdtq.a(1, 0).a(this.i0).c();
        this.j0 = zzdtqVarC11;
        this.k0 = zzdth.a(new zzbvn(zzdtqVarC11));
        this.l0 = zzdth.a(zzbmw.a(this.l, zzcyx.a(), this.f12929h));
        this.m0 = zzdtq.a(0, 2).b(kcVar.Z1).b(this.l0).c();
        this.n0 = zzdth.a(zzbvc.a(kcVar.l, this.m0, this.f12928g));
        this.o0 = zzdth.a(zzbrh.a(this.f12926e, kcVar.l, kcVar.b2.f14504j, this.f12928g, kcVar.b2.J));
        this.p0 = zzdth.a(zzbqn.a(this.f12925d, kcVar.l, this.o0));
        this.q0 = zzbwn.a(zzcddVar, kcVar.b2.f14497c);
        zzdtq zzdtqVarC12 = zzdtq.a(1, 1).b(kcVar.a2).a(this.q0).c();
        this.r0 = zzdtqVarC12;
        this.s0 = zzdth.a(zzbtn.a(zzdtqVarC12));
        this.t0 = zzdth.a(zzcea.a(this.G, this.D, kcVar.u1, this.X, kcVar.V1, kcVar.b2.f14497c, this.n0, this.l, this.p0, this.o, this.o0, kcVar.e0, this.s0));
        this.u0 = zzdth.a(new zzcnj(this.G, this.v, this.D, this.R, this.b0, kcVar.V1, this.Z, this.X, this.k0));
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final zzbry a() {
        return this.o.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final zzbse b() {
        return this.D.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final zzbri c() {
        return this.G.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final zzbrt d() {
        return this.v.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final zzbvd e() {
        return this.K.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbpd
    public final zzcoj f() {
        return new zzcoj(this.G.get(), this.v.get(), this.D.get(), this.R.get(), (zzbtp) this.v0.V1.get(), this.X.get(), this.Z.get());
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzcdp g() {
        return this.t0.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzbsv h() {
        return this.X.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzbwq i() {
        return this.g0.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzcdb j() {
        zzcdb zzcdbVarA = zzcde.a((Context) this.v0.l.get(), zzbwf.a(this.f12923b), new zzbup(Collections.singleton(zzbwk.a(this.f12923b, this.A.get()))), this.b0.get(), this.o.get(), this.S.get(), zzbps.b(this.f12924c), (zzdan) this.v0.b2.L.get());
        zzbql.d(zzcdbVarA, zzbpu.b(this.f12924c));
        zzbql.c(zzcdbVarA, zzbps.b(this.f12924c));
        zzbql.a(zzcdbVarA, this.o.get());
        zzbql.b(zzcdbVarA, this.R.get());
        zzbql.e(zzcdbVarA, zzbpt.b(this.f12924c));
        return zzcdbVarA;
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzbvj k() {
        return this.k0.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcdc
    public final zzcni l() {
        return this.u0.get();
    }
}
