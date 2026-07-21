package kotlinx.coroutines.scheduling;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.random.Random;
import kotlin.ranges.l;
import kotlin.u;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.s0;
import kotlinx.coroutines.t0;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.c3.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0000\u0018\u0000 X2\u00020\\2\u00020]:\u0003XYZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0086\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001d\u001a\u00020\n2\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010!\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0013H\u0082\b¢\u0006\u0004\b#\u0010\u0015J\u0010\u0010$\u001a\u00020\u0001H\u0082\b¢\u0006\u0004\b$\u0010\u0017J-\u0010&\u001a\u00020\u00132\n\u0010\u001a\u001a\u00060\u0018j\u0002`\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\f¢\u0006\u0004\b&\u0010'J\u001b\u0010)\u001a\u00020\u00132\n\u0010(\u001a\u00060\u0018j\u0002`\u0019H\u0016¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0001H\u0082\b¢\u0006\u0004\b-\u0010\u0017J\u001b\u0010/\u001a\u00020\u00012\n\u0010.\u001a\u00060 R\u00020\u0000H\u0002¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\b\u0018\u00010 R\u00020\u0000H\u0002¢\u0006\u0004\b1\u0010\"J\u0019\u00102\u001a\u00020\f2\n\u0010.\u001a\u00060 R\u00020\u0000¢\u0006\u0004\b2\u00103J)\u00106\u001a\u00020\u00132\n\u0010.\u001a\u00060 R\u00020\u00002\u0006\u00104\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001¢\u0006\u0004\b6\u00107J\u0010\u00108\u001a\u00020\u0004H\u0082\b¢\u0006\u0004\b8\u0010,J\u0015\u00109\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b9\u0010:J\u0015\u0010<\u001a\u00020\u00132\u0006\u0010;\u001a\u00020\u0004¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\u00132\u0006\u0010>\u001a\u00020\fH\u0002¢\u0006\u0004\b?\u0010@J\r\u0010A\u001a\u00020\u0013¢\u0006\u0004\bA\u0010\u0015J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\fH\u0082\b¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\fH\u0002¢\u0006\u0004\bH\u0010EJ+\u0010I\u001a\u0004\u0018\u00010\n*\b\u0018\u00010 R\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010%\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010JR\u0015\u0010\u0010\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0017R\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010LR\u0015\u0010\u001f\u001a\u00020\u00018Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u0017R\u0014\u0010O\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010Q\u001a\u00020N8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bQ\u0010PR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010RR\u0011\u0010S\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bS\u0010ER\u0014\u0010\u0003\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010LR\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010TR\u001e\u0010V\u001a\f\u0012\b\u0012\u00060 R\u00020\u00000U8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006["}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", HttpUrl.FRAGMENT_ENCODE_SET, "corePoolSize", "maxPoolSize", HttpUrl.FRAGMENT_ENCODE_SET, "idleWorkerKeepAliveNs", HttpUrl.FRAGMENT_ENCODE_SET, "schedulerName", "<init>", "(IIJLjava/lang/String;)V", "Lkotlinx/coroutines/scheduling/Task;", "task", HttpUrl.FRAGMENT_ENCODE_SET, "addToGlobalQueue", "(Lkotlinx/coroutines/scheduling/Task;)Z", "state", "availableCpuPermits", "(J)I", "blockingTasks", HttpUrl.FRAGMENT_ENCODE_SET, "close", "()V", "createNewWorker", "()I", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "createTask", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;)Lkotlinx/coroutines/scheduling/Task;", "createdWorkers", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "currentWorker", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", "decrementBlockingTasks", "decrementCreatedWorkers", "tailDispatch", "dispatch", "(Ljava/lang/Runnable;Lkotlinx/coroutines/scheduling/TaskContext;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "incrementBlockingTasks", "()J", "incrementCreatedWorkers", "worker", "parkedWorkersStackNextIndex", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)I", "parkedWorkersStackPop", "parkedWorkersStackPush", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;)Z", "oldIndex", "newIndex", "parkedWorkersStackTopUpdate", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;II)V", "releaseCpuPermit", "runSafely", "(Lkotlinx/coroutines/scheduling/Task;)V", "timeout", "shutdown", "(J)V", "skipUnpark", "signalBlockingWork", "(Z)V", "signalCpuWork", "toString", "()Ljava/lang/String;", "tryAcquireCpuPermit", "()Z", "tryCreateWorker", "(J)Z", "tryUnpark", "submitToLocalQueue", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "getAvailableCpuPermits", "I", "getCreatedWorkers", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalBlockingQueue", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "globalCpuQueue", "J", "isTerminated", "Ljava/lang/String;", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "workers", "Lkotlinx/coroutines/internal/ResizableAtomicArray;", "Companion", "Worker", "WorkerState", "kotlinx-coroutines-core", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;
    volatile /* synthetic */ long controlState;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f25660k;
    public final int l;
    public final long m;
    public final String n;
    public final GlobalQueue o;
    public final GlobalQueue p;
    private volatile /* synthetic */ long parkedWorkersStack;
    public final ResizableAtomicArray<c> q;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25655f = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Symbol f25659j = new Symbol("NOT_IN_STACK");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f25656g = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ AtomicLongFieldUpdater f25657h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f25658i = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* JADX INFO: renamed from: kotlinx.coroutines.c3.a$a */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "BLOCKING_MASK", HttpUrl.FRAGMENT_ENCODE_SET, "BLOCKING_SHIFT", HttpUrl.FRAGMENT_ENCODE_SET, "CLAIMED", "CPU_PERMITS_MASK", "CPU_PERMITS_SHIFT", "CREATED_MASK", "MAX_SUPPORTED_POOL_SIZE", "MIN_SUPPORTED_POOL_SIZE", "NOT_IN_STACK", "Lkotlinx/coroutines/internal/Symbol;", "PARKED", "PARKED_INDEX_MASK", "PARKED_VERSION_INC", "PARKED_VERSION_MASK", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.c3.a$b */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            a = iArr;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.c3.a$d */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.f25660k = i2;
        this.l = i3;
        this.m = j2;
        this.n = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.o = new GlobalQueue();
        this.p = new GlobalQueue();
        this.parkedWorkersStack = 0L;
        this.q = new ResizableAtomicArray<>(i2 + 1);
        this.controlState = ((long) i2) << 42;
        this._isTerminated = 0;
    }

    private final void A(boolean z) {
        long jAddAndGet = f25657h.addAndGet(this, 2097152L);
        if (z || J() || H(jAddAndGet)) {
            return;
        }
        J();
    }

    private final Task D(c cVar, Task task, boolean z) {
        if (cVar == null || cVar.f25663h == d.TERMINATED) {
            return task;
        }
        if (task.f25680g.getA() == 0 && cVar.f25663h == d.BLOCKING) {
            return task;
        }
        cVar.l = true;
        return cVar.f25662g.a(task, z);
    }

    private final boolean H(long j2) {
        if (l.b(((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21)), 0) < this.f25660k) {
            int iB = b();
            if (iB == 1 && this.f25660k > 1) {
                b();
            }
            if (iB > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean I(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.H(j2);
    }

    private final boolean J() {
        c cVarK;
        do {
            cVarK = k();
            if (cVarK == null) {
                return false;
            }
        } while (!c.f25661f.compareAndSet(cVarK, -1, 0));
        LockSupport.unpark(cVarK);
        return true;
    }

    private final boolean a(Task task) {
        return task.f25680g.getA() == 1 ? this.p.a(task) : this.o.a(task);
    }

    private final int b() {
        synchronized (this.q) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int iB = l.b(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iB >= this.f25660k) {
                return 0;
            }
            if (i2 >= this.l) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i3 > 0 && this.q.b(i3) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(this, i3);
            this.q.c(i3, cVar);
            if (!(i3 == ((int) (2097151 & f25657h.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return iB + 1;
        }
    }

    private final c d() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !m.a(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void f(CoroutineScheduler coroutineScheduler, Runnable runnable, TaskContext taskContext, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            taskContext = l.f25686f;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.e(runnable, taskContext, z);
    }

    private final int j(c cVar) {
        Object nextParkedWorker = cVar.getNextParkedWorker();
        while (nextParkedWorker != f25659j) {
            if (nextParkedWorker == null) {
                return 0;
            }
            c cVar2 = (c) nextParkedWorker;
            int indexInArray = cVar2.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = cVar2.getNextParkedWorker();
        }
        return -1;
    }

    private final c k() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            c cVarB = this.q.b((int) (2097151 & j2));
            if (cVarB == null) {
                return null;
            }
            long j3 = (2097152 + j2) & (-2097152);
            int iJ = j(cVarB);
            if (iJ >= 0 && f25656g.compareAndSet(this, j2, ((long) iJ) | j3)) {
                cVarB.p(f25659j);
                return cVarB;
            }
        }
    }

    public final void B() {
        if (J() || I(this, 0L, 1, null)) {
            return;
        }
        J();
    }

    public final Task c(Runnable runnable, TaskContext taskContext) {
        long jA = l.f25685e.a();
        if (!(runnable instanceof Task)) {
            return new TaskImpl(runnable, jA, taskContext);
        }
        Task task = (Task) runnable;
        task.f25679f = jA;
        task.f25680g = taskContext;
        return task;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        z(10000L);
    }

    public final void e(Runnable runnable, TaskContext taskContext, boolean z) {
        if (kotlinx.coroutines.c.a() != null) {
            throw null;
        }
        Task taskC = c(runnable, taskContext);
        c cVarD = d();
        Task taskD = D(cVarD, taskC, z);
        if (taskD != null && !a(taskD)) {
            throw new RejectedExecutionException(this.n + " was terminated");
        }
        boolean z2 = z && cVarD != null;
        if (taskC.f25680g.getA() != 0) {
            A(z2);
        } else {
            if (z2) {
                return;
            }
            B();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        f(this, command, null, false, 6, null);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean l(c cVar) {
        long j2;
        long j3;
        int indexInArray;
        if (cVar.getNextParkedWorker() != f25659j) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            int i2 = (int) (2097151 & j2);
            j3 = (2097152 + j2) & (-2097152);
            indexInArray = cVar.getIndexInArray();
            if (s0.a()) {
                if (!(indexInArray != 0)) {
                    throw new AssertionError();
                }
            }
            cVar.p(this.q.b(i2));
        } while (!f25656g.compareAndSet(this, j2, ((long) indexInArray) | j3));
        return true;
    }

    public final void m(c cVar, int i2, int i3) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iJ = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (iJ == i2) {
                iJ = i3 == 0 ? j(cVar) : i3;
            }
            if (iJ >= 0 && f25656g.compareAndSet(this, j2, j3 | ((long) iJ))) {
                return;
            }
        }
    }

    public final void p(Task task) {
        try {
            task.run();
            if (kotlinx.coroutines.c.a() != null) {
                throw null;
            }
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
                if (kotlinx.coroutines.c.a() != null) {
                    throw null;
                }
            } catch (Throwable th2) {
                if (kotlinx.coroutines.c.a() == null) {
                    throw th2;
                }
                throw null;
            }
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.q.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            c cVarB = this.q.b(i7);
            if (cVarB != null) {
                int iF = cVarB.f25662g.f();
                int i8 = b.a[cVarB.f25663h.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iF);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i8 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i8 == 4) {
                    i5++;
                    if (iF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iF);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.n + '@' + t0.b(this) + "[Pool Size {core = " + this.f25660k + ", max = " + this.l + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.o.c() + ", global blocking queue size = " + this.p.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.f25660k - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    public final void z(long j2) throws InterruptedException {
        int i2;
        Task taskD;
        if (f25658i.compareAndSet(this, 0, 1)) {
            c cVarD = d();
            synchronized (this.q) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    c cVarB = this.q.b(i3);
                    m.c(cVarB);
                    c cVar = cVarB;
                    if (cVar != cVarD) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j2);
                        }
                        d dVar = cVar.f25663h;
                        if (s0.a()) {
                            if (!(dVar == d.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        cVar.f25662g.g(this.p);
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.p.b();
            this.o.b();
            while (true) {
                if (cVarD == null) {
                    taskD = this.o.d();
                    if (taskD == null && (taskD = this.p.d()) == null) {
                        break;
                    }
                } else {
                    taskD = cVarD.f(true);
                    if (taskD == null) {
                        taskD = this.o.d();
                        if (taskD == null) {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
                p(taskD);
            }
            if (cVarD != null) {
                cVarD.s(d.TERMINATED);
            }
            if (s0.a()) {
                if (!(((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.f25660k)) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.c3.a$c */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\b\u0080\u0004\u0018\u00002\u00020GB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u001cJ\u000f\u0010 \u001a\u00020\u0007H\u0002¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b!\u0010\u0017J\u000f\u0010\"\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010\u001cJ\u0015\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u000b2\u0006\u0010'\u001a\u00020\u000fH\u0002¢\u0006\u0004\b(\u0010\u0012J\u000f\u0010)\u001a\u00020\u0007H\u0002¢\u0006\u0004\b)\u0010\u001cR*\u0010*\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00018\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\tR\u0014\u00100\u001a\u00020/8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00102\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0016\u0010>\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010+R\u0012\u0010B\u001a\u00020?8Æ\u0002¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010E\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u00106¨\u0006F"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$Worker;", HttpUrl.FRAGMENT_ENCODE_SET, "index", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "taskMode", HttpUrl.FRAGMENT_ENCODE_SET, "afterTask", "(I)V", "beforeTask", "Lkotlinx/coroutines/scheduling/Task;", "task", "executeTask", "(Lkotlinx/coroutines/scheduling/Task;)V", HttpUrl.FRAGMENT_ENCODE_SET, "scanLocalQueue", "findAnyTask", "(Z)Lkotlinx/coroutines/scheduling/Task;", "findTask", "mode", "idleReset", "inStack", "()Z", "upperBound", "nextInt", "(I)I", "park", "()V", "pollGlobalQueues", "()Lkotlinx/coroutines/scheduling/Task;", "run", "runWorker", "tryAcquireCpuPermit", "tryPark", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "tryReleaseCpu", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "blockingOnly", "trySteal", "tryTerminateWorker", "indexInArray", "I", "getIndexInArray", "()I", "setIndexInArray", "Lkotlinx/coroutines/scheduling/WorkQueue;", "localQueue", "Lkotlinx/coroutines/scheduling/WorkQueue;", "mayHaveLocalTasks", "Z", HttpUrl.FRAGMENT_ENCODE_SET, "minDelayUntilStealableTaskNs", "J", HttpUrl.FRAGMENT_ENCODE_SET, "nextParkedWorker", "Ljava/lang/Object;", "getNextParkedWorker", "()Ljava/lang/Object;", "setNextParkedWorker", "(Ljava/lang/Object;)V", "rngState", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "getScheduler", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "scheduler", "state", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "terminationDeadline", "kotlinx-coroutines-core", "Ljava/lang/Thread;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class c extends Thread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        static final /* synthetic */ AtomicIntegerFieldUpdater f25661f = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final WorkQueue f25662g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public d f25663h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private long f25664i;
        private volatile int indexInArray;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f25665j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f25666k;
        public boolean l;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            setDaemon(true);
            this.f25662g = new WorkQueue();
            this.f25663h = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f25659j;
            this.f25666k = Random.f22952f.c();
        }

        private final void b(int i2) {
            if (i2 == 0) {
                return;
            }
            CoroutineScheduler.f25657h.addAndGet(CoroutineScheduler.this, -2097152L);
            d dVar = this.f25663h;
            if (dVar != d.TERMINATED) {
                if (s0.a()) {
                    if (!(dVar == d.BLOCKING)) {
                        throw new AssertionError();
                    }
                }
                this.f25663h = d.DORMANT;
            }
        }

        private final void c(int i2) {
            if (i2 != 0 && s(d.BLOCKING)) {
                CoroutineScheduler.this.B();
            }
        }

        private final void d(Task task) {
            int a = task.f25680g.getA();
            i(a);
            c(a);
            CoroutineScheduler.this.p(task);
            b(a);
        }

        private final Task e(boolean z) {
            Task taskM;
            Task taskM2;
            if (z) {
                boolean z2 = k(CoroutineScheduler.this.f25660k * 2) == 0;
                if (z2 && (taskM2 = m()) != null) {
                    return taskM2;
                }
                Task taskH = this.f25662g.h();
                if (taskH != null) {
                    return taskH;
                }
                if (!z2 && (taskM = m()) != null) {
                    return taskM;
                }
            } else {
                Task taskM3 = m();
                if (taskM3 != null) {
                    return taskM3;
                }
            }
            return t(false);
        }

        private final void i(int i2) {
            this.f25664i = 0L;
            if (this.f25663h == d.PARKING) {
                if (s0.a()) {
                    if (!(i2 == 1)) {
                        throw new AssertionError();
                    }
                }
                this.f25663h = d.BLOCKING;
            }
        }

        private final boolean j() {
            return this.nextParkedWorker != CoroutineScheduler.f25659j;
        }

        private final void l() {
            if (this.f25664i == 0) {
                this.f25664i = System.nanoTime() + CoroutineScheduler.this.m;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.m);
            if (System.nanoTime() - this.f25664i >= 0) {
                this.f25664i = 0L;
                u();
            }
        }

        private final Task m() {
            if (k(2) == 0) {
                Task taskD = CoroutineScheduler.this.o.d();
                return taskD != null ? taskD : CoroutineScheduler.this.p.d();
            }
            Task taskD2 = CoroutineScheduler.this.p.d();
            return taskD2 != null ? taskD2 : CoroutineScheduler.this.o.d();
        }

        private final void n() {
            loop0: while (true) {
                boolean z = false;
                while (true) {
                    if (CoroutineScheduler.this.isTerminated() || this.f25663h == d.TERMINATED) {
                        break loop0;
                    }
                    Task taskF = f(this.l);
                    if (taskF != null) {
                        this.f25665j = 0L;
                        d(taskF);
                        break;
                    }
                    this.l = false;
                    if (this.f25665j == 0) {
                        r();
                    } else {
                        if (z) {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f25665j);
                            this.f25665j = 0L;
                            break;
                        }
                        z = true;
                    }
                }
            }
            s(d.TERMINATED);
        }

        private final boolean q() {
            boolean z;
            if (this.f25663h != d.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j2 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j2) >> 42)) == 0) {
                        z = false;
                        break;
                    }
                    if (CoroutineScheduler.f25657h.compareAndSet(coroutineScheduler, j2, j2 - 4398046511104L)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    return false;
                }
                this.f25663h = d.CPU_ACQUIRED;
            }
            return true;
        }

        private final void r() {
            if (!j()) {
                CoroutineScheduler.this.l(this);
                return;
            }
            if (s0.a()) {
                if (!(this.f25662g.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.f25663h != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        private final Task t(boolean z) {
            if (s0.a()) {
                if (!(this.f25662g.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int i2 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i2 < 2) {
                return null;
            }
            int iK = k(i2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                iK++;
                if (iK > i2) {
                    iK = 1;
                }
                c cVarB = coroutineScheduler.q.b(iK);
                if (cVarB != null && cVarB != this) {
                    if (s0.a()) {
                        if (!(this.f25662g.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    long jK = z ? this.f25662g.k(cVarB.f25662g) : this.f25662g.l(cVarB.f25662g);
                    if (jK == -1) {
                        return this.f25662g.h();
                    }
                    if (jK > 0) {
                        jMin = Math.min(jMin, jK);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f25665j = jMin;
            return null;
        }

        private final void u() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.q) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.f25660k) {
                    return;
                }
                if (f25661f.compareAndSet(this, -1, 1)) {
                    int i2 = this.indexInArray;
                    o(0);
                    coroutineScheduler.m(this, i2, 0);
                    int andDecrement = (int) (2097151 & CoroutineScheduler.f25657h.getAndDecrement(coroutineScheduler));
                    if (andDecrement != i2) {
                        c cVarB = coroutineScheduler.q.b(andDecrement);
                        m.c(cVarB);
                        c cVar = cVarB;
                        coroutineScheduler.q.c(i2, cVar);
                        cVar.o(i2);
                        coroutineScheduler.m(cVar, andDecrement, i2);
                    }
                    coroutineScheduler.q.c(andDecrement, null);
                    u uVar = u.a;
                    this.f25663h = d.TERMINATED;
                }
            }
        }

        public final Task f(boolean z) {
            Task taskD;
            if (q()) {
                return e(z);
            }
            if (!z || (taskD = this.f25662g.h()) == null) {
                taskD = CoroutineScheduler.this.p.d();
            }
            return taskD == null ? t(true) : taskD;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final int getIndexInArray() {
            return this.indexInArray;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final int k(int i2) {
            int i3 = this.f25666k;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f25666k = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Integer.MAX_VALUE) % i2;
        }

        public final void o(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.n);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.f25663h;
            boolean z = dVar2 == d.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.f25657h.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f25663h = dVar;
            }
            return z;
        }

        public c(CoroutineScheduler coroutineScheduler, int i2) {
            this();
            o(i2);
        }
    }
}
