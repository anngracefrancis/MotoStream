package io.sentry.util.thread;

import io.sentry.protocol.w;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: NoOpMainThreadChecker.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class d implements b {
    private static final d a = new d();

    public static d e() {
        return a;
    }

    @Override // io.sentry.util.thread.b
    public boolean a(long j2) {
        return false;
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean b(w wVar) {
        return a.b(this, wVar);
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean c(Thread thread) {
        return a.c(this, thread);
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean d() {
        return a.a(this);
    }
}
