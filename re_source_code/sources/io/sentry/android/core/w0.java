package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.sentry.s4;
import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: DeviceInfoUtil.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class w0 {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile w0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f22268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SentryAndroidOptions f22269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final s0 f22270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Boolean f22271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final t0.a f22272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final io.sentry.protocol.k f22273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Long f22274h;

    /* JADX INFO: compiled from: DeviceInfoUtil.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[io.sentry.android.core.internal.util.k.a.values().length];
            a = iArr;
            try {
                iArr[io.sentry.android.core.internal.util.k.a.NOT_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[io.sentry.android.core.internal.util.k.a.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public w0(Context context, SentryAndroidOptions sentryAndroidOptions) {
        this.f22268b = context;
        this.f22269c = sentryAndroidOptions;
        s0 s0Var = new s0(sentryAndroidOptions.getLogger());
        this.f22270d = s0Var;
        io.sentry.android.core.internal.util.m.a().c();
        this.f22273g = B();
        this.f22271e = s0Var.f();
        this.f22272f = t0.p(context, sentryAndroidOptions.getLogger(), s0Var);
        ActivityManager.MemoryInfo memoryInfoH = t0.h(context, sentryAndroidOptions.getLogger());
        if (memoryInfoH != null) {
            this.f22274h = q(memoryInfoH);
        } else {
            this.f22274h = null;
        }
    }

    private boolean A() {
        String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) && !Environment.isExternalStorageEmulated();
    }

    private void C(io.sentry.protocol.e eVar, boolean z) {
        Boolean bool;
        Intent intentD = d();
        if (intentD != null) {
            eVar.N(e(intentD));
            eVar.R(z(intentD));
            eVar.O(f(intentD));
        }
        int i2 = a.a[io.sentry.android.core.internal.util.k.b(this.f22268b, this.f22269c.getLogger()).ordinal()];
        if (i2 != 1) {
            bool = i2 != 2 ? null : Boolean.TRUE;
        } else {
            bool = Boolean.FALSE;
        }
        eVar.h0(bool);
        ActivityManager.MemoryInfo memoryInfoH = t0.h(this.f22268b, this.f22269c.getLogger());
        if (memoryInfoH != null && z) {
            eVar.W(Long.valueOf(memoryInfoH.availMem));
            eVar.b0(Boolean.valueOf(memoryInfoH.lowMemory));
        }
        File externalFilesDir = this.f22268b.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            StatFs statFs = new StatFs(externalFilesDir.getPath());
            eVar.q0(w(statFs));
            eVar.X(y(statFs));
        }
        StatFs statFsO = o(externalFilesDir);
        if (statFsO != null) {
            eVar.U(v(statFsO));
            eVar.T(x(statFsO));
        }
        if (eVar.I() == null) {
            eVar.S(io.sentry.android.core.internal.util.k.c(this.f22268b, this.f22269c.getLogger(), this.f22270d));
        }
    }

    private int b(StatFs statFs) {
        return statFs.getAvailableBlocks();
    }

    private long c(StatFs statFs) {
        return this.f22270d.d() >= 18 ? statFs.getAvailableBlocksLong() : b(statFs);
    }

    private Intent d() {
        return t0.o(this.f22268b, this.f22270d, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }

    private Float e(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("level", -1);
            int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return Float.valueOf((intExtra / intExtra2) * 100.0f);
            }
            return null;
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting device battery level.", th);
            return null;
        }
    }

    private Float f(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return Float.valueOf(intExtra / 10.0f);
            }
            return null;
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting battery temperature.", th);
            return null;
        }
    }

    private int g(StatFs statFs) {
        return statFs.getBlockCount();
    }

    private long h(StatFs statFs) {
        return this.f22270d.d() >= 18 ? statFs.getBlockCountLong() : g(statFs);
    }

    private int i(StatFs statFs) {
        return statFs.getBlockSize();
    }

    private long j(StatFs statFs) {
        return this.f22270d.d() >= 18 ? statFs.getBlockSizeLong() : i(statFs);
    }

    private Date k() {
        try {
            return io.sentry.a1.d(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        } catch (IllegalArgumentException e2) {
            this.f22269c.getLogger().a(s4.ERROR, e2, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }

    private String l() {
        try {
            return a1.a(this.f22268b);
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting installationId.", th);
            return null;
        }
    }

    private File[] m() {
        if (this.f22270d.d() >= 19) {
            return this.f22268b.getExternalFilesDirs(null);
        }
        File externalFilesDir = this.f22268b.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return new File[]{externalFilesDir};
        }
        return null;
    }

    private File n(File file) {
        File[] fileArrM = m();
        if (fileArrM != null) {
            String absolutePath = file != null ? file.getAbsolutePath() : null;
            for (File file2 : fileArrM) {
                if (file2 != null && (absolutePath == null || absolutePath.isEmpty() || !file2.getAbsolutePath().contains(absolutePath))) {
                    return file2;
                }
            }
        } else {
            this.f22269c.getLogger().c(s4.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }

    private StatFs o(File file) {
        if (A()) {
            this.f22269c.getLogger().c(s4.INFO, "External storage is not mounted or emulated.", new Object[0]);
            return null;
        }
        File fileN = n(file);
        if (fileN != null) {
            return new StatFs(fileN.getPath());
        }
        this.f22269c.getLogger().c(s4.INFO, "Not possible to read external files directory", new Object[0]);
        return null;
    }

    public static w0 p(Context context, SentryAndroidOptions sentryAndroidOptions) {
        if (a == null) {
            synchronized (w0.class) {
                if (a == null) {
                    a = new w0(context.getApplicationContext(), sentryAndroidOptions);
                }
            }
        }
        return a;
    }

    private Long q(ActivityManager.MemoryInfo memoryInfo) {
        return this.f22270d.d() >= 16 ? Long.valueOf(memoryInfo.totalMem) : Long.valueOf(Runtime.getRuntime().totalMemory());
    }

    private io.sentry.protocol.e.b s() {
        io.sentry.protocol.e.b bVarA;
        Throwable th;
        try {
            bVarA = io.sentry.android.core.internal.util.o.a(this.f22268b.getResources().getConfiguration().orientation);
            if (bVarA == null) {
                try {
                    this.f22269c.getLogger().c(s4.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    this.f22269c.getLogger().b(s4.ERROR, "Error getting device orientation.", th);
                    return bVarA;
                }
            }
        } catch (Throwable th3) {
            bVarA = null;
            th = th3;
        }
        return bVarA;
    }

    private TimeZone u() {
        if (this.f22270d.d() >= 24) {
            LocaleList locales = this.f22268b.getResources().getConfiguration().getLocales();
            if (!locales.isEmpty()) {
                return Calendar.getInstance(locales.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }

    private Long v(StatFs statFs) {
        try {
            return Long.valueOf(h(statFs) * j(statFs));
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting total external storage amount.", th);
            return null;
        }
    }

    private Long w(StatFs statFs) {
        try {
            return Long.valueOf(h(statFs) * j(statFs));
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting total internal storage amount.", th);
            return null;
        }
    }

    private Long x(StatFs statFs) {
        try {
            return Long.valueOf(c(statFs) * j(statFs));
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting unused external storage amount.", th);
            return null;
        }
    }

    private Long y(StatFs statFs) {
        try {
            return Long.valueOf(c(statFs) * j(statFs));
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting unused internal storage amount.", th);
            return null;
        }
    }

    private Boolean z(Intent intent) {
        try {
            int intExtra = intent.getIntExtra("plugged", -1);
            boolean z = true;
            if (intExtra != 1 && intExtra != 2) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable th) {
            this.f22269c.getLogger().b(s4.ERROR, "Error getting device charging state.", th);
            return null;
        }
    }

    protected io.sentry.protocol.k B() {
        io.sentry.protocol.k kVar = new io.sentry.protocol.k();
        kVar.j("Android");
        kVar.m(Build.VERSION.RELEASE);
        kVar.h(Build.DISPLAY);
        String strG = t0.g(this.f22269c.getLogger());
        if (strG != null) {
            kVar.i(strG);
        }
        if (this.f22269c.isEnableRootCheck()) {
            kVar.k(Boolean.valueOf(new io.sentry.android.core.internal.util.r(this.f22268b, this.f22270d, this.f22269c.getLogger()).e()));
        }
        return kVar;
    }

    public io.sentry.protocol.e a(boolean z, boolean z2) {
        io.sentry.protocol.e eVar = new io.sentry.protocol.e();
        if (this.f22269c.isSendDefaultPii()) {
            eVar.g0(t0.d(this.f22268b, this.f22270d));
        }
        eVar.c0(Build.MANUFACTURER);
        eVar.Q(Build.BRAND);
        eVar.V(t0.f(this.f22269c.getLogger()));
        eVar.e0(Build.MODEL);
        eVar.f0(Build.ID);
        eVar.M(t0.c(this.f22270d));
        eVar.i0(s());
        Boolean bool = this.f22271e;
        if (bool != null) {
            eVar.p0(bool);
        }
        DisplayMetrics displayMetricsE = t0.e(this.f22268b, this.f22269c.getLogger());
        if (displayMetricsE != null) {
            eVar.o0(Integer.valueOf(displayMetricsE.widthPixels));
            eVar.n0(Integer.valueOf(displayMetricsE.heightPixels));
            eVar.l0(Float.valueOf(displayMetricsE.density));
            eVar.m0(Integer.valueOf(displayMetricsE.densityDpi));
        }
        eVar.P(k());
        eVar.r0(u());
        if (eVar.J() == null) {
            eVar.Y(l());
        }
        Locale locale = Locale.getDefault();
        if (eVar.K() == null) {
            eVar.Z(locale.getLanguage());
        }
        if (eVar.L() == null) {
            eVar.a0(locale.toString());
        }
        List<Integer> listC = io.sentry.android.core.internal.util.m.a().c();
        if (!listC.isEmpty()) {
            eVar.k0(Double.valueOf(((Integer) Collections.max(listC)).doubleValue()));
            eVar.j0(Integer.valueOf(listC.size()));
        }
        eVar.d0(this.f22274h);
        if (z && this.f22269c.isCollectAdditionalContext()) {
            C(eVar, z2);
        }
        return eVar;
    }

    public io.sentry.protocol.k r() {
        return this.f22273g;
    }

    public t0.a t() {
        return this.f22272f;
    }
}
