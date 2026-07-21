package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.o2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0096\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ResumeAwaitOnCompletion<T> extends JobNode {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CancellableContinuationImpl<T> f25864j;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeAwaitOnCompletion(CancellableContinuationImpl<? super T> cancellableContinuationImpl) {
        this.f25864j = cancellableContinuationImpl;
    }

    @Override // kotlinx.coroutines.CompletionHandlerBase
    public void E(Throwable th) {
        Object objX = F().X();
        if (s0.a() && !(!(objX instanceof Incomplete))) {
            throw new AssertionError();
        }
        if (objX instanceof CompletedExceptionally) {
            CancellableContinuationImpl<T> cancellableContinuationImpl = this.f25864j;
            Result.a aVar = Result.f25108f;
            cancellableContinuationImpl.resumeWith(Result.a(kotlin.o.a(((CompletedExceptionally) objX).f25646b)));
        } else {
            CancellableContinuationImpl<T> cancellableContinuationImpl2 = this.f25864j;
            Result.a aVar2 = Result.f25108f;
            cancellableContinuationImpl2.resumeWith(Result.a(g2.h(objX)));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ kotlin.u invoke(Throwable th) {
        E(th);
        return kotlin.u.a;
    }
}
