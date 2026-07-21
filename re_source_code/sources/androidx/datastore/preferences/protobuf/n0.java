package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: MapFieldSchemas.java */
/* JADX INFO: loaded from: classes.dex */
final class n0 {
    private static final l0 a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final l0 f1372b = new m0();

    static l0 a() {
        return a;
    }

    static l0 b() {
        return f1372b;
    }

    private static l0 c() {
        try {
            return (l0) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
