package kotlin.reflect.y.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.r;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.v0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.b.q.a;
import kotlin.reflect.y.internal.j0.d.a.g0;
import kotlin.reflect.y.internal.j0.d.a.k0.f;
import kotlin.reflect.y.internal.j0.d.a.n0.l;
import kotlin.reflect.y.internal.j0.d.a.z;
import kotlin.reflect.y.internal.j0.d.b.v;
import kotlin.reflect.y.internal.j0.e.a0.b.d;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.reflect.y.internal.j0.j.b.g0.j;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.f0.y.e.d0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/RuntimeTypeMapper;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "JAVA_LANG_VOID", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "primitiveType", "Lkotlin/reflect/jvm/internal/impl/builtins/PrimitiveType;", "Ljava/lang/Class;", "getPrimitiveType", "(Ljava/lang/Class;)Lorg/jetbrains/kotlin/builtins/PrimitiveType;", "isKnownBuiltInFunction", HttpUrl.FRAGMENT_ENCODE_SET, "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "mapJvmClassToKotlinClassId", "klass", "mapJvmFunctionSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature$KotlinFunction;", "mapName", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "mapPropertySignature", "Lkotlin/reflect/jvm/internal/JvmPropertySignature;", "possiblyOverriddenProperty", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "mapSignature", "Lkotlin/reflect/jvm/internal/JvmFunctionSignature;", "possiblySubstitutedFunction", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RuntimeTypeMapper {
    public static final RuntimeTypeMapper a = new RuntimeTypeMapper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f23033b;

    static {
        b bVarM = b.m(new c("java.lang.Void"));
        m.e(bVarM, "topLevel(FqName(\"java.lang.Void\"))");
        f23033b = bVarM;
    }

    private RuntimeTypeMapper() {
    }

    private final i a(Class<?> cls) {
        if (cls.isPrimitive()) {
            return e.k(cls.getSimpleName()).x();
        }
        return null;
    }

    private final boolean b(y yVar) {
        if (kotlin.reflect.y.internal.j0.i.c.o(yVar) || kotlin.reflect.y.internal.j0.i.c.p(yVar)) {
            return true;
        }
        return m.a(yVar.getName(), a.f23239e.a()) && yVar.f().isEmpty();
    }

    private final JvmFunctionSignature.e d(y yVar) {
        return new JvmFunctionSignature.e(new d.b(e(yVar), v.c(yVar, false, false, 1, null)));
    }

    private final String e(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        String strB = g0.b(bVar);
        if (strB != null) {
            return strB;
        }
        if (bVar instanceof u0) {
            String strK = kotlin.reflect.y.internal.j0.i.t.a.o(bVar).getName().k();
            m.e(strK, "descriptor.propertyIfAccessor.name.asString()");
            return z.b(strK);
        }
        if (bVar instanceof v0) {
            String strK2 = kotlin.reflect.y.internal.j0.i.t.a.o(bVar).getName().k();
            m.e(strK2, "descriptor.propertyIfAccessor.name.asString()");
            return z.e(strK2);
        }
        String strK3 = bVar.getName().k();
        m.e(strK3, "descriptor.name.asString()");
        return strK3;
    }

    public final b c(Class<?> cls) {
        m.f(cls, "klass");
        if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            m.e(componentType, "klass.componentType");
            i iVarA = a(componentType);
            if (iVarA != null) {
                return new b(k.r, iVarA.q());
            }
            b bVarM = b.m(k.a.f23208i.l());
            m.e(bVarM, "topLevel(StandardNames.FqNames.array.toSafe())");
            return bVarM;
        }
        if (m.a(cls, Void.TYPE)) {
            return f23033b;
        }
        i iVarA2 = a(cls);
        if (iVarA2 != null) {
            return new b(k.r, iVarA2.v());
        }
        b bVarA = kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d.a(cls);
        if (!bVarA.k()) {
            kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
            c cVarB = bVarA.b();
            m.e(cVarB, "classId.asSingleFqName()");
            b bVarM2 = cVar.m(cVarB);
            if (bVarM2 != null) {
                return bVarM2;
            }
        }
        return bVarA;
    }

    public final JvmPropertySignature f(t0 t0Var) {
        m.f(t0Var, "possiblyOverriddenProperty");
        t0 t0VarA = ((t0) kotlin.reflect.y.internal.j0.i.d.L(t0Var)).a();
        m.e(t0VarA, "unwrapFakeOverride(possi…rriddenProperty).original");
        if (t0VarA instanceof j) {
            j jVar = (j) t0VarA;
            n nVarG1 = jVar.E();
            h.f<n, kotlin.f0.y.e.j0.e.a0.a.d> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23823d;
            m.e(fVar, "propertySignature");
            kotlin.f0.y.e.j0.e.a0.a.d dVar = (kotlin.f0.y.e.j0.e.a0.a.d) kotlin.reflect.y.internal.j0.e.z.e.a(nVarG1, fVar);
            if (dVar != null) {
                return new JvmPropertySignature.c(t0VarA, nVarG1, dVar, jVar.Z(), jVar.T());
            }
        } else if (t0VarA instanceof f) {
            z0 z0VarT = ((f) t0VarA).t();
            kotlin.reflect.y.internal.j0.d.a.m0.a aVar = z0VarT instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) z0VarT : null;
            l lVarB = aVar != null ? aVar.b() : null;
            if (lVarB instanceof r) {
                return new JvmPropertySignature.a(((r) lVarB).U());
            }
            if (lVarB instanceof u) {
                Method methodU = ((u) lVarB).U();
                v0 setter = t0VarA.getSetter();
                z0 z0VarT2 = setter != null ? setter.t() : null;
                kotlin.reflect.y.internal.j0.d.a.m0.a aVar2 = z0VarT2 instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) z0VarT2 : null;
                l lVarB2 = aVar2 != null ? aVar2.b() : null;
                u uVar = lVarB2 instanceof u ? (u) lVarB2 : null;
                return new JvmPropertySignature.b(methodU, uVar != null ? uVar.U() : null);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java field " + t0VarA + " (source = " + lVarB + ')');
        }
        u0 getter = t0VarA.getGetter();
        m.c(getter);
        JvmFunctionSignature.e eVarD = d(getter);
        v0 setter2 = t0VarA.getSetter();
        return new JvmPropertySignature.d(eVarD, setter2 != null ? d(setter2) : null);
    }

    public final JvmFunctionSignature g(y yVar) {
        Method methodU;
        d.b bVarB;
        d.b bVarE;
        m.f(yVar, "possiblySubstitutedFunction");
        y yVarA = ((y) kotlin.reflect.y.internal.j0.i.d.L(yVar)).a();
        m.e(yVarA, "unwrapFakeOverride(possi…titutedFunction).original");
        if (yVarA instanceof kotlin.reflect.y.internal.j0.j.b.g0.b) {
            kotlin.reflect.y.internal.j0.j.b.g0.b bVar = (kotlin.reflect.y.internal.j0.j.b.g0.b) yVarA;
            o oVarE = bVar.E();
            if ((oVarE instanceof kotlin.reflect.y.internal.j0.e.i) && (bVarE = kotlin.reflect.y.internal.j0.e.a0.b.i.a.e((kotlin.reflect.y.internal.j0.e.i) oVarE, bVar.Z(), bVar.T())) != null) {
                return new JvmFunctionSignature.e(bVarE);
            }
            if (!(oVarE instanceof kotlin.reflect.y.internal.j0.e.d) || (bVarB = kotlin.reflect.y.internal.j0.e.a0.b.i.a.b((kotlin.reflect.y.internal.j0.e.d) oVarE, bVar.Z(), bVar.T())) == null) {
                return d(yVarA);
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = yVar.b();
            m.e(mVarB, "possiblySubstitutedFunction.containingDeclaration");
            return kotlin.reflect.y.internal.j0.i.f.b(mVarB) ? new JvmFunctionSignature.e(bVarB) : new JvmFunctionSignature.d(bVarB);
        }
        if (yVarA instanceof kotlin.reflect.y.internal.j0.d.a.k0.e) {
            z0 z0VarT = ((kotlin.reflect.y.internal.j0.d.a.k0.e) yVarA).t();
            kotlin.reflect.y.internal.j0.d.a.m0.a aVar = z0VarT instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) z0VarT : null;
            l lVarB = aVar != null ? aVar.b() : null;
            u uVar = lVarB instanceof u ? (u) lVarB : null;
            if (uVar != null && (methodU = uVar.U()) != null) {
                return new JvmFunctionSignature.c(methodU);
            }
            throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java method " + yVarA);
        }
        if (!(yVarA instanceof kotlin.reflect.y.internal.j0.d.a.k0.b)) {
            if (b(yVarA)) {
                return d(yVarA);
            }
            throw new KotlinReflectionInternalError("Unknown origin of " + yVarA + " (" + yVarA.getClass() + ')');
        }
        z0 z0VarT2 = ((kotlin.reflect.y.internal.j0.d.a.k0.b) yVarA).t();
        kotlin.reflect.y.internal.j0.d.a.m0.a aVar2 = z0VarT2 instanceof kotlin.reflect.y.internal.j0.d.a.m0.a ? (kotlin.reflect.y.internal.j0.d.a.m0.a) z0VarT2 : null;
        l lVarB2 = aVar2 != null ? aVar2.b() : null;
        if (lVarB2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.o) {
            return new JvmFunctionSignature.b(((kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.o) lVarB2).U());
        }
        if (lVarB2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.l) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.l lVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.l) lVarB2;
            if (lVar.r()) {
                return new JvmFunctionSignature.a(lVar.w());
            }
        }
        throw new KotlinReflectionInternalError("Incorrect resolution sequence for Java constructor " + yVarA + " (" + lVarB2 + ')');
    }
}
