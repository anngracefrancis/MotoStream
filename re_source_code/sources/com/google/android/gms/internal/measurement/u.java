package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class u extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f17259j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx.c f17260k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u(zzx.c cVar, Activity activity) {
        super(zzx.this);
        this.f17260k = cVar;
        this.f17259j = activity;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzx.this.p.onActivityResumed(ObjectWrapper.E0(this.f17259j), this.f17582g);
    }
}
