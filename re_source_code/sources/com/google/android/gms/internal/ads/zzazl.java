package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.StrictMode;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazl {
    public static <T> T a(Context context, Callable<T> callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            T tCall = callable.call();
            StrictMode.setThreadPolicy(threadPolicy);
            return tCall;
        } catch (Throwable th) {
            try {
                zzbad.c("Unexpected exception.", th);
                zzaqx.f(context).a(th, "StrictModeUtil.runWithLaxStrictMode");
                return null;
            } finally {
                StrictMode.setThreadPolicy(threadPolicy);
            }
        }
    }

    public static <T> T b(Callable<T> callable) throws Exception {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().permitDiskWrites().build());
            return callable.call();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }
}
