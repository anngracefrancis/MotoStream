package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class g6 extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12629f;

    g6(f6 f6Var, String str) {
        this.f12629f = str;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        new zzbah().a(this.f12629f);
    }
}
