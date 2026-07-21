package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: classes2.dex */
final class h0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Result f11759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zacm f11760g;

    h0(zacm zacmVar, Result result) {
        this.f11760g = zacmVar;
        this.f11759f = result;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                BasePendingResult.a.set(Boolean.TRUE);
                this.f11760g.a.b(this.f11759f);
                i0 unused = this.f11760g.f11848g;
                i0 unused2 = this.f11760g.f11848g;
                throw null;
            } catch (RuntimeException unused3) {
                i0 unused4 = this.f11760g.f11848g;
                i0 unused5 = this.f11760g.f11848g;
                throw null;
            }
        } catch (Throwable th) {
            BasePendingResult.a.set(Boolean.FALSE);
            zacm zacmVar = this.f11760g;
            zacm.c(this.f11759f);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f11760g.f11847f.get();
            if (googleApiClient != null) {
                googleApiClient.v(this.f11760g);
            }
            throw th;
        }
    }
}
