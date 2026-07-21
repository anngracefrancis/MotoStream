package com.google.firebase.messaging;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class m implements Executor {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Executor f19831f = new m();

    private m() {
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
