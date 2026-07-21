package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class vl implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzced f13459f;

    private vl(zzced zzcedVar) {
        this.f13459f = zzcedVar;
    }

    static Runnable a(zzced zzcedVar) {
        return new vl(zzcedVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13459f.b();
    }
}
