package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzfn;
import com.google.android.gms.measurement.internal.zzfs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class AppMeasurementReceiver extends c.o.a.a implements zzfs {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzfn f17685c;

    @Override // com.google.android.gms.measurement.internal.zzfs
    public final void a(Context context, Intent intent) {
        c.o.a.a.d(context, intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzfs
    public final BroadcastReceiver.PendingResult b() {
        return goAsync();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f17685c == null) {
            this.f17685c = new zzfn(this);
        }
        this.f17685c.a(context, intent);
    }
}
