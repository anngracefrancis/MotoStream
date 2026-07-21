package io.sentry.android.core.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: Debouncer.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class n {
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final io.sentry.transport.q f22189b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f22191d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f22190c = new AtomicInteger(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f22192e = new AtomicLong(0);

    public n(io.sentry.transport.q qVar, long j2, int i2) {
        this.f22189b = qVar;
        this.a = j2;
        this.f22191d = i2 <= 0 ? 1 : i2;
    }

    public boolean a() {
        long jA = this.f22189b.a();
        if (this.f22192e.get() == 0 || this.f22192e.get() + this.a <= jA) {
            this.f22190c.set(0);
            this.f22192e.set(jA);
            return false;
        }
        if (this.f22190c.incrementAndGet() < this.f22191d) {
            return false;
        }
        this.f22190c.set(0);
        return true;
    }
}
