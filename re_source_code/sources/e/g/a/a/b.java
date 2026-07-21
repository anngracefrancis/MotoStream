package e.g.a.a;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
