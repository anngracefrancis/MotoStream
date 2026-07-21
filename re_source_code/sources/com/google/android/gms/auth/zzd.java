package com.google.android.gms.auth;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import com.google.android.gms.common.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class zzd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final String f11548b = "callerUid";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final String f11549c = "androidPackageName";
    private static final String[] a = {"com.google", "com.google.work", "cn.google"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ComponentName f11550d = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Logger f11551e = new Logger("Auth", "GoogleAuthUtil");

    zzd() {
    }
}
