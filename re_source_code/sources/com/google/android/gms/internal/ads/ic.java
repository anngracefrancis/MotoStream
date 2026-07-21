package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.VideoController;
import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class ic extends zzbvy {
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
    private zzdtu<zzbxe> a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzbvz f12757b;
    private zzdtu<Set<zzbuz<zzbuu>>> b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzbpr f12758c;
    private zzdtu<Set<zzbuz<zzbuu>>> c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzbqm f12759d;
    private zzdtu<zzbuv> d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzbrg f12760e;
    private zzdtu<zzbwq> e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzdtu<zzaly> f12761f;
    private zzdtu<Set<zzbuz<zzue>>> f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzdtu<zzcxm> f12762g;
    private zzdtu<Set<zzbuz<zzue>>> g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzdtu<JSONObject> f12763h;
    private zzdtu<zzbva> h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzdtu<zzty> f12764i;
    private zzdtu<zzavb> i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzdtu<zzbml> f12765j;
    private zzdtu<com.google.android.gms.ads.internal.zzb> j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private zzdtu<zzbmg> f12766k;
    private zzdtu<zzbuz<zzbto>> k0;
    private zzdtu<zzbmn> l;
    private zzdtu<Set<zzbuz<zzbto>>> l0;
    private zzdtu<Set<zzbuz<zzbrx>>> m;
    private zzdtu<zzbtl> m0;
    private zzdtu<Set<zzbuz<zzbrx>>> n;
    private zzdtu<zzcdp> n0;
    private zzdtu<zzbry> o;
    private final /* synthetic */ hc o0;
    private zzdtu<zzcxu> p;
    private zzdtu<zzbme> q;
    private zzdtu<zzbuz<zzbrl>> r;
    private zzdtu<zzbuz<zzbrw>> s;
    private zzdtu<Set<zzbuz<zzbrw>>> t;
    private zzdtu<Set<zzbuz<zzbrw>>> u;
    private zzdtu<zzbrt> v;
    private zzdtu<zzbxc> w;
    private zzdtu<Set<zzbuz<zzbrl>>> x;
    private zzdtu<zzavf> y;
    private zzdtu<View> z;

    private ic(hc hcVar, zzbpr zzbprVar, zzbvz zzbvzVar) {
        this.o0 = hcVar;
        this.a = new zzbqo();
        this.f12757b = zzbvzVar;
        this.f12758c = zzbprVar;
        this.f12759d = new zzbqm();
        this.f12760e = new zzbrg();
        this.f12761f = zzdth.a(zzbmu.a(hcVar.c2.I));
        zzbps zzbpsVarA = zzbps.a(zzbprVar);
        this.f12762g = zzbpsVarA;
        this.f12763h = zzdth.a(zzbnb.a(zzbpsVarA));
        this.f12764i = zzdth.a(zzbmt.a(this.f12762g, hcVar.c2.f14504j, this.f12763h, zzbwx.a()));
        this.f12765j = zzdth.a(zzbmm.a(hcVar.f12704c, this.f12764i));
        this.f12766k = zzdth.a(zzbmr.a(this.f12764i, this.f12761f, zzcyx.a()));
        zzdtu<zzbmn> zzdtuVarA = zzdth.a(zzbmq.a(this.f12761f, this.f12765j, hcVar.c2.f14497c, this.f12766k, hcVar.c2.f14501g));
        this.l = zzdtuVarA;
        this.m = zzdth.a(zzbmv.a(zzdtuVarA, zzcyx.a(), this.f12763h));
        zzdtq zzdtqVarC = zzdtq.a(0, 3).b(hcVar.u1).b(hcVar.v1).b(this.m).c();
        this.n = zzdtqVarC;
        this.o = zzdth.a(zzbsd.a(zzdtqVarC));
        zzbpu zzbpuVarA = zzbpu.a(zzbprVar);
        this.p = zzbpuVarA;
        zzdtu<zzbme> zzdtuVarA2 = zzdth.a(zzbmf.a(zzbpuVarA, this.f12762g, hcVar.t));
        this.q = zzdtuVarA2;
        this.r = zzbqi.a(zzdtuVarA2, zzcyx.a());
        this.s = zzbqj.a(this.q, zzcyx.a());
        this.t = zzdth.a(zzbms.a(this.l, zzcyx.a(), this.f12763h));
        zzdtq zzdtqVarC2 = zzdtq.a(3, 3).a(hcVar.B1).a(hcVar.C1).b(hcVar.D1).b(hcVar.E1).a(this.s).b(this.t).c();
        this.u = zzdtqVarC2;
        zzdtu<zzbrt> zzdtuVarA3 = zzdth.a(zzbrv.a(zzdtqVarC2));
        this.v = zzdtuVarA3;
        zzdtu<zzbxc> zzdtuVarA4 = zzdth.a(zzbxd.a(zzdtuVarA3, this.f12762g));
        this.w = zzdtuVarA4;
        this.x = zzbwe.a(zzbvzVar, zzdtuVarA4);
        this.y = zzbwj.a(zzbvzVar, hcVar.f12704c, hcVar.p);
        this.z = zzbwc.a(zzbvzVar);
        zzdtu<zzbxg> zzdtuVarA5 = zzdth.a(zzbxh.a(this.y, hcVar.f12704c, hcVar.c2.C, this.z, zzbww.a()));
        this.A = zzdtuVarA5;
        this.B = zzbwl.a(zzbvzVar, zzdtuVarA5, zzcyx.a());
        zzdtq zzdtqVarC3 = zzdtq.a(4, 3).a(hcVar.w1).b(hcVar.x1).b(hcVar.y1).a(hcVar.A1).a(this.r).b(this.x).a(this.B).c();
        this.C = zzdtqVarC3;
        this.D = zzdth.a(zzbsl.a(zzdtqVarC3));
        this.E = zzbqh.a(this.q, zzcyx.a());
        zzdtq zzdtqVarC4 = zzdtq.a(3, 2).a(hcVar.F1).a(hcVar.G1).b(hcVar.H1).b(hcVar.I1).a(this.E).c();
        this.F = zzdtqVarC4;
        this.G = zzdth.a(zzbrk.a(zzdtqVarC4));
        zzdtu<zzbvh> zzdtuVarA6 = zzdth.a(zzbvi.a(this.f12762g, hcVar.t));
        this.H = zzdtuVarA6;
        this.I = zzbqg.a(zzdtuVarA6, zzcyx.a());
        zzdtq zzdtqVarC5 = zzdtq.a(1, 1).b(hcVar.J1).a(this.I).c();
        this.J = zzdtqVarC5;
        this.K = zzdth.a(zzbvf.a(zzdtqVarC5));
        this.L = zzbqk.b(this.q, zzcyx.a());
        this.M = zzbwo.a(zzbvzVar);
        zzdtu<zzbxa> zzdtuVarA7 = zzdth.a(zzbxb.a(hcVar.f12704c, this.M, this.f12762g, hcVar.c2.f14504j, zzbww.a()));
        this.N = zzdtuVarA7;
        this.O = zzbwg.a(zzbvzVar, zzdtuVarA7);
        this.P = zzbwd.a(zzbvzVar, hcVar.l, hcVar.c2.f14504j, this.f12762g, hcVar.p);
        zzdtq zzdtqVarC6 = zzdtq.a(7, 3).a(hcVar.K1).a(hcVar.L1).a(hcVar.M1).b(hcVar.N1).b(hcVar.O1).b(hcVar.P1).a(hcVar.Q1).a(this.L).a(this.O).a(this.P).c();
        this.Q = zzdtqVarC6;
        this.R = zzdth.a(zzbsq.a(zzdtqVarC6));
        zzdtu<zzbpv> zzdtuVarA8 = zzdth.a(zzbpw.a(this.D));
        this.S = zzdtuVarA8;
        this.T = zzbqp.a(this.a, zzdtuVarA8);
        this.U = zzdth.a(zzbmx.a(this.l, zzcyx.a(), this.f12763h));
        this.V = zzbwh.a(zzbvzVar, this.N);
        zzdtq zzdtqVarC7 = zzdtq.a(2, 2).b(hcVar.V1).a(this.T).b(this.U).a(this.V).c();
        this.W = zzdtqVarC7;
        this.X = zzdth.a(zzbta.a(zzdtqVarC7));
        zzdtq zzdtqVarC8 = zzdtq.a(0, 1).b(hcVar.W1).c();
        this.Y = zzdtqVarC8;
        this.Z = zzdth.a(zzbvw.a(zzdtqVarC8));
        zzdtu<zzbxe> zzdtuVarA9 = zzdth.a(zzbxf.a(this.o));
        this.a0 = zzdtuVarA9;
        this.b0 = zzbwm.a(zzdtuVarA9);
        zzdtq zzdtqVarC9 = zzdtq.a(0, 1).b(this.b0).c();
        this.c0 = zzdtqVarC9;
        zzdtu<zzbuv> zzdtuVarA10 = zzdth.a(zzbuy.a(zzdtqVarC9));
        this.d0 = zzdtuVarA10;
        this.e0 = zzdth.a(zzbwr.a(this.X, zzdtuVarA10));
        this.f0 = zzdth.a(zzbmw.a(this.l, zzcyx.a(), this.f12763h));
        this.g0 = zzdtq.a(0, 2).b(hcVar.a2).b(this.f0).c();
        this.h0 = zzdth.a(zzbvc.a(hcVar.l, this.g0, this.f12762g));
        this.i0 = zzdth.a(zzbrh.a(this.f12760e, hcVar.l, hcVar.c2.f14504j, this.f12762g, hcVar.c2.J));
        this.j0 = zzdth.a(zzbqn.a(this.f12759d, hcVar.l, this.i0));
        this.k0 = zzbwn.a(zzbvzVar, hcVar.c2.f14497c);
        zzdtq zzdtqVarC10 = zzdtq.a(1, 1).b(hcVar.b2).a(this.k0).c();
        this.l0 = zzdtqVarC10;
        this.m0 = zzdth.a(zzbtn.a(zzdtqVarC10));
        this.n0 = zzdth.a(zzcea.a(this.G, this.D, hcVar.Z1, this.X, hcVar.U1, hcVar.c2.f14497c, this.h0, this.l, this.j0, this.o, this.i0, hcVar.e0, this.m0));
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
        return new zzcoj(this.G.get(), this.v.get(), this.D.get(), this.R.get(), (zzbtp) this.o0.U1.get(), this.X.get(), this.Z.get());
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final zzcdp g() {
        return this.n0.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final zzbvx h() {
        zzbvx zzbvxVarA = zzbwp.a((Context) this.o0.l.get(), this.o.get(), new zzbup(Collections.singleton(zzbwk.a(this.f12757b, this.A.get()))), zzbwf.a(this.f12757b), this.S.get(), (zzdan) this.o0.c2.L.get());
        zzbql.d(zzbvxVarA, zzbpu.b(this.f12758c));
        zzbql.c(zzbvxVarA, zzbps.b(this.f12758c));
        zzbql.a(zzbvxVarA, this.o.get());
        zzbql.b(zzbvxVarA, this.R.get());
        zzbql.e(zzbvxVarA, zzbpt.b(this.f12758c));
        return zzbvxVarA;
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final zzbsv i() {
        return this.X.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbvy
    public final zzbwq j() {
        return this.e0.get();
    }
}
