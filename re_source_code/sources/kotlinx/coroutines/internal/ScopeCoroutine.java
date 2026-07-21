package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.CoroutineStackFrame;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.Job;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.internal.c0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\u000e\u0010\u0019\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bR\u0019\u0010\n\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/internal/ScopeCoroutine;", "T", "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "isScopedCoroutine", HttpUrl.FRAGMENT_ENCODE_SET, "()Z", "parent", "Lkotlinx/coroutines/Job;", "getParent$kotlinx_coroutines_core", "()Lkotlinx/coroutines/Job;", "afterCompletion", HttpUrl.FRAGMENT_ENCODE_SET, "state", HttpUrl.FRAGMENT_ENCODE_SET, "afterResume", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ScopeCoroutine<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Continuation<T> f25792h;

    /* JADX WARN: Multi-variable type inference failed */
    public ScopeCoroutine(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true, true);
        this.f25792h = continuation;
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void C0(Object obj) {
        Continuation<T> continuation = this.f25792h;
        continuation.resumeWith(kotlinx.coroutines.e0.a(obj, continuation));
    }

    public final Job G0() {
        ChildHandle childHandleW = W();
        if (childHandleW != null) {
            return childHandleW.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected final boolean c0() {
        return true;
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public final CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.f25792h;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.p003y.j.p004a.CoroutineStackFrame
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void v(Object obj) {
        i.c(kotlin.p003y.intrinsics.c.b(this.f25792h), kotlinx.coroutines.e0.a(obj, this.f25792h), null, 2, null);
    }
}
