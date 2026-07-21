package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class b extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17127j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17128k;
    private final /* synthetic */ zzk l;
    private final /* synthetic */ zzx m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    b(zzx zzxVar, String str, String str2, zzk zzkVar) {
        super(zzxVar);
        this.m = zzxVar;
        this.f17127j = str;
        this.f17128k = str2;
        this.l = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.m.p.getConditionalUserProperties(this.f17127j, this.f17128k, this.l);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.l.J(null);
    }
}
