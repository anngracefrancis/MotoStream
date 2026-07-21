package io.sentry;

import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JavaMemoryCollector.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public final class k2 implements r1 {
    private final Runtime a = Runtime.getRuntime();

    @Override // io.sentry.r1
    public void a(k3 k3Var) {
        k3Var.b(new w2(System.currentTimeMillis(), this.a.totalMemory() - this.a.freeMemory()));
    }

    @Override // io.sentry.r1
    public void setup() {
    }
}
