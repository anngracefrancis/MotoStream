package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class r1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzajw f13251f;

    private r1(zzajw zzajwVar) {
        this.f13251f = zzajwVar;
    }

    static Runnable a(zzajw zzajwVar) {
        return new r1(zzajwVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13251f.destroy();
    }
}
