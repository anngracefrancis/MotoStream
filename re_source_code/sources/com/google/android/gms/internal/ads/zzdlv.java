package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdlv {
    public static boolean a() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
