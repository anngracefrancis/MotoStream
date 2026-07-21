package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes2.dex */
final class t0 implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13340f;

    t0(zzaii zzaiiVar, zzbbr zzbbrVar) {
        this.f13340f = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void E0(ConnectionResult connectionResult) {
        this.f13340f.c(new RuntimeException("Connection failed."));
    }
}
