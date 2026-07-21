package kotlin.p003y.j.p004a;

import kotlin.Metadata;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.y.j.a.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lkotlin/coroutines/jvm/internal/CompletedContinuation;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", HttpUrl.FRAGMENT_ENCODE_SET, "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CompletedContinuation implements Continuation<Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CompletedContinuation f25620f = new CompletedContinuation();

    private CompletedContinuation() {
    }

    @Override // kotlin.p003y.Continuation
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // kotlin.p003y.Continuation
    public void resumeWith(Object result) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
