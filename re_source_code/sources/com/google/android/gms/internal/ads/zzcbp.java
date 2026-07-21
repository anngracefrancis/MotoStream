package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcbp {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbmy f15017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbva f15018c;

    zzcbp(Executor executor, zzbmy zzbmyVar, zzbva zzbvaVar) {
        this.a = executor;
        this.f15018c = zzbvaVar;
        this.f15017b = zzbmyVar;
    }

    final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        this.f15017b.j();
    }

    final /* synthetic */ void b(zzbgz zzbgzVar, Map map) {
        this.f15017b.k();
    }

    public final void c(final zzbgz zzbgzVar) {
        if (zzbgzVar == null) {
            return;
        }
        this.f15018c.Y(zzbgzVar.getView());
        this.f15018c.V(new zzue(zzbgzVar) { // from class: com.google.android.gms.internal.ads.dh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbgz f12480f;

            {
                this.f12480f = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzue
            public final void r0(zzud zzudVar) {
                zzbii zzbiiVarP = this.f12480f.p();
                Rect rect = zzudVar.f16801f;
                zzbiiVarP.l(rect.left, rect.top, false);
            }
        }, this.a);
        this.f15018c.V(new zzue(zzbgzVar) { // from class: com.google.android.gms.internal.ads.eh

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbgz f12532f;

            {
                this.f12532f = zzbgzVar;
            }

            @Override // com.google.android.gms.internal.ads.zzue
            public final void r0(zzud zzudVar) {
                zzbgz zzbgzVar2 = this.f12532f;
                HashMap map = new HashMap();
                map.put("isVisible", zzudVar.m ? "1" : "0");
                zzbgzVar2.y("onAdVisibilityChanged", map);
            }
        }, this.a);
        this.f15018c.V(this.f15017b, this.a);
        this.f15017b.u(zzbgzVar);
        zzbgzVar.f("/trackActiveViewUnit", new zzaho(this) { // from class: com.google.android.gms.internal.ads.fh
            private final zzcbp a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, Map map) {
                this.a.b((zzbgz) obj, map);
            }
        });
        zzbgzVar.f("/untrackActiveViewUnit", new zzaho(this) { // from class: com.google.android.gms.internal.ads.gh
            private final zzcbp a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzaho
            public final void a(Object obj, Map map) {
                this.a.a((zzbgz) obj, map);
            }
        });
    }
}
