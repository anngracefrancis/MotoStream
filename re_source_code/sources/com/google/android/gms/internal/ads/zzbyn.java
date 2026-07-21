package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbyn extends zzbpc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f14856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbyt f14857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbzb f14858h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbzl f14859i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbyx f14860j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbzc f14861k;
    private final zzdte<zzccb> l;
    private final zzdte<zzcbz> m;
    private final zzdte<zzccg> n;
    private final zzdte<zzcbw> o;
    private final zzdte<zzccd> p;
    private zzcab q;
    private boolean r;
    private final zzavf s;
    private final zzdh t;
    private final zzbai u;
    private final Context v;

    public zzbyn(Executor executor, zzbyt zzbytVar, zzbzb zzbzbVar, zzbzl zzbzlVar, zzbyx zzbyxVar, zzbzc zzbzcVar, zzdte<zzccb> zzdteVar, zzdte<zzcbz> zzdteVar2, zzdte<zzccg> zzdteVar3, zzdte<zzcbw> zzdteVar4, zzdte<zzccd> zzdteVar5, zzavf zzavfVar, zzdh zzdhVar, zzbai zzbaiVar, Context context) {
        this.f14856f = executor;
        this.f14857g = zzbytVar;
        this.f14858h = zzbzbVar;
        this.f14859i = zzbzlVar;
        this.f14860j = zzbyxVar;
        this.f14861k = zzbzcVar;
        this.l = zzdteVar;
        this.m = zzdteVar2;
        this.n = zzdteVar3;
        this.o = zzdteVar4;
        this.p = zzdteVar5;
        this.s = zzavfVar;
        this.t = zzdhVar;
        this.u = zzbaiVar;
        this.v = context;
    }

    public static boolean D(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), null);
    }

    private final void y(String str) {
        String str2;
        View view;
        if (this.f14860j.d()) {
            zzbgz zzbgzVarB = this.f14857g.B();
            zzbgz zzbgzVarA = this.f14857g.A();
            if (zzbgzVarB == null && zzbgzVarA == null) {
                return;
            }
            boolean z = zzbgzVarB != null;
            boolean z2 = zzbgzVarA != null;
            String str3 = null;
            if (z) {
                str2 = str3;
            } else if (z2) {
                str3 = "javascript";
                zzbgzVarB = zzbgzVarA;
                str2 = str3;
            } else {
                zzbgzVarB = null;
                str2 = null;
            }
            if (zzbgzVarB.getWebView() != null && zzk.zzlv().g(this.v)) {
                zzbai zzbaiVar = this.u;
                int i2 = zzbaiVar.f14327g;
                int i3 = zzbaiVar.f14328h;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i2);
                sb.append(".");
                sb.append(i3);
                IObjectWrapper iObjectWrapperC = zzk.zzlv().c(sb.toString(), zzbgzVarB.getWebView(), HttpUrl.FRAGMENT_ENCODE_SET, "javascript", str2, str);
                if (iObjectWrapperC == null) {
                    return;
                }
                this.f14857g.F(iObjectWrapperC);
                zzbgzVarB.H(iObjectWrapperC);
                if (z2 && (view = zzbgzVarA.getView()) != null) {
                    zzk.zzlv().d(iObjectWrapperC, view);
                }
                zzk.zzlv().e(iObjectWrapperC);
            }
        }
    }

    public final synchronized boolean A(Bundle bundle) {
        if (this.r) {
            return true;
        }
        boolean zM = this.f14858h.m(bundle);
        this.r = zM;
        return zM;
    }

    public final synchronized void B() {
        this.f14858h.j0();
    }

    public final zzaee C() {
        return new zzbym(this.f14857g);
    }

    public final void E(View view) {
        IObjectWrapper iObjectWrapperC = this.f14857g.C();
        boolean z = this.f14857g.B() != null;
        if (!this.f14860j.d() || iObjectWrapperC == null || !z || view == null) {
            return;
        }
        zzk.zzlv().d(iObjectWrapperC, view);
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final synchronized void a() {
        this.f14856f.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.vf

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbyn f13455f;

            {
                this.f13455f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13455f.r();
            }
        });
        super.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void c() {
        this.f14856f.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.tf

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbyn f13354f;

            {
                this.f13354f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13354f.s();
            }
        });
        if (this.f14857g.w() != 7) {
            Executor executor = this.f14856f;
            zzbzb zzbzbVar = this.f14858h;
            zzbzbVar.getClass();
            executor.execute(uf.a(zzbzbVar));
        }
        super.c();
    }

    public final synchronized void g() {
        this.f14858h.W();
    }

    public final synchronized void h() {
        zzcab zzcabVar = this.q;
        if (zzcabVar == null) {
            zzbad.e("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            final boolean z = zzcabVar instanceof zzbzi;
            this.f14856f.execute(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.wf

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbyn f13508f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final boolean f13509g;

                {
                    this.f13508f = this;
                    this.f13509g = z;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13508f.t(this.f13509g);
                }
            });
        }
    }

    public final synchronized void i(View view) {
        this.f14858h.c(view);
    }

    public final synchronized void j(View view, MotionEvent motionEvent, View view2) {
        this.f14858h.g(view, motionEvent, view2);
    }

    public final synchronized void k(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (((Boolean) zzyt.e().c(zzacu.X4)).booleanValue()) {
            this.f14859i.g(this.q);
        }
        this.f14858h.h(view, view2, map, map2, z);
    }

    public final synchronized void l(zzaag zzaagVar) {
        this.f14858h.G0(zzaagVar);
    }

    public final synchronized void m(zzaak zzaakVar) {
        this.f14858h.e0(zzaakVar);
    }

    public final synchronized void n(zzagd zzagdVar) {
        this.f14858h.d0(zzagdVar);
    }

    public final synchronized void o(zzcab zzcabVar) {
        zzdc zzdcVarF;
        this.q = zzcabVar;
        this.f14859i.f(zzcabVar);
        this.f14858h.a(zzcabVar.k0(), zzcabVar.V3(), zzcabVar.S4(), zzcabVar, zzcabVar);
        if (((Boolean) zzyt.e().c(zzacu.n2)).booleanValue() && (zzdcVarF = this.t.f()) != null) {
            zzdcVarF.zzb(zzcabVar.k0());
        }
        if (zzcabVar.E3() != null) {
            zzcabVar.E3().d(this.s);
        }
    }

    public final synchronized void p() {
        if (this.r) {
            return;
        }
        this.f14858h.l();
    }

    public final boolean q() {
        return this.f14860j.b();
    }

    final /* synthetic */ void r() {
        this.f14858h.destroy();
        this.f14857g.a();
    }

    final /* synthetic */ void s() {
        try {
            int iW = this.f14857g.w();
            if (iW == 1) {
                if (this.f14861k.a() != null) {
                    y("Google");
                    this.f14861k.a().t2(this.l.get());
                    return;
                }
                return;
            }
            if (iW == 2) {
                if (this.f14861k.b() != null) {
                    y("Google");
                    this.f14861k.b().D3(this.m.get());
                    return;
                }
                return;
            }
            if (iW == 3) {
                if (this.f14861k.h(this.f14857g.e()) != null) {
                    this.f14861k.h(this.f14857g.e()).M4(this.p.get());
                }
            } else {
                if (iW == 6) {
                    if (this.f14861k.c() != null) {
                        y("Google");
                        this.f14861k.c().u6(this.n.get());
                        return;
                    }
                    return;
                }
                if (iW != 7) {
                    zzbad.g("Wrong native template id!");
                } else if (this.f14861k.e() != null) {
                    this.f14861k.e().g6(this.o.get());
                }
            }
        } catch (RemoteException e2) {
            zzbad.c("RemoteException when notifyAdLoad is called", e2);
        }
    }

    final /* synthetic */ void t(boolean z) {
        this.f14858h.k(this.q.k0(), this.q.y4(), this.q.V3(), z);
    }

    public final synchronized void u(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.r) {
            return;
        }
        if (z) {
            this.f14858h.j(view, map, map2);
            this.r = true;
            return;
        }
        if (!z) {
            if (((Boolean) zzyt.e().c(zzacu.S2)).booleanValue() && map != null) {
                Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    View view2 = it.next().getValue().get();
                    if (view2 != null && D(view2)) {
                        this.f14858h.j(view, map, map2);
                        this.r = true;
                        return;
                    }
                }
            }
        }
    }

    public final synchronized void v(zzcab zzcabVar) {
        this.f14858h.e(zzcabVar.k0(), zzcabVar.y4());
        if (zzcabVar.E0() != null) {
            zzcabVar.E0().setClickable(false);
            zzcabVar.E0().removeAllViews();
        }
        if (zzcabVar.E3() != null) {
            zzcabVar.E3().e(this.s);
        }
        this.q = null;
    }

    public final synchronized void w(Bundle bundle) {
        this.f14858h.f(bundle);
    }

    public final synchronized void x(String str) {
        this.f14858h.i(str);
    }

    public final synchronized void z(Bundle bundle) {
        this.f14858h.b(bundle);
    }
}
