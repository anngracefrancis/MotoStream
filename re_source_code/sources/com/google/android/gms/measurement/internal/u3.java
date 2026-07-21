package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzfx f17973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzet f17974g;

    u3(zzfn zzfnVar, zzfx zzfxVar, zzet zzetVar) {
        this.f17973f = zzfxVar;
        this.f17974g = zzetVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f17973f.E() == null) {
            this.f17974g.H().a("Install Referrer Reporter is null");
            return;
        }
        zzfm zzfmVarE = this.f17973f.E();
        zzfmVarE.a.r();
        zzfmVarE.b(zzfmVarE.a.f().getPackageName());
    }
}
