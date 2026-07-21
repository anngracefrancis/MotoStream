package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class f extends WeakReference<Throwable> {
    private final int a;

    public f(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == f.class) {
            if (this == obj) {
                return true;
            }
            f fVar = (f) obj;
            if (this.a == fVar.a && get() == fVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
