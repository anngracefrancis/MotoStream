package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import cm.aptoide.pt.notification.PullingContentService;
import java.util.Calendar;

/* JADX INFO: compiled from: TwilightManager.java */
/* JADX INFO: loaded from: classes.dex */
class n {
    private static n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocationManager f225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f226d = new a();

    /* JADX INFO: compiled from: TwilightManager.java */
    private static class a {
        boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f230e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f231f;

        a() {
        }
    }

    n(Context context, LocationManager locationManager) {
        this.f224b = context;
        this.f225c = locationManager;
    }

    static n a(Context context) {
        if (a == null) {
            Context applicationContext = context.getApplicationContext();
            a = new n(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return a;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationC = androidx.core.content.c.b(this.f224b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.c.b(this.f224b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c("gps") : null;
        if (locationC2 == null || locationC == null) {
            return locationC2 != null ? locationC2 : locationC;
        }
        return locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.f225c.isProviderEnabled(str)) {
                return this.f225c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f226d.f231f > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j2;
        long j3;
        a aVar = this.f226d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        m mVarB = m.b();
        mVarB.a(jCurrentTimeMillis - PullingContentService.UPDATES_INTERVAL, location.getLatitude(), location.getLongitude());
        long j4 = mVarB.f221b;
        mVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = mVarB.f223d == 1;
        long j5 = mVarB.f222c;
        long j6 = mVarB.f221b;
        boolean z2 = z;
        mVarB.a(PullingContentService.UPDATES_INTERVAL + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j7 = mVarB.f222c;
        if (j5 == -1 || j6 == -1) {
            j2 = 43200000 + jCurrentTimeMillis;
        } else {
            if (jCurrentTimeMillis > j6) {
                j3 = 0 + j7;
            } else {
                j3 = jCurrentTimeMillis > j5 ? 0 + j6 : 0 + j5;
            }
            j2 = j3 + 60000;
        }
        aVar.a = z2;
        aVar.f227b = j4;
        aVar.f228c = j5;
        aVar.f229d = j6;
        aVar.f230e = j7;
        aVar.f231f = j2;
    }

    boolean d() {
        a aVar = this.f226d;
        if (e()) {
            return aVar.a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
