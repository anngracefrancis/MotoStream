package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes2.dex */
final class o0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final n0 f11776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ zal f11777g;

    o0(zal zalVar, n0 n0Var) {
        this.f11777g = zalVar;
        this.f11776f = n0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f11777g.f11872g) {
            ConnectionResult connectionResultA = this.f11776f.a();
            if (connectionResultA.Y()) {
                zal zalVar = this.f11777g;
                zalVar.f11734f.startActivityForResult(GoogleApiActivity.b(zalVar.b(), connectionResultA.W(), this.f11776f.b(), false), 1);
            } else if (this.f11777g.f11875j.m(connectionResultA.y())) {
                zal zalVar2 = this.f11777g;
                zalVar2.f11875j.z(zalVar2.b(), this.f11777g.f11734f, connectionResultA.y(), 2, this.f11777g);
            } else {
                if (connectionResultA.y() != 18) {
                    this.f11777g.l(connectionResultA, this.f11776f.b());
                    return;
                }
                Dialog dialogT = GoogleApiAvailability.t(this.f11777g.b(), this.f11777g);
                zal zalVar3 = this.f11777g;
                zalVar3.f11875j.v(zalVar3.b().getApplicationContext(), new p0(this, dialogT));
            }
        }
    }
}
