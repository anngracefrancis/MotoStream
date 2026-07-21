package io.sentry.android.core;

import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.j3;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class EnvelopeFileObserverIntegration implements Integration, Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private y0 f22036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private w1 f22037g;

    private static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration {
        private OutboxEnvelopeFileObserverIntegration() {
        }

        @Override // io.sentry.android.core.EnvelopeFileObserverIntegration
        protected String e(x4 x4Var) {
            return x4Var.getOutboxPath();
        }
    }

    public static EnvelopeFileObserverIntegration b() {
        return new OutboxEnvelopeFileObserverIntegration();
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public final void c(v1 v1Var, x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        io.sentry.util.q.c(x4Var, "SentryOptions is required");
        this.f22037g = x4Var.getLogger();
        String strE = e(x4Var);
        if (strE == null) {
            this.f22037g.c(s4.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
            return;
        }
        w1 w1Var = this.f22037g;
        s4 s4Var = s4.DEBUG;
        w1Var.c(s4Var, "Registering EnvelopeFileObserverIntegration for path: %s", strE);
        y0 y0Var = new y0(strE, new j3(v1Var, x4Var.getEnvelopeReader(), x4Var.getSerializer(), this.f22037g, x4Var.getFlushTimeoutMillis()), this.f22037g, x4Var.getFlushTimeoutMillis());
        this.f22036f = y0Var;
        try {
            y0Var.startWatching();
            this.f22037g.c(s4Var, "EnvelopeFileObserverIntegration installed.", new Object[0]);
        } catch (Throwable th) {
            x4Var.getLogger().b(s4.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", th);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        y0 y0Var = this.f22036f;
        if (y0Var != null) {
            y0Var.stopWatching();
            w1 w1Var = this.f22037g;
            if (w1Var != null) {
                w1Var.c(s4.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    abstract String e(x4 x4Var);
}
