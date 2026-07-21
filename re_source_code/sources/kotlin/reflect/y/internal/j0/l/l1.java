package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.l;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.l.t1.j;

/* JADX INFO: compiled from: TypeSubstitutor.java */
/* JADX INFO: loaded from: classes3.dex */
public class l1 {
    public static final l1 a = g(j1.f24750b);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j1 f24756b;

    /* JADX INFO: compiled from: TypeSubstitutor.java */
    static class a implements Function1<kotlin.reflect.y.internal.j0.f.c, Boolean> {
        a() {
        }

        private static /* synthetic */ void b(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(kotlin.reflect.y.internal.j0.f.c cVar) {
            if (cVar == null) {
                b(0);
            }
            return Boolean.valueOf(!cVar.equals(k.a.Q));
        }
    }

    /* JADX INFO: compiled from: TypeSubstitutor.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: TypeSubstitutor.java */
    private static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: TypeSubstitutor.java */
    private enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    protected l1(j1 j1Var) {
        if (j1Var == null) {
            a(7);
        }
        this.f24756b = j1Var;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0021 A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:24:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b8  */
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        if (i2 != 1 && i2 != 2 && i2 != 8 && i2 != 34 && i2 != 37) {
            switch (i2) {
                default:
                    switch (i2) {
                        default:
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            str = "@NotNull method %s.%s must not return null";
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    str = "@NotNull method %s.%s must not return null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i2 != 1 && i2 != 2 && i2 != 8 && i2 != 34 && i2 != 37) {
            switch (i2) {
                default:
                    switch (i2) {
                        default:
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            i3 = 3;
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    i3 = 2;
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            i3 = 2;
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    i3 = 2;
                    break;
            }
        } else {
            i3 = 2;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                break;
            case 3:
                objArr[0] = "first";
                break;
            case 4:
                objArr[0] = "second";
                break;
            case 5:
                objArr[0] = "substitutionContext";
                break;
            case 6:
                objArr[0] = "context";
                break;
            case 7:
            default:
                objArr[0] = "substitution";
                break;
            case 9:
            case 14:
                objArr[0] = "type";
                break;
            case 10:
            case 15:
                objArr[0] = "howThisTypeIsUsed";
                break;
            case 16:
            case 17:
            case 36:
                objArr[0] = "typeProjection";
                break;
            case 18:
            case 28:
                objArr[0] = "originalProjection";
                break;
            case 26:
                objArr[0] = "originalType";
                break;
            case 27:
                objArr[0] = "substituted";
                break;
            case 33:
                objArr[0] = "annotations";
                break;
            case 35:
            case 38:
                objArr[0] = "typeParameterVariance";
                break;
            case 39:
                objArr[0] = "projectionKind";
                break;
        }
        if (i2 == 1) {
            objArr[1] = "replaceWithNonApproximatingSubstitution";
        } else if (i2 == 2) {
            objArr[1] = "replaceWithContravariantApproximatingSubstitution";
        } else if (i2 == 8) {
            objArr[1] = "getSubstitution";
        } else if (i2 == 34) {
            objArr[1] = "filterOutUnsafeVariance";
        } else if (i2 != 37) {
            switch (i2) {
                case 11:
                case 12:
                case 13:
                    objArr[1] = "safeSubstitute";
                    break;
                default:
                    switch (i2) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            objArr[1] = "unsafeSubstitute";
                            break;
                        default:
                            switch (i2) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                    break;
                                default:
                                    switch (i2) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            objArr[1] = "combine";
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            objArr[1] = "combine";
        }
        switch (i2) {
            case 1:
            case 2:
            case 8:
            case 11:
            case 12:
            case 13:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case 30:
            case 31:
            case 32:
            case 34:
            case 37:
            case 40:
            case 41:
            case 42:
                break;
            case 3:
            case 4:
                objArr[2] = "createChainedSubstitutor";
                break;
            case 5:
            case 6:
            default:
                objArr[2] = "create";
                break;
            case 7:
                objArr[2] = "<init>";
                break;
            case 9:
            case 10:
                objArr[2] = "safeSubstitute";
                break;
            case 14:
            case 15:
            case 16:
                objArr[2] = "substitute";
                break;
            case 17:
                objArr[2] = "substituteWithoutApproximation";
                break;
            case 18:
                objArr[2] = "unsafeSubstitute";
                break;
            case 26:
            case 27:
            case 28:
                objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                break;
            case 33:
                objArr[2] = "filterOutUnsafeVariance";
                break;
            case 35:
            case 36:
            case 38:
            case 39:
                objArr[2] = "combine";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 1 && i2 != 2 && i2 != 8 && i2 != 34 && i2 != 37) {
            switch (i2) {
                case 11:
                case 12:
                case 13:
                    break;
                default:
                    switch (i2) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                        default:
                            switch (i2) {
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    break;
                                default:
                                    switch (i2) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            throw new IllegalArgumentException(str2);
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
        throw new IllegalStateException(str2);
    }

    private static void b(int i2, g1 g1Var, j1 j1Var) {
        if (i2 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(g1Var) + "; substitution: " + o(j1Var));
    }

    public static r1 c(r1 r1Var, g1 g1Var) {
        if (r1Var == null) {
            a(35);
        }
        if (g1Var == null) {
            a(36);
        }
        if (!g1Var.c()) {
            return d(r1Var, g1Var.a());
        }
        r1 r1Var2 = r1.OUT_VARIANCE;
        if (r1Var2 == null) {
            a(37);
        }
        return r1Var2;
    }

    public static r1 d(r1 r1Var, r1 r1Var2) {
        if (r1Var == null) {
            a(38);
        }
        if (r1Var2 == null) {
            a(39);
        }
        r1 r1Var3 = r1.INVARIANT;
        if (r1Var == r1Var3) {
            if (r1Var2 == null) {
                a(40);
            }
            return r1Var2;
        }
        if (r1Var2 == r1Var3) {
            if (r1Var == null) {
                a(41);
            }
            return r1Var;
        }
        if (r1Var == r1Var2) {
            if (r1Var2 == null) {
                a(42);
            }
            return r1Var2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + r1Var + "' and projection kind '" + r1Var2 + "' cannot be combined");
    }

    private static d e(r1 r1Var, r1 r1Var2) {
        r1 r1Var3 = r1.IN_VARIANCE;
        if (r1Var == r1Var3 && r1Var2 == r1.OUT_VARIANCE) {
            return d.OUT_IN_IN_POSITION;
        }
        return (r1Var == r1.OUT_VARIANCE && r1Var2 == r1Var3) ? d.IN_IN_OUT_POSITION : d.NO_CONFLICT;
    }

    public static l1 f(e0 e0Var) {
        if (e0Var == null) {
            a(6);
        }
        return g(f1.i(e0Var.O0(), e0Var.M0()));
    }

    public static l1 g(j1 j1Var) {
        if (j1Var == null) {
            a(0);
        }
        return new l1(j1Var);
    }

    public static l1 h(j1 j1Var, j1 j1Var2) {
        if (j1Var == null) {
            a(3);
        }
        if (j1Var2 == null) {
            a(4);
        }
        return g(u.i(j1Var, j1Var2));
    }

    private static g i(g gVar) {
        if (gVar == null) {
            a(33);
        }
        return !gVar.R0(k.a.Q) ? gVar : new l(gVar, new a());
    }

    private static g1 l(e0 e0Var, g1 g1Var, e1 e1Var, g1 g1Var2) {
        if (e0Var == null) {
            a(26);
        }
        if (g1Var == null) {
            a(27);
        }
        if (g1Var2 == null) {
            a(28);
        }
        if (!e0Var.getAnnotations().R0(k.a.Q)) {
            if (g1Var == null) {
                a(29);
            }
            return g1Var;
        }
        e1 e1VarO0 = g1Var.getType().O0();
        if (!(e1VarO0 instanceof j)) {
            return g1Var;
        }
        g1 g1VarF = ((j) e1VarO0).f();
        r1 r1VarA = g1VarF.a();
        d dVarE = e(g1Var2.a(), r1VarA);
        d dVar = d.OUT_IN_IN_POSITION;
        if (dVarE == dVar) {
            return new i1(g1VarF.getType());
        }
        return (e1Var != null && e(e1Var.n(), r1VarA) == dVar) ? new i1(g1VarF.getType()) : g1Var;
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (kotlin.p002reflect.jvm.internal.impl.utils.c.a(th)) {
                throw th;
            }
            return "[Exception while computing toString(): " + th + "]";
        }
    }

    private g1 r(g1 g1Var, int i2) throws c {
        e0 type = g1Var.getType();
        r1 r1VarA = g1Var.a();
        if (type.O0().c() instanceof e1) {
            return g1Var;
        }
        m0 m0VarB = q0.b(type);
        e0 e0VarP = m0VarB != null ? m().p(m0VarB, r1.INVARIANT) : null;
        e0 e0VarB = k1.b(type, s(type.O0().getParameters(), type.M0(), i2), this.f24756b.d(type.getAnnotations()));
        if ((e0VarB instanceof m0) && (e0VarP instanceof m0)) {
            e0VarB = q0.j((m0) e0VarB, (m0) e0VarP);
        }
        return new i1(r1VarA, e0VarB);
    }

    private List<g1> s(List<e1> list, List<g1> list2, int i2) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            e1 e1Var = list.get(i3);
            g1 g1Var = list2.get(i3);
            g1 g1VarU = u(g1Var, e1Var, i2 + 1);
            int i4 = b.a[e(e1Var.n(), g1VarU.a()).ordinal()];
            if (i4 == 1 || i4 == 2) {
                g1VarU = n1.s(e1Var);
            } else if (i4 == 3) {
                r1 r1VarN = e1Var.n();
                r1 r1Var = r1.INVARIANT;
                if (r1VarN != r1Var && !g1VarU.c()) {
                    g1VarU = new i1(r1Var, g1VarU.getType());
                }
            }
            if (g1VarU != g1Var) {
                z = true;
            }
            arrayList.add(g1VarU);
        }
        return !z ? list2 : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private g1 u(g1 g1Var, e1 e1Var, int i2) throws c {
        if (g1Var == null) {
            a(18);
        }
        b(i2, g1Var, this.f24756b);
        if (g1Var.c()) {
            return g1Var;
        }
        e0 type = g1Var.getType();
        if (type instanceof o1) {
            o1 o1Var = (o1) type;
            q1 q1VarV = o1Var.v();
            e0 e0VarH = o1Var.H();
            g1 g1VarU = u(new i1(g1Var.a(), q1VarV), e1Var, i2 + 1);
            return g1VarU.c() ? g1VarU : new i1(g1VarU.a(), p1.d(g1VarU.getType().R0(), p(e0VarH, g1Var.a())));
        }
        if (!w.a(type) && !(type.R0() instanceof l0)) {
            g1 g1VarE = this.f24756b.e(type);
            g1 g1VarL = g1VarE != null ? l(type, g1VarE, e1Var, g1Var) : null;
            r1 r1VarA = g1Var.a();
            if (g1VarL == null && b0.b(type) && !c1.b(type)) {
                y yVarA = b0.a(type);
                int i3 = i2 + 1;
                g1 g1VarU2 = u(new i1(r1VarA, yVarA.W0()), e1Var, i3);
                g1 g1VarU3 = u(new i1(r1VarA, yVarA.X0()), e1Var, i3);
                return (g1VarU2.getType() == yVarA.W0() && g1VarU3.getType() == yVarA.X0()) ? g1Var : new i1(g1VarU2.a(), f0.d(k1.a(g1VarU2.getType()), k1.a(g1VarU3.getType())));
            }
            if (!h.m0(type) && !g0.a(type)) {
                if (g1VarL != null) {
                    d dVarE = e(r1VarA, g1VarL.a());
                    if (!kotlin.reflect.y.internal.j0.i.q.a.d.d(type)) {
                        int i4 = b.a[dVarE.ordinal()];
                        if (i4 == 1) {
                            throw new c("Out-projection in in-position");
                        }
                        if (i4 == 2) {
                            return new i1(r1.OUT_VARIANCE, type.O0().o().I());
                        }
                    }
                    n nVarA = c1.a(type);
                    if (g1VarL.c()) {
                        return g1VarL;
                    }
                    e0 e0VarK = nVarA != null ? nVarA.K(g1VarL.getType()) : n1.q(g1VarL.getType(), type.P0());
                    if (!type.getAnnotations().isEmpty()) {
                        e0VarK = kotlin.reflect.y.internal.j0.l.x1.a.u(e0VarK, new kotlin.p002reflect.jvm.internal.impl.descriptors.n1.k(e0VarK.getAnnotations(), i(this.f24756b.d(type.getAnnotations()))));
                    }
                    if (dVarE == d.NO_CONFLICT) {
                        r1VarA = d(r1VarA, g1VarL.a());
                    }
                    return new i1(r1VarA, e0VarK);
                }
                g1Var = r(g1Var, i2);
                if (g1Var == null) {
                    a(25);
                }
            }
        }
        return g1Var;
    }

    public j1 j() {
        j1 j1Var = this.f24756b;
        if (j1Var == null) {
            a(8);
        }
        return j1Var;
    }

    public boolean k() {
        return this.f24756b.f();
    }

    public l1 m() {
        j1 j1Var = this.f24756b;
        return ((j1Var instanceof c0) && j1Var.b()) ? new l1(new c0(((c0) this.f24756b).j(), ((c0) this.f24756b).i(), false)) : this;
    }

    public e0 n(e0 e0Var, r1 r1Var) {
        if (e0Var == null) {
            a(9);
        }
        if (r1Var == null) {
            a(10);
        }
        if (k()) {
            if (e0Var == null) {
                a(11);
            }
            return e0Var;
        }
        try {
            e0 type = u(new i1(r1Var, e0Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e2) {
            kotlin.reflect.y.internal.j0.l.u1.h hVarD = kotlin.reflect.y.internal.j0.l.u1.k.d(kotlin.reflect.y.internal.j0.l.u1.j.G, e2.getMessage());
            if (hVarD == null) {
                a(13);
            }
            return hVarD;
        }
    }

    public e0 p(e0 e0Var, r1 r1Var) {
        if (e0Var == null) {
            a(14);
        }
        if (r1Var == null) {
            a(15);
        }
        g1 g1VarQ = q(new i1(r1Var, j().g(e0Var, r1Var)));
        if (g1VarQ == null) {
            return null;
        }
        return g1VarQ.getType();
    }

    public g1 q(g1 g1Var) {
        if (g1Var == null) {
            a(16);
        }
        g1 g1VarT = t(g1Var);
        return (this.f24756b.a() || this.f24756b.b()) ? kotlin.reflect.y.internal.j0.l.y1.b.c(g1VarT, this.f24756b.b()) : g1VarT;
    }

    public g1 t(g1 g1Var) {
        if (g1Var == null) {
            a(17);
        }
        if (k()) {
            return g1Var;
        }
        try {
            return u(g1Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }
}
