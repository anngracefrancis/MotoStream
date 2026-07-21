package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final BackgroundDetector f11694f = new BackgroundDetector();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f11695g = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f11696h = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final ArrayList f11697i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11698j = false;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public interface BackgroundStateChangeListener {
        @KeepForSdk
        void a(boolean z);
    }

    @KeepForSdk
    private BackgroundDetector() {
    }

    @KeepForSdk
    public static BackgroundDetector b() {
        return f11694f;
    }

    @KeepForSdk
    public static void c(Application application) {
        BackgroundDetector backgroundDetector = f11694f;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.f11698j) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.f11698j = true;
            }
        }
    }

    private final void f(boolean z) {
        synchronized (f11694f) {
            Iterator it = this.f11697i.iterator();
            while (it.hasNext()) {
                ((BackgroundStateChangeListener) it.next()).a(z);
            }
        }
    }

    @KeepForSdk
    public void a(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f11694f) {
            this.f11697i.add(backgroundStateChangeListener);
        }
    }

    @KeepForSdk
    public boolean d() {
        return this.f11695g.get();
    }

    @KeepForSdk
    @TargetApi(16)
    public boolean e(boolean z) {
        if (!this.f11696h.get()) {
            if (!PlatformVersion.c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f11696h.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f11695g.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f11695g.compareAndSet(true, false);
        this.f11696h.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.f11695g.compareAndSet(true, false);
        this.f11696h.set(true);
        if (zCompareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        if (i2 == 20 && this.f11695g.compareAndSet(false, true)) {
            this.f11696h.set(true);
            f(true);
        }
    }
}
