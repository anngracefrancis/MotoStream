package com.bumptech.glide.m;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: DefaultConnectivityMonitorFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {
    @Override // com.bumptech.glide.m.d
    public c a(Context context, c.a aVar) {
        boolean z = androidx.core.content.a.a(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new e(context, aVar) : new j();
    }
}
