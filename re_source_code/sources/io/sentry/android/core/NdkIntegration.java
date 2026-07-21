package io.sentry.android.core;

import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class NdkIntegration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f22047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SentryAndroidOptions f22048g;

    public NdkIntegration(Class<?> cls) {
        this.f22047f = cls;
    }

    private void b(x4 x4Var) {
        x4Var.setEnableNdk(false);
        x4Var.setEnableScopeSync(false);
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public final void c(v1 v1Var, x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22048g = sentryAndroidOptions;
        boolean zIsEnableNdk = sentryAndroidOptions.isEnableNdk();
        w1 logger = this.f22048g.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "NdkIntegration enabled: %s", Boolean.valueOf(zIsEnableNdk));
        if (!zIsEnableNdk || this.f22047f == null) {
            b(this.f22048g);
            return;
        }
        if (this.f22048g.getCacheDirPath() == null) {
            this.f22048g.getLogger().c(s4.ERROR, "No cache dir path is defined in options.", new Object[0]);
            b(this.f22048g);
            return;
        }
        try {
            this.f22047f.getMethod("init", SentryAndroidOptions.class).invoke(null, this.f22048g);
            this.f22048g.getLogger().c(s4Var, "NdkIntegration installed.", new Object[0]);
            a();
        } catch (NoSuchMethodException e2) {
            b(this.f22048g);
            this.f22048g.getLogger().b(s4.ERROR, "Failed to invoke the SentryNdk.init method.", e2);
        } catch (Throwable th) {
            b(this.f22048g);
            this.f22048g.getLogger().b(s4.ERROR, "Failed to initialize SentryNdk.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SentryAndroidOptions sentryAndroidOptions = this.f22048g;
        if (sentryAndroidOptions == null || !sentryAndroidOptions.isEnableNdk()) {
            return;
        }
        Class<?> cls = this.f22047f;
        try {
            if (cls != null) {
                try {
                    try {
                        cls.getMethod("close", new Class[0]).invoke(null, new Object[0]);
                        this.f22048g.getLogger().c(s4.DEBUG, "NdkIntegration removed.", new Object[0]);
                    } catch (NoSuchMethodException e2) {
                        this.f22048g.getLogger().b(s4.ERROR, "Failed to invoke the SentryNdk.close method.", e2);
                    }
                } catch (Throwable th) {
                    this.f22048g.getLogger().b(s4.ERROR, "Failed to close SentryNdk.", th);
                }
            }
        } finally {
            b(this.f22048g);
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }
}
