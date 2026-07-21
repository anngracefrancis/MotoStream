package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
final class m00 implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12946f;

    m00(String str) {
        this.f12946f = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f12946f);
    }
}
