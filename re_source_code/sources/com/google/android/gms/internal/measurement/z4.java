package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class z4 extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17304k;
    private final /* synthetic */ Bundle l;
    private final /* synthetic */ zzx m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    z4(zzx zzxVar, String str, String str2, Bundle bundle) {
        super(zzxVar);
        this.m = zzxVar;
        this.f17303j = str;
        this.f17304k = str2;
        this.l = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.m.p.clearConditionalUserProperty(this.f17303j, this.f17304k, this.l);
    }
}
