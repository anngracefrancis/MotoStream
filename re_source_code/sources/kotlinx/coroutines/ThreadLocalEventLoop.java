package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.u2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0010R\u0014\u0010\u0003\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\u0007\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040\bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/ThreadLocalEventLoop;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "getEventLoop$kotlinx_coroutines_core", "()Lkotlinx/coroutines/EventLoop;", "ref", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "currentOrNull", "currentOrNull$kotlinx_coroutines_core", "resetEventLoop", HttpUrl.FRAGMENT_ENCODE_SET, "resetEventLoop$kotlinx_coroutines_core", "setEventLoop", "setEventLoop$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ThreadLocalEventLoop {
    public static final ThreadLocalEventLoop a = new ThreadLocalEventLoop();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<EventLoop> f25881b = new ThreadLocal<>();

    private ThreadLocalEventLoop() {
    }

    public final EventLoop a() {
        return f25881b.get();
    }

    public final EventLoop b() {
        ThreadLocal<EventLoop> threadLocal = f25881b;
        EventLoop eventLoop = threadLocal.get();
        if (eventLoop != null) {
            return eventLoop;
        }
        EventLoop eventLoopA = l1.a();
        threadLocal.set(eventLoopA);
        return eventLoopA;
    }

    public final void c() {
        f25881b.set(null);
    }

    public final void d(EventLoop eventLoop) {
        f25881b.set(eventLoop);
    }
}
