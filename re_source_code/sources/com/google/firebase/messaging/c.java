package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class c {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f19805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h0 f19806c;

    public c(Context context, h0 h0Var, Executor executor) {
        this.a = executor;
        this.f19805b = context;
        this.f19806c = h0Var;
    }

    private boolean b() {
        if (((KeyguardManager) this.f19805b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            return false;
        }
        if (!PlatformVersion.h()) {
            SystemClock.sleep(10L);
        }
        int iMyPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f19805b.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    if (runningAppProcessInfo.importance == 100) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void c(a.C0233a c0233a) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.f19805b.getSystemService("notification")).notify(c0233a.f19791b, c0233a.f19792c, c0233a.a.c());
    }

    private d0 d() {
        d0 d0VarC = d0.c(this.f19806c.p("gcm.n.image"));
        if (d0VarC != null) {
            d0VarC.e(this.a);
        }
        return d0VarC;
    }

    private void e(androidx.core.app.i.e eVar, d0 d0Var) {
        if (d0Var == null) {
            return;
        }
        try {
            Bitmap bitmap = (Bitmap) Tasks.b(d0Var.d(), 5L, TimeUnit.SECONDS);
            eVar.p(bitmap);
            eVar.A(new androidx.core.app.i.b().i(bitmap).h(null));
        } catch (InterruptedException unused) {
            Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
            d0Var.close();
            Thread.currentThread().interrupt();
        } catch (ExecutionException e2) {
            String strValueOf = String.valueOf(e2.getCause());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 26);
            sb.append("Failed to download image: ");
            sb.append(strValueOf);
            Log.w("FirebaseMessaging", sb.toString());
        } catch (TimeoutException unused2) {
            Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
            d0Var.close();
        }
    }

    boolean a() {
        if (this.f19806c.a("gcm.n.noui")) {
            return true;
        }
        if (b()) {
            return false;
        }
        d0 d0VarD = d();
        a.C0233a c0233aD = a.d(this.f19805b, this.f19806c);
        e(c0233aD.a, d0VarD);
        c(c0233aD);
        return true;
    }
}
