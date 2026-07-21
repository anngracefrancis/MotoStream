package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.h0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Tasks.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0010*\u00020\u00118À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u0013"}, d2 = {"BlockingContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "CORE_POOL_SIZE", HttpUrl.FRAGMENT_ENCODE_SET, "DEFAULT_SCHEDULER_NAME", HttpUrl.FRAGMENT_ENCODE_SET, "IDLE_WORKER_KEEP_ALIVE_NS", HttpUrl.FRAGMENT_ENCODE_SET, "MAX_POOL_SIZE", "NonBlockingContext", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class l {
    public static final long a = h0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25682b = h0.d("kotlinx.coroutines.scheduler.core.pool.size", kotlin.ranges.l.b(f0.a(), 2), 1, 0, 8, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25683c = h0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f25684d = TimeUnit.SECONDS.toNanos(h0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60, 0, 0, 12, null));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static SchedulerTimeSource f25685e = NanoTimeSource.a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TaskContext f25686f = new TaskContextImpl(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final TaskContext f25687g = new TaskContextImpl(1);
}
