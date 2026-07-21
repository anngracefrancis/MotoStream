package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class b30 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ IOException f12309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ x20 f12310g;

    b30(x20 x20Var, IOException iOException) {
        this.f12310g = x20Var;
        this.f12309f = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12310g.f13549j.f(this.f12309f);
    }
}
