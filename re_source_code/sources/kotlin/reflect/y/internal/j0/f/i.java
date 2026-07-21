package kotlin.reflect.y.internal.j0.f;

import io.sentry.protocol.DebugImage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.collections.x0;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;

/* JADX INFO: compiled from: StandardClassIds.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    private static final b A;
    private static final b B;
    private static final b C;
    private static final b D;
    private static final b E;
    private static final b F;
    private static final b G;
    private static final b H;
    private static final b I;
    private static final b J;
    private static final b K;
    private static final b L;
    private static final b M;
    private static final b N;
    private static final b O;
    private static final b P;
    private static final b Q;
    private static final b R;
    private static final b S;
    private static final b T;
    private static final b U;
    private static final Set<b> V;
    private static final Map<b, b> W;
    private static final Map<b, b> X;
    private static final Set<b> Y;
    private static final Map<b, b> Z;
    public static final i a = new i();
    private static final Map<b, b> a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f24226b;
    private static final Set<b> b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f24227c;
    private static final b c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final c f24228d;
    private static final b d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final c f24229e;
    private static final b e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c f24230f;
    private static final b f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c f24231g;
    private static final b g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final c f24232h;
    private static final b h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final c f24233i;
    private static final b i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final c f24234j;
    private static final b j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final c f24235k;
    private static final b k0;
    private static final Set<c> l;
    private static final b l0;
    private static final b m;
    private static final b m0;
    private static final b n;
    private static final b n0;
    private static final b o;
    private static final b o0;
    private static final b p;
    private static final b p0;
    private static final b q;
    private static final b q0;
    private static final b r;
    private static final b r0;
    private static final b s;
    private static final b s0;
    private static final b t;
    private static final b t0;
    private static final b u;
    private static final b u0;
    private static final b v;
    private static final b v0;
    private static final b w;
    private static final b w0;
    private static final b x;
    private static final b x0;
    private static final b y;
    private static final b y0;
    private static final b z;

    static {
        c cVar = new c("kotlin");
        f24226b = cVar;
        c cVarC = cVar.c(f.x("reflect"));
        m.e(cVarC, "BASE_KOTLIN_PACKAGE.chil…me.identifier(\"reflect\"))");
        f24227c = cVarC;
        c cVarC2 = cVar.c(f.x("collections"));
        m.e(cVarC2, "BASE_KOTLIN_PACKAGE.chil…dentifier(\"collections\"))");
        f24228d = cVarC2;
        c cVarC3 = cVar.c(f.x("ranges"));
        m.e(cVarC3, "BASE_KOTLIN_PACKAGE.chil…ame.identifier(\"ranges\"))");
        f24229e = cVarC3;
        c cVarC4 = cVar.c(f.x(DebugImage.JVM));
        m.e(cVarC4, "BASE_KOTLIN_PACKAGE.child(Name.identifier(\"jvm\"))");
        f24230f = cVarC4;
        c cVarC5 = cVarC4.c(f.x("internal"));
        m.e(cVarC5, "BASE_JVM_PACKAGE.child(N…e.identifier(\"internal\"))");
        f24231g = cVarC5;
        c cVarC6 = cVar.c(f.x("annotation"));
        m.e(cVarC6, "BASE_KOTLIN_PACKAGE.chil…identifier(\"annotation\"))");
        f24232h = cVarC6;
        c cVarC7 = cVar.c(f.x("internal"));
        m.e(cVarC7, "BASE_KOTLIN_PACKAGE.chil…e.identifier(\"internal\"))");
        f24233i = cVarC7;
        c cVarC8 = cVarC7.c(f.x("ir"));
        m.e(cVarC8, "BASE_INTERNAL_PACKAGE.child(Name.identifier(\"ir\"))");
        f24234j = cVarC8;
        c cVarC9 = cVar.c(f.x("coroutines"));
        m.e(cVarC9, "BASE_KOTLIN_PACKAGE.chil…identifier(\"coroutines\"))");
        f24235k = cVarC9;
        l = w0.i(cVar, cVarC2, cVarC3, cVarC6, cVarC, cVarC7, cVarC9);
        m = j.k("Nothing");
        n = j.k("Unit");
        o = j.k("Any");
        p = j.k("Enum");
        q = j.k("Annotation");
        r = j.k("Array");
        b bVarK = j.k("Boolean");
        s = bVarK;
        b bVarK2 = j.k("Char");
        t = bVarK2;
        b bVarK3 = j.k("Byte");
        u = bVarK3;
        b bVarK4 = j.k("Short");
        v = bVarK4;
        b bVarK5 = j.k("Int");
        w = bVarK5;
        b bVarK6 = j.k("Long");
        x = bVarK6;
        b bVarK7 = j.k("Float");
        y = bVarK7;
        b bVarK8 = j.k("Double");
        z = bVarK8;
        A = j.r(bVarK3);
        B = j.r(bVarK4);
        C = j.r(bVarK5);
        D = j.r(bVarK6);
        E = j.k("String");
        F = j.k("Throwable");
        G = j.k("Cloneable");
        H = j.q("KProperty");
        I = j.q("KMutableProperty");
        J = j.q("KProperty0");
        K = j.q("KMutableProperty0");
        L = j.q("KProperty1");
        M = j.q("KMutableProperty1");
        N = j.q("KProperty2");
        O = j.q("KMutableProperty2");
        P = j.q("KFunction");
        Q = j.q("KClass");
        R = j.q("KCallable");
        S = j.k("Comparable");
        T = j.k("Number");
        U = j.k("Function");
        Set<b> setI = w0.i(bVarK, bVarK2, bVarK3, bVarK4, bVarK5, bVarK6, bVarK7, bVarK8);
        V = setI;
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(setI, 10)), 16));
        for (Object obj : setI) {
            f fVarJ = ((b) obj).j();
            m.e(fVarJ, "id.shortClassName");
            linkedHashMap.put(obj, j.o(fVarJ));
        }
        W = linkedHashMap;
        X = j.n(linkedHashMap);
        Set<b> setI2 = w0.i(A, B, C, D);
        Y = setI2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(l.b(p0.e(v.u(setI2, 10)), 16));
        for (Object obj2 : setI2) {
            f fVarJ2 = ((b) obj2).j();
            m.e(fVarJ2, "id.shortClassName");
            linkedHashMap2.put(obj2, j.o(fVarJ2));
        }
        Z = linkedHashMap2;
        a0 = j.n(linkedHashMap2);
        b0 = x0.m(x0.l(V, Y), E);
        c0 = j.m("Continuation");
        d0 = j.l("Iterator");
        e0 = j.l("Iterable");
        f0 = j.l("Collection");
        g0 = j.l("List");
        h0 = j.l("ListIterator");
        i0 = j.l("Set");
        b bVarL = j.l("Map");
        j0 = bVarL;
        k0 = j.l("MutableIterator");
        l0 = j.l("MutableIterable");
        m0 = j.l("MutableCollection");
        n0 = j.l("MutableList");
        o0 = j.l("MutableListIterator");
        p0 = j.l("MutableSet");
        b bVarL2 = j.l("MutableMap");
        q0 = bVarL2;
        b bVarD = bVarL.d(f.x("Entry"));
        m.e(bVarD, "Map.createNestedClassId(Name.identifier(\"Entry\"))");
        r0 = bVarD;
        b bVarD2 = bVarL2.d(f.x("MutableEntry"));
        m.e(bVarD2, "MutableMap.createNestedC…entifier(\"MutableEntry\"))");
        s0 = bVarD2;
        t0 = j.k("Result");
        u0 = j.p("IntRange");
        v0 = j.p("LongRange");
        w0 = j.p("CharRange");
        x0 = j.j("AnnotationRetention");
        y0 = j.j("AnnotationTarget");
    }

    private i() {
    }

    public final b a() {
        return r;
    }

    public final c b() {
        return f24232h;
    }

    public final c c() {
        return f24228d;
    }

    public final c d() {
        return f24235k;
    }

    public final c e() {
        return f24226b;
    }

    public final c f() {
        return f24229e;
    }

    public final c g() {
        return f24227c;
    }

    public final b h() {
        return Q;
    }

    public final b i() {
        return P;
    }

    public final b j() {
        return n0;
    }

    public final b k() {
        return q0;
    }

    public final b l() {
        return p0;
    }
}
