package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmn implements com.google.android.gms.ads.internal.overlay.zzo, zzbrw, zzbrx, zzue {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbmg f14545f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbml f14546g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzamd<JSONObject, JSONObject> f14548i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Executor f14549j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Clock f14550k;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<zzbgz> f14547h = new HashSet();
    private final AtomicBoolean l = new AtomicBoolean(false);
    private final zzbmp m = new zzbmp();
    private boolean n = false;
    private WeakReference<Object> o = new WeakReference<>(this);

    public zzbmn(zzaly zzalyVar, zzbml zzbmlVar, Executor executor, zzbmg zzbmgVar, Clock clock) {
        this.f14545f = zzbmgVar;
        zzaln<JSONObject> zzalnVar = zzalo.f13955b;
        this.f14548i = zzalyVar.a("google.afma.activeView.handleUpdate", zzalnVar, zzalnVar);
        this.f14546g = zzbmlVar;
        this.f14549j = executor;
        this.f14550k = clock;
    }

    private final void u() {
        Iterator<zzbgz> it = this.f14547h.iterator();
        while (it.hasNext()) {
            this.f14545f.g(it.next());
        }
        this.f14545f.d();
    }

    public final synchronized void B(zzbgz zzbgzVar) {
        this.f14547h.add(zzbgzVar);
        this.f14545f.f(zzbgzVar);
    }

    public final void F(Object obj) {
        this.o = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final synchronized void j(Context context) {
        this.m.f14554e = "u";
        q();
        u();
        this.n = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final synchronized void k(Context context) {
        this.m.f14551b = false;
        q();
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        if (this.l.compareAndSet(false, true)) {
            this.f14545f.b(this);
            q();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        this.m.f14551b = true;
        q();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        this.m.f14551b = false;
        q();
    }

    public final synchronized void q() {
        try {
            if (!(this.o.get() != null)) {
                y();
                return;
            }
            if (!this.n && this.l.get()) {
                try {
                    this.m.f14553d = this.f14550k.b();
                    final JSONObject jSONObjectB = this.f14546g.b(this.m);
                    for (final zzbgz zzbgzVar : this.f14547h) {
                        this.f14549j.execute(new Runnable(zzbgzVar, jSONObjectB) { // from class: com.google.android.gms.internal.ads.vc

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            private final zzbgz f13453f;

                            /* JADX INFO: renamed from: g, reason: collision with root package name */
                            private final JSONObject f13454g;

                            {
                                this.f13453f = zzbgzVar;
                                this.f13454g = jSONObjectB;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f13453f.Y("AFMA_updateActiveView", this.f13454g);
                            }
                        });
                    }
                    zzbao.b(this.f14548i.zzf(jSONObjectB), "ActiveViewListener.callActiveViewJs");
                } catch (Exception e2) {
                    zzawz.l("Failed to call ActiveViewJS", e2);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrx
    public final synchronized void r(Context context) {
        this.m.f14551b = true;
        q();
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final synchronized void r0(zzud zzudVar) {
        zzbmp zzbmpVar = this.m;
        zzbmpVar.a = zzudVar.m;
        zzbmpVar.f14555f = zzudVar;
        q();
    }

    public final synchronized void y() {
        u();
        this.n = true;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzsz() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzta() {
    }
}
