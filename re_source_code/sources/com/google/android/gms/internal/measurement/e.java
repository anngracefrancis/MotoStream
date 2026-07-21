package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17146j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17147k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e(zzx zzxVar, String str) {
        super(zzxVar);
        this.f17147k = zzxVar;
        this.f17146j = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.f17147k.p.endAdUnitExposure(this.f17146j, this.f17582g);
    }
}
