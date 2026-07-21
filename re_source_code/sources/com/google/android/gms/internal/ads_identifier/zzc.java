package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

/* JADX INFO: loaded from: classes2.dex */
public class zzc {
    private static final ClassLoader a = zzc.class.getClassLoader();

    private zzc() {
    }

    public static void a(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
