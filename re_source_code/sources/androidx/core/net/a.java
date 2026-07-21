package androidx.core.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

/* JADX INFO: compiled from: ConnectivityManagerCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a(ConnectivityManager connectivityManager) {
        if (Build.VERSION.SDK_INT >= 16) {
            return connectivityManager.isActiveNetworkMetered();
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return true;
        }
        int type = activeNetworkInfo.getType();
        return (type == 1 || type == 7 || type == 9) ? false : true;
    }
}
