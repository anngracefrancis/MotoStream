package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.p003y.EmptyCoroutineContext;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.d1, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/DispatcherExecutor;", "Ljava/util/concurrent/Executor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", HttpUrl.FRAGMENT_ENCODE_SET, "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class DispatcherExecutor implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineDispatcher f25724f;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable block) {
        this.f25724f.K(EmptyCoroutineContext.f25609f, block);
    }

    public String toString() {
        return this.f25724f.toString();
    }
}
