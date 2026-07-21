package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzawz extends zzbad {
    public static void l(String str, Throwable th) {
        if (n()) {
            Log.v("Ads", str, th);
        }
    }

    public static void m(String str) {
        if (n()) {
            Log.v("Ads", str);
        }
    }

    public static boolean n() {
        if (zzbad.a(2)) {
            return ((Boolean) zzyt.e().c(zzacu.N1)).booleanValue();
        }
        return false;
    }
}
