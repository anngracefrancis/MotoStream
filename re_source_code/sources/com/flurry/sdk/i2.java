package com.flurry.sdk;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class i2 {
    private static final Map<b, d2> a;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.values().length];
            a = iArr;
            try {
                iArr[b.PUBLIC_API.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.CORE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.DATA_PROCESSOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PROVIDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.CONFIG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        CORE,
        DATA_PROCESSOR,
        PROVIDER,
        PUBLIC_API,
        REPORTS,
        CONFIG,
        MISC
    }

    static class c implements RejectedExecutionHandler {
        private c() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            d1.c(6, "ActorFactory", runnable.toString() + "is rejected");
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    static class d implements ThreadFactory {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final AtomicInteger f10831f = new AtomicInteger(0);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f10832g = "Flurry #";

        d() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f10832g + this.f10831f.incrementAndGet());
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(10);
            return thread;
        }
    }

    static {
        Executor executorB;
        HashMap map = new HashMap();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        for (b bVar : b.values()) {
            String strName = bVar.name();
            int i2 = a.a[bVar.ordinal()];
            if (i2 == 1) {
                executorB = b();
            } else if (i2 == 2) {
                executorB = c(iAvailableProcessors);
            } else if (i2 == 3) {
                executorB = b();
            } else if (i2 != 4) {
                executorB = i2 != 5 ? b() : b();
            } else {
                executorB = c(iAvailableProcessors);
            }
            map.put(bVar, new d2(executorB, strName));
        }
        a = Collections.unmodifiableMap(map);
    }

    public static synchronized d2 a(b bVar) {
        return a.get(bVar);
    }

    private static Executor b() {
        return new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(), new c((byte) 0));
    }

    private static Executor c(int i2) {
        return new ThreadPoolExecutor(0, i2, 6L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(), new c((byte) 0));
    }
}
