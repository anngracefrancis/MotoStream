package com.flurry.sdk;

import java.util.Collections;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d7<b> implements Thread.UncaughtExceptionHandler {
    public n7 p;
    public boolean q;

    public c() {
        super("FlurryErrorProvider");
        this.p = new n7();
        this.q = false;
        q7 q7VarA = q7.a();
        synchronized (q7VarA.f11026c) {
            q7VarA.f11026c.put(this, null);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        String message;
        th.printStackTrace();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.q) {
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace == null || stackTrace.length <= 0) {
                message = th.getMessage() != null ? th.getMessage() : HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                StringBuilder sb = new StringBuilder();
                if (th.getMessage() != null) {
                    sb.append(" (");
                    sb.append(th.getMessage());
                    sb.append(")\n");
                }
                message = sb.toString();
            }
            t(new b(p7.UNCAUGHT_EXCEPTION_ID.f11009i, jCurrentTimeMillis, message, th.getClass().getName(), th, o7.a(), null, this.p.b()));
        }
    }

    public final void x(String str, long j2, String str2, String str3, Throwable th, Map<String, String> map, Map<String, String> map2) {
        t(new b(str, j2, str2, str3, th, map, map2, Collections.emptyList()));
    }
}
