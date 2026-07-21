package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class i4 extends r6 {
    public i4(t6 t6Var) {
        super(t6Var);
    }

    @TargetApi(18)
    public static Map<String, Map<String, String>> h(h0 h0Var) {
        int intExtra;
        int intExtra2;
        HashMap map = new HashMap();
        new HashMap();
        if (h0Var.a) {
            map.put("boot.time", i(Long.toString(System.currentTimeMillis() - SystemClock.elapsedRealtime())));
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 18) {
                map.put("disk.size.total.internal", i(Long.toString(statFs.getAvailableBlocksLong())));
                map.put("disk.size.available.internal", i(Long.toString(statFs.getAvailableBlocksLong())));
            } else {
                map.put("disk.size.total.internal", i(Long.toString(statFs.getAvailableBlocks())));
                map.put("disk.size.available.internal", i(Long.toString(statFs.getAvailableBlocks())));
            }
            n nVar = h0Var.f10807b;
            if (nVar != null && !nVar.a) {
                try {
                    StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
                    if (i2 >= 18) {
                        map.put("disk.size.total.external", i(Long.toString(statFs2.getAvailableBlocksLong())));
                        map.put("disk.size.available.external", i(Long.toString(statFs2.getAvailableBlocksLong())));
                    } else {
                        map.put("disk.size.total.external", i(Long.toString(statFs2.getAvailableBlocks())));
                        map.put("disk.size.available.external", i(Long.toString(statFs2.getAvailableBlocks())));
                    }
                } catch (Exception e2) {
                    d1.c(5, "SessionPropertiesFrame", e2.getMessage());
                }
            }
            m0.a();
            TelephonyManager telephonyManager = (TelephonyManager) b0.a().getSystemService("phone");
            map.put("carrier.name", i(telephonyManager == null ? null : telephonyManager.getNetworkOperatorName()));
            m0.a();
            TelephonyManager telephonyManager2 = (TelephonyManager) b0.a().getSystemService("phone");
            map.put("carrier.details", i(telephonyManager2 == null ? null : telephonyManager2.getNetworkOperator()));
        }
        ActivityManager activityManager = (ActivityManager) b0.a().getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        Map<String, String> mapI = i(Long.toString(memoryInfo.availMem));
        StringBuilder sb = new StringBuilder("memory.available");
        sb.append(h0Var.a ? ".start" : ".end");
        map.put(sb.toString(), mapI);
        if (Build.VERSION.SDK_INT >= 16) {
            Map<String, String> mapI2 = i(Long.toString(memoryInfo.availMem));
            StringBuilder sb2 = new StringBuilder("memory.total");
            sb2.append(h0Var.a ? ".start" : ".end");
            map.put(sb2.toString(), mapI2);
        }
        boolean z = false;
        int i3 = -1;
        try {
            Intent intentRegisterReceiver = b0.a().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (intentRegisterReceiver != null) {
                int intExtra3 = intentRegisterReceiver.getIntExtra("status", -1);
                z = intExtra3 == 2 || intExtra3 == 5;
                intExtra = intentRegisterReceiver.getIntExtra("level", -1);
                try {
                    intExtra2 = intentRegisterReceiver.getIntExtra("scale", -1);
                    i3 = intExtra;
                } catch (Exception e3) {
                    e = e3;
                    d1.c(5, "SessionPropertiesFrame", "Error getting battery status: ".concat(String.valueOf(e)));
                    i3 = intExtra;
                    intExtra2 = -1;
                }
            } else {
                intExtra2 = -1;
            }
        } catch (Exception e4) {
            e = e4;
            intExtra = -1;
        }
        float f2 = i3 / intExtra2;
        Map<String, String> mapI3 = i(Boolean.toString(z));
        StringBuilder sb3 = new StringBuilder("battery.charging");
        sb3.append(h0Var.a ? ".start" : ".end");
        map.put(sb3.toString(), mapI3);
        Map<String, String> mapI4 = i(Float.toString(f2));
        StringBuilder sb4 = new StringBuilder("battery.remaining");
        sb4.append(h0Var.a ? ".start" : ".end");
        map.put(sb4.toString(), mapI4);
        n nVar2 = h0Var.f10807b;
        if (nVar2 != null && nVar2.a) {
            map.put("instantapp.name", i(nVar2.f10925b));
        }
        return map;
    }

    private static Map<String, String> i(String str) {
        HashMap map = new HashMap();
        map.put("value", str);
        return map;
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.SESSION_PROPERTIES;
    }
}
