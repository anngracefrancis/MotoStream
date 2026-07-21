package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzji;
import com.google.android.gms.measurement.internal.zzjm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzjm {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzji<AppMeasurementJobService> f17684f;

    private final zzji<AppMeasurementJobService> c() {
        if (this.f17684f == null) {
            this.f17684f = new zzji<>(this);
        }
        return this.f17684f;
    }

    @Override // com.google.android.gms.measurement.internal.zzjm
    public final void a(Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.zzjm
    @TargetApi(24)
    public final void b(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzjm
    public final boolean d(int i2) {
        throw new UnsupportedOperationException();
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

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return c().g(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        return c().i(intent);
    }
}
