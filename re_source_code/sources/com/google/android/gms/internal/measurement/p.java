package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class p extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f17241j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17242k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    p(zzx zzxVar, boolean z) {
        super(zzxVar);
        this.f17242k = zzxVar;
        this.f17241j = z;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.f17242k.p.setDataCollectionEnabled(this.f17241j);
    }
}
