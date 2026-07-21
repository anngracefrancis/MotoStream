package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class l<T> {
    public static Executor a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread f8543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<h<T>> f8544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<h<Throwable>> f8545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f8546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FutureTask<k<T>> f8547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile k<T> f8548g;

    /* JADX INFO: compiled from: LottieTask.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.this.f8548g == null || l.this.f8547f.isCancelled()) {
                return;
            }
            k kVar = l.this.f8548g;
            if (kVar.b() != null) {
                l.this.k(kVar.b());
            } else {
                l.this.i(kVar.a());
            }
        }
    }

    /* JADX INFO: compiled from: LottieTask.java */
    class b extends Thread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f8550f;

        b(String str) {
            super(str);
            this.f8550f = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!isInterrupted() && !this.f8550f) {
                if (l.this.f8547f.isDone()) {
                    try {
                        l lVar = l.this;
                        lVar.n((k) lVar.f8547f.get());
                    } catch (InterruptedException | ExecutionException e2) {
                        l.this.n(new k(e2));
                    }
                    this.f8550f = true;
                    l.this.p();
                }
            }
        }
    }

    public l(Callable<k<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f8545d);
        if (arrayList.isEmpty()) {
            Log.w("LOTTIE", "Lottie encountered an error but no failure listener was added.", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(th);
        }
    }

    private void j() {
        this.f8546e.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(T t) {
        Iterator it = new ArrayList(this.f8544c).iterator();
        while (it.hasNext()) {
            ((h) it.next()).a(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(k<T> kVar) {
        if (this.f8548g != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f8548g = kVar;
        j();
    }

    private synchronized void o() {
        if (!q() && this.f8548g == null) {
            b bVar = new b("LottieTaskObserver");
            this.f8543b = bVar;
            bVar.start();
            c.b("Starting TaskObserver thread");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void p() {
        if (q()) {
            if (this.f8544c.isEmpty() || this.f8548g != null) {
                this.f8543b.interrupt();
                this.f8543b = null;
                c.b("Stopping TaskObserver thread");
            }
        }
    }

    private boolean q() {
        Thread thread = this.f8543b;
        return thread != null && thread.isAlive();
    }

    public synchronized l<T> g(h<Throwable> hVar) {
        if (this.f8548g != null && this.f8548g.a() != null) {
            hVar.a(this.f8548g.a());
        }
        this.f8545d.add(hVar);
        o();
        return this;
    }

    public synchronized l<T> h(h<T> hVar) {
        if (this.f8548g != null && this.f8548g.b() != null) {
            hVar.a(this.f8548g.b());
        }
        this.f8544c.add(hVar);
        o();
        return this;
    }

    public synchronized l<T> l(h<Throwable> hVar) {
        this.f8545d.remove(hVar);
        p();
        return this;
    }

    public synchronized l<T> m(h<T> hVar) {
        this.f8544c.remove(hVar);
        p();
        return this;
    }

    l(Callable<k<T>> callable, boolean z) {
        this.f8544c = new LinkedHashSet(1);
        this.f8545d = new LinkedHashSet(1);
        this.f8546e = new Handler(Looper.getMainLooper());
        this.f8548g = null;
        FutureTask<k<T>> futureTask = new FutureTask<>(callable);
        this.f8547f = futureTask;
        if (!z) {
            a.execute(futureTask);
            o();
        } else {
            try {
                n(callable.call());
            } catch (Throwable th) {
                n(new k<>(th));
            }
        }
    }
}
