package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbkz extends zzaac {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f14510f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbai f14511g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzclc f14512h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcjz<zzams, zzclb> f14513i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzcpf f14514j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzcgb f14515k;
    private boolean l = false;

    zzbkz(Context context, zzbai zzbaiVar, zzclc zzclcVar, zzcjz<zzams, zzclb> zzcjzVar, zzcpf zzcpfVar, zzcgb zzcgbVar) {
        this.f14510f = context;
        this.f14511g = zzbaiVar;
        this.f14512h = zzclcVar;
        this.f14513i = zzcjzVar;
        this.f14514j = zzcpfVar;
        this.f14515k = zzcgbVar;
    }

    private final String h7() {
        Context applicationContext = this.f14510f.getApplicationContext() == null ? this.f14510f : this.f14510f.getApplicationContext();
        try {
            return Wrappers.a(applicationContext).c(applicationContext.getPackageName(), 128).metaData.getString("com.google.android.gms.ads.APPLICATION_ID");
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            zzawz.l("Error getting metadata", e2);
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void B2(String str, IObjectWrapper iObjectWrapper) {
        String strH7 = ((Boolean) zzyt.e().c(zzacu.e3)).booleanValue() ? h7() : HttpUrl.FRAGMENT_ENCODE_SET;
        if (!TextUtils.isEmpty(strH7)) {
            str = strH7;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        zzacu.a(this.f14510f);
        boolean zBooleanValue = ((Boolean) zzyt.e().c(zzacu.c3)).booleanValue();
        zzacj<Boolean> zzacjVar = zzacu.a1;
        boolean zBooleanValue2 = zBooleanValue | ((Boolean) zzyt.e().c(zzacjVar)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzyt.e().c(zzacjVar)).booleanValue()) {
            zBooleanValue2 = true;
            final Runnable runnable2 = (Runnable) ObjectWrapper.k0(iObjectWrapper);
            runnable = new Runnable(this, runnable2) { // from class: com.google.android.gms.internal.ads.pc

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbkz f13161f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final Runnable f13162g;

                {
                    this.f13161f = this;
                    this.f13162g = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    final zzbkz zzbkzVar = this.f13161f;
                    final Runnable runnable3 = this.f13162g;
                    zzbbm.a.execute(new Runnable(zzbkzVar, runnable3) { // from class: com.google.android.gms.internal.ads.qc

                        /* JADX INFO: renamed from: f, reason: collision with root package name */
                        private final zzbkz f13229f;

                        /* JADX INFO: renamed from: g, reason: collision with root package name */
                        private final Runnable f13230g;

                        {
                            this.f13229f = zzbkzVar;
                            this.f13230g = runnable3;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f13229f.i7(this.f13230g);
                        }
                    });
                }
            };
        }
        if (zBooleanValue2) {
            zzk.zzlo().zza(this.f14510f, this.f14511g, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized float C4() {
        return zzk.zzll().d();
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final String H3() {
        return this.f14511g.f14326f;
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized boolean J3() {
        return zzk.zzll().e();
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void N2(String str) {
        this.f14514j.g(str);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void O0(zzamp zzampVar) throws RemoteException {
        this.f14512h.c(zzampVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final List<zzaio> T2() throws RemoteException {
        return this.f14515k.f();
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void Y1(zzait zzaitVar) throws RemoteException {
        this.f14515k.l(zzaitVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void a() {
        if (this.l) {
            zzbad.i("Mobile ads is initialized already.");
            return;
        }
        zzacu.a(this.f14510f);
        zzk.zzlk().k(this.f14510f, this.f14511g);
        zzk.zzlm().c(this.f14510f);
        this.l = true;
        this.f14515k.k();
        if (((Boolean) zzyt.e().c(zzacu.b2)).booleanValue()) {
            this.f14514j.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void c2(boolean z) {
        zzk.zzll().a(z);
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void e5(String str) {
        zzacu.a(this.f14510f);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzyt.e().c(zzacu.c3)).booleanValue()) {
                zzk.zzlo().zza(this.f14510f, this.f14511g, str, (Runnable) null);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void i7(Runnable runnable) {
        Preconditions.f("Adapters must be initialized on the main thread.");
        Map<String, zzamm> mapE = zzk.zzlk().r().q().e();
        if (mapE == null || mapE.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzbad.d("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.f14512h.a()) {
            HashMap map = new HashMap();
            IObjectWrapper iObjectWrapperE0 = ObjectWrapper.E0(this.f14510f);
            Iterator<zzamm> it = mapE.values().iterator();
            while (it.hasNext()) {
                for (zzaml zzamlVar : it.next().a) {
                    String str = zzamlVar.f13977k;
                    for (String str2 : zzamlVar.f13969c) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzcjy<zzams, ListenerT> zzcjyVarA = this.f14513i.a(str3, jSONObject);
                    if (zzcjyVarA != 0) {
                        zzams zzamsVar = (zzams) zzcjyVarA.f15313b;
                        if (!zzamsVar.isInitialized() && zzamsVar.x3()) {
                            zzamsVar.H4(iObjectWrapperE0, (zzclb) zzcjyVarA.f15314c, (List) entry.getValue());
                            String strValueOf = String.valueOf(str3);
                            zzbad.e(strValueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(strValueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (Throwable th2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzbad.d(sb.toString(), th2);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final void t6(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzbad.g("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.k0(iObjectWrapper);
        if (context == null) {
            zzbad.g("Context is null. Failed to open debug menu.");
            return;
        }
        zzayb zzaybVar = new zzayb(context);
        zzaybVar.a(str);
        zzaybVar.j(this.f14511g.f14326f);
        zzaybVar.b();
    }

    @Override // com.google.android.gms.internal.ads.zzaab
    public final synchronized void v5(float f2) {
        zzk.zzll().b(f2);
    }
}
