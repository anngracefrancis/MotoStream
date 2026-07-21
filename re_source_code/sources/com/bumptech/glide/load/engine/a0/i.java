package com.bumptech.glide.load.engine.a0;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: compiled from: MemorySizeCalculator.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f9066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9067d;

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    public static final class a {
        static final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Context f9068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ActivityManager f9069c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c f9070d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        float f9072f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        float f9071e = 2.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f9073g = 0.4f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float f9074h = 0.33f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f9075i = 4194304;

        static {
            a = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f9072f = a;
            this.f9068b = context;
            this.f9069c = (ActivityManager) context.getSystemService("activity");
            this.f9070d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !i.e(this.f9069c)) {
                return;
            }
            this.f9072f = 0.0f;
        }

        public i a() {
            return new i(this);
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    private static final class b implements c {
        private final DisplayMetrics a;

        b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // com.bumptech.glide.load.engine.a0.i.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // com.bumptech.glide.load.engine.a0.i.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    /* JADX INFO: compiled from: MemorySizeCalculator.java */
    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.f9066c = aVar.f9068b;
        int i2 = e(aVar.f9069c) ? aVar.f9075i / 2 : aVar.f9075i;
        this.f9067d = i2;
        int iC = c(aVar.f9069c, aVar.f9073g, aVar.f9074h);
        float fB = aVar.f9070d.b() * aVar.f9070d.a() * 4;
        int iRound = Math.round(aVar.f9072f * fB);
        int iRound2 = Math.round(fB * aVar.f9071e);
        int i3 = iC - i2;
        int i4 = iRound2 + iRound;
        if (i4 <= i3) {
            this.f9065b = iRound2;
            this.a = iRound;
        } else {
            float f2 = i3;
            float f3 = aVar.f9072f;
            float f4 = aVar.f9071e;
            float f5 = f2 / (f3 + f4);
            this.f9065b = Math.round(f4 * f5);
            this.a = Math.round(f5 * aVar.f9072f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f9065b));
            sb.append(", pool size: ");
            sb.append(f(this.a));
            sb.append(", byte array size: ");
            sb.append(f(i2));
            sb.append(", memory class limited? ");
            sb.append(i4 > iC);
            sb.append(", max size: ");
            sb.append(f(iC));
            sb.append(", memoryClass: ");
            sb.append(aVar.f9069c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.f9069c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e(activityManager)) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i2) {
        return Formatter.formatFileSize(this.f9066c, i2);
    }

    public int a() {
        return this.f9067d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.f9065b;
    }
}
