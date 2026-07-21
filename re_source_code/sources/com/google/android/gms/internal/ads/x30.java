package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class x30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzlh f13551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f13552g;

    x30(zzto zztoVar, zzlh zzlhVar) {
        this.f13552g = zztoVar;
        this.f13551f = zzlhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13552g.f16775b.q(this.f13551f);
    }
}
