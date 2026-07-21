package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"kotlinx/coroutines/JobKt__FutureKt", "kotlinx/coroutines/JobKt__JobKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class b2 {
    public static final CompletableJob a(Job job) {
        return d2.a(job);
    }

    public static final void c(CoroutineContext coroutineContext, CancellationException cancellationException) {
        d2.c(coroutineContext, cancellationException);
    }

    public static final void d(CancellableContinuation<?> cancellableContinuation, Future<?> future) {
        c2.a(cancellableContinuation, future);
    }

    public static final void e(CoroutineContext coroutineContext) {
        d2.d(coroutineContext);
    }

    public static final void f(Job job) {
        d2.e(job);
    }
}
