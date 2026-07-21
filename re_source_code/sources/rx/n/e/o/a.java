package rx.n.e.o;

import java.util.Iterator;

/* JADX INFO: compiled from: BaseLinkedQueue.java */
/* JADX INFO: loaded from: classes3.dex */
abstract class a<E> extends b<E> {
    a() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return g() == c();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        rx.n.e.n.c<E> cVarC;
        rx.n.e.n.c<E> cVarG = g();
        rx.n.e.n.c<E> cVarC2 = c();
        int i2 = 0;
        while (cVarG != cVarC2 && i2 < Integer.MAX_VALUE) {
            do {
                cVarC = cVarG.c();
            } while (cVarC == null);
            i2++;
            cVarG = cVarC;
        }
        return i2;
    }
}
