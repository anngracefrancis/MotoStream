package io.sentry.android.core;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class AppComponentsBreadcrumbsIntegration implements Integration, Closeable, ComponentCallbacks2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f22028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private v1 f22029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SentryAndroidOptions f22030h;

    public AppComponentsBreadcrumbsIntegration(Context context) {
        this.f22028f = (Context) io.sentry.util.q.c(context, "Context is required");
    }

    private void b(Integer num) {
        if (this.f22029g != null) {
            io.sentry.v0 v0Var = new io.sentry.v0();
            if (num != null) {
                if (num.intValue() < 40) {
                    return;
                } else {
                    v0Var.m("level", num);
                }
            }
            v0Var.p("system");
            v0Var.l("device.event");
            v0Var.o("Low memory");
            v0Var.m("action", "LOW_MEMORY");
            v0Var.n(s4.WARNING);
            this.f22029g.i(v0Var);
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(v1 v1Var, x4 x4Var) {
        this.f22029g = (v1) io.sentry.util.q.c(v1Var, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22030h = sentryAndroidOptions;
        w1 logger = sentryAndroidOptions.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "AppComponentsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f22030h.isEnableAppComponentBreadcrumbs()));
        if (this.f22030h.isEnableAppComponentBreadcrumbs()) {
            try {
                this.f22028f.registerComponentCallbacks(this);
                x4Var.getLogger().c(s4Var, "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
                a();
            } catch (Throwable th) {
                this.f22030h.setEnableAppComponentBreadcrumbs(false);
                x4Var.getLogger().a(s4.INFO, th, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.f22028f.unregisterComponentCallbacks(this);
        } catch (Throwable th) {
            SentryAndroidOptions sentryAndroidOptions = this.f22030h;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().a(s4.DEBUG, th, "It was not possible to unregisterComponentCallbacks", new Object[0]);
            }
        }
        SentryAndroidOptions sentryAndroidOptions2 = this.f22030h;
        if (sentryAndroidOptions2 != null) {
            sentryAndroidOptions2.getLogger().c(s4.DEBUG, "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (this.f22029g != null) {
            io.sentry.protocol.e.b bVarA = io.sentry.android.core.internal.util.o.a(this.f22028f.getResources().getConfiguration().orientation);
            String lowerCase = bVarA != null ? bVarA.name().toLowerCase(Locale.ROOT) : "undefined";
            io.sentry.v0 v0Var = new io.sentry.v0();
            v0Var.p("navigation");
            v0Var.l("device.orientation");
            v0Var.m("position", lowerCase);
            v0Var.n(s4.INFO);
            n1 n1Var = new n1();
            n1Var.j("android:configuration", configuration);
            this.f22029g.n(v0Var, n1Var);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b(null);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        b(Integer.valueOf(i2));
    }
}
