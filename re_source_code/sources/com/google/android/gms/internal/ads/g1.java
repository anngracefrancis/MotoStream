package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class g1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12612f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzajy f12613g;

    g1(zzajy zzajyVar, String str) {
        this.f12613g = zzajyVar;
        this.f12612f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12613g.f13927f.loadUrl(this.f12612f);
    }
}
