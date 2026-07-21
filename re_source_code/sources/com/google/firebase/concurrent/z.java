package com.google.firebase.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: SequentialExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
final class z implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f18972f = Logger.getLogger(z.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f18973g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Deque<Runnable> f18974h = new ArrayDeque();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f18975i = c.IDLE;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f18976j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b f18977k = new b(this, null);

    /* JADX INFO: compiled from: SequentialExecutor.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Runnable f18978f;

        a(Runnable runnable) {
            this.f18978f = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18978f.run();
        }

        public String toString() {
            return this.f18978f.toString();
        }
    }

    /* JADX INFO: compiled from: SequentialExecutor.java */
    private final class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Runnable f18980f;

        private b() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
        
            if (r1 == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
        
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004c, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0054, code lost:
        
            r8.f18980f.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
        
            com.google.firebase.concurrent.z.f18972f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r8.f18980f, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x007c, code lost:
        
            r8.f18980f = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x007e, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a() {
            /*
                r8 = this;
                r0 = 0
                r1 = 0
            L2:
                com.google.firebase.concurrent.z r2 = com.google.firebase.concurrent.z.this     // Catch: java.lang.Throwable -> L82
                java.util.Deque r2 = com.google.firebase.concurrent.z.a(r2)     // Catch: java.lang.Throwable -> L82
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L82
                if (r0 != 0) goto L2b
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.z$c r0 = com.google.firebase.concurrent.z.b(r0)     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.z$c r3 = com.google.firebase.concurrent.z.c.RUNNING     // Catch: java.lang.Throwable -> L7f
                if (r0 != r3) goto L20
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L1f
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L1f:
                return
            L20:
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.z.d(r0)     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.z.c(r0, r3)     // Catch: java.lang.Throwable -> L7f
                r0 = 1
            L2b:
                com.google.firebase.concurrent.z r3 = com.google.firebase.concurrent.z.this     // Catch: java.lang.Throwable -> L7f
                java.util.Deque r3 = com.google.firebase.concurrent.z.a(r3)     // Catch: java.lang.Throwable -> L7f
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L7f
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L7f
                r8.f18980f = r3     // Catch: java.lang.Throwable -> L7f
                if (r3 != 0) goto L4d
                com.google.firebase.concurrent.z r0 = com.google.firebase.concurrent.z.this     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.z$c r3 = com.google.firebase.concurrent.z.c.IDLE     // Catch: java.lang.Throwable -> L7f
                com.google.firebase.concurrent.z.c(r0, r3)     // Catch: java.lang.Throwable -> L7f
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                if (r1 == 0) goto L4c
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
            L4c:
                return
            L4d:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L82
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r8.f18980f     // Catch: java.lang.Throwable -> L5c java.lang.RuntimeException -> L5e
                r3.run()     // Catch: java.lang.Throwable -> L5c java.lang.RuntimeException -> L5e
            L59:
                r8.f18980f = r2     // Catch: java.lang.Throwable -> L82
                goto L2
            L5c:
                r0 = move-exception
                goto L7c
            L5e:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.concurrent.z.e()     // Catch: java.lang.Throwable -> L5c
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5c
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c
                r6.<init>()     // Catch: java.lang.Throwable -> L5c
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L5c
                java.lang.Runnable r7 = r8.f18980f     // Catch: java.lang.Throwable -> L5c
                r6.append(r7)     // Catch: java.lang.Throwable -> L5c
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5c
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5c
                goto L59
            L7c:
                r8.f18980f = r2     // Catch: java.lang.Throwable -> L82
                throw r0     // Catch: java.lang.Throwable -> L82
            L7f:
                r0 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L7f
                throw r0     // Catch: java.lang.Throwable -> L82
            L82:
                r0 = move-exception
                if (r1 == 0) goto L8c
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L8c:
                goto L8e
            L8d:
                throw r0
            L8e:
                goto L8d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.z.b.a():void");
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a();
            } catch (Error e2) {
                synchronized (z.this.f18974h) {
                    z.this.f18975i = c.IDLE;
                    throw e2;
                }
            }
        }

        public String toString() {
            Runnable runnable = this.f18980f;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + z.this.f18975i + "}";
        }

        /* synthetic */ b(z zVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SequentialExecutor.java */
    enum c {
        IDLE,
        QUEUING,
        QUEUED,
        RUNNING
    }

    z(Executor executor) {
        this.f18973g = (Executor) Preconditions.k(executor);
    }

    static /* synthetic */ long d(z zVar) {
        long j2 = zVar.f18976j;
        zVar.f18976j = 1 + j2;
        return j2;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c cVar;
        Preconditions.k(runnable);
        synchronized (this.f18974h) {
            c cVar2 = this.f18975i;
            if (cVar2 != c.RUNNING && cVar2 != (cVar = c.QUEUED)) {
                long j2 = this.f18976j;
                a aVar = new a(runnable);
                this.f18974h.add(aVar);
                c cVar3 = c.QUEUING;
                this.f18975i = cVar3;
                boolean z = true;
                try {
                    this.f18973g.execute(this.f18977k);
                    if (this.f18975i != cVar3) {
                        return;
                    }
                    synchronized (this.f18974h) {
                        if (this.f18976j == j2 && this.f18975i == cVar3) {
                            this.f18975i = cVar;
                        }
                    }
                    return;
                } catch (Error | RuntimeException e2) {
                    synchronized (this.f18974h) {
                        c cVar4 = this.f18975i;
                        if ((cVar4 != c.IDLE && cVar4 != c.QUEUING) || !this.f18974h.removeLastOccurrence(aVar)) {
                            z = false;
                        }
                        if (!(e2 instanceof RejectedExecutionException) || z) {
                            throw e2;
                        }
                    }
                    return;
                }
            }
            this.f18974h.add(runnable);
        }
    }

    public String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f18973g + "}";
    }
}
