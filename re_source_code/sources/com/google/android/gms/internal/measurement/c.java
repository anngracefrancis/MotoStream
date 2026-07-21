package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class c extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Activity f17135j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17136k;
    private final /* synthetic */ String l;
    private final /* synthetic */ zzx m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    c(zzx zzxVar, Activity activity, String str, String str2) {
        super(zzxVar);
        this.m = zzxVar;
        this.f17135j = activity;
        this.f17136k = str;
        this.l = str2;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.m.p.setCurrentScreen(ObjectWrapper.E0(this.f17135j), this.f17136k, this.l, this.f17581f);
    }
}
