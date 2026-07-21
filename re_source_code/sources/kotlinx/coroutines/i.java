package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.ContinuationInterceptor;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"runBlocking", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
public final /* synthetic */ class i {
    /* JADX WARN: Code duplicated, block: B:16:0x0036  */
    public static final <T> T a(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) throws InterruptedException {
        EventLoop eventLoopA;
        CoroutineContext coroutineContextE;
        Thread threadCurrentThread = Thread.currentThread();
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(ContinuationInterceptor.f25606b);
        if (continuationInterceptor == null) {
            eventLoopA = ThreadLocalEventLoop.a.b();
            coroutineContextE = h0.e(GlobalScope.f25874f, coroutineContext.plus(eventLoopA));
        } else {
            EventLoop eventLoop = continuationInterceptor instanceof EventLoop ? (EventLoop) continuationInterceptor : null;
            if (eventLoop == null) {
                eventLoopA = ThreadLocalEventLoop.a.a();
            } else {
                EventLoop eventLoop2 = eventLoop.q0() ? eventLoop : null;
                if (eventLoop2 == null) {
                    eventLoopA = ThreadLocalEventLoop.a.a();
                } else {
                    eventLoopA = eventLoop2;
                }
            }
            coroutineContextE = h0.e(GlobalScope.f25874f, coroutineContext);
        }
        BlockingCoroutine blockingCoroutine = new BlockingCoroutine(coroutineContextE, threadCurrentThread, eventLoopA);
        blockingCoroutine.F0(CoroutineStart.DEFAULT, blockingCoroutine, function2);
        return (T) blockingCoroutine.G0();
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i2, Object obj) throws InterruptedException {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f25609f;
        }
        return h.c(coroutineContext, function2);
    }
}
