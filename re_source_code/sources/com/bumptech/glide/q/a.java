package com.bumptech.glide.q;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.f;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: ApplicationVersionSignature.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final ConcurrentMap<String, f> a = new ConcurrentHashMap();

    private static PackageInfo a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("AppVersionSignature", "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    private static String b(PackageInfo packageInfo) {
        return packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString();
    }

    public static f c(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, f> concurrentMap = a;
        f fVar = concurrentMap.get(packageName);
        if (fVar != null) {
            return fVar;
        }
        f fVarD = d(context);
        f fVarPutIfAbsent = concurrentMap.putIfAbsent(packageName, fVarD);
        return fVarPutIfAbsent == null ? fVarD : fVarPutIfAbsent;
    }

    private static f d(Context context) {
        return new c(b(a(context)));
    }
}
