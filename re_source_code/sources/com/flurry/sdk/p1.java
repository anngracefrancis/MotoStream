package com.flurry.sdk;

import android.app.ActivityManager;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class p1 {
    private static String[] a = {"resource", "http"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int[] f10992b = {4, 8};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f10993c = 4 | 8;

    public static ActivityManager.MemoryInfo a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }
}
