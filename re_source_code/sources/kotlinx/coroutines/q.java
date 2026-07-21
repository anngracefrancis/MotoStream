package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.p003y.Continuation;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0000\u001a3\u0010\u0005\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u00022\u001a\b\u0004\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0018\u0010\f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0018\u0010\u000f\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"getOrCreateCancellableContinuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "T", "delegate", "Lkotlin/coroutines/Continuation;", "suspendCancellableCoroutine", "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/CancellableContinuation;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendCancellableCoroutineReusable", "disposeOnCancellation", "handle", "Lkotlinx/coroutines/DisposableHandle;", "removeOnCancellation", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class q {
    public static final void a(CancellableContinuation<?> cancellableContinuation, DisposableHandle disposableHandle) {
        cancellableContinuation.e(new DisposeOnCancel(disposableHandle));
    }

    public static final <T> CancellableContinuationImpl<T> b(Continuation<? super T> continuation) {
        if (!(continuation instanceof DispatchedContinuation)) {
            return new CancellableContinuationImpl<>(continuation, 1);
        }
        CancellableContinuationImpl<T> cancellableContinuationImplL = ((DispatchedContinuation) continuation).l();
        if (cancellableContinuationImplL != null) {
            if (!cancellableContinuationImplL.I()) {
                cancellableContinuationImplL = null;
            }
            if (cancellableContinuationImplL != null) {
                return cancellableContinuationImplL;
            }
        }
        return new CancellableContinuationImpl<>(continuation, 2);
    }

    public static final void c(CancellableContinuation<?> cancellableContinuation, LockFreeLinkedListNode lockFreeLinkedListNode) {
        cancellableContinuation.e(new RemoveOnCancel(lockFreeLinkedListNode));
    }
}
