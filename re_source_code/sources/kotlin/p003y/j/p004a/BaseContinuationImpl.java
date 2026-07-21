package kotlin.p003y.j.p004a;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.y.j.a.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", HttpUrl.FRAGMENT_ENCODE_SET, "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class BaseContinuationImpl implements Continuation<Object>, CoroutineStackFrame, Serializable {
    private final Continuation<Object> completion;

    public BaseContinuationImpl(Continuation<Object> continuation) {
        this.completion = continuation;
    }

    public Continuation<u> create(Continuation<?> continuation) {
        m.f(continuation, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<Object> continuation = this.completion;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    public final Continuation<Object> getCompletion() {
        return this.completion;
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    protected abstract Object invokeSuspend(Object result);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.p003y.Continuation
    public final void resumeWith(Object result) {
        Continuation<Object> continuation = this;
        while (true) {
            h.b(continuation);
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) continuation;
            Continuation<Object> continuation2 = baseContinuationImpl.completion;
            m.c(continuation2);
            try {
                Object objInvokeSuspend = baseContinuationImpl.invokeSuspend(result);
                if (objInvokeSuspend == d.c()) {
                    return;
                }
                Result.a aVar = Result.f25108f;
                result = Result.a(objInvokeSuspend);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f25108f;
                result = Result.a(o.a(th));
            }
            baseContinuationImpl.releaseIntercepted();
            if (!(continuation2 instanceof BaseContinuationImpl)) {
                continuation2.resumeWith(result);
                return;
            }
            continuation = continuation2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public Continuation<u> create(Object obj, Continuation<?> continuation) {
        m.f(continuation, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
