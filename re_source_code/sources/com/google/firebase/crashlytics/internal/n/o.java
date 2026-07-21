package com.google.firebase.crashlytics.internal.n;

import android.os.Process;

/* JADX INFO: compiled from: BackgroundPriorityRunnable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o implements Runnable {
    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
