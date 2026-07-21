package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
final class m40 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f12957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f12958g;
    private Runnable m;
    private long o;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f12959h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12960i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12961j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<zzut> f12962k = new ArrayList();
    private final List<zzvg> l = new ArrayList();
    private boolean n = false;

    m40() {
    }

    private final void c(Activity activity) {
        synchronized (this.f12959h) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.f12957f = activity;
            }
        }
    }

    static /* synthetic */ boolean g(m40 m40Var, boolean z) {
        m40Var.f12960i = false;
        return false;
    }

    public final Activity a() {
        return this.f12957f;
    }

    public final Context b() {
        return this.f12958g;
    }

    public final void e(Application application, Context context) {
        if (this.n) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
        if (context instanceof Activity) {
            c((Activity) context);
        }
        this.f12958g = application;
        this.o = ((Long) zzyt.e().c(zzacu.e1)).longValue();
        this.n = true;
    }

    public final void f(zzut zzutVar) {
        synchronized (this.f12959h) {
            this.f12962k.add(zzutVar);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.f12959h) {
            try {
                Activity activity2 = this.f12957f;
                if (activity2 == null) {
                    return;
                }
                if (activity2.equals(activity)) {
                    this.f12957f = null;
                }
                Iterator<zzvg> it = this.l.iterator();
                while (it.hasNext()) {
                    try {
                        if (it.next().a(activity)) {
                            it.remove();
                        }
                    } catch (Exception e2) {
                        zzk.zzlk().e(e2, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        c(activity);
        synchronized (this.f12959h) {
            Iterator<zzvg> it = this.l.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityPaused(activity);
                } catch (Exception e2) {
                    zzk.zzlk().e(e2, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
                }
            }
        }
        this.f12961j = true;
        Runnable runnable = this.m;
        if (runnable != null) {
            zzaxi.a.removeCallbacks(runnable);
        }
        Handler handler = zzaxi.a;
        n40 n40Var = new n40(this);
        this.m = n40Var;
        handler.postDelayed(n40Var, this.o);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        c(activity);
        this.f12961j = false;
        boolean z = !this.f12960i;
        this.f12960i = true;
        Runnable runnable = this.m;
        if (runnable != null) {
            zzaxi.a.removeCallbacks(runnable);
        }
        synchronized (this.f12959h) {
            Iterator<zzvg> it = this.l.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onActivityResumed(activity);
                } catch (Exception e2) {
                    zzk.zzlk().e(e2, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
                }
            }
            if (z) {
                Iterator<zzut> it2 = this.f12962k.iterator();
                while (it2.hasNext()) {
                    try {
                        it2.next().a(true);
                    } catch (Exception e3) {
                        zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e3);
                    }
                }
            } else {
                zzbad.e("App is still foreground.");
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        c(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
