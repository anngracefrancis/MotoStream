package com.flurry.sdk;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class q7 {
    private static q7 a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map<Thread.UncaughtExceptionHandler, Void> f11026c = new WeakHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Thread.UncaughtExceptionHandler f11025b = Thread.getDefaultUncaughtExceptionHandler();

    final class a implements Thread.UncaughtExceptionHandler {
        private a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            Iterator<Thread.UncaughtExceptionHandler> it = q7.this.b().iterator();
            while (it.hasNext()) {
                try {
                    it.next().uncaughtException(thread, th);
                } catch (Throwable unused) {
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = q7.this.f11025b;
            if (uncaughtExceptionHandler != null) {
                try {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                } catch (Throwable unused2) {
                }
            }
        }

        /* synthetic */ a(q7 q7Var, byte b2) {
            this();
        }
    }

    private q7() {
        Thread.setDefaultUncaughtExceptionHandler(new a(this, (byte) 0));
    }

    public static synchronized q7 a() {
        if (a == null) {
            a = new q7();
        }
        return a;
    }

    final Set<Thread.UncaughtExceptionHandler> b() {
        Set<Thread.UncaughtExceptionHandler> setKeySet;
        synchronized (this.f11026c) {
            setKeySet = this.f11026c.keySet();
        }
        return setKeySet;
    }
}
