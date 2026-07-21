package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: TransactionExecutor.java */
/* JADX INFO: loaded from: classes.dex */
class r implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Executor f2204f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque<Runnable> f2205g = new ArrayDeque<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Runnable f2206h;

    /* JADX INFO: compiled from: TransactionExecutor.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f2207f;

        a(Runnable runnable) {
            this.f2207f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f2207f.run();
            } finally {
                r.this.a();
            }
        }
    }

    r(Executor executor) {
        this.f2204f = executor;
    }

    synchronized void a() {
        Runnable runnablePoll = this.f2205g.poll();
        this.f2206h = runnablePoll;
        if (runnablePoll != null) {
            this.f2204f.execute(runnablePoll);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f2205g.offer(new a(runnable));
        if (this.f2206h == null) {
            a();
        }
    }
}
