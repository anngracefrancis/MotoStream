package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.CoroutineStackFrame;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.o, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\t\u0012\u0004\u0012\u00028\u00000\u008a\u00012\t\u0012\u0004\u0012\u00028\u00000\u008b\u00012\u00060tj\u0002`uB\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013JB\u0010\u0012\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0018J\u001e\u0010\u001b\u001a\u00020\u00112\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019H\u0082\b¢\u0006\u0004\b\u001b\u0010\u001cJ8\u0010\u001e\u001a\u00020\u00112!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u001e\u0010\u0018J\u0019\u0010 \u001a\u00020\u001f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b \u0010!J!\u0010%\u001a\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0010¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010!J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020\bH\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010,\u001a\u00020\u0011H\u0000¢\u0006\u0004\b*\u0010+J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010+J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u0004H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00103\u001a\u00020\u000f2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104J\u001b\u00108\u001a\u0004\u0018\u00010\u000f2\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b6\u00107J\u0011\u00109\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\n\u0018\u00010;j\u0004\u0018\u0001`<H\u0016¢\u0006\u0004\b=\u0010>J\u001f\u0010A\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u00105\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020\u0011H\u0016¢\u0006\u0004\bB\u0010+J\u0011\u0010D\u001a\u0004\u0018\u00010CH\u0002¢\u0006\u0004\bD\u0010EJ8\u0010F\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u001fH\u0002¢\u0006\u0004\bH\u0010IJ8\u0010J\u001a\u00020\r2'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u0017H\u0002¢\u0006\u0004\bJ\u0010KJB\u0010L\u001a\u00020\u00112'\u0010\u000e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\u0014j\u0002`\u00172\b\u00105\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\bL\u0010MJ\u000f\u0010O\u001a\u00020NH\u0014¢\u0006\u0004\bO\u0010PJ\u0017\u0010S\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0000¢\u0006\u0004\bQ\u0010RJ\u000f\u0010T\u001a\u00020\u0011H\u0002¢\u0006\u0004\bT\u0010+J\u000f\u0010U\u001a\u00020\u001fH\u0001¢\u0006\u0004\bU\u0010IJ<\u0010W\u001a\u00020\u00112\u0006\u0010V\u001a\u00028\u00002#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\bW\u0010XJH\u0010Y\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042%\b\u0002\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bY\u0010ZJ \u0010]\u001a\u00020\u00112\f\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000[H\u0016ø\u0001\u0000¢\u0006\u0004\b]\u0010)JZ\u0010`\u001a\u0004\u0018\u00010\b2\u0006\u00105\u001a\u00020^2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\b\u0010_\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b`\u0010aJ\u0011\u0010c\u001a\u0004\u0018\u00010\bH\u0010¢\u0006\u0004\bb\u0010:J\u000f\u0010d\u001a\u00020NH\u0016¢\u0006\u0004\bd\u0010PJ\u000f\u0010e\u001a\u00020\u001fH\u0002¢\u0006\u0004\be\u0010IJ#\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\be\u0010fJH\u0010e\u001a\u0004\u0018\u00010\b2\u0006\u0010V\u001a\u00028\u00002\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0016¢\u0006\u0004\be\u0010gJJ\u0010i\u001a\u0004\u0018\u00010h2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010_\u001a\u0004\u0018\u00010\b2#\u0010\u001d\u001a\u001f\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0014H\u0002¢\u0006\u0004\bi\u0010jJ\u0019\u0010l\u001a\u0004\u0018\u00010\b2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u00020\u001fH\u0002¢\u0006\u0004\bn\u0010IJ\u001b\u0010p\u001a\u00020\u0011*\u00020o2\u0006\u0010V\u001a\u00028\u0000H\u0016¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u0011*\u00020o2\u0006\u0010k\u001a\u00020\u000fH\u0016¢\u0006\u0004\br\u0010sR\u001c\u0010x\u001a\n\u0018\u00010tj\u0004\u0018\u0001`u8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u001a\u0010z\u001a\u00020y8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0080\u0004¢\u0006\r\n\u0004\b\u0003\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001R\u0016\u0010\u0081\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010IR\u0016\u0010\u0082\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0082\u0001\u0010IR\u0016\u0010\u0083\u0001\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u0010IR\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u0017\u00105\u001a\u0004\u0018\u00010\b8@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010:R\u0016\u0010\u0088\u0001\u001a\u00020N8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u0010P\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0089\u0001"}, d2 = {"Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "Lkotlin/coroutines/Continuation;", "delegate", HttpUrl.FRAGMENT_ENCODE_SET, "resumeMode", "<init>", "(Lkotlin/coroutines/Continuation;I)V", HttpUrl.FRAGMENT_ENCODE_SET, "proposedUpdate", HttpUrl.FRAGMENT_ENCODE_SET, "alreadyResumedError", "(Ljava/lang/Object;)Ljava/lang/Void;", "Lkotlinx/coroutines/CancelHandler;", "handler", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "callCancelHandler", "(Lkotlinx/coroutines/CancelHandler;Ljava/lang/Throwable;)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "Lkotlin/Function0;", "block", "callCancelHandlerSafely", "(Lkotlin/jvm/functions/Function0;)V", "onCancellation", "callOnCancellation", HttpUrl.FRAGMENT_ENCODE_SET, "cancel", "(Ljava/lang/Throwable;)Z", "takenState", "cancelCompletedResult$kotlinx_coroutines_core", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelCompletedResult", "cancelLater", "token", "completeResume", "(Ljava/lang/Object;)V", "detachChild$kotlinx_coroutines_core", "()V", "detachChild", "detachChildIfNonResuable", "mode", "dispatchResume", "(I)V", "Lkotlinx/coroutines/Job;", "parent", "getContinuationCancellationCause", "(Lkotlinx/coroutines/Job;)Ljava/lang/Throwable;", "state", "getExceptionalResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "getExceptionalResult", "getResult", "()Ljava/lang/Object;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "getSuccessfulResult", "initCancellability", "Lkotlinx/coroutines/DisposableHandle;", "installParentHandle", "()Lkotlinx/coroutines/DisposableHandle;", "invokeOnCancellation", "(Lkotlin/jvm/functions/Function1;)V", "isReusable", "()Z", "makeCancelHandler", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/CancelHandler;", "multipleHandlersError", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", HttpUrl.FRAGMENT_ENCODE_SET, "nameString", "()Ljava/lang/String;", "parentCancelled$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)V", "parentCancelled", "releaseClaimedReusableContinuation", "resetStateReusable", "value", "resume", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "resumeImpl", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lkotlin/Result;", "result", "resumeWith", "Lkotlinx/coroutines/NotCompleted;", "idempotent", "resumedState", "(Lkotlinx/coroutines/NotCompleted;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "takeState$kotlinx_coroutines_core", "takeState", "toString", "tryResume", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "tryResumeImpl", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/Symbol;", "exception", "tryResumeWithException", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "trySuspend", "Lkotlinx/coroutines/CoroutineDispatcher;", "resumeUndispatched", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "isActive", "isCancelled", "isCompleted", "parentHandle", "Lkotlinx/coroutines/DisposableHandle;", "getState$kotlinx_coroutines_core", "getStateDebugRepresentation", "stateDebugRepresentation", "kotlinx-coroutines-core", "Lkotlinx/coroutines/DispatchedTask;", "Lkotlinx/coroutines/CancellableContinuation;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CancellableContinuationImpl<T> extends DispatchedTask<T> implements CancellableContinuation<T>, CoroutineStackFrame {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f25859i = AtomicIntegerFieldUpdater.newUpdater(CancellableContinuationImpl.class, "_decision");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25860j = AtomicReferenceFieldUpdater.newUpdater(CancellableContinuationImpl.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Continuation<T> f25861k;
    private final CoroutineContext l;
    private DisposableHandle m;

    /* JADX WARN: Multi-variable type inference failed */
    public CancellableContinuationImpl(Continuation<? super T> continuation, int i2) {
        super(i2);
        this.f25861k = continuation;
        if (s0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        this.l = continuation.getL();
        this._decision = 0;
        this._state = Active.f25723f;
    }

    private final DisposableHandle A() {
        Job job = (Job) getL().get(Job.f25890e);
        if (job == null) {
            return null;
        }
        DisposableHandle disposableHandleD = Job.a.d(job, true, false, new ChildContinuation(this), 2, null);
        this.m = disposableHandleD;
        return disposableHandleD;
    }

    private final boolean C() {
        return c1.c(this.f25647h) && ((DispatchedContinuation) this.f25861k).p();
    }

    private final CancelHandler D(Function1<? super Throwable, kotlin.u> function1) {
        return function1 instanceof CancelHandler ? (CancelHandler) function1 : new InvokeOnCancel(function1);
    }

    private final void E(Function1<? super Throwable, kotlin.u> function1, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + function1 + ", already has " + obj).toString());
    }

    private final void H() {
        Throwable thT;
        Continuation<T> continuation = this.f25861k;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        if (dispatchedContinuation == null || (thT = dispatchedContinuation.t(this)) == null) {
            return;
        }
        s();
        o(thT);
    }

    private final void J(Object obj, int i2, Function1<? super Throwable, kotlin.u> function1) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof NotCompleted)) {
                if (obj2 instanceof CancelledContinuation) {
                    CancelledContinuation cancelledContinuation = (CancelledContinuation) obj2;
                    if (cancelledContinuation.c()) {
                        if (function1 != null) {
                            p(function1, cancelledContinuation.f25646b);
                            return;
                        }
                        return;
                    }
                }
                k(obj);
                throw new KotlinNothingValueException();
            }
        } while (!f25860j.compareAndSet(this, obj2, L((NotCompleted) obj2, obj, i2, function1, null)));
        t();
        u(i2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void K(CancellableContinuationImpl cancellableContinuationImpl, Object obj, int i2, Function1 function1, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        cancellableContinuationImpl.J(obj, i2, function1);
    }

    private final Object L(NotCompleted notCompleted, Object obj, int i2, Function1<? super Throwable, kotlin.u> function1, Object obj2) {
        if (obj instanceof CompletedExceptionally) {
            if (s0.a()) {
                if (!(obj2 == null)) {
                    throw new AssertionError();
                }
            }
            if (!s0.a()) {
                return obj;
            }
            if (function1 == null) {
                return obj;
            }
            throw new AssertionError();
        }
        if (!c1.b(i2) && obj2 == null) {
            return obj;
        }
        if (function1 != null || (((notCompleted instanceof CancelHandler) && !(notCompleted instanceof BeforeResumeCancelHandler)) || obj2 != null)) {
            return new CompletedContinuation(obj, notCompleted instanceof CancelHandler ? (CancelHandler) notCompleted : null, function1, obj2, null, 16, null);
        }
        return obj;
    }

    private final boolean M() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f25859i.compareAndSet(this, 0, 2));
        return true;
    }

    private final Symbol N(Object obj, Object obj2, Function1<? super Throwable, kotlin.u> function1) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof NotCompleted)) {
                if (!(obj3 instanceof CompletedContinuation) || obj2 == null) {
                    return null;
                }
                CompletedContinuation completedContinuation = (CompletedContinuation) obj3;
                if (completedContinuation.idempotentResume != obj2) {
                    return null;
                }
                if (!s0.a() || kotlin.jvm.internal.m.a(completedContinuation.result, obj)) {
                    return p.a;
                }
                throw new AssertionError();
            }
        } while (!f25860j.compareAndSet(this, obj3, L((NotCompleted) obj3, obj, this.f25647h, function1, obj2)));
        t();
        return p.a;
    }

    private final boolean O() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f25859i.compareAndSet(this, 0, 1));
        return true;
    }

    private final Void k(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    private final void l(Function1<? super Throwable, kotlin.u> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            l0.a(getL(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    private final boolean r(Throwable th) {
        if (C()) {
            return ((DispatchedContinuation) this.f25861k).r(th);
        }
        return false;
    }

    private final void t() {
        if (C()) {
            return;
        }
        s();
    }

    private final void u(int i2) {
        if (M()) {
            return;
        }
        c1.a(this, i2);
    }

    private final String y() {
        Object obj = get_state();
        if (obj instanceof NotCompleted) {
            return "Active";
        }
        return obj instanceof CancelledContinuation ? "Cancelled" : "Completed";
    }

    public boolean B() {
        return !(get_state() instanceof NotCompleted);
    }

    protected String F() {
        return "CancellableContinuation";
    }

    public final void G(Throwable th) {
        if (r(th)) {
            return;
        }
        o(th);
        t();
    }

    public final boolean I() {
        if (s0.a()) {
            if (!(this.f25647h == 2)) {
                throw new AssertionError();
            }
        }
        if (s0.a()) {
            if (!(this.m != NonDisposableHandle.f25852f)) {
                throw new AssertionError();
            }
        }
        Object obj = this._state;
        if (s0.a() && !(!(obj instanceof NotCompleted))) {
            throw new AssertionError();
        }
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            s();
            return false;
        }
        this._decision = 0;
        this._state = Active.f25723f;
        return true;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof NotCompleted) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof CompletedExceptionally) {
                return;
            }
            if (obj2 instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj2;
                if (!(!completedContinuation.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (f25860j.compareAndSet(this, obj2, CompletedContinuation.b(completedContinuation, null, null, null, null, th, 15, null))) {
                    completedContinuation.d(this, th);
                    return;
                }
            } else if (f25860j.compareAndSet(this, obj2, new CompletedContinuation(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean b() {
        return get_state() instanceof NotCompleted;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public final Continuation<T> c() {
        return this.f25861k;
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Throwable d(Object obj) {
        Throwable thD = super.d(obj);
        if (thD == null) {
            return null;
        }
        Continuation<T> continuation = this.f25861k;
        return (s0.d() && (continuation instanceof CoroutineStackFrame)) ? kotlinx.coroutines.internal.d0.j(thD, (CoroutineStackFrame) continuation) : thD;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void e(Function1<? super Throwable, kotlin.u> function1) {
        CancelHandler cancelHandlerD = D(function1);
        while (true) {
            Object obj = this._state;
            if (obj instanceof Active) {
                if (f25860j.compareAndSet(this, obj, cancelHandlerD)) {
                    return;
                }
            } else if (obj instanceof CancelHandler) {
                E(function1, obj);
            } else {
                boolean z = obj instanceof CompletedExceptionally;
                if (z) {
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
                    if (!completedExceptionally.b()) {
                        E(function1, obj);
                    }
                    if (obj instanceof CancelledContinuation) {
                        if (!z) {
                            completedExceptionally = null;
                        }
                        l(function1, completedExceptionally != null ? completedExceptionally.f25646b : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        E(function1, obj);
                    }
                    if (cancelHandlerD instanceof BeforeResumeCancelHandler) {
                        return;
                    }
                    if (completedContinuation.c()) {
                        l(function1, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (f25860j.compareAndSet(this, obj, CompletedContinuation.b(completedContinuation, null, cancelHandlerD, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (cancelHandlerD instanceof BeforeResumeCancelHandler) {
                        return;
                    }
                    if (f25860j.compareAndSet(this, obj, new CompletedContinuation(obj, cancelHandlerD, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.DispatchedTask
    public <T> T f(Object obj) {
        return obj instanceof CompletedContinuation ? (T) ((CompletedContinuation) obj).result : obj;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public Object g(T t, Object obj, Function1<? super Throwable, kotlin.u> function1) {
        return N(t, obj, function1);
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f25861k;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.p003y.Continuation
    /* JADX INFO: renamed from: getContext, reason: from getter */
    public CoroutineContext getL() {
        return this.l;
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void h(CoroutineDispatcher coroutineDispatcher, T t) {
        Continuation<T> continuation = this.f25861k;
        DispatchedContinuation dispatchedContinuation = continuation instanceof DispatchedContinuation ? (DispatchedContinuation) continuation : null;
        K(this, t, (dispatchedContinuation != null ? dispatchedContinuation.f25797j : null) == coroutineDispatcher ? 4 : this.f25647h, null, 4, null);
    }

    @Override // kotlinx.coroutines.DispatchedTask
    public Object j() {
        return get_state();
    }

    public final void m(CancelHandler cancelHandler, Throwable th) {
        try {
            cancelHandler.b(th);
        } catch (Throwable th2) {
            l0.a(getL(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void n(T t, Function1<? super Throwable, kotlin.u> function1) {
        J(t, this.f25647h, function1);
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public boolean o(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof NotCompleted)) {
                return false;
            }
            z = obj instanceof CancelHandler;
        } while (!f25860j.compareAndSet(this, obj, new CancelledContinuation(this, th, z)));
        CancelHandler cancelHandler = z ? (CancelHandler) obj : null;
        if (cancelHandler != null) {
            m(cancelHandler, th);
        }
        t();
        u(this.f25647h);
        return true;
    }

    public final void p(Function1<? super Throwable, kotlin.u> function1, Throwable th) {
        try {
            function1.invoke(th);
        } catch (Throwable th2) {
            l0.a(getL(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    @Override // kotlinx.coroutines.CancellableContinuation
    public void q(Object obj) {
        if (s0.a()) {
            if (!(obj == p.a)) {
                throw new AssertionError();
            }
        }
        u(this.f25647h);
    }

    @Override // kotlin.p003y.Continuation
    public void resumeWith(Object result) {
        K(this, e0.c(result, this), this.f25647h, null, 4, null);
    }

    public final void s() {
        DisposableHandle disposableHandle = this.m;
        if (disposableHandle == null) {
            return;
        }
        disposableHandle.k();
        this.m = NonDisposableHandle.f25852f;
    }

    public String toString() {
        return F() + '(' + t0.c(this.f25861k) + "){" + y() + "}@" + t0.b(this);
    }

    public Throwable v(Job job) {
        return job.j();
    }

    public final Object w() {
        Job job;
        boolean zC = C();
        if (O()) {
            if (this.m == null) {
                A();
            }
            if (zC) {
                H();
            }
            return kotlin.p003y.intrinsics.d.c();
        }
        if (zC) {
            H();
        }
        Object obj = get_state();
        if (obj instanceof CompletedExceptionally) {
            Throwable th = ((CompletedExceptionally) obj).f25646b;
            if (s0.d()) {
                throw kotlinx.coroutines.internal.d0.j(th, this);
            }
            throw th;
        }
        if (!c1.b(this.f25647h) || (job = (Job) getL().get(Job.f25890e)) == null || job.b()) {
            return f(obj);
        }
        CancellationException cancellationExceptionJ = job.j();
        a(obj, cancellationExceptionJ);
        if (s0.d()) {
            throw kotlinx.coroutines.internal.d0.j(cancellationExceptionJ, this);
        }
        throw cancellationExceptionJ;
    }

    /* JADX INFO: renamed from: x, reason: from getter */
    public final Object get_state() {
        return this._state;
    }

    public void z() {
        DisposableHandle disposableHandleA = A();
        if (disposableHandleA != null && B()) {
            disposableHandleA.k();
            this.m = NonDisposableHandle.f25852f;
        }
    }
}
