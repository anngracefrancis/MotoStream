package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class j extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17183j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17184k;
    private final /* synthetic */ boolean l;
    private final /* synthetic */ zzk m;
    private final /* synthetic */ zzx n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    j(zzx zzxVar, String str, String str2, boolean z, zzk zzkVar) {
        super(zzxVar);
        this.n = zzxVar;
        this.f17183j = str;
        this.f17184k = str2;
        this.l = z;
        this.m = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.n.p.getUserProperties(this.f17183j, this.f17184k, this.l, this.m);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.m.J(null);
    }
}
