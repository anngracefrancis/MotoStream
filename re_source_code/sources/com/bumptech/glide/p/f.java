package com.bumptech.glide.p;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.GlideException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: RequestFutureTarget.java */
/* JADX INFO: loaded from: classes.dex */
public class f<R> implements c<R>, g<R> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f9493f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f9494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f9495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f9496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f9497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private R f9498k;
    private d l;
    private boolean m;
    private boolean n;
    private boolean o;
    private GlideException p;

    /* JADX INFO: compiled from: RequestFutureTarget.java */
    static class a {
        a() {
        }

        void a(Object obj) {
            obj.notifyAll();
        }

        void b(Object obj, long j2) throws InterruptedException {
            obj.wait(j2);
        }
    }

    public f(int i2, int i3) {
        this(i2, i3, true, f9493f);
    }

    private synchronized R a(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f9496i && !isDone()) {
            com.bumptech.glide.r.k.a();
        }
        if (this.m) {
            throw new CancellationException();
        }
        if (this.o) {
            throw new ExecutionException(this.p);
        }
        if (this.n) {
            return this.f9498k;
        }
        if (l == null) {
            this.f9497j.b(this, 0L);
        } else if (l.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                this.f9497j.b(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.o) {
            throw new ExecutionException(this.p);
        }
        if (this.m) {
            throw new CancellationException();
        }
        if (!this.n) {
            throw new TimeoutException();
        }
        return this.f9498k;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z) {
        d dVar;
        if (isDone()) {
            return false;
        }
        this.m = true;
        this.f9497j.a(this);
        if (z && (dVar = this.l) != null) {
            dVar.clear();
            this.l = null;
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return a(null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized d getRequest() {
        return this.l;
    }

    @Override // com.bumptech.glide.p.l.i
    public void getSize(com.bumptech.glide.p.l.h hVar) {
        hVar.g(this.f9494g, this.f9495h);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.m;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.m || this.n || this.o;
    }

    @Override // com.bumptech.glide.m.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.p.l.i
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized void onResourceReady(R r, com.bumptech.glide.p.m.d<? super R> dVar) {
    }

    @Override // com.bumptech.glide.m.i
    public void onStart() {
    }

    @Override // com.bumptech.glide.m.i
    public void onStop() {
    }

    @Override // com.bumptech.glide.p.l.i
    public void removeCallback(com.bumptech.glide.p.l.h hVar) {
    }

    @Override // com.bumptech.glide.p.l.i
    public synchronized void setRequest(d dVar) {
        this.l = dVar;
    }

    f(int i2, int i3, boolean z, a aVar) {
        this.f9494g = i2;
        this.f9495h = i3;
        this.f9496i = z;
        this.f9497j = aVar;
    }

    @Override // com.bumptech.glide.p.g
    public synchronized boolean onLoadFailed(GlideException glideException, Object obj, com.bumptech.glide.p.l.i<R> iVar, boolean z) {
        this.o = true;
        this.p = glideException;
        this.f9497j.a(this);
        return false;
    }

    @Override // com.bumptech.glide.p.g
    public synchronized boolean onResourceReady(R r, Object obj, com.bumptech.glide.p.l.i<R> iVar, com.bumptech.glide.load.a aVar, boolean z) {
        this.n = true;
        this.f9498k = r;
        this.f9497j.a(this);
        return false;
    }

    @Override // java.util.concurrent.Future
    public R get(long j2, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return a(Long.valueOf(timeUnit.toMillis(j2)));
    }
}
