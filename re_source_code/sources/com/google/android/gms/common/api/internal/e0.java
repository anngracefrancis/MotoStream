package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
final class e0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f11750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ GoogleApiManager.b f11751g;

    e0(GoogleApiManager.b bVar, ConnectionResult connectionResult) {
        this.f11751g = bVar;
        this.f11750f = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.f11750f.e0()) {
            ((GoogleApiManager.zaa) GoogleApiManager.this.r.get(this.f11751g.f11718b)).E0(this.f11750f);
            return;
        }
        GoogleApiManager.b.e(this.f11751g, true);
        if (this.f11751g.a.requiresSignIn()) {
            this.f11751g.g();
            return;
        }
        try {
            this.f11751g.a.getRemoteService(null, Collections.emptySet());
        } catch (SecurityException e2) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e2);
            ((GoogleApiManager.zaa) GoogleApiManager.this.r.get(this.f11751g.f11718b)).E0(new ConnectionResult(10));
        }
    }
}
