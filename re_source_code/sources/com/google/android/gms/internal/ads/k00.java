package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class k00 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzr f12846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzy f12847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f12848h;

    public k00(zzr zzrVar, zzy zzyVar, Runnable runnable) {
        this.f12846f = zzrVar;
        this.f12847g = zzyVar;
        this.f12848h = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12846f.u();
        zzy zzyVar = this.f12847g;
        zzaf zzafVar = zzyVar.f16975c;
        if (zzafVar == null) {
            this.f12846f.F(zzyVar.a);
        } else {
            this.f12846f.H(zzafVar);
        }
        if (this.f12847g.f16976d) {
            this.f12846f.I("intermediate-response");
        } else {
            this.f12846f.J("done");
        }
        Runnable runnable = this.f12848h;
        if (runnable != null) {
            runnable.run();
        }
    }
}
