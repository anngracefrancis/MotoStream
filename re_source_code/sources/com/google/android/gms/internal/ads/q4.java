package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class q4 implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f13218f = new AtomicInteger(1);

    q4(zzavg zzavgVar) {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f13218f.getAndIncrement();
        StringBuilder sb = new StringBuilder(42);
        sb.append("AdWorker(SCION_TASK_EXECUTOR) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
