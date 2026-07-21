package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.p2, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/ResumeUndispatchedRunnable;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CancellableContinuation;)V", "run", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class ResumeUndispatchedRunnable implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineDispatcher f25866f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CancellableContinuation<kotlin.u> f25867g;

    /* JADX WARN: Multi-variable type inference failed */
    public ResumeUndispatchedRunnable(CoroutineDispatcher coroutineDispatcher, CancellableContinuation<? super kotlin.u> cancellableContinuation) {
        this.f25866f = coroutineDispatcher;
        this.f25867g = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f25867g.h(this.f25866f, kotlin.u.a);
    }
}
