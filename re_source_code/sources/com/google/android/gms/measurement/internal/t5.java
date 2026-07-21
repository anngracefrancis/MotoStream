package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class t5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzig f17965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzif f17966g;

    t5(zzif zzifVar, zzig zzigVar) {
        this.f17966g = zzifVar;
        this.f17965f = zzigVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17966g.J(this.f17965f, false);
        zzif zzifVar = this.f17966g;
        zzifVar.f18183c = null;
        zzifVar.r().N(null);
    }
}
