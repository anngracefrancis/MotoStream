package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzccj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.ads.internal.zza f15060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbhf f15061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f15062d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f15063e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdh f15064f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbai f15065g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzbbh<zzbgz> f15067i;
    private final ph a = new ph(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzahu f15066h = new zzahu();

    public zzccj(Context context, Executor executor, zzdh zzdhVar, zzbai zzbaiVar, com.google.android.gms.ads.internal.zza zzaVar, zzbhf zzbhfVar) {
        this.f15062d = context;
        this.f15063e = executor;
        this.f15064f = zzdhVar;
        this.f15065g = zzbaiVar;
        this.f15060b = zzaVar;
        this.f15061c = zzbhfVar;
    }

    public final synchronized void a() {
        zzbbh<zzbgz> zzbbhVar = this.f15067i;
        if (zzbbhVar == null) {
            return;
        }
        zzbar.f(zzbbhVar, new lh(this), this.f15063e);
        this.f15067i = null;
    }

    final /* synthetic */ zzbbh b(String str, JSONObject jSONObject, zzbgz zzbgzVar) throws Exception {
        return this.f15066h.b(zzbgzVar, str, jSONObject);
    }

    public final synchronized void d(String str, zzaho<Object> zzahoVar) {
        zzbbh<zzbgz> zzbbhVar = this.f15067i;
        if (zzbbhVar == null) {
            return;
        }
        zzbar.f(zzbbhVar, new mh(this, str, zzahoVar), this.f15063e);
    }

    public final synchronized void e(String str, Map<String, ?> map) {
        zzbbh<zzbgz> zzbbhVar = this.f15067i;
        if (zzbbhVar == null) {
            return;
        }
        zzbar.f(zzbbhVar, new oh(this, str, map), this.f15063e);
    }

    public final <T> void f(WeakReference<T> weakReference, String str, zzaho<T> zzahoVar) {
        d(str, new rh(this, weakReference, str, zzahoVar, null));
    }

    public final synchronized void g() {
        zzbbh<zzbgz> zzbbhVarD = zzbar.d(zzbhf.a(this.f15062d, this.f15065g, (String) zzyt.e().c(zzacu.H2), this.f15064f, this.f15060b), new zzbam(this) { // from class: com.google.android.gms.internal.ads.jh
            private final zzccj a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbam
            public final Object a(Object obj) {
                return this.a.j((zzbgz) obj);
            }
        }, this.f15063e);
        this.f15067i = zzbbhVarD;
        zzbao.a(zzbbhVarD, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void h(String str, zzaho<Object> zzahoVar) {
        zzbbh<zzbgz> zzbbhVar = this.f15067i;
        if (zzbbhVar == null) {
            return;
        }
        zzbar.f(zzbbhVar, new nh(this, str, zzahoVar), this.f15063e);
    }

    public final synchronized zzbbh<JSONObject> i(final String str, final JSONObject jSONObject) {
        zzbbh<zzbgz> zzbbhVar = this.f15067i;
        if (zzbbhVar == null) {
            return zzbar.o(null);
        }
        return zzbar.c(zzbbhVar, new zzbal(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.kh
            private final zzccj a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f12880b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final JSONObject f12881c;

            {
                this.a = this;
                this.f12880b = str;
                this.f12881c = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.b(this.f12880b, this.f12881c, (zzbgz) obj);
            }
        }, this.f15063e);
    }

    final /* synthetic */ zzbgz j(zzbgz zzbgzVar) {
        zzbgzVar.f("/result", this.f15066h);
        zzbii zzbiiVarP = zzbgzVar.p();
        ph phVar = this.a;
        zzbiiVarP.c(null, phVar, phVar, phVar, phVar, false, null, new com.google.android.gms.ads.internal.zzb(this.f15062d, null, null), null, null);
        return zzbgzVar;
    }
}
