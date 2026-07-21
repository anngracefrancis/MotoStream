package c.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: compiled from: SimpleArrayMap.java */
/* JADX INFO: loaded from: classes.dex */
public class g<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static Object[] f2944f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static int f2945g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static Object[] f2946h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static int f2947i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int[] f2948j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object[] f2949k;
    int l;

    public g() {
        this.f2948j = c.a;
        this.f2949k = c.f2917c;
        this.l = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (g.class) {
                Object[] objArr = f2946h;
                if (objArr != null) {
                    this.f2949k = objArr;
                    f2946h = (Object[]) objArr[0];
                    this.f2948j = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2947i--;
                    return;
                }
            }
        } else if (i2 == 4) {
            synchronized (g.class) {
                Object[] objArr2 = f2944f;
                if (objArr2 != null) {
                    this.f2949k = objArr2;
                    f2944f = (Object[]) objArr2[0];
                    this.f2948j = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2945g--;
                    return;
                }
            }
        }
        this.f2948j = new int[i2];
        this.f2949k = new Object[i2 << 1];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return c.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (f2947i < 10) {
                    objArr[0] = f2946h;
                    objArr[1] = iArr;
                    for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f2946h = objArr;
                    f2947i++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (f2945g < 10) {
                    objArr[0] = f2944f;
                    objArr[1] = iArr;
                    for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                        objArr[i4] = null;
                    }
                    f2944f = objArr;
                    f2945g++;
                }
            }
        }
    }

    public void c(int i2) {
        int i3 = this.l;
        int[] iArr = this.f2948j;
        if (iArr.length < i2) {
            Object[] objArr = this.f2949k;
            a(i2);
            if (this.l > 0) {
                System.arraycopy(iArr, 0, this.f2948j, 0, i3);
                System.arraycopy(objArr, 0, this.f2949k, 0, i3 << 1);
            }
            d(iArr, objArr, i3);
        }
        if (this.l != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.l;
        if (i2 > 0) {
            int[] iArr = this.f2948j;
            Object[] objArr = this.f2949k;
            this.f2948j = c.a;
            this.f2949k = c.f2917c;
            this.l = 0;
            d(iArr, objArr, i2);
        }
        if (this.l > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    int e(Object obj, int i2) {
        int i3 = this.l;
        if (i3 == 0) {
            return -1;
        }
        int iB = b(this.f2948j, i3, i2);
        if (iB < 0 || obj.equals(this.f2949k[iB << 1])) {
            return iB;
        }
        int i4 = iB + 1;
        while (i4 < i3 && this.f2948j[i4] == i2) {
            if (obj.equals(this.f2949k[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        for (int i5 = iB - 1; i5 >= 0 && this.f2948j[i5] == i2; i5--) {
            if (obj.equals(this.f2949k[i5 << 1])) {
                return i5;
            }
        }
        return i4 ^ (-1);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.l; i2++) {
                try {
                    K kJ = j(i2);
                    V vN = n(i2);
                    Object obj2 = gVar.get(kJ);
                    if (vN == null) {
                        if (obj2 != null || !gVar.containsKey(kJ)) {
                            return false;
                        }
                    } else if (!vN.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i3 = 0; i3 < this.l; i3++) {
                try {
                    K kJ2 = j(i3);
                    V vN2 = n(i3);
                    Object obj3 = map.get(kJ2);
                    if (vN2 == null) {
                        if (obj3 != null || !map.containsKey(kJ2)) {
                            return false;
                        }
                    } else if (!vN2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? h() : e(obj, obj.hashCode());
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int iF = f(obj);
        return iF >= 0 ? (V) this.f2949k[(iF << 1) + 1] : v;
    }

    int h() {
        int i2 = this.l;
        if (i2 == 0) {
            return -1;
        }
        int iB = b(this.f2948j, i2, 0);
        if (iB < 0 || this.f2949k[iB << 1] == null) {
            return iB;
        }
        int i3 = iB + 1;
        while (i3 < i2 && this.f2948j[i3] == 0) {
            if (this.f2949k[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iB - 1; i4 >= 0 && this.f2948j[i4] == 0; i4--) {
            if (this.f2949k[i4 << 1] == null) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    public int hashCode() {
        int[] iArr = this.f2948j;
        Object[] objArr = this.f2949k;
        int i2 = this.l;
        int i3 = 1;
        int i4 = 0;
        int iHashCode = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return iHashCode;
    }

    int i(Object obj) {
        int i2 = this.l * 2;
        Object[] objArr = this.f2949k;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.l <= 0;
    }

    public K j(int i2) {
        return (K) this.f2949k[i2 << 1];
    }

    public void k(g<? extends K, ? extends V> gVar) {
        int i2 = gVar.l;
        c(this.l + i2);
        if (this.l != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(gVar.j(i3), gVar.n(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(gVar.f2948j, 0, this.f2948j, 0, i2);
            System.arraycopy(gVar.f2949k, 0, this.f2949k, 0, i2 << 1);
            this.l = i2;
        }
    }

    public V l(int i2) {
        Object[] objArr = this.f2949k;
        int i3 = i2 << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.l;
        int i5 = 0;
        if (i4 <= 1) {
            d(this.f2948j, objArr, i4);
            this.f2948j = c.a;
            this.f2949k = c.f2917c;
        } else {
            int i6 = i4 - 1;
            int[] iArr = this.f2948j;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i6) {
                    int i7 = i2 + 1;
                    int i8 = i6 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr2 = this.f2949k;
                    System.arraycopy(objArr2, i7 << 1, objArr2, i3, i8 << 1);
                }
                Object[] objArr3 = this.f2949k;
                int i9 = i6 << 1;
                objArr3[i9] = null;
                objArr3[i9 + 1] = null;
            } else {
                a(i4 > 8 ? i4 + (i4 >> 1) : 8);
                if (i4 != this.l) {
                    throw new ConcurrentModificationException();
                }
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.f2948j, 0, i2);
                    System.arraycopy(objArr, 0, this.f2949k, 0, i3);
                }
                if (i2 < i6) {
                    int i10 = i2 + 1;
                    int i11 = i6 - i2;
                    System.arraycopy(iArr, i10, this.f2948j, i2, i11);
                    System.arraycopy(objArr, i10 << 1, this.f2949k, i3, i11 << 1);
                }
            }
            i5 = i6;
        }
        if (i4 != this.l) {
            throw new ConcurrentModificationException();
        }
        this.l = i5;
        return v;
    }

    public V m(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        Object[] objArr = this.f2949k;
        V v2 = (V) objArr[i3];
        objArr[i3] = v;
        return v2;
    }

    public V n(int i2) {
        return (V) this.f2949k[(i2 << 1) + 1];
    }

    public V put(K k2, V v) {
        int i2;
        int iE;
        int i3 = this.l;
        if (k2 == null) {
            iE = h();
            i2 = 0;
        } else {
            int iHashCode = k2.hashCode();
            i2 = iHashCode;
            iE = e(k2, iHashCode);
        }
        if (iE >= 0) {
            int i4 = (iE << 1) + 1;
            Object[] objArr = this.f2949k;
            V v2 = (V) objArr[i4];
            objArr[i4] = v;
            return v2;
        }
        int i5 = iE ^ (-1);
        int[] iArr = this.f2948j;
        if (i3 >= iArr.length) {
            int i6 = 4;
            if (i3 >= 8) {
                i6 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i6 = 8;
            }
            Object[] objArr2 = this.f2949k;
            a(i6);
            if (i3 != this.l) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f2948j;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f2949k, 0, objArr2.length);
            }
            d(iArr, objArr2, i3);
        }
        if (i5 < i3) {
            int[] iArr3 = this.f2948j;
            int i7 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
            Object[] objArr3 = this.f2949k;
            System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.l - i5) << 1);
        }
        int i8 = this.l;
        if (i3 == i8) {
            int[] iArr4 = this.f2948j;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                Object[] objArr4 = this.f2949k;
                int i9 = i5 << 1;
                objArr4[i9] = k2;
                objArr4[i9 + 1] = v;
                this.l = i8 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k2, V v) {
        V v2 = get(k2);
        return v2 == null ? put(k2, v) : v2;
    }

    public V remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return l(iF);
        }
        return null;
    }

    public V replace(K k2, V v) {
        int iF = f(k2);
        if (iF >= 0) {
            return m(iF, v);
        }
        return null;
    }

    public int size() {
        return this.l;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.l * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.l; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            K kJ = j(i2);
            if (kJ != this) {
                sb.append(kJ);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vN = n(i2);
            if (vN != this) {
                sb.append(vN);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        V vN = n(iF);
        if (obj2 != vN && (obj2 == null || !obj2.equals(vN))) {
            return false;
        }
        l(iF);
        return true;
    }

    public boolean replace(K k2, V v, V v2) {
        int iF = f(k2);
        if (iF < 0) {
            return false;
        }
        V vN = n(iF);
        if (vN != v && (v == null || !v.equals(vN))) {
            return false;
        }
        m(iF, v2);
        return true;
    }

    public g(int i2) {
        if (i2 == 0) {
            this.f2948j = c.a;
            this.f2949k = c.f2917c;
        } else {
            a(i2);
        }
        this.l = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            k(gVar);
        }
    }
}
