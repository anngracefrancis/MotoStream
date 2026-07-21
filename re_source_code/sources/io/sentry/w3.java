package io.sentry;

import java.io.File;

/* JADX INFO: compiled from: SendCachedEnvelopeFireAndForgetIntegration.java */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class w3 {
    public static boolean a(x3 _this, String str, w1 w1Var) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        w1Var.c(s4.INFO, "No cached dir path is defined in options.", new Object[0]);
        return false;
    }

    public static u3 b(x3 _this, final e1 e1Var, final String str, final w1 w1Var) {
        final File file = new File(str);
        return new u3() { // from class: io.sentry.s
            @Override // io.sentry.u3
            public final void a() {
                w3.c(w1Var, str, e1Var, file);
            }
        };
    }

    public static /* synthetic */ void c(w1 w1Var, String str, e1 e1Var, File file) {
        s4 s4Var = s4.DEBUG;
        w1Var.c(s4Var, "Started processing cached files from %s", str);
        e1Var.e(file);
        w1Var.c(s4Var, "Finished processing cached files from %s", str);
    }
}
