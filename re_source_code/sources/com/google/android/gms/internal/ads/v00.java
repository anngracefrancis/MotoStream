package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class v00 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13416g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f13417h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzma f13418i;

    v00(zzma zzmaVar, String str, long j2, long j3) {
        this.f13418i = zzmaVar;
        this.f13415f = str;
        this.f13416g = j2;
        this.f13417h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13418i.f16456b.d(this.f13415f, this.f13416g, this.f13417h);
    }
}
