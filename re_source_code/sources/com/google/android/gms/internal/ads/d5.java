package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class d5 implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicInteger f12448f = new AtomicInteger(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12449g;

    d5(String str) {
        this.f12449g = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.f12449g;
        int andIncrement = this.f12448f.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("AdWorker(");
        sb.append(str);
        sb.append(") #");
        sb.append(andIncrement);
        return new Thread(runnable, sb.toString());
    }
}
