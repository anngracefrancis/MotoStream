package io.sentry;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SynchronizedCollection.java */
/* JADX INFO: loaded from: classes2.dex */
class l5<E> implements Collection<E>, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Collection<E> f22491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Object f22492g;

    l5(Collection<E> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection must not be null.");
        }
        this.f22491f = collection;
        this.f22492g = this;
    }

    @Override // java.util.Collection
    public boolean add(E e2) {
        boolean zAdd;
        synchronized (this.f22492g) {
            zAdd = c().add(e2);
        }
        return zAdd;
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean zAddAll;
        synchronized (this.f22492g) {
            zAddAll = c().addAll(collection);
        }
        return zAddAll;
    }

    protected Collection<E> c() {
        return this.f22491f;
    }

    @Override // java.util.Collection
    public void clear() {
        synchronized (this.f22492g) {
            c().clear();
        }
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean zContains;
        synchronized (this.f22492g) {
            zContains = c().contains(obj);
        }
        return zContains;
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        boolean zContainsAll;
        synchronized (this.f22492g) {
            zContainsAll = c().containsAll(collection);
        }
        return zContainsAll;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.f22492g) {
            zIsEmpty = c().isEmpty();
        }
        return zIsEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return c().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        boolean zRemove;
        synchronized (this.f22492g) {
            zRemove = c().remove(obj);
        }
        return zRemove;
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        boolean zRemoveAll;
        synchronized (this.f22492g) {
            zRemoveAll = c().removeAll(collection);
        }
        return zRemoveAll;
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        boolean zRetainAll;
        synchronized (this.f22492g) {
            zRetainAll = c().retainAll(collection);
        }
        return zRetainAll;
    }

    @Override // java.util.Collection
    public int size() {
        int size;
        synchronized (this.f22492g) {
            size = c().size();
        }
        return size;
    }

    public String toString() {
        String string;
        synchronized (this.f22492g) {
            string = c().toString();
        }
        return string;
    }
}
