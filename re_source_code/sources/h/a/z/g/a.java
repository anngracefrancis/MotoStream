package h.a.z.g;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AbstractDirectTask.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a extends AtomicReference<Future<?>> implements h.a.x.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static final FutureTask<Void> f21638f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected static final FutureTask<Void> f21639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final Runnable f21640h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Thread f21641i;

    static {
        Runnable runnable = h.a.z.b.a.f21452b;
        f21638f = new FutureTask<>(runnable, null);
        f21639g = new FutureTask<>(runnable, null);
    }

    a(Runnable runnable) {
        this.f21640h = runnable;
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == f21638f) {
                return;
            }
            if (future2 == f21639g) {
                future.cancel(this.f21641i != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // h.a.x.c
    public final void k() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == f21638f || future == (futureTask = f21639g) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.f21641i != Thread.currentThread());
    }

    @Override // h.a.x.c
    public final boolean q() {
        Future<?> future = get();
        return future == f21638f || future == f21639g;
    }
}
