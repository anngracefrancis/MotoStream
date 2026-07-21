package io.sentry.android.core;

import android.os.SystemClock;
import io.sentry.f4;
import io.sentry.u4;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AppStartState.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class q0 {
    private static q0 a = new q0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f22252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Long f22253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f22254d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f4 f22255e;

    private q0() {
    }

    public static q0 e() {
        return a;
    }

    public f4 a() {
        Long lB;
        f4 f4VarD = d();
        if (f4VarD == null || (lB = b()) == null) {
            return null;
        }
        return new u4(f4VarD.x() + io.sentry.a1.h(lB.longValue()));
    }

    public synchronized Long b() {
        Long l;
        if (this.f22252b != null && (l = this.f22253c) != null && this.f22254d != null) {
            long jLongValue = l.longValue() - this.f22252b.longValue();
            if (jLongValue >= 60000) {
                return null;
            }
            return Long.valueOf(jLongValue);
        }
        return null;
    }

    public Long c() {
        return this.f22252b;
    }

    public f4 d() {
        return this.f22255e;
    }

    public Boolean f() {
        return this.f22254d;
    }

    synchronized void g() {
        h(SystemClock.uptimeMillis());
    }

    void h(long j2) {
        this.f22253c = Long.valueOf(j2);
    }

    synchronized void i(long j2, f4 f4Var) {
        if (this.f22255e == null || this.f22252b == null) {
            this.f22255e = f4Var;
            this.f22252b = Long.valueOf(j2);
        }
    }

    synchronized void j(boolean z) {
        if (this.f22254d != null) {
            return;
        }
        this.f22254d = Boolean.valueOf(z);
    }
}
