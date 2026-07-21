package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class s extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Bundle f17251j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17252k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    s(zzx zzxVar, Bundle bundle) {
        super(zzxVar);
        this.f17252k = zzxVar;
        this.f17251j = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.f17252k.p.setConditionalUserProperty(this.f17251j, this.f17581f);
    }
}
