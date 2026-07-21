package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
class u3<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f17263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List<z3> f17264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<K, V> f17265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f17266i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile b4 f17267j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Map<K, V> f17268k;
    private volatile v3 l;

    private u3(int i2) {
        this.f17263f = i2;
        this.f17264g = Collections.emptyList();
        this.f17265h = Collections.emptyMap();
        this.f17268k = Collections.emptyMap();
    }

    private final int a(K k2) {
        int size = this.f17264g.size() - 1;
        if (size >= 0) {
            int iCompareTo = k2.compareTo((Comparable) this.f17264g.get(size).getKey());
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
            int iCompareTo2 = k2.compareTo((Comparable) this.f17264g.get(i3).getKey());
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

    static <FieldDescriptorType extends zzey<FieldDescriptorType>> u3<FieldDescriptorType, Object> b(int i2) {
        return new t3(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V l(int i2) {
        q();
        V v = (V) this.f17264g.remove(i2).getValue();
        if (!this.f17265h.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = r().entrySet().iterator();
            this.f17264g.add(new z3(this, it.next()));
            it.remove();
        }
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        if (this.f17266i) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> r() {
        q();
        if (this.f17265h.isEmpty() && !(this.f17265h instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f17265h = treeMap;
            this.f17268k = treeMap.descendingMap();
        }
        return (SortedMap) this.f17265h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        q();
        if (!this.f17264g.isEmpty()) {
            this.f17264g.clear();
        }
        if (this.f17265h.isEmpty()) {
            return;
        }
        this.f17265h.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.f17265h.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final V put(K k2, V v) {
        q();
        int iA = a(k2);
        if (iA >= 0) {
            return (V) this.f17264g.get(iA).setValue(v);
        }
        q();
        if (this.f17264g.isEmpty() && !(this.f17264g instanceof ArrayList)) {
            this.f17264g = new ArrayList(this.f17263f);
        }
        int i2 = -(iA + 1);
        if (i2 >= this.f17263f) {
            return r().put(k2, v);
        }
        int size = this.f17264g.size();
        int i3 = this.f17263f;
        if (size == i3) {
            z3 z3VarRemove = this.f17264g.remove(i3 - 1);
            r().put((Comparable) z3VarRemove.getKey(), z3VarRemove.getValue());
        }
        this.f17264g.add(i2, new z3(this, k2, v));
        return null;
    }

    public void e() {
        if (this.f17266i) {
            return;
        }
        this.f17265h = this.f17265h.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f17265h);
        this.f17268k = this.f17268k.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f17268k);
        this.f17266i = true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f17267j == null) {
            this.f17267j = new b4(this, null);
        }
        return this.f17267j;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u3)) {
            return super.equals(obj);
        }
        u3 u3Var = (u3) obj;
        int size = size();
        if (size != u3Var.size()) {
            return false;
        }
        int iK = k();
        if (iK != u3Var.k()) {
            return entrySet().equals(u3Var.entrySet());
        }
        for (int i2 = 0; i2 < iK; i2++) {
            if (!i(i2).equals(u3Var.i(i2))) {
                return false;
            }
        }
        if (iK != size) {
            return this.f17265h.equals(u3Var.f17265h);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        return iA >= 0 ? (V) this.f17264g.get(iA).getValue() : this.f17265h.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iK = k();
        int iHashCode = 0;
        for (int i2 = 0; i2 < iK; i2++) {
            iHashCode += this.f17264g.get(i2).hashCode();
        }
        return this.f17265h.size() > 0 ? iHashCode + this.f17265h.hashCode() : iHashCode;
    }

    public final Map.Entry<K, V> i(int i2) {
        return this.f17264g.get(i2);
    }

    public final boolean j() {
        return this.f17266i;
    }

    public final int k() {
        return this.f17264g.size();
    }

    public final Iterable<Map.Entry<K, V>> n() {
        return this.f17265h.isEmpty() ? y3.a() : this.f17265h.entrySet();
    }

    final Set<Map.Entry<K, V>> p() {
        if (this.l == null) {
            this.l = new v3(this, null);
        }
        return this.l;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        q();
        Comparable comparable = (Comparable) obj;
        int iA = a(comparable);
        if (iA >= 0) {
            return l(iA);
        }
        if (this.f17265h.isEmpty()) {
            return null;
        }
        return this.f17265h.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f17264g.size() + this.f17265h.size();
    }

    /* synthetic */ u3(int i2, t3 t3Var) {
        this(i2);
    }
}
