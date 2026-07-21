package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.y.internal.j0.b.g;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.l.d0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.t1.q;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.x;
import kotlin.text.u;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final String a(e eVar, y<?> yVar) {
        m.f(eVar, "klass");
        m.f(yVar, "typeMappingConfiguration");
        String strB = yVar.b(eVar);
        if (strB != null) {
            return strB;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = eVar.b();
        m.e(mVarB, "klass.containingDeclaration");
        String strU = h.b(eVar.getName()).u();
        m.e(strU, "safeIdentifier(klass.name).identifier");
        if (mVarB instanceof k0) {
            c cVarD = ((k0) mVarB).d();
            if (cVarD.d()) {
                return strU;
            }
            StringBuilder sb = new StringBuilder();
            String strB2 = cVarD.b();
            m.e(strB2, "fqName.asString()");
            sb.append(u.z(strB2, '.', '/', false, 4, null));
            sb.append('/');
            sb.append(strU);
            return sb.toString();
        }
        e eVar2 = mVarB instanceof e ? (e) mVarB : null;
        if (eVar2 == null) {
            throw new IllegalArgumentException("Unexpected container: " + mVarB + " for " + eVar);
        }
        String strD = yVar.d(eVar2);
        if (strD == null) {
            strD = a(eVar2, yVar);
        }
        return strD + '$' + strU;
    }

    public static /* synthetic */ String b(e eVar, y yVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            yVar = z.a;
        }
        return a(eVar, yVar);
    }

    public static final boolean c(a aVar) {
        m.f(aVar, "descriptor");
        if (aVar instanceof l) {
            return true;
        }
        e0 returnType = aVar.getReturnType();
        m.c(returnType);
        if (kotlin.reflect.y.internal.j0.b.h.B0(returnType)) {
            e0 returnType2 = aVar.getReturnType();
            m.c(returnType2);
            if (!n1.l(returnType2) && !(aVar instanceof u0)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10, types: [T, java.lang.Object] */
    public static final <T> T d(e0 e0Var, m<T> mVar, a0 a0Var, y<? extends T> yVar, j<T> jVar, Function3<? super e0, ? super T, ? super a0, kotlin.u> function3) {
        T t;
        e0 e0Var2;
        Object objD;
        m.f(e0Var, "kotlinType");
        m.f(mVar, "factory");
        m.f(a0Var, "mode");
        m.f(yVar, "typeMappingConfiguration");
        m.f(function3, "writeGenericType");
        e0 e0VarE = yVar.e(e0Var);
        if (e0VarE != null) {
            return (T) d(e0VarE, mVar, a0Var, yVar, jVar, function3);
        }
        if (g.q(e0Var)) {
            return (T) d(kotlin.reflect.y.internal.j0.b.l.a(e0Var), mVar, a0Var, yVar, jVar, function3);
        }
        q qVar = q.a;
        Object objB = b0.b(qVar, e0Var, mVar, a0Var);
        if (objB != null) {
            ?? r11 = (Object) b0.a(mVar, objB, a0Var.d());
            function3.d(e0Var, r11, a0Var);
            return r11;
        }
        e1 e1VarO0 = e0Var.O0();
        if (e1VarO0 instanceof d0) {
            d0 d0Var = (d0) e1VarO0;
            e0 e0VarI = d0Var.i();
            if (e0VarI == null) {
                e0VarI = yVar.c(d0Var.a());
            }
            return (T) d(kotlin.reflect.y.internal.j0.l.x1.a.w(e0VarI), mVar, a0Var, yVar, jVar, function3);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarC = e1VarO0.w();
        if (hVarC == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + e0Var);
        }
        if (k.m(hVarC)) {
            T t2 = (T) mVar.c("error/NonExistentClass");
            yVar.f(e0Var, (e) hVarC);
            if (jVar == null) {
                return t2;
            }
            throw null;
        }
        boolean z = hVarC instanceof e;
        if (z && kotlin.reflect.y.internal.j0.b.h.c0(e0Var)) {
            if (e0Var.M0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            g1 g1Var = e0Var.M0().get(0);
            e0 type = g1Var.getType();
            m.e(type, "memberProjection.type");
            if (g1Var.a() == r1.IN_VARIANCE) {
                objD = mVar.c("java/lang/Object");
                if (jVar != null) {
                    throw null;
                }
            } else {
                if (jVar != null) {
                    throw null;
                }
                r1 r1VarA = g1Var.a();
                m.e(r1VarA, "memberProjection.projectionKind");
                objD = d(type, mVar, a0Var.f(r1VarA, true), yVar, jVar, function3);
                if (jVar != null) {
                    throw null;
                }
            }
            return (T) mVar.b('[' + mVar.a(objD));
        }
        if (!z) {
            if (!(hVarC instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e1)) {
                if ((hVarC instanceof d1) && a0Var.b()) {
                    return (T) d(((d1) hVarC).W(), mVar, a0Var, yVar, jVar, function3);
                }
                throw new UnsupportedOperationException("Unknown type " + e0Var);
            }
            e0 e0VarI2 = kotlin.reflect.y.internal.j0.l.x1.a.i((kotlin.p002reflect.jvm.internal.impl.descriptors.e1) hVarC);
            if (e0Var.P0()) {
                e0VarI2 = kotlin.reflect.y.internal.j0.l.x1.a.t(e0VarI2);
            }
            T t3 = (T) d(e0VarI2, mVar, a0Var, yVar, null, kotlin.p002reflect.jvm.internal.impl.utils.d.b());
            if (jVar == null) {
                return t3;
            }
            m.e(hVarC.getName(), "descriptor.getName()");
            throw null;
        }
        if (f.b(hVarC) && !a0Var.c() && (e0Var2 = (e0) x.a(qVar, e0Var)) != null) {
            return (T) d(e0Var2, mVar, a0Var.g(), yVar, jVar, function3);
        }
        if (a0Var.e() && kotlin.reflect.y.internal.j0.b.h.k0((e) hVarC)) {
            t = (Object) mVar.e();
        } else {
            e eVar = (e) hVarC;
            e eVarA = eVar.a();
            m.e(eVarA, "descriptor.original");
            T tA = yVar.a(eVarA);
            if (tA == null) {
                if (eVar.i() == kotlin.p002reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY) {
                    kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = eVar.b();
                    m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    eVar = (e) mVarB;
                }
                e eVarA2 = eVar.a();
                m.e(eVarA2, "enumClassIfEnumEntry.original");
                t = (Object) mVar.c(a(eVarA2, yVar));
            } else {
                t = (Object) tA;
            }
        }
        function3.d(e0Var, t, a0Var);
        return t;
    }

    public static /* synthetic */ Object e(e0 e0Var, m mVar, a0 a0Var, y yVar, j jVar, Function3 function3, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            function3 = kotlin.p002reflect.jvm.internal.impl.utils.d.b();
        }
        return d(e0Var, mVar, a0Var, yVar, jVar, function3);
    }
}
