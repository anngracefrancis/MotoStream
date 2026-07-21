package c.e;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class e<K, V> {
    private final LinkedHashMap<K, V> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2925d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2926e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2927f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2928g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2929h;

    public e(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f2924c = i2;
        this.a = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int e(K k2, V v) {
        int iF = f(k2, v);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException("Negative size: " + k2 + "=" + v);
    }

    protected V a(K k2) {
        return null;
    }

    protected void b(boolean z, K k2, V v, V v2) {
    }

    public final V c(K k2) {
        V vPut;
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.a.get(k2);
            if (v != null) {
                this.f2928g++;
                return v;
            }
            this.f2929h++;
            V vA = a(k2);
            if (vA == null) {
                return null;
            }
            synchronized (this) {
                this.f2926e++;
                vPut = this.a.put(k2, vA);
                if (vPut != null) {
                    this.a.put(k2, vPut);
                } else {
                    this.f2923b += e(k2, vA);
                }
            }
            if (vPut != null) {
                b(false, k2, vA, vPut);
                return vPut;
            }
            g(this.f2924c);
            return vA;
        }
    }

    public final V d(K k2, V v) {
        V vPut;
        if (k2 == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f2925d++;
            this.f2923b += e(k2, v);
            vPut = this.a.put(k2, v);
            if (vPut != null) {
                this.f2923b -= e(k2, vPut);
            }
        }
        if (vPut != null) {
            b(false, k2, vPut, v);
        }
        g(this.f2924c);
        return vPut;
    }

    protected int f(K k2, V v) {
        return 1;
    }

    public void g(int i2) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f2923b < 0 || (this.a.isEmpty() && this.f2923b != 0)) {
                    break;
                }
                if (this.f2923b > i2 && !this.a.isEmpty()) {
                    Map.Entry<K, V> next = this.a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.a.remove(key);
                    this.f2923b -= e(key, value);
                    this.f2927f++;
                }
                return;
            }
            b(true, key, value, null);
        }
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    public final synchronized String toString() {
        int i2;
        int i3;
        i2 = this.f2928g;
        i3 = this.f2929h + i2;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f2924c), Integer.valueOf(this.f2928g), Integer.valueOf(this.f2929h), Integer.valueOf(i3 != 0 ? (i2 * 100) / i3 : 0));
    }
}
