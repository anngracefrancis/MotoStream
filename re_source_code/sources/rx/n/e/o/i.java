package rx.n.e.o;

/* JADX INFO: compiled from: MpscLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i<E> extends a<E> {
    public i() {
        rx.n.e.n.c<E> cVar = new rx.n.e.n.c<>();
        this.consumerNode = cVar;
        i(cVar);
    }

    protected rx.n.e.n.c<E> i(rx.n.e.n.c<E> cVar) {
        rx.n.e.n.c<E> cVar2;
        do {
            cVar2 = this.producerNode;
        } while (!z.a.compareAndSwapObject(this, e.f26814f, cVar2, cVar));
        return cVar2;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("null elements not allowed");
        }
        rx.n.e.n.c<E> cVar = new rx.n.e.n.c<>(e2);
        i(cVar).d(cVar);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        rx.n.e.n.c<E> cVarC;
        rx.n.e.n.c<E> cVar = this.consumerNode;
        rx.n.e.n.c<E> cVarC2 = cVar.c();
        if (cVarC2 != null) {
            return cVarC2.b();
        }
        if (cVar == c()) {
            return null;
        }
        do {
            cVarC = cVar.c();
        } while (cVarC == null);
        return cVarC.b();
    }

    @Override // java.util.Queue
    public E poll() {
        rx.n.e.n.c<E> cVarC;
        rx.n.e.n.c<E> cVarF = f();
        rx.n.e.n.c<E> cVarC2 = cVarF.c();
        if (cVarC2 != null) {
            E eA = cVarC2.a();
            h(cVarC2);
            return eA;
        }
        if (cVarF == c()) {
            return null;
        }
        do {
            cVarC = cVarF.c();
        } while (cVarC == null);
        E eA2 = cVarC.a();
        this.consumerNode = cVarC;
        return eA2;
    }
}
