package com.google.android.gms.internal.ads;

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
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnv {
    private static final zzdnv A;
    private static final zzdnv B;
    private static final zzdnv C;
    private static final zzdnv D;
    private static final zzdnv E;
    private static final zzdnv F;
    private static final zzdnv G;
    private static final zzdnv H;
    private static final zzdnv I;
    private static final zzdnv J;
    private static final zzdnv K;
    private static final zzdnv L;
    private static final zzdnv M;
    private static final zzdnv N;
    public static final zzdnv O;
    private static final zzdnv P;
    private static final zzdnv Q;
    private static final zzdnv R;
    private static final zzdnv S;
    private static final zzdnv T;
    private static final zzdnv U;
    private static final zzdnv V;
    private static final zzdnv W;
    private static final zzdnv X;
    private static final zzdnv Y;
    private static final zzdnv Z;
    private static final zzdnv a0;
    public static final zzdnv b0;
    private static final zzdnv c0;
    private static final zzdnv d0;
    private static final zzdnv[] e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzdnv f16012f;
    private static final Type[] f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final zzdnv f16013g;
    private static final /* synthetic */ zzdnv[] g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final zzdnv f16014h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final zzdnv f16015i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final zzdnv f16016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final zzdnv f16017k;
    private static final zzdnv l;
    private static final zzdnv m;
    private static final zzdnv n;
    private static final zzdnv o;
    private static final zzdnv p;
    private static final zzdnv q;
    private static final zzdnv r;
    private static final zzdnv s;
    private static final zzdnv t;
    private static final zzdnv u;
    private static final zzdnv v;
    private static final zzdnv w;
    private static final zzdnv x;
    private static final zzdnv y;
    private static final zzdnv z;
    private final zzdom h0;
    private final int i0;
    private final bv j0;
    private final Class<?> k0;
    private final boolean l0;

    static {
        bv bvVar = bv.SCALAR;
        zzdom zzdomVar = zzdom.f16041j;
        f16012f = new zzdnv("DOUBLE", 0, 0, bvVar, zzdomVar);
        zzdom zzdomVar2 = zzdom.f16040i;
        f16013g = new zzdnv("FLOAT", 1, 1, bvVar, zzdomVar2);
        zzdom zzdomVar3 = zzdom.f16039h;
        f16014h = new zzdnv("INT64", 2, 2, bvVar, zzdomVar3);
        f16015i = new zzdnv("UINT64", 3, 3, bvVar, zzdomVar3);
        zzdom zzdomVar4 = zzdom.f16038g;
        f16016j = new zzdnv("INT32", 4, 4, bvVar, zzdomVar4);
        f16017k = new zzdnv("FIXED64", 5, 5, bvVar, zzdomVar3);
        l = new zzdnv("FIXED32", 6, 6, bvVar, zzdomVar4);
        zzdom zzdomVar5 = zzdom.f16042k;
        m = new zzdnv("BOOL", 7, 7, bvVar, zzdomVar5);
        zzdom zzdomVar6 = zzdom.l;
        n = new zzdnv("STRING", 8, 8, bvVar, zzdomVar6);
        zzdom zzdomVar7 = zzdom.o;
        o = new zzdnv("MESSAGE", 9, 9, bvVar, zzdomVar7);
        zzdom zzdomVar8 = zzdom.m;
        p = new zzdnv("BYTES", 10, 10, bvVar, zzdomVar8);
        q = new zzdnv("UINT32", 11, 11, bvVar, zzdomVar4);
        zzdom zzdomVar9 = zzdom.n;
        r = new zzdnv("ENUM", 12, 12, bvVar, zzdomVar9);
        s = new zzdnv("SFIXED32", 13, 13, bvVar, zzdomVar4);
        t = new zzdnv("SFIXED64", 14, 14, bvVar, zzdomVar3);
        u = new zzdnv("SINT32", 15, 15, bvVar, zzdomVar4);
        v = new zzdnv("SINT64", 16, 16, bvVar, zzdomVar3);
        w = new zzdnv("GROUP", 17, 17, bvVar, zzdomVar7);
        bv bvVar2 = bv.VECTOR;
        x = new zzdnv("DOUBLE_LIST", 18, 18, bvVar2, zzdomVar);
        y = new zzdnv("FLOAT_LIST", 19, 19, bvVar2, zzdomVar2);
        z = new zzdnv("INT64_LIST", 20, 20, bvVar2, zzdomVar3);
        A = new zzdnv("UINT64_LIST", 21, 21, bvVar2, zzdomVar3);
        B = new zzdnv("INT32_LIST", 22, 22, bvVar2, zzdomVar4);
        C = new zzdnv("FIXED64_LIST", 23, 23, bvVar2, zzdomVar3);
        D = new zzdnv("FIXED32_LIST", 24, 24, bvVar2, zzdomVar4);
        E = new zzdnv("BOOL_LIST", 25, 25, bvVar2, zzdomVar5);
        F = new zzdnv("STRING_LIST", 26, 26, bvVar2, zzdomVar6);
        G = new zzdnv("MESSAGE_LIST", 27, 27, bvVar2, zzdomVar7);
        H = new zzdnv("BYTES_LIST", 28, 28, bvVar2, zzdomVar8);
        I = new zzdnv("UINT32_LIST", 29, 29, bvVar2, zzdomVar4);
        J = new zzdnv("ENUM_LIST", 30, 30, bvVar2, zzdomVar9);
        K = new zzdnv("SFIXED32_LIST", 31, 31, bvVar2, zzdomVar4);
        L = new zzdnv("SFIXED64_LIST", 32, 32, bvVar2, zzdomVar3);
        M = new zzdnv("SINT32_LIST", 33, 33, bvVar2, zzdomVar4);
        N = new zzdnv("SINT64_LIST", 34, 34, bvVar2, zzdomVar3);
        bv bvVar3 = bv.PACKED_VECTOR;
        O = new zzdnv("DOUBLE_LIST_PACKED", 35, 35, bvVar3, zzdomVar);
        P = new zzdnv("FLOAT_LIST_PACKED", 36, 36, bvVar3, zzdomVar2);
        Q = new zzdnv("INT64_LIST_PACKED", 37, 37, bvVar3, zzdomVar3);
        R = new zzdnv("UINT64_LIST_PACKED", 38, 38, bvVar3, zzdomVar3);
        S = new zzdnv("INT32_LIST_PACKED", 39, 39, bvVar3, zzdomVar4);
        T = new zzdnv("FIXED64_LIST_PACKED", 40, 40, bvVar3, zzdomVar3);
        U = new zzdnv("FIXED32_LIST_PACKED", 41, 41, bvVar3, zzdomVar4);
        V = new zzdnv("BOOL_LIST_PACKED", 42, 42, bvVar3, zzdomVar5);
        W = new zzdnv("UINT32_LIST_PACKED", 43, 43, bvVar3, zzdomVar4);
        X = new zzdnv("ENUM_LIST_PACKED", 44, 44, bvVar3, zzdomVar9);
        Y = new zzdnv("SFIXED32_LIST_PACKED", 45, 45, bvVar3, zzdomVar4);
        zzdom zzdomVar10 = zzdom.f16039h;
        Z = new zzdnv("SFIXED64_LIST_PACKED", 46, 46, bvVar3, zzdomVar10);
        a0 = new zzdnv("SINT32_LIST_PACKED", 47, 47, bvVar3, zzdom.f16038g);
        b0 = new zzdnv("SINT64_LIST_PACKED", 48, 48, bvVar3, zzdomVar10);
        c0 = new zzdnv("GROUP_LIST", 49, 49, bvVar2, zzdomVar7);
        d0 = new zzdnv("MAP", 50, 50, bv.MAP, zzdom.f16037f);
        g0 = new zzdnv[]{f16012f, f16013g, f16014h, f16015i, f16016j, f16017k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, a0, b0, c0, d0};
        f0 = new Type[0];
        zzdnv[] zzdnvVarArrValues = values();
        e0 = new zzdnv[zzdnvVarArrValues.length];
        for (zzdnv zzdnvVar : zzdnvVarArrValues) {
            e0[zzdnvVar.i0] = zzdnvVar;
        }
    }

    private zzdnv(String str, int i2, int i3, bv bvVar, zzdom zzdomVar) {
        int i4;
        super(str, i2);
        this.i0 = i3;
        this.j0 = bvVar;
        this.h0 = zzdomVar;
        int i5 = av.a[bvVar.ordinal()];
        if (i5 == 1 || i5 == 2) {
            this.k0 = zzdomVar.g();
        } else {
            this.k0 = null;
        }
        this.l0 = (bvVar != bv.SCALAR || (i4 = av.f12267b[zzdomVar.ordinal()]) == 1 || i4 == 2 || i4 == 3) ? false : true;
    }

    public static zzdnv[] values() {
        return (zzdnv[]) g0.clone();
    }

    public final int g() {
        return this.i0;
    }
}
