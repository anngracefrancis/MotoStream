package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class r extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ Long f17246j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ String f17247k;
    private final /* synthetic */ String l;
    private final /* synthetic */ Bundle m;
    private final /* synthetic */ boolean n;
    private final /* synthetic */ boolean o;
    private final /* synthetic */ zzx p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    r(zzx zzxVar, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(zzxVar);
        this.p = zzxVar;
        this.f17246j = l;
        this.f17247k = str;
        this.l = str2;
        this.m = bundle;
        this.n = z;
        this.o = z2;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        Long l = this.f17246j;
        this.p.p.logEvent(this.f17247k, this.l, this.m, this.n, this.o, l == null ? this.f17581f : l.longValue());
    }
}
