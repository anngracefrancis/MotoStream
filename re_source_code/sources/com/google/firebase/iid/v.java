package com.google.firebase.iid;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class v implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f19662f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PowerManager.WakeLock f19663g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final FirebaseInstanceId f19664h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    ExecutorService f19665i = b.b();

    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    @VisibleForTesting
    static class a extends BroadcastReceiver {
        private v a;

        public a(v vVar) {
            this.a = vVar;
        }

        public void a() {
            if (FirebaseInstanceId.s()) {
                Log.d("FirebaseInstanceId", "Connectivity change received registered");
            }
            this.a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            v vVar = this.a;
            if (vVar != null && vVar.c()) {
                if (FirebaseInstanceId.s()) {
                    Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
                }
                this.a.f19664h.f(this.a, 0L);
                this.a.b().unregisterReceiver(this);
                this.a = null;
            }
        }
    }

    @VisibleForTesting
    v(FirebaseInstanceId firebaseInstanceId, long j2) {
        this.f19664h = firebaseInstanceId;
        this.f19662f = j2;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) b().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.f19663g = wakeLockNewWakeLock;
        wakeLockNewWakeLock.setReferenceCounted(false);
    }

    Context b() {
        return this.f19664h.g().i();
    }

    boolean c() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @VisibleForTesting
    boolean d() throws IOException {
        if (!this.f19664h.H(this.f19664h.q())) {
            return true;
        }
        try {
            if (this.f19664h.d() == null) {
                Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                return false;
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "Token successfully retrieved");
            }
            return true;
        } catch (IOException e2) {
            if (!k.f(e2.getMessage())) {
                if (e2.getMessage() != null) {
                    throw e2;
                }
                Log.w("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            }
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
            sb.append("Token retrieval failed: ");
            sb.append(message);
            sb.append(". Will retry token retrieval");
            Log.w("FirebaseInstanceId", sb.toString());
            return false;
        } catch (SecurityException unused) {
            Log.w("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
            return false;
        }
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public void run() {
        if (t.a().c(b())) {
            this.f19663g.acquire();
        }
        try {
            this.f19664h.D(true);
            if (!this.f19664h.t()) {
                this.f19664h.D(false);
                if (!t.a().c(b())) {
                }
            } else if (!t.a().b(b()) || c()) {
                if (d()) {
                    this.f19664h.D(false);
                } else {
                    this.f19664h.G(this.f19662f);
                }
                if (!t.a().c(b())) {
                }
            } else {
                new a(this).a();
                if (!t.a().c(b())) {
                }
            }
        } catch (IOException e2) {
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
            sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
            sb.append(message);
            sb.append(". Won't retry the operation.");
            Log.e("FirebaseInstanceId", sb.toString());
            this.f19664h.D(false);
            if (!t.a().c(b())) {
            }
        } finally {
            if (t.a().c(b())) {
                this.f19663g.release();
            }
        }
    }
}
