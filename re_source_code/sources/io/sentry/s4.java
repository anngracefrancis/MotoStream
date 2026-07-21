package io.sentry;

import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: SentryLevel.java */
/* JADX INFO: loaded from: classes2.dex */
public enum s4 implements r2 {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
    FATAL;

    /* JADX INFO: compiled from: SentryLevel.java */
    static final class a implements l2<s4> {
        a() {
        }

        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s4 a(n2 n2Var, w1 w1Var) throws Exception {
            return s4.valueOf(n2Var.J().toUpperCase(Locale.ROOT));
        }
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.b(name().toLowerCase(Locale.ROOT));
    }
}
