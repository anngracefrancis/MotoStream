package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryAutoDateProvider.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class b4 implements g4 {
    private final g4 a;

    public b4() {
        if (b()) {
            this.a = new p4();
        } else {
            this.a = new w4();
        }
    }

    private static boolean b() {
        return io.sentry.util.s.b() && io.sentry.util.s.a();
    }

    @Override // io.sentry.g4
    public f4 a() {
        return this.a.a();
    }
}
