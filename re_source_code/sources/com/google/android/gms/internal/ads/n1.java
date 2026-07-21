package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class n1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzajw f13011f;

    private n1(zzajw zzajwVar) {
        this.f13011f = zzajwVar;
    }

    static Runnable a(zzajw zzajwVar) {
        return new n1(zzajwVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13011f.destroy();
    }
}
