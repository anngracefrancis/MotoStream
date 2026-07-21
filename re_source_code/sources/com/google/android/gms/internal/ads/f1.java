package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class f1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzajy f12553g;

    f1(zzajy zzajyVar, String str) {
        this.f12553g = zzajyVar;
        this.f12552f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12553g.f13927f.loadData(this.f12552f, "text/html", "UTF-8");
    }
}
