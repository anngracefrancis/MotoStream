package io.sentry;

import java.security.SecureRandom;

/* JADX INFO: compiled from: TracesSampler.java */
/* JADX INFO: loaded from: classes2.dex */
final class p5 {
    private static final Double a = Double.valueOf(1.0d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x4 f22546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SecureRandom f22547c;

    public p5(x4 x4Var) {
        this((x4) io.sentry.util.q.c(x4Var, "options are required"), new SecureRandom());
    }

    private boolean b(Double d2) {
        return d2.doubleValue() >= this.f22547c.nextDouble();
    }

    q5 a(r3 r3Var) {
        Double dA;
        Double dA2;
        q5 q5VarG = r3Var.a().g();
        if (q5VarG != null) {
            return q5VarG;
        }
        if (this.f22546b.getProfilesSampler() != null) {
            try {
                dA = this.f22546b.getProfilesSampler().a(r3Var);
            } catch (Throwable th) {
                this.f22546b.getLogger().b(s4.ERROR, "Error in the 'ProfilesSamplerCallback' callback.", th);
                dA = null;
            }
        } else {
            dA = null;
        }
        if (dA == null) {
            dA = this.f22546b.getProfilesSampleRate();
        }
        Boolean boolValueOf = Boolean.valueOf(dA != null && b(dA));
        if (this.f22546b.getTracesSampler() != null) {
            try {
                dA2 = this.f22546b.getTracesSampler().a(r3Var);
            } catch (Throwable th2) {
                this.f22546b.getLogger().b(s4.ERROR, "Error in the 'TracesSamplerCallback' callback.", th2);
                dA2 = null;
            }
            if (dA2 != null) {
                return new q5(Boolean.valueOf(b(dA2)), dA2, boolValueOf, dA);
            }
        }
        q5 q5VarU = r3Var.a().u();
        if (q5VarU != null) {
            return q5VarU;
        }
        Double tracesSampleRate = this.f22546b.getTracesSampleRate();
        Double d2 = Boolean.TRUE.equals(this.f22546b.getEnableTracing()) ? a : null;
        if (tracesSampleRate == null) {
            tracesSampleRate = d2;
        }
        if (tracesSampleRate != null) {
            return new q5(Boolean.valueOf(b(tracesSampleRate)), tracesSampleRate, boolValueOf, dA);
        }
        Boolean bool = Boolean.FALSE;
        return new q5(bool, null, bool, null);
    }

    p5(x4 x4Var, SecureRandom secureRandom) {
        this.f22546b = x4Var;
        this.f22547c = secureRandom;
    }
}
