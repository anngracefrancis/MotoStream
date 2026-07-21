package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class st implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Application f13335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f13336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f13337h = false;

    public st(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f13336g = new WeakReference<>(activityLifecycleCallbacks);
        this.f13335f = application;
    }

    private final void a(zzdu zzduVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f13336g.get();
            if (activityLifecycleCallbacks != null) {
                zzduVar.a(activityLifecycleCallbacks);
            } else {
                if (this.f13337h) {
                    return;
                }
                this.f13335f.unregisterActivityLifecycleCallbacks(this);
                this.f13337h = true;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new ku(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new hy(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new jw(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new qv(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new wx(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new ev(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new hx(this, activity));
    }
}
