package com.google.android.gms.common.util.concurrent;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class NumberedThreadFactory implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f12167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f12168g = new AtomicInteger();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ThreadFactory f12169h = Executors.defaultThreadFactory();

    @KeepForSdk
    public NumberedThreadFactory(String str) {
        Preconditions.l(str, "Name must not be null");
        this.f12167f = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread threadNewThread = this.f12169h.newThread(new a(runnable, 0));
        threadNewThread.setName(this.f12167f + "[" + this.f12168g.getAndIncrement() + "]");
        return threadNewThread;
    }
}
