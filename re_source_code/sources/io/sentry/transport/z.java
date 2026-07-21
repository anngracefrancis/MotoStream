package io.sentry.transport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/* JADX INFO: compiled from: ReusableCountLatch.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z {
    private final a a;

    /* JADX INFO: compiled from: ReusableCountLatch.java */
    private static final class a extends AbstractQueuedSynchronizer {
        a(int i2) {
            setState(i2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            releaseShared(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int e() {
            return getState();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            int state;
            do {
                state = getState();
            } while (!compareAndSetState(state, state + 1));
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public int tryAcquireShared(int i2) {
            return getState() == 0 ? 1 : -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        public boolean tryReleaseShared(int i2) {
            int state;
            int i3;
            do {
                state = getState();
                if (state == 0) {
                    return false;
                }
                i3 = state - 1;
            } while (!compareAndSetState(state, i3));
            return i3 == 0;
        }
    }

    public z(int i2) {
        if (i2 >= 0) {
            this.a = new a(i2);
            return;
        }
        throw new IllegalArgumentException("negative initial count '" + i2 + "' is not allowed");
    }

    public void a() {
        this.a.d();
    }

    public int b() {
        return this.a.e();
    }

    public void c() {
        this.a.f();
    }

    public boolean d(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.a.tryAcquireSharedNanos(1, timeUnit.toNanos(j2));
    }

    public z() {
        this(0);
    }
}
