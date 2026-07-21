package io.sentry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: compiled from: CircularFifoQueue.java */
/* JADX INFO: loaded from: classes2.dex */
final class w0<E> extends AbstractCollection<E> implements Queue<E>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient E[] f22798f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient int f22799g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient int f22800h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient boolean f22801i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f22802j;

    /* JADX INFO: compiled from: CircularFifoQueue.java */
    class a implements Iterator<E> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f22803f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f22804g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f22805h;

        a() {
            this.f22803f = w0.this.f22799g;
            this.f22805h = w0.this.f22801i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22805h || this.f22803f != w0.this.f22800h;
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f22805h = false;
            int i2 = this.f22803f;
            this.f22804g = i2;
            this.f22803f = w0.this.t(i2);
            return (E) w0.this.f22798f[this.f22804g];
        }

        @Override // java.util.Iterator
        public void remove() {
            int i2 = this.f22804g;
            if (i2 == -1) {
                throw new IllegalStateException();
            }
            if (i2 == w0.this.f22799g) {
                w0.this.remove();
                this.f22804g = -1;
                return;
            }
            int iT = this.f22804g + 1;
            if (w0.this.f22799g >= this.f22804g || iT >= w0.this.f22800h) {
                while (iT != w0.this.f22800h) {
                    if (iT >= w0.this.f22802j) {
                        w0.this.f22798f[iT - 1] = w0.this.f22798f[0];
                        iT = 0;
                    } else {
                        w0.this.f22798f[w0.this.s(iT)] = w0.this.f22798f[iT];
                        iT = w0.this.t(iT);
                    }
                }
            } else {
                System.arraycopy(w0.this.f22798f, iT, w0.this.f22798f, this.f22804g, w0.this.f22800h - iT);
            }
            this.f22804g = -1;
            w0 w0Var = w0.this;
            w0Var.f22800h = w0Var.s(w0Var.f22800h);
            w0.this.f22798f[w0.this.f22800h] = null;
            w0.this.f22801i = false;
            this.f22803f = w0.this.s(this.f22803f);
        }
    }

    public w0() {
        this(32);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f22798f = (E[]) new Object[this.f22802j];
        int i2 = objectInputStream.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            ((E[]) this.f22798f)[i3] = objectInputStream.readObject();
        }
        this.f22799g = 0;
        boolean z = i2 == this.f22802j;
        this.f22801i = z;
        if (z) {
            this.f22800h = 0;
        } else {
            this.f22800h = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int s(int i2) {
        int i3 = i2 - 1;
        return i3 < 0 ? this.f22802j - 1 : i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int t(int i2) {
        int i3 = i2 + 1;
        if (i3 >= this.f22802j) {
            return 0;
        }
        return i3;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e2) {
        if (e2 == null) {
            throw new NullPointerException("Attempted to add null object to queue");
        }
        if (u()) {
            remove();
        }
        E[] eArr = this.f22798f;
        int i2 = this.f22800h;
        int i3 = i2 + 1;
        this.f22800h = i3;
        eArr[i2] = e2;
        if (i3 >= this.f22802j) {
            this.f22800h = 0;
        }
        if (this.f22800h == this.f22799g) {
            this.f22801i = true;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f22801i = false;
        this.f22799g = 0;
        this.f22800h = 0;
        Arrays.fill(this.f22798f, (Object) null);
    }

    @Override // java.util.Queue
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return peek();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        return add(e2);
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return this.f22798f[this.f22799g];
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return remove();
    }

    @Override // java.util.Queue
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E[] eArr = this.f22798f;
        int i2 = this.f22799g;
        E e2 = eArr[i2];
        if (e2 != null) {
            int i3 = i2 + 1;
            this.f22799g = i3;
            eArr[i2] = null;
            if (i3 >= this.f22802j) {
                this.f22799g = 0;
            }
            this.f22801i = false;
        }
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i2 = this.f22800h;
        int i3 = this.f22799g;
        if (i2 < i3) {
            return (this.f22802j - i3) + i2;
        }
        if (i2 != i3) {
            return i2 - i3;
        }
        if (this.f22801i) {
            return this.f22802j;
        }
        return 0;
    }

    public boolean u() {
        return size() == this.f22802j;
    }

    w0(int i2) {
        this.f22799g = 0;
        this.f22800h = 0;
        this.f22801i = false;
        if (i2 <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        E[] eArr = (E[]) new Object[i2];
        this.f22798f = eArr;
        this.f22802j = eArr.length;
    }
}
