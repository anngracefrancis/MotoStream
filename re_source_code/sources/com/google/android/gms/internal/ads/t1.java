package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class t1 implements zzbbt {
    private final /* synthetic */ zzala a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzakh f13341b;

    t1(zzakh zzakhVar, zzala zzalaVar) {
        this.f13341b = zzakhVar;
        this.a = zzalaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbt
    public final void run() {
        synchronized (this.f13341b.a) {
            this.f13341b.f13938h = 1;
            zzawz.m("Failed loading new engine. Marking new engine destroyable.");
            this.a.i();
        }
    }
}
