package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
final class cp implements zzcva<zzcvf> {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12434b;

    public cp(zzbbl zzbblVar, Context context) {
        this.a = zzbblVar;
        this.f12434b = context;
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    private static String c(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo resolveInfoA = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (resolveInfoA == null || (activityInfo = resolveInfoA.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfoE = Wrappers.a(context).e(activityInfo.packageName, 0);
            if (packageInfoE != null) {
                int i2 = packageInfoE.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String e(Context context) {
        try {
            PackageInfo packageInfoE = Wrappers.a(context).e("com.android.vending", 128);
            if (packageInfoE != null) {
                int i2 = packageInfoE.versionCode;
                String str = packageInfoE.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvf> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.dp

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final cp f12483f;

            {
                this.f12483f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12483f.d();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:22:0x009b  */
    final /* synthetic */ zzcvf d() throws Exception {
        boolean zEquals;
        PackageManager packageManager = this.f12434b.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z = a(packageManager, "geo:0,0?q=donuts") != null;
        boolean z2 = a(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean zStartsWith = Build.DEVICE.startsWith("generic");
        boolean zA = DeviceProperties.a(this.f12434b);
        boolean zB = DeviceProperties.b(this.f12434b);
        String language = locale.getLanguage();
        String strC = c(this.f12434b, packageManager);
        String strE = e(this.f12434b);
        String str = Build.FINGERPRINT;
        Context context = this.f12434b;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities == null || resolveInfoResolveActivity == null) {
                zEquals = false;
            } else {
                for (int i2 = 0; i2 < listQueryIntentActivities.size(); i2++) {
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i2).activityInfo.name)) {
                        zEquals = resolveInfoResolveActivity.activityInfo.packageName.equals(zzdtv.a(context));
                    }
                }
                zEquals = false;
            }
        } else {
            zEquals = false;
        }
        return new zzcvf(z, z2, country, zStartsWith, zA, zB, language, strC, strE, str, zEquals, Build.MODEL);
    }
}
