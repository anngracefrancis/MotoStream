package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzfu extends q4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicLong f18144c = new AtomicLong(Long.MIN_VALUE);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x3 f18145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private x3 f18146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PriorityBlockingQueue<v3<?>> f18147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BlockingQueue<v3<?>> f18148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f18149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f18150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f18151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Semaphore f18152k;
    private volatile boolean l;

    zzfu(zzfx zzfxVar) {
        super(zzfxVar);
        this.f18151j = new Object();
        this.f18152k = new Semaphore(2);
        this.f18147f = new PriorityBlockingQueue<>();
        this.f18148g = new LinkedBlockingQueue();
        this.f18149h = new w3(this, "Thread death: Uncaught exception on worker thread");
        this.f18150i = new w3(this, "Thread death: Uncaught exception on network thread");
    }

    static /* synthetic */ x3 A(zzfu zzfuVar, x3 x3Var) {
        zzfuVar.f18146e = null;
        return null;
    }

    static /* synthetic */ x3 u(zzfu zzfuVar, x3 x3Var) {
        zzfuVar.f18145d = null;
        return null;
    }

    private final void y(v3<?> v3Var) {
        synchronized (this.f18151j) {
            this.f18147f.add(v3Var);
            x3 x3Var = this.f18145d;
            if (x3Var == null) {
                x3 x3Var2 = new x3(this, "Measurement Worker", this.f18147f);
                this.f18145d = x3Var2;
                x3Var2.setUncaughtExceptionHandler(this.f18149h);
                this.f18145d.start();
            } else {
                x3Var.a();
            }
        }
    }

    public final <V> Future<V> B(Callable<V> callable) throws IllegalStateException {
        p();
        Preconditions.k(callable);
        v3<?> v3Var = new v3<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f18145d) {
            v3Var.run();
        } else {
            y(v3Var);
        }
        return v3Var;
    }

    public final void C(Runnable runnable) throws IllegalStateException {
        p();
        Preconditions.k(runnable);
        v3<?> v3Var = new v3<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f18151j) {
            this.f18148g.add(v3Var);
            x3 x3Var = this.f18146e;
            if (x3Var == null) {
                x3 x3Var2 = new x3(this, "Measurement Network", this.f18148g);
                this.f18146e = x3Var2;
                x3Var2.setUncaughtExceptionHandler(this.f18150i);
                this.f18146e.start();
            } else {
                x3Var.a();
            }
        }
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    public final boolean I() {
        return Thread.currentThread() == this.f18145d;
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final void c() {
        if (Thread.currentThread() != this.f18146e) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final void d() {
        if (Thread.currentThread() != this.f18145d) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final boolean s() {
        return false;
    }

    final <T> T v(AtomicReference<T> atomicReference, long j2, String str, Runnable runnable) {
        synchronized (atomicReference) {
            g().z(runnable);
            try {
                atomicReference.wait(15000L);
            } catch (InterruptedException unused) {
                zzev zzevVarK = h().K();
                String strValueOf = String.valueOf(str);
                zzevVarK.a(strValueOf.length() != 0 ? "Interrupted waiting for ".concat(strValueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            zzev zzevVarK2 = h().K();
            String strValueOf2 = String.valueOf(str);
            zzevVarK2.a(strValueOf2.length() != 0 ? "Timed out waiting for ".concat(strValueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    public final <V> Future<V> w(Callable<V> callable) throws IllegalStateException {
        p();
        Preconditions.k(callable);
        v3<?> v3Var = new v3<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f18145d) {
            if (!this.f18147f.isEmpty()) {
                h().K().a("Callable skipped the worker queue.");
            }
            v3Var.run();
        } else {
            y(v3Var);
        }
        return v3Var;
    }

    public final void z(Runnable runnable) throws IllegalStateException {
        p();
        Preconditions.k(runnable);
        y(new v3<>(this, runnable, false, "Task exception on worker thread"));
    }
}
