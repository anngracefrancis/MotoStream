package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(17)
public final class zzazm {
    private static zzazm a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f14301b;

    private zzazm() {
    }

    public static zzazm a() {
        if (a == null) {
            a = new zzazm();
        }
        return a;
    }
}
