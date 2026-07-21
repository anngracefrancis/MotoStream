package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class z20 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ x20 f13671f;

    z20(x20 x20Var) {
        this.f13671f = x20Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f13671f.M) {
            return;
        }
        this.f13671f.v.g(this.f13671f);
    }
}
