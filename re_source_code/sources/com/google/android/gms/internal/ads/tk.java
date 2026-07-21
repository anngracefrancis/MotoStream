package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class tk implements zzban<zzbnf> {
    private final /* synthetic */ zzckv a;

    tk(zzckv zzckvVar) {
        this.a = zzckvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        this.a.f15340d.onAdFailedToLoad(zzcgm.b(th));
        zzcya.a(th, "DelayedBannerAd.onFailure");
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbnf zzbnfVar) {
        zzbnfVar.c();
    }
}
