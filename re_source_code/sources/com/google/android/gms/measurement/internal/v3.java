package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v3<V> extends FutureTask<V> implements Comparable<v3> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f17985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f17986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f17987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzfu f17988i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v3(zzfu zzfuVar, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.f17988i = zzfuVar;
        Preconditions.k(str);
        long andIncrement = zzfu.f18144c.getAndIncrement();
        this.f17985f = andIncrement;
        this.f17987h = str;
        this.f17986g = z;
        if (andIncrement == Long.MAX_VALUE) {
            zzfuVar.h().H().a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(v3 v3Var) {
        v3 v3Var2 = v3Var;
        boolean z = this.f17986g;
        if (z != v3Var2.f17986g) {
            return z ? -1 : 1;
        }
        long j2 = this.f17985f;
        long j3 = v3Var2.f17985f;
        if (j2 < j3) {
            return -1;
        }
        if (j2 > j3) {
            return 1;
        }
        this.f17988i.h().I().b("Two tasks share the same index. index", Long.valueOf(this.f17985f));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.f17988i.h().H().b(this.f17987h, th);
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v3(zzfu zzfuVar, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        this.f17988i = zzfuVar;
        Preconditions.k(str);
        long andIncrement = zzfu.f18144c.getAndIncrement();
        this.f17985f = andIncrement;
        this.f17987h = str;
        this.f17986g = false;
        if (andIncrement == Long.MAX_VALUE) {
            zzfuVar.h().H().a("Tasks index overflow");
        }
    }
}
