package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzaht {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzdh f13902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f13903c;

    public zzaht(Context context, zzdh zzdhVar, View view) {
        this.a = context;
        this.f13902b = zzdhVar;
        this.f13903c = view;
    }

    private static Intent a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        return intent2;
    }

    @VisibleForTesting
    private final ResolveInfo b(Intent intent, ArrayList<ResolveInfo> arrayList) {
        ResolveInfo resolveInfo = null;
        try {
            PackageManager packageManager = this.a.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intent, 65536);
            if (listQueryIntentActivities != null && resolveInfoResolveActivity != null) {
                for (int i2 = 0; i2 < listQueryIntentActivities.size(); i2++) {
                    if (resolveInfoResolveActivity.activityInfo.name.equals(listQueryIntentActivities.get(i2).activityInfo.name)) {
                        resolveInfo = resolveInfoResolveActivity;
                        break;
                    }
                }
            }
            arrayList.addAll(listQueryIntentActivities);
        } catch (Throwable th) {
            zzk.zzlk().e(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
        return resolveInfo;
    }

    @VisibleForTesting
    private final ResolveInfo c(Intent intent) {
        return b(intent, new ArrayList<>());
    }

    private static Intent e(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0064  */
    @VisibleForTesting
    public final Intent d(Map<String, String> map) {
        boolean z;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo resolveInfoC;
        ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
        String str = map.get("u");
        Uri uriBuild = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri uri = Uri.parse(zzahs.b(this.a, this.f13902b, str, this.f13903c, null));
        boolean z2 = Boolean.parseBoolean(map.get("use_first_package"));
        boolean z3 = Boolean.parseBoolean(map.get("use_running_process"));
        if (Boolean.parseBoolean(map.get("use_custom_tabs"))) {
            z = true;
        } else if (((Boolean) zzyt.e().c(zzacu.F3)).booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        if ("http".equalsIgnoreCase(uri.getScheme())) {
            uriBuild = uri.buildUpon().scheme(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME).build();
        } else if (BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equalsIgnoreCase(uri.getScheme())) {
            uriBuild = uri.buildUpon().scheme("http").build();
        }
        ArrayList<ResolveInfo> arrayList = new ArrayList<>();
        Intent intentE = e(uri);
        Intent intentE2 = e(uriBuild);
        if (z) {
            zzk.zzlg();
            zzaxi.I(this.a, intentE);
            zzk.zzlg();
            zzaxi.I(this.a, intentE2);
        }
        ResolveInfo resolveInfoB = b(intentE, arrayList);
        if (resolveInfoB != null) {
            return a(intentE, resolveInfoB);
        }
        if (intentE2 != null && (resolveInfoC = c(intentE2)) != null) {
            Intent intentA = a(intentE, resolveInfoC);
            if (c(intentA) != null) {
                return intentA;
            }
        }
        if (arrayList.size() == 0) {
            return intentE;
        }
        if (z3 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                ResolveInfo resolveInfo = arrayList.get(i2);
                i2++;
                ResolveInfo resolveInfo2 = resolveInfo;
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    if (it.next().processName.equals(resolveInfo2.activityInfo.packageName)) {
                        return a(intentE, resolveInfo2);
                    }
                }
            }
        }
        return z2 ? a(intentE, arrayList.get(0)) : intentE;
    }
}
