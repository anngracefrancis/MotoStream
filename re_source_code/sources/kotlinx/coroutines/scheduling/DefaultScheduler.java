package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.c3.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\r\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/SchedulerCoroutineDispatcher;", "()V", "close", HttpUrl.FRAGMENT_ENCODE_SET, "shutdown", "shutdown$kotlinx_coroutines_core", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultScheduler extends SchedulerCoroutineDispatcher {
    public static final DefaultScheduler m = new DefaultScheduler();

    private DefaultScheduler() {
        super(l.f25682b, l.f25683c, l.f25684d, "DefaultDispatcher");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
