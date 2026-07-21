package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdp {
    private final zzbri a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbse f15108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbss f15109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbsv f15110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbtp f15111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f15112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbva f15113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbmn f15114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zzb f15115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbry f15116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzavb f15117k;
    private final zzdh l;
    private final zzbtl m;

    public zzcdp(zzbri zzbriVar, zzbse zzbseVar, zzbss zzbssVar, zzbsv zzbsvVar, zzbtp zzbtpVar, Executor executor, zzbva zzbvaVar, zzbmn zzbmnVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbry zzbryVar, zzavb zzavbVar, zzdh zzdhVar, zzbtl zzbtlVar) {
        this.a = zzbriVar;
        this.f15108b = zzbseVar;
        this.f15109c = zzbssVar;
        this.f15110d = zzbsvVar;
        this.f15111e = zzbtpVar;
        this.f15112f = executor;
        this.f15113g = zzbvaVar;
        this.f15114h = zzbmnVar;
        this.f15115i = zzbVar;
        this.f15116j = zzbryVar;
        this.f15117k = zzavbVar;
        this.l = zzdhVar;
        this.m = zzbtlVar;
    }

    public static zzbbh<?> a(zzbgz zzbgzVar, String str, String str2) {
        final zzbbr zzbbrVar = new zzbbr();
        zzbgzVar.p().i(new zzbij(zzbbrVar) { // from class: com.google.android.gms.internal.ads.ci
            private final zzbbr a;

            {
                this.a = zzbbrVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zzae(boolean z) {
                zzbbr zzbbrVar2 = this.a;
                if (z) {
                    zzbbrVar2.a(null);
                } else {
                    zzbbrVar2.c(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzbgzVar.G(str, str2, null);
        return zzbbrVar;
    }

    final /* synthetic */ void c(zzbgz zzbgzVar, zzbgz zzbgzVar2, Map map) {
        this.f15114h.B(zzbgzVar);
    }

    final /* synthetic */ boolean d(View view, MotionEvent motionEvent) {
        this.f15115i.recordClick();
        zzavb zzavbVar = this.f15117k;
        if (zzavbVar == null) {
            return false;
        }
        zzavbVar.e();
        return false;
    }

    final /* synthetic */ void e(View view) {
        this.f15115i.recordClick();
        zzavb zzavbVar = this.f15117k;
        if (zzavbVar != null) {
            zzavbVar.e();
        }
    }

    final /* synthetic */ void f() {
        this.f15108b.f0();
    }

    final /* synthetic */ void g() {
        this.a.onAdClicked();
    }

    public final void i(final zzbgz zzbgzVar, boolean z) {
        zzdc zzdcVarF;
        zzbgzVar.p().c(new zzxr(this) { // from class: com.google.android.gms.internal.ads.uh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcdp f13397f;

            {
                this.f13397f = this;
            }

            @Override // com.google.android.gms.internal.ads.zzxr
            public final void onAdClicked() {
                this.f13397f.g();
            }
        }, this.f15109c, this.f15110d, new zzagx(this) { // from class: com.google.android.gms.internal.ads.vh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcdp f13456f;

            {
                this.f13456f = this;
            }

            @Override // com.google.android.gms.internal.ads.zzagx
            public final void onAppEvent(String str, String str2) {
                this.f13456f.j(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzu(this) { // from class: com.google.android.gms.internal.ads.wh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcdp f13510f;

            {
                this.f13510f = this;
            }

            @Override // com.google.android.gms.ads.internal.overlay.zzu
            public final void zztq() {
                this.f13510f.f();
            }
        }, z, null, this.f15115i, new di(this), this.f15117k);
        zzbgzVar.setOnTouchListener(new View.OnTouchListener(this) { // from class: com.google.android.gms.internal.ads.xh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcdp f13580f;

            {
                this.f13580f = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f13580f.d(view, motionEvent);
            }
        });
        zzbgzVar.setOnClickListener(new View.OnClickListener(this) { // from class: com.google.android.gms.internal.ads.yh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcdp f13643f;

            {
                this.f13643f = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f13643f.e(view);
            }
        });
        if (((Boolean) zzyt.e().c(zzacu.n2)).booleanValue() && (zzdcVarF = this.l.f()) != null) {
            zzdcVarF.zzb(zzbgzVar.getView());
        }
        this.f15113g.V(zzbgzVar, this.f15112f);
        this.f15113g.V(new zzue(zzbgzVar) { // from class: com.google.android.gms.internal.ads.zh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbgz f13707f;

            {
                this.f13707f = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzue
            public final void r0(zzud zzudVar) {
                zzbii zzbiiVarP = this.f13707f.p();
                Rect rect = zzudVar.f16801f;
                zzbiiVarP.l(rect.left, rect.top, false);
            }
        }, this.f15112f);
        this.f15113g.Y(zzbgzVar.getView());
        zzbgzVar.f("/trackActiveViewUnit", new zzaho(this, zzbgzVar) { // from class: com.google.android.gms.internal.ads.ai
            private final zzcdp a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final zzbgz f12255b;

            {
                this.a = this;
                this.f12255b = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, Map map) {
                this.a.c(this.f12255b, (zzbgz) obj, map);
            }
        });
        this.f15114h.F(zzbgzVar);
        this.f15116j.Y(new zzbvp(zzbgzVar) { // from class: com.google.android.gms.internal.ads.bi
            private final zzbgz a;

            {
                this.a = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbvp
            public final void a() {
                this.a.destroy();
            }
        }, this.f15112f);
    }

    final /* synthetic */ void j(String str, String str2) {
        this.f15111e.onAppEvent(str, str2);
    }
}
