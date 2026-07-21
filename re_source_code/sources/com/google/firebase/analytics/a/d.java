package com.google.firebase.analytics.a;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class d implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Executor f18856f = new d();

    private d() {
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
