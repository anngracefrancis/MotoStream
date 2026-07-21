package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzk f17166j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17167k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h(zzx zzxVar, zzk zzkVar) {
        super(zzxVar);
        this.f17167k = zzxVar;
        this.f17166j = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.f17167k.p.getCurrentScreenName(this.f17166j);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17166j.J(null);
    }
}
