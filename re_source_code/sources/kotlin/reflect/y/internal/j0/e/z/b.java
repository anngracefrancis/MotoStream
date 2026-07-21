package kotlin.reflect.y.internal.j0.e.z;

import kotlin.p002reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.y.internal.j0.e.j;
import kotlin.reflect.y.internal.j0.e.k;
import kotlin.reflect.y.internal.j0.e.x;

/* JADX INFO: compiled from: Flags.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final C0370b A;
    public static final C0370b B;
    public static final C0370b C;
    public static final C0370b D;
    public static final C0370b E;
    public static final C0370b F;
    public static final C0370b G;
    public static final C0370b H;
    public static final C0370b I;
    public static final C0370b J;
    public static final C0370b K;
    public static final C0370b L;
    public static final C0370b M;
    public static final C0370b N;
    public static final C0370b O;
    public static final C0370b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0370b f24182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0370b f24183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d<x> f24184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d<k> f24185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d<kotlin.reflect.y.internal.j0.e.c.EnumC0365c> f24186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0370b f24187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0370b f24188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0370b f24189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final C0370b f24190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C0370b f24191k;
    public static final C0370b l;
    public static final C0370b m;
    public static final C0370b n;
    public static final d<j> o;
    public static final C0370b p;
    public static final C0370b q;
    public static final C0370b r;
    public static final C0370b s;
    public static final C0370b t;
    public static final C0370b u;
    public static final C0370b v;
    public static final C0370b w;
    public static final C0370b x;
    public static final C0370b y;
    public static final C0370b z;

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.z.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Flags.java */
    public static class C0370b extends d<Boolean> {
        public C0370b(int i2) {
            super(i2, 1);
        }

        private static /* synthetic */ void f(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Boolean d(int i2) {
            Boolean boolValueOf = Boolean.valueOf((i2 & (1 << this.a)) != 0);
            if (boolValueOf == null) {
                f(0);
            }
            return boolValueOf;
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int e(Boolean bool) {
            if (bool.booleanValue()) {
                return 1 << this.a;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: Flags.java */
    private static class c<E extends i.a> extends d<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final E[] f24192c;

        public c(int i2, E[] eArr) {
            super(i2, g(eArr));
            this.f24192c = eArr;
        }

        private static /* synthetic */ void f(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
        }

        private static <E> int g(E[] eArr) {
            if (eArr == null) {
                f(0);
            }
            int length = eArr.length - 1;
            if (length == 0) {
                return 1;
            }
            for (int i2 = 31; i2 >= 0; i2--) {
                if (((1 << i2) & length) != 0) {
                    return i2 + 1;
                }
            }
            throw new IllegalStateException("Empty enum: " + eArr.getClass());
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public E d(int i2) {
            int i3 = (1 << this.f24193b) - 1;
            int i4 = this.a;
            int i5 = (i2 & (i3 << i4)) >> i4;
            for (E e2 : this.f24192c) {
                if (e2.f() == i5) {
                    return e2;
                }
            }
            return null;
        }

        @Override // kotlin.f0.y.e.j0.e.z.b.d
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public int e(E e2) {
            return e2.f() << this.a;
        }
    }

    /* JADX INFO: compiled from: Flags.java */
    public static abstract class d<E> {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f24193b;

        /* JADX WARN: Incorrect types in method signature: <E::Lkotlin/reflect/jvm/internal/impl/protobuf/i$a;>(Lkotlin/f0/y/e/j0/e/z/b$d<*>;[TE;)Lkotlin/f0/y/e/j0/e/z/b$d<TE;>; */
        public static d a(d dVar, i.a[] aVarArr) {
            return new c(dVar.a + dVar.f24193b, aVarArr);
        }

        public static C0370b b(d<?> dVar) {
            return new C0370b(dVar.a + dVar.f24193b);
        }

        public static C0370b c() {
            return new C0370b(0);
        }

        public abstract E d(int i2);

        public abstract int e(E e2);

        private d(int i2, int i3) {
            this.a = i2;
            this.f24193b = i3;
        }
    }

    static {
        C0370b c0370bC = d.c();
        a = c0370bC;
        f24182b = d.b(c0370bC);
        C0370b c0370bC2 = d.c();
        f24183c = c0370bC2;
        d<x> dVarA = d.a(c0370bC2, x.values());
        f24184d = dVarA;
        d<k> dVarA2 = d.a(dVarA, k.values());
        f24185e = dVarA2;
        d<kotlin.reflect.y.internal.j0.e.c.EnumC0365c> dVarA3 = d.a(dVarA2, kotlin.reflect.y.internal.j0.e.c.EnumC0365c.values());
        f24186f = dVarA3;
        C0370b c0370bB = d.b(dVarA3);
        f24187g = c0370bB;
        C0370b c0370bB2 = d.b(c0370bB);
        f24188h = c0370bB2;
        C0370b c0370bB3 = d.b(c0370bB2);
        f24189i = c0370bB3;
        C0370b c0370bB4 = d.b(c0370bB3);
        f24190j = c0370bB4;
        C0370b c0370bB5 = d.b(c0370bB4);
        f24191k = c0370bB5;
        l = d.b(c0370bB5);
        C0370b c0370bB6 = d.b(dVarA);
        m = c0370bB6;
        n = d.b(c0370bB6);
        d<j> dVarA4 = d.a(dVarA2, j.values());
        o = dVarA4;
        C0370b c0370bB7 = d.b(dVarA4);
        p = c0370bB7;
        C0370b c0370bB8 = d.b(c0370bB7);
        q = c0370bB8;
        C0370b c0370bB9 = d.b(c0370bB8);
        r = c0370bB9;
        C0370b c0370bB10 = d.b(c0370bB9);
        s = c0370bB10;
        C0370b c0370bB11 = d.b(c0370bB10);
        t = c0370bB11;
        C0370b c0370bB12 = d.b(c0370bB11);
        u = c0370bB12;
        C0370b c0370bB13 = d.b(c0370bB12);
        v = c0370bB13;
        w = d.b(c0370bB13);
        C0370b c0370bB14 = d.b(dVarA4);
        x = c0370bB14;
        C0370b c0370bB15 = d.b(c0370bB14);
        y = c0370bB15;
        C0370b c0370bB16 = d.b(c0370bB15);
        z = c0370bB16;
        C0370b c0370bB17 = d.b(c0370bB16);
        A = c0370bB17;
        C0370b c0370bB18 = d.b(c0370bB17);
        B = c0370bB18;
        C0370b c0370bB19 = d.b(c0370bB18);
        C = c0370bB19;
        C0370b c0370bB20 = d.b(c0370bB19);
        D = c0370bB20;
        C0370b c0370bB21 = d.b(c0370bB20);
        E = c0370bB21;
        F = d.b(c0370bB21);
        C0370b c0370bB22 = d.b(c0370bC2);
        G = c0370bB22;
        C0370b c0370bB23 = d.b(c0370bB22);
        H = c0370bB23;
        I = d.b(c0370bB23);
        C0370b c0370bB24 = d.b(dVarA2);
        J = c0370bB24;
        C0370b c0370bB25 = d.b(c0370bB24);
        K = c0370bB25;
        L = d.b(c0370bB25);
        C0370b c0370bC3 = d.c();
        M = c0370bC3;
        N = d.b(c0370bC3);
        O = d.c();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0021  */
    /* JADX WARN: Code duplicated, block: B:18:0x002b  */
    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "modality";
        } else if (i2 == 2) {
            objArr[0] = "kind";
        } else if (i2 == 5) {
            objArr[0] = "modality";
        } else if (i2 == 6) {
            objArr[0] = "memberKind";
        } else if (i2 == 8) {
            objArr[0] = "modality";
        } else if (i2 == 9) {
            objArr[0] = "memberKind";
        } else if (i2 != 11) {
            objArr[0] = "visibility";
        } else {
            objArr[0] = "modality";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i2) {
            case 3:
                objArr[2] = "getConstructorFlags";
                break;
            case 4:
            case 5:
            case 6:
                objArr[2] = "getFunctionFlags";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "getPropertyFlags";
                break;
            case 10:
            case 11:
                objArr[2] = "getAccessorFlags";
                break;
            default:
                objArr[2] = "getClassFlags";
                break;
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static int b(boolean z2, x xVar, k kVar, boolean z3, boolean z4, boolean z5) {
        if (xVar == null) {
            a(10);
        }
        if (kVar == null) {
            a(11);
        }
        return f24183c.e(Boolean.valueOf(z2)) | f24185e.e(kVar) | f24184d.e(xVar) | J.e(Boolean.valueOf(z3)) | K.e(Boolean.valueOf(z4)) | L.e(Boolean.valueOf(z5));
    }
}
