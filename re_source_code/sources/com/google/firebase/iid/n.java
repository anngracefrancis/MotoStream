package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class n {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19652e = 0;

    public n(Context context) {
        this.a = context;
    }

    public static String c(com.google.firebase.j jVar) {
        String strD = jVar.l().d();
        if (strD != null) {
            return strD;
        }
        String strC = jVar.l().c();
        if (!strC.startsWith("1:")) {
            return strC;
        }
        String[] strArrSplit = strC.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private PackageInfo f(String str) {
        try {
            return this.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
            sb.append("Failed to find package ");
            sb.append(strValueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    private synchronized void h() {
        PackageInfo packageInfoF = f(this.a.getPackageName());
        if (packageInfoF != null) {
            this.f19649b = Integer.toString(packageInfoF.versionCode);
            this.f19650c = packageInfoF.versionName;
        }
    }

    public synchronized String a() {
        if (this.f19649b == null) {
            h();
        }
        return this.f19649b;
    }

    public synchronized String b() {
        if (this.f19650c == null) {
            h();
        }
        return this.f19650c;
    }

    public synchronized int d() {
        PackageInfo packageInfoF;
        if (this.f19651d == 0 && (packageInfoF = f("com.google.android.gms")) != null) {
            this.f19651d = packageInfoF.versionCode;
        }
        return this.f19651d;
    }

    public synchronized int e() {
        int i2 = this.f19652e;
        if (i2 != 0) {
            return i2;
        }
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        int i3 = 1;
        if (!PlatformVersion.k()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                this.f19652e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
            this.f19652e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (PlatformVersion.k()) {
            this.f19652e = 2;
            i3 = 2;
        } else {
            this.f19652e = 1;
        }
        return i3;
    }

    @KeepForSdk
    public boolean g() {
        return e() != 0;
    }
}
