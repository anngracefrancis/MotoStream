package io.sentry;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class ShutdownHookIntegration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Runtime f21991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Thread f21992g;

    public ShutdownHookIntegration(Runtime runtime) {
        this.f21991f = (Runtime) io.sentry.util.q.c(runtime, "Runtime is required");
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(final v1 v1Var, final x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        io.sentry.util.q.c(x4Var, "SentryOptions is required");
        if (!x4Var.isEnableShutdownHook()) {
            x4Var.getLogger().c(s4.INFO, "enableShutdownHook is disabled.", new Object[0]);
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: io.sentry.q0
            @Override // java.lang.Runnable
            public final void run() {
                v1Var.h(x4Var.getFlushTimeoutMillis());
            }
        });
        this.f21992g = thread;
        this.f21991f.addShutdownHook(thread);
        x4Var.getLogger().c(s4.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
        a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Thread thread = this.f21992g;
        if (thread != null) {
            try {
                this.f21991f.removeShutdownHook(thread);
            } catch (IllegalStateException e2) {
                String message = e2.getMessage();
                if (message == null || !message.equals("Shutdown in progress")) {
                    throw e2;
                }
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }
}
