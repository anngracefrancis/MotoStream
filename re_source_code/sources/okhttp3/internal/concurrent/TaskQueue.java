package okhttp3.internal.concurrent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001?B\u0019\b\u0000\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b=\u0010>J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\rJ?\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u001aJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010(\u001a\u00020'8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00020,8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0019\u00103\u001a\b\u0012\u0004\u0012\u00020\u0002018F@\u0006¢\u0006\u0006\u001a\u0004\b2\u00100R\"\u00104\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u00108R\"\u0010\u001b\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u00105\u001a\u0004\b9\u0010\u001d\"\u0004\b:\u00108R\u001c\u0010\n\u001a\u00020\t8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010;\u001a\u0004\b<\u0010 \u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006@"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue;", HttpUrl.FRAGMENT_ENCODE_SET, "Lokhttp3/internal/concurrent/Task;", "task", HttpUrl.FRAGMENT_ENCODE_SET, "delayNanos", "Lkotlin/u;", "schedule", "(Lokhttp3/internal/concurrent/Task;J)V", HttpUrl.FRAGMENT_ENCODE_SET, "name", "Lkotlin/Function0;", "block", "(Ljava/lang/String;JLkotlin/a0/c/a;)V", HttpUrl.FRAGMENT_ENCODE_SET, "cancelable", "execute", "(Ljava/lang/String;JZLkotlin/a0/c/a;)V", "Ljava/util/concurrent/CountDownLatch;", "idleLatch", "()Ljava/util/concurrent/CountDownLatch;", "recurrence", "scheduleAndDecide$okhttp", "(Lokhttp3/internal/concurrent/Task;JZ)Z", "scheduleAndDecide", "cancelAll", "()V", "shutdown", "cancelAllAndDecide$okhttp", "()Z", "cancelAllAndDecide", "toString", "()Ljava/lang/String;", "activeTask", "Lokhttp3/internal/concurrent/Task;", "getActiveTask$okhttp", "()Lokhttp3/internal/concurrent/Task;", "setActiveTask$okhttp", "(Lokhttp3/internal/concurrent/Task;)V", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", HttpUrl.FRAGMENT_ENCODE_SET, "futureTasks", "Ljava/util/List;", "getFutureTasks$okhttp", "()Ljava/util/List;", HttpUrl.FRAGMENT_ENCODE_SET, "getScheduledTasks", "scheduledTasks", "cancelActiveTask", "Z", "getCancelActiveTask$okhttp", "setCancelActiveTask$okhttp", "(Z)V", "getShutdown$okhttp", "setShutdown$okhttp", "Ljava/lang/String;", "getName$okhttp", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Ljava/lang/String;)V", "AwaitIdleTask", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class TaskQueue {
    private Task activeTask;
    private boolean cancelActiveTask;
    private final List<Task> futureTasks;
    private final String name;
    private boolean shutdown;
    private final TaskRunner taskRunner;

    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lokhttp3/internal/concurrent/TaskQueue$AwaitIdleTask;", "Lokhttp3/internal/concurrent/Task;", HttpUrl.FRAGMENT_ENCODE_SET, "runOnce", "()J", "Ljava/util/concurrent/CountDownLatch;", "latch", "Ljava/util/concurrent/CountDownLatch;", "getLatch", "()Ljava/util/concurrent/CountDownLatch;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class AwaitIdleTask extends Task {
        private final CountDownLatch latch;

        public AwaitIdleTask() {
            super(Util.okHttpName + " awaitIdle", false);
            this.latch = new CountDownLatch(1);
        }

        public final CountDownLatch getLatch() {
            return this.latch;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.latch.countDown();
            return -1L;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", HttpUrl.FRAGMENT_ENCODE_SET, "runOnce", "()J", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass1 extends Task {
        final /* synthetic */ Function0 $block;
        final /* synthetic */ boolean $cancelable;
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function0 function0, String str, boolean z, String str2, boolean z2) {
            super(str2, z2);
            this.$block = function0;
            this.$name = str;
            this.$cancelable = z;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            this.$block.invoke();
            return -1L;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.concurrent.TaskQueue$schedule$2, reason: invalid class name */
    /* JADX INFO: compiled from: TaskQueue.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"okhttp3/internal/concurrent/TaskQueue$schedule$2", "Lokhttp3/internal/concurrent/Task;", HttpUrl.FRAGMENT_ENCODE_SET, "runOnce", "()J", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class AnonymousClass2 extends Task {
        final /* synthetic */ Function0 $block;
        final /* synthetic */ String $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function0 function0, String str, String str2) {
            super(str2, false, 2, null);
            this.$block = function0;
            this.$name = str;
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            return ((Number) this.$block.invoke()).longValue();
        }
    }

    public TaskQueue(TaskRunner taskRunner, String str) {
        m.f(taskRunner, "taskRunner");
        m.f(str, "name");
        this.taskRunner = taskRunner;
        this.name = str;
        this.futureTasks = new ArrayList();
    }

    public static /* synthetic */ void execute$default(TaskQueue taskQueue, String str, long j2, boolean z, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        boolean z2 = (i2 & 4) != 0 ? true : z;
        m.f(str, "name");
        m.f(function0, "block");
        taskQueue.schedule(new AnonymousClass1(function0, str, z2, str, z2), j2);
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, Task task, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        taskQueue.schedule(task, j2);
    }

    public final void cancelAll() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                u uVar = u.a;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        m.e(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public final boolean cancelAllAndDecide$okhttp() {
        Task task = this.activeTask;
        if (task != null) {
            m.c(task);
            if (task.getCancelable()) {
                this.cancelActiveTask = true;
            }
        }
        boolean z = false;
        for (int size = this.futureTasks.size() - 1; size >= 0; size--) {
            if (this.futureTasks.get(size).getCancelable()) {
                Task task2 = this.futureTasks.get(size);
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task2, this, "canceled");
                }
                this.futureTasks.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void execute(String name, long delayNanos, boolean cancelable, Function0<u> block) {
        m.f(name, "name");
        m.f(block, "block");
        schedule(new AnonymousClass1(block, name, cancelable, name, cancelable), delayNanos);
    }

    /* JADX INFO: renamed from: getActiveTask$okhttp, reason: from getter */
    public final Task getActiveTask() {
        return this.activeTask;
    }

    /* JADX INFO: renamed from: getCancelActiveTask$okhttp, reason: from getter */
    public final boolean getCancelActiveTask() {
        return this.cancelActiveTask;
    }

    public final List<Task> getFutureTasks$okhttp() {
        return this.futureTasks;
    }

    /* JADX INFO: renamed from: getName$okhttp, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final List<Task> getScheduledTasks() {
        List<Task> listE0;
        synchronized (this.taskRunner) {
            listE0 = c0.E0(this.futureTasks);
        }
        return listE0;
    }

    /* JADX INFO: renamed from: getShutdown$okhttp, reason: from getter */
    public final boolean getShutdown() {
        return this.shutdown;
    }

    /* JADX INFO: renamed from: getTaskRunner$okhttp, reason: from getter */
    public final TaskRunner getTaskRunner() {
        return this.taskRunner;
    }

    public final CountDownLatch idleLatch() {
        synchronized (this.taskRunner) {
            if (this.activeTask == null && this.futureTasks.isEmpty()) {
                return new CountDownLatch(0);
            }
            Task task = this.activeTask;
            if (task instanceof AwaitIdleTask) {
                return ((AwaitIdleTask) task).getLatch();
            }
            for (Task task2 : this.futureTasks) {
                if (task2 instanceof AwaitIdleTask) {
                    return ((AwaitIdleTask) task2).getLatch();
                }
            }
            AwaitIdleTask awaitIdleTask = new AwaitIdleTask();
            if (scheduleAndDecide$okhttp(awaitIdleTask, 0L, false)) {
                this.taskRunner.kickCoordinator$okhttp(this);
            }
            return awaitIdleTask.getLatch();
        }
    }

    public final void schedule(Task task, long delayNanos) {
        m.f(task, "task");
        synchronized (this.taskRunner) {
            if (!this.shutdown) {
                if (scheduleAndDecide$okhttp(task, delayNanos, false)) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                u uVar = u.a;
            } else if (task.getCancelable()) {
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean scheduleAndDecide$okhttp(Task task, long delayNanos, boolean recurrence) {
        String str;
        m.f(task, "task");
        task.initQueue$okhttp(this);
        long jNanoTime = this.taskRunner.getBackend().nanoTime();
        long j2 = jNanoTime + delayNanos;
        int iIndexOf = this.futureTasks.indexOf(task);
        if (iIndexOf != -1) {
            if (task.getNextExecuteNanoTime() <= j2) {
                if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
                    TaskLoggerKt.log(task, this, "already scheduled");
                }
                return false;
            }
            this.futureTasks.remove(iIndexOf);
        }
        task.setNextExecuteNanoTime$okhttp(j2);
        if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
            if (recurrence) {
                str = "run again after " + TaskLoggerKt.formatDuration(j2 - jNanoTime);
            } else {
                str = "scheduled after " + TaskLoggerKt.formatDuration(j2 - jNanoTime);
            }
            TaskLoggerKt.log(task, this, str);
        }
        Iterator<Task> it = this.futureTasks.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (it.next().getNextExecuteNanoTime() - jNanoTime > delayNanos) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.futureTasks.size();
        }
        this.futureTasks.add(size, task);
        return size == 0;
    }

    public final void setActiveTask$okhttp(Task task) {
        this.activeTask = task;
    }

    public final void setCancelActiveTask$okhttp(boolean z) {
        this.cancelActiveTask = z;
    }

    public final void setShutdown$okhttp(boolean z) {
        this.shutdown = z;
    }

    public final void shutdown() {
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            synchronized (this.taskRunner) {
                this.shutdown = true;
                if (cancelAllAndDecide$okhttp()) {
                    this.taskRunner.kickCoordinator$okhttp(this);
                }
                u uVar = u.a;
            }
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        m.e(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST NOT hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public String toString() {
        return this.name;
    }

    public static /* synthetic */ void schedule$default(TaskQueue taskQueue, String str, long j2, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 0;
        }
        m.f(str, "name");
        m.f(function0, "block");
        taskQueue.schedule(new AnonymousClass2(function0, str, str), j2);
    }

    public final void schedule(String name, long delayNanos, Function0<Long> block) {
        m.f(name, "name");
        m.f(block, "block");
        schedule(new AnonymousClass2(block, name, name), delayNanos);
    }
}
