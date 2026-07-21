package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class cn implements zzban<zzbvx> {
    private final /* synthetic */ zzbws a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcqd f12433b;

    cn(zzcqd zzcqdVar, zzbws zzbwsVar) {
        this.f12433b = zzcqdVar;
        this.a = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        synchronized (this.f12433b) {
            zzcqd.i7(this.f12433b, null);
            this.a.b().onAdFailedToLoad(zzcgm.b(th));
            zzcya.a(th, "InterstitialAdManagerShim.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbvx zzbvxVar) {
        zzbvx zzbvxVar2 = zzbvxVar;
        synchronized (this.f12433b) {
            zzcqd.i7(this.f12433b, null);
            this.f12433b.n = zzbvxVar2;
            zzbvxVar2.c();
        }
    }
}
