package h.a.z.a;

import io.reactivex.exceptions.ProtocolViolationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: DisposableHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public enum c implements h.a.x.c {
    DISPOSED;

    public static boolean A(AtomicReference<h.a.x.c> atomicReference, h.a.x.c cVar) {
        h.a.z.b.b.c(cVar, "d is null");
        if (atomicReference.compareAndSet(null, cVar)) {
            return true;
        }
        cVar.k();
        if (atomicReference.get() == DISPOSED) {
            return false;
        }
        x();
        return false;
    }

    public static boolean D(h.a.x.c cVar, h.a.x.c cVar2) {
        if (cVar2 == null) {
            h.a.a0.a.o(new NullPointerException("next is null"));
            return false;
        }
        if (cVar == null) {
            return true;
        }
        cVar2.k();
        x();
        return false;
    }

    public static boolean g(AtomicReference<h.a.x.c> atomicReference) {
        h.a.x.c andSet;
        h.a.x.c cVar = atomicReference.get();
        c cVar2 = DISPOSED;
        if (cVar == cVar2 || (andSet = atomicReference.getAndSet(cVar2)) == cVar2) {
            return false;
        }
        if (andSet == null) {
            return true;
        }
        andSet.k();
        return true;
    }

    public static boolean u(h.a.x.c cVar) {
        return cVar == DISPOSED;
    }

    public static boolean v(AtomicReference<h.a.x.c> atomicReference, h.a.x.c cVar) {
        h.a.x.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.k();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        return true;
    }

    public static void x() {
        h.a.a0.a.o(new ProtocolViolationException("Disposable already set!"));
    }

    public static boolean y(AtomicReference<h.a.x.c> atomicReference, h.a.x.c cVar) {
        h.a.x.c cVar2;
        do {
            cVar2 = atomicReference.get();
            if (cVar2 == DISPOSED) {
                if (cVar == null) {
                    return false;
                }
                cVar.k();
                return false;
            }
        } while (!atomicReference.compareAndSet(cVar2, cVar));
        if (cVar2 == null) {
            return true;
        }
        cVar2.k();
        return true;
    }

    @Override // h.a.x.c
    public void k() {
    }

    @Override // h.a.x.c
    public boolean q() {
        return true;
    }
}
