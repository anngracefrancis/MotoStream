package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class m implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ n f18334g;

    m(n nVar, Task task) {
        this.f18334g = nVar;
        this.f18333f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f18334g.f18335b) {
            n nVar = this.f18334g;
            if (nVar.f18336c != null) {
                nVar.f18336c.c((Exception) Preconditions.k(this.f18333f.i()));
            }
        }
    }
}
