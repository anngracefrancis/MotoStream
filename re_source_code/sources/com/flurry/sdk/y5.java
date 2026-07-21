package com.flurry.sdk;

import android.location.Location;
import android.os.Build;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class y5 extends q6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Location f11152e;

    public y5(int i2, boolean z, boolean z2, Location location) {
        this.f11149b = i2;
        this.f11150c = z;
        this.f11151d = z2;
        this.f11152e = location;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        Location location;
        double d2;
        double d3;
        boolean zHasSpeedAccuracy;
        JSONObject jSONObjectA = super.a();
        jSONObjectA.put("fl.report.location.enabled", this.f11150c);
        if (this.f11150c) {
            jSONObjectA.put("fl.location.permission.status", this.f11151d);
            if (this.f11151d && (location = this.f11152e) != null) {
                int i2 = Build.VERSION.SDK_INT;
                boolean z = false;
                double verticalAccuracyMeters = 0.0d;
                if (i2 >= 26) {
                    verticalAccuracyMeters = location.getVerticalAccuracyMeters();
                    double bearingAccuracyDegrees = this.f11152e.getBearingAccuracyDegrees();
                    double speedAccuracyMetersPerSecond = this.f11152e.getSpeedAccuracyMetersPerSecond();
                    boolean zHasBearingAccuracy = this.f11152e.hasBearingAccuracy();
                    zHasSpeedAccuracy = this.f11152e.hasSpeedAccuracy();
                    d3 = speedAccuracyMetersPerSecond;
                    d2 = bearingAccuracyDegrees;
                    z = zHasBearingAccuracy;
                } else {
                    d2 = 0.0d;
                    d3 = 0.0d;
                    zHasSpeedAccuracy = false;
                }
                jSONObjectA.put("fl.precision.value", this.f11149b);
                jSONObjectA.put("fl.latitude.value", this.f11152e.getLatitude());
                jSONObjectA.put("fl.longitude.value", this.f11152e.getLongitude());
                jSONObjectA.put("fl.horizontal.accuracy.value", this.f11152e.getAccuracy());
                jSONObjectA.put("fl.time.epoch.value", this.f11152e.getTime());
                if (i2 >= 17) {
                    jSONObjectA.put("fl.time.uptime.value", TimeUnit.NANOSECONDS.toMillis(this.f11152e.getElapsedRealtimeNanos()));
                }
                jSONObjectA.put("fl.altitude.value", this.f11152e.getAltitude());
                jSONObjectA.put("fl.vertical.accuracy.value", verticalAccuracyMeters);
                jSONObjectA.put("fl.bearing.value", this.f11152e.getBearing());
                jSONObjectA.put("fl.speed.value", this.f11152e.getSpeed());
                jSONObjectA.put("fl.bearing.accuracy.available", z);
                jSONObjectA.put("fl.speed.accuracy.available", zHasSpeedAccuracy);
                jSONObjectA.put("fl.bearing.accuracy.degrees", d2);
                jSONObjectA.put("fl.speed.accuracy.meters.per.sec", d3);
            }
        }
        return jSONObjectA;
    }
}
