package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.f, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/internal/NoOpContinuation;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", HttpUrl.FRAGMENT_ENCODE_SET, "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class NoOpContinuation implements Continuation<Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final NoOpContinuation f25759f = new NoOpContinuation();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CoroutineContext f25760g = EmptyCoroutineContext.f25609f;

    private NoOpContinuation() {
    }

    @Override // kotlin.p003y.Continuation
    public CoroutineContext getContext() {
        return f25760g;
    }

    @Override // kotlin.p003y.Continuation
    public void resumeWith(Object result) {
    }
}
