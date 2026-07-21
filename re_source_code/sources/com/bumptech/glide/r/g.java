package com.bumptech.glide.r;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T, Y> {
    private final Map<T, Y> a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f9550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9552d;

    public g(long j2) {
        this.f9550b = j2;
        this.f9551c = j2;
    }

    private void f() {
        m(this.f9551c);
    }

    public void b() {
        m(0L);
    }

    public synchronized Y g(T t) {
        return this.a.get(t);
    }

    public synchronized long h() {
        return this.f9551c;
    }

    protected int i(Y y) {
        return 1;
    }

    protected void j(T t, Y y) {
    }

    public synchronized Y k(T t, Y y) {
        long jI = i(y);
        if (jI >= this.f9551c) {
            j(t, y);
            return null;
        }
        if (y != null) {
            this.f9552d += jI;
        }
        Y yPut = this.a.put(t, y);
        if (yPut != null) {
            this.f9552d -= (long) i(yPut);
            if (!yPut.equals(y)) {
                j(t, yPut);
            }
        }
        f();
        return yPut;
    }

    public synchronized Y l(T t) {
        Y yRemove;
        yRemove = this.a.remove(t);
        if (yRemove != null) {
            this.f9552d -= (long) i(yRemove);
        }
        return yRemove;
    }

    protected synchronized void m(long j2) {
        while (this.f9552d > j2) {
            Iterator<Map.Entry<T, Y>> it = this.a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f9552d -= (long) i(value);
            T key = next.getKey();
            it.remove();
            j(key, value);
        }
    }
}
