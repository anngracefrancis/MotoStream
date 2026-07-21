package rx.n.e.n;

/* JADX INFO: compiled from: MpscLinkedAtomicQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<E> extends b<E> {
    public d() {
        c<E> cVar = new c<>();
        h(cVar);
        i(cVar);
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        c<E> cVar = new c<>(e2);
        i(cVar).d(cVar);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        c<E> cVarC;
        c<E> cVarC2 = c();
        c<E> cVarC3 = cVarC2.c();
        if (cVarC3 != null) {
            return cVarC3.b();
        }
        if (cVarC2 == g()) {
            return null;
        }
        do {
            cVarC = cVarC2.c();
        } while (cVarC == null);
        return cVarC.b();
    }

    @Override // java.util.Queue
    public E poll() {
        c<E> cVarC;
        c<E> cVarC2 = c();
        c<E> cVarC3 = cVarC2.c();
        if (cVarC3 != null) {
            E eA = cVarC3.a();
            h(cVarC3);
            return eA;
        }
        if (cVarC2 == g()) {
            return null;
        }
        do {
            cVarC = cVarC2.c();
        } while (cVarC == null);
        E eA2 = cVarC.a();
        h(cVarC);
        return eA2;
    }
}
