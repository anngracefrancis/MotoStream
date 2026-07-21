package com.google.android.gms.internal.ads;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
final class n30 implements ThreadFactory {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13018f;

    n30(String str) {
        this.f13018f = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f13018f);
    }
}
