package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockTracker;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@KeepForSdk
public class WakeLock {
    private static ScheduledExecutorService a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile zza f18299b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f18300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PowerManager.WakeLock f18301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WorkSource f18302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f18303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f18304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f18305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f18306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f18307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f18308k;
    private final Map<String, Integer[]> l;
    private final Set<Future<?>> m;
    private int n;
    private AtomicInteger o;

    public interface zza {
    }

    @KeepForSdk
    public WakeLock(Context context, int i2, String str) {
        this(context, i2, str, null, context == null ? null : context.getPackageName());
    }

    private final String d(String str) {
        return (!this.f18308k || TextUtils.isEmpty(str)) ? this.f18305h : str;
    }

    private final List<String> e() {
        return WorkSourceUtil.d(this.f18302e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(int i2) {
        if (this.f18301d.isHeld()) {
            try {
                this.f18301d.release();
            } catch (RuntimeException e2) {
                if (!e2.getClass().equals(RuntimeException.class)) {
                    throw e2;
                }
                Log.e("WakeLock", String.valueOf(this.f18304g).concat(" was already released!"), e2);
            }
            this.f18301d.isHeld();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0056 A[Catch: all -> 0x0096, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0016, B:11:0x0029, B:13:0x002e, B:15:0x0038, B:22:0x005e, B:23:0x007d, B:16:0x0047, B:18:0x0056, B:20:0x005a, B:8:0x001a, B:10:0x0022), top: B:31:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:22:0x005e A[Catch: all -> 0x0096, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0016, B:11:0x0029, B:13:0x002e, B:15:0x0038, B:22:0x005e, B:23:0x007d, B:16:0x0047, B:18:0x0056, B:20:0x005a, B:8:0x001a, B:10:0x0022), top: B:31:0x000d }] */
    @KeepForSdk
    public void a(long j2) {
        this.o.incrementAndGet();
        String strD = d(null);
        synchronized (this.f18300c) {
            boolean z = false;
            if ((!this.l.isEmpty() || this.n > 0) && !this.f18301d.isHeld()) {
                this.l.clear();
                this.n = 0;
            }
            if (this.f18308k) {
                Integer[] numArr = this.l.get(strD);
                if (numArr == null) {
                    this.l.put(strD, new Integer[]{1});
                    z = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() + 1);
                }
                if (z) {
                    WakeLockTracker.a().c(this.f18307j, StatsUtils.a(this.f18301d, strD), 7, this.f18304g, strD, null, this.f18303f, e(), j2);
                    this.n++;
                } else if (!this.f18308k) {
                    WakeLockTracker.a().c(this.f18307j, StatsUtils.a(this.f18301d, strD), 7, this.f18304g, strD, null, this.f18303f, e(), j2);
                    this.n++;
                }
            } else if (!this.f18308k && this.n == 0) {
                WakeLockTracker.a().c(this.f18307j, StatsUtils.a(this.f18301d, strD), 7, this.f18304g, strD, null, this.f18303f, e(), j2);
                this.n++;
            }
        }
        this.f18301d.acquire();
        if (j2 > 0) {
            a.schedule(new b(this), j2, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0052 A[Catch: all -> 0x007e, TryCatch #0 {, blocks: (B:7:0x0021, B:9:0x0027, B:21:0x005a, B:22:0x0079, B:12:0x0033, B:14:0x003b, B:15:0x0042, B:17:0x0052, B:19:0x0056), top: B:30:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x005a A[Catch: all -> 0x007e, TryCatch #0 {, blocks: (B:7:0x0021, B:9:0x0027, B:21:0x005a, B:22:0x0079, B:12:0x0033, B:14:0x003b, B:15:0x0042, B:17:0x0052, B:19:0x0056), top: B:30:0x0021 }] */
    @KeepForSdk
    public void b() {
        boolean z;
        if (this.o.decrementAndGet() < 0) {
            Log.e("WakeLock", String.valueOf(this.f18304g).concat(" release without a matched acquire!"));
        }
        String strD = d(null);
        synchronized (this.f18300c) {
            if (this.f18308k) {
                Integer[] numArr = this.l.get(strD);
                if (numArr == null) {
                    z = false;
                } else if (numArr[0].intValue() == 1) {
                    this.l.remove(strD);
                    z = true;
                } else {
                    numArr[0] = Integer.valueOf(numArr[0].intValue() - 1);
                    z = false;
                }
                if (z) {
                    WakeLockTracker.a().b(this.f18307j, StatsUtils.a(this.f18301d, strD), 8, this.f18304g, strD, null, this.f18303f, e());
                    this.n--;
                } else if (!this.f18308k) {
                    WakeLockTracker.a().b(this.f18307j, StatsUtils.a(this.f18301d, strD), 8, this.f18304g, strD, null, this.f18303f, e());
                    this.n--;
                }
            } else if (!this.f18308k && this.n == 1) {
                WakeLockTracker.a().b(this.f18307j, StatsUtils.a(this.f18301d, strD), 8, this.f18304g, strD, null, this.f18303f, e());
                this.n--;
            }
        }
        f(0);
    }

    @KeepForSdk
    public void c(boolean z) {
        this.f18301d.setReferenceCounted(z);
        this.f18308k = z;
    }

    private WakeLock(Context context, int i2, String str, String str2, String str3) {
        this(context, i2, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private WakeLock(Context context, int i2, String str, String str2, String str3, String str4) {
        this.f18300c = this;
        this.f18308k = true;
        this.l = new HashMap();
        this.m = Collections.synchronizedSet(new HashSet());
        this.o = new AtomicInteger(0);
        Preconditions.l(context, "WakeLock: context must not be null");
        Preconditions.h(str, "WakeLock: wakeLockName must not be empty");
        this.f18303f = i2;
        this.f18305h = null;
        this.f18306i = null;
        Context applicationContext = context.getApplicationContext();
        this.f18307j = applicationContext;
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String strValueOf = String.valueOf(str);
            this.f18304g = strValueOf.length() != 0 ? "*gcore*:".concat(strValueOf) : new String("*gcore*:");
        } else {
            this.f18304g = str;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i2, str);
        this.f18301d = wakeLockNewWakeLock;
        if (WorkSourceUtil.e(context)) {
            WorkSource workSourceB = WorkSourceUtil.b(context, Strings.a(str3) ? context.getPackageName() : str3);
            this.f18302e = workSourceB;
            if (workSourceB != null && WorkSourceUtil.e(applicationContext)) {
                WorkSource workSource = this.f18302e;
                if (workSource != null) {
                    workSource.add(workSourceB);
                } else {
                    this.f18302e = workSourceB;
                }
                try {
                    wakeLockNewWakeLock.setWorkSource(this.f18302e);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e2) {
                    Log.wtf("WakeLock", e2.toString());
                }
            }
        }
        if (a == null) {
            a = PooledExecutorsProvider.a().a();
        }
    }
}
