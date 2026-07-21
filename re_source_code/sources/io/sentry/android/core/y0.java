package io.sentry.android.core;

import android.os.FileObserver;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.t1;
import io.sentry.w1;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: EnvelopeFileObserver.java */
/* JADX INFO: loaded from: classes2.dex */
final class y0 extends FileObserver {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final t1 f22280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w1 f22281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f22282d;

    /* JADX INFO: compiled from: EnvelopeFileObserver.java */
    private static final class a implements io.sentry.hints.f, io.sentry.hints.k, io.sentry.hints.p, io.sentry.hints.i, io.sentry.hints.c, io.sentry.hints.j {
        boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f22283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CountDownLatch f22284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f22285d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final w1 f22286e;

        public a(long j2, w1 w1Var) {
            a();
            this.f22285d = j2;
            this.f22286e = (w1) io.sentry.util.q.c(w1Var, "ILogger is required.");
        }

        @Override // io.sentry.hints.j
        public void a() {
            this.f22284c = new CountDownLatch(1);
            this.a = false;
            this.f22283b = false;
        }

        @Override // io.sentry.hints.k
        public boolean b() {
            return this.a;
        }

        @Override // io.sentry.hints.p
        public void c(boolean z) {
            this.f22283b = z;
            this.f22284c.countDown();
        }

        @Override // io.sentry.hints.k
        public void d(boolean z) {
            this.a = z;
        }

        @Override // io.sentry.hints.i
        public boolean e() {
            try {
                return this.f22284c.await(this.f22285d, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
                this.f22286e.b(s4.ERROR, "Exception while awaiting on lock.", e2);
                return false;
            }
        }

        @Override // io.sentry.hints.p
        public boolean f() {
            return this.f22283b;
        }
    }

    y0(String str, t1 t1Var, w1 w1Var, long j2) {
        super(str);
        this.a = str;
        this.f22280b = (t1) io.sentry.util.q.c(t1Var, "Envelope sender is required.");
        this.f22281c = (w1) io.sentry.util.q.c(w1Var, "Logger is required.");
        this.f22282d = j2;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        if (str == null || i2 != 8) {
            return;
        }
        this.f22281c.c(s4.DEBUG, "onEvent fired for EnvelopeFileObserver with event type %d on path: %s for file %s.", Integer.valueOf(i2), this.a, str);
        n1 n1VarA = io.sentry.util.m.a(new a(this.f22282d, this.f22281c));
        this.f22280b.a(this.a + File.separator + str, n1VarA);
    }
}
