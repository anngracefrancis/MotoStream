package kotlin.reflect.y.internal.j0.d.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import kotlin.f0.y.e.j0.d.b.b.a;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.z.e;
import kotlin.reflect.y.internal.j0.e.z.g;
import kotlin.reflect.y.internal.j0.j.b.f;
import kotlin.reflect.y.internal.j0.j.b.z;
import kotlin.text.v;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<A, S extends a<? extends A>> implements f<A> {
    private final o a;

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public static abstract class a<A> {
        public abstract Map<t, List<A>> a();
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    private enum EnumC0342b {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[kotlin.reflect.y.internal.j0.j.b.b.values().length];
            iArr[kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_GETTER.ordinal()] = 1;
            iArr[kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_SETTER.ordinal()] = 2;
            iArr[kotlin.reflect.y.internal.j0.j.b.b.PROPERTY.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationLoader.kt */
    public static final class d implements q.c {
        final /* synthetic */ b<A, S> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ArrayList<A> f23736b;

        d(b<A, S> bVar, ArrayList<A> arrayList) {
            this.a = bVar;
            this.f23736b = arrayList;
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.c
        public void a() {
        }

        @Override // kotlin.f0.y.e.j0.d.b.q.c
        public q.a b(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var) {
            m.f(bVar, "classId");
            m.f(z0Var, "source");
            return this.a.y(bVar, z0Var, this.f23736b);
        }
    }

    public b(o oVar) {
        m.f(oVar, "kotlinClassFinder");
        this.a = oVar;
    }

    private final q B(z.a aVar) {
        z0 z0VarC = aVar.c();
        s sVar = z0VarC instanceof s ? (s) z0VarC : null;
        if (sVar != null) {
            return sVar.d();
        }
        return null;
    }

    private final int l(z zVar, o oVar) {
        if (oVar instanceof i) {
            if (kotlin.reflect.y.internal.j0.e.z.f.d((i) oVar)) {
                return 1;
            }
        } else if (oVar instanceof n) {
            if (kotlin.reflect.y.internal.j0.e.z.f.e((n) oVar)) {
                return 1;
            }
        } else {
            if (!(oVar instanceof kotlin.reflect.y.internal.j0.e.d)) {
                throw new UnsupportedOperationException("Unsupported message: " + oVar.getClass());
            }
            m.d(zVar, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
            z.a aVar = (z.a) zVar;
            if (aVar.g() == kotlin.reflect.y.internal.j0.e.c.EnumC0365c.ENUM_CLASS) {
                return 2;
            }
            if (aVar.i()) {
                return 1;
            }
        }
        return 0;
    }

    private final List<A> m(z zVar, t tVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        q qVarO = o(zVar, v(zVar, z, z2, bool, z3));
        if (qVarO == null) {
            return u.j();
        }
        List<A> list = p(qVarO).a().get(tVar);
        return list == null ? u.j() : list;
    }

    static /* synthetic */ List n(b bVar, z zVar, t tVar, boolean z, boolean z2, Boolean bool, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return bVar.m(zVar, tVar, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? false : z2, (i2 & 16) != 0 ? null : bool, (i2 & 32) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    public static /* synthetic */ t s(b bVar, o oVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, kotlin.reflect.y.internal.j0.j.b.b bVar2, boolean z, int i2, Object obj) {
        if (obj == null) {
            return bVar.r(oVar, cVar, gVar, bVar2, (i2 & 16) != 0 ? false : z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    public static /* synthetic */ t u(b bVar, n nVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if (obj == null) {
            return bVar.t(nVar, cVar, gVar, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2, (i2 & 32) != 0 ? true : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final List<A> z(z zVar, n nVar, EnumC0342b enumC0342b) {
        Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.A.d(nVar.b0());
        m.e(boolD, "IS_CONST.get(proto.flags)");
        boolean zBooleanValue = boolD.booleanValue();
        boolean zF = kotlin.reflect.y.internal.j0.e.a0.b.i.f(nVar);
        if (enumC0342b == EnumC0342b.PROPERTY) {
            t tVarU = u(this, nVar, zVar.b(), zVar.d(), false, true, false, 40, null);
            return tVarU == null ? u.j() : n(this, zVar, tVarU, true, false, Boolean.valueOf(zBooleanValue), zF, 8, null);
        }
        t tVarU2 = u(this, nVar, zVar.b(), zVar.d(), true, false, false, 48, null);
        if (tVarU2 == null) {
            return u.j();
        }
        return v.J(tVarU2.a(), "$delegate", false, 2, null) != (enumC0342b == EnumC0342b.DELEGATE_FIELD) ? u.j() : m(zVar, tVarU2, true, true, Boolean.valueOf(zBooleanValue), zF);
    }

    protected abstract A A(kotlin.reflect.y.internal.j0.e.b bVar, kotlin.reflect.y.internal.j0.e.z.c cVar);

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> a(s sVar, kotlin.reflect.y.internal.j0.e.z.c cVar) {
        m.f(sVar, "proto");
        m.f(cVar, "nameResolver");
        Object objU = sVar.u(kotlin.reflect.y.internal.j0.e.a0.a.f23827h);
        m.e(objU, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<kotlin.reflect.y.internal.j0.e.b> iterable = (Iterable) objU;
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(iterable, 10));
        for (kotlin.reflect.y.internal.j0.e.b bVar : iterable) {
            m.e(bVar, "it");
            arrayList.add(A(bVar, cVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> b(z zVar, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar, int i2, kotlin.reflect.y.internal.j0.e.u uVar) {
        m.f(zVar, "container");
        m.f(oVar, "callableProto");
        m.f(bVar, "kind");
        m.f(uVar, "proto");
        t tVarS = s(this, oVar, zVar.b(), zVar.d(), bVar, false, 16, null);
        if (tVarS == null) {
            return u.j();
        }
        return n(this, zVar, t.a.e(tVarS, i2 + l(zVar, oVar)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> c(z.a aVar) {
        m.f(aVar, "container");
        q qVarB = B(aVar);
        if (qVarB != null) {
            ArrayList arrayList = new ArrayList(1);
            qVarB.b(new d(this, arrayList), q(qVarB));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + aVar.a()).toString());
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> d(q qVar, kotlin.reflect.y.internal.j0.e.z.c cVar) {
        m.f(qVar, "proto");
        m.f(cVar, "nameResolver");
        Object objU = qVar.u(kotlin.reflect.y.internal.j0.e.a0.a.f23825f);
        m.e(objU, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<kotlin.reflect.y.internal.j0.e.b> iterable = (Iterable) objU;
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(iterable, 10));
        for (kotlin.reflect.y.internal.j0.e.b bVar : iterable) {
            m.e(bVar, "it");
            arrayList.add(A(bVar, cVar));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> f(z zVar, kotlin.reflect.y.internal.j0.e.g gVar) {
        m.f(zVar, "container");
        m.f(gVar, "proto");
        t.a aVar = t.a;
        String string = zVar.b().getString(gVar.F());
        String strC = ((z.a) zVar).e().c();
        m.e(strC, "container as ProtoContai…Class).classId.asString()");
        return n(this, zVar, aVar.a(string, kotlin.reflect.y.internal.j0.e.a0.b.b.b(strC)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> g(z zVar, n nVar) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        return z(zVar, nVar, EnumC0342b.BACKING_FIELD);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> h(z zVar, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
        m.f(zVar, "container");
        m.f(oVar, "proto");
        m.f(bVar, "kind");
        t tVarS = s(this, oVar, zVar.b(), zVar.d(), bVar, false, 16, null);
        return tVarS != null ? n(this, zVar, t.a.e(tVarS, 0), false, false, null, false, 60, null) : u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> i(z zVar, n nVar) {
        m.f(zVar, "container");
        m.f(nVar, "proto");
        return z(zVar, nVar, EnumC0342b.DELEGATE_FIELD);
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.f
    public List<A> j(z zVar, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
        m.f(zVar, "container");
        m.f(oVar, "proto");
        m.f(bVar, "kind");
        if (bVar == kotlin.reflect.y.internal.j0.j.b.b.PROPERTY) {
            return z(zVar, (n) oVar, EnumC0342b.PROPERTY);
        }
        t tVarS = s(this, oVar, zVar.b(), zVar.d(), bVar, false, 16, null);
        return tVarS == null ? u.j() : n(this, zVar, tVarS, false, false, null, false, 60, null);
    }

    protected final q o(z zVar, q qVar) {
        m.f(zVar, "container");
        if (qVar != null) {
            return qVar;
        }
        if (zVar instanceof z.a) {
            return B((z.a) zVar);
        }
        return null;
    }

    protected abstract S p(q qVar);

    protected byte[] q(q qVar) {
        m.f(qVar, "kotlinClass");
        return null;
    }

    protected final t r(o oVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, kotlin.reflect.y.internal.j0.j.b.b bVar, boolean z) {
        m.f(oVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        m.f(bVar, "kind");
        if (oVar instanceof kotlin.reflect.y.internal.j0.e.d) {
            t.a aVar = t.a;
            kotlin.f0.y.e.j0.e.a0.b.d.b bVarB = kotlin.reflect.y.internal.j0.e.a0.b.i.a.b((kotlin.reflect.y.internal.j0.e.d) oVar, cVar, gVar);
            if (bVarB == null) {
                return null;
            }
            return aVar.b(bVarB);
        }
        if (oVar instanceof i) {
            t.a aVar2 = t.a;
            kotlin.f0.y.e.j0.e.a0.b.d.b bVarE = kotlin.reflect.y.internal.j0.e.a0.b.i.a.e((i) oVar, cVar, gVar);
            if (bVarE == null) {
                return null;
            }
            return aVar2.b(bVarE);
        }
        if (!(oVar instanceof n)) {
            return null;
        }
        h.f<n, kotlin.f0.y.e.j0.e.a0.a.d> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23823d;
        m.e(fVar, "propertySignature");
        kotlin.f0.y.e.j0.e.a0.a.d dVar = (kotlin.f0.y.e.j0.e.a0.a.d) e.a((h.d) oVar, fVar);
        if (dVar == null) {
            return null;
        }
        int i2 = c.a[bVar.ordinal()];
        if (i2 == 1) {
            if (!dVar.G()) {
                return null;
            }
            t.a aVar3 = t.a;
            kotlin.f0.y.e.j0.e.a0.a.c cVarB = dVar.B();
            m.e(cVarB, "signature.getter");
            return aVar3.c(cVar, cVarB);
        }
        if (i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return t((n) oVar, cVar, gVar, true, true, z);
        }
        if (!dVar.H()) {
            return null;
        }
        t.a aVar4 = t.a;
        kotlin.f0.y.e.j0.e.a0.a.c cVarC = dVar.C();
        m.e(cVarC, "signature.setter");
        return aVar4.c(cVar, cVarC);
    }

    protected final t t(n nVar, kotlin.reflect.y.internal.j0.e.z.c cVar, g gVar, boolean z, boolean z2, boolean z3) {
        m.f(nVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<n, kotlin.f0.y.e.j0.e.a0.a.d> fVar = kotlin.reflect.y.internal.j0.e.a0.a.f23823d;
        m.e(fVar, "propertySignature");
        kotlin.f0.y.e.j0.e.a0.a.d dVar = (kotlin.f0.y.e.j0.e.a0.a.d) e.a(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        if (z) {
            kotlin.f0.y.e.j0.e.a0.b.d.a aVarC = kotlin.reflect.y.internal.j0.e.a0.b.i.a.c(nVar, cVar, gVar, z3);
            if (aVarC == null) {
                return null;
            }
            return t.a.b(aVarC);
        }
        if (!z2 || !dVar.I()) {
            return null;
        }
        t.a aVar = t.a;
        kotlin.f0.y.e.j0.e.a0.a.c cVarD = dVar.D();
        m.e(cVarD, "signature.syntheticMethod");
        return aVar.c(cVar, cVarD);
    }

    protected final q v(z zVar, boolean z, boolean z2, Boolean bool, boolean z3) {
        z.a aVarH;
        m.f(zVar, "container");
        if (z) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + zVar + ')').toString());
            }
            if (zVar instanceof z.a) {
                z.a aVar = (z.a) zVar;
                if (aVar.g() == kotlin.reflect.y.internal.j0.e.c.EnumC0365c.INTERFACE) {
                    o oVar = this.a;
                    kotlin.reflect.y.internal.j0.f.b bVarD = aVar.e().d(kotlin.reflect.y.internal.j0.f.f.x("DefaultImpls"));
                    m.e(bVarD, "container.classId.create…EFAULT_IMPLS_CLASS_NAME))");
                    return p.b(oVar, bVarD);
                }
            }
            if (bool.booleanValue() && (zVar instanceof z.b)) {
                z0 z0VarC = zVar.c();
                k kVar = z0VarC instanceof k ? (k) z0VarC : null;
                kotlin.reflect.y.internal.j0.i.u.d dVarF = kVar != null ? kVar.f() : null;
                if (dVarF != null) {
                    o oVar2 = this.a;
                    String strF = dVarF.f();
                    m.e(strF, "facadeClassName.internalName");
                    kotlin.reflect.y.internal.j0.f.b bVarM = kotlin.reflect.y.internal.j0.f.b.m(new kotlin.reflect.y.internal.j0.f.c(kotlin.text.u.z(strF, '/', '.', false, 4, null)));
                    m.e(bVarM, "topLevel(FqName(facadeCl…lName.replace('/', '.')))");
                    return p.b(oVar2, bVarM);
                }
            }
        }
        if (z2 && (zVar instanceof z.a)) {
            z.a aVar2 = (z.a) zVar;
            if (aVar2.g() == kotlin.reflect.y.internal.j0.e.c.EnumC0365c.COMPANION_OBJECT && (aVarH = aVar2.h()) != null && (aVarH.g() == kotlin.reflect.y.internal.j0.e.c.EnumC0365c.CLASS || aVarH.g() == kotlin.reflect.y.internal.j0.e.c.EnumC0365c.ENUM_CLASS || (z3 && (aVarH.g() == kotlin.reflect.y.internal.j0.e.c.EnumC0365c.INTERFACE || aVarH.g() == kotlin.reflect.y.internal.j0.e.c.EnumC0365c.ANNOTATION_CLASS)))) {
                return B(aVarH);
            }
        }
        if (!(zVar instanceof z.b) || !(zVar.c() instanceof k)) {
            return null;
        }
        z0 z0VarC2 = zVar.c();
        m.d(z0VarC2, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        k kVar2 = (k) z0VarC2;
        q qVarG = kVar2.g();
        return qVarG == null ? p.b(this.a, kVar2.d()) : qVarG;
    }

    protected final boolean w(kotlin.reflect.y.internal.j0.f.b bVar) {
        q qVarB;
        m.f(bVar, "classId");
        return bVar.g() != null && m.a(bVar.j().k(), "Container") && (qVarB = p.b(this.a, bVar)) != null && kotlin.reflect.y.internal.j0.a.a.c(qVarB);
    }

    protected abstract q.a x(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var, List<A> list);

    protected final q.a y(kotlin.reflect.y.internal.j0.f.b bVar, z0 z0Var, List<A> list) {
        m.f(bVar, "annotationClassId");
        m.f(z0Var, "source");
        m.f(list, "result");
        if (kotlin.reflect.y.internal.j0.a.a.b().contains(bVar)) {
            return null;
        }
        return x(bVar, z0Var, list);
    }
}
