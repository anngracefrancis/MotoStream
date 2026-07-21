package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public final class z1 implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ThreadGroup f11156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f11157g = 1;

    public z1(String str) {
        this.f11156f = new ThreadGroup(str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f11156f, runnable);
        thread.setName(this.f11156f.getName() + ":" + thread.getId());
        thread.setPriority(this.f11157g);
        return thread;
    }
}
