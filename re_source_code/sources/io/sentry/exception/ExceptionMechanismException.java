package io.sentry.exception;

import io.sentry.protocol.i;
import io.sentry.util.q;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class ExceptionMechanismException extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f22400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Throwable f22401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread f22402h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f22403i;

    public ExceptionMechanismException(i iVar, Throwable th, Thread thread, boolean z) {
        this.f22400f = (i) q.c(iVar, "Mechanism is required.");
        this.f22401g = (Throwable) q.c(th, "Throwable is required.");
        this.f22402h = (Thread) q.c(thread, "Thread is required.");
        this.f22403i = z;
    }

    public i a() {
        return this.f22400f;
    }

    public Thread b() {
        return this.f22402h;
    }

    public Throwable c() {
        return this.f22401g;
    }

    public boolean d() {
        return this.f22403i;
    }

    public ExceptionMechanismException(i iVar, Throwable th, Thread thread) {
        this(iVar, th, thread, false);
    }
}
