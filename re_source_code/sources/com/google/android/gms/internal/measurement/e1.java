package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class e1 extends WeakReference<Throwable> {
    private final int a;

    public e1(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == e1.class) {
            if (this == obj) {
                return true;
            }
            e1 e1Var = (e1) obj;
            if (this.a == e1Var.a && get() == e1Var.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
