package io.sentry.android.core;

import android.os.Debug;
import io.sentry.k3;
import io.sentry.r1;
import io.sentry.w2;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: AndroidMemoryCollector.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class j0 implements r1 {
    @Override // io.sentry.r1
    public void a(k3 k3Var) {
        k3Var.b(new w2(System.currentTimeMillis(), Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(), Debug.getNativeHeapSize() - Debug.getNativeHeapFreeSize()));
    }

    @Override // io.sentry.r1
    public void setup() {
    }
}
