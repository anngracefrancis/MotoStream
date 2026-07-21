package com.bumptech.glide.load.o.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

/* JADX INFO: compiled from: HardwareConfigState.java */
/* JADX INFO: loaded from: classes.dex */
final class q {
    private static final File a = new File("/proc/self/fd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile q f9383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile int f9384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f9385d = true;

    private q() {
    }

    static q a() {
        if (f9383b == null) {
            synchronized (q.class) {
                if (f9383b == null) {
                    f9383b = new q();
                }
            }
        }
        return f9383b;
    }

    private synchronized boolean b() {
        boolean z = true;
        int i2 = this.f9384c + 1;
        this.f9384c = i2;
        if (i2 >= 50) {
            this.f9384c = 0;
            int length = a.list().length;
            if (length >= 700) {
                z = false;
            }
            this.f9385d = z;
            if (!this.f9385d && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit 700");
            }
        }
        return this.f9385d;
    }

    @TargetApi(26)
    boolean c(int i2, int i3, BitmapFactory.Options options, com.bumptech.glide.load.b bVar, boolean z, boolean z2) {
        if (!z || Build.VERSION.SDK_INT < 26 || z2) {
            return false;
        }
        boolean z3 = i2 >= 128 && i3 >= 128 && b();
        if (z3) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return z3;
    }
}
