package f.b;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static <T> void a(T t, Class<T> cls) {
        if (t != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    public static <T> T b(T t) {
        t.getClass();
        return t;
    }

    public static <T> T c(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
}
