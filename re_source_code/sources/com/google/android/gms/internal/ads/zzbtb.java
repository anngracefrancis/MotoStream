package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbtb extends zzbts<zzbtf> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ScheduledExecutorService f14719g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Clock f14720h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f14721i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f14722j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14723k;
    private ScheduledFuture<?> l;

    public zzbtb(ScheduledExecutorService scheduledExecutorService, Clock clock) {
        super(Collections.emptySet());
        this.f14721i = -1L;
        this.f14722j = -1L;
        this.f14723k = false;
        this.f14719g = scheduledExecutorService;
        this.f14720h = clock;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g0() {
        T(me.a);
    }

    private final synchronized void o0(long j2) {
        ScheduledFuture<?> scheduledFuture = this.l;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            this.l.cancel(true);
        }
        this.f14721i = this.f14720h.b() + j2;
        this.l = this.f14719g.schedule(new oe(this), j2, TimeUnit.MILLISECONDS);
    }

    public final synchronized void f0() {
        this.f14723k = false;
        o0(0L);
    }

    public final synchronized void i0(int i2) {
        if (i2 <= 0) {
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(i2);
        if (this.f14723k) {
            long j2 = this.f14722j;
            if (j2 <= 0 || millis >= j2) {
                millis = j2;
            }
            this.f14722j = millis;
            return;
        }
        long jB = this.f14720h.b();
        long j3 = this.f14721i;
        if (jB > j3 || j3 - this.f14720h.b() > millis) {
            o0(millis);
        }
    }

    public final synchronized void onPause() {
        if (!this.f14723k) {
            ScheduledFuture<?> scheduledFuture = this.l;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                this.f14722j = -1L;
            } else {
                this.l.cancel(true);
                this.f14722j = this.f14721i - this.f14720h.b();
            }
            this.f14723k = true;
        }
    }

    public final synchronized void onResume() {
        if (this.f14723k) {
            if (this.f14722j > 0 && this.l.isCancelled()) {
                o0(this.f14722j);
            }
            this.f14723k = false;
        }
    }
}
