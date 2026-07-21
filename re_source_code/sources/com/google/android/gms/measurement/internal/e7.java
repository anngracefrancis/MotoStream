package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e7 extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzkc f17748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzjy f17749f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e7(zzjy zzjyVar, s4 s4Var, zzkc zzkcVar) {
        super(s4Var);
        this.f17749f = zzjyVar;
        this.f17748e = zzkcVar;
    }

    @Override // com.google.android.gms.measurement.internal.f
    public final void b() {
        this.f17749f.x();
        this.f17749f.h().P().a("Starting upload from DelayedRunnable");
        this.f17748e.d0();
    }
}
