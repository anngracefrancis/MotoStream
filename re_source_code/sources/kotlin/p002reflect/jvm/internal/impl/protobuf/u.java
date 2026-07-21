package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
/* JADX INFO: loaded from: classes3.dex */
public class u extends AbstractList<String> implements RandomAccess, m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m f25484f;

    /* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
    class a implements ListIterator<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ListIterator<String> f25485f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f25486g;

        a(int i2) {
            this.f25486g = i2;
            this.f25485f = u.this.f25484f.listIterator(i2);
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f25485f.next();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String previous() {
            return this.f25485f.previous();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f25485f.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f25485f.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f25485f.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f25485f.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: UnmodifiableLazyStringList.java */
    class b implements Iterator<String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Iterator<String> f25488f;

        b() {
            this.f25488f = u.this.f25484f.iterator();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String next() {
            return this.f25488f.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25488f.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public u(m mVar) {
        this.f25484f = mVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public d N0(int i2) {
        return this.f25484f.N0(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public String get(int i2) {
        return this.f25484f.get(i2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public void h1(d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public List<?> j() {
        return this.f25484f.j();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.m
    public m k() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i2) {
        return new a(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f25484f.size();
    }
}
