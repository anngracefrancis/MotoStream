package io.sentry.hints;

import io.sentry.s4;
import io.sentry.w1;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: BlockingFlushHint.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public abstract class e implements g, i {
    private final CountDownLatch a = new CountDownLatch(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f22425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w1 f22426c;

    public e(long j2, w1 w1Var) {
        this.f22425b = j2;
        this.f22426c = w1Var;
    }

    @Override // io.sentry.hints.g
    public void b() {
        this.a.countDown();
    }

    @Override // io.sentry.hints.i
    public boolean e() {
        try {
            return this.a.await(this.f22425b, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            this.f22426c.b(s4.ERROR, "Exception while awaiting for flush in BlockingFlushHint", e2);
            return false;
        }
    }
}
