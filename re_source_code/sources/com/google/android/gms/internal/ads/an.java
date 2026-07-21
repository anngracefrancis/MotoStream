package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class an implements zzban<zzbnf> {
    private final /* synthetic */ zzboc a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcpt f12261b;

    an(zzcpt zzcptVar, zzboc zzbocVar) {
        this.f12261b = zzcptVar;
        this.a = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        synchronized (this.f12261b) {
            zzcpt.i7(this.f12261b, null);
            this.a.c().onAdFailedToLoad(zzcgm.b(th));
            this.f12261b.l.i0(60);
            zzcya.a(th, "BannerAdManagerShim.onFailure");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(zzbnf zzbnfVar) {
        zzbnf zzbnfVar2 = zzbnfVar;
        synchronized (this.f12261b) {
            zzcpt.i7(this.f12261b, null);
            if (this.f12261b.o != null) {
                this.f12261b.o.a();
            }
            this.f12261b.o = zzbnfVar2;
            this.f12261b.f15523h.removeAllViews();
            this.f12261b.f15523h.addView(zzbnfVar2.i());
            zzbnfVar2.c();
            this.f12261b.l.i0(zzbnfVar2.k());
        }
    }
}
