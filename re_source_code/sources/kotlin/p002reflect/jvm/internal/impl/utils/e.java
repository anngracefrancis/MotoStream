package kotlin.p002reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SmartList.java */
/* JADX INFO: loaded from: classes3.dex */
public class e<E> extends AbstractList<E> implements RandomAccess {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f25518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f25519g;

    /* JADX INFO: compiled from: SmartList.java */
    private static class b<T> implements Iterator<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final b f25520f = new b();

        private b() {
        }

        public static <T> b<T> b() {
            return f25520f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: SmartList.java */
    private class c extends d<E> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f25521g;

        public c() {
            super();
            this.f25521g = ((AbstractList) e.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.e.d
        protected void b() {
            if (((AbstractList) e.this).modCount == this.f25521g) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) e.this).modCount + "; expected: " + this.f25521g);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.e.d
        protected E c() {
            return (E) e.this.f25519g;
        }

        @Override // java.util.Iterator
        public void remove() {
            b();
            e.this.clear();
        }
    }

    /* JADX INFO: compiled from: SmartList.java */
    private static abstract class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f25523f;

        private d() {
        }

        protected abstract void b();

        protected abstract T c();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f25523f;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f25523f) {
                throw new NoSuchElementException();
            }
            this.f25523f = true;
            b();
            return c();
        }
    }

    private static /* synthetic */ void c(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i2 == 2 || i2 == 3) {
            objArr[1] = "iterator";
        } else if (i2 == 5 || i2 == 6 || i2 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 5 && i2 != 6 && i2 != 7) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        int i2 = this.f25518f;
        if (i2 == 0) {
            this.f25519g = e2;
        } else if (i2 == 1) {
            this.f25519g = new Object[]{this.f25519g, e2};
        } else {
            Object[] objArr = (Object[]) this.f25519g;
            int length = objArr.length;
            if (i2 >= length) {
                int i3 = ((length * 3) / 2) + 1;
                int i4 = i2 + 1;
                if (i3 < i4) {
                    i3 = i4;
                }
                Object[] objArr2 = new Object[i3];
                this.f25519g = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f25518f] = e2;
        }
        this.f25518f++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f25519g = null;
        this.f25518f = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i2) {
        int i3;
        if (i2 >= 0 && i2 < (i3 = this.f25518f)) {
            return i3 == 1 ? (E) this.f25519g : (E) ((Object[]) this.f25519g)[i2];
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.f25518f);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        int i2 = this.f25518f;
        if (i2 == 0) {
            b bVarB = b.b();
            if (bVarB == null) {
                c(2);
            }
            return bVarB;
        }
        if (i2 == 1) {
            return new c();
        }
        Iterator<E> it = super.iterator();
        if (it == null) {
            c(3);
        }
        return it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i2) {
        int i3;
        E e2;
        if (i2 < 0 || i2 >= (i3 = this.f25518f)) {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.f25518f);
        }
        if (i3 == 1) {
            e2 = (E) this.f25519g;
            this.f25519g = null;
        } else {
            Object[] objArr = (Object[]) this.f25519g;
            Object obj = objArr[i2];
            if (i3 == 2) {
                this.f25519g = objArr[1 - i2];
            } else {
                int i4 = (i3 - i2) - 1;
                if (i4 > 0) {
                    System.arraycopy(objArr, i2 + 1, objArr, i2, i4);
                }
                objArr[this.f25518f - 1] = null;
            }
            e2 = (E) obj;
        }
        this.f25518f--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i2, E e2) {
        int i3;
        if (i2 < 0 || i2 >= (i3 = this.f25518f)) {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.f25518f);
        }
        if (i3 == 1) {
            E e3 = (E) this.f25519g;
            this.f25519g = e2;
            return e3;
        }
        Object[] objArr = (Object[]) this.f25519g;
        E e4 = (E) objArr[i2];
        objArr[i2] = e2;
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f25518f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr == 0) {
            c(4);
        }
        int length = tArr.length;
        int i2 = this.f25518f;
        if (i2 == 1) {
            if (length == 0) {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.f25519g;
                return tArr2;
            }
            tArr[0] = this.f25519g;
        } else {
            if (length < i2) {
                T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.f25519g, i2, tArr.getClass());
                if (tArr3 == null) {
                    c(6);
                }
                return tArr3;
            }
            if (i2 != 0) {
                System.arraycopy(this.f25519g, 0, tArr, 0, i2);
            }
        }
        int i3 = this.f25518f;
        if (length > i3) {
            tArr[i3] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, E e2) {
        int i3;
        if (i2 >= 0 && i2 <= (i3 = this.f25518f)) {
            if (i3 == 0) {
                this.f25519g = e2;
            } else if (i3 == 1 && i2 == 0) {
                this.f25519g = new Object[]{e2, this.f25519g};
            } else {
                Object[] objArr = new Object[i3 + 1];
                if (i3 == 1) {
                    objArr[0] = this.f25519g;
                } else {
                    Object[] objArr2 = (Object[]) this.f25519g;
                    System.arraycopy(objArr2, 0, objArr, 0, i2);
                    System.arraycopy(objArr2, i2, objArr, i2 + 1, this.f25518f - i2);
                }
                objArr[i2] = e2;
                this.f25519g = objArr;
            }
            this.f25518f++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i2 + ", Size: " + this.f25518f);
    }
}
