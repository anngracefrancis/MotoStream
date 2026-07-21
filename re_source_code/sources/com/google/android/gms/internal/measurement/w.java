package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class w extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f17273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx.c f17274k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    w(zzx.c cVar, Activity activity) {
        super(zzx.this);
        this.f17274k = cVar;
        this.f17273j = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzx.this.p.onActivityStopped(ObjectWrapper.E0(this.f17273j), this.f17582g);
    }
}
