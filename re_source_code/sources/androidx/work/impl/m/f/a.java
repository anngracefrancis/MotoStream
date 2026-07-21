package androidx.work.impl.m.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.n;

/* JADX INFO: compiled from: BatteryChargingTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c<Boolean> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f2491i = n.f("BatteryChrgTracker");

    public a(Context context, androidx.work.impl.utils.p.a aVar) {
        super(context, aVar);
    }

    private boolean j(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }

    @Override // androidx.work.impl.m.f.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    @Override // androidx.work.impl.m.f.c
    public void h(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
        }
        byte b2 = 1;
        n.c().a(f2491i, String.format("Received %s", action), new Throwable[0]);
        switch (action.hashCode()) {
            case -1886648615:
                if (!action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    b2 = -1;
                } else {
                    b2 = 0;
                }
                break;
            case -54942926:
                if (!action.equals("android.os.action.DISCHARGING")) {
                    b2 = -1;
                }
                break;
            case 948344062:
                if (!action.equals("android.os.action.CHARGING")) {
                    b2 = -1;
                } else {
                    b2 = 2;
                }
                break;
            case 1019184907:
                if (!action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    b2 = -1;
                } else {
                    b2 = 3;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
                d(Boolean.FALSE);
                break;
            case 1:
                d(Boolean.FALSE);
                break;
            case 2:
                d(Boolean.TRUE);
                break;
            case 3:
                d(Boolean.TRUE);
                break;
        }
    }

    @Override // androidx.work.impl.m.f.d
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Boolean b() {
        Intent intentRegisterReceiver = this.f2496c.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return Boolean.valueOf(j(intentRegisterReceiver));
        }
        n.c().b(f2491i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
