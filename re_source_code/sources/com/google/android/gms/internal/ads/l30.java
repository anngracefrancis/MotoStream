package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class l30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f12911g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzr f12912h;

    l30(zzr zzrVar, String str, long j2) {
        this.f12912h = zzrVar;
        this.f12910f = str;
        this.f12911g = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12912h.f16633f.a(this.f12910f, this.f12911g);
        this.f12912h.f16633f.b(this.f12912h.toString());
    }
}
