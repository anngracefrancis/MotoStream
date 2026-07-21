package com.facebook.internal.t0.l;

import android.app.ActivityManager;
import android.os.Looper;
import android.os.Process;
import com.facebook.a0;
import com.facebook.internal.t0.i;
import com.facebook.internal.t0.k;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ANRDetector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final d a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f9882b = Process.myUid();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ScheduledExecutorService f9883c = Executors.newSingleThreadScheduledExecutor();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f9884d = HttpUrl.FRAGMENT_ENCODE_SET;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Runnable f9885e = new Runnable() { // from class: com.facebook.internal.t0.l.a
        @Override // java.lang.Runnable
        public final void run() {
            d.a();
        }
    };

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a() {
        try {
            a0 a0Var = a0.a;
            Object systemService = a0.c().getSystemService("activity");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
            }
            b((ActivityManager) systemService);
        } catch (Exception unused) {
        }
    }

    public static final void b(ActivityManager activityManager) {
        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState;
        if (activityManager == null || (processesInErrorState = activityManager.getProcessesInErrorState()) == null) {
            return;
        }
        for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
            if (processErrorStateInfo.condition == 2 && processErrorStateInfo.uid == f9882b) {
                Thread thread = Looper.getMainLooper().getThread();
                m.e(thread, "getMainLooper().thread");
                k kVar = k.a;
                String strD = k.d(thread);
                if (!m.a(strD, f9884d) && k.h(thread)) {
                    f9884d = strD;
                    i.a aVar = i.a.a;
                    i.a.a(processErrorStateInfo.shortMsg, strD).g();
                }
            }
        }
    }

    public static final void d() {
        f9883c.scheduleWithFixedDelay(f9885e, 0L, 500, TimeUnit.MILLISECONDS);
    }
}
