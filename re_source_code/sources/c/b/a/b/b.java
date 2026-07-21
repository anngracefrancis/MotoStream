package c.b.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: SafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    c<K, V> f2851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c<K, V> f2852g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f2853h = new WeakHashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2854i = 0;

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // c.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2858i;
        }

        @Override // c.b.a.b.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f2857h;
        }
    }

    /* JADX INFO: renamed from: c.b.a.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static class C0064b<K, V> extends e<K, V> {
        C0064b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // c.b.a.b.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2857h;
        }

        @Override // c.b.a.b.b.e
        c<K, V> d(c<K, V> cVar) {
            return cVar.f2858i;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f2855f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final V f2856g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        c<K, V> f2857h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        c<K, V> f2858i;

        c(K k2, V v) {
            this.f2855f = k2;
            this.f2856g = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f2855f.equals(cVar.f2855f) && this.f2856g.equals(cVar.f2856g);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f2855f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f2856g;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2855f.hashCode() ^ this.f2856g.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2855f + "=" + this.f2856g;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: SafeIterableMap.java */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private c<K, V> f2859f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f2860g = true;

        d() {
        }

        @Override // c.b.a.b.b.f
        public void b(c<K, V> cVar) {
            c<K, V> cVar2 = this.f2859f;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f2858i;
                this.f2859f = cVar3;
                this.f2860g = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f2860g) {
                this.f2860g = false;
                this.f2859f = b.this.f2851f;
            } else {
                c<K, V> cVar = this.f2859f;
                this.f2859f = cVar != null ? cVar.f2857h : null;
            }
            return this.f2859f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2860g) {
                return b.this.f2851f != null;
            }
            c<K, V> cVar = this.f2859f;
            return (cVar == null || cVar.f2857h == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        c<K, V> f2862f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        c<K, V> f2863g;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f2862f = cVar2;
            this.f2863g = cVar;
        }

        private c<K, V> g() {
            c<K, V> cVar = this.f2863g;
            c<K, V> cVar2 = this.f2862f;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // c.b.a.b.b.f
        public void b(c<K, V> cVar) {
            if (this.f2862f == cVar && cVar == this.f2863g) {
                this.f2863g = null;
                this.f2862f = null;
            }
            c<K, V> cVar2 = this.f2862f;
            if (cVar2 == cVar) {
                this.f2862f = c(cVar2);
            }
            if (this.f2863g == cVar) {
                this.f2863g = g();
            }
        }

        abstract c<K, V> c(c<K, V> cVar);

        abstract c<K, V> d(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f2863g;
            this.f2863g = g();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2863g != null;
        }
    }

    /* JADX INFO: compiled from: SafeIterableMap.java */
    interface f<K, V> {
        void b(c<K, V> cVar);
    }

    public Iterator<Map.Entry<K, V>> c() {
        C0064b c0064b = new C0064b(this.f2852g, this.f2851f);
        this.f2853h.put(c0064b, Boolean.FALSE);
        return c0064b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry<K, V> f() {
        return this.f2851f;
    }

    protected c<K, V> g(K k2) {
        c<K, V> cVar = this.f2851f;
        while (cVar != null && !cVar.f2855f.equals(k2)) {
            cVar = cVar.f2857h;
        }
        return cVar;
    }

    public b<K, V>.d h() {
        b<K, V>.d dVar = new d();
        this.f2853h.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    public Map.Entry<K, V> i() {
        return this.f2852g;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f2851f, this.f2852g);
        this.f2853h.put(aVar, Boolean.FALSE);
        return aVar;
    }

    protected c<K, V> n(K k2, V v) {
        c<K, V> cVar = new c<>(k2, v);
        this.f2854i++;
        c<K, V> cVar2 = this.f2852g;
        if (cVar2 == null) {
            this.f2851f = cVar;
            this.f2852g = cVar;
            return cVar;
        }
        cVar2.f2857h = cVar;
        cVar.f2858i = cVar2;
        this.f2852g = cVar;
        return cVar;
    }

    public V o(K k2, V v) {
        c<K, V> cVarG = g(k2);
        if (cVarG != null) {
            return cVarG.f2856g;
        }
        n(k2, v);
        return null;
    }

    public V q(K k2) {
        c<K, V> cVarG = g(k2);
        if (cVarG == null) {
            return null;
        }
        this.f2854i--;
        if (!this.f2853h.isEmpty()) {
            Iterator<f<K, V>> it = this.f2853h.keySet().iterator();
            while (it.hasNext()) {
                it.next().b(cVarG);
            }
        }
        c<K, V> cVar = cVarG.f2858i;
        if (cVar != null) {
            cVar.f2857h = cVarG.f2857h;
        } else {
            this.f2851f = cVarG.f2857h;
        }
        c<K, V> cVar2 = cVarG.f2857h;
        if (cVar2 != null) {
            cVar2.f2858i = cVar;
        } else {
            this.f2852g = cVar;
        }
        cVarG.f2857h = null;
        cVarG.f2858i = null;
        return cVarG.f2856g;
    }

    public int size() {
        return this.f2854i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
