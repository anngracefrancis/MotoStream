package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.u0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\u0014\u0010 \u001a\u00020\u001e2\n\u0010!\u001a\u00060\u0002j\u0002`\u0003H\u0016J\r\u0010\"\u001a\u00020\u001eH\u0000¢\u0006\u0002\b#J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\b2\n\u0010'\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0015H\u0002J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\b2\u0006\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u001eH\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0002J\u000e\u00102\u001a\u00020\u001e2\u0006\u00103\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0004R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Lkotlinx/coroutines/DefaultExecutor;", "Lkotlinx/coroutines/EventLoopImplBase;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "()V", "ACTIVE", HttpUrl.FRAGMENT_ENCODE_SET, "DEFAULT_KEEP_ALIVE_MS", HttpUrl.FRAGMENT_ENCODE_SET, "FRESH", "KEEP_ALIVE_NANOS", "SHUTDOWN", "SHUTDOWN_ACK", "SHUTDOWN_REQ", "THREAD_NAME", HttpUrl.FRAGMENT_ENCODE_SET, "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "debugStatus", "isShutDown", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "isShutdownRequested", "isThreadPresent", "isThreadPresent$kotlinx_coroutines_core", "thread", "getThread", "()Ljava/lang/Thread;", "acknowledgeShutdownIfNeeded", HttpUrl.FRAGMENT_ENCODE_SET, "createThreadSync", "enqueue", "task", "ensureStarted", "ensureStarted$kotlinx_coroutines_core", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "block", "context", "Lkotlin/coroutines/CoroutineContext;", "notifyStartup", "reschedule", "now", "delayedTask", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "run", "shutdown", "shutdownError", "shutdownForTests", "timeout", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultExecutor extends EventLoopImplBase implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final DefaultExecutor l;
    private static final long m;

    static {
        Long l2;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        l = defaultExecutor;
        EventLoop.f0(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l2 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l2 = 1000L;
        }
        m = timeUnit.toNanos(l2.longValue());
    }

    private DefaultExecutor() {
    }

    private final synchronized void a1() {
        if (h1()) {
            debugStatus = 3;
            R0();
            notifyAll();
        }
    }

    private final synchronized Thread c1() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean f1() {
        return debugStatus == 4;
    }

    private final boolean h1() {
        int i2 = debugStatus;
        return i2 == 2 || i2 == 3;
    }

    private final synchronized boolean k1() {
        if (h1()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    private final void l1() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // kotlinx.coroutines.EventLoopImplBase
    public void J0(Runnable runnable) {
        if (f1()) {
            l1();
        }
        super.J0(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        ThreadLocalEventLoop.a.d(this);
        if (c.a() != null) {
            throw null;
        }
        try {
            if (!k1()) {
                _thread = null;
                a1();
                if (c.a() != null) {
                    throw null;
                }
                if (N0()) {
                    return;
                }
                getL();
                return;
            }
            long j2 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jN0 = n0();
                if (jN0 != Long.MAX_VALUE) {
                    j2 = Long.MAX_VALUE;
                } else {
                    if (c.a() != null) {
                        throw null;
                    }
                    long jNanoTime = System.nanoTime();
                    if (j2 == Long.MAX_VALUE) {
                        j2 = m + jNanoTime;
                    }
                    long j3 = j2 - jNanoTime;
                    if (j3 <= 0) {
                        _thread = null;
                        a1();
                        if (c.a() != null) {
                            throw null;
                        }
                        if (N0()) {
                            return;
                        }
                        getL();
                        return;
                    }
                    jN0 = kotlin.ranges.l.e(jN0, j3);
                }
                if (jN0 > 0) {
                    if (h1()) {
                        _thread = null;
                        a1();
                        if (c.a() != null) {
                            throw null;
                        }
                        if (N0()) {
                            return;
                        }
                        getL();
                        return;
                    }
                    if (c.a() != null) {
                        throw null;
                    }
                    LockSupport.parkNanos(this, jN0);
                }
            }
        } catch (Throwable th) {
            _thread = null;
            a1();
            if (c.a() != null) {
                throw null;
            }
            if (!N0()) {
                getL();
            }
            throw th;
        }
    }

    @Override // kotlinx.coroutines.EventLoopImplBase, kotlinx.coroutines.EventLoop
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    /* JADX INFO: renamed from: t0 */
    protected Thread getL() {
        Thread thread = _thread;
        return thread == null ? c1() : thread;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    protected void x0(long j2, EventLoopImplBase.b bVar) {
        l1();
    }
}
