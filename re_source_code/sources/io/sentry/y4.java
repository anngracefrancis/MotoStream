package io.sentry;

/* JADX INFO: compiled from: SentryRuntimeEventProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
final class y4 implements k1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f22822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f22823g;

    public y4(String str, String str2) {
        this.f22822f = str;
        this.f22823g = str2;
    }

    private <T extends c4> T a(T t) {
        if (t.C().d() == null) {
            t.C().m(new io.sentry.protocol.s());
        }
        io.sentry.protocol.s sVarD = t.C().d();
        if (sVarD != null && sVarD.d() == null && sVarD.e() == null) {
            sVarD.f(this.f22823g);
            sVarD.h(this.f22822f);
        }
        return t;
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        return (l4) a(l4Var);
    }

    @Override // io.sentry.k1
    public io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        return (io.sentry.protocol.x) a(xVar);
    }

    public y4() {
        this(System.getProperty("java.version"), System.getProperty("java.vendor"));
    }
}
