package io.sentry;

import io.sentry.exception.ExceptionMechanismException;
import java.io.Closeable;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
public final class UncaughtExceptionHandlerIntegration implements Integration, Thread.UncaughtExceptionHandler, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f21993f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private v1 f21994g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private x4 f21995h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f21996i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final v5 f21997j;

    @ApiStatus.Internal
    public static class a extends io.sentry.hints.e implements io.sentry.hints.l {
        public a(long j2, w1 w1Var) {
            super(j2, w1Var);
        }
    }

    public UncaughtExceptionHandlerIntegration() {
        this(v5.a.c());
    }

    static Throwable b(Thread thread, Throwable th) {
        io.sentry.protocol.i iVar = new io.sentry.protocol.i();
        iVar.i(Boolean.FALSE);
        iVar.j("UncaughtExceptionHandler");
        return new ExceptionMechanismException(iVar, th, thread);
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public final void c(v1 v1Var, x4 x4Var) {
        if (this.f21996i) {
            x4Var.getLogger().c(s4.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.f21996i = true;
        this.f21994g = (v1) io.sentry.util.q.c(v1Var, "Hub is required");
        x4 x4Var2 = (x4) io.sentry.util.q.c(x4Var, "SentryOptions is required");
        this.f21995h = x4Var2;
        w1 logger = x4Var2.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "UncaughtExceptionHandlerIntegration enabled: %s", Boolean.valueOf(this.f21995h.isEnableUncaughtExceptionHandler()));
        if (this.f21995h.isEnableUncaughtExceptionHandler()) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandlerB = this.f21997j.b();
            if (uncaughtExceptionHandlerB != null) {
                this.f21995h.getLogger().c(s4Var, "default UncaughtExceptionHandler class='" + uncaughtExceptionHandlerB.getClass().getName() + "'", new Object[0]);
                this.f21993f = uncaughtExceptionHandlerB;
            }
            this.f21997j.a(this);
            this.f21995h.getLogger().c(s4Var, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
            a();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this == this.f21997j.b()) {
            this.f21997j.a(this.f21993f);
            x4 x4Var = this.f21995h;
            if (x4Var != null) {
                x4Var.getLogger().c(s4.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        x4 x4Var = this.f21995h;
        if (x4Var == null || this.f21994g == null) {
            return;
        }
        x4Var.getLogger().c(s4.INFO, "Uncaught exception received.", new Object[0]);
        try {
            a aVar = new a(this.f21995h.getFlushTimeoutMillis(), this.f21995h.getLogger());
            l4 l4Var = new l4(b(thread, th));
            l4Var.z0(s4.FATAL);
            n1 n1VarA = io.sentry.util.m.a(aVar);
            boolean zEquals = this.f21994g.t(l4Var, n1VarA).equals(io.sentry.protocol.q.f22645f);
            io.sentry.hints.h hVarB = io.sentry.util.m.b(n1VarA);
            if ((!zEquals || io.sentry.hints.h.MULTITHREADED_DEDUPLICATION.equals(hVarB)) && !aVar.e()) {
                this.f21995h.getLogger().c(s4.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", l4Var.G());
            }
        } catch (Throwable th2) {
            this.f21995h.getLogger().b(s4.ERROR, "Error sending uncaught exception to Sentry.", th2);
        }
        if (this.f21993f != null) {
            this.f21995h.getLogger().c(s4.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
            this.f21993f.uncaughtException(thread, th);
        } else if (this.f21995h.isPrintUncaughtStackTrace()) {
            th.printStackTrace();
        }
    }

    UncaughtExceptionHandlerIntegration(v5 v5Var) {
        this.f21996i = false;
        this.f21997j = (v5) io.sentry.util.q.c(v5Var, "threadAdapter is required.");
    }
}
