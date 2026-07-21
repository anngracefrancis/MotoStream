package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.v0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.n, reason: from Kotlin metadata */
/* JADX INFO: compiled from: LimitedDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0097Aø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0016J#\u0010\u001a\u001a\u00020\u00132\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u001bH\u0082\bJ\u001c\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003H\u0017J%\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00152\n\u0010\u0011\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0018\u001a\u00020\u0019H\u0096\u0001J\u0010\u0010 \u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\b\u0010!\u001a\u00020\u0013H\u0016J\u001f\u0010\"\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u00152\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130$H\u0096\u0001J\b\u0010%\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rj\u0002`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lkotlinx/coroutines/internal/LimitedDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lkotlinx/coroutines/Delay;", "dispatcher", "parallelism", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/CoroutineDispatcher;I)V", "queue", "Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "runningWorkers", "workerAllocationLock", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/SynchronizedObject;", "addAndTryDispatching", HttpUrl.FRAGMENT_ENCODE_SET, "block", "delay", HttpUrl.FRAGMENT_ENCODE_SET, "time", HttpUrl.FRAGMENT_ENCODE_SET, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "dispatchInternal", "Lkotlin/Function0;", "dispatchYield", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "limitedParallelism", "run", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "tryAllocateWorker", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LimitedDispatcher extends CoroutineDispatcher implements Runnable, Delay {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineDispatcher f25817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f25818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Delay f25819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LockFreeTaskQueue<Runnable> f25820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f25821k;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i2) {
        this.f25817g = coroutineDispatcher;
        this.f25818h = i2;
        Delay delay = coroutineDispatcher instanceof Delay ? (Delay) coroutineDispatcher : null;
        this.f25819i = delay == null ? v0.a() : delay;
        this.f25820j = new LockFreeTaskQueue<>(false);
        this.f25821k = new Object();
    }

    private final boolean T(Runnable runnable) {
        this.f25820j.a(runnable);
        return this.runningWorkers >= this.f25818h;
    }

    private final boolean W() {
        synchronized (this.f25821k) {
            if (this.runningWorkers >= this.f25818h) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void K(CoroutineContext coroutineContext, Runnable runnable) {
        if (T(runnable) || !W()) {
            return;
        }
        this.f25817g.K(this, this);
    }

    @Override // kotlinx.coroutines.Delay
    public void e(long j2, CancellableContinuation<? super kotlin.u> cancellableContinuation) {
        this.f25819i.e(j2, cancellableContinuation);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            int i2 = 0;
            while (true) {
                Runnable runnableD = this.f25820j.d();
                if (runnableD != null) {
                    try {
                        runnableD.run();
                    } catch (Throwable th) {
                        kotlinx.coroutines.l0.a(EmptyCoroutineContext.f25609f, th);
                    }
                    i2++;
                    if (i2 >= 16 && this.f25817g.N(this)) {
                        this.f25817g.K(this, this);
                        return;
                    }
                }
            }
            synchronized (this.f25821k) {
                this.runningWorkers--;
                if (this.f25820j.c() == 0) {
                    return;
                }
                this.runningWorkers++;
                kotlin.u uVar = kotlin.u.a;
            }
        }
    }
}
