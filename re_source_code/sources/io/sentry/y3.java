package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SendFireAndForgetEnvelopeSender.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class y3 implements x3 {
    private final v3 a;

    public y3(v3 v3Var) {
        this.a = (v3) io.sentry.util.q.c(v3Var, "SendFireAndForgetDirPath is required");
    }

    @Override // io.sentry.x3
    public /* synthetic */ u3 a(e1 e1Var, String str, w1 w1Var) {
        return w3.b(this, e1Var, str, w1Var);
    }

    @Override // io.sentry.x3
    public u3 b(v1 v1Var, x4 x4Var) {
        io.sentry.util.q.c(v1Var, "Hub is required");
        io.sentry.util.q.c(x4Var, "SentryOptions is required");
        String strA = this.a.a();
        if (strA != null && c(strA, x4Var.getLogger())) {
            return a(new i1(v1Var, x4Var.getSerializer(), x4Var.getLogger(), x4Var.getFlushTimeoutMillis()), strA, x4Var.getLogger());
        }
        x4Var.getLogger().c(s4.ERROR, "No cache dir path is defined in options.", new Object[0]);
        return null;
    }

    @Override // io.sentry.x3
    public /* synthetic */ boolean c(String str, w1 w1Var) {
        return w3.a(this, str, w1Var);
    }
}
