package io.sentry;

import java.util.Date;

/* JADX INFO: compiled from: SentryNanotimeDate.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v4 extends f4 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Date f22772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f22773g;

    public v4() {
        this(a1.c(), System.nanoTime());
    }

    private long y(v4 v4Var, v4 v4Var2) {
        return v4Var.x() + (v4Var2.f22773g - v4Var.f22773g);
    }

    @Override // io.sentry.f4, java.lang.Comparable
    /* JADX INFO: renamed from: g */
    public int compareTo(f4 f4Var) {
        if (!(f4Var instanceof v4)) {
            return super.compareTo(f4Var);
        }
        v4 v4Var = (v4) f4Var;
        long time = this.f22772f.getTime();
        long time2 = v4Var.f22772f.getTime();
        return time == time2 ? Long.valueOf(this.f22773g).compareTo(Long.valueOf(v4Var.f22773g)) : Long.valueOf(time).compareTo(Long.valueOf(time2));
    }

    @Override // io.sentry.f4
    public long k(f4 f4Var) {
        return f4Var instanceof v4 ? this.f22773g - ((v4) f4Var).f22773g : super.k(f4Var);
    }

    @Override // io.sentry.f4
    public long v(f4 f4Var) {
        if (f4Var == null || !(f4Var instanceof v4)) {
            return super.v(f4Var);
        }
        v4 v4Var = (v4) f4Var;
        return compareTo(f4Var) < 0 ? y(this, v4Var) : y(v4Var, this);
    }

    @Override // io.sentry.f4
    public long x() {
        return a1.a(this.f22772f);
    }

    public v4(Date date, long j2) {
        this.f22772f = date;
        this.f22773g = j2;
    }
}
