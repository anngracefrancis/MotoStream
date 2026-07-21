package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class a30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ d30 f12215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ x20 f12216g;

    a30(x20 x20Var, d30 d30Var) {
        this.f12216g = x20Var;
        this.f12215f = d30Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12215f.a();
        int size = this.f12216g.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((zzqt) this.f12216g.u.valueAt(i2)).e();
        }
    }
}
