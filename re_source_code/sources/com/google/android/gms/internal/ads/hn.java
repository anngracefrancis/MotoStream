package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class hn implements zzban<zzcdb> {
    private final /* synthetic */ zzcdf a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcqj f12721b;

    hn(zzcqj zzcqjVar, zzcdf zzcdfVar) {
        this.f12721b = zzcqjVar;
        this.a = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        synchronized (this.f12721b) {
            zzcqj.i7(this.f12721b, null);
            this.a.b().onAdFailedToLoad(zzcgm.b(th));
            zzcya.a(th, "NonagonRewardedVideoAdImpl.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzcdb zzcdbVar) {
        zzcdb zzcdbVar2 = zzcdbVar;
        synchronized (this.f12721b) {
            zzcqj.i7(this.f12721b, null);
            this.f12721b.f15548g = zzcdbVar2;
            zzcdbVar2.c();
        }
    }
}
