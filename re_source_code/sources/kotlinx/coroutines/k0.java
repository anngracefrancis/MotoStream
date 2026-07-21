package kotlinx.coroutines;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CoroutineExceptionHandlerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"handlers", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleCoroutineExceptionImpl", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class k0 {
    private static final List<CoroutineExceptionHandler> a = kotlin.sequences.n.A(kotlin.sequences.l.a(defpackage.a.a()));

    public static final void a(CoroutineContext coroutineContext, Throwable th) {
        Iterator<CoroutineExceptionHandler> it = a.iterator();
        while (it.hasNext()) {
            try {
                it.next().handleException(coroutineContext, th);
            } catch (Throwable th2) {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, l0.b(th, th2));
            }
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        try {
            Result.a aVar = Result.f25108f;
            kotlin.b.a(th, new DiagnosticCoroutineContextException(coroutineContext));
            Result.a(kotlin.u.a);
        } catch (Throwable th3) {
            Result.a aVar2 = Result.f25108f;
            Result.a(kotlin.o.a(th3));
        }
        threadCurrentThread2.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread2, th);
    }
}
