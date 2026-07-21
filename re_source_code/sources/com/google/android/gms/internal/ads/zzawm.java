package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawm {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zztz f14217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzaxc f14218c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzawu f14219d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14220e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Context f14221f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzbai f14222g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private zzacy f14223h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Boolean f14224i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicInteger f14225j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final x4 f14226k;
    private final Object l;
    private zzbbh<ArrayList<String>> m;

    public zzawm() {
        zzaxc zzaxcVar = new zzaxc();
        this.f14218c = zzaxcVar;
        this.f14219d = new zzawu(zzyt.f(), zzaxcVar);
        this.f14220e = false;
        this.f14223h = null;
        this.f14224i = null;
        this.f14225j = new AtomicInteger(0);
        this.f14226k = new x4(null);
        this.l = new Object();
    }

    @TargetApi(16)
    private static ArrayList<String> f(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfoE = Wrappers.a(context).e(context.getApplicationInfo().packageName, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
            if (packageInfoE.requestedPermissions != null && packageInfoE.requestedPermissionsFlags != null) {
                int i2 = 0;
                while (true) {
                    String[] strArr = packageInfoE.requestedPermissions;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if ((packageInfoE.requestedPermissionsFlags[i2] & 2) != 0) {
                        arrayList.add(strArr[i2]);
                    }
                    i2++;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final Context a() {
        return this.f14221f;
    }

    public final Resources b() {
        if (this.f14222g.f14329i) {
            return this.f14221f.getResources();
        }
        try {
            zzbae.b(this.f14221f).getResources();
            return null;
        } catch (zzbag e2) {
            zzbad.d("Cannot load resource from dynamite apk or local jar", e2);
            return null;
        }
    }

    public final void d(Boolean bool) {
        synchronized (this.a) {
            this.f14224i = bool;
        }
    }

    public final void e(Throwable th, String str) {
        zzaqx.e(this.f14221f, this.f14222g).a(th, str);
    }

    public final void h(Throwable th, String str) {
        zzaqx.e(this.f14221f, this.f14222g).b(th, str, ((Float) zzyt.e().c(zzacu.p)).floatValue());
    }

    @TargetApi(23)
    public final void k(Context context, zzbai zzbaiVar) {
        synchronized (this.a) {
            if (!this.f14220e) {
                this.f14221f = context.getApplicationContext();
                this.f14222g = zzbaiVar;
                zzk.zzlj().d(this.f14219d);
                zzacy zzacyVar = null;
                this.f14218c.B(this.f14221f, null, true);
                zzaqx.e(this.f14221f, this.f14222g);
                this.f14217b = new zztz(context.getApplicationContext(), this.f14222g);
                zzk.zzlp();
                if (((Boolean) zzyt.e().c(zzacu.e0)).booleanValue()) {
                    zzacyVar = new zzacy();
                } else {
                    zzawz.m("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                }
                this.f14223h = zzacyVar;
                if (zzacyVar != null) {
                    zzbao.a(new w4(this).zzvi(), "AppState.registerCsiReporter");
                }
                this.f14220e = true;
                s();
            }
        }
        zzk.zzlg().g0(context, zzbaiVar.f14326f);
    }

    public final zzacy l() {
        zzacy zzacyVar;
        synchronized (this.a) {
            zzacyVar = this.f14223h;
        }
        return zzacyVar;
    }

    public final Boolean m() {
        Boolean bool;
        synchronized (this.a) {
            bool = this.f14224i;
        }
        return bool;
    }

    public final void n() {
        this.f14226k.a();
    }

    public final void o() {
        this.f14225j.incrementAndGet();
    }

    public final void p() {
        this.f14225j.decrementAndGet();
    }

    public final int q() {
        return this.f14225j.get();
    }

    public final zzaxb r() {
        zzaxc zzaxcVar;
        synchronized (this.a) {
            zzaxcVar = this.f14218c;
        }
        return zzaxcVar;
    }

    public final zzbbh<ArrayList<String>> s() {
        if (PlatformVersion.c() && this.f14221f != null) {
            if (!((Boolean) zzyt.e().c(zzacu.p2)).booleanValue()) {
                synchronized (this.l) {
                    zzbbh<ArrayList<String>> zzbbhVar = this.m;
                    if (zzbbhVar != null) {
                        return zzbbhVar;
                    }
                    zzbbh<ArrayList<String>> zzbbhVarA = zzaxg.a(new Callable(this) { // from class: com.google.android.gms.internal.ads.v4

                        /* JADX INFO: renamed from: f, reason: collision with root package name */
                        private final zzawm f13439f;

                        {
                            this.f13439f = this;
                        }

                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.f13439f.u();
                        }
                    });
                    this.m = zzbbhVarA;
                    return zzbbhVarA;
                }
            }
        }
        return zzbar.o(new ArrayList());
    }

    public final zzawu t() {
        return this.f14219d;
    }

    final /* synthetic */ ArrayList u() throws Exception {
        return f(zzasq.f(this.f14221f));
    }
}
