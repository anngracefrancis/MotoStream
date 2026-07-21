package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.p003y.Continuation;
import kotlin.p003y.ContinuationInterceptor;
import kotlin.p003y.CoroutineContext;
import kotlinx.coroutines.internal.ScopeCoroutine;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.w2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0014J\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bR\"\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/UndispatchedCoroutine;", "T", "Lkotlinx/coroutines/internal/ScopeCoroutine;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "threadStateToRecover", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", HttpUrl.FRAGMENT_ENCODE_SET, "afterResume", HttpUrl.FRAGMENT_ENCODE_SET, "state", "clearThreadContext", HttpUrl.FRAGMENT_ENCODE_SET, "saveThreadContext", "oldValue", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UndispatchedCoroutine<T> extends ScopeCoroutine<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ThreadLocal<Pair<CoroutineContext, Object>> f25887i;

    /* JADX WARN: Illegal instructions before constructor call */
    public UndispatchedCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        UndispatchedMarker undispatchedMarker = UndispatchedMarker.f25889f;
        super(coroutineContext.get(undispatchedMarker) == null ? coroutineContext.plus(undispatchedMarker) : coroutineContext, continuation);
        this.f25887i = new ThreadLocal<>();
        if (continuation.getL().get(ContinuationInterceptor.f25606b) instanceof CoroutineDispatcher) {
            return;
        }
        Object objC = kotlinx.coroutines.internal.i0.c(coroutineContext, null);
        kotlinx.coroutines.internal.i0.a(coroutineContext, objC);
        I0(coroutineContext, objC);
    }

    @Override // kotlinx.coroutines.internal.ScopeCoroutine, kotlinx.coroutines.AbstractCoroutine
    protected void C0(Object obj) {
        Pair<CoroutineContext, Object> pair = this.f25887i.get();
        if (pair != null) {
            kotlinx.coroutines.internal.i0.a(pair.a(), pair.b());
            this.f25887i.set(null);
        }
        Object objA = e0.a(obj, this.f25792h);
        Continuation<T> continuation = this.f25792h;
        CoroutineContext l = continuation.getL();
        Object objC = kotlinx.coroutines.internal.i0.c(l, null);
        UndispatchedCoroutine<?> undispatchedCoroutineG = objC != kotlinx.coroutines.internal.i0.a ? h0.g(continuation, l, objC) : null;
        try {
            this.f25792h.resumeWith(objA);
            kotlin.u uVar = kotlin.u.a;
        } finally {
            if (undispatchedCoroutineG == null || undispatchedCoroutineG.H0()) {
                kotlinx.coroutines.internal.i0.a(l, objC);
            }
        }
    }

    public final boolean H0() {
        if (this.f25887i.get() == null) {
            return false;
        }
        this.f25887i.set(null);
        return true;
    }

    public final void I0(CoroutineContext coroutineContext, Object obj) {
        this.f25887i.set(kotlin.s.a(coroutineContext, obj));
    }
}
