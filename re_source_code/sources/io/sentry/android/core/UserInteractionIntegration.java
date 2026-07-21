package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class UserInteractionIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Application f22083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private v1 f22084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SentryAndroidOptions f22085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f22086i;

    public UserInteractionIntegration(Application application, b1 b1Var) {
        this.f22083f = (Application) io.sentry.util.q.c(application, "Application is required");
        this.f22086i = b1Var.b("androidx.core.view.GestureDetectorCompat", this.f22085h);
    }

    private void b(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.f22085h;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(s4.INFO, "Window was null in startTracking", new Object[0]);
                return;
            }
            return;
        }
        if (this.f22084g == null || this.f22085h == null) {
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback == null) {
            callback = new io.sentry.android.core.internal.gestures.f();
        }
        window.setCallback(new io.sentry.android.core.internal.gestures.h(callback, activity, new io.sentry.android.core.internal.gestures.g(activity, this.f22084g, this.f22085h), this.f22085h));
    }

    private void e(Activity activity) {
        Window window = activity.getWindow();
        if (window == null) {
            SentryAndroidOptions sentryAndroidOptions = this.f22085h;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(s4.INFO, "Window was null in stopTracking", new Object[0]);
                return;
            }
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof io.sentry.android.core.internal.gestures.h) {
            io.sentry.android.core.internal.gestures.h hVar = (io.sentry.android.core.internal.gestures.h) callback;
            hVar.c();
            if (hVar.a() instanceof io.sentry.android.core.internal.gestures.f) {
                window.setCallback(null);
            } else {
                window.setCallback(hVar.a());
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(v1 v1Var, x4 x4Var) {
        this.f22085h = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22084g = (v1) io.sentry.util.q.c(v1Var, "Hub is required");
        boolean z = this.f22085h.isEnableUserInteractionBreadcrumbs() || this.f22085h.isEnableUserInteractionTracing();
        w1 logger = this.f22085h.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "UserInteractionIntegration enabled: %s", Boolean.valueOf(z));
        if (z) {
            if (!this.f22086i) {
                x4Var.getLogger().c(s4.INFO, "androidx.core is not available, UserInteractionIntegration won't be installed", new Object[0]);
                return;
            }
            this.f22083f.registerActivityLifecycleCallbacks(this);
            this.f22085h.getLogger().c(s4Var, "UserInteractionIntegration installed.", new Object[0]);
            a();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22083f.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.f22085h;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(s4.DEBUG, "UserInteractionIntegration removed.", new Object[0]);
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        e(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
