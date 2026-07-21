package androidx.datastore.preferences.protobuf;

import okhttp3.HttpUrl;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'g' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: JavaType.java */
/* JADX INFO: loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b0 f1261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b0 f1262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b0 f1263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final b0 f1264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final b0 f1265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final b0 f1266k;
    public static final b0 l;
    public static final b0 m;
    public static final b0 n;
    public static final b0 o;
    private static final /* synthetic */ b0[] p;
    private final Class<?> q;
    private final Class<?> r;
    private final Object s;

    static {
        b0 b0Var = new b0("VOID", 0, Void.class, Void.class, null);
        f1261f = b0Var;
        Class cls = Integer.TYPE;
        b0 b0Var2 = new b0("INT", 1, cls, Integer.class, 0);
        f1262g = b0Var2;
        b0 b0Var3 = new b0("LONG", 2, Long.TYPE, Long.class, 0L);
        f1263h = b0Var3;
        b0 b0Var4 = new b0("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f1264i = b0Var4;
        b0 b0Var5 = new b0("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f1265j = b0Var5;
        b0 b0Var6 = new b0("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f1266k = b0Var6;
        b0 b0Var7 = new b0("STRING", 6, String.class, String.class, HttpUrl.FRAGMENT_ENCODE_SET);
        l = b0Var7;
        b0 b0Var8 = new b0("BYTE_STRING", 7, h.class, h.class, h.f1298f);
        m = b0Var8;
        b0 b0Var9 = new b0("ENUM", 8, cls, Integer.class, null);
        n = b0Var9;
        b0 b0Var10 = new b0("MESSAGE", 9, Object.class, Object.class, null);
        o = b0Var10;
        p = new b0[]{b0Var, b0Var2, b0Var3, b0Var4, b0Var5, b0Var6, b0Var7, b0Var8, b0Var9, b0Var10};
    }

    private b0(String str, int i2, Class cls, Class cls2, Object obj) {
        super(str, i2);
        this.q = cls;
        this.r = cls2;
        this.s = obj;
    }

    public static b0 valueOf(String str) {
        return (b0) Enum.valueOf(b0.class, str);
    }

    public static b0[] values() {
        return (b0[]) p.clone();
    }

    public Class<?> g() {
        return this.r;
    }
}
