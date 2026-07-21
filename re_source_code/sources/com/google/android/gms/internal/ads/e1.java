package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class e1 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzajy f12492g;

    e1(zzajy zzajyVar, String str) {
        this.f12492g = zzajyVar;
        this.f12491f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12492g.f13927f.loadData(this.f12491f, "text/html", "UTF-8");
    }
}
