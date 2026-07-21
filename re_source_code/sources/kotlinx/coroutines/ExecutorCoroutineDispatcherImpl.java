package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.p1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J.\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#*\u00020$2\n\u0010\u0010\u001a\u00060\u0011j\u0002`\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006%"}, d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcherImpl;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/Delay;", "executor", "Ljava/util/concurrent/Executor;", "(Ljava/util/concurrent/Executor;)V", "getExecutor", "()Ljava/util/concurrent/Executor;", "cancelJobOnRejection", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "Ljava/util/concurrent/RejectedExecutionException;", "close", "dispatch", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", HttpUrl.FRAGMENT_ENCODE_SET, "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "scheduleBlock", "Ljava/util/concurrent/ScheduledFuture;", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExecutorCoroutineDispatcherImpl extends ExecutorCoroutineDispatcher implements Delay {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f25865h;

    public ExecutorCoroutineDispatcherImpl(Executor executor) {
        this.f25865h = executor;
        kotlinx.coroutines.internal.e.a(getF25865h());
    }

    private final void T(CoroutineContext coroutineContext, RejectedExecutionException rejectedExecutionException) {
        b2.c(coroutineContext, n1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> Y(ScheduledExecutorService scheduledExecutorService, Runnable runnable, CoroutineContext coroutineContext, long j2) {
        try {
            return scheduledExecutorService.schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e2) {
            T(coroutineContext, e2);
            return null;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void K(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            Executor f25865h = getF25865h();
            if (c.a() != null) {
                throw null;
            }
            f25865h.execute(runnable);
        } catch (RejectedExecutionException e2) {
            if (c.a() != null) {
                throw null;
            }
            T(coroutineContext, e2);
            Dispatchers.b().K(coroutineContext, runnable);
        }
    }

    /* JADX INFO: renamed from: W, reason: from getter */
    public Executor getF25865h() {
        return this.f25865h;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor f25865h = getF25865h();
        ExecutorService executorService = f25865h instanceof ExecutorService ? (ExecutorService) f25865h : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // kotlinx.coroutines.Delay
    public void e(long j2, CancellableContinuation<? super kotlin.u> cancellableContinuation) {
        Executor f25865h = getF25865h();
        ScheduledExecutorService scheduledExecutorService = f25865h instanceof ScheduledExecutorService ? (ScheduledExecutorService) f25865h : null;
        ScheduledFuture<?> scheduledFutureY = scheduledExecutorService != null ? Y(scheduledExecutorService, new ResumeUndispatchedRunnable(this, cancellableContinuation), cancellableContinuation.getL(), j2) : null;
        if (scheduledFutureY != null) {
            b2.d(cancellableContinuation, scheduledFutureY);
        } else {
            DefaultExecutor.l.e(j2, cancellableContinuation);
        }
    }

    public boolean equals(Object other) {
        return (other instanceof ExecutorCoroutineDispatcherImpl) && ((ExecutorCoroutineDispatcherImpl) other).getF25865h() == getF25865h();
    }

    public int hashCode() {
        return System.identityHashCode(getF25865h());
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return getF25865h().toString();
    }
}
