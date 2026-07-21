package io.sentry.android.core;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.SystemClock;
import io.sentry.s4;
import io.sentry.w1;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ANRWatchDog.java */
/* JADX INFO: loaded from: classes2.dex */
final class e0 extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f22108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f22109g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c1 f22110h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final io.sentry.transport.q f22111i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f22112j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final long f22113k;
    private final w1 l;
    private volatile long m;
    private final AtomicBoolean n;
    private final Context o;
    private final Runnable p;

    /* JADX INFO: compiled from: ANRWatchDog.java */
    public interface a {
        void a(ApplicationNotResponding applicationNotResponding);
    }

    e0(long j2, boolean z, a aVar, w1 w1Var, Context context) {
        this(new io.sentry.transport.q() { // from class: io.sentry.android.core.a
            @Override // io.sentry.transport.q
            public final long a() {
                return SystemClock.uptimeMillis();
            }
        }, j2, 500L, z, aVar, w1Var, new c1(), context);
    }

    private boolean a() {
        ActivityManager activityManager = (ActivityManager) this.o.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = null;
        try {
            processesInErrorState = activityManager.getProcessesInErrorState();
        } catch (Throwable th) {
            this.l.b(s4.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", th);
        }
        if (processesInErrorState == null) {
            return false;
        }
        Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
        while (it.hasNext()) {
            if (it.next().condition == 2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(io.sentry.transport.q qVar) {
        this.m = qVar.a();
        this.n.set(false);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.p.run();
        while (!isInterrupted()) {
            this.f22110h.b(this.p);
            try {
                Thread.sleep(this.f22112j);
                if (this.f22111i.a() - this.m > this.f22113k) {
                    if (!this.f22108f && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                        this.l.c(s4.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                        this.n.set(true);
                    } else if (a() && this.n.compareAndSet(false, true)) {
                        this.f22109g.a(new ApplicationNotResponding("Application Not Responding for at least " + this.f22113k + " ms.", this.f22110h.a()));
                    }
                }
            } catch (InterruptedException e2) {
                try {
                    Thread.currentThread().interrupt();
                    this.l.c(s4.WARNING, "Interrupted: %s", e2.getMessage());
                    return;
                } catch (SecurityException unused) {
                    this.l.c(s4.WARNING, "Failed to interrupt due to SecurityException: %s", e2.getMessage());
                    return;
                }
            }
        }
    }

    e0(final io.sentry.transport.q qVar, long j2, long j3, boolean z, a aVar, w1 w1Var, c1 c1Var, Context context) {
        super("|ANR-WatchDog|");
        this.m = 0L;
        this.n = new AtomicBoolean(false);
        this.f22111i = qVar;
        this.f22113k = j2;
        this.f22112j = j3;
        this.f22108f = z;
        this.f22109g = aVar;
        this.l = w1Var;
        this.f22110h = c1Var;
        this.o = context;
        this.p = new Runnable() { // from class: io.sentry.android.core.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f22092f.d(qVar);
            }
        };
        if (j2 < j3 * 2) {
            throw new IllegalArgumentException(String.format("ANRWatchDog: timeoutIntervalMillis has to be at least %d ms", Long.valueOf(this.f22112j * 2)));
        }
    }
}
