package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.crashlytics.internal.g;
import java.util.List;

/* JADX INFO: compiled from: AppData.java */
/* JADX INFO: loaded from: classes2.dex */
public class l {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<q> f19057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f19058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f19059e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f19060f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f19061g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f19062h;

    public l(String str, String str2, List<q> list, String str3, String str4, String str5, String str6, g gVar) {
        this.a = str;
        this.f19056b = str2;
        this.f19057c = list;
        this.f19058d = str3;
        this.f19059e = str4;
        this.f19060f = str5;
        this.f19061g = str6;
        this.f19062h = gVar;
    }

    public static l a(Context context, i0 i0Var, String str, String str2, List<q> list, g gVar) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String strG = i0Var.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String strB = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new l(str, str2, list, strG, packageName, strB, str3, gVar);
    }

    private static String b(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
    }
}
