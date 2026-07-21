package io.sentry.util.thread;

import io.sentry.protocol.w;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: MainThreadChecker.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class c implements b {
    private static final long a = Thread.currentThread().getId();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f22765b = new c();

    private c() {
    }

    public static c e() {
        return f22765b;
    }

    @Override // io.sentry.util.thread.b
    public boolean a(long j2) {
        return a == j2;
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
