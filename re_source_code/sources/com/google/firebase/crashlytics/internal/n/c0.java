package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.d;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.t.i;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
/* JADX INFO: loaded from: classes2.dex */
class c0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final a f19017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f19018g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f19019h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d f19020i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AtomicBoolean f19021j = new AtomicBoolean(false);

    /* JADX INFO: compiled from: CrashlyticsUncaughtExceptionHandler.java */
    interface a {
        void a(i iVar, Thread thread, Throwable th);
    }

    public c0(a aVar, i iVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, d dVar) {
        this.f19017f = aVar;
        this.f19018g = iVar;
        this.f19019h = uncaughtExceptionHandler;
        this.f19020i = dVar;
    }

    private boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            h.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            h.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.f19020i.b()) {
            return true;
        }
        h.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    boolean a() {
        return this.f19021j.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.Thread$UncaughtExceptionHandler] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.google.firebase.crashlytics.h.h] */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.google.firebase.crashlytics.h.h] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Thread] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.atomic.AtomicBoolean] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ?? r0 = "Completed exception processing. Invoking default exception handler.";
        this.f19021j.set(true);
        try {
            try {
                if (b(thread, th)) {
                    this.f19017f.a(this.f19018g, thread, th);
                } else {
                    h.f().b("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e2) {
                h.f().e("An error occurred in the uncaught exception handler", e2);
            }
        } finally {
            h.f().b(r0);
            this.f19019h.uncaughtException(thread, th);
            this.f19021j.set(false);
        }
    }
}
