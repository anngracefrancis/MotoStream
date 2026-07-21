package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public final class zzse {
    private final ExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private m30<? extends zzsh> f16712b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IOException f16713c;

    public zzse(String str) {
        this.a = zzsy.h(str);
    }

    public final boolean a() {
        return this.f16712b != null;
    }

    public final <T extends zzsh> long b(T t, zzsf<T> zzsfVar, int i2) {
        Looper looperMyLooper = Looper.myLooper();
        zzsk.e(looperMyLooper != null);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new m30(this, looperMyLooper, t, zzsfVar, i2, jElapsedRealtime).d(0L);
        return jElapsedRealtime;
    }

    public final void f(Runnable runnable) {
        m30<? extends zzsh> m30Var = this.f16712b;
        if (m30Var != null) {
            m30Var.e(true);
        }
        this.a.execute(runnable);
        this.a.shutdown();
    }

    public final void h(int i2) throws IOException {
        IOException iOException = this.f16713c;
        if (iOException != null) {
            throw iOException;
        }
        m30<? extends zzsh> m30Var = this.f16712b;
        if (m30Var != null) {
            m30Var.c(m30Var.f12953h);
        }
    }

    public final void i() {
        this.f16712b.e(false);
    }
}
