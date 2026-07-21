package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjg implements zzbro, zzbsr {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f15288f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f15289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzcjm f15290h;

    public zzcjg(zzcjm zzcjmVar) {
        this.f15290h = zzcjmVar;
    }

    private static void a() {
        synchronized (f15288f) {
            f15289g++;
        }
    }

    private static boolean b() {
        boolean z;
        synchronized (f15288f) {
            z = f15289g < ((Integer) zzyt.e().c(zzacu.b5)).intValue();
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i2) {
        if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue() && b()) {
            this.f15290h.g(false);
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue() && b()) {
            this.f15290h.g(true);
            a();
        }
    }
}
