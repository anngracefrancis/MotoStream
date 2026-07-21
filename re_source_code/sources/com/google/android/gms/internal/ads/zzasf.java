package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class zzasf {
    private int A;
    private String B;
    private boolean C;
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f14131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14135f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f14136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14140k;
    private int l;
    private double m;
    private boolean n;
    private String o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private boolean t;
    private final boolean u;
    private boolean v;
    private String w;
    private String x;
    private float y;
    private int z;

    public zzasf(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        c(context);
        d(context);
        e(context);
        Locale locale = Locale.getDefault();
        this.q = a(packageManager, "geo:0,0?q=donuts") != null;
        this.r = a(packageManager, "http://www.google.com") != null;
        this.s = locale.getCountry();
        zzyt.a();
        this.t = zzazt.v();
        this.u = DeviceProperties.a(context);
        this.v = DeviceProperties.b(context);
        this.w = locale.getLanguage();
        this.x = b(context, packageManager);
        this.B = f(context);
        Resources resources = context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            return;
        }
        this.y = displayMetrics.density;
        this.z = displayMetrics.widthPixels;
        this.A = displayMetrics.heightPixels;
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzk.zzlk().e(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String b(Context context, PackageManager packageManager) {
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

    private final void c(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.a = audioManager.getMode();
                this.f14131b = audioManager.isMusicActive();
                this.f14132c = audioManager.isSpeakerphoneOn();
                this.f14133d = audioManager.getStreamVolume(3);
                this.f14134e = audioManager.getRingerMode();
                this.f14135f = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzk.zzlk().e(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.a = -2;
        this.f14131b = false;
        this.f14132c = false;
        this.f14133d = 0;
        this.f14134e = 2;
        this.f14135f = 0;
    }

    @TargetApi(16)
    private final void d(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.f14136g = telephonyManager.getNetworkOperator();
        this.f14138i = telephonyManager.getNetworkType();
        this.f14139j = telephonyManager.getPhoneType();
        this.f14137h = -2;
        this.f14140k = false;
        this.l = -1;
        zzk.zzlg();
        if (zzaxi.f0(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.f14137h = activeNetworkInfo.getType();
                this.l = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.f14137h = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                this.f14140k = connectivityManager.isActiveNetworkMetered();
            }
        }
    }

    private final void e(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver == null) {
            this.m = -1.0d;
            this.n = false;
        } else {
            int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
            this.m = intentRegisterReceiver.getIntExtra("level", -1) / intentRegisterReceiver.getIntExtra("scale", -1);
            this.n = intExtra == 2 || intExtra == 5;
        }
    }

    private static String f(Context context) {
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

    public final zzase g() {
        return new zzase(this.a, this.q, this.r, this.f14136g, this.s, this.t, this.u, this.v, this.f14131b, this.f14132c, this.w, this.x, this.B, this.f14133d, this.f14137h, this.f14138i, this.f14139j, this.f14134e, this.f14135f, this.y, this.z, this.A, this.m, this.n, this.f14140k, this.l, this.o, this.C, this.p);
    }

    public zzasf(Context context, zzase zzaseVar) {
        c(context);
        d(context);
        e(context);
        this.o = Build.FINGERPRINT;
        this.p = Build.DEVICE;
        this.C = PlatformVersion.b() && zzads.a(context);
        this.q = zzaseVar.f14121b;
        this.r = zzaseVar.f14122c;
        this.s = zzaseVar.f14124e;
        this.t = zzaseVar.f14125f;
        this.u = zzaseVar.f14126g;
        this.v = zzaseVar.f14127h;
        this.w = zzaseVar.f14130k;
        this.x = zzaseVar.l;
        this.B = zzaseVar.m;
        this.y = zzaseVar.t;
        this.z = zzaseVar.u;
        this.A = zzaseVar.v;
    }
}
