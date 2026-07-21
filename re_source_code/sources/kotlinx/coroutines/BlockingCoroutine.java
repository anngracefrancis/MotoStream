package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.f, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u000b\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/BlockingCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "blockedThread", "Ljava/lang/Thread;", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Thread;Lkotlinx/coroutines/EventLoop;)V", "isScopedCoroutine", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "afterCompletion", HttpUrl.FRAGMENT_ENCODE_SET, "state", HttpUrl.FRAGMENT_ENCODE_SET, "joinBlocking", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class BlockingCoroutine<T> extends AbstractCoroutine<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread f25744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final EventLoop f25745i;

    public BlockingCoroutine(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f25744h = thread;
        this.f25745i = eventLoop;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final T G0() throws Throwable {
        if (c.a() != null) {
            throw null;
        }
        try {
            EventLoop eventLoop = this.f25745i;
            if (eventLoop != null) {
                EventLoop.f0(eventLoop, false, 1, null);
            }
            while (!Thread.interrupted()) {
                try {
                    EventLoop eventLoop2 = this.f25745i;
                    long jN0 = eventLoop2 != null ? eventLoop2.n0() : Long.MAX_VALUE;
                    if (b0()) {
                        EventLoop eventLoop3 = this.f25745i;
                        if (eventLoop3 != null) {
                            EventLoop.W(eventLoop3, false, 1, null);
                        }
                        if (c.a() != null) {
                            throw null;
                        }
                        T t = (T) g2.h(X());
                        CompletedExceptionally completedExceptionally = t instanceof CompletedExceptionally ? (CompletedExceptionally) t : null;
                        if (completedExceptionally == null) {
                            return t;
                        }
                        throw completedExceptionally.f25646b;
                    }
                    if (c.a() != null) {
                        throw null;
                    }
                    LockSupport.parkNanos(this, jN0);
                } catch (Throwable th) {
                    EventLoop eventLoop4 = this.f25745i;
                    if (eventLoop4 != null) {
                        EventLoop.W(eventLoop4, false, 1, null);
                    }
                    throw th;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            y(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            if (c.a() != null) {
                throw null;
            }
            throw th2;
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    protected boolean c0() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void v(Object obj) {
        if (kotlin.jvm.internal.m.a(Thread.currentThread(), this.f25744h)) {
            return;
        }
        Thread thread = this.f25744h;
        if (c.a() != null) {
            throw null;
        }
        LockSupport.unpark(thread);
    }
}
