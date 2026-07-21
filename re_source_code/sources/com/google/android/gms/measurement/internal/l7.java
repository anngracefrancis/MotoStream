package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class l7 implements Callable<String> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzm f17858f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzkc f17859g;

    l7(zzkc zzkcVar, zzm zzmVar) {
        this.f17859g = zzkcVar;
        this.f17858f = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        z3 z3VarT = this.f17859g.T(this.f17858f);
        if (z3VarT != null) {
            return z3VarT.x();
        }
        this.f17859g.h().K().a("App info was null when attempting to get app instance id");
        return null;
    }
}
