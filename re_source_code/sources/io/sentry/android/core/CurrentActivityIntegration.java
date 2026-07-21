package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.v1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class CurrentActivityIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Application f22035f;

    public CurrentActivityIntegration(Application application) {
        this.f22035f = (Application) io.sentry.util.q.c(application, "Application is required");
    }

    private void b(Activity activity) {
        if (u0.c().b() == activity) {
            u0.c().a();
        }
    }

    private void e(Activity activity) {
        u0.c().d(activity);
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(v1 v1Var, x4 x4Var) {
        this.f22035f.registerActivityLifecycleCallbacks(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22035f.unregisterActivityLifecycleCallbacks(this);
        u0.c().a();
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        e(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        e(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        e(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        b(activity);
    }
}
