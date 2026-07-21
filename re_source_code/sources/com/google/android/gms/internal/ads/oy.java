package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class oy implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ int f13126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ boolean f13127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzdy f13128h;

    oy(zzdy zzdyVar, int i2, boolean z) {
        this.f13128h = zzdyVar;
        this.f13126f = i2;
        this.f13127g = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbp.zza zzaVarL = this.f13128h.l(this.f13126f, this.f13127g);
        this.f13128h.f16191k = zzaVarL;
        if (zzdy.h(this.f13126f, zzaVarL)) {
            this.f13128h.e(this.f13126f + 1, this.f13127g);
        }
    }
}
