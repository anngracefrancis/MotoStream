package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class l0 {
    private static l0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19827b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f19828c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Boolean f19829d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Queue<Intent> f19830e = new ArrayDeque();

    private l0() {
    }

    private int a(Context context, Intent intent) {
        ComponentName componentNameStartService;
        String strF = f(context, intent);
        if (strF != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", strF.length() != 0 ? "Restricting intent to a specific service: ".concat(strF) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), strF);
        }
        try {
            if (e(context)) {
                componentNameStartService = v0.e(context, intent);
            } else {
                componentNameStartService = context.startService(intent);
                Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
            }
            if (componentNameStartService != null) {
                return -1;
            }
            Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
            return 404;
        } catch (IllegalStateException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(strValueOf);
            Log.e("FirebaseMessaging", sb.toString());
            return 402;
        } catch (SecurityException e3) {
            Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", e3);
            return 401;
        }
    }

    static synchronized l0 b() {
        if (a == null) {
            a = new l0();
        }
        return a;
    }

    private synchronized String f(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.f19827b;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveInfoResolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfoResolveService != null && (serviceInfo = resolveInfoResolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    String strValueOf = String.valueOf(context.getPackageName());
                    String strValueOf2 = String.valueOf(serviceInfo.name);
                    this.f19827b = strValueOf2.length() != 0 ? strValueOf.concat(strValueOf2) : new String(strValueOf);
                } else {
                    this.f19827b = serviceInfo.name;
                }
                return this.f19827b;
            }
            String str3 = serviceInfo.packageName;
            String str4 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str3);
            sb.append("/");
            sb.append(str4);
            Log.e("FirebaseMessaging", sb.toString());
            return null;
        }
        Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    Intent c() {
        return this.f19830e.poll();
    }

    boolean d(Context context) {
        if (this.f19829d == null) {
            this.f19829d = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f19828c.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f19829d.booleanValue();
    }

    boolean e(Context context) {
        if (this.f19828c == null) {
            this.f19828c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f19828c.booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f19828c.booleanValue();
    }

    public int g(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Starting service");
        }
        this.f19830e.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return a(context, intent2);
    }
}
