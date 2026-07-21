package c.b.a.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FastSafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f2850j = new HashMap<>();

    public boolean contains(K k2) {
        return this.f2850j.containsKey(k2);
    }

    @Override // c.b.a.b.b
    protected b.c<K, V> g(K k2) {
        return this.f2850j.get(k2);
    }

    @Override // c.b.a.b.b
    public V o(K k2, V v) {
        b.c<K, V> cVarG = g(k2);
        if (cVarG != null) {
            return cVarG.f2856g;
        }
        this.f2850j.put(k2, n(k2, v));
        return null;
    }

    @Override // c.b.a.b.b
    public V q(K k2) {
        V v = (V) super.q(k2);
        this.f2850j.remove(k2);
        return v;
    }

    public Map.Entry<K, V> r(K k2) {
        if (contains(k2)) {
            return this.f2850j.get(k2).f2858i;
        }
        return null;
    }
}
