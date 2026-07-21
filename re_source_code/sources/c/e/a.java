package c.e;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: ArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends g<K, V> implements Map<K, V> {
    f<K, V> m;

    /* JADX INFO: renamed from: c.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ArrayMap.java */
    class C0067a extends f<K, V> {
        C0067a() {
        }

        @Override // c.e.f
        protected void a() {
            a.this.clear();
        }

        @Override // c.e.f
        protected Object b(int i2, int i3) {
            return a.this.f2949k[(i2 << 1) + i3];
        }

        @Override // c.e.f
        protected Map<K, V> c() {
            return a.this;
        }

        @Override // c.e.f
        protected int d() {
            return a.this.l;
        }

        @Override // c.e.f
        protected int e(Object obj) {
            return a.this.f(obj);
        }

        @Override // c.e.f
        protected int f(Object obj) {
            return a.this.i(obj);
        }

        @Override // c.e.f
        protected void g(K k2, V v) {
            a.this.put(k2, v);
        }

        @Override // c.e.f
        protected void h(int i2) {
            a.this.l(i2);
        }

        @Override // c.e.f
        protected V i(int i2, V v) {
            return a.this.m(i2, v);
        }
    }

    public a() {
    }

    private f<K, V> o() {
        if (this.m == null) {
            this.m = new C0067a();
        }
        return this.m;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return o().l();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return o().m();
    }

    public boolean p(Collection<?> collection) {
        return f.p(this, collection);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        c(this.l + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return o().n();
    }

    public a(int i2) {
        super(i2);
    }

    public a(g gVar) {
        super(gVar);
    }
}
