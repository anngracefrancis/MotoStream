package com.google.android.gms.cloudmessaging;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class v implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Executor f11607f = new v();

    private v() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
