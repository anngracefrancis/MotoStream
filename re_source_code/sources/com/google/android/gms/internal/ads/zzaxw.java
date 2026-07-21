package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
public class zzaxw extends zzaxv {
    private static boolean w(int i2, int i3, int i4) {
        return Math.abs(i2 - i3) <= i4;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final boolean j(Activity activity, Configuration configuration) {
        if (!((Boolean) zzyt.e().c(zzacu.O3)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzyt.e().c(zzacu.Q3)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzyt.a();
        int iA = zzazt.a(activity, configuration.screenHeightDp);
        int iA2 = zzazt.a(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        zzk.zzlg();
        DisplayMetrics displayMetricsB = zzaxi.b(windowManager);
        int i2 = displayMetricsB.heightPixels;
        int i3 = displayMetricsB.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        double d2 = activity.getResources().getDisplayMetrics().density;
        Double.isNaN(d2);
        int iRound = ((int) Math.round(d2 + 0.5d)) * ((Integer) zzyt.e().c(zzacu.N3)).intValue();
        return !(w(i2, iA + dimensionPixelSize, iRound) && w(i3, iA2, iRound));
    }
}
