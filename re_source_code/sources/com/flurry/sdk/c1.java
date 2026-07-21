package com.flurry.sdk;

import com.flurry.sdk.g2;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class c1<T extends g2> {
    private final z0<Object, T> a = new z0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HashMap<T, Object> f10657b = new HashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final HashMap<T, Future<?>> f10658c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadPoolExecutor f10659d;

    final class b extends ThreadPoolExecutor.DiscardPolicy {

        final class a extends f2 {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ g2 f10665h;

            a(g2 g2Var) {
                this.f10665h = g2Var;
            }

            @Override // com.flurry.sdk.f2
            public final void a() {
            }
        }

        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ThreadPoolExecutor.DiscardPolicy, java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            super.rejectedExecution(runnable, threadPoolExecutor);
            g2 g2VarA = c1.a(runnable);
            if (g2VarA == null) {
                return;
            }
            synchronized (c1.this.f10658c) {
                c1.this.f10658c.remove(g2VarA);
            }
            c1.this.b(g2VarA);
            new a(g2VarA).run();
        }
    }

    public c1(String str, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        a aVar = new a(timeUnit, blockingQueue);
        this.f10659d = aVar;
        aVar.setRejectedExecutionHandler(new b());
        aVar.setThreadFactory(new z1(str));
    }

    static /* synthetic */ g2 a(Runnable runnable) {
        if (runnable instanceof b1) {
            return (g2) ((b1) runnable).a();
        }
        if (runnable instanceof g2) {
            return (g2) runnable;
        }
        d1.c(6, "TrackedThreadPoolExecutor", "Unknown runnable class: " + runnable.getClass().getName());
        return null;
    }

    private synchronized void d(Object obj, T t) {
        List<T> listB;
        z0<Object, T> z0Var = this.a;
        if (obj != null && (listB = z0Var.b(obj, false)) != null) {
            listB.remove(t);
            if (listB.size() == 0) {
                z0Var.a.remove(obj);
            }
        }
        this.f10657b.remove(t);
    }

    private synchronized void e(Object obj, T t) {
        this.a.c(obj, t);
        this.f10657b.put(t, obj);
    }

    final synchronized void b(T t) {
        d(this.f10657b.get(t), t);
    }

    public final synchronized void c(Object obj, T t) {
        if (obj == null) {
            return;
        }
        e(obj, t);
        this.f10659d.submit(t);
    }

    final class a extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: com.flurry.sdk.c1$a$a, reason: collision with other inner class name */
        final class C0157a extends f2 {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ g2 f10661h;

            C0157a(g2 g2Var) {
                this.f10661h = g2Var;
            }

            @Override // com.flurry.sdk.f2
            public final void a() {
            }
        }

        final class b extends f2 {

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ g2 f10663h;

            b(g2 g2Var) {
                this.f10663h = g2Var;
            }

            @Override // com.flurry.sdk.f2
            public final void a() {
            }
        }

        a(TimeUnit timeUnit, BlockingQueue blockingQueue) {
            super(0, 5, 5000L, timeUnit, blockingQueue);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.concurrent.ThreadPoolExecutor
        protected final void afterExecute(Runnable runnable, Throwable th) {
            super.afterExecute(runnable, th);
            g2 g2VarA = c1.a(runnable);
            if (g2VarA == null) {
                return;
            }
            synchronized (c1.this.f10658c) {
                c1.this.f10658c.remove(g2VarA);
            }
            c1.this.b(g2VarA);
            new b(g2VarA).run();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        protected final void beforeExecute(Thread thread, Runnable runnable) {
            super.beforeExecute(thread, runnable);
            g2 g2VarA = c1.a(runnable);
            if (g2VarA == null) {
                return;
            }
            new C0157a(g2VarA).run();
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected final <V> RunnableFuture<V> newTaskFor(Runnable runnable, V v) {
            b1 b1Var = new b1(runnable, v);
            synchronized (c1.this.f10658c) {
                c1.this.f10658c.put((T) ((g2) runnable), b1Var);
            }
            return b1Var;
        }

        @Override // java.util.concurrent.AbstractExecutorService
        protected final <V> RunnableFuture<V> newTaskFor(Callable<V> callable) {
            throw new UnsupportedOperationException("Callable not supported");
        }
    }
}
