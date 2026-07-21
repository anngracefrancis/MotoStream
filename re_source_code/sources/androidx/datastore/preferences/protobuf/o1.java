package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
/* JADX INFO: loaded from: classes.dex */
public class o1 extends AbstractList<String> implements f0, RandomAccess {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f0 f1373f;

    /* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
    class a implements ListIterator<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ListIterator<String> f1374f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f1375g;

        a(int i2) {
            this.f1375g = i2;
            this.f1374f = o1.this.f1373f.listIterator(i2);
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f1374f.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f1374f.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f1374f.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f1374f.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f1374f.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f1374f.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
    class b implements Iterator<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Iterator<String> f1377f;

        b() {
            this.f1377f = o1.this.f1373f.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f1377f.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f1377f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public o1(f0 f0Var) {
        this.f1373f = f0Var;
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public void a0(h hVar) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public Object c1(int i2) {
        return this.f1373f.c1(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i2) {
        return (String) this.f1373f.get(i2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public List<?> j() {
        return this.f1373f.j();
    }

    @Override // androidx.datastore.preferences.protobuf.f0
    public f0 k() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i2) {
        return new a(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f1373f.size();
    }
}
