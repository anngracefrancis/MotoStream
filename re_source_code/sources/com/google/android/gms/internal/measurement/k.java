package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class k extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzk f17189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17190k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    k(zzx zzxVar, zzk zzkVar) {
        super(zzxVar);
        this.f17190k = zzxVar;
        this.f17189j = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.f17190k.p.getCurrentScreenClass(this.f17189j);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17189j.J(null);
    }
}
