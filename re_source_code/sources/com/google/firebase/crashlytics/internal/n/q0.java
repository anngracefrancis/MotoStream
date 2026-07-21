package com.google.firebase.crashlytics.internal.n;

import android.annotation.SuppressLint;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    private static final ExecutorService a = g0.c("awaitEvenIfOnMainThread task continuation executor");

    public static <T> T a(Task<T> task) throws InterruptedException, TimeoutException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        task.g(a, new Continuation() { // from class: com.google.firebase.crashlytics.h.n.i
            @Override // com.google.android.gms.tasks.Continuation
            public final Object a(Task task2) throws Exception {
                q0.d(countDownLatch, task2);
                return null;
            }
        });
        if (Looper.getMainLooper() == Looper.myLooper()) {
            countDownLatch.await(3L, TimeUnit.SECONDS);
        } else {
            countDownLatch.await(4L, TimeUnit.SECONDS);
        }
        if (task.n()) {
            return task.j();
        }
        if (task.l()) {
            throw new CancellationException("Task is already canceled");
        }
        if (task.m()) {
            throw new IllegalStateException(task.i());
        }
        throw new TimeoutException();
    }

    public static boolean b(CountDownLatch countDownLatch, long j2, TimeUnit timeUnit) {
        boolean zAwait;
        boolean z = false;
        try {
            long nanos = timeUnit.toNanos(j2);
            long jNanoTime = System.nanoTime() + nanos;
            while (true) {
                try {
                    zAwait = countDownLatch.await(nanos, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                    nanos = jNanoTime - System.nanoTime();
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return zAwait;
        } catch (Throwable th) {
            if (z) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static <T> Task<T> c(final Executor executor, final Callable<Task<T>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: com.google.firebase.crashlytics.h.n.k
            @Override // java.lang.Runnable
            public final void run() {
                q0.f(callable, executor, taskCompletionSource);
            }
        });
        return taskCompletionSource.a();
    }

    static /* synthetic */ Object d(CountDownLatch countDownLatch, Task task) throws Exception {
        countDownLatch.countDown();
        return null;
    }

    static /* synthetic */ Object e(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.n()) {
            taskCompletionSource.c(task.j());
            return null;
        }
        if (task.i() == null) {
            return null;
        }
        taskCompletionSource.b(task.i());
        return null;
    }

    static /* synthetic */ void f(Callable callable, Executor executor, final TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).g(executor, new Continuation() { // from class: com.google.firebase.crashlytics.h.n.j
                @Override // com.google.android.gms.tasks.Continuation
                public final Object a(Task task) throws Exception {
                    q0.e(taskCompletionSource, task);
                    return null;
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.b(e2);
        }
    }

    static /* synthetic */ Void g(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.n()) {
            taskCompletionSource.e(task.j());
            return null;
        }
        if (task.i() == null) {
            return null;
        }
        taskCompletionSource.d(task.i());
        return null;
    }

    static /* synthetic */ Void h(TaskCompletionSource taskCompletionSource, Task task) throws Exception {
        if (task.n()) {
            taskCompletionSource.e(task.j());
            return null;
        }
        if (task.i() == null) {
            return null;
        }
        taskCompletionSource.d(task.i());
        return null;
    }

    @SuppressLint({"TaskMainThread"})
    public static <T> Task<T> i(Task<T> task, Task<T> task2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Continuation<T, TContinuationResult> continuation = new Continuation() { // from class: com.google.firebase.crashlytics.h.n.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object a(Task task3) throws Exception {
                q0.g(taskCompletionSource, task3);
                return null;
            }
        };
        task.f(continuation);
        task2.f(continuation);
        return taskCompletionSource.a();
    }

    public static <T> Task<T> j(Executor executor, Task<T> task, Task<T> task2) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Continuation<T, TContinuationResult> continuation = new Continuation() { // from class: com.google.firebase.crashlytics.h.n.g
            @Override // com.google.android.gms.tasks.Continuation
            public final Object a(Task task3) throws Exception {
                q0.h(taskCompletionSource, task3);
                return null;
            }
        };
        task.g(executor, continuation);
        task2.g(executor, continuation);
        return taskCompletionSource.a();
    }
}
