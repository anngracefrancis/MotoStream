package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawr {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @VisibleForTesting
    private final String f14232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzaxb f14233h;

    @VisibleForTesting
    private long a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private long f14227b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private int f14228c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    int f14229d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @VisibleForTesting
    private long f14230e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f14231f = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    private int f14234i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @VisibleForTesting
    private int f14235j = 0;

    public zzawr(String str, zzaxb zzaxbVar) {
        this.f14232g = str;
        this.f14233h = zzaxbVar;
    }

    private static boolean b(Context context) {
        Context contextF = zzasq.f(context);
        int identifier = contextF.getResources().getIdentifier("Theme.Translucent", "style", "android");
        if (identifier == 0) {
            zzbad.h("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == contextF.getPackageManager().getActivityInfo(new ComponentName(contextF.getPackageName(), AdActivity.CLASS_NAME), 0).theme) {
                return true;
            }
            zzbad.h("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzbad.i("Fail to fetch AdActivity theme");
            zzbad.h("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final void a(zzxz zzxzVar, long j2) {
        Bundle bundle;
        synchronized (this.f14231f) {
            long jM = this.f14233h.m();
            long jA = zzk.zzln().a();
            if (this.f14227b == -1) {
                if (jA - jM > ((Long) zzyt.e().c(zzacu.f1)).longValue()) {
                    this.f14229d = -1;
                } else {
                    this.f14229d = this.f14233h.i();
                }
                this.f14227b = j2;
                this.a = j2;
            } else {
                this.a = j2;
            }
            if (zzxzVar == null || (bundle = zzxzVar.f16970h) == null || bundle.getInt("gw", 2) != 1) {
                this.f14228c++;
                int i2 = this.f14229d + 1;
                this.f14229d = i2;
                if (i2 == 0) {
                    this.f14230e = 0L;
                    this.f14233h.x(jA);
                } else {
                    this.f14230e = jA - this.f14233h.d();
                }
            }
        }
    }

    public final Bundle c(Context context, String str) {
        Bundle bundle;
        synchronized (this.f14231f) {
            bundle = new Bundle();
            bundle.putString("session_id", this.f14232g);
            bundle.putLong("basets", this.f14227b);
            bundle.putLong("currts", this.a);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.f14228c);
            bundle.putInt("preqs_in_session", this.f14229d);
            bundle.putLong("time_in_session", this.f14230e);
            bundle.putInt("pclick", this.f14234i);
            bundle.putInt("pimp", this.f14235j);
            bundle.putBoolean("support_transparent_background", b(context));
        }
        return bundle;
    }

    public final void d() {
        synchronized (this.f14231f) {
            this.f14235j++;
        }
    }

    public final void e() {
        synchronized (this.f14231f) {
            this.f14234i++;
        }
    }
}
