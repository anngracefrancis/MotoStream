package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: ExtensionRegistryFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class o {
    static final Class<?> a = c();

    public static p a() {
        if (a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return p.f1381d;
    }

    private static final p b(String str) throws Exception {
        return (p) a.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    static Class<?> c() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
