package com.google.android.gms.measurement.internal;

import android.os.Process;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class x3 extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f18014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<v3<?>> f18015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzfu f18016h;

    public x3(zzfu zzfuVar, String str, BlockingQueue<v3<?>> blockingQueue) {
        this.f18016h = zzfuVar;
        Preconditions.k(str);
        Preconditions.k(blockingQueue);
        this.f18014f = new Object();
        this.f18015g = blockingQueue;
        setName(str);
    }

    private final void b(InterruptedException interruptedException) {
        this.f18016h.h().K().b(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    public final void a() {
        synchronized (this.f18014f) {
            this.f18014f.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z = false;
        while (!z) {
            try {
                this.f18016h.f18152k.acquire();
                z = true;
            } catch (InterruptedException e2) {
                b(e2);
            }
        }
        try {
            int threadPriority = Process.getThreadPriority(Process.myTid());
            while (true) {
                v3<?> v3VarPoll = this.f18015g.poll();
                if (v3VarPoll == null) {
                    synchronized (this.f18014f) {
                        if (this.f18015g.peek() == null && !this.f18016h.l) {
                            try {
                                this.f18014f.wait(30000L);
                            } catch (InterruptedException e3) {
                                b(e3);
                            }
                        }
                    }
                    synchronized (this.f18016h.f18151j) {
                        if (this.f18015g.peek() == null) {
                            break;
                        }
                    }
                } else {
                    Process.setThreadPriority(v3VarPoll.f17986g ? threadPriority : 10);
                    v3VarPoll.run();
                }
            }
            synchronized (this.f18016h.f18151j) {
                this.f18016h.f18152k.release();
                this.f18016h.f18151j.notifyAll();
                if (this == this.f18016h.f18145d) {
                    zzfu.u(this.f18016h, null);
                } else if (this == this.f18016h.f18146e) {
                    zzfu.A(this.f18016h, null);
                } else {
                    this.f18016h.h().H().a("Current scheduler thread is neither worker nor network");
                }
            }
        } catch (Throwable th) {
            synchronized (this.f18016h.f18151j) {
                this.f18016h.f18152k.release();
                this.f18016h.f18151j.notifyAll();
                if (this == this.f18016h.f18145d) {
                    zzfu.u(this.f18016h, null);
                } else if (this == this.f18016h.f18146e) {
                    zzfu.A(this.f18016h, null);
                } else {
                    this.f18016h.h().H().a("Current scheduler thread is neither worker nor network");
                }
                throw th;
            }
        }
    }
}
