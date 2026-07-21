package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class h implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference<zaak> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Api<?> f11757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f11758c;

    public h(zaak zaakVar, Api<?> api, boolean z) {
        this.a = new WeakReference<>(zaakVar);
        this.f11757b = api;
        this.f11758c = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void a(ConnectionResult connectionResult) {
        zaak zaakVar = this.a.get();
        if (zaakVar == null) {
            return;
        }
        Preconditions.o(Looper.myLooper() == zaakVar.a.s.o(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        zaakVar.f11805b.lock();
        try {
            if (zaakVar.t(0)) {
                if (!connectionResult.e0()) {
                    zaakVar.p(connectionResult, this.f11757b, this.f11758c);
                }
                if (zaakVar.i()) {
                    zaakVar.j();
                }
            }
        } finally {
            zaakVar.f11805b.unlock();
        }
    }
}
