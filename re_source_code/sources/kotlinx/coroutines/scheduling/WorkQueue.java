package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.c3.n, reason: from Kotlin metadata */
/* JADX INFO: compiled from: WorkQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\b\u0000\u0018\u00002\u00020*B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010&\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020#8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010%¨\u0006)"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", HttpUrl.FRAGMENT_ENCODE_SET, "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalQueue", HttpUrl.FRAGMENT_ENCODE_SET, "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "poll", "()Lkotlinx/coroutines/scheduling/Task;", "pollBuffer", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "victim", HttpUrl.FRAGMENT_ENCODE_SET, "tryStealBlockingFrom", "(Lkotlinx/coroutines/scheduling/WorkQueue;)J", "tryStealFrom", "blockingOnly", "tryStealLastScheduled", "(Lkotlinx/coroutines/scheduling/WorkQueue;Z)J", "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", HttpUrl.FRAGMENT_ENCODE_SET, "getBufferSize$kotlinx_coroutines_core", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "kotlinx-coroutines-core", HttpUrl.FRAGMENT_ENCODE_SET}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WorkQueue {
    private static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f25689b = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f25690c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f25691d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicReferenceArray<Task> f25692e = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ Task b(WorkQueue workQueue, Task task, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return workQueue.a(task, z);
    }

    private final Task c(Task task) {
        if (task.f25680g.getA() == 1) {
            f25691d.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int i2 = this.producerIndex & 127;
        while (this.f25692e.get(i2) != null) {
            Thread.yield();
        }
        this.f25692e.lazySet(i2, task);
        f25689b.incrementAndGet(this);
        return null;
    }

    private final void d(Task task) {
        if (task != null) {
            if (task.f25680g.getA() == 1) {
                int iDecrementAndGet = f25691d.decrementAndGet(this);
                if (s0.a()) {
                    if (!(iDecrementAndGet >= 0)) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    private final Task i() {
        Task andSet;
        while (true) {
            int i2 = this.consumerIndex;
            if (i2 - this.producerIndex == 0) {
                return null;
            }
            int i3 = i2 & 127;
            if (f25690c.compareAndSet(this, i2, i2 + 1) && (andSet = this.f25692e.getAndSet(i3, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    private final boolean j(GlobalQueue globalQueue) {
        Task taskI = i();
        if (taskI == null) {
            return false;
        }
        globalQueue.a(taskI);
        return true;
    }

    private final long m(WorkQueue workQueue, boolean z) {
        Task task;
        do {
            task = (Task) workQueue.lastScheduledTask;
            if (task == null) {
                return -2L;
            }
            if (z) {
                if (!(task.f25680g.getA() == 1)) {
                    return -2L;
                }
            }
            long jA = l.f25685e.a() - task.f25679f;
            long j2 = l.a;
            if (jA < j2) {
                return j2 - jA;
            }
        } while (!a.compareAndSet(workQueue, task, null));
        b(this, task, false, 2, null);
        return -1L;
    }

    public final Task a(Task task, boolean z) {
        if (z) {
            return c(task);
        }
        Task task2 = (Task) a.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return c(task2);
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(GlobalQueue globalQueue) {
        Task task = (Task) a.getAndSet(this, null);
        if (task != null) {
            globalQueue.a(task);
        }
        while (j(globalQueue)) {
        }
    }

    public final Task h() {
        Task task = (Task) a.getAndSet(this, null);
        return task == null ? i() : task;
    }

    public final long k(WorkQueue workQueue) {
        if (s0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        int i2 = workQueue.producerIndex;
        AtomicReferenceArray<Task> atomicReferenceArray = workQueue.f25692e;
        for (int i3 = workQueue.consumerIndex; i3 != i2; i3++) {
            int i4 = i3 & 127;
            if (workQueue.blockingTasksInBuffer == 0) {
                break;
            }
            Task task = atomicReferenceArray.get(i4);
            if (task != null) {
                if ((task.f25680g.getA() == 1) && atomicReferenceArray.compareAndSet(i4, task, null)) {
                    f25691d.decrementAndGet(workQueue);
                    b(this, task, false, 2, null);
                    return -1L;
                }
            }
        }
        return m(workQueue, true);
    }

    public final long l(WorkQueue workQueue) {
        if (s0.a()) {
            if (!(e() == 0)) {
                throw new AssertionError();
            }
        }
        Task taskI = workQueue.i();
        if (taskI == null) {
            return m(workQueue, false);
        }
        Task taskB = b(this, taskI, false, 2, null);
        if (!s0.a()) {
            return -1L;
        }
        if (taskB == null) {
            return -1L;
        }
        throw new AssertionError();
    }
}
