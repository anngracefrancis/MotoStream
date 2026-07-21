package com.google.firebase.iid;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class h implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Executor f19641f = new h();

    private h() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
