package rx.n.e.o;

/* JADX INFO: compiled from: SpmcArrayQueue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class k<E> extends o<E> {
    public k(int i2) {
        super(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return t() == q();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        E[] eArr = this.f26819j;
        long j2 = this.f26818i;
        long jQ = q();
        long jC = c(jQ);
        if (i(eArr, jC) != null) {
            if (jQ - t() > j2) {
                return false;
            }
            while (i(eArr, jC) != null) {
            }
        }
        o(eArr, jC, e2);
        r(jQ + 1);
        return true;
    }

    @Override // java.util.Queue
    public E peek() {
        E eH;
        long jU = u();
        do {
            long jT = t();
            if (jT >= jU) {
                long jQ = q();
                if (jT >= jQ) {
                    return null;
                }
                v(jQ);
            }
            eH = h(c(jT));
        } while (eH == null);
        return eH;
    }

    @Override // java.util.Queue, rx.n.e.o.h
    public E poll() {
        long jT;
        long jU = u();
        do {
            jT = t();
            if (jT >= jU) {
                long jQ = q();
                if (jT >= jQ) {
                    return null;
                }
                v(jQ);
            }
        } while (!s(jT, 1 + jT));
        long jC = c(jT);
        E[] eArr = this.f26819j;
        E eG = g(eArr, jC);
        n(eArr, jC, null);
        return eG;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long jT = t();
        while (true) {
            long jQ = q();
            long jT2 = t();
            if (jT == jT2) {
                return (int) (jQ - jT2);
            }
            jT = jT2;
        }
    }
}
