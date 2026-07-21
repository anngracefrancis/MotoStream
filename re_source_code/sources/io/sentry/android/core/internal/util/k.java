package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import io.sentry.android.core.s0;
import io.sentry.s4;
import io.sentry.w1;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: ConnectivityChecker.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class k {

    /* JADX INFO: compiled from: ConnectivityChecker.java */
    public enum a {
        CONNECTED,
        NOT_CONNECTED,
        NO_PERMISSION,
        UNKNOWN
    }

    private static a a(Context context, ConnectivityManager connectivityManager, w1 w1Var) {
        if (!q.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w1Var.c(s4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return a.NO_PERMISSION;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected() ? a.CONNECTED : a.NOT_CONNECTED;
            }
            w1Var.c(s4.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
            return a.NOT_CONNECTED;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Could not retrieve Connection Status", th);
            return a.UNKNOWN;
        }
    }

    public static a b(Context context, w1 w1Var) {
        ConnectivityManager connectivityManagerE = e(context, w1Var);
        return connectivityManagerE == null ? a.UNKNOWN : a(context, connectivityManagerE, w1Var);
    }

    @SuppressLint({"ObsoleteSdkInt", "MissingPermission", "NewApi"})
    public static String c(Context context, w1 w1Var, s0 s0Var) {
        boolean zHasTransport;
        ConnectivityManager connectivityManagerE = e(context, w1Var);
        if (connectivityManagerE == null) {
            return null;
        }
        boolean z = false;
        if (!q.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w1Var.c(s4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return null;
        }
        try {
            boolean zHasTransport2 = true;
            if (s0Var.d() >= 23) {
                Network activeNetwork = connectivityManagerE.getActiveNetwork();
                if (activeNetwork == null) {
                    w1Var.c(s4.INFO, "Network is null and cannot check network status", new Object[0]);
                    return null;
                }
                NetworkCapabilities networkCapabilities = connectivityManagerE.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities == null) {
                    w1Var.c(s4.INFO, "NetworkCapabilities is null and cannot check network type", new Object[0]);
                    return null;
                }
                boolean zHasTransport3 = networkCapabilities.hasTransport(3);
                zHasTransport = networkCapabilities.hasTransport(1);
                zHasTransport2 = networkCapabilities.hasTransport(0);
                z = zHasTransport3;
            } else {
                NetworkInfo activeNetworkInfo = connectivityManagerE.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    w1Var.c(s4.INFO, "NetworkInfo is null, there's no active network.", new Object[0]);
                    return null;
                }
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type == 1) {
                        zHasTransport = true;
                    } else if (type != 9) {
                        zHasTransport = false;
                    } else {
                        zHasTransport = false;
                        z = true;
                    }
                    zHasTransport2 = false;
                } else {
                    zHasTransport = false;
                }
            }
            if (z) {
                return "ethernet";
            }
            if (zHasTransport) {
                return "wifi";
            }
            if (zHasTransport2) {
                return "cellular";
            }
            return null;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "Failed to retrieve network info", th);
        }
    }

    @SuppressLint({"NewApi"})
    public static String d(NetworkCapabilities networkCapabilities, s0 s0Var) {
        if (s0Var.d() < 21) {
            return null;
        }
        if (networkCapabilities.hasTransport(3)) {
            return "ethernet";
        }
        if (networkCapabilities.hasTransport(1)) {
            return "wifi";
        }
        if (networkCapabilities.hasTransport(0)) {
            return "cellular";
        }
        return null;
    }

    private static ConnectivityManager e(Context context, w1 w1Var) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            w1Var.c(s4.INFO, "ConnectivityManager is null and cannot check network status", new Object[0]);
        }
        return connectivityManager;
    }

    @SuppressLint({"MissingPermission", "NewApi"})
    public static boolean f(Context context, w1 w1Var, s0 s0Var, ConnectivityManager.NetworkCallback networkCallback) {
        if (s0Var.d() < 24) {
            w1Var.c(s4.DEBUG, "NetworkCallbacks need Android N+.", new Object[0]);
            return false;
        }
        ConnectivityManager connectivityManagerE = e(context, w1Var);
        if (connectivityManagerE == null) {
            return false;
        }
        if (!q.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            w1Var.c(s4.INFO, "No permission (ACCESS_NETWORK_STATE) to check network status.", new Object[0]);
            return false;
        }
        try {
            connectivityManagerE.registerDefaultNetworkCallback(networkCallback);
            return true;
        } catch (Throwable th) {
            w1Var.b(s4.ERROR, "registerDefaultNetworkCallback failed", th);
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static void g(Context context, w1 w1Var, s0 s0Var, ConnectivityManager.NetworkCallback networkCallback) {
        ConnectivityManager connectivityManagerE;
        if (s0Var.d() >= 21 && (connectivityManagerE = e(context, w1Var)) != null) {
            try {
                connectivityManagerE.unregisterNetworkCallback(networkCallback);
            } catch (Throwable th) {
                w1Var.b(s4.ERROR, "unregisterNetworkCallback failed", th);
            }
        }
    }
}
