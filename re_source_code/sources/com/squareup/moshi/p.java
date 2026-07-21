package com.squareup.moshi;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: LinkedHashTreeMap.java */
/* JADX INFO: loaded from: classes2.dex */
final class p<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Comparator<Comparable> f20578f = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Comparator<? super K> f20579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    g<K, V>[] f20580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final g<K, V> f20581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f20582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f20583k;
    int l;
    private p<K, V>.d m;
    private p<K, V>.e n;

    /* JADX INFO: compiled from: LinkedHashTreeMap.java */
    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    /* JADX INFO: compiled from: LinkedHashTreeMap.java */
    static final class b<K, V> {
        private g<K, V> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f20584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f20585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20586d;

        b() {
        }

        void a(g<K, V> gVar) {
            gVar.f20597h = null;
            gVar.f20595f = null;
            gVar.f20596g = null;
            gVar.n = 1;
            int i2 = this.f20584b;
            if (i2 > 0) {
                int i3 = this.f20586d;
                if ((i3 & 1) == 0) {
                    this.f20586d = i3 + 1;
                    this.f20584b = i2 - 1;
                    this.f20585c++;
                }
            }
            gVar.f20595f = this.a;
            this.a = gVar;
            int i4 = this.f20586d + 1;
            this.f20586d = i4;
            int i5 = this.f20584b;
            if (i5 > 0 && (i4 & 1) == 0) {
                this.f20586d = i4 + 1;
                this.f20584b = i5 - 1;
                this.f20585c++;
            }
            int i6 = 4;
            while (true) {
                int i7 = i6 - 1;
                if ((this.f20586d & i7) != i7) {
                    return;
                }
                int i8 = this.f20585c;
                if (i8 == 0) {
                    g<K, V> gVar2 = this.a;
                    g<K, V> gVar3 = gVar2.f20595f;
                    g<K, V> gVar4 = gVar3.f20595f;
                    gVar3.f20595f = gVar4.f20595f;
                    this.a = gVar3;
                    gVar3.f20596g = gVar4;
                    gVar3.f20597h = gVar2;
                    gVar3.n = gVar2.n + 1;
                    gVar4.f20595f = gVar3;
                    gVar2.f20595f = gVar3;
                } else if (i8 == 1) {
                    g<K, V> gVar5 = this.a;
                    g<K, V> gVar6 = gVar5.f20595f;
                    this.a = gVar6;
                    gVar6.f20597h = gVar5;
                    gVar6.n = gVar5.n + 1;
                    gVar5.f20595f = gVar6;
                    this.f20585c = 0;
                } else if (i8 == 2) {
                    this.f20585c = 0;
                }
                i6 *= 2;
            }
        }

        void b(int i2) {
            this.f20584b = ((Integer.highestOneBit(i2) * 2) - 1) - i2;
            this.f20586d = 0;
            this.f20585c = 0;
            this.a = null;
        }

        g<K, V> c() {
            g<K, V> gVar = this.a;
            if (gVar.f20595f == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    /* JADX INFO: compiled from: LinkedHashTreeMap.java */
    static class c<K, V> {
        private g<K, V> a;

        c() {
        }

        public g<K, V> a() {
            g<K, V> gVar = this.a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f20595f;
            gVar.f20595f = null;
            g<K, V> gVar3 = gVar.f20597h;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 == null) {
                    this.a = gVar4;
                    return gVar;
                }
                gVar2.f20595f = gVar4;
                gVar3 = gVar2.f20596g;
            }
        }

        void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f20595f = gVar2;
                gVar2 = gVar;
                gVar = gVar.f20596g;
            }
            this.a = gVar2;
        }
    }

    /* JADX INFO: compiled from: LinkedHashTreeMap.java */
    final class d extends AbstractSet<Map.Entry<K, V>> {

        /* JADX INFO: compiled from: LinkedHashTreeMap.java */
        class a extends p<K, V>.f<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return b();
            }
        }

        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            p.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && p.this.e((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> gVarE;
            if (!(obj instanceof Map.Entry) || (gVarE = p.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            p.this.i(gVarE, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.f20582j;
        }
    }

    /* JADX INFO: compiled from: LinkedHashTreeMap.java */
    final class e extends AbstractSet<K> {

        /* JADX INFO: compiled from: LinkedHashTreeMap.java */
        class a extends p<K, V>.f<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return b().f20600k;
            }
        }

        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            p.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return p.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return p.this.j(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p.this.f20582j;
        }
    }

    /* JADX INFO: compiled from: LinkedHashTreeMap.java */
    abstract class f<T> implements Iterator<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        g<K, V> f20591f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        g<K, V> f20592g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f20593h;

        f() {
            this.f20591f = p.this.f20581i.f20598i;
            this.f20593h = p.this.f20583k;
        }

        final g<K, V> b() {
            g<K, V> gVar = this.f20591f;
            p pVar = p.this;
            if (gVar == pVar.f20581i) {
                throw new NoSuchElementException();
            }
            if (pVar.f20583k != this.f20593h) {
                throw new ConcurrentModificationException();
            }
            this.f20591f = gVar.f20598i;
            this.f20592g = gVar;
            return gVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f20591f != p.this.f20581i;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f20592g;
            if (gVar == null) {
                throw new IllegalStateException();
            }
            p.this.i(gVar, true);
            this.f20592g = null;
            this.f20593h = p.this.f20583k;
        }
    }

    p() {
        this(null);
    }

    private void a() {
        g<K, V>[] gVarArrB = b(this.f20580h);
        this.f20580h = gVarArrB;
        this.l = (gVarArrB.length / 2) + (gVarArrB.length / 4);
    }

    static <K, V> g<K, V>[] b(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i2 = 0; i2 < length; i2++) {
            g<K, V> gVar = gVarArr[i2];
            if (gVar != null) {
                cVar.b(gVar);
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    g<K, V> gVarA = cVar.a();
                    if (gVarA == null) {
                        break;
                    }
                    if ((gVarA.l & length) == 0) {
                        i3++;
                    } else {
                        i4++;
                    }
                }
                bVar.b(i3);
                bVar2.b(i4);
                cVar.b(gVar);
                while (true) {
                    g<K, V> gVarA2 = cVar.a();
                    if (gVarA2 == null) {
                        break;
                    }
                    if ((gVarA2.l & length) == 0) {
                        bVar.a(gVarA2);
                    } else {
                        bVar2.a(gVarA2);
                    }
                }
                gVarArr2[i2] = i3 > 0 ? bVar.c() : null;
                gVarArr2[i2 + length] = i4 > 0 ? bVar2.c() : null;
            }
        }
        return gVarArr2;
    }

    private boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void h(g<K, V> gVar, boolean z) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f20596g;
            g<K, V> gVar3 = gVar.f20597h;
            int i2 = gVar2 != null ? gVar2.n : 0;
            int i3 = gVar3 != null ? gVar3.n : 0;
            int i4 = i2 - i3;
            if (i4 == -2) {
                g<K, V> gVar4 = gVar3.f20596g;
                g<K, V> gVar5 = gVar3.f20597h;
                int i5 = (gVar4 != null ? gVar4.n : 0) - (gVar5 != null ? gVar5.n : 0);
                if (i5 != -1 && (i5 != 0 || z)) {
                    m(gVar3);
                }
                l(gVar);
                if (z) {
                    return;
                }
            } else if (i4 == 2) {
                g<K, V> gVar6 = gVar2.f20596g;
                g<K, V> gVar7 = gVar2.f20597h;
                int i6 = (gVar6 != null ? gVar6.n : 0) - (gVar7 != null ? gVar7.n : 0);
                if (i6 != 1 && (i6 != 0 || z)) {
                    l(gVar2);
                }
                m(gVar);
                if (z) {
                    return;
                }
            } else if (i4 == 0) {
                gVar.n = i2 + 1;
                if (z) {
                    return;
                }
            } else {
                gVar.n = Math.max(i2, i3) + 1;
                if (!z) {
                    return;
                }
            }
            gVar = gVar.f20595f;
        }
    }

    private void k(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f20595f;
        gVar.f20595f = null;
        if (gVar2 != null) {
            gVar2.f20595f = gVar3;
        }
        if (gVar3 == null) {
            int i2 = gVar.l;
            g<K, V>[] gVarArr = this.f20580h;
            gVarArr[i2 & (gVarArr.length - 1)] = gVar2;
        } else if (gVar3.f20596g == gVar) {
            gVar3.f20596g = gVar2;
        } else {
            gVar3.f20597h = gVar2;
        }
    }

    private void l(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f20596g;
        g<K, V> gVar3 = gVar.f20597h;
        g<K, V> gVar4 = gVar3.f20596g;
        g<K, V> gVar5 = gVar3.f20597h;
        gVar.f20597h = gVar4;
        if (gVar4 != null) {
            gVar4.f20595f = gVar;
        }
        k(gVar, gVar3);
        gVar3.f20596g = gVar;
        gVar.f20595f = gVar3;
        int iMax = Math.max(gVar2 != null ? gVar2.n : 0, gVar4 != null ? gVar4.n : 0) + 1;
        gVar.n = iMax;
        gVar3.n = Math.max(iMax, gVar5 != null ? gVar5.n : 0) + 1;
    }

    private void m(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f20596g;
        g<K, V> gVar3 = gVar.f20597h;
        g<K, V> gVar4 = gVar2.f20596g;
        g<K, V> gVar5 = gVar2.f20597h;
        gVar.f20596g = gVar5;
        if (gVar5 != null) {
            gVar5.f20595f = gVar;
        }
        k(gVar, gVar2);
        gVar2.f20597h = gVar;
        gVar.f20595f = gVar2;
        int iMax = Math.max(gVar3 != null ? gVar3.n : 0, gVar5 != null ? gVar5.n : 0) + 1;
        gVar.n = iMax;
        gVar2.n = Math.max(iMax, gVar4 != null ? gVar4.n : 0) + 1;
    }

    private static int n(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f20580h, (Object) null);
        this.f20582j = 0;
        this.f20583k++;
        g<K, V> gVar = this.f20581i;
        g<K, V> gVar2 = gVar.f20598i;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f20598i;
            gVar2.f20599j = null;
            gVar2.f20598i = null;
            gVar2 = gVar3;
        }
        gVar.f20599j = gVar;
        gVar.f20598i = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    g<K, V> d(K k2, boolean z) {
        g<K, V> gVar;
        int i2;
        g<K, V> gVar2;
        Comparator<? super K> comparator = this.f20579g;
        g<K, V>[] gVarArr = this.f20580h;
        int iN = n(k2.hashCode());
        int length = (gVarArr.length - 1) & iN;
        g<K, V> gVar3 = gVarArr[length];
        if (gVar3 != null) {
            Comparable comparable = comparator == f20578f ? (Comparable) k2 : null;
            while (true) {
                int iCompareTo = comparable != null ? comparable.compareTo(gVar3.f20600k) : comparator.compare(k2, gVar3.f20600k);
                if (iCompareTo == 0) {
                    return gVar3;
                }
                g<K, V> gVar4 = iCompareTo < 0 ? gVar3.f20596g : gVar3.f20597h;
                if (gVar4 == null) {
                    gVar = gVar3;
                    i2 = iCompareTo;
                    break;
                }
                gVar3 = gVar4;
            }
        } else {
            gVar = gVar3;
            i2 = 0;
        }
        if (!z) {
            return null;
        }
        g<K, V> gVar5 = this.f20581i;
        if (gVar != null) {
            gVar2 = new g<>(gVar, k2, iN, gVar5, gVar5.f20599j);
            if (i2 < 0) {
                gVar.f20596g = gVar2;
            } else {
                gVar.f20597h = gVar2;
            }
            h(gVar, true);
        } else {
            if (comparator == f20578f && !(k2 instanceof Comparable)) {
                throw new ClassCastException(k2.getClass().getName() + " is not Comparable");
            }
            gVar2 = new g<>(gVar, k2, iN, gVar5, gVar5.f20599j);
            gVarArr[length] = gVar2;
        }
        int i3 = this.f20582j;
        this.f20582j = i3 + 1;
        if (i3 > this.l) {
            a();
        }
        this.f20583k++;
        return gVar2;
    }

    g<K, V> e(Map.Entry<?, ?> entry) {
        g<K, V> gVarF = f(entry.getKey());
        if (gVarF != null && c(gVarF.m, entry.getValue())) {
            return gVarF;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        p<K, V>.d dVar = this.m;
        if (dVar != null) {
            return dVar;
        }
        p<K, V>.d dVar2 = new d();
        this.m = dVar2;
        return dVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    g<K, V> f(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return d(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> gVarF = f(obj);
        if (gVarF != null) {
            return gVarF.m;
        }
        return null;
    }

    void i(g<K, V> gVar, boolean z) {
        int i2;
        if (z) {
            g<K, V> gVar2 = gVar.f20599j;
            gVar2.f20598i = gVar.f20598i;
            gVar.f20598i.f20599j = gVar2;
            gVar.f20599j = null;
            gVar.f20598i = null;
        }
        g<K, V> gVar3 = gVar.f20596g;
        g<K, V> gVar4 = gVar.f20597h;
        g<K, V> gVar5 = gVar.f20595f;
        int i3 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                k(gVar, gVar3);
                gVar.f20596g = null;
            } else if (gVar4 != null) {
                k(gVar, gVar4);
                gVar.f20597h = null;
            } else {
                k(gVar, null);
            }
            h(gVar5, false);
            this.f20582j--;
            this.f20583k++;
            return;
        }
        g<K, V> gVarB = gVar3.n > gVar4.n ? gVar3.b() : gVar4.a();
        i(gVarB, false);
        g<K, V> gVar6 = gVar.f20596g;
        if (gVar6 != null) {
            i2 = gVar6.n;
            gVarB.f20596g = gVar6;
            gVar6.f20595f = gVarB;
            gVar.f20596g = null;
        } else {
            i2 = 0;
        }
        g<K, V> gVar7 = gVar.f20597h;
        if (gVar7 != null) {
            i3 = gVar7.n;
            gVarB.f20597h = gVar7;
            gVar7.f20595f = gVarB;
            gVar.f20597h = null;
        }
        gVarB.n = Math.max(i2, i3) + 1;
        k(gVar, gVarB);
    }

    g<K, V> j(Object obj) {
        g<K, V> gVarF = f(obj);
        if (gVarF != null) {
            i(gVarF, true);
        }
        return gVarF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        p<K, V>.e eVar = this.n;
        if (eVar != null) {
            return eVar;
        }
        p<K, V>.e eVar2 = new e();
        this.n = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k2, V v) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        g<K, V> gVarD = d(k2, true);
        V v2 = gVarD.m;
        gVarD.m = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> gVarJ = j(obj);
        if (gVarJ != null) {
            return gVarJ.m;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f20582j;
    }

    p(Comparator<? super K> comparator) {
        this.f20582j = 0;
        this.f20583k = 0;
        this.f20579g = comparator == null ? f20578f : comparator;
        this.f20581i = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.f20580h = gVarArr;
        this.l = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    /* JADX INFO: compiled from: LinkedHashTreeMap.java */
    static final class g<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        g<K, V> f20595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        g<K, V> f20596g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        g<K, V> f20597h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        g<K, V> f20598i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        g<K, V> f20599j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final K f20600k;
        final int l;
        V m;
        int n;

        g() {
            this.f20600k = null;
            this.l = -1;
            this.f20599j = this;
            this.f20598i = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f20596g; gVar2 != null; gVar2 = gVar2.f20596g) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f20597h; gVar2 != null; gVar2 = gVar2.f20597h) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k2 = this.f20600k;
            if (k2 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k2.equals(entry.getKey())) {
                return false;
            }
            V v = this.m;
            if (v == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f20600k;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.m;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f20600k;
            int iHashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.m;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.m;
            this.m = v;
            return v2;
        }

        public String toString() {
            return this.f20600k + "=" + this.m;
        }

        g(g<K, V> gVar, K k2, int i2, g<K, V> gVar2, g<K, V> gVar3) {
            this.f20595f = gVar;
            this.f20600k = k2;
            this.l = i2;
            this.n = 1;
            this.f20598i = gVar2;
            this.f20599j = gVar3;
            gVar3.f20598i = this;
            gVar2.f20599j = this;
        }
    }
}
