package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
final class vt extends WeakReference<Throwable> {
    private final int a;

    public vt(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == vt.class) {
            if (this == obj) {
                return true;
            }
            vt vtVar = (vt) obj;
            if (this.a == vtVar.a && get() == vtVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a;
    }
}
