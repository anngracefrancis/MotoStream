package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzk f17222k;
    private final /* synthetic */ zzx l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    n(zzx zzxVar, String str, zzk zzkVar) {
        super(zzxVar);
        this.l = zzxVar;
        this.f17221j = str;
        this.f17222k = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        this.l.p.getMaxUserProperties(this.f17221j, this.f17222k);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17222k.J(null);
    }
}
