package com.google.android.gms.dynamite;

import android.os.Looper;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzb {
    private static volatile ClassLoader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile Thread f12205b;

    public static synchronized ClassLoader a() {
        if (a == null) {
            a = b();
        }
        return a;
    }

    private static synchronized ClassLoader b() {
        ClassLoader contextClassLoader = null;
        if (f12205b == null) {
            f12205b = c();
            if (f12205b == null) {
                return null;
            }
        }
        synchronized (f12205b) {
            try {
                contextClassLoader = f12205b.getContextClassLoader();
            } catch (SecurityException e2) {
                Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e2.getMessage());
            }
        }
        return contextClassLoader;
    }

    private static synchronized Thread c() {
        SecurityException e2;
        Thread aVar;
        Thread thread;
        ThreadGroup threadGroup;
        ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
        if (threadGroup2 == null) {
            return null;
        }
        synchronized (Void.class) {
            try {
                int iActiveGroupCount = threadGroup2.activeGroupCount();
                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                threadGroup2.enumerate(threadGroupArr);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i3 >= iActiveGroupCount) {
                        threadGroup = null;
                        break;
                    }
                    threadGroup = threadGroupArr[i3];
                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                        break;
                    }
                    i3++;
                }
                if (threadGroup == null) {
                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                }
                int iActiveCount = threadGroup.activeCount();
                Thread[] threadArr = new Thread[iActiveCount];
                threadGroup.enumerate(threadArr);
                while (true) {
                    if (i2 >= iActiveCount) {
                        thread = null;
                        break;
                    }
                    thread = threadArr[i2];
                    if ("GmsDynamite".equals(thread.getName())) {
                        break;
                    }
                    i2++;
                }
                if (thread == null) {
                    try {
                        aVar = new a(threadGroup, "GmsDynamite");
                        try {
                            aVar.setContextClassLoader(null);
                            aVar.start();
                        } catch (SecurityException e3) {
                            e2 = e3;
                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e2.getMessage());
                        }
                    } catch (SecurityException e4) {
                        e2 = e4;
                        aVar = thread;
                    }
                    thread = aVar;
                }
            } catch (SecurityException e5) {
                e2 = e5;
                aVar = null;
            }
        }
        return thread;
    }
}
