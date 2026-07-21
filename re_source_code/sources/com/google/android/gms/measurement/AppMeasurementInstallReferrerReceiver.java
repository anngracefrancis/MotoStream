package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzfn;
import com.google.android.gms.measurement.internal.zzfs;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzfs {
    private zzfn a;

    @Override // com.google.android.gms.measurement.internal.zzfs
    public final void a(Context context, Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.zzfs
    public final BroadcastReceiver.PendingResult b() {
        return goAsync();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.a == null) {
            this.a = new zzfn(this);
        }
        this.a.a(context, intent);
    }
}
