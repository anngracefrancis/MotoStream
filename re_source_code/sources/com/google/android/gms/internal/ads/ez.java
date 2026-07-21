package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class ez implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f12548g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12549h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzgr f12550i;

    ez(zzgr zzgrVar, String str, long j2, long j3) {
        this.f12550i = zzgrVar;
        this.f12547f = str;
        this.f12548g = j2;
        this.f12549h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12550i.f16260j.c(this.f12547f, this.f12548g, this.f12549h);
    }
}
