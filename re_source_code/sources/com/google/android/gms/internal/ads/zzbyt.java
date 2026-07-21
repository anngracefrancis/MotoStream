package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import cm.aptoide.pt.account.AccountAnalytics;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyt {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zzaar f14872b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzaea f14873c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f14874d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<zzadw> f14875e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzabj f14877g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Bundle f14878h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbgz f14879i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzbgz f14880j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private IObjectWrapper f14881k;
    private View l;
    private IObjectWrapper m;
    private double n;
    private zzaei o;
    private zzaei p;
    private String q;
    private float t;
    private c.e.g<String, zzadw> r = new c.e.g<>();
    private c.e.g<String, String> s = new c.e.g<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<zzabj> f14876f = Collections.emptyList();

    private static <T> T G(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return (T) ObjectWrapper.k0(iObjectWrapper);
    }

    public static zzbyt H(zzana zzanaVar) {
        try {
            return p(zzanaVar.getVideoController(), zzanaVar.f(), (View) G(zzanaVar.K()), zzanaVar.g(), zzanaVar.k(), zzanaVar.i(), zzanaVar.getExtras(), zzanaVar.h(), (View) G(zzanaVar.I()), zzanaVar.j(), zzanaVar.getStore(), zzanaVar.o(), zzanaVar.t(), zzanaVar.n(), null, 0.0f);
        } catch (RemoteException e2) {
            zzbad.d("Failed to get native ad assets from app install ad mapper", e2);
            return null;
        }
    }

    public static zzbyt I(zzand zzandVar) {
        try {
            return p(zzandVar.getVideoController(), zzandVar.f(), (View) G(zzandVar.K()), zzandVar.g(), zzandVar.k(), zzandVar.i(), zzandVar.getExtras(), zzandVar.h(), (View) G(zzandVar.I()), zzandVar.j(), null, null, -1.0d, zzandVar.D0(), zzandVar.w(), 0.0f);
        } catch (RemoteException e2) {
            zzbad.d("Failed to get native ad assets from content ad mapper", e2);
            return null;
        }
    }

    public static zzbyt J(zzang zzangVar) {
        try {
            return p(zzangVar.getVideoController(), zzangVar.f(), (View) G(zzangVar.K()), zzangVar.g(), zzangVar.k(), zzangVar.i(), zzangVar.getExtras(), zzangVar.h(), (View) G(zzangVar.I()), zzangVar.j(), zzangVar.getStore(), zzangVar.o(), zzangVar.t(), zzangVar.n(), zzangVar.w(), zzangVar.X3());
        } catch (RemoteException e2) {
            zzbad.d("Failed to get native ad assets from unified ad mapper", e2);
            return null;
        }
    }

    private final synchronized void O(float f2) {
        this.t = f2;
    }

    private final synchronized String Q(String str) {
        return this.s.get(str);
    }

    private static zzbyt p(zzaar zzaarVar, zzaea zzaeaVar, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d2, zzaei zzaeiVar, String str6, float f2) {
        zzbyt zzbytVar = new zzbyt();
        zzbytVar.a = 6;
        zzbytVar.f14872b = zzaarVar;
        zzbytVar.f14873c = zzaeaVar;
        zzbytVar.f14874d = view;
        zzbytVar.T("headline", str);
        zzbytVar.f14875e = list;
        zzbytVar.T("body", str2);
        zzbytVar.f14878h = bundle;
        zzbytVar.T("call_to_action", str3);
        zzbytVar.l = view2;
        zzbytVar.m = iObjectWrapper;
        zzbytVar.T(AccountAnalytics.STORE, str4);
        zzbytVar.T("price", str5);
        zzbytVar.n = d2;
        zzbytVar.o = zzaeiVar;
        zzbytVar.T("advertiser", str6);
        zzbytVar.O(f2);
        return zzbytVar;
    }

    public static zzbyt q(zzana zzanaVar) {
        try {
            zzaar videoController = zzanaVar.getVideoController();
            zzaea zzaeaVarF = zzanaVar.f();
            View view = (View) G(zzanaVar.K());
            String strG = zzanaVar.g();
            List<zzadw> listK = zzanaVar.k();
            String strI = zzanaVar.i();
            Bundle extras = zzanaVar.getExtras();
            String strH = zzanaVar.h();
            View view2 = (View) G(zzanaVar.I());
            IObjectWrapper iObjectWrapperJ = zzanaVar.j();
            String store = zzanaVar.getStore();
            String strO = zzanaVar.o();
            double dT = zzanaVar.t();
            zzaei zzaeiVarN = zzanaVar.n();
            zzbyt zzbytVar = new zzbyt();
            zzbytVar.a = 2;
            zzbytVar.f14872b = videoController;
            zzbytVar.f14873c = zzaeaVarF;
            zzbytVar.f14874d = view;
            zzbytVar.T("headline", strG);
            zzbytVar.f14875e = listK;
            zzbytVar.T("body", strI);
            zzbytVar.f14878h = extras;
            zzbytVar.T("call_to_action", strH);
            zzbytVar.l = view2;
            zzbytVar.m = iObjectWrapperJ;
            zzbytVar.T(AccountAnalytics.STORE, store);
            zzbytVar.T("price", strO);
            zzbytVar.n = dT;
            zzbytVar.o = zzaeiVarN;
            return zzbytVar;
        } catch (RemoteException e2) {
            zzbad.d("Failed to get native ad from app install ad mapper", e2);
            return null;
        }
    }

    public static zzbyt r(zzand zzandVar) {
        try {
            zzaar videoController = zzandVar.getVideoController();
            zzaea zzaeaVarF = zzandVar.f();
            View view = (View) G(zzandVar.K());
            String strG = zzandVar.g();
            List<zzadw> listK = zzandVar.k();
            String strI = zzandVar.i();
            Bundle extras = zzandVar.getExtras();
            String strH = zzandVar.h();
            View view2 = (View) G(zzandVar.I());
            IObjectWrapper iObjectWrapperJ = zzandVar.j();
            String strW = zzandVar.w();
            zzaei zzaeiVarD0 = zzandVar.D0();
            zzbyt zzbytVar = new zzbyt();
            zzbytVar.a = 1;
            zzbytVar.f14872b = videoController;
            zzbytVar.f14873c = zzaeaVarF;
            zzbytVar.f14874d = view;
            zzbytVar.T("headline", strG);
            zzbytVar.f14875e = listK;
            zzbytVar.T("body", strI);
            zzbytVar.f14878h = extras;
            zzbytVar.T("call_to_action", strH);
            zzbytVar.l = view2;
            zzbytVar.m = iObjectWrapperJ;
            zzbytVar.T("advertiser", strW);
            zzbytVar.p = zzaeiVarD0;
            return zzbytVar;
        } catch (RemoteException e2) {
            zzbad.d("Failed to get native ad from content ad mapper", e2);
            return null;
        }
    }

    public final synchronized zzbgz A() {
        return this.f14879i;
    }

    public final synchronized zzbgz B() {
        return this.f14880j;
    }

    public final synchronized IObjectWrapper C() {
        return this.f14881k;
    }

    public final synchronized c.e.g<String, zzadw> D() {
        return this.r;
    }

    public final synchronized c.e.g<String, String> E() {
        return this.s;
    }

    public final synchronized void F(IObjectWrapper iObjectWrapper) {
        this.f14881k = iObjectWrapper;
    }

    public final synchronized void K(zzaar zzaarVar) {
        this.f14872b = zzaarVar;
    }

    public final synchronized void L(zzaei zzaeiVar) {
        this.p = zzaeiVar;
    }

    public final synchronized void M(int i2) {
        this.a = i2;
    }

    public final synchronized void N(List<zzabj> list) {
        this.f14876f = list;
    }

    public final synchronized void P(String str) {
        this.q = str;
    }

    public final synchronized void R(zzbgz zzbgzVar) {
        this.f14879i = zzbgzVar;
    }

    public final synchronized void S(zzbgz zzbgzVar) {
        this.f14880j = zzbgzVar;
    }

    public final synchronized void T(String str, String str2) {
        try {
            if (str2 == null) {
                this.s.remove(str);
            } else {
                this.s.put(str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzaei U() {
        return this.o;
    }

    public final synchronized zzaea V() {
        return this.f14873c;
    }

    public final synchronized IObjectWrapper W() {
        return this.m;
    }

    public final synchronized zzaei X() {
        return this.p;
    }

    public final synchronized float Y() {
        return this.t;
    }

    public final synchronized void Z(View view) {
        this.l = view;
    }

    public final synchronized void a() {
        zzbgz zzbgzVar = this.f14879i;
        if (zzbgzVar != null) {
            zzbgzVar.destroy();
            this.f14879i = null;
        }
        zzbgz zzbgzVar2 = this.f14880j;
        if (zzbgzVar2 != null) {
            zzbgzVar2.destroy();
            this.f14880j = null;
        }
        this.f14881k = null;
        this.r.clear();
        this.s.clear();
        this.f14872b = null;
        this.f14873c = null;
        this.f14874d = null;
        this.f14875e = null;
        this.f14878h = null;
        this.l = null;
        this.m = null;
        this.o = null;
        this.p = null;
        this.q = null;
    }

    public final synchronized String b() {
        return Q("advertiser");
    }

    public final synchronized String c() {
        return Q("body");
    }

    public final synchronized String d() {
        return Q("call_to_action");
    }

    public final synchronized String e() {
        return this.q;
    }

    public final synchronized Bundle f() {
        if (this.f14878h == null) {
            this.f14878h = new Bundle();
        }
        return this.f14878h;
    }

    public final synchronized String g() {
        return Q("headline");
    }

    public final synchronized List<zzadw> h() {
        return this.f14875e;
    }

    public final synchronized List<zzabj> i() {
        return this.f14876f;
    }

    public final synchronized String j() {
        return Q("price");
    }

    public final synchronized double k() {
        return this.n;
    }

    public final synchronized String l() {
        return Q(AccountAnalytics.STORE);
    }

    public final synchronized zzaar m() {
        return this.f14872b;
    }

    public final synchronized void n(List<zzadw> list) {
        this.f14875e = list;
    }

    public final synchronized void o(double d2) {
        this.n = d2;
    }

    public final synchronized void s(zzabj zzabjVar) {
        this.f14877g = zzabjVar;
    }

    public final synchronized void t(zzaea zzaeaVar) {
        this.f14873c = zzaeaVar;
    }

    public final synchronized void u(zzaei zzaeiVar) {
        this.o = zzaeiVar;
    }

    public final synchronized void v(String str, zzadw zzadwVar) {
        try {
            if (zzadwVar == null) {
                this.r.remove(str);
            } else {
                this.r.put(str, zzadwVar);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int w() {
        return this.a;
    }

    public final synchronized View x() {
        return this.f14874d;
    }

    public final synchronized zzabj y() {
        return this.f14877g;
    }

    public final synchronized View z() {
        return this.l;
    }
}
