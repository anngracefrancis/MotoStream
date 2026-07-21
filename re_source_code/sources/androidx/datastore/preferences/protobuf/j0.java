package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: MapEntryLite.java */
/* JADX INFO: loaded from: classes.dex */
public class j0<K, V> {
    private final a<K, V> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final K f1350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final V f1351c;

    /* JADX INFO: compiled from: MapEntryLite.java */
    static class a<K, V> {
        public final r1.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final K f1352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r1.b f1353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final V f1354d;

        public a(r1.b bVar, K k2, r1.b bVar2, V v) {
            this.a = bVar;
            this.f1352b = k2;
            this.f1353c = bVar2;
            this.f1354d = v;
        }
    }

    private j0(r1.b bVar, K k2, r1.b bVar2, V v) {
        this.a = new a<>(bVar, k2, bVar2, v);
        this.f1350b = k2;
        this.f1351c = v;
    }

    static <K, V> int b(a<K, V> aVar, K k2, V v) {
        return u.d(aVar.a, 1, k2) + u.d(aVar.f1353c, 2, v);
    }

    public static <K, V> j0<K, V> d(r1.b bVar, K k2, r1.b bVar2, V v) {
        return new j0<>(bVar, k2, bVar2, v);
    }

    static <K, V> void e(CodedOutputStream codedOutputStream, a<K, V> aVar, K k2, V v) throws IOException {
        u.z(codedOutputStream, aVar.a, 1, k2);
        u.z(codedOutputStream, aVar.f1353c, 2, v);
    }

    public int a(int i2, K k2, V v) {
        return CodedOutputStream.V(i2) + CodedOutputStream.C(b(this.a, k2, v));
    }

    a<K, V> c() {
        return this.a;
    }
}
