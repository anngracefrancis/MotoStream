package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes2.dex */
final class x40 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzvn f13555f;

    x40(zzvn zzvnVar) {
        this.f13555f = zzvnVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        synchronized (this.f13555f.f16858b) {
            this.f13555f.f16861e = null;
            if (this.f13555f.f16859c != null) {
                zzvn.f(this.f13555f, null);
            }
            this.f13555f.f16858b.notifyAll();
        }
    }
}
