package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class ly implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ThreadFactory f12941f = Executors.defaultThreadFactory();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f12942g = new AtomicInteger(1);

    ly() {
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f12941f.newThread(runnable);
        int andIncrement = this.f12942g.getAndIncrement();
        StringBuilder sb = new StringBuilder(16);
        sb.append("gads-");
        sb.append(andIncrement);
        threadNewThread.setName(sb.toString());
        return threadNewThread;
    }
}
