package com.airbnb.epoxy;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: BoundViewHolders.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements Iterable<u> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c.e.d<u> f8429f = new c.e.d<>();

    /* JADX INFO: compiled from: BoundViewHolders.java */
    private class b implements Iterator<u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f8430f;

        private b() {
            this.f8430f = 0;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            c.e.d dVar = e.this.f8429f;
            int i2 = this.f8430f;
            this.f8430f = i2 + 1;
            return (u) dVar.o(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8430f < e.this.f8429f.n();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public void f(u uVar) {
        this.f8429f.k(uVar.getItemId(), uVar);
    }

    public void g(u uVar) {
        this.f8429f.l(uVar.getItemId());
    }

    @Override // java.lang.Iterable
    public Iterator<u> iterator() {
        return new b();
    }

    public int size() {
        return this.f8429f.n();
    }
}
