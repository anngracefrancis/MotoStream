package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzk f17152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17153k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    g(zzx zzxVar, zzk zzkVar) {
        super(zzxVar);
        this.f17153k = zzxVar;
        this.f17152j = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.f17153k.p.getGmpAppId(this.f17152j);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17152j.J(null);
    }
}
