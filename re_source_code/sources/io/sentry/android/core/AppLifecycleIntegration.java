package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLifecycleIntegration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    volatile LifecycleWatcher f22031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SentryAndroidOptions f22032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c1 f22033h;

    public AppLifecycleIntegration() {
        this(new c1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void k(v1 v1Var) {
        SentryAndroidOptions sentryAndroidOptions = this.f22032g;
        if (sentryAndroidOptions == null) {
            return;
        }
        this.f22031f = new LifecycleWatcher(v1Var, sentryAndroidOptions.getSessionTrackingIntervalMillis(), this.f22032g.isEnableAutoSessionTracking(), this.f22032g.isEnableAppLifecycleBreadcrumbs());
        try {
            ProcessLifecycleOwner.h().getLifecycle().a(this.f22031f);
            this.f22032g.getLogger().c(s4.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
            a();
        } catch (Throwable th) {
            this.f22031f = null;
            this.f22032g.getLogger().b(s4.ERROR, "AppLifecycleIntegration failed to get Lifecycle and could not be installed.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f() {
        LifecycleWatcher lifecycleWatcher = this.f22031f;
        if (lifecycleWatcher != null) {
            ProcessLifecycleOwner.h().getLifecycle().c(lifecycleWatcher);
            SentryAndroidOptions sentryAndroidOptions = this.f22032g;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(s4.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
        this.f22031f = null;
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(final v1 v1Var, x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22032g = sentryAndroidOptions;
        w1 logger = sentryAndroidOptions.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "enableSessionTracking enabled: %s", Boolean.valueOf(this.f22032g.isEnableAutoSessionTracking()));
        this.f22032g.getLogger().c(s4Var, "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.f22032g.isEnableAppLifecycleBreadcrumbs()));
        if (this.f22032g.isEnableAutoSessionTracking() || this.f22032g.isEnableAppLifecycleBreadcrumbs()) {
            try {
                Class.forName("androidx.lifecycle.DefaultLifecycleObserver");
                Class.forName("androidx.lifecycle.ProcessLifecycleOwner");
                if (io.sentry.android.core.internal.util.h.e().d()) {
                    j(v1Var);
                } else {
                    this.f22033h.b(new Runnable() { // from class: io.sentry.android.core.x
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f22275f.k(v1Var);
                        }
                    });
                }
            } catch (ClassNotFoundException e2) {
                x4Var.getLogger().b(s4.INFO, "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed", e2);
            } catch (IllegalStateException e3) {
                x4Var.getLogger().b(s4.ERROR, "AppLifecycleIntegration could not be installed", e3);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f22031f == null) {
            return;
        }
        if (io.sentry.android.core.internal.util.h.e().d()) {
            e();
        } else {
            this.f22033h.b(new Runnable() { // from class: io.sentry.android.core.w
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22267f.f();
                }
            });
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    AppLifecycleIntegration(c1 c1Var) {
        this.f22033h = c1Var;
    }
}
