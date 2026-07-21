package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes2.dex */
final class d50 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbbr f12450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzwb f12451g;

    d50(zzwb zzwbVar, zzbbr zzbbrVar) {
        this.f12451g = zzwbVar;
        this.f12450f = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        synchronized (this.f12451g.f16871d) {
            this.f12450f.c(new RuntimeException("Connection failed."));
        }
    }
}
