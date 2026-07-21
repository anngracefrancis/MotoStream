package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class bq implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f12359f = new AtomicInteger(1);

    bq() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        int andIncrement = this.f12359f.getAndIncrement();
        StringBuilder sb = new StringBuilder(25);
        sb.append("AdWorker(NG) #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
