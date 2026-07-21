package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class c8 implements SensorEventListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SensorManager f12405f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Display f12407h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float[] f12410k;
    private Handler l;
    private e8 m;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f12408i = new float[9];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float[] f12409j = new float[9];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f12406g = new Object();

    c8(Context context) {
        this.f12405f = (SensorManager) context.getSystemService("sensor");
        this.f12407h = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    private final void e(int i2, int i3) {
        float[] fArr = this.f12409j;
        float f2 = fArr[i2];
        fArr[i2] = fArr[i3];
        fArr[i3] = f2;
    }

    final void a() {
        if (this.l != null) {
            return;
        }
        Sensor defaultSensor = this.f12405f.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzbad.g("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        zzdbh zzdbhVar = new zzdbh(handlerThread.getLooper());
        this.l = zzdbhVar;
        if (this.f12405f.registerListener(this, defaultSensor, 0, zzdbhVar)) {
            return;
        }
        zzbad.g("SensorManager.registerListener failed.");
        b();
    }

    final void b() {
        if (this.l == null) {
            return;
        }
        this.f12405f.unregisterListener(this);
        this.l.post(new d8(this));
        this.l = null;
    }

    final void c(e8 e8Var) {
        this.m = e8Var;
    }

    final boolean d(float[] fArr) {
        synchronized (this.f12406g) {
            float[] fArr2 = this.f12410k;
            if (fArr2 == null) {
                return false;
            }
            System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
            return true;
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.f12406g) {
            if (this.f12410k == null) {
                this.f12410k = new float[9];
            }
        }
        SensorManager.getRotationMatrixFromVector(this.f12408i, fArr);
        int rotation = this.f12407h.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(this.f12408i, 2, 129, this.f12409j);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(this.f12408i, 129, 130, this.f12409j);
        } else if (rotation != 3) {
            System.arraycopy(this.f12408i, 0, this.f12409j, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(this.f12408i, 130, 1, this.f12409j);
        }
        e(1, 3);
        e(2, 6);
        e(5, 7);
        synchronized (this.f12406g) {
            System.arraycopy(this.f12409j, 0, this.f12410k, 0, 9);
        }
        e8 e8Var = this.m;
        if (e8Var != null) {
            e8Var.a();
        }
    }
}
