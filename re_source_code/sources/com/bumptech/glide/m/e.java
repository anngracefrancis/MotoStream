package com.bumptech.glide.m;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes.dex */
final class e implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f9450f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final c.a f9451g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f9452h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f9453i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final BroadcastReceiver f9454j = new a();

    /* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f9452h;
            eVar.f9452h = eVar.a(context);
            if (z != e.this.f9452h) {
                if (Log.isLoggable("ConnectivityMonitor", 3)) {
                    Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + e.this.f9452h);
                }
                e eVar2 = e.this;
                eVar2.f9451g.a(eVar2.f9452h);
            }
        }
    }

    e(Context context, c.a aVar) {
        this.f9450f = context.getApplicationContext();
        this.f9451g = aVar;
    }

    private void b() {
        if (this.f9453i) {
            return;
        }
        this.f9452h = a(this.f9450f);
        try {
            this.f9450f.registerReceiver(this.f9454j, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f9453i = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    private void c() {
        if (this.f9453i) {
            this.f9450f.unregisterReceiver(this.f9454j);
            this.f9453i = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.bumptech.glide.r.j.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.m.i
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.m.i
    public void onStart() {
        b();
    }

    @Override // com.bumptech.glide.m.i
    public void onStop() {
        c();
    }
}
