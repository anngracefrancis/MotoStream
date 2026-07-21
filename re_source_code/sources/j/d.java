package j;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public class d extends e0 {
    public static final a Companion = new a(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static d head;
    private boolean inQueue;
    private d next;
    private long timeoutAt;

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(d dVar) {
            synchronized (d.class) {
                if (!dVar.inQueue) {
                    return false;
                }
                dVar.inQueue = false;
                for (d dVar2 = d.head; dVar2 != null; dVar2 = dVar2.next) {
                    if (dVar2.next == dVar) {
                        dVar2.next = dVar.next;
                        dVar.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(d dVar, long j2, boolean z) {
            synchronized (d.class) {
                if (!(!dVar.inQueue)) {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
                dVar.inQueue = true;
                if (d.head == null) {
                    d.head = new d();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j2 != 0 && z) {
                    dVar.timeoutAt = Math.min(j2, dVar.deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (j2 != 0) {
                    dVar.timeoutAt = j2 + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    dVar.timeoutAt = dVar.deadlineNanoTime();
                }
                long jRemainingNanos = dVar.remainingNanos(jNanoTime);
                d dVar2 = d.head;
                kotlin.jvm.internal.m.c(dVar2);
                while (dVar2.next != null) {
                    d dVar3 = dVar2.next;
                    kotlin.jvm.internal.m.c(dVar3);
                    if (jRemainingNanos < dVar3.remainingNanos(jNanoTime)) {
                        break;
                    }
                    dVar2 = dVar2.next;
                    kotlin.jvm.internal.m.c(dVar2);
                }
                dVar.next = dVar2.next;
                dVar2.next = dVar;
                if (dVar2 == d.head) {
                    d.class.notify();
                }
                kotlin.u uVar = kotlin.u.a;
            }
        }

        public final d c() throws InterruptedException {
            d dVar = d.head;
            kotlin.jvm.internal.m.c(dVar);
            d dVar2 = dVar.next;
            if (dVar2 == null) {
                long jNanoTime = System.nanoTime();
                d.class.wait(d.IDLE_TIMEOUT_MILLIS);
                d dVar3 = d.head;
                kotlin.jvm.internal.m.c(dVar3);
                if (dVar3.next != null || System.nanoTime() - jNanoTime < d.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return d.head;
            }
            long jRemainingNanos = dVar2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                long j2 = jRemainingNanos / 1000000;
                d.class.wait(j2, (int) (jRemainingNanos - (1000000 * j2)));
                return null;
            }
            d dVar4 = d.head;
            kotlin.jvm.internal.m.c(dVar4);
            dVar4.next = dVar2.next;
            dVar2.next = null;
            return dVar2;
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    private static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            d dVarC;
            while (true) {
                try {
                    synchronized (d.class) {
                        try {
                            dVarC = d.Companion.c();
                            if (dVarC == d.head) {
                                d.head = null;
                                return;
                            }
                            kotlin.u uVar = kotlin.u.a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (dVarC != null) {
                        dVarC.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class c implements b0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b0 f22828g;

        c(b0 b0Var) {
            this.f22828g = b0Var;
        }

        @Override // j.b0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d timeout() {
            return d.this;
        }

        @Override // j.b0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            d dVar = d.this;
            dVar.enter();
            try {
                try {
                    this.f22828g.close();
                    kotlin.u uVar = kotlin.u.a;
                    if (dVar.exit()) {
                        throw dVar.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!dVar.exit()) {
                        throw e2;
                    }
                    throw dVar.access$newTimeoutException(e2);
                }
            } catch (Throwable th) {
                dVar.exit();
                throw th;
            }
        }

        @Override // j.b0, java.io.Flushable
        public void flush() throws IOException {
            d dVar = d.this;
            dVar.enter();
            try {
                try {
                    this.f22828g.flush();
                    kotlin.u uVar = kotlin.u.a;
                    if (dVar.exit()) {
                        throw dVar.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!dVar.exit()) {
                        throw e2;
                    }
                    throw dVar.access$newTimeoutException(e2);
                }
            } catch (Throwable th) {
                dVar.exit();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f22828g + ')';
        }

        @Override // j.b0
        public void write(f fVar, long j2) throws IOException {
            kotlin.jvm.internal.m.f(fVar, "source");
            j.c.b(fVar.size(), 0L, j2);
            while (true) {
                long j3 = 0;
                if (j2 <= 0) {
                    return;
                }
                y yVar = fVar.f22831f;
                kotlin.jvm.internal.m.c(yVar);
                while (j3 < d.TIMEOUT_WRITE_SIZE) {
                    j3 += (long) (yVar.f22880d - yVar.f22879c);
                    if (j3 >= j2) {
                        j3 = j2;
                        break;
                    } else {
                        yVar = yVar.f22883g;
                        kotlin.jvm.internal.m.c(yVar);
                    }
                }
                d dVar = d.this;
                dVar.enter();
                try {
                    try {
                        this.f22828g.write(fVar, j3);
                        kotlin.u uVar = kotlin.u.a;
                        if (dVar.exit()) {
                            throw dVar.access$newTimeoutException(null);
                        }
                        j2 -= j3;
                    } catch (IOException e2) {
                        if (!dVar.exit()) {
                            throw e2;
                        }
                        throw dVar.access$newTimeoutException(e2);
                    }
                } catch (Throwable th) {
                    dVar.exit();
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: j.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class C0310d implements d0 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d0 f22830g;

        C0310d(d0 d0Var) {
            this.f22830g = d0Var;
        }

        @Override // j.d0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public d timeout() {
            return d.this;
        }

        @Override // j.d0, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            d dVar = d.this;
            dVar.enter();
            try {
                try {
                    this.f22830g.close();
                    kotlin.u uVar = kotlin.u.a;
                    if (dVar.exit()) {
                        throw dVar.access$newTimeoutException(null);
                    }
                } catch (IOException e2) {
                    if (!dVar.exit()) {
                        throw e2;
                    }
                    throw dVar.access$newTimeoutException(e2);
                }
            } catch (Throwable th) {
                dVar.exit();
                throw th;
            }
        }

        @Override // j.d0
        public long read(f fVar, long j2) throws IOException {
            kotlin.jvm.internal.m.f(fVar, "sink");
            d dVar = d.this;
            dVar.enter();
            try {
                try {
                    long j3 = this.f22830g.read(fVar, j2);
                    if (dVar.exit()) {
                        throw dVar.access$newTimeoutException(null);
                    }
                    return j3;
                } catch (IOException e2) {
                    if (dVar.exit()) {
                        throw dVar.access$newTimeoutException(e2);
                    }
                    throw e2;
                }
            } catch (Throwable th) {
                dVar.exit();
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f22830g + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j2) {
        return this.timeoutAt - j2;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            Companion.e(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.d(this);
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final b0 sink(b0 b0Var) {
        kotlin.jvm.internal.m.f(b0Var, "sink");
        return new c(b0Var);
    }

    public final d0 source(d0 d0Var) {
        kotlin.jvm.internal.m.f(d0Var, "source");
        return new C0310d(d0Var);
    }

    protected void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> function0) throws IOException {
        kotlin.jvm.internal.m.f(function0, "block");
        enter();
        try {
            try {
                T tInvoke = function0.invoke();
                kotlin.jvm.internal.k.b(1);
                if (exit()) {
                    throw access$newTimeoutException(null);
                }
                kotlin.jvm.internal.k.a(1);
                return tInvoke;
            } catch (IOException e2) {
                if (exit()) {
                    throw access$newTimeoutException(e2);
                }
                throw e2;
            }
        } catch (Throwable th) {
            kotlin.jvm.internal.k.b(1);
            exit();
            kotlin.jvm.internal.k.a(1);
            throw th;
        }
    }
}
