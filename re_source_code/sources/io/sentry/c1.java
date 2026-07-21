package io.sentry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DefaultTransactionPerformanceCollector.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class c1 implements u5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<r1> f22314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x4 f22315e;
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Timer f22312b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, List<k3>> f22313c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f22316f = new AtomicBoolean(false);

    /* JADX INFO: compiled from: DefaultTransactionPerformanceCollector.java */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Iterator it = c1.this.f22314d.iterator();
            while (it.hasNext()) {
                ((r1) it.next()).setup();
            }
        }
    }

    /* JADX INFO: compiled from: DefaultTransactionPerformanceCollector.java */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            k3 k3Var = new k3();
            Iterator it = c1.this.f22314d.iterator();
            while (it.hasNext()) {
                ((r1) it.next()).a(k3Var);
            }
            Iterator it2 = c1.this.f22313c.values().iterator();
            while (it2.hasNext()) {
                ((List) it2.next()).add(k3Var);
            }
        }
    }

    public c1(x4 x4Var) {
        this.f22315e = (x4) io.sentry.util.q.c(x4Var, "The options object is required.");
        this.f22314d = x4Var.getCollectors();
    }

    @Override // io.sentry.u5
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<k3> f(e2 e2Var) {
        List<k3> listRemove = this.f22313c.remove(e2Var.k().toString());
        this.f22315e.getLogger().c(s4.DEBUG, "stop collecting performance info for transactions %s (%s)", e2Var.getName(), e2Var.m().k().toString());
        if (this.f22313c.isEmpty() && this.f22316f.getAndSet(false)) {
            synchronized (this.a) {
                if (this.f22312b != null) {
                    this.f22312b.cancel();
                    this.f22312b = null;
                }
            }
        }
        return listRemove;
    }

    @Override // io.sentry.u5
    public void b(final e2 e2Var) {
        if (this.f22314d.isEmpty()) {
            this.f22315e.getLogger().c(s4.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        if (!this.f22313c.containsKey(e2Var.k().toString())) {
            this.f22313c.put(e2Var.k().toString(), new ArrayList());
            try {
                this.f22315e.getExecutorService().b(new Runnable() { // from class: io.sentry.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f21998f.f(e2Var);
                    }
                }, 30000L);
            } catch (RejectedExecutionException e2) {
                this.f22315e.getLogger().b(s4.ERROR, "Failed to call the executor. Performance collector will not be automatically finished. Did you call Sentry.close()?", e2);
            }
        }
        if (this.f22316f.getAndSet(true)) {
            return;
        }
        synchronized (this.a) {
            if (this.f22312b == null) {
                this.f22312b = new Timer(true);
            }
            this.f22312b.schedule(new a(), 0L);
            this.f22312b.scheduleAtFixedRate(new b(), 100L, 100L);
        }
    }

    @Override // io.sentry.u5
    public void close() {
        this.f22313c.clear();
        this.f22315e.getLogger().c(s4.DEBUG, "stop collecting all performance info for transactions", new Object[0]);
        if (this.f22316f.getAndSet(false)) {
            synchronized (this.a) {
                if (this.f22312b != null) {
                    this.f22312b.cancel();
                    this.f22312b = null;
                }
            }
        }
    }
}
