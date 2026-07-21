package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzakw extends zzbbw<zzalf> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f13939c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzala f13940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13941e;

    public zzakw(zzala zzalaVar) {
        this.f13940d = zzalaVar;
    }

    public final void f() {
        synchronized (this.f13939c) {
            if (this.f13941e) {
                return;
            }
            this.f13941e = true;
            d(new v1(this), new zzbbu());
            d(new w1(this), new x1(this));
        }
    }
}
