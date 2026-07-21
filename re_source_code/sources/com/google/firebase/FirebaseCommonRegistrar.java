package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    static /* synthetic */ String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    static /* synthetic */ String b(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? HttpUrl.FRAGMENT_ENCODE_SET : String.valueOf(applicationInfo.minSdkVersion);
    }

    static /* synthetic */ String c(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 16 && context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
            return "tv";
        }
        if (i2 >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
            return "watch";
        }
        if (i2 < 23 || !context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            return (i2 < 26 || !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) ? HttpUrl.FRAGMENT_ENCODE_SET : "embedded";
        }
        return "auto";
    }

    static /* synthetic */ String d(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName != null ? e(installerPackageName) : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    private static String e(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<com.google.firebase.components.n<?>> getComponents() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.firebase.u.d.b());
        arrayList.add(com.google.firebase.r.f.c());
        arrayList.add(com.google.firebase.u.h.a("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(com.google.firebase.u.h.a("fire-core", "20.4.2"));
        arrayList.add(com.google.firebase.u.h.a("device-name", e(Build.PRODUCT)));
        arrayList.add(com.google.firebase.u.h.a("device-model", e(Build.DEVICE)));
        arrayList.add(com.google.firebase.u.h.a("device-brand", e(Build.BRAND)));
        arrayList.add(com.google.firebase.u.h.b("android-target-sdk", new com.google.firebase.u.h.a() { // from class: com.google.firebase.d
            @Override // com.google.firebase.u.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.a((Context) obj);
            }
        }));
        arrayList.add(com.google.firebase.u.h.b("android-min-sdk", new com.google.firebase.u.h.a() { // from class: com.google.firebase.e
            @Override // com.google.firebase.u.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.b((Context) obj);
            }
        }));
        arrayList.add(com.google.firebase.u.h.b("android-platform", new com.google.firebase.u.h.a() { // from class: com.google.firebase.f
            @Override // com.google.firebase.u.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.c((Context) obj);
            }
        }));
        arrayList.add(com.google.firebase.u.h.b("android-installer", new com.google.firebase.u.h.a() { // from class: com.google.firebase.c
            @Override // com.google.firebase.u.h.a
            public final String a(Object obj) {
                return FirebaseCommonRegistrar.d((Context) obj);
            }
        }));
        String strA = com.google.firebase.u.f.a();
        if (strA != null) {
            arrayList.add(com.google.firebase.u.h.a("kotlin", strA));
        }
        return arrayList;
    }
}
