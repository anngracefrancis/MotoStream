package kotlin.reflect.y.internal.j0.i;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.q;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.v0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.y.internal.j0.b.o;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: DescriptorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final c a = new c("kotlin.jvm.JvmName");

    public static boolean A(m mVar) {
        return D(mVar, f.ENUM_CLASS);
    }

    public static boolean B(m mVar) {
        if (mVar == null) {
            a(36);
        }
        return D(mVar, f.ENUM_ENTRY);
    }

    public static boolean C(m mVar) {
        return D(mVar, f.INTERFACE);
    }

    private static boolean D(m mVar, f fVar) {
        if (fVar == null) {
            a(37);
        }
        return (mVar instanceof e) && ((e) mVar).i() == fVar;
    }

    public static boolean E(m mVar) {
        if (mVar == null) {
            a(1);
        }
        while (mVar != null) {
            if (u(mVar) || y(mVar)) {
                return true;
            }
            mVar = mVar.b();
        }
        return false;
    }

    private static boolean F(e0 e0Var, m mVar) {
        if (e0Var == null) {
            a(30);
        }
        if (mVar == null) {
            a(31);
        }
        h hVarC = e0Var.O0().c();
        if (hVarC == null) {
            return false;
        }
        m mVarA = hVarC.a();
        return (mVarA instanceof h) && (mVar instanceof h) && ((h) mVar).h().equals(((h) mVarA).h());
    }

    public static boolean G(m mVar) {
        return (D(mVar, f.CLASS) || D(mVar, f.INTERFACE)) && ((e) mVar).j() == d0.SEALED;
    }

    public static boolean H(e eVar, e eVar2) {
        if (eVar == null) {
            a(28);
        }
        if (eVar2 == null) {
            a(29);
        }
        return I(eVar.s(), eVar2.a());
    }

    public static boolean I(e0 e0Var, m mVar) {
        if (e0Var == null) {
            a(32);
        }
        if (mVar == null) {
            a(33);
        }
        if (F(e0Var, mVar)) {
            return true;
        }
        Iterator<e0> it = e0Var.O0().a().iterator();
        while (it.hasNext()) {
            if (I(it.next(), mVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(m mVar) {
        return mVar != null && (mVar.b() instanceof k0);
    }

    public static boolean K(j1 j1Var, e0 e0Var) {
        if (j1Var == null) {
            a(63);
        }
        if (e0Var == null) {
            a(64);
        }
        if (j1Var.j0() || g0.a(e0Var)) {
            return false;
        }
        if (n1.b(e0Var)) {
            return true;
        }
        kotlin.reflect.y.internal.j0.b.h hVarF = a.f(j1Var);
        if (!kotlin.reflect.y.internal.j0.b.h.r0(e0Var)) {
            kotlin.reflect.y.internal.j0.l.t1.e eVar = kotlin.reflect.y.internal.j0.l.t1.e.a;
            if (!eVar.b(hVarF.W(), e0Var) && !eVar.b(hVarF.K().s(), e0Var) && !eVar.b(hVarF.i(), e0Var)) {
                o oVar = o.a;
                if (!o.d(e0Var)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static <D extends b> D L(D d2) {
        if (d2 == null) {
            a(59);
        }
        while (d2.i() == b.a.FAKE_OVERRIDE) {
            Collection<? extends b> collectionE = d2.e();
            if (collectionE.isEmpty()) {
                throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + d2);
            }
            d2 = (D) collectionE.iterator().next();
        }
        return d2;
    }

    public static <D extends q> D M(D d2) {
        if (d2 == null) {
            a(61);
        }
        if (d2 instanceof b) {
            return L((b) d2);
        }
        if (d2 == null) {
            a(62);
        }
        return d2;
    }

    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
            case 13:
            case 14:
            case 15:
            case 21:
            case 23:
            case 24:
            case 34:
            case 35:
            case 36:
            case 57:
            case 58:
            case 59:
            case 61:
            case 79:
            case 92:
            case 94:
                objArr[0] = "descriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
            case 16:
                objArr[0] = "first";
                break;
            case 17:
                objArr[0] = "second";
                break;
            case 18:
            case 19:
                objArr[0] = "aClass";
                break;
            case 20:
                objArr[0] = "kotlinType";
                break;
            case 25:
                objArr[0] = "declarationDescriptor";
                break;
            case 26:
            case 28:
                objArr[0] = "subClass";
                break;
            case 27:
            case 29:
            case 33:
                objArr[0] = "superClass";
                break;
            case 30:
            case 32:
            case 45:
            case 64:
                objArr[0] = "type";
                break;
            case 31:
                objArr[0] = "other";
                break;
            case 37:
                objArr[0] = "classKind";
                break;
            case 38:
            case 39:
            case 41:
            case 44:
            case 48:
            case 54:
            case 65:
            case 66:
            case 67:
            case 74:
            case 75:
                objArr[0] = "classDescriptor";
                break;
            case 46:
                objArr[0] = "typeConstructor";
                break;
            case 55:
                objArr[0] = "innerClassName";
                break;
            case 56:
                objArr[0] = "location";
                break;
            case 63:
                objArr[0] = "variable";
                break;
            case 68:
                objArr[0] = "f";
                break;
            case 70:
                objArr[0] = "current";
                break;
            case 71:
                objArr[0] = "result";
                break;
            case 72:
                objArr[0] = "memberDescriptor";
                break;
            case 76:
            case 77:
            case 78:
                objArr[0] = "annotated";
                break;
            case 82:
            case 84:
            case 87:
            case 89:
                objArr[0] = "scope";
                break;
            case 85:
            case 88:
            case 90:
                objArr[0] = "name";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getFqNameSafe";
                break;
            case 7:
                objArr[1] = "getFqNameUnsafe";
                break;
            case 9:
            case 10:
                objArr[1] = "getFqNameFromTopLevelClass";
                break;
            case 12:
                objArr[1] = "getClassIdForNonLocalClass";
                break;
            case 22:
                objArr[1] = "getContainingModule";
                break;
            case 40:
                objArr[1] = "getSuperclassDescriptors";
                break;
            case 42:
            case 43:
                objArr[1] = "getSuperClassType";
                break;
            case 47:
                objArr[1] = "getClassDescriptorForTypeConstructor";
                break;
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                objArr[1] = "getDefaultConstructorVisibility";
                break;
            case 60:
                objArr[1] = "unwrapFakeOverride";
                break;
            case 62:
                objArr[1] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 69:
                objArr[1] = "getAllOverriddenDescriptors";
                break;
            case 73:
                objArr[1] = "getAllOverriddenDeclarations";
                break;
            case 80:
            case 81:
                objArr[1] = "getContainingSourceFile";
                break;
            case 83:
                objArr[1] = "getAllDescriptors";
                break;
            case 86:
                objArr[1] = "getFunctionByName";
                break;
            case 91:
                objArr[1] = "getPropertyByName";
                break;
            case 93:
                objArr[1] = "getDirectMember";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
                break;
        }
        switch (i2) {
            case 1:
                objArr[2] = "isLocal";
                break;
            case 2:
                objArr[2] = "getFqName";
                break;
            case 3:
                objArr[2] = "getFqNameSafe";
                break;
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                break;
            case 5:
                objArr[2] = "getFqNameSafeIfPossible";
                break;
            case 6:
                objArr[2] = "getFqNameUnsafe";
                break;
            case 8:
                objArr[2] = "getFqNameFromTopLevelClass";
                break;
            case 11:
                objArr[2] = "getClassIdForNonLocalClass";
                break;
            case 13:
                objArr[2] = "isExtension";
                break;
            case 14:
                objArr[2] = "isOverride";
                break;
            case 15:
                objArr[2] = "isStaticDeclaration";
                break;
            case 16:
            case 17:
                objArr[2] = "areInSameModule";
                break;
            case 18:
            case 19:
                objArr[2] = "getParentOfType";
                break;
            case 20:
            case 23:
                objArr[2] = "getContainingModuleOrNull";
                break;
            case 21:
                objArr[2] = "getContainingModule";
                break;
            case 24:
                objArr[2] = "getContainingClass";
                break;
            case 25:
                objArr[2] = "isAncestor";
                break;
            case 26:
            case 27:
                objArr[2] = "isDirectSubclass";
                break;
            case 28:
            case 29:
                objArr[2] = "isSubclass";
                break;
            case 30:
            case 31:
                objArr[2] = "isSameClass";
                break;
            case 32:
            case 33:
                objArr[2] = "isSubtypeOfClass";
                break;
            case 34:
                objArr[2] = "isAnonymousObject";
                break;
            case 35:
                objArr[2] = "isAnonymousFunction";
                break;
            case 36:
                objArr[2] = "isEnumEntry";
                break;
            case 37:
                objArr[2] = "isKindOf";
                break;
            case 38:
                objArr[2] = "hasAbstractMembers";
                break;
            case 39:
                objArr[2] = "getSuperclassDescriptors";
                break;
            case 41:
                objArr[2] = "getSuperClassType";
                break;
            case 44:
                objArr[2] = "getSuperClassDescriptor";
                break;
            case 45:
                objArr[2] = "getClassDescriptorForType";
                break;
            case 46:
                objArr[2] = "getClassDescriptorForTypeConstructor";
                break;
            case 48:
                objArr[2] = "getDefaultConstructorVisibility";
                break;
            case 54:
            case 55:
            case 56:
                objArr[2] = "getInnerClassByName";
                break;
            case 57:
                objArr[2] = "isStaticNestedClass";
                break;
            case 58:
                objArr[2] = "isTopLevelOrInnerClass";
                break;
            case 59:
                objArr[2] = "unwrapFakeOverride";
                break;
            case 61:
                objArr[2] = "unwrapFakeOverrideToAnyDeclaration";
                break;
            case 63:
            case 64:
                objArr[2] = "shouldRecordInitializerForProperty";
                break;
            case 65:
                objArr[2] = "classCanHaveAbstractFakeOverride";
                break;
            case 66:
                objArr[2] = "classCanHaveAbstractDeclaration";
                break;
            case 67:
                objArr[2] = "classCanHaveOpenMembers";
                break;
            case 68:
                objArr[2] = "getAllOverriddenDescriptors";
                break;
            case 70:
            case 71:
                objArr[2] = "collectAllOverriddenDescriptors";
                break;
            case 72:
                objArr[2] = "getAllOverriddenDeclarations";
                break;
            case 74:
                objArr[2] = "isSingletonOrAnonymousObject";
                break;
            case 75:
                objArr[2] = "canHaveDeclaredConstructors";
                break;
            case 76:
                objArr[2] = "getJvmName";
                break;
            case 77:
                objArr[2] = "findJvmNameAnnotation";
                break;
            case 78:
                objArr[2] = "hasJvmNameAnnotation";
                break;
            case 79:
                objArr[2] = "getContainingSourceFile";
                break;
            case 82:
                objArr[2] = "getAllDescriptors";
                break;
            case 84:
            case 85:
                objArr[2] = "getFunctionByName";
                break;
            case 87:
            case 88:
                objArr[2] = "getFunctionByNameOrNull";
                break;
            case 89:
            case 90:
                objArr[2] = "getPropertyByName";
                break;
            case 92:
                objArr[2] = "getDirectMember";
                break;
            case 94:
                objArr[2] = "isMethodOfAny";
                break;
            default:
                objArr[2] = "getDispatchReceiverParameterIfNeeded";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 7:
            case 9:
            case 10:
            case 12:
            case 22:
            case 40:
            case 42:
            case 43:
            case 47:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 60:
            case 62:
            case 69:
            case 73:
            case 80:
            case 81:
            case 83:
            case 86:
            case 91:
            case 93:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static boolean b(m mVar, m mVar2) {
        if (mVar == null) {
            a(16);
        }
        if (mVar2 == null) {
            a(17);
        }
        return g(mVar).equals(g(mVar2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends kotlin.p002reflect.jvm.internal.impl.descriptors.a> void c(D d2, Set<D> set) {
        if (d2 == null) {
            a(70);
        }
        if (set == 0) {
            a(71);
        }
        if (set.contains(d2)) {
            return;
        }
        Iterator<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.a> it = d2.a().e().iterator();
        while (it.hasNext()) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.a aVarA = it.next().a();
            c(aVarA, set);
            set.add(aVarA);
        }
    }

    public static <D extends kotlin.p002reflect.jvm.internal.impl.descriptors.a> Set<D> d(D d2) {
        if (d2 == null) {
            a(68);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        c(d2.a(), linkedHashSet);
        return linkedHashSet;
    }

    public static e e(e0 e0Var) {
        if (e0Var == null) {
            a(45);
        }
        return f(e0Var.O0());
    }

    public static e f(e1 e1Var) {
        if (e1Var == null) {
            a(46);
        }
        e eVar = (e) e1Var.c();
        if (eVar == null) {
            a(47);
        }
        return eVar;
    }

    public static kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g(m mVar) {
        if (mVar == null) {
            a(21);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0VarH = h(mVar);
        if (g0VarH == null) {
            a(22);
        }
        return g0VarH;
    }

    public static kotlin.p002reflect.jvm.internal.impl.descriptors.g0 h(m mVar) {
        if (mVar == null) {
            a(23);
        }
        while (mVar != null) {
            if (mVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.g0) {
                return (kotlin.p002reflect.jvm.internal.impl.descriptors.g0) mVar;
            }
            if (mVar instanceof p0) {
                return ((p0) mVar).v0();
            }
            mVar = mVar.b();
        }
        return null;
    }

    public static kotlin.p002reflect.jvm.internal.impl.descriptors.g0 i(e0 e0Var) {
        if (e0Var == null) {
            a(20);
        }
        h hVarC = e0Var.O0().c();
        if (hVarC == null) {
            return null;
        }
        return h(hVarC);
    }

    public static a1 j(m mVar) {
        if (mVar == null) {
            a(79);
        }
        if (mVar instanceof v0) {
            mVar = ((v0) mVar).B0();
        }
        if (mVar instanceof p) {
            a1 a1VarA = ((p) mVar).t().a();
            if (a1VarA == null) {
                a(80);
            }
            return a1VarA;
        }
        a1 a1Var = a1.a;
        if (a1Var == null) {
            a(81);
        }
        return a1Var;
    }

    public static u k(e eVar, boolean z) {
        if (eVar == null) {
            a(48);
        }
        f fVarI = eVar.i();
        if (fVarI == f.ENUM_CLASS || fVarI.k()) {
            u uVar = t.a;
            if (uVar == null) {
                a(49);
            }
            return uVar;
        }
        if (G(eVar)) {
            if (z) {
                u uVar2 = t.f25366c;
                if (uVar2 == null) {
                    a(50);
                }
                return uVar2;
            }
            u uVar3 = t.a;
            if (uVar3 == null) {
                a(51);
            }
            return uVar3;
        }
        if (u(eVar)) {
            u uVar4 = t.l;
            if (uVar4 == null) {
                a(52);
            }
            return uVar4;
        }
        u uVar5 = t.f25368e;
        if (uVar5 == null) {
            a(53);
        }
        return uVar5;
    }

    public static w0 l(m mVar) {
        if (mVar == null) {
            a(0);
        }
        if (mVar instanceof e) {
            return ((e) mVar).K0();
        }
        return null;
    }

    public static kotlin.reflect.y.internal.j0.f.d m(m mVar) {
        if (mVar == null) {
            a(2);
        }
        c cVarO = o(mVar);
        return cVarO != null ? cVarO.j() : p(mVar);
    }

    public static c n(m mVar) {
        if (mVar == null) {
            a(3);
        }
        c cVarO = o(mVar);
        if (cVarO == null) {
            cVarO = p(mVar).l();
        }
        if (cVarO == null) {
            a(4);
        }
        return cVarO;
    }

    private static c o(m mVar) {
        if (mVar == null) {
            a(5);
        }
        if ((mVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.g0) || k.m(mVar)) {
            return c.a;
        }
        if (mVar instanceof p0) {
            return ((p0) mVar).d();
        }
        if (mVar instanceof k0) {
            return ((k0) mVar).d();
        }
        return null;
    }

    private static kotlin.reflect.y.internal.j0.f.d p(m mVar) {
        if (mVar == null) {
            a(6);
        }
        kotlin.reflect.y.internal.j0.f.d dVarC = m(mVar.b()).c(mVar.getName());
        if (dVarC == null) {
            a(7);
        }
        return dVarC;
    }

    public static <D extends m> D q(m mVar, Class<D> cls) {
        if (cls == null) {
            a(18);
        }
        return (D) r(mVar, cls, true);
    }

    public static <D extends m> D r(m mVar, Class<D> cls, boolean z) {
        if (cls == null) {
            a(19);
        }
        if (mVar == null) {
            return null;
        }
        if (z) {
            mVar = (D) mVar.b();
        }
        while (mVar != null) {
            if (cls.isInstance(mVar)) {
                return (D) mVar;
            }
            mVar = (D) mVar.b();
        }
        return null;
    }

    public static e s(e eVar) {
        if (eVar == null) {
            a(44);
        }
        Iterator<e0> it = eVar.h().a().iterator();
        while (it.hasNext()) {
            e eVarE = e(it.next());
            if (eVarE.i() != f.INTERFACE) {
                return eVarE;
            }
        }
        return null;
    }

    public static boolean t(m mVar) {
        return D(mVar, f.ANNOTATION_CLASS);
    }

    public static boolean u(m mVar) {
        if (mVar == null) {
            a(34);
        }
        return v(mVar) && mVar.getName().equals(kotlin.reflect.y.internal.j0.f.h.f24216b);
    }

    public static boolean v(m mVar) {
        return D(mVar, f.CLASS);
    }

    public static boolean w(m mVar) {
        return v(mVar) || A(mVar);
    }

    public static boolean x(m mVar) {
        return D(mVar, f.OBJECT) && ((e) mVar).A();
    }

    public static boolean y(m mVar) {
        return (mVar instanceof q) && ((q) mVar).getVisibility() == t.f25369f;
    }

    public static boolean z(e eVar, e eVar2) {
        if (eVar == null) {
            a(26);
        }
        if (eVar2 == null) {
            a(27);
        }
        Iterator<e0> it = eVar.h().a().iterator();
        while (it.hasNext()) {
            if (F(it.next(), eVar2.a())) {
                return true;
            }
        }
        return false;
    }
}
