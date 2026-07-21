package com.google.firebase.iid;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class t {
    private static t a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f19655b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Boolean f19656c = null;

    private t() {
    }

    @KeepForSdk
    public static synchronized t a() {
        if (a == null) {
            a = new t();
        }
        return a;
    }

    boolean b(Context context) {
        if (this.f19656c == null) {
            this.f19656c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.f19655b.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f19656c.booleanValue();
    }

    boolean c(Context context) {
        if (this.f19655b == null) {
            this.f19655b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.f19655b.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f19655b.booleanValue();
    }
}
