package com.google.firebase.w;

import android.os.Build;
import android.os.Trace;

/* JADX INFO: compiled from: FirebaseTrace.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static void a() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }

    public static void b(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }
}
