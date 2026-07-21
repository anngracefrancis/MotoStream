package io.sentry.android.core;

/* JADX INFO: loaded from: classes2.dex */
final class ApplicationNotResponding extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Thread f22034f;

    ApplicationNotResponding(String str, Thread thread) {
        super(str);
        Thread thread2 = (Thread) io.sentry.util.q.c(thread, "Thread must be provided.");
        this.f22034f = thread2;
        setStackTrace(thread2.getStackTrace());
    }

    public Thread a() {
        return this.f22034f;
    }
}
