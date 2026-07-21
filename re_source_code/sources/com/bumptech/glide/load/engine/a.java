package com.bumptech.glide.load.engine;

import android.os.Process;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: ActiveResources.java */
/* JADX INFO: loaded from: classes.dex */
final class a {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f9045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<com.bumptech.glide.load.f, d> f9046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReferenceQueue<p<?>> f9047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p.a f9048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f9049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile c f9050g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActiveResources.java */
    class ThreadFactoryC0123a implements ThreadFactory {

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ActiveResources.java */
        class RunnableC0124a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Runnable f9051f;

            RunnableC0124a(Runnable runnable) {
                this.f9051f = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                Process.setThreadPriority(10);
                this.f9051f.run();
            }
        }

        ThreadFactoryC0123a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(new RunnableC0124a(runnable), "glide-active-resources");
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    interface c {
        void a();
    }

    /* JADX INFO: compiled from: ActiveResources.java */
    static final class d extends WeakReference<p<?>> {
        final com.bumptech.glide.load.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f9054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        u<?> f9055c;

        d(com.bumptech.glide.load.f fVar, p<?> pVar, ReferenceQueue<? super p<?>> referenceQueue, boolean z) {
            super(pVar, referenceQueue);
            this.a = (com.bumptech.glide.load.f) com.bumptech.glide.r.j.d(fVar);
            this.f9055c = (pVar.f() && z) ? (u) com.bumptech.glide.r.j.d(pVar.b()) : null;
            this.f9054b = pVar.f();
        }

        void a() {
            this.f9055c = null;
            clear();
        }
    }

    a(boolean z) {
        this(z, Executors.newSingleThreadExecutor(new ThreadFactoryC0123a()));
    }

    synchronized void a(com.bumptech.glide.load.f fVar, p<?> pVar) {
        d dVarPut = this.f9046c.put(fVar, new d(fVar, pVar, this.f9047d, this.a));
        if (dVarPut != null) {
            dVarPut.a();
        }
    }

    void b() {
        while (!this.f9049f) {
            try {
                c((d) this.f9047d.remove());
                c cVar = this.f9050g;
                if (cVar != null) {
                    cVar.a();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    void c(d dVar) {
        u<?> uVar;
        synchronized (this.f9048e) {
            synchronized (this) {
                this.f9046c.remove(dVar.a);
                if (dVar.f9054b && (uVar = dVar.f9055c) != null) {
                    p<?> pVar = new p<>(uVar, true, false);
                    pVar.h(dVar.a, this.f9048e);
                    this.f9048e.d(dVar.a, pVar);
                }
            }
        }
    }

    synchronized void d(com.bumptech.glide.load.f fVar) {
        d dVarRemove = this.f9046c.remove(fVar);
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }

    synchronized p<?> e(com.bumptech.glide.load.f fVar) {
        d dVar = this.f9046c.get(fVar);
        if (dVar == null) {
            return null;
        }
        p<?> pVar = dVar.get();
        if (pVar == null) {
            c(dVar);
        }
        return pVar;
    }

    void f(p.a aVar) {
        synchronized (aVar) {
            synchronized (this) {
                this.f9048e = aVar;
            }
        }
    }

    a(boolean z, Executor executor) {
        this.f9046c = new HashMap();
        this.f9047d = new ReferenceQueue<>();
        this.a = z;
        this.f9045b = executor;
        executor.execute(new b());
    }
}
