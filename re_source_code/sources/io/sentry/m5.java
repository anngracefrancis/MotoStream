package io.sentry;

import java.util.Queue;

/* JADX INFO: compiled from: SynchronizedQueue.java */
/* JADX INFO: loaded from: classes2.dex */
final class m5<E> extends l5<E> implements Queue<E> {
    private m5(Queue<E> queue) {
        super(queue);
    }

    static <E> m5<E> g(Queue<E> queue) {
        return new m5<>(queue);
    }

    @Override // java.util.Queue
    public E element() {
        E eElement;
        synchronized (this.f22492g) {
            eElement = c().element();
        }
        return eElement;
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        synchronized (this.f22492g) {
            zEquals = c().equals(obj);
        }
        return zEquals;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.sentry.l5
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Queue<E> c() {
        return (Queue) super.c();
    }

    @Override // java.util.Collection
    public int hashCode() {
        int iHashCode;
        synchronized (this.f22492g) {
            iHashCode = c().hashCode();
        }
        return iHashCode;
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        boolean zOffer;
        synchronized (this.f22492g) {
            zOffer = c().offer(e2);
        }
        return zOffer;
    }

    @Override // java.util.Queue
    public E peek() {
        E ePeek;
        synchronized (this.f22492g) {
            ePeek = c().peek();
        }
        return ePeek;
    }

    @Override // java.util.Queue
    public E poll() {
        E ePoll;
        synchronized (this.f22492g) {
            ePoll = c().poll();
        }
        return ePoll;
    }

    @Override // java.util.Queue
    public E remove() {
        E eRemove;
        synchronized (this.f22492g) {
            eRemove = c().remove();
        }
        return eRemove;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] array;
        synchronized (this.f22492g) {
            array = c().toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        T[] tArr2;
        synchronized (this.f22492g) {
            tArr2 = (T[]) c().toArray(tArr);
        }
        return tArr2;
    }
}
