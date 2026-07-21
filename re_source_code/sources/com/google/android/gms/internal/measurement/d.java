package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class d extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17145k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(zzx zzxVar, String str) {
        super(zzxVar);
        this.f17145k = zzxVar;
        this.f17144j = str;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.f17145k.p.beginAdUnitExposure(this.f17144j, this.f17582g);
    }
}
