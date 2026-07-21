package c.u.a;

/* JADX INFO: compiled from: SimpleSQLiteQuery.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f3468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object[] f3469g;

    public a(String str, Object[] objArr) {
        this.f3468f = str;
        this.f3469g = objArr;
    }

    private static void c(d dVar, int i2, Object obj) {
        if (obj == null) {
            dVar.I0(i2);
            return;
        }
        if (obj instanceof byte[]) {
            dVar.o0(i2, (byte[]) obj);
            return;
        }
        if (obj instanceof Float) {
            dVar.L(i2, ((Float) obj).floatValue());
            return;
        }
        if (obj instanceof Double) {
            dVar.L(i2, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Long) {
            dVar.h0(i2, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof Integer) {
            dVar.h0(i2, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Short) {
            dVar.h0(i2, ((Short) obj).shortValue());
            return;
        }
        if (obj instanceof Byte) {
            dVar.h0(i2, ((Byte) obj).byteValue());
            return;
        }
        if (obj instanceof String) {
            dVar.w(i2, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            dVar.h0(i2, ((Boolean) obj).booleanValue() ? 1L : 0L);
            return;
        }
        throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i2 + " Supported types: null, byte[], float, double, long, int, short, byte, string");
    }

    public static void d(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i2 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            i2++;
            c(dVar, i2, obj);
        }
    }

    @Override // c.u.a.e
    public String a() {
        return this.f3468f;
    }

    @Override // c.u.a.e
    public void b(d dVar) {
        d(dVar, this.f3469g);
    }

    public a(String str) {
        this(str, null);
    }
}
