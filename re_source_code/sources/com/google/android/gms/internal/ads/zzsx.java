package com.google.android.gms.internal.ads;

import android.os.Trace;

/* JADX INFO: loaded from: classes2.dex */
public final class zzsx {
    public static void a(String str) {
        if (zzsy.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void b() {
        if (zzsy.a >= 18) {
            Trace.endSection();
        }
    }
}
