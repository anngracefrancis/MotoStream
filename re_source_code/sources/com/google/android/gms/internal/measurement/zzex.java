package com.google.android.gms.internal.measurement;

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
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzex {
    private static final zzex A;
    private static final zzex B;
    private static final zzex C;
    private static final zzex D;
    private static final zzex E;
    private static final zzex F;
    private static final zzex G;
    private static final zzex H;
    private static final zzex I;
    private static final zzex J;
    private static final zzex K;
    private static final zzex L;
    private static final zzex M;
    private static final zzex N;
    public static final zzex O;
    private static final zzex P;
    private static final zzex Q;
    private static final zzex R;
    private static final zzex S;
    private static final zzex T;
    private static final zzex U;
    private static final zzex V;
    private static final zzex W;
    private static final zzex X;
    private static final zzex Y;
    private static final zzex Z;
    private static final zzex a0;
    public static final zzex b0;
    private static final zzex c0;
    private static final zzex d0;
    private static final zzex[] e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzex f17387f;
    private static final Type[] f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzex f17388g;
    private static final /* synthetic */ zzex[] g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzex f17389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzex f17390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzex f17391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final zzex f17392k;
    private static final zzex l;
    private static final zzex m;
    private static final zzex n;
    private static final zzex o;
    private static final zzex p;
    private static final zzex q;
    private static final zzex r;
    private static final zzex s;
    private static final zzex t;
    private static final zzex u;
    private static final zzex v;
    private static final zzex w;
    private static final zzex x;
    private static final zzex y;
    private static final zzex z;
    private final zzfq h0;
    private final int i0;
    private final i2 j0;
    private final Class<?> k0;
    private final boolean l0;

    static {
        i2 i2Var = i2.SCALAR;
        zzfq zzfqVar = zzfq.f17416j;
        f17387f = new zzex("DOUBLE", 0, 0, i2Var, zzfqVar);
        zzfq zzfqVar2 = zzfq.f17415i;
        f17388g = new zzex("FLOAT", 1, 1, i2Var, zzfqVar2);
        zzfq zzfqVar3 = zzfq.f17414h;
        f17389h = new zzex("INT64", 2, 2, i2Var, zzfqVar3);
        f17390i = new zzex("UINT64", 3, 3, i2Var, zzfqVar3);
        zzfq zzfqVar4 = zzfq.f17413g;
        f17391j = new zzex("INT32", 4, 4, i2Var, zzfqVar4);
        f17392k = new zzex("FIXED64", 5, 5, i2Var, zzfqVar3);
        l = new zzex("FIXED32", 6, 6, i2Var, zzfqVar4);
        zzfq zzfqVar5 = zzfq.f17417k;
        m = new zzex("BOOL", 7, 7, i2Var, zzfqVar5);
        zzfq zzfqVar6 = zzfq.l;
        n = new zzex("STRING", 8, 8, i2Var, zzfqVar6);
        zzfq zzfqVar7 = zzfq.o;
        o = new zzex("MESSAGE", 9, 9, i2Var, zzfqVar7);
        zzfq zzfqVar8 = zzfq.m;
        p = new zzex("BYTES", 10, 10, i2Var, zzfqVar8);
        q = new zzex("UINT32", 11, 11, i2Var, zzfqVar4);
        zzfq zzfqVar9 = zzfq.n;
        r = new zzex("ENUM", 12, 12, i2Var, zzfqVar9);
        s = new zzex("SFIXED32", 13, 13, i2Var, zzfqVar4);
        t = new zzex("SFIXED64", 14, 14, i2Var, zzfqVar3);
        u = new zzex("SINT32", 15, 15, i2Var, zzfqVar4);
        v = new zzex("SINT64", 16, 16, i2Var, zzfqVar3);
        w = new zzex("GROUP", 17, 17, i2Var, zzfqVar7);
        i2 i2Var2 = i2.VECTOR;
        x = new zzex("DOUBLE_LIST", 18, 18, i2Var2, zzfqVar);
        y = new zzex("FLOAT_LIST", 19, 19, i2Var2, zzfqVar2);
        z = new zzex("INT64_LIST", 20, 20, i2Var2, zzfqVar3);
        A = new zzex("UINT64_LIST", 21, 21, i2Var2, zzfqVar3);
        B = new zzex("INT32_LIST", 22, 22, i2Var2, zzfqVar4);
        C = new zzex("FIXED64_LIST", 23, 23, i2Var2, zzfqVar3);
        D = new zzex("FIXED32_LIST", 24, 24, i2Var2, zzfqVar4);
        E = new zzex("BOOL_LIST", 25, 25, i2Var2, zzfqVar5);
        F = new zzex("STRING_LIST", 26, 26, i2Var2, zzfqVar6);
        G = new zzex("MESSAGE_LIST", 27, 27, i2Var2, zzfqVar7);
        H = new zzex("BYTES_LIST", 28, 28, i2Var2, zzfqVar8);
        I = new zzex("UINT32_LIST", 29, 29, i2Var2, zzfqVar4);
        J = new zzex("ENUM_LIST", 30, 30, i2Var2, zzfqVar9);
        K = new zzex("SFIXED32_LIST", 31, 31, i2Var2, zzfqVar4);
        L = new zzex("SFIXED64_LIST", 32, 32, i2Var2, zzfqVar3);
        M = new zzex("SINT32_LIST", 33, 33, i2Var2, zzfqVar4);
        N = new zzex("SINT64_LIST", 34, 34, i2Var2, zzfqVar3);
        i2 i2Var3 = i2.PACKED_VECTOR;
        O = new zzex("DOUBLE_LIST_PACKED", 35, 35, i2Var3, zzfqVar);
        P = new zzex("FLOAT_LIST_PACKED", 36, 36, i2Var3, zzfqVar2);
        Q = new zzex("INT64_LIST_PACKED", 37, 37, i2Var3, zzfqVar3);
        R = new zzex("UINT64_LIST_PACKED", 38, 38, i2Var3, zzfqVar3);
        S = new zzex("INT32_LIST_PACKED", 39, 39, i2Var3, zzfqVar4);
        T = new zzex("FIXED64_LIST_PACKED", 40, 40, i2Var3, zzfqVar3);
        U = new zzex("FIXED32_LIST_PACKED", 41, 41, i2Var3, zzfqVar4);
        V = new zzex("BOOL_LIST_PACKED", 42, 42, i2Var3, zzfqVar5);
        W = new zzex("UINT32_LIST_PACKED", 43, 43, i2Var3, zzfqVar4);
        X = new zzex("ENUM_LIST_PACKED", 44, 44, i2Var3, zzfqVar9);
        Y = new zzex("SFIXED32_LIST_PACKED", 45, 45, i2Var3, zzfqVar4);
        zzfq zzfqVar10 = zzfq.f17414h;
        Z = new zzex("SFIXED64_LIST_PACKED", 46, 46, i2Var3, zzfqVar10);
        a0 = new zzex("SINT32_LIST_PACKED", 47, 47, i2Var3, zzfq.f17413g);
        b0 = new zzex("SINT64_LIST_PACKED", 48, 48, i2Var3, zzfqVar10);
        c0 = new zzex("GROUP_LIST", 49, 49, i2Var2, zzfqVar7);
        d0 = new zzex("MAP", 50, 50, i2.MAP, zzfq.f17412f);
        g0 = new zzex[]{f17387f, f17388g, f17389h, f17390i, f17391j, f17392k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0};
        f0 = new Type[0];
        zzex[] zzexVarArrValues = values();
        e0 = new zzex[zzexVarArrValues.length];
        for (zzex zzexVar : zzexVarArrValues) {
            e0[zzexVar.i0] = zzexVar;
        }
    }

    private zzex(String str, int i2, int i3, i2 i2Var, zzfq zzfqVar) {
        int i4;
        super(str, i2);
        this.i0 = i3;
        this.j0 = i2Var;
        this.h0 = zzfqVar;
        int i5 = j2.a[i2Var.ordinal()];
        if (i5 == 1 || i5 == 2) {
            this.k0 = zzfqVar.g();
        } else {
            this.k0 = null;
        }
        this.l0 = (i2Var != i2.SCALAR || (i4 = j2.f17185b[zzfqVar.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : true;
    }

    public static zzex[] values() {
        return (zzex[]) g0.clone();
    }

    public final int a() {
        return this.i0;
    }
}
