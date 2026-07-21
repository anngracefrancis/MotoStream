package c.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ArraySet.java */
/* JADX INFO: loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f2909f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Object[] f2910g = new Object[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Object[] f2911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f2912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object[] f2913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static int f2914k;
    private int[] l;
    Object[] m;
    int n;
    private f<E, E> o;

    /* JADX INFO: compiled from: ArraySet.java */
    class a extends f<E, E> {
        a() {
        }

        @Override // c.e.f
        protected void a() {
            b.this.clear();
        }

        @Override // c.e.f
        protected Object b(int i2, int i3) {
            return b.this.m[i2];
        }

        @Override // c.e.f
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // c.e.f
        protected int d() {
            return b.this.n;
        }

        @Override // c.e.f
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // c.e.f
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // c.e.f
        protected void g(E e2, E e3) {
            b.this.add(e2);
        }

        @Override // c.e.f
        protected void h(int i2) {
            b.this.o(i2);
        }

        @Override // c.e.f
        protected E i(int i2, E e2) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    private void c(int i2) {
        if (i2 == 8) {
            synchronized (b.class) {
                Object[] objArr = f2913j;
                if (objArr != null) {
                    this.m = objArr;
                    f2913j = (Object[]) objArr[0];
                    this.l = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2914k--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f2911h;
                if (objArr2 != null) {
                    this.m = objArr2;
                    f2911h = (Object[]) objArr2[0];
                    this.l = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2912i--;
                    return;
                }
            }
        }
        this.l = new int[i2];
        this.m = new Object[i2];
    }

    private static void g(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f2914k < 10) {
                    objArr[0] = f2913j;
                    objArr[1] = iArr;
                    for (int i3 = i2 - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2913j = objArr;
                    f2914k++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f2912i < 10) {
                    objArr[0] = f2911h;
                    objArr[1] = iArr;
                    for (int i4 = i2 - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f2911h = objArr;
                    f2912i++;
                }
            }
        }
    }

    private f<E, E> h() {
        if (this.o == null) {
            this.o = new a();
        }
        return this.o;
    }

    private int i(Object obj, int i2) {
        int i3 = this.n;
        if (i3 == 0) {
            return -1;
        }
        int iA = c.a(this.l, i3, i2);
        if (iA < 0 || obj.equals(this.m[iA])) {
            return iA;
        }
        int i4 = iA + 1;
        while (i4 < i3 && this.l[i4] == i2) {
            if (obj.equals(this.m[i4])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iA - 1; i5 >= 0 && this.l[i5] == i2; i5--) {
            if (obj.equals(this.m[i5])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    private int n() {
        int i2 = this.n;
        if (i2 == 0) {
            return -1;
        }
        int iA = c.a(this.l, i2, 0);
        if (iA < 0 || this.m[iA] == null) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.l[i3] == 0) {
            if (this.m[i3] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.l[i4] == 0; i4--) {
            if (this.m[i4] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e2) {
        int i2;
        int i3;
        if (e2 == null) {
            i3 = n();
            i2 = 0;
        } else {
            int iHashCode = e2.hashCode();
            i2 = iHashCode;
            i3 = i(e2, iHashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i4 = i3 ^ (-1);
        int i5 = this.n;
        int[] iArr = this.l;
        if (i5 >= iArr.length) {
            int i6 = 4;
            if (i5 >= 8) {
                i6 = (i5 >> 1) + i5;
            } else if (i5 >= 4) {
                i6 = 8;
            }
            Object[] objArr = this.m;
            c(i6);
            int[] iArr2 = this.l;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.m, 0, objArr.length);
            }
            g(iArr, objArr, this.n);
        }
        int i7 = this.n;
        if (i4 < i7) {
            int[] iArr3 = this.l;
            int i8 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i8, i7 - i4);
            Object[] objArr2 = this.m;
            System.arraycopy(objArr2, i4, objArr2, i8, this.n - i4);
        }
        this.l[i4] = i2;
        this.m[i4] = e2;
        this.n++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        f(this.n + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2 = this.n;
        if (i2 != 0) {
            g(this.l, this.m, i2);
            this.l = f2909f;
            this.m = f2910g;
            this.n = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.n; i2++) {
                try {
                    if (!set.contains(q(i2))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void f(int i2) {
        int[] iArr = this.l;
        if (iArr.length < i2) {
            Object[] objArr = this.m;
            c(i2);
            int i3 = this.n;
            if (i3 > 0) {
                System.arraycopy(iArr, 0, this.l, 0, i3);
                System.arraycopy(objArr, 0, this.m, 0, this.n);
            }
            g(iArr, objArr, this.n);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.l;
        int i2 = this.n;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(Object obj) {
        return obj == null ? n() : i(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.n <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return h().m().iterator();
    }

    public E o(int i2) {
        Object[] objArr = this.m;
        E e2 = (E) objArr[i2];
        int i3 = this.n;
        if (i3 <= 1) {
            g(this.l, objArr, i3);
            this.l = f2909f;
            this.m = f2910g;
            this.n = 0;
        } else {
            int[] iArr = this.l;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                int i4 = i3 - 1;
                this.n = i4;
                if (i2 < i4) {
                    int i5 = i2 + 1;
                    System.arraycopy(iArr, i5, iArr, i2, i4 - i2);
                    Object[] objArr2 = this.m;
                    System.arraycopy(objArr2, i5, objArr2, i2, this.n - i2);
                }
                this.m[this.n] = null;
            } else {
                c(i3 > 8 ? i3 + (i3 >> 1) : 8);
                this.n--;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.l, 0, i2);
                    System.arraycopy(objArr, 0, this.m, 0, i2);
                }
                int i6 = this.n;
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    System.arraycopy(iArr, i7, this.l, i2, i6 - i2);
                    System.arraycopy(objArr, i7, this.m, i2, this.n - i2);
                }
            }
        }
        return e2;
    }

    public E q(int i2) {
        return (E) this.m[i2];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        o(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.n - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.m[i2])) {
                o(i2);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.n;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i2 = this.n;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.m, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.n * 14);
        sb.append('{');
        for (int i2 = 0; i2 < this.n; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            E eQ = q(i2);
            if (eQ != this) {
                sb.append(eQ);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i2) {
        if (i2 == 0) {
            this.l = f2909f;
            this.m = f2910g;
        } else {
            c(i2);
        }
        this.n = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.n) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.n));
        }
        System.arraycopy(this.m, 0, tArr, 0, this.n);
        int length = tArr.length;
        int i2 = this.n;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }
}
