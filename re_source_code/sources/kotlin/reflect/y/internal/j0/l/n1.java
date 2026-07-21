package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.utils.f;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.t1.n;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: TypeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class n1 {
    public static final m0 a = k.d(j.H, new String[0]);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m0 f24766b = k.d(j.A, new String[0]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m0 f24767c = new a("NO_EXPECTED_TYPE");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m0 f24768d = new a("UNIT_EXPECTED_TYPE");

    /* JADX INFO: compiled from: TypeUtils.java */
    public static class a extends r {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f24769g;

        public a(String str) {
            this.f24769g = str;
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0030  */
        private static /* synthetic */ void a1(int i2) {
            String str = (i2 == 1 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 4) ? 2 : 3];
            if (i2 == 1) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else if (i2 == 2) {
                objArr[0] = "delegate";
            } else if (i2 == 3) {
                objArr[0] = "kotlinTypeRefiner";
            } else if (i2 != 4) {
                objArr[0] = "newAttributes";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            }
            if (i2 == 1) {
                objArr[1] = "toString";
            } else if (i2 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            } else {
                objArr[1] = "refine";
            }
            if (i2 != 1) {
                if (i2 == 2) {
                    objArr[2] = "replaceDelegate";
                } else if (i2 == 3) {
                    objArr[2] = "refine";
                } else if (i2 != 4) {
                    objArr[2] = "replaceAttributes";
                }
            }
            String str2 = String.format(str, objArr);
            if (i2 != 1 && i2 != 4) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // kotlin.reflect.y.internal.j0.l.q1
        /* JADX INFO: renamed from: V0, reason: merged with bridge method [inline-methods] */
        public m0 S0(boolean z) {
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.q1
        /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
        public m0 U0(a1 a1Var) {
            if (a1Var == null) {
                a1(0);
            }
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.r
        protected m0 X0() {
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.r
        public r Z0(m0 m0Var) {
            if (m0Var == null) {
                a1(2);
            }
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.r
        /* JADX INFO: renamed from: b1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a Y0(g gVar) {
            if (gVar == null) {
                a1(3);
            }
            return this;
        }

        @Override // kotlin.reflect.y.internal.j0.l.m0
        public String toString() {
            String str = this.f24769g;
            if (str == null) {
                a1(1);
            }
            return str;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Code duplicated, block: B:33:0x0055  */
    /* JADX WARN: Code duplicated, block: B:75:0x0105  */
    /* JADX WARN: Code duplicated, block: B:82:0x0120  */
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        if (i2 != 4 && i2 != 9 && i2 != 11 && i2 != 15 && i2 != 17 && i2 != 19 && i2 != 26 && i2 != 35 && i2 != 47 && i2 != 52 && i2 != 6 && i2 != 7) {
            switch (i2) {
                case 55:
                case 56:
                case 57:
                case 58:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
        } else {
            str = "@NotNull method %s.%s must not return null";
        }
        if (i2 != 4 && i2 != 9 && i2 != 11 && i2 != 15 && i2 != 17 && i2 != 19 && i2 != 26 && i2 != 35 && i2 != 47 && i2 != 52 && i2 != 6 && i2 != 7) {
            switch (i2) {
                case 55:
                case 56:
                case 57:
                case 58:
                    i3 = 2;
                    break;
                default:
                    i3 = 3;
                    break;
            }
        } else {
            i3 = 2;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case 57:
            case 58:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                break;
            case 5:
            case 8:
            case 10:
            case 18:
            case 23:
            case 25:
            case 27:
            case 28:
            case 29:
            case 30:
            case 38:
            case 40:
            default:
                objArr[0] = "type";
                break;
            case 12:
                objArr[0] = "typeConstructor";
                break;
            case 13:
                objArr[0] = "unsubstitutedMemberScope";
                break;
            case 14:
                objArr[0] = "refinedTypeFactory";
                break;
            case 16:
                objArr[0] = "parameters";
                break;
            case 20:
                objArr[0] = "subType";
                break;
            case 21:
                objArr[0] = "superType";
                break;
            case 22:
                objArr[0] = "substitutor";
                break;
            case 24:
                objArr[0] = "result";
                break;
            case 31:
            case 33:
                objArr[0] = "clazz";
                break;
            case 32:
                objArr[0] = "typeArguments";
                break;
            case 34:
                objArr[0] = "projections";
                break;
            case 36:
                objArr[0] = "a";
                break;
            case 37:
                objArr[0] = "b";
                break;
            case 39:
                objArr[0] = "typeParameters";
                break;
            case 41:
                objArr[0] = "typeParameterConstructors";
                break;
            case 42:
                objArr[0] = "specialType";
                break;
            case 43:
            case 44:
                objArr[0] = "isSpecialType";
                break;
            case 45:
                objArr[0] = "parameterDescriptor";
                break;
            case 46:
            case 50:
                objArr[0] = "numberValueTypeConstructor";
                break;
            case 48:
            case 49:
                objArr[0] = "supertypes";
                break;
            case 51:
            case 54:
                objArr[0] = "expectedType";
                break;
            case 53:
                objArr[0] = "literalTypeConstructor";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "makeNullableAsSpecified";
        } else if (i2 == 9) {
            objArr[1] = "makeNullableIfNeeded";
        } else if (i2 == 11 || i2 == 15) {
            objArr[1] = "makeUnsubstitutedType";
        } else if (i2 == 17) {
            objArr[1] = "getDefaultTypeProjections";
        } else if (i2 == 19) {
            objArr[1] = "getImmediateSupertypes";
        } else if (i2 == 26) {
            objArr[1] = "getAllSupertypes";
        } else if (i2 == 35) {
            objArr[1] = "substituteProjectionsForParameters";
        } else if (i2 == 47) {
            objArr[1] = "getDefaultPrimitiveNumberType";
        } else if (i2 != 52) {
            if (i2 != 6 && i2 != 7) {
                switch (i2) {
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        objArr[1] = "getPrimitiveNumberType";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                }
            } else {
                objArr[1] = "makeNullableIfNeeded";
            }
        } else {
            objArr[1] = "getPrimitiveNumberType";
        }
        switch (i2) {
            case 1:
                objArr[2] = "makeNullable";
                break;
            case 2:
                objArr[2] = "makeNotNullable";
                break;
            case 3:
                objArr[2] = "makeNullableAsSpecified";
                break;
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
            case 15:
            case 17:
            case 19:
            case 26:
            case 35:
            case 47:
            case 52:
            case 55:
            case 56:
            case 57:
            case 58:
                break;
            case 5:
            case 8:
                objArr[2] = "makeNullableIfNeeded";
                break;
            case 10:
                objArr[2] = "canHaveSubtypes";
                break;
            case 12:
            case 13:
            case 14:
                objArr[2] = "makeUnsubstitutedType";
                break;
            case 16:
                objArr[2] = "getDefaultTypeProjections";
                break;
            case 18:
                objArr[2] = "getImmediateSupertypes";
                break;
            case 20:
            case 21:
            case 22:
                objArr[2] = "createSubstitutedSupertype";
                break;
            case 23:
            case 24:
                objArr[2] = "collectAllSupertypes";
                break;
            case 25:
                objArr[2] = "getAllSupertypes";
                break;
            case 27:
                objArr[2] = "isNullableType";
                break;
            case 28:
                objArr[2] = "acceptsNullable";
                break;
            case 29:
                objArr[2] = "hasNullableSuperType";
                break;
            case 30:
                objArr[2] = "getClassDescriptor";
                break;
            case 31:
            case 32:
                objArr[2] = "substituteParameters";
                break;
            case 33:
            case 34:
                objArr[2] = "substituteProjectionsForParameters";
                break;
            case 36:
            case 37:
                objArr[2] = "equalTypes";
                break;
            case 38:
            case 39:
                objArr[2] = "dependsOnTypeParameters";
                break;
            case 40:
            case 41:
                objArr[2] = "dependsOnTypeConstructors";
                break;
            case 42:
            case 43:
            case 44:
                objArr[2] = "contains";
                break;
            case 45:
                objArr[2] = "makeStarProjection";
                break;
            case 46:
            case 48:
                objArr[2] = "getDefaultPrimitiveNumberType";
                break;
            case 49:
                objArr[2] = "findByFqName";
                break;
            case 50:
            case 51:
            case 53:
            case 54:
                objArr[2] = "getPrimitiveNumberType";
                break;
            case 59:
                objArr[2] = "isTypeParameter";
                break;
            case 60:
                objArr[2] = "isReifiedTypeParameter";
                break;
            case 61:
                objArr[2] = "isNonReifiedTypeParameter";
                break;
            case 62:
                objArr[2] = "getTypeParameterDescriptorOrNull";
                break;
            default:
                objArr[2] = "noExpectedType";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 4 && i2 != 9 && i2 != 11 && i2 != 15 && i2 != 17 && i2 != 19 && i2 != 26 && i2 != 35 && i2 != 47 && i2 != 52 && i2 != 6 && i2 != 7) {
            switch (i2) {
                case 55:
                case 56:
                case 57:
                case 58:
                    break;
                default:
                    throw new IllegalArgumentException(str2);
            }
        }
        throw new IllegalStateException(str2);
    }

    public static boolean b(e0 e0Var) {
        if (e0Var == null) {
            a(28);
        }
        if (e0Var.P0()) {
            return true;
        }
        return b0.b(e0Var) && b(b0.a(e0Var).X0());
    }

    public static boolean c(e0 e0Var, Function1<q1, Boolean> function1) {
        if (function1 == null) {
            a(43);
        }
        return d(e0Var, function1, null);
    }

    private static boolean d(e0 e0Var, Function1<q1, Boolean> function1, f<e0> fVar) {
        if (function1 == null) {
            a(44);
        }
        if (e0Var == null) {
            return false;
        }
        q1 q1VarR0 = e0Var.R0();
        if (v(e0Var)) {
            return function1.invoke(q1VarR0).booleanValue();
        }
        if (fVar != null && fVar.contains(e0Var)) {
            return false;
        }
        if (function1.invoke(q1VarR0).booleanValue()) {
            return true;
        }
        if (fVar == null) {
            fVar = f.c();
        }
        fVar.add(e0Var);
        y yVar = q1VarR0 instanceof y ? (y) q1VarR0 : null;
        if (yVar != null && (d(yVar.W0(), function1, fVar) || d(yVar.X0(), function1, fVar))) {
            return true;
        }
        if ((q1VarR0 instanceof p) && d(((p) q1VarR0).a1(), function1, fVar)) {
            return true;
        }
        e1 e1VarO0 = e0Var.O0();
        if (e1VarO0 instanceof d0) {
            Iterator<e0> it = ((d0) e1VarO0).a().iterator();
            while (it.hasNext()) {
                if (d(it.next(), function1, fVar)) {
                    return true;
                }
            }
            return false;
        }
        for (g1 g1Var : e0Var.M0()) {
            if (!g1Var.c()) {
                if (d(g1Var.getType(), function1, fVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static e0 e(e0 e0Var, e0 e0Var2, l1 l1Var) {
        if (e0Var == null) {
            a(20);
        }
        if (e0Var2 == null) {
            a(21);
        }
        if (l1Var == null) {
            a(22);
        }
        e0 e0VarP = l1Var.p(e0Var2, r1.INVARIANT);
        if (e0VarP != null) {
            return q(e0VarP, e0Var.P0());
        }
        return null;
    }

    public static e f(e0 e0Var) {
        if (e0Var == null) {
            a(30);
        }
        h hVarC = e0Var.O0().w();
        if (hVarC instanceof e) {
            return (e) hVarC;
        }
        return null;
    }

    public static List<g1> g(List<e1> list) {
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<e1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new i1(it.next().s()));
        }
        List<g1> listE0 = c0.E0(arrayList);
        if (listE0 == null) {
            a(17);
        }
        return listE0;
    }

    public static List<e0> h(e0 e0Var) {
        if (e0Var == null) {
            a(18);
        }
        l1 l1VarF = l1.f(e0Var);
        Collection<e0> collectionA = e0Var.O0().a();
        ArrayList arrayList = new ArrayList(collectionA.size());
        Iterator<e0> it = collectionA.iterator();
        while (it.hasNext()) {
            e0 e0VarE = e(e0Var, it.next(), l1VarF);
            if (e0VarE != null) {
                arrayList.add(e0VarE);
            }
        }
        return arrayList;
    }

    public static e1 i(e0 e0Var) {
        if (e0Var == null) {
            a(62);
        }
        if (e0Var.O0().w() instanceof e1) {
            return (e1) e0Var.O0().w();
        }
        return null;
    }

    public static boolean j(e0 e0Var) {
        if (e0Var == null) {
            a(29);
        }
        if (e0Var.O0().w() instanceof e) {
            return false;
        }
        Iterator<e0> it = h(e0Var).iterator();
        while (it.hasNext()) {
            if (l(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(e0 e0Var) {
        return e0Var != null && e0Var.O0() == a.O0();
    }

    public static boolean l(e0 e0Var) {
        if (e0Var == null) {
            a(27);
        }
        if (e0Var.P0()) {
            return true;
        }
        if (b0.b(e0Var) && l(b0.a(e0Var).X0())) {
            return true;
        }
        if (q0.c(e0Var)) {
            return false;
        }
        if (m(e0Var)) {
            return j(e0Var);
        }
        if (e0Var instanceof e) {
            e1 e1VarD = ((e) e0Var).X0().d();
            return e1VarD == null || j(e1VarD.s());
        }
        e1 e1VarO0 = e0Var.O0();
        if (e1VarO0 instanceof d0) {
            Iterator<e0> it = e1VarO0.a().iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(e0 e0Var) {
        if (e0Var == null) {
            a(59);
        }
        return i(e0Var) != null || (e0Var.O0() instanceof n);
    }

    public static e0 n(e0 e0Var) {
        if (e0Var == null) {
            a(2);
        }
        return p(e0Var, false);
    }

    public static e0 o(e0 e0Var) {
        if (e0Var == null) {
            a(1);
        }
        return p(e0Var, true);
    }

    public static e0 p(e0 e0Var, boolean z) {
        if (e0Var == null) {
            a(3);
        }
        q1 q1VarS0 = e0Var.R0().S0(z);
        if (q1VarS0 == null) {
            a(4);
        }
        return q1VarS0;
    }

    public static e0 q(e0 e0Var, boolean z) {
        if (e0Var == null) {
            a(8);
        }
        if (z) {
            return o(e0Var);
        }
        if (e0Var == null) {
            a(9);
        }
        return e0Var;
    }

    public static m0 r(m0 m0Var, boolean z) {
        if (m0Var == null) {
            a(5);
        }
        if (!z) {
            if (m0Var == null) {
                a(7);
            }
            return m0Var;
        }
        m0 m0VarS0 = m0Var.S0(true);
        if (m0VarS0 == null) {
            a(6);
        }
        return m0VarS0;
    }

    public static g1 s(e1 e1Var) {
        if (e1Var == null) {
            a(45);
        }
        return new s0(e1Var);
    }

    public static m0 t(h hVar, kotlin.reflect.y.internal.j0.i.w.h hVar2, Function1<g, m0> function1) {
        if (!k.m(hVar)) {
            return u(hVar.h(), hVar2, function1);
        }
        kotlin.reflect.y.internal.j0.l.u1.h hVarD = k.d(j.G, hVar.toString());
        if (hVarD == null) {
            a(11);
        }
        return hVarD;
    }

    public static m0 u(e1 e1Var, kotlin.reflect.y.internal.j0.i.w.h hVar, Function1<g, m0> function1) {
        if (e1Var == null) {
            a(12);
        }
        if (hVar == null) {
            a(13);
        }
        if (function1 == null) {
            a(14);
        }
        m0 m0VarK = f0.k(a1.f24676g.h(), e1Var, g(e1Var.getParameters()), false, hVar, function1);
        if (m0VarK == null) {
            a(15);
        }
        return m0VarK;
    }

    public static boolean v(e0 e0Var) {
        if (e0Var == null) {
            a(0);
        }
        return e0Var == f24767c || e0Var == f24768d;
    }
}
