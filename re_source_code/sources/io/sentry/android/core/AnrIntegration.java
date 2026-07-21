package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import io.sentry.Integration;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.i2;
import io.sentry.l4;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class AnrIntegration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static e0 f22011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object f22012g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f22013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private x4 f22014i;

    static final class a implements io.sentry.hints.b, io.sentry.hints.q {
        private final boolean a;

        a(boolean z) {
            this.a = z;
        }

        @Override // io.sentry.hints.b
        public /* synthetic */ Long c() {
            return io.sentry.hints.a.b(this);
        }

        @Override // io.sentry.hints.b
        public boolean d() {
            return true;
        }

        @Override // io.sentry.hints.b
        public String f() {
            return this.a ? "anr_background" : "anr_foreground";
        }
    }

    public AnrIntegration(Context context) {
        this.f22013h = context;
    }

    private Throwable b(boolean z, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        String str = "ANR for at least " + sentryAndroidOptions.getAnrTimeoutIntervalMillis() + " ms.";
        if (z) {
            str = "Background " + str;
        }
        ApplicationNotResponding applicationNotResponding2 = new ApplicationNotResponding(str, applicationNotResponding.a());
        io.sentry.protocol.i iVar = new io.sentry.protocol.i();
        iVar.j("ANR");
        return new ExceptionMechanismException(iVar, applicationNotResponding2, applicationNotResponding2.a(), true);
    }

    private void j(final v1 v1Var, final SentryAndroidOptions sentryAndroidOptions) {
        w1 logger = sentryAndroidOptions.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "AnrIntegration enabled: %s", Boolean.valueOf(sentryAndroidOptions.isAnrEnabled()));
        if (sentryAndroidOptions.isAnrEnabled()) {
            synchronized (f22012g) {
                if (f22011f == null) {
                    sentryAndroidOptions.getLogger().c(s4Var, "ANR timeout in milliseconds: %d", Long.valueOf(sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                    e0 e0Var = new e0(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), new e0.a() { // from class: io.sentry.android.core.v
                        @Override // io.sentry.android.core.e0.a
                        public final void a(ApplicationNotResponding applicationNotResponding) {
                            this.a.f(v1Var, sentryAndroidOptions, applicationNotResponding);
                        }
                    }, sentryAndroidOptions.getLogger(), this.f22013h);
                    f22011f = e0Var;
                    e0Var.start();
                    sentryAndroidOptions.getLogger().c(s4Var, "AnrIntegration installed.", new Object[0]);
                    a();
                }
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public final void c(v1 v1Var, x4 x4Var) {
        this.f22014i = (x4) io.sentry.util.q.c(x4Var, "SentryOptions is required");
        j(v1Var, (SentryAndroidOptions) x4Var);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (f22012g) {
            e0 e0Var = f22011f;
            if (e0Var != null) {
                e0Var.interrupt();
                f22011f = null;
                x4 x4Var = this.f22014i;
                if (x4Var != null) {
                    x4Var.getLogger().c(s4.DEBUG, "AnrIntegration removed.", new Object[0]);
                }
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void f(v1 v1Var, SentryAndroidOptions sentryAndroidOptions, ApplicationNotResponding applicationNotResponding) {
        sentryAndroidOptions.getLogger().c(s4.INFO, "ANR triggered with message: %s", applicationNotResponding.getMessage());
        boolean zEquals = Boolean.TRUE.equals(r0.a().b());
        l4 l4Var = new l4(b(zEquals, sentryAndroidOptions, applicationNotResponding));
        l4Var.z0(s4.ERROR);
        v1Var.t(l4Var, io.sentry.util.m.a(new a(zEquals)));
    }
}
