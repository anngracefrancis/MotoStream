package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.n2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/RemoveOnCancel;", "Lkotlinx/coroutines/BeforeResumeCancelHandler;", "node", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "invoke", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class RemoveOnCancel extends BeforeResumeCancelHandler {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LockFreeLinkedListNode f25858f;

    public RemoveOnCancel(LockFreeLinkedListNode lockFreeLinkedListNode) {
        this.f25858f = lockFreeLinkedListNode;
    }

    @Override // kotlinx.coroutines.CancelHandlerBase
    public void b(Throwable th) {
        this.f25858f.z();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        b(th);
        return kotlin.u.a;
    }

    public String toString() {
        return "RemoveOnCancel[" + this.f25858f + ']';
    }
}
