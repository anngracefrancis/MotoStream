package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class t extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f17255j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ Bundle f17256k;
    private final /* synthetic */ zzx.c l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    t(zzx.c cVar, Activity activity, Bundle bundle) {
        super(zzx.this);
        this.l = cVar;
        this.f17255j = activity;
        this.f17256k = bundle;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzx.this.p.onActivityCreated(ObjectWrapper.E0(this.f17255j), this.f17256k, this.f17582g);
    }
}
