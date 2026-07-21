package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e6 extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ zzik f17747e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e6(zzik zzikVar, s4 s4Var) {
        super(s4Var);
        this.f17747e = zzikVar;
    }

    @Override // com.google.android.gms.measurement.internal.f
    public final void b() {
        this.f17747e.h().K().a("Tasks have been queued for a long time");
    }
}
