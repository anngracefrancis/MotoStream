package kotlinx.coroutines.scheduling;

import cm.aptoide.pt.BuildConfig;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.EmptyCoroutineContext;
import kotlin.ranges.l;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.h0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.c3.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0017J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/scheduling/DefaultIoScheduler;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Ljava/util/concurrent/Executor;", "()V", BuildConfig.APTOIDE_THEME, "Lkotlinx/coroutines/CoroutineDispatcher;", "executor", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", HttpUrl.FRAGMENT_ENCODE_SET, "dispatch", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatchYield", "execute", "command", "limitedParallelism", "parallelism", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultIoScheduler extends ExecutorCoroutineDispatcher implements Executor {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DefaultIoScheduler f25673h = new DefaultIoScheduler();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final CoroutineDispatcher f25674i = UnlimitedIoScheduler.f25688g.Q(h0.d("kotlinx.coroutines.io.parallelism", l.b(64, f0.a()), 0, 0, 12, null));

    private DefaultIoScheduler() {
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void K(CoroutineContext coroutineContext, Runnable runnable) {
        f25674i.K(coroutineContext, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        K(EmptyCoroutineContext.f25609f, command);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.IO";
    }
}
