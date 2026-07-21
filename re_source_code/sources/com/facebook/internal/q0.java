package com.facebook.internal;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.FacebookSdkNotInitializedException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Validate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q0 {
    public static final q0 a = new q0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9837b = q0.class.getName();

    private q0() {
    }

    public static final <T> void a(Collection<? extends T> collection, String str) {
        kotlin.jvm.internal.m.f(collection, "container");
        kotlin.jvm.internal.m.f(str, "name");
        Iterator<? extends T> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("Container '" + str + "' cannot contain null values");
            }
        }
    }

    public static final String b() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String strD = com.facebook.a0.d();
        if (strD != null) {
            return strD;
        }
        throw new IllegalStateException("No App ID found, please set the App ID.".toString());
    }

    public static final String c() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        String strI = com.facebook.a0.i();
        if (strI != null) {
            return strI;
        }
        throw new IllegalStateException("No Client Token found, please set the Client Token. Please follow https://developers.facebook.com/docs/android/getting-started/#client-access-token to get the token and fill it in AndroidManifest.xml".toString());
    }

    public static final boolean d(Context context, String str) {
        List<ResolveInfo> listQueryIntentActivities;
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "redirectURI");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setData(Uri.parse(str));
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 64);
        } else {
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        boolean z = false;
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (!kotlin.jvm.internal.m.a(activityInfo.name, "com.facebook.CustomTabActivity") || !kotlin.jvm.internal.m.a(activityInfo.packageName, context.getPackageName())) {
                return false;
            }
            z = true;
        }
        return z;
    }

    @SuppressLint({"WrongConstant"})
    public static final void e(Context context, boolean z) {
        ActivityInfo activityInfo;
        kotlin.jvm.internal.m.f(context, "context");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                activityInfo = packageManager.getActivityInfo(new ComponentName(context, "com.facebook.FacebookActivity"), 1);
            } catch (PackageManager.NameNotFoundException unused) {
                activityInfo = null;
            }
        } else {
            activityInfo = null;
        }
        if (activityInfo == null) {
            if (!(!z)) {
                throw new IllegalStateException("FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.".toString());
            }
            Log.w(f9837b, "FacebookActivity is not declared in the AndroidManifest.xml. If you are using the facebook-common module or dependent modules please add com.facebook.FacebookActivity to your AndroidManifest.xml file. See https://developers.facebook.com/docs/android/getting-started for more info.");
        }
    }

    public static final void f(Context context, boolean z) {
        kotlin.jvm.internal.m.f(context, "context");
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") == -1) {
            if (!(!z)) {
                throw new IllegalStateException("No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.".toString());
            }
            Log.w(f9837b, "No internet permissions granted for the app, please add <uses-permission android:name=\"android.permission.INTERNET\" /> to your AndroidManifest.xml.");
        }
    }

    public static final void g(String str, String str2) {
        kotlin.jvm.internal.m.f(str, "arg");
        kotlin.jvm.internal.m.f(str2, "name");
        if (str.length() > 0) {
            return;
        }
        throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be empty").toString());
    }

    public static final <T> void h(Collection<? extends T> collection, String str) {
        kotlin.jvm.internal.m.f(collection, "container");
        kotlin.jvm.internal.m.f(str, "name");
        if (!collection.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException(("Container '" + str + "' cannot be empty").toString());
    }

    public static final <T> void i(Collection<? extends T> collection, String str) {
        kotlin.jvm.internal.m.f(collection, "container");
        kotlin.jvm.internal.m.f(str, "name");
        a(collection, str);
        h(collection, str);
    }

    public static final void j(Object obj, String str) {
        kotlin.jvm.internal.m.f(str, "name");
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument '" + str + "' cannot be null");
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0015  */
    public static final String k(String str, String str2) {
        boolean z;
        kotlin.jvm.internal.m.f(str2, "name");
        if (str != null) {
            z = str.length() > 0;
        }
        if (z) {
            return str;
        }
        throw new IllegalArgumentException(("Argument '" + str2 + "' cannot be null or empty").toString());
    }

    public static final void l() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (!com.facebook.a0.w()) {
            throw new FacebookSdkNotInitializedException("The SDK has not been initialized, make sure to call FacebookSdk.sdkInitialize() first.");
        }
    }
}
