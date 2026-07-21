package io.sentry.android.core.internal.util;

import android.os.Looper;
import io.sentry.protocol.w;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidMainThreadChecker.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class h implements io.sentry.util.thread.b {
    private static final h a = new h();

    private h() {
    }

    public static h e() {
        return a;
    }

    @Override // io.sentry.util.thread.b
    public boolean a(long j2) {
        return Looper.getMainLooper().getThread().getId() == j2;
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean b(w wVar) {
        return io.sentry.util.thread.a.b(this, wVar);
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean c(Thread thread) {
        return io.sentry.util.thread.a.c(this, thread);
    }

    @Override // io.sentry.util.thread.b
    public /* synthetic */ boolean d() {
        return io.sentry.util.thread.a.a(this);
    }
}
