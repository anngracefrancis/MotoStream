package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzw {
    private final boolean a = false;

    zzw(Context context) {
    }

    public static boolean a() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
