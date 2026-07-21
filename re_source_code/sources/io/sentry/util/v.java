package io.sentry.util;

import io.sentry.o3;
import io.sentry.s3;
import io.sentry.t3;
import io.sentry.u0;
import io.sentry.v1;
import io.sentry.x4;

/* JADX INFO: compiled from: TracingUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    static /* synthetic */ void a(x4 x4Var, s3 s3Var, o3 o3Var) {
        u0 u0VarB = o3Var.b();
        if (u0VarB == null) {
            u0VarB = new u0(x4Var.getLogger());
            o3Var.g(u0VarB);
        }
        if (u0VarB.q()) {
            u0VarB.D(s3Var, x4Var);
            u0VarB.a();
        }
    }

    public static o3 d(final s3 s3Var, final x4 x4Var) {
        return s3Var.B(new s3.a() { // from class: io.sentry.util.f
            @Override // io.sentry.s3.a
            public final void a(o3 o3Var) {
                v.a(x4Var, s3Var, o3Var);
            }
        });
    }

    public static void e(v1 v1Var) {
        v1Var.o(new t3() { // from class: io.sentry.util.g
            @Override // io.sentry.t3
            public final void a(s3 s3Var) {
                s3Var.B(new s3.a() { // from class: io.sentry.util.e
                    @Override // io.sentry.s3.a
                    public final void a(o3 o3Var) {
                        s3Var.x(new o3());
                    }
                });
            }
        });
    }
}
