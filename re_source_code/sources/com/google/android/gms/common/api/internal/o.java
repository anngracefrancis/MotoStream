package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes2.dex */
final class o implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zaak f11775f;

    private o(zaak zaakVar) {
        this.f11775f = zaakVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        this.f11775f.f11805b.lock();
        try {
            if (this.f11775f.w(connectionResult)) {
                this.f11775f.l();
                this.f11775f.j();
            } else {
                this.f11775f.x(connectionResult);
            }
        } finally {
            this.f11775f.f11805b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void H(int i2) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void P(Bundle bundle) {
        if (!this.f11775f.r.m()) {
            this.f11775f.f11814k.d(new m(this.f11775f));
            return;
        }
        this.f11775f.f11805b.lock();
        try {
            if (this.f11775f.f11814k == null) {
                return;
            }
            this.f11775f.f11814k.d(new m(this.f11775f));
        } finally {
            this.f11775f.f11805b.unlock();
        }
    }

    /* synthetic */ o(zaak zaakVar, g gVar) {
        this(zaakVar);
    }
}
