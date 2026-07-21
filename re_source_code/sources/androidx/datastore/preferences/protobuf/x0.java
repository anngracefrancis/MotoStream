package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: NewInstanceSchemas.java */
/* JADX INFO: loaded from: classes.dex */
final class x0 {
    private static final v0 a = c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final v0 f1446b = new w0();

    static v0 a() {
        return a;
    }

    static v0 b() {
        return f1446b;
    }

    private static v0 c() {
        try {
            return (v0) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
