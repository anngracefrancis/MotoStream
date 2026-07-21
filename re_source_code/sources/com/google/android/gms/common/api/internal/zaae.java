package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes2.dex */
public class zaae extends zal {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c.e.b<zai<?>> f11802k;
    private GoogleApiManager l;

    private final void q() {
        if (this.f11802k.isEmpty()) {
            return;
        }
        this.l.i(this);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void g() {
        super.g();
        q();
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        super.i();
        q();
    }

    @Override // com.google.android.gms.common.api.internal.zal, com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.l.m(this);
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void l(ConnectionResult connectionResult, int i2) {
        this.l.f(connectionResult, i2);
    }

    @Override // com.google.android.gms.common.api.internal.zal
    protected final void n() {
        this.l.A();
    }

    final c.e.b<zai<?>> p() {
        return this.f11802k;
    }
}
