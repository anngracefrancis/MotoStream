package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzji;
import com.google.android.gms.measurement.internal.zzjm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class AppMeasurementService extends Service implements zzjm {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzji<AppMeasurementService> f17686f;

    private final zzji<AppMeasurementService> c() {
        if (this.f17686f == null) {
            this.f17686f = new zzji<>(this);
        }
        return this.f17686f;
    }

    @Override // com.google.android.gms.measurement.internal.zzjm
    public final void a(Intent intent) {
        c.o.a.a.c(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzjm
    public final void b(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjm
    public final boolean d(int i2) {
        return stopSelfResult(i2);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return c().b(intent);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        c().c();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        c().h();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final void onRebind(Intent intent) {
        c().k(intent);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        return c().a(intent, i2, i3);
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return c().i(intent);
    }
}
