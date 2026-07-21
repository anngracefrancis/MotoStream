package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcya {
    public static void a(Throwable th, String str) {
        int iB = zzcgm.b(th);
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(iB);
        zzbad.h(sb.toString());
        zzawz.l(str, th);
        if (zzcgm.b(th) == 3) {
            return;
        }
        zzk.zzlk().h(th, str);
    }

    public static void b(Context context, boolean z) {
        if (z) {
            zzbad.h("This request is sent from a test device.");
            return;
        }
        zzyt.a();
        String strL = zzazt.l(context);
        StringBuilder sb = new StringBuilder(String.valueOf(strL).length() + 71);
        sb.append("Use AdRequest.Builder.addTestDevice(\"");
        sb.append(strL);
        sb.append("\") to get test ads on this device.");
        zzbad.h(sb.toString());
    }
}
