package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DiagnosticLogger.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class d1 implements w1 {
    private final x4 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final w1 f22370b;

    public d1(x4 x4Var, w1 w1Var) {
        this.a = (x4) io.sentry.util.q.c(x4Var, "SentryOptions is required.");
        this.f22370b = w1Var;
    }

    @Override // io.sentry.w1
    public void a(s4 s4Var, Throwable th, String str, Object... objArr) {
        if (this.f22370b == null || !d(s4Var)) {
            return;
        }
        this.f22370b.a(s4Var, th, str, objArr);
    }

    @Override // io.sentry.w1
    public void b(s4 s4Var, String str, Throwable th) {
        if (this.f22370b == null || !d(s4Var)) {
            return;
        }
        this.f22370b.b(s4Var, str, th);
    }

    @Override // io.sentry.w1
    public void c(s4 s4Var, String str, Object... objArr) {
        if (this.f22370b == null || !d(s4Var)) {
            return;
        }
        this.f22370b.c(s4Var, str, objArr);
    }

    @Override // io.sentry.w1
    public boolean d(s4 s4Var) {
        return s4Var != null && this.a.isDebug() && s4Var.ordinal() >= this.a.getDiagnosticLevel().ordinal();
    }
}
