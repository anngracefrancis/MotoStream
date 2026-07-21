package androidx.work.impl.utils;

import android.content.Context;
import android.os.PowerManager;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: WakeLocks.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    private static final String a = androidx.work.n.f("WakeLocks");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<PowerManager.WakeLock, String> f2583b = new WeakHashMap<>();

    public static void a() {
        HashMap map = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f2583b;
        synchronized (weakHashMap) {
            map.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : map.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                androidx.work.n.c().h(a, String.format("WakeLock held for %s", map.get(wakeLock)), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock b(Context context, String str) {
        String str2 = "WorkManager: " + str;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str2);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f2583b;
        synchronized (weakHashMap) {
            weakHashMap.put(wakeLockNewWakeLock, str2);
        }
        return wakeLockNewWakeLock;
    }
}
