package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class u0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f19873f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Boolean f19874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Boolean f19875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Context f19876i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final g0 f19877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PowerManager.WakeLock f19878k;
    private final t0 l;
    private final long m;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    class a extends BroadcastReceiver {
        private u0 a;

        public a(u0 u0Var) {
            this.a = u0Var;
        }

        public void a() {
            if (u0.j()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            u0.this.f19876i.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            u0 u0Var = this.a;
            if (u0Var == null) {
                return;
            }
            if (u0Var.i()) {
                if (u0.j()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.a.l.k(this.a, 0L);
                context.unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    u0(t0 t0Var, Context context, g0 g0Var, long j2) {
        this.l = t0Var;
        this.f19876i = context;
        this.m = j2;
        this.f19877j = g0Var;
        this.f19878k = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static String e(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 142);
        sb.append("Missing Permission: ");
        sb.append(str);
        sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        return sb.toString();
    }

    private static boolean f(Context context) {
        boolean zBooleanValue;
        synchronized (f19873f) {
            Boolean bool = f19875h;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.ACCESS_NETWORK_STATE", bool) : bool.booleanValue());
            f19875h = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    private static boolean g(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (z || !Log.isLoggable("FirebaseMessaging", 3)) {
            return z;
        }
        Log.d("FirebaseMessaging", e(str));
        return false;
    }

    private static boolean h(Context context) {
        boolean zBooleanValue;
        synchronized (f19873f) {
            Boolean bool = f19874g;
            Boolean boolValueOf = Boolean.valueOf(bool == null ? g(context, "android.permission.WAKE_LOCK", bool) : bool.booleanValue());
            f19874g = boolValueOf;
            zBooleanValue = boolValueOf.booleanValue();
        }
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean i() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f19876i.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (h(this.f19876i)) {
            this.f19878k.acquire(b.a);
        }
        try {
            this.l.l(true);
            if (!this.f19877j.g()) {
                this.l.l(false);
            } else if (f(this.f19876i) && !i()) {
                new a(this).a();
            } else {
                if (this.l.o()) {
                    this.l.l(false);
                } else {
                    this.l.p(this.m);
                }
            }
        } catch (IOException e2) {
            String strValueOf = String.valueOf(e2.getMessage());
            Log.e("FirebaseMessaging", strValueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(strValueOf) : new String("Failed to sync topics. Won't retry sync. "));
            this.l.l(false);
        } finally {
            if (h(this.f19876i)) {
                try {
                    this.f19878k.release();
                } catch (RuntimeException unused) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
        }
    }
}
