package com.google.android.gms.internal.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
final class b implements zal {
    private b() {
    }

    @Override // com.google.android.gms.internal.base.zal
    public final ExecutorService a(int i2, ThreadFactory threadFactory, int i3) {
        return Executors.newFixedThreadPool(2, threadFactory);
    }
}
