package h.a.z.b;

import h.a.y.c;

/* JADX INFO: compiled from: ObjectHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    static final c<Object, Object> a = new a();

    /* JADX INFO: compiled from: ObjectHelper.java */
    static final class a implements c<Object, Object> {
        a() {
        }
    }

    public static int a(int i2, int i3) {
        if (i2 < i3) {
            return -1;
        }
        return i2 > i3 ? 1 : 0;
    }

    public static int b(long j2, long j3) {
        if (j2 < j3) {
            return -1;
        }
        return j2 > j3 ? 1 : 0;
    }

    public static <T> T c(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int d(int i2, String str) {
        if (i2 > 0) {
            return i2;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i2);
    }
}
