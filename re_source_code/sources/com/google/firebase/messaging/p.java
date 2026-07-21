package com.google.firebase.messaging;

import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zzd;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class p {
    private static Executor a(String str) {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-Trigger-Topics-Io"));
    }

    static ScheduledExecutorService b() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Init"));
    }

    static ExecutorService c() {
        zzd.a();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("Firebase-Messaging-Intent-Handle"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }

    static ExecutorService d() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io"));
    }

    static ExecutorService e() {
        return Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Task"));
    }

    static ScheduledExecutorService f() {
        return new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io"));
    }

    static Executor g() {
        return a("Firebase-Messaging-Trigger-Topics-Io");
    }
}
