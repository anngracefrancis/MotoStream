package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class u {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue f18345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18346c;

    u() {
    }

    public final void a(t tVar) {
        synchronized (this.a) {
            if (this.f18345b == null) {
                this.f18345b = new ArrayDeque();
            }
            this.f18345b.add(tVar);
        }
    }

    public final void b(Task task) {
        t tVar;
        synchronized (this.a) {
            if (this.f18345b != null && !this.f18346c) {
                this.f18346c = true;
                while (true) {
                    synchronized (this.a) {
                        tVar = (t) this.f18345b.poll();
                        if (tVar == null) {
                            this.f18346c = false;
                            return;
                        }
                    }
                    tVar.a(task);
                }
            }
        }
    }
}
