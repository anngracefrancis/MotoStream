package io.sentry;

import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Hub.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p1 implements v1 {
    private volatile io.sentry.protocol.q a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x4 f22538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f22539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k5 f22540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final p5 f22541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Throwable, io.sentry.util.r<WeakReference<d2>, String>> f22542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u5 f22543g;

    public p1(x4 x4Var) {
        this(x4Var, d(x4Var));
    }

    private void a(l4 l4Var) {
        io.sentry.util.r<WeakReference<d2>, String> rVar;
        d2 d2Var;
        if (!this.f22538b.isTracingEnabled() || l4Var.O() == null || (rVar = this.f22542f.get(io.sentry.util.k.a(l4Var.O()))) == null) {
            return;
        }
        WeakReference<d2> weakReferenceA = rVar.a();
        if (l4Var.C().e() == null && weakReferenceA != null && (d2Var = weakReferenceA.get()) != null) {
            l4Var.C().n(d2Var.m());
        }
        String strB = rVar.b();
        if (l4Var.t0() != null || strB == null) {
            return;
        }
        l4Var.E0(strB);
    }

    private s3 b(s3 s3Var, t3 t3Var) {
        if (t3Var != null) {
            try {
                s3 s3Var2 = new s3(s3Var);
                t3Var.a(s3Var2);
                return s3Var2;
            } catch (Throwable th) {
                this.f22538b.getLogger().b(s4.ERROR, "Error in the 'ScopeCallback' callback.", th);
            }
        }
        return s3Var;
    }

    private io.sentry.protocol.q c(l4 l4Var, n1 n1Var, t3 t3Var) {
        io.sentry.protocol.q qVarB = io.sentry.protocol.q.f22645f;
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return qVarB;
        }
        if (l4Var == null) {
            this.f22538b.getLogger().c(s4.WARNING, "captureEvent called with null parameter.", new Object[0]);
            return qVarB;
        }
        try {
            a(l4Var);
            k5.a aVarA = this.f22540d.a();
            qVarB = aVarA.a().b(l4Var, b(aVarA.c(), t3Var), n1Var);
            this.a = qVarB;
            return qVarB;
        } catch (Throwable th) {
            this.f22538b.getLogger().b(s4.ERROR, "Error while capturing event with id: " + l4Var.G(), th);
            return qVarB;
        }
    }

    private static k5.a d(x4 x4Var) {
        u(x4Var);
        return new k5.a(x4Var, new d4(x4Var), new s3(x4Var));
    }

    private e2 e(r5 r5Var, t5 t5Var) {
        final e2 e2VarR;
        io.sentry.util.q.c(r5Var, "transactionContext is required");
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            e2VarR = d3.r();
        } else if (!this.f22538b.getInstrumenter().equals(r5Var.s())) {
            this.f22538b.getLogger().c(s4.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", r5Var.s(), this.f22538b.getInstrumenter());
            e2VarR = d3.r();
        } else if (this.f22538b.isTracingEnabled()) {
            q5 q5VarA = this.f22541e.a(new r3(r5Var, t5Var.e()));
            r5Var.n(q5VarA);
            b5 b5Var = new b5(r5Var, this, t5Var, this.f22543g);
            if (q5VarA.c().booleanValue() && q5VarA.a().booleanValue()) {
                this.f22538b.getTransactionProfiler().b(b5Var);
            }
            e2VarR = b5Var;
        } else {
            this.f22538b.getLogger().c(s4.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            e2VarR = d3.r();
        }
        if (t5Var.i()) {
            o(new t3() { // from class: io.sentry.h
                @Override // io.sentry.t3
                public final void a(s3 s3Var) {
                    s3Var.z(e2VarR);
                }
            });
        }
        return e2VarR;
    }

    private static void u(x4 x4Var) {
        io.sentry.util.q.c(x4Var, "SentryOptions is required.");
        if (x4Var.getDsn() == null || x4Var.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub if no DSN is available.");
        }
    }

    @Override // io.sentry.v1
    public void close() {
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (Integration integration : this.f22538b.getIntegrations()) {
                if (integration instanceof Closeable) {
                    try {
                        ((Closeable) integration).close();
                    } catch (IOException e2) {
                        this.f22538b.getLogger().c(s4.WARNING, "Failed to close the integration {}.", integration, e2);
                    }
                }
            }
            o(new t3() { // from class: io.sentry.i
                @Override // io.sentry.t3
                public final void a(s3 s3Var) {
                    s3Var.b();
                }
            });
            this.f22538b.getTransactionProfiler().close();
            this.f22538b.getTransactionPerformanceCollector().close();
            this.f22538b.getExecutorService().a(this.f22538b.getShutdownTimeoutMillis());
            this.f22540d.a().a().close();
        } catch (Throwable th) {
            this.f22538b.getLogger().b(s4.ERROR, "Error while closing the Hub.", th);
        }
        this.f22539c = false;
    }

    @Override // io.sentry.v1
    public void endSession() {
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        k5.a aVarA = this.f22540d.a();
        d5 d5VarG = aVarA.c().g();
        if (d5VarG != null) {
            aVarA.a().a(d5VarG, io.sentry.util.m.a(new io.sentry.hints.m()));
        }
    }

    @Override // io.sentry.v1
    public void h(long j2) {
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            this.f22540d.a().a().h(j2);
        } catch (Throwable th) {
            this.f22538b.getLogger().b(s4.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    @Override // io.sentry.v1
    public /* synthetic */ void i(v0 v0Var) {
        u1.a(this, v0Var);
    }

    @Override // io.sentry.v1
    public boolean isEnabled() {
        return this.f22539c;
    }

    @Override // io.sentry.v1
    @ApiStatus.Internal
    public io.sentry.protocol.q j(h4 h4Var, n1 n1Var) {
        io.sentry.util.q.c(h4Var, "SentryEnvelope is required.");
        io.sentry.protocol.q qVar = io.sentry.protocol.q.f22645f;
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return qVar;
        }
        try {
            io.sentry.protocol.q qVarJ = this.f22540d.a().a().j(h4Var, n1Var);
            return qVarJ != null ? qVarJ : qVar;
        } catch (Throwable th) {
            this.f22538b.getLogger().b(s4.ERROR, "Error while capturing envelope.", th);
            return qVar;
        }
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q k(l4 l4Var) {
        return u1.c(this, l4Var);
    }

    @Override // io.sentry.v1
    @ApiStatus.Internal
    public e2 l(r5 r5Var, t5 t5Var) {
        return e(r5Var, t5Var);
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q m(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var) {
        return u1.d(this, xVar, o5Var, n1Var);
    }

    @Override // io.sentry.v1
    public void n(v0 v0Var, n1 n1Var) {
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (v0Var == null) {
            this.f22538b.getLogger().c(s4.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            this.f22540d.a().c().a(v0Var, n1Var);
        }
    }

    @Override // io.sentry.v1
    public void o(t3 t3Var) {
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            t3Var.a(this.f22540d.a().c());
        } catch (Throwable th) {
            this.f22538b.getLogger().b(s4.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.v1
    @ApiStatus.Internal
    public void p(Throwable th, d2 d2Var, String str) {
        io.sentry.util.q.c(th, "throwable is required");
        io.sentry.util.q.c(d2Var, "span is required");
        io.sentry.util.q.c(str, "transactionName is required");
        Throwable thA = io.sentry.util.k.a(th);
        if (this.f22542f.containsKey(thA)) {
            return;
        }
        this.f22542f.put(thA, new io.sentry.util.r<>(new WeakReference(d2Var), str));
    }

    @Override // io.sentry.v1
    public x4 q() {
        return this.f22540d.a().b();
    }

    @Override // io.sentry.v1
    @ApiStatus.Internal
    public io.sentry.protocol.q r(io.sentry.protocol.x xVar, o5 o5Var, n1 n1Var, m3 m3Var) {
        io.sentry.util.q.c(xVar, "transaction is required");
        io.sentry.protocol.q qVar = io.sentry.protocol.q.f22645f;
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return qVar;
        }
        if (!xVar.p0()) {
            this.f22538b.getLogger().c(s4.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", xVar.G());
            return qVar;
        }
        if (!Boolean.TRUE.equals(Boolean.valueOf(xVar.q0()))) {
            this.f22538b.getLogger().c(s4.DEBUG, "Transaction %s was dropped due to sampling decision.", xVar.G());
            this.f22538b.getClientReportRecorder().a(io.sentry.clientreport.e.SAMPLE_RATE, z0.Transaction);
            return qVar;
        }
        try {
            k5.a aVarA = this.f22540d.a();
            return aVarA.a().c(xVar, o5Var, aVarA.c(), n1Var, m3Var);
        } catch (Throwable th) {
            this.f22538b.getLogger().b(s4.ERROR, "Error while capturing transaction with id: " + xVar.G(), th);
            return qVar;
        }
    }

    @Override // io.sentry.v1
    public /* synthetic */ io.sentry.protocol.q s(h4 h4Var) {
        return u1.b(this, h4Var);
    }

    @Override // io.sentry.v1
    public void startSession() {
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        k5.a aVarA = this.f22540d.a();
        s3.d dVarA = aVarA.c().A();
        if (dVarA == null) {
            this.f22538b.getLogger().c(s4.WARNING, "Session could not be started.", new Object[0]);
            return;
        }
        if (dVarA.b() != null) {
            aVarA.a().a(dVarA.b(), io.sentry.util.m.a(new io.sentry.hints.m()));
        }
        aVarA.a().a(dVarA.a(), io.sentry.util.m.a(new io.sentry.hints.o()));
    }

    @Override // io.sentry.v1
    public io.sentry.protocol.q t(l4 l4Var, n1 n1Var) {
        return c(l4Var, n1Var, null);
    }

    private p1(x4 x4Var, k5 k5Var) {
        this.f22542f = Collections.synchronizedMap(new WeakHashMap());
        u(x4Var);
        this.f22538b = x4Var;
        this.f22541e = new p5(x4Var);
        this.f22540d = k5Var;
        this.a = io.sentry.protocol.q.f22645f;
        this.f22543g = x4Var.getTransactionPerformanceCollector();
        this.f22539c = true;
    }

    @Override // io.sentry.v1
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v1 m371clone() {
        if (!isEnabled()) {
            this.f22538b.getLogger().c(s4.WARNING, "Disabled Hub cloned.", new Object[0]);
        }
        return new p1(this.f22538b, new k5(this.f22540d));
    }

    private p1(x4 x4Var, k5.a aVar) {
        this(x4Var, new k5(x4Var.getLogger(), aVar));
    }
}
