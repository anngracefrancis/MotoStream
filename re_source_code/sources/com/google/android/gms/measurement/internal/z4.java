package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class z4 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bundle f18045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzhc f18046g;

    z4(zzhc zzhcVar, Bundle bundle) {
        this.f18046g = zzhcVar;
        this.f18045f = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f18046g.x0(this.f18045f);
    }
}
