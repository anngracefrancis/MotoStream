package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class dn implements zzban<zzcdb> {
    private final /* synthetic */ zzcdf a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcqf f12481b;

    dn(zzcqf zzcqfVar, zzcdf zzcdfVar) {
        this.f12481b = zzcqfVar;
        this.a = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        synchronized (this.f12481b) {
            zzcqf.i7(this.f12481b, null);
            this.a.b().onAdFailedToLoad(zzcgm.b(th));
            zzcya.a(th, "NonagonRewardedAdImpl.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzcdb zzcdbVar) {
        zzcdb zzcdbVar2 = zzcdbVar;
        synchronized (this.f12481b) {
            zzcqf.i7(this.f12481b, null);
            this.f12481b.f15542g = zzcdbVar2;
            zzcdbVar2.c();
        }
    }
}
