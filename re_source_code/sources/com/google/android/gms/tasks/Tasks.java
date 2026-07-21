package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
public final class Tasks {
    private Tasks() {
    }

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.i();
        Preconditions.l(task, "Task must not be null");
        if (task.m()) {
            return (TResult) h(task);
        }
        a aVar = new a(null);
        i(task, aVar);
        aVar.a();
        return (TResult) h(task);
    }

    public static <TResult> TResult b(Task<TResult> task, long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.i();
        Preconditions.l(task, "Task must not be null");
        Preconditions.l(timeUnit, "TimeUnit must not be null");
        if (task.m()) {
            return (TResult) h(task);
        }
        a aVar = new a(null);
        i(task, aVar);
        if (aVar.d(j2, timeUnit)) {
            return (TResult) h(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @Deprecated
    public static <TResult> Task<TResult> c(Executor executor, Callable<TResult> callable) {
        Preconditions.l(executor, "Executor must not be null");
        Preconditions.l(callable, "Callback must not be null");
        x xVar = new x();
        executor.execute(new y(xVar, callable));
        return xVar;
    }

    public static <TResult> Task<TResult> d(Exception exc) {
        x xVar = new x();
        xVar.q(exc);
        return xVar;
    }

    public static <TResult> Task<TResult> e(TResult tresult) {
        x xVar = new x();
        xVar.r(tresult);
        return xVar;
    }

    public static Task<Void> f(Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return e(null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        x xVar = new x();
        c cVar = new c(collection.size(), xVar);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            i(it2.next(), cVar);
        }
        return xVar;
    }

    public static Task<Void> g(Task<?>... taskArr) {
        return (taskArr == null || taskArr.length == 0) ? e(null) : f(Arrays.asList(taskArr));
    }

    private static Object h(Task task) throws ExecutionException {
        if (task.n()) {
            return task.j();
        }
        if (task.l()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.i());
    }

    private static void i(Task task, b bVar) {
        Executor executor = TaskExecutors.f18310b;
        task.e(executor, bVar);
        task.d(executor, bVar);
        task.a(executor, bVar);
    }
}
