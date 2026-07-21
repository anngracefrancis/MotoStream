package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzha;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class o extends zzx.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzha f17230j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17231k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    o(zzx zzxVar, zzha zzhaVar) {
        super(zzxVar);
        this.f17231k = zzxVar;
        this.f17230j = zzhaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        for (int i2 = 0; i2 < this.f17231k.l.size(); i2++) {
            if (this.f17230j.equals(((Pair) this.f17231k.l.get(i2)).first)) {
                Log.w(this.f17231k.f17577h, "OnEventListener already registered.");
                return;
            }
        }
        zzx.b bVar = new zzx.b(this.f17230j);
        this.f17231k.l.add(new Pair(this.f17230j, bVar));
        this.f17231k.p.registerOnMeasurementEventListener(bVar);
    }
}
