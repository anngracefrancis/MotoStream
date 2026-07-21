package k.b.f;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: MessageFormatter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final a a(String str, Object[] objArr) {
        Throwable thJ = j(objArr);
        if (thJ != null) {
            objArr = r(objArr);
        }
        return b(str, objArr, thJ);
    }

    public static final a b(String str, Object[] objArr, Throwable th) {
        int i2;
        if (str == null) {
            return new a(null, objArr, th);
        }
        if (objArr == null) {
            return new a(str);
        }
        StringBuilder sb = new StringBuilder(str.length() + 50);
        int i3 = 0;
        int i4 = 0;
        while (i3 < objArr.length) {
            int iIndexOf = str.indexOf("{}", i4);
            if (iIndexOf == -1) {
                if (i4 == 0) {
                    return new a(str, objArr, th);
                }
                sb.append((CharSequence) str, i4, str.length());
                return new a(sb.toString(), objArr, th);
            }
            if (m(str, iIndexOf)) {
                if (l(str, iIndexOf)) {
                    sb.append((CharSequence) str, i4, iIndexOf - 1);
                    f(sb, objArr[i3], new HashMap());
                } else {
                    i3--;
                    sb.append((CharSequence) str, i4, iIndexOf - 1);
                    sb.append('{');
                    i2 = iIndexOf + 1;
                }
                i4 = i2;
                i3++;
            } else {
                sb.append((CharSequence) str, i4, iIndexOf);
                f(sb, objArr[i3], new HashMap());
            }
            i2 = iIndexOf + 2;
            i4 = i2;
            i3++;
        }
        sb.append((CharSequence) str, i4, str.length());
        return new a(sb.toString(), objArr, th);
    }

    private static void c(StringBuilder sb, boolean[] zArr) {
        sb.append('[');
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(zArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void d(StringBuilder sb, byte[] bArr) {
        sb.append('[');
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append((int) bArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void e(StringBuilder sb, char[] cArr) {
        sb.append('[');
        int length = cArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(cArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void f(StringBuilder sb, Object obj, Map<Object[], Object> map) {
        if (obj == null) {
            sb.append("null");
            return;
        }
        if (!obj.getClass().isArray()) {
            p(sb, obj);
            return;
        }
        if (obj instanceof boolean[]) {
            c(sb, (boolean[]) obj);
            return;
        }
        if (obj instanceof byte[]) {
            d(sb, (byte[]) obj);
            return;
        }
        if (obj instanceof char[]) {
            e(sb, (char[]) obj);
            return;
        }
        if (obj instanceof short[]) {
            q(sb, (short[]) obj);
            return;
        }
        if (obj instanceof int[]) {
            k(sb, (int[]) obj);
            return;
        }
        if (obj instanceof long[]) {
            n(sb, (long[]) obj);
            return;
        }
        if (obj instanceof float[]) {
            h(sb, (float[]) obj);
        } else if (obj instanceof double[]) {
            g(sb, (double[]) obj);
        } else {
            o(sb, (Object[]) obj, map);
        }
    }

    private static void g(StringBuilder sb, double[] dArr) {
        sb.append('[');
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(dArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void h(StringBuilder sb, float[] fArr) {
        sb.append('[');
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(fArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    public static final a i(String str, Object obj, Object obj2) {
        return a(str, new Object[]{obj, obj2});
    }

    static final Throwable j(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    private static void k(StringBuilder sb, int[] iArr) {
        sb.append('[');
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(iArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    static final boolean l(String str, int i2) {
        return i2 >= 2 && str.charAt(i2 - 2) == '\\';
    }

    static final boolean m(String str, int i2) {
        return i2 != 0 && str.charAt(i2 - 1) == '\\';
    }

    private static void n(StringBuilder sb, long[] jArr) {
        sb.append('[');
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(jArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static void o(StringBuilder sb, Object[] objArr, Map<Object[], Object> map) {
        sb.append('[');
        if (map.containsKey(objArr)) {
            sb.append("...");
        } else {
            map.put(objArr, null);
            int length = objArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                f(sb, objArr[i2], map);
                if (i2 != length - 1) {
                    sb.append(", ");
                }
            }
            map.remove(objArr);
        }
        sb.append(']');
    }

    private static void p(StringBuilder sb, Object obj) {
        try {
            sb.append(obj.toString());
        } catch (Throwable th) {
            i.b("SLF4J: Failed toString() invocation on an object of type [" + obj.getClass().getName() + "]", th);
            sb.append("[FAILED toString()]");
        }
    }

    private static void q(StringBuilder sb, short[] sArr) {
        sb.append('[');
        int length = sArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append((int) sArr[i2]);
            if (i2 != length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
    }

    private static Object[] r(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }
}
