package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DispatchedTask.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, d2 = {"MODE_ATOMIC", HttpUrl.FRAGMENT_ENCODE_SET, "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", HttpUrl.FRAGMENT_ENCODE_SET, "(I)Z", "isReusableMode", "dispatch", HttpUrl.FRAGMENT_ENCODE_SET, "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class c1 {
    public static final <T> void a(DispatchedTask<? super T> dispatchedTask, int i2) {
        if (s0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> continuationC = dispatchedTask.c();
        boolean z = i2 == 4;
        if (z || !(continuationC instanceof DispatchedContinuation) || b(i2) != b(dispatchedTask.f25647h)) {
            d(dispatchedTask, continuationC, z);
            return;
        }
        CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) continuationC).f25797j;
        CoroutineContext l = continuationC.getL();
        if (coroutineDispatcher.N(l)) {
            coroutineDispatcher.K(l, dispatchedTask);
        } else {
            e(dispatchedTask);
        }
    }

    public static final boolean b(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean c(int i2) {
        return i2 == 2;
    }

    public static final <T> void d(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z) {
        Object objF;
        Object objJ = dispatchedTask.j();
        Throwable thD = dispatchedTask.d(objJ);
        if (thD != null) {
            Result.a aVar = Result.f25108f;
            objF = kotlin.o.a(thD);
        } else {
            Result.a aVar2 = Result.f25108f;
            objF = dispatchedTask.f(objJ);
        }
        Object objA = Result.a(objF);
        if (!z) {
            continuation.resumeWith(objA);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Continuation<T> continuation2 = dispatchedContinuation.f25798k;
        Object obj = dispatchedContinuation.m;
        CoroutineContext l = continuation2.getL();
        Object objC = kotlinx.coroutines.internal.i0.c(l, obj);
        UndispatchedCoroutine<?> undispatchedCoroutineG = objC != kotlinx.coroutines.internal.i0.a ? h0.g(continuation2, l, objC) : null;
        try {
            dispatchedContinuation.f25798k.resumeWith(objA);
            kotlin.u uVar = kotlin.u.a;
        } finally {
            if (undispatchedCoroutineG == null || undispatchedCoroutineG.H0()) {
                kotlinx.coroutines.internal.i0.a(l, objC);
            }
        }
    }

    private static final void e(DispatchedTask<?> dispatchedTask) {
        EventLoop eventLoopB = ThreadLocalEventLoop.a.b();
        if (eventLoopB.i0()) {
            eventLoopB.Z(dispatchedTask);
            return;
        }
        eventLoopB.e0(true);
        try {
            d(dispatchedTask, dispatchedTask.c(), true);
            do {
            } while (eventLoopB.p0());
        } catch (Throwable th) {
            try {
                dispatchedTask.i(th, null);
            } finally {
                eventLoopB.T(true);
            }
        }
    }
}
