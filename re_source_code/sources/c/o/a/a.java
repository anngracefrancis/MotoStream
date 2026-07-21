package c.o.a;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;

/* JADX INFO: compiled from: WakefulBroadcastReceiver.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class a extends BroadcastReceiver {
    private static final SparseArray<PowerManager.WakeLock> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f3358b = 1;

    public static boolean c(Intent intent) {
        int intExtra = intent.getIntExtra("androidx.contentpager.content.wakelockid", 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<PowerManager.WakeLock> sparseArray = a;
        synchronized (sparseArray) {
            PowerManager.WakeLock wakeLock = sparseArray.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                sparseArray.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
            return true;
        }
    }

    public static ComponentName d(Context context, Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = a;
        synchronized (sparseArray) {
            int i2 = f3358b;
            int i3 = i2 + 1;
            f3358b = i3;
            if (i3 <= 0) {
                f3358b = 1;
            }
            intent.putExtra("androidx.contentpager.content.wakelockid", i2);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
            wakeLockNewWakeLock.setReferenceCounted(false);
            wakeLockNewWakeLock.acquire(60000L);
            sparseArray.put(i2, wakeLockNewWakeLock);
            return componentNameStartService;
        }
    }
}
