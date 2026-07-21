package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzag {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f12053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f12054d;

    public static int a(Context context) {
        c(context);
        return f12054d;
    }

    public static String b(Context context) {
        c(context);
        return f12053c;
    }

    private static void c(Context context) {
        synchronized (a) {
            if (f12052b) {
                return;
            }
            f12052b = true;
            try {
                Bundle bundle = Wrappers.a(context).c(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f12053c = bundle.getString("com.google.app.id");
                f12054d = bundle.getInt("com.google.android.gms.version");
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
        }
    }
}
