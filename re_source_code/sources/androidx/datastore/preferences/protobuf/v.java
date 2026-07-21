package androidx.datastore.preferences.protobuf;

import java.lang.reflect.Type;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: FieldType.java */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public static final v A;
    public static final v B;
    public static final v C;
    public static final v D;
    public static final v E;
    public static final v F;
    public static final v G;
    public static final v H;
    public static final v I;
    public static final v J;
    public static final v K;
    public static final v L;
    public static final v M;
    public static final v N;
    public static final v O;
    public static final v P;
    public static final v Q;
    public static final v R;
    public static final v S;
    public static final v T;
    public static final v U;
    public static final v V;
    public static final v W;
    public static final v X;
    public static final v Y;
    public static final v Z;
    public static final v a0;
    public static final v b0;
    public static final v c0;
    public static final v d0;
    private static final v[] e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v f1430f;
    private static final Type[] f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f1431g;
    private static final /* synthetic */ v[] g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v f1432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f1433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final v f1434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v f1435k;
    public static final v l;
    public static final v m;
    public static final v n;
    public static final v o;
    public static final v p;
    public static final v q;
    public static final v r;
    public static final v s;
    public static final v t;
    public static final v u;
    public static final v v;
    public static final v w;
    public static final v x;
    public static final v y;
    public static final v z;
    private final b0 h0;
    private final int i0;
    private final b j0;
    private final Class<?> k0;
    private final boolean l0;

    /* JADX INFO: compiled from: FieldType.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1436b;

        static {
            int[] iArr = new int[b0.values().length];
            f1436b = iArr;
            try {
                iArr[b0.m.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1436b[b0.o.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1436b[b0.l.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            a = iArr2;
            try {
                iArr2[b.MAP.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.VECTOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.SCALAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: FieldType.java */
    enum b {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);


        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final boolean f1442k;

        b(boolean z) {
            this.f1442k = z;
        }
    }

    static {
        b bVar = b.SCALAR;
        b0 b0Var = b0.f1265j;
        f1430f = new v("DOUBLE", 0, 0, bVar, b0Var);
        b0 b0Var2 = b0.f1264i;
        f1431g = new v("FLOAT", 1, 1, bVar, b0Var2);
        b0 b0Var3 = b0.f1263h;
        f1432h = new v("INT64", 2, 2, bVar, b0Var3);
        f1433i = new v("UINT64", 3, 3, bVar, b0Var3);
        b0 b0Var4 = b0.f1262g;
        f1434j = new v("INT32", 4, 4, bVar, b0Var4);
        f1435k = new v("FIXED64", 5, 5, bVar, b0Var3);
        l = new v("FIXED32", 6, 6, bVar, b0Var4);
        b0 b0Var5 = b0.f1266k;
        m = new v("BOOL", 7, 7, bVar, b0Var5);
        b0 b0Var6 = b0.l;
        n = new v("STRING", 8, 8, bVar, b0Var6);
        b0 b0Var7 = b0.o;
        o = new v("MESSAGE", 9, 9, bVar, b0Var7);
        b0 b0Var8 = b0.m;
        p = new v("BYTES", 10, 10, bVar, b0Var8);
        q = new v("UINT32", 11, 11, bVar, b0Var4);
        b0 b0Var9 = b0.n;
        r = new v("ENUM", 12, 12, bVar, b0Var9);
        s = new v("SFIXED32", 13, 13, bVar, b0Var4);
        t = new v("SFIXED64", 14, 14, bVar, b0Var3);
        u = new v("SINT32", 15, 15, bVar, b0Var4);
        v = new v("SINT64", 16, 16, bVar, b0Var3);
        w = new v("GROUP", 17, 17, bVar, b0Var7);
        b bVar2 = b.VECTOR;
        x = new v("DOUBLE_LIST", 18, 18, bVar2, b0Var);
        y = new v("FLOAT_LIST", 19, 19, bVar2, b0Var2);
        z = new v("INT64_LIST", 20, 20, bVar2, b0Var3);
        A = new v("UINT64_LIST", 21, 21, bVar2, b0Var3);
        B = new v("INT32_LIST", 22, 22, bVar2, b0Var4);
        C = new v("FIXED64_LIST", 23, 23, bVar2, b0Var3);
        D = new v("FIXED32_LIST", 24, 24, bVar2, b0Var4);
        E = new v("BOOL_LIST", 25, 25, bVar2, b0Var5);
        F = new v("STRING_LIST", 26, 26, bVar2, b0Var6);
        G = new v("MESSAGE_LIST", 27, 27, bVar2, b0Var7);
        H = new v("BYTES_LIST", 28, 28, bVar2, b0Var8);
        I = new v("UINT32_LIST", 29, 29, bVar2, b0Var4);
        J = new v("ENUM_LIST", 30, 30, bVar2, b0Var9);
        K = new v("SFIXED32_LIST", 31, 31, bVar2, b0Var4);
        L = new v("SFIXED64_LIST", 32, 32, bVar2, b0Var3);
        M = new v("SINT32_LIST", 33, 33, bVar2, b0Var4);
        N = new v("SINT64_LIST", 34, 34, bVar2, b0Var3);
        b bVar3 = b.PACKED_VECTOR;
        O = new v("DOUBLE_LIST_PACKED", 35, 35, bVar3, b0Var);
        P = new v("FLOAT_LIST_PACKED", 36, 36, bVar3, b0Var2);
        Q = new v("INT64_LIST_PACKED", 37, 37, bVar3, b0Var3);
        R = new v("UINT64_LIST_PACKED", 38, 38, bVar3, b0Var3);
        S = new v("INT32_LIST_PACKED", 39, 39, bVar3, b0Var4);
        T = new v("FIXED64_LIST_PACKED", 40, 40, bVar3, b0Var3);
        U = new v("FIXED32_LIST_PACKED", 41, 41, bVar3, b0Var4);
        V = new v("BOOL_LIST_PACKED", 42, 42, bVar3, b0Var5);
        W = new v("UINT32_LIST_PACKED", 43, 43, bVar3, b0Var4);
        X = new v("ENUM_LIST_PACKED", 44, 44, bVar3, b0Var9);
        Y = new v("SFIXED32_LIST_PACKED", 45, 45, bVar3, b0Var4);
        b0 b0Var10 = b0.f1263h;
        Z = new v("SFIXED64_LIST_PACKED", 46, 46, bVar3, b0Var10);
        a0 = new v("SINT32_LIST_PACKED", 47, 47, bVar3, b0.f1262g);
        b0 = new v("SINT64_LIST_PACKED", 48, 48, bVar3, b0Var10);
        c0 = new v("GROUP_LIST", 49, 49, bVar2, b0Var7);
        d0 = new v("MAP", 50, 50, b.MAP, b0.f1261f);
        g0 = new v[]{f1430f, f1431g, f1432h, f1433i, f1434j, f1435k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0};
        f0 = new Type[0];
        v[] vVarArrValues = values();
        e0 = new v[vVarArrValues.length];
        for (v vVar : vVarArrValues) {
            e0[vVar.i0] = vVar;
        }
    }

    private v(String str, int i2, int i3, b bVar, b0 b0Var) {
        int i4;
        super(str, i2);
        this.i0 = i3;
        this.j0 = bVar;
        this.h0 = b0Var;
        int i5 = a.a[bVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            this.k0 = b0Var.g();
        } else {
            this.k0 = null;
        }
        this.l0 = (bVar != b.SCALAR || (i4 = a.f1436b[b0Var.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : true;
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) g0.clone();
    }

    public int g() {
        return this.i0;
    }
}
