package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class e40 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Application f12505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final WeakReference<Application.ActivityLifecycleCallbacks> f12506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f12507h = false;

    public e40(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.f12506g = new WeakReference<>(activityLifecycleCallbacks);
        this.f12505f = application;
    }

    private final void a(zzun zzunVar) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.f12506g.get();
            if (activityLifecycleCallbacks != null) {
                zzunVar.a(activityLifecycleCallbacks);
            } else {
                if (this.f12507h) {
                    return;
                }
                this.f12505f.unregisterActivityLifecycleCallbacks(this);
                this.f12507h = true;
            }
        } catch (Exception e2) {
            zzbad.c("Error while dispatching lifecycle callback.", e2);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        a(new f40(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        a(new l40(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        a(new i40(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        a(new h40(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a(new k40(this, activity, bundle));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        a(new g40(this, activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        a(new j40(this, activity));
    }
}
