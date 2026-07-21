package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.CoroutineStackFrame;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletedWithCancellation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.t0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.h, reason: from Kotlin metadata */
/* JADX INFO: compiled from: DispatchedContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000O2\u00060?j\u0002`@2\b\u0012\u0004\u0012\u00028\u00000\u0004B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0011\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\n\u0018\u00010\u001bj\u0004\u0018\u0001`\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\nJH\u0010+\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%2%\b\b\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\b\u0018\u00010'H\u0086\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001a\u0010.\u001a\u00020\u001f2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0086\b¢\u0006\u0004\b.\u0010/J!\u00100\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0086\bø\u0001\u0000¢\u0006\u0004\b0\u00101J \u00102\u001a\u00020\b2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016ø\u0001\u0000¢\u0006\u0004\b2\u00101J\u0011\u00105\u001a\u0004\u0018\u00010\u000bH\u0010¢\u0006\u0004\b3\u00104J\u000f\u00107\u001a\u000206H\u0016¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u0004\u0018\u00010\r2\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u000309¢\u0006\u0004\b:\u0010;R\u001e\u0010<\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b<\u0010=\u0012\u0004\b>\u0010\nR\u001c\u0010C\u001a\n\u0018\u00010?j\u0004\u0018\u0001`@8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010\u0016\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010FR\u0014\u0010G\u001a\u00020\u000b8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\bG\u0010=R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010KR\u001a\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006N"}, d2 = {"Lkotlinx/coroutines/internal/DispatchedContinuation;", "T", "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Lkotlin/coroutines/Continuation;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlin/coroutines/Continuation;)V", HttpUrl.FRAGMENT_ENCODE_SET, "awaitReusability", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "takenState", HttpUrl.FRAGMENT_ENCODE_SET, "cause", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "Lkotlinx/coroutines/CancellableContinuationImpl;", "claimReusableCancellableContinuation", "()Lkotlinx/coroutines/CancellableContinuationImpl;", "Lkotlin/coroutines/CoroutineContext;", "context", "value", "dispatchYield$kotlinx_coroutines_core", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "dispatchYield", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", HttpUrl.FRAGMENT_ENCODE_SET, "isReusable", "()Z", "postponeCancellation", "(Ljava/lang/Throwable;)Z", "release", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onCancellation", "resumeCancellableWith", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "state", "resumeCancelled", "(Ljava/lang/Object;)Z", "resumeUndispatchedWith", "(Ljava/lang/Object;)V", "resumeWith", "takeState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "takeState", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/CancellableContinuation;", "tryReleaseClaimedContinuation", "(Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Throwable;", "_state", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "countOrElement", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlinx/coroutines/CoroutineDispatcher;", "getReusableCancellableContinuation", "reusableCancellableContinuation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DispatchedContinuation<T> extends DispatchedTask<T> implements CoroutineStackFrame, Continuation<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25796i = AtomicReferenceFieldUpdater.newUpdater(DispatchedContinuation.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CoroutineDispatcher f25797j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Continuation<T> f25798k;
    public Object l;
    public final Object m;

    /* JADX WARN: Multi-variable type inference failed */
    public DispatchedContinuation(CoroutineDispatcher coroutineDispatcher, Continuation<? super T> continuation) {
        super(-1);
        this.f25797j = coroutineDispatcher;
        this.f25798k = continuation;
        this.l = i.a;
        this.m = i0.b(getL());
        this._reusableCancellableContinuation = null;
    }

    private final CancellableContinuationImpl<?> m() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof CancellableContinuationImpl) {
            return (CancellableContinuationImpl) obj;
        }
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void a(Object obj, Throwable th) {
        if (obj instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) obj).onCancellation.invoke(th);
        }
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Continuation<T> c() {
        return this;
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f25798k;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.p003y.Continuation
    /* JADX INFO: renamed from: getContext */
    public CoroutineContext getL() {
        return this.f25798k.getL();
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object j() {
        Object obj = this.l;
        if (s0.a()) {
            if (!(obj != i.a)) {
                throw new AssertionError();
            }
        }
        this.l = i.a;
        return obj;
    }

    public final void k() {
        while (this._reusableCancellableContinuation == i.f25799b) {
        }
    }

    public final CancellableContinuationImpl<T> l() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = i.f25799b;
                return null;
            }
            if (obj instanceof CancellableContinuationImpl) {
                if (f25796i.compareAndSet(this, obj, i.f25799b)) {
                    return (CancellableContinuationImpl) obj;
                }
            } else if (obj != i.f25799b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean p() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean r(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            Symbol symbol = i.f25799b;
            if (kotlin.jvm.internal.m.a(obj, symbol)) {
                if (f25796i.compareAndSet(this, symbol, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (f25796i.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @Override // kotlin.p003y.Continuation
    public void resumeWith(Object result) {
        CoroutineContext context = this.f25798k.getL();
        Object objD = kotlinx.coroutines.e0.d(result, null, 1, null);
        if (this.f25797j.N(context)) {
            this.l = objD;
            this.f25647h = 0;
            this.f25797j.K(context, this);
            return;
        }
        s0.a();
        EventLoop eventLoopB = ThreadLocalEventLoop.a.b();
        if (eventLoopB.i0()) {
            this.l = objD;
            this.f25647h = 0;
            eventLoopB.Z(this);
            return;
        }
        eventLoopB.e0(true);
        try {
            CoroutineContext context2 = getL();
            Object objC = i0.c(context2, this.m);
            try {
                this.f25798k.resumeWith(result);
                kotlin.u uVar = kotlin.u.a;
                i0.a(context2, objC);
                while (eventLoopB.p0()) {
                }
            } catch (Throwable th) {
                i0.a(context2, objC);
                throw th;
            }
        } catch (Throwable th2) {
            try {
                i(th2, null);
            } finally {
                eventLoopB.T(true);
            }
        }
    }

    public final void s() {
        k();
        CancellableContinuationImpl<?> cancellableContinuationImplM = m();
        if (cancellableContinuationImplM != null) {
            cancellableContinuationImplM.s();
        }
    }

    public final Throwable t(CancellableContinuation<?> cancellableContinuation) {
        Symbol symbol;
        do {
            Object obj = this._reusableCancellableContinuation;
            symbol = i.f25799b;
            if (obj != symbol) {
                if (obj instanceof Throwable) {
                    if (f25796i.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f25796i.compareAndSet(this, symbol, cancellableContinuation));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f25797j + ", " + t0.c(this.f25798k) + ']';
    }
}
