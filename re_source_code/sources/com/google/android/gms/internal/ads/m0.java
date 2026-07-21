package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class m0 implements zzaho<zzbgz> {
    m0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        WindowManager windowManager = (WindowManager) zzbgzVar2.getContext().getSystemService("window");
        zzk.zzlg();
        DisplayMetrics displayMetricsB = zzaxi.b(windowManager);
        int i2 = displayMetricsB.widthPixels;
        int i3 = displayMetricsB.heightPixels;
        int[] iArr = new int[2];
        HashMap map2 = new HashMap();
        ((View) zzbgzVar2).getLocationInWindow(iArr);
        map2.put("xInPixels", Integer.valueOf(iArr[0]));
        map2.put("yInPixels", Integer.valueOf(iArr[1]));
        map2.put("windowWidthInPixels", Integer.valueOf(i2));
        map2.put("windowHeightInPixels", Integer.valueOf(i3));
        zzbgzVar2.y("locationReady", map2);
        zzbad.i("GET LOCATION COMPILED");
    }
}
