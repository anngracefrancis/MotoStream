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
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class p0 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PowerManager.WakeLock f19846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final FirebaseMessaging f19847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    ExecutorService f19848i = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("firebase-iid-executor"));

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    @VisibleForTesting
    static class a extends BroadcastReceiver {
        private p0 a;

        public a(p0 p0Var) {
            this.a = p0Var;
        }

        public void a() {
            if (p0.c()) {
                Log.d("FirebaseMessaging", "Connectivity change received registered");
            }
            this.a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            p0 p0Var = this.a;
            if (p0Var != null && p0Var.d()) {
                if (p0.c()) {
                    Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
                }
                this.a.f19847h.e(this.a, 0L);
                this.a.b().unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    @VisibleForTesting
    @SuppressLint({"InvalidWakeLockTag"})
    public p0(FirebaseMessaging firebaseMessaging, long j2) {
        this.f19847h = firebaseMessaging;
        this.f19845f = j2;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f19846g = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    static boolean c() {
        return Log.isLoggable("FirebaseMessaging", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3));
    }

    Context b() {
        return this.f19847h.f();
    }

    boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    boolean e() throws IOException {
        try {
            if (this.f19847h.c() == null) {
                Log.e("FirebaseMessaging", "Token retrieval failed: null");
                return false;
            }
            if (!Log.isLoggable("FirebaseMessaging", 3)) {
                return true;
            }
            Log.d("FirebaseMessaging", "Token successfully retrieved");
            return true;
        } catch (IOException e2) {
            if (!b0.f(e2.getMessage())) {
                if (e2.getMessage() != null) {
                    throw e2;
                }
                Log.w("FirebaseMessaging", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
            sb.append("Token retrieval failed: ");
            sb.append(message);
            sb.append(". Will retry token retrieval");
            Log.w("FirebaseMessaging", sb.toString());
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseMessaging", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"WakelockTimeout"})
    public void run() {
        if (l0.b().e(b())) {
            this.f19846g.acquire();
        }
        try {
            this.f19847h.q(true);
            if (!this.f19847h.l()) {
                this.f19847h.q(false);
                if (!l0.b().e(b())) {
                }
            } else if (!l0.b().d(b()) || d()) {
                if (e()) {
                    this.f19847h.q(false);
                } else {
                    this.f19847h.t(this.f19845f);
                }
                if (!l0.b().e(b())) {
                }
            } else {
                new a(this).a();
                if (!l0.b().e(b())) {
                }
            }
        } catch (IOException e2) {
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseMessaging", sb.toString());
            this.f19847h.q(false);
            if (!l0.b().e(b())) {
            }
        } finally {
            if (l0.b().e(b())) {
                this.f19846g.release();
            }
        }
    }
}
