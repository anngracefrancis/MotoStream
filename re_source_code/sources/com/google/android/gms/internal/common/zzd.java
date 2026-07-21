package com.google.android.gms.internal.common;

import android.os.Build;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzd {
    public static final int a;

    static {
        a = Build.VERSION.SDK_INT >= 23 ? 67108864 : 0;
    }
}
