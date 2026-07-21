package kotlin.reflect.y.internal.k0;

/* JADX INFO: compiled from: HashPMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b<K, V> {
    private static final b<Object, Object> a = new b<>(d.a(), 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d<a<e<K, V>>> f24947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24948c;

    private b(d<a<e<K, V>>> dVar, int i2) {
        this.f24947b = dVar;
        this.f24948c = i2;
    }

    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[2];
        objArr[0] = "kotlin/reflect/jvm/internal/pcollections/HashPMap";
        if (i2 != 1) {
            objArr[1] = "empty";
        } else {
            objArr[1] = "minus";
        }
        throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", objArr));
    }

    public static <K, V> b<K, V> b() {
        b<K, V> bVar = (b<K, V>) a;
        if (bVar == null) {
            a(0);
        }
        return bVar;
    }

    private a<e<K, V>> d(int i2) {
        a<e<K, V>> aVarB = this.f24947b.b(i2);
        return aVarB == null ? a.f() : aVarB;
    }

    private static <K, V> int e(a<e<K, V>> aVar, Object obj) {
        int i2 = 0;
        while (aVar != null && aVar.size() > 0) {
            if (aVar.f24943g.f24955f.equals(obj)) {
                return i2;
            }
            aVar = aVar.f24944h;
            i2++;
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public V c(Object obj) {
        for (a aVarD = d(obj.hashCode()); aVarD != null && aVarD.size() > 0; aVarD = aVarD.f24944h) {
            e eVar = (e) aVarD.f24943g;
            if (eVar.f24955f.equals(obj)) {
                return eVar.f24956g;
            }
        }
        return null;
    }

    public b<K, V> f(K k2, V v) {
        a<e<K, V>> aVarD = d(k2.hashCode());
        int size = aVarD.size();
        int iE = e(aVarD, k2);
        if (iE != -1) {
            aVarD = aVarD.h(iE);
        }
        a<e<K, V>> aVarN = aVarD.n(new e<>(k2, v));
        return new b<>(this.f24947b.c(k2.hashCode(), aVarN), (this.f24948c - size) + aVarN.size());
    }
}
