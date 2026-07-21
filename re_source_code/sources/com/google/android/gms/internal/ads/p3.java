package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class p3 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Thread.UncaughtExceptionHandler f13143f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzaqx f13144g;

    p3(zzaqx zzaqxVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f13144g = zzaqxVar;
        this.f13143f = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.f13144g.d(thread, th);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f13143f;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } finally {
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f13143f;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        } catch (Throwable unused) {
            zzbad.g("AdMob exception reporter failed reporting the exception.");
        }
    }
}
