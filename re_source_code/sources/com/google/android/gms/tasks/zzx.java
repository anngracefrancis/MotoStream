package com.google.android.gms.tasks;

import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzx implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ TaskCompletionSource f18355f;

    @Override // java.lang.Runnable
    public final void run() {
        this.f18355f.d(new TimeoutException());
    }
}
