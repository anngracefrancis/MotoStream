package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class my implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzr f12997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzd f12998g;

    my(zzd zzdVar, zzr zzrVar) {
        this.f12998g = zzdVar;
        this.f12997f = zzrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f12998g.f15812h.put(this.f12997f);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
