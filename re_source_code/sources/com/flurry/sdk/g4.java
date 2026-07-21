package com.flurry.sdk;

import java.util.TimerTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g4 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static Runnable f10784f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final String f10785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final g4 f10786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected final boolean f10787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final boolean f10788j;

    static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public class b extends FutureTask<Void> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final g4 f10789f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private TimerTask f10790g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f10791h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f10792i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final int f10793j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f10794k;

        b(g4 g4Var, Runnable runnable) {
            super(runnable, null);
            this.f10791h = 0;
            this.f10792i = 1;
            this.f10793j = 2;
            this.f10789f = g4Var;
            if (runnable == g4.f10784f) {
                this.f10794k = 0;
            } else {
                this.f10794k = 1;
            }
        }

        public final synchronized boolean a() {
            return this.f10794k == 0;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
        public synchronized boolean cancel(boolean z) {
            super.cancel(z);
            TimerTask timerTask = this.f10790g;
            if (timerTask != null) {
                timerTask.cancel();
            }
            return true;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public synchronized void run() {
            if (this.f10794k != 1) {
                super.run();
                return;
            }
            this.f10794k = 2;
            if (!this.f10789f.p(this)) {
                this.f10789f.o(this);
            }
            this.f10794k = 1;
        }
    }

    g4(String str, g4 g4Var, boolean z) {
        this(str, g4Var, z, g4Var == null ? false : g4Var.f10788j);
    }

    protected abstract void k(Runnable runnable);

    protected void l(Runnable runnable) {
    }

    protected abstract Future<Void> m(Runnable runnable);

    protected abstract void n(Runnable runnable) throws CancellationException;

    protected final boolean o(Runnable runnable) {
        for (g4 g4Var = this.f10786h; g4Var != null; g4Var = g4Var.f10786h) {
            if (g4Var.p(runnable)) {
                return true;
            }
        }
        runnable.run();
        return true;
    }

    protected abstract boolean p(Runnable runnable);

    private g4(String str, g4 g4Var, boolean z, boolean z2) {
        this.f10785g = str;
        this.f10786h = g4Var;
        this.f10787i = z;
        this.f10788j = z2;
    }
}
