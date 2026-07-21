package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public class zzbbr<T> implements zzbbh<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private T f14335g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Throwable f14336h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14337i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14338j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f14334f = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c7 f14339k = new c7();

    private final boolean d() {
        return this.f14336h != null || this.f14337i;
    }

    public final void a(T t) {
        synchronized (this.f14334f) {
            if (this.f14338j) {
                return;
            }
            if (d()) {
                zzk.zzlk().h(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.set");
                return;
            }
            this.f14337i = true;
            this.f14335g = t;
            this.f14334f.notifyAll();
            this.f14339k.b();
        }
    }

    public final void c(Throwable th) {
        synchronized (this.f14334f) {
            if (this.f14338j) {
                return;
            }
            if (d()) {
                zzk.zzlk().h(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture.setException");
                return;
            }
            this.f14336h = th;
            this.f14334f.notifyAll();
            this.f14339k.b();
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.f14334f) {
            if (d()) {
                return false;
            }
            this.f14338j = true;
            this.f14337i = true;
            this.f14334f.notifyAll();
            this.f14339k.b();
            return true;
        }
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, CancellationException, InterruptedException {
        T t;
        synchronized (this.f14334f) {
            while (!d()) {
                this.f14334f.wait();
            }
            if (this.f14336h != null) {
                throw new ExecutionException(this.f14336h);
            }
            if (this.f14338j) {
                throw new CancellationException("SettableFuture was cancelled.");
            }
            t = this.f14335g;
        }
        return t;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z;
        synchronized (this.f14334f) {
            z = this.f14338j;
        }
        return z;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        boolean zD;
        synchronized (this.f14334f) {
            zD = d();
        }
        return zD;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void k(Runnable runnable, Executor executor) {
        this.f14339k.a(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws ExecutionException, CancellationException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.f14334f) {
            long millis = timeUnit.toMillis(j2);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j3 = millis + jCurrentTimeMillis;
            while (!d() && jCurrentTimeMillis < j3) {
                this.f14334f.wait(j3 - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            if (!this.f14338j) {
                if (this.f14336h == null) {
                    if (this.f14337i) {
                        t = this.f14335g;
                    } else {
                        throw new TimeoutException("SettableFuture timed out.");
                    }
                } else {
                    throw new ExecutionException(this.f14336h);
                }
            } else {
                throw new CancellationException("SettableFuture was cancelled.");
            }
        }
        return t;
    }
}
