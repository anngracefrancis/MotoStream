package io.sentry.android.core;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import io.sentry.Integration;
import io.sentry.i2;
import io.sentry.n1;
import io.sentry.s4;
import io.sentry.v1;
import io.sentry.w1;
import io.sentry.x4;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class TempSensorBreadcrumbsIntegration implements Integration, Closeable, SensorEventListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f22079f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private v1 f22080g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private SentryAndroidOptions f22081h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    SensorManager f22082i;

    public TempSensorBreadcrumbsIntegration(Context context) {
        this.f22079f = (Context) io.sentry.util.q.c(context, "Context is required");
    }

    @Override // io.sentry.j2
    public /* synthetic */ void a() {
        i2.a(this);
    }

    @Override // io.sentry.Integration
    public void c(v1 v1Var, x4 x4Var) {
        this.f22080g = (v1) io.sentry.util.q.c(v1Var, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.q.c(x4Var instanceof SentryAndroidOptions ? (SentryAndroidOptions) x4Var : null, "SentryAndroidOptions is required");
        this.f22081h = sentryAndroidOptions;
        w1 logger = sentryAndroidOptions.getLogger();
        s4 s4Var = s4.DEBUG;
        logger.c(s4Var, "enableSystemEventsBreadcrumbs enabled: %s", Boolean.valueOf(this.f22081h.isEnableSystemEventBreadcrumbs()));
        if (this.f22081h.isEnableSystemEventBreadcrumbs()) {
            try {
                SensorManager sensorManager = (SensorManager) this.f22079f.getSystemService("sensor");
                this.f22082i = sensorManager;
                if (sensorManager != null) {
                    Sensor defaultSensor = sensorManager.getDefaultSensor(13);
                    if (defaultSensor != null) {
                        this.f22082i.registerListener(this, defaultSensor, 3);
                        x4Var.getLogger().c(s4Var, "TempSensorBreadcrumbsIntegration installed.", new Object[0]);
                        a();
                    } else {
                        this.f22081h.getLogger().c(s4.INFO, "TYPE_AMBIENT_TEMPERATURE is not available.", new Object[0]);
                    }
                } else {
                    this.f22081h.getLogger().c(s4.INFO, "SENSOR_SERVICE is not available.", new Object[0]);
                }
            } catch (Throwable th) {
                x4Var.getLogger().a(s4.ERROR, th, "Failed to init. the SENSOR_SERVICE.", new Object[0]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        SensorManager sensorManager = this.f22082i;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.f22082i = null;
            SentryAndroidOptions sentryAndroidOptions = this.f22081h;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(s4.DEBUG, "TempSensorBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    @Override // io.sentry.j2
    public /* synthetic */ String d() {
        return i2.b(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr == null || fArr.length == 0 || fArr[0] == 0.0f || this.f22080g == null) {
            return;
        }
        io.sentry.v0 v0Var = new io.sentry.v0();
        v0Var.p("system");
        v0Var.l("device.event");
        v0Var.m("action", "TYPE_AMBIENT_TEMPERATURE");
        v0Var.m("accuracy", Integer.valueOf(sensorEvent.accuracy));
        v0Var.m("timestamp", Long.valueOf(sensorEvent.timestamp));
        v0Var.n(s4.INFO);
        v0Var.m("degree", Float.valueOf(sensorEvent.values[0]));
        n1 n1Var = new n1();
        n1Var.j("android:sensorEvent", sensorEvent);
        this.f22080g.n(v0Var, n1Var);
    }
}
