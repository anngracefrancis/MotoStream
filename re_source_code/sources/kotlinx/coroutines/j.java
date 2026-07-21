package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.ContinuationInterceptor;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001aU\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086@ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001a[\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0010\"\u0004\b\u0000\u0010\u0005*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001aF\u0010\u0014\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00152)\b\b\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0086Jø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001aO\u0010\u0017\u001a\u00020\u0018*\u00020\n2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00122'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"RESUMED", HttpUrl.FRAGMENT_ENCODE_SET, "SUSPENDED", "UNDECIDED", "withContext", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "async", "Lkotlinx/coroutines/Deferred;", "start", "Lkotlinx/coroutines/CoroutineStart;", "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Deferred;", "invoke", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "launch", "Lkotlinx/coroutines/Job;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/Job;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/BuildersKt")
public final /* synthetic */ class j {
    public static final Job a(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super CoroutineScope, ? super Continuation<? super kotlin.u>, ? extends Object> function2) {
        CoroutineContext coroutineContextE = h0.e(coroutineScope, coroutineContext);
        AbstractCoroutine lazyStandaloneCoroutine = coroutineStart.q() ? new LazyStandaloneCoroutine(coroutineContextE, function2) : new StandaloneCoroutine(coroutineContextE, true);
        lazyStandaloneCoroutine.F0(coroutineStart, lazyStandaloneCoroutine, function2);
        return lazyStandaloneCoroutine;
    }

    public static /* synthetic */ Job b(CoroutineScope coroutineScope, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f25609f;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        return h.a(coroutineScope, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Object c(CoroutineContext coroutineContext, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        Object objH0;
        CoroutineContext context = continuation.getL();
        CoroutineContext coroutineContextD = h0.d(context, coroutineContext);
        b2.e(coroutineContextD);
        if (coroutineContextD == context) {
            ScopeCoroutine scopeCoroutine = new ScopeCoroutine(coroutineContextD, continuation);
            objH0 = kotlinx.coroutines.a3.b.b(scopeCoroutine, scopeCoroutine, function2);
        } else {
            ContinuationInterceptor.b bVar = ContinuationInterceptor.f25606b;
            if (kotlin.jvm.internal.m.a(coroutineContextD.get(bVar), context.get(bVar))) {
                UndispatchedCoroutine undispatchedCoroutine = new UndispatchedCoroutine(coroutineContextD, continuation);
                Object objC = kotlinx.coroutines.internal.i0.c(coroutineContextD, null);
                try {
                    Object objB = kotlinx.coroutines.a3.b.b(undispatchedCoroutine, undispatchedCoroutine, function2);
                    kotlinx.coroutines.internal.i0.a(coroutineContextD, objC);
                    objH0 = objB;
                } catch (Throwable th) {
                    kotlinx.coroutines.internal.i0.a(coroutineContextD, objC);
                    throw th;
                }
            } else {
                DispatchedCoroutine dispatchedCoroutine = new DispatchedCoroutine(coroutineContextD, continuation);
                kotlinx.coroutines.a3.a.d(function2, dispatchedCoroutine, dispatchedCoroutine, null, 4, null);
                objH0 = dispatchedCoroutine.H0();
            }
        }
        if (objH0 == kotlin.p003y.intrinsics.d.c()) {
            kotlin.p003y.j.p004a.h.c(continuation);
        }
        return objH0;
    }
}
