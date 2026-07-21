package kotlinx.coroutines.internal;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function1;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.UndispatchedCoroutine;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0006\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082\b\u001aU\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00152%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0012\u0010\u001d\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00100\bH\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "getREUSABLE_CLAIMED$annotations", "()V", "UNDEFINED", "getUNDEFINED$annotations", "executeUnconfined", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", HttpUrl.FRAGMENT_ENCODE_SET, "mode", HttpUrl.FRAGMENT_ENCODE_SET, "doYield", "block", "Lkotlin/Function0;", HttpUrl.FRAGMENT_ENCODE_SET, "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i {
    private static final Symbol a = new Symbol("UNDEFINED");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Symbol f25799b = new Symbol("REUSABLE_CLAIMED");

    public static final <T> void b(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, kotlin.u> function1) {
        boolean z;
        if (!(continuation instanceof DispatchedContinuation)) {
            continuation.resumeWith(obj);
            return;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
        Object objB = kotlinx.coroutines.e0.b(obj, function1);
        if (dispatchedContinuation.f25797j.N(dispatchedContinuation.getL())) {
            dispatchedContinuation.l = objB;
            dispatchedContinuation.f25647h = 1;
            dispatchedContinuation.f25797j.K(dispatchedContinuation.getL(), dispatchedContinuation);
            return;
        }
        s0.a();
        EventLoop eventLoopB = ThreadLocalEventLoop.a.b();
        if (eventLoopB.i0()) {
            dispatchedContinuation.l = objB;
            dispatchedContinuation.f25647h = 1;
            eventLoopB.Z(dispatchedContinuation);
            return;
        }
        eventLoopB.e0(true);
        try {
            Job job = (Job) dispatchedContinuation.getL().get(Job.f25890e);
            if (job == null || job.b()) {
                z = false;
            } else {
                CancellationException cancellationExceptionJ = job.j();
                dispatchedContinuation.a(objB, cancellationExceptionJ);
                Result.a aVar = Result.f25108f;
                dispatchedContinuation.resumeWith(Result.a(kotlin.o.a(cancellationExceptionJ)));
                z = true;
            }
            if (!z) {
                Continuation<T> continuation2 = dispatchedContinuation.f25798k;
                Object obj2 = dispatchedContinuation.m;
                CoroutineContext context = continuation2.getL();
                Object objC = i0.c(context, obj2);
                UndispatchedCoroutine<?> undispatchedCoroutineG = objC != i0.a ? kotlinx.coroutines.h0.g(continuation2, context, objC) : null;
                try {
                    dispatchedContinuation.f25798k.resumeWith(obj);
                    kotlin.u uVar = kotlin.u.a;
                    if (undispatchedCoroutineG == null || undispatchedCoroutineG.H0()) {
                        i0.a(context, objC);
                    }
                } catch (Throwable th) {
                    if (undispatchedCoroutineG == null || undispatchedCoroutineG.H0()) {
                        i0.a(context, objC);
                    }
                    throw th;
                }
            }
            while (eventLoopB.p0()) {
            }
        } catch (Throwable th2) {
            try {
                dispatchedContinuation.i(th2, null);
            } finally {
                eventLoopB.T(true);
            }
        }
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }
}
