package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DelegatingScheduledFuture.java */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"RestrictedApi"})
class x<V> extends c.f.a.a<V> implements ScheduledFuture<V> {
    private final ScheduledFuture<?> m;

    /* JADX INFO: compiled from: DelegatingScheduledFuture.java */
    class a implements b<V> {
        a() {
        }

        @Override // com.google.firebase.concurrent.x.b
        public void a(Throwable th) {
            x.this.M(th);
        }

        @Override // com.google.firebase.concurrent.x.b
        public void set(V v) {
            x.this.L(v);
        }
    }

    /* JADX INFO: compiled from: DelegatingScheduledFuture.java */
    interface b<T> {
        void a(Throwable th);

        void set(T t);
    }

    /* JADX INFO: compiled from: DelegatingScheduledFuture.java */
    interface c<T> {
        ScheduledFuture<?> a(b<T> bVar);
    }

    x(c<V> cVar) {
        this.m = cVar.a(new a());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public int compareTo(Delayed delayed) {
        return this.m.compareTo(delayed);
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.m.getDelay(timeUnit);
    }

    @Override // c.f.a.a
    protected void u() {
        this.m.cancel(O());
    }
}
