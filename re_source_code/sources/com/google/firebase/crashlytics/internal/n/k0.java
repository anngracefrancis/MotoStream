package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: InstallerPackageNameProvider.java */
/* JADX INFO: loaded from: classes2.dex */
class k0 {
    private String a;

    k0() {
    }

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? HttpUrl.FRAGMENT_ENCODE_SET : installerPackageName;
    }

    synchronized String a(Context context) {
        if (this.a == null) {
            this.a = b(context);
        }
        return HttpUrl.FRAGMENT_ENCODE_SET.equals(this.a) ? null : this.a;
    }
}
