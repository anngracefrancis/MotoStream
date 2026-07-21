package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k5 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ boolean f17841f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f17842g;

    k5(zzhc zzhcVar, boolean z) {
        this.f17842g = zzhcVar;
        this.f17841f = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zP = this.f17842g.a.p();
        boolean zO = this.f17842g.a.o();
        this.f17842g.a.n(this.f17841f);
        if (zO == this.f17841f) {
            this.f17842g.a.h().P().b("Default data collection state already set to", Boolean.valueOf(this.f17841f));
        }
        if (this.f17842g.a.p() == zP || this.f17842g.a.p() != this.f17842g.a.o()) {
            this.f17842g.a.h().M().c("Default data collection is different than actual status", Boolean.valueOf(this.f17841f), Boolean.valueOf(zP));
        }
        this.f17842g.l0();
    }
}
