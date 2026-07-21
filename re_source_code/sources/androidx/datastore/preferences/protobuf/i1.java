package androidx.datastore.preferences.protobuf;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SmallSortedMap.java */
/* JADX INFO: loaded from: classes.dex */
class i1<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f1315f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<i1<K, V>.e> f1316g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<K, V> f1317h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1318i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile i1<K, V>.g f1319j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<K, V> f1320k;
    private volatile i1<K, V>.c l;

    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* JADX INFO: compiled from: SmallSortedMap.java */
    static class a<FieldDescriptorType> extends i1<FieldDescriptorType, Object> {
        a(int i2) {
            super(i2, null);
        }

        @Override // androidx.datastore.preferences.protobuf.i1, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((u.b) obj, obj2);
        }

        @Override // androidx.datastore.preferences.protobuf.i1
        public void q() {
            if (!p()) {
                for (int i2 = 0; i2 < l(); i2++) {
                    Map.Entry<FieldDescriptorType, Object> entryK = k(i2);
                    if (((u.b) entryK.getKey()).h()) {
                        entryK.setValue(Collections.unmodifiableList((List) entryK.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : n()) {
                    if (((u.b) entry.getKey()).h()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.q();
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class c extends i1<K, V>.g {
        private c() {
            super(i1.this, null);
        }

        @Override // androidx.datastore.preferences.protobuf.i1.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(i1.this, null);
        }

        /* synthetic */ c(i1 i1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private static class d {
        private static final Iterator<Object> a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f1325b = new b();

        /* JADX INFO: compiled from: SmallSortedMap.java */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* JADX INFO: compiled from: SmallSortedMap.java */
        static class b implements Iterable<Object> {
            b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return d.a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f1325b;
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class e implements Map.Entry<K, V>, Comparable<i1<K, V>.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final K f1326f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private V f1327g;

        e(i1 i1Var, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean k(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return k(this.f1326f, entry.getKey()) && k(this.f1327g, entry.getValue());
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(i1<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f1327g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k2 = this.f1326f;
            int iHashCode = k2 == null ? 0 : k2.hashCode();
            V v = this.f1327g;
            return iHashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f1326f;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            i1.this.h();
            V v2 = this.f1327g;
            this.f1327g = v;
            return v2;
        }

        public String toString() {
            return this.f1326f + "=" + this.f1327g;
        }

        e(K k2, V v) {
            this.f1326f = k2;
            this.f1327g = v;
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class g extends AbstractSet<Map.Entry<K, V>> {
        private g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (contains(entry)) {
                return false;
            }
            i1.this.put(entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            i1.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = i1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(i1.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            i1.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i1.this.size();
        }

        /* synthetic */ g(i1 i1Var, a aVar) {
            this();
        }
    }

    /* synthetic */ i1(int i2, a aVar) {
        this(i2);
    }

    private int f(K k2) {
        int size = this.f1316g.size() - 1;
        if (size >= 0) {
            int iCompareTo = k2.compareTo(this.f1316g.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            int iCompareTo2 = k2.compareTo(this.f1316g.get(i3).getKey());
            if (iCompareTo2 < 0) {
                size = i3 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i3;
                }
                i2 = i3 + 1;
            }
        }
        return -(i2 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f1318i) {
            throw new UnsupportedOperationException();
        }
    }

    private void j() {
        h();
        if (!this.f1316g.isEmpty() || (this.f1316g instanceof ArrayList)) {
            return;
        }
        this.f1316g = new ArrayList(this.f1315f);
    }

    private SortedMap<K, V> o() {
        h();
        if (this.f1317h.isEmpty() && !(this.f1317h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f1317h = treeMap;
            this.f1320k = treeMap.descendingMap();
        }
        return (SortedMap) this.f1317h;
    }

    static <FieldDescriptorType extends u.b<FieldDescriptorType>> i1<FieldDescriptorType, Object> r(int i2) {
        return new a(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V t(int i2) {
        h();
        V value = this.f1316g.remove(i2).getValue();
        if (!this.f1317h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = o().entrySet().iterator();
            this.f1316g.add(new e(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        h();
        if (!this.f1316g.isEmpty()) {
            this.f1316g.clear();
        }
        if (this.f1317h.isEmpty()) {
            return;
        }
        this.f1317h.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f1317h.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f1319j == null) {
            this.f1319j = new g(this, null);
        }
        return this.f1319j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return super.equals(obj);
        }
        i1 i1Var = (i1) obj;
        int size = size();
        if (size != i1Var.size()) {
            return false;
        }
        int iL = l();
        if (iL != i1Var.l()) {
            return entrySet().equals(i1Var.entrySet());
        }
        for (int i2 = 0; i2 < iL; i2++) {
            if (!k(i2).equals(i1Var.k(i2))) {
                return false;
            }
        }
        if (iL != size) {
            return this.f1317h.equals(i1Var.f1317h);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        return iF >= 0 ? this.f1316g.get(iF).getValue() : this.f1317h.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iL = l();
        int iHashCode = 0;
        for (int i2 = 0; i2 < iL; i2++) {
            iHashCode += this.f1316g.get(i2).hashCode();
        }
        return m() > 0 ? iHashCode + this.f1317h.hashCode() : iHashCode;
    }

    Set<Map.Entry<K, V>> i() {
        if (this.l == null) {
            this.l = new c(this, null);
        }
        return this.l;
    }

    public Map.Entry<K, V> k(int i2) {
        return this.f1316g.get(i2);
    }

    public int l() {
        return this.f1316g.size();
    }

    public int m() {
        return this.f1317h.size();
    }

    public Iterable<Map.Entry<K, V>> n() {
        return this.f1317h.isEmpty() ? d.b() : this.f1317h.entrySet();
    }

    public boolean p() {
        return this.f1318i;
    }

    public void q() {
        if (this.f1318i) {
            return;
        }
        this.f1317h = this.f1317h.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f1317h);
        this.f1320k = this.f1320k.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f1320k);
        this.f1318i = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        h();
        Comparable comparable = (Comparable) obj;
        int iF = f(comparable);
        if (iF >= 0) {
            return t(iF);
        }
        if (this.f1317h.isEmpty()) {
            return null;
        }
        return this.f1317h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public V put(K k2, V v) {
        h();
        int iF = f(k2);
        if (iF >= 0) {
            return this.f1316g.get(iF).setValue(v);
        }
        j();
        int i2 = -(iF + 1);
        if (i2 >= this.f1315f) {
            return o().put(k2, v);
        }
        int size = this.f1316g.size();
        int i3 = this.f1315f;
        if (size == i3) {
            i1<K, V>.e eVarRemove = this.f1316g.remove(i3 - 1);
            o().put(eVarRemove.getKey(), eVarRemove.getValue());
        }
        this.f1316g.add(i2, new e(k2, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f1316g.size() + this.f1317h.size();
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class b implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1321f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f1322g;

        private b() {
            this.f1321f = i1.this.f1316g.size();
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f1322g == null) {
                this.f1322g = i1.this.f1320k.entrySet().iterator();
            }
            return this.f1322g;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (b().hasNext()) {
                return b().next();
            }
            List list = i1.this.f1316g;
            int i2 = this.f1321f - 1;
            this.f1321f = i2;
            return (Map.Entry) list.get(i2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i2 = this.f1321f;
            return (i2 > 0 && i2 <= i1.this.f1316g.size()) || b().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(i1 i1Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SmallSortedMap.java */
    private class f implements Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f1329f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f1330g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f1331h;

        private f() {
            this.f1329f = -1;
        }

        private Iterator<Map.Entry<K, V>> b() {
            if (this.f1331h == null) {
                this.f1331h = i1.this.f1317h.entrySet().iterator();
            }
            return this.f1331h;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f1330g = true;
            int i2 = this.f1329f + 1;
            this.f1329f = i2;
            return i2 < i1.this.f1316g.size() ? (Map.Entry) i1.this.f1316g.get(this.f1329f) : b().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1329f + 1 >= i1.this.f1316g.size()) {
                return !i1.this.f1317h.isEmpty() && b().hasNext();
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f1330g) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.f1330g = false;
            i1.this.h();
            if (this.f1329f >= i1.this.f1316g.size()) {
                b().remove();
                return;
            }
            i1 i1Var = i1.this;
            int i2 = this.f1329f;
            this.f1329f = i2 - 1;
            i1Var.t(i2);
        }

        /* synthetic */ f(i1 i1Var, a aVar) {
            this();
        }
    }

    private i1(int i2) {
        this.f1315f = i2;
        this.f1316g = Collections.emptyList();
        this.f1317h = Collections.emptyMap();
        this.f1320k = Collections.emptyMap();
    }
}
