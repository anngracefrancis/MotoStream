package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class y implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ x f18353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Callable f18354g;

    y(x xVar, Callable callable) {
        this.f18353f = xVar;
        this.f18354g = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f18353f.r(this.f18354g.call());
        } catch (Exception e2) {
            this.f18353f.q(e2);
        } catch (Throwable th) {
            this.f18353f.q(new RuntimeException(th));
        }
    }
}
