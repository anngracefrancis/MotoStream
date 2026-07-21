package com.facebook.o0;

/* JADX INFO: compiled from: AppEventStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class z {
    public static final z a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10557b = z.class.getName();

    private z() {
    }

    public static final synchronized void a(t tVar, i0 i0Var) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
        kotlin.jvm.internal.m.f(i0Var, "appEvents");
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        com.facebook.o0.q0.g.b();
        x xVar = x.a;
        h0 h0VarA = x.a();
        h0VarA.a(tVar, i0Var.d());
        x.b(h0VarA);
    }

    public static final synchronized void b(w wVar) {
        kotlin.jvm.internal.m.f(wVar, "eventsToPersist");
        com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
        com.facebook.o0.q0.g.b();
        x xVar = x.a;
        h0 h0VarA = x.a();
        for (t tVar : wVar.f()) {
            i0 i0VarC = wVar.c(tVar);
            if (i0VarC == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            h0VarA.a(tVar, i0VarC.d());
        }
        x xVar2 = x.a;
        x.b(h0VarA);
    }
}
