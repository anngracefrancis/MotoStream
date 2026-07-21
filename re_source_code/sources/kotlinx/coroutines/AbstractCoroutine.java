package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AbstractCoroutine.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0015\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dH\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020\u001aH\u0010¢\u0006\u0002\b J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\tH\u0014J\u0015\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0004J\u001c\u0010(\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000*ø\u0001\u0000¢\u0006\u0002\u0010&JM\u0010+\u001a\u00020\u0016\"\u0004\b\u0001\u0010,2\u0006\u0010+\u001a\u00020-2\u0006\u0010.\u001a\u0002H,2'\u0010/\u001a#\b\u0001\u0012\u0004\u0012\u0002H,\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u001800¢\u0006\u0002\b1ø\u0001\u0000¢\u0006\u0002\u00102R\u0017\u0010\f\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u00063"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "initParentJob", HttpUrl.FRAGMENT_ENCODE_SET, "active", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "context", "getContext$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "isActive", "()Z", "afterResume", HttpUrl.FRAGMENT_ENCODE_SET, "state", HttpUrl.FRAGMENT_ENCODE_SET, "cancellationExceptionMessage", HttpUrl.FRAGMENT_ENCODE_SET, "handleOnCompletionException", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "handleOnCompletionException$kotlinx_coroutines_core", "nameString", "nameString$kotlinx_coroutines_core", "onCancelled", "cause", "handled", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletionInternal", "resumeWith", "result", "Lkotlin/Result;", "start", "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineContext f25631g;

    public AbstractCoroutine(CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            a0((Job) coroutineContext.get(Job.f25890e));
        }
        this.f25631g = coroutineContext.plus(this);
    }

    protected void C0(Object obj) {
        v(obj);
    }

    protected void D0(Throwable th, boolean z) {
    }

    protected void E0(T t) {
    }

    public final <R> void F0(CoroutineStart coroutineStart, R r, Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2) {
        coroutineStart.k(function2, r, this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.JobSupport
    public String K() {
        return t0.a(this) + " was cancelled";
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void Z(Throwable th) {
        l0.a(this.f25631g, th);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean b() {
        return super.b();
    }

    @Override // kotlin.p003y.Continuation
    /* JADX INFO: renamed from: getContext, reason: from getter */
    public final CoroutineContext getF25631g() {
        return this.f25631g;
    }

    @Override // kotlinx.coroutines.JobSupport
    public String h0() {
        String strB = h0.b(this.f25631g);
        if (strB == null) {
            return super.h0();
        }
        return '\"' + strB + "\":" + super.h0();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    /* JADX INFO: renamed from: i */
    public CoroutineContext getF25795f() {
        return this.f25631g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    protected final void m0(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            E0(obj);
        } else {
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
            D0(completedExceptionally.f25646b, completedExceptionally.a());
        }
    }

    @Override // kotlin.p003y.Continuation
    public final void resumeWith(Object result) {
        Object objF0 = f0(e0.d(result, null, 1, null));
        if (objF0 == g2.f25772b) {
            return;
        }
        C0(objF0);
    }
}
