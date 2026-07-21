package com.google.firebase.installations.r;

import com.google.firebase.installations.o;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RequestLimiter.java */
/* JADX INFO: loaded from: classes2.dex */
class e {
    private static final long a = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f19739b = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final o f19740c = o.c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f19741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19742e;

    e() {
    }

    private synchronized long a(int i2) {
        if (!c(i2)) {
            return a;
        }
        double dPow = Math.pow(2.0d, this.f19742e);
        double dE = this.f19740c.e();
        Double.isNaN(dE);
        return (long) Math.min(dPow + dE, f19739b);
    }

    private static boolean c(int i2) {
        return i2 == 429 || (i2 >= 500 && i2 < 600);
    }

    private static boolean d(int i2) {
        return (i2 >= 200 && i2 < 300) || i2 == 401 || i2 == 404;
    }

    private synchronized void e() {
        this.f19742e = 0;
    }

    public synchronized boolean b() {
        return this.f19742e == 0 || this.f19740c.a() > this.f19741d;
    }

    public synchronized void f(int i2) {
        if (d(i2)) {
            e();
            return;
        }
        this.f19742e++;
        this.f19741d = this.f19740c.a() + a(i2);
    }
}
