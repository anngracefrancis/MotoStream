package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: classes2.dex */
final class s0 implements BaseGmsClient.BaseConnectionCallbacks {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13300f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzaii f13301g;

    s0(zzaii zzaiiVar, zzbbr zzbbrVar) {
        this.f13301g = zzaiiVar;
        this.f13300f = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void H(int i2) {
        zzbbr zzbbrVar = this.f13300f;
        StringBuilder sb = new StringBuilder(34);
        sb.append("onConnectionSuspended: ");
        sb.append(i2);
        zzbbrVar.c(new RuntimeException(sb.toString()));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void P(Bundle bundle) {
        try {
            this.f13300f.a(this.f13301g.a.e());
        } catch (DeadObjectException e2) {
            this.f13300f.c(e2);
        }
    }
}
