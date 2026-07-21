package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class w30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f13493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzto f13494i;

    w30(zzto zztoVar, String str, long j2, long j3) {
        this.f13494i = zztoVar;
        this.f13491f = str;
        this.f13492g = j2;
        this.f13493h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13494i.f16775b.g(this.f13491f, this.f13492g, this.f13493h);
    }
}
