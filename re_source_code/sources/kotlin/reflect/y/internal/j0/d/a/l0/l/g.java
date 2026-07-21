package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.x0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.d.a.e0;
import kotlin.reflect.y.internal.j0.d.a.h0;
import kotlin.reflect.y.internal.j0.d.a.i0;
import kotlin.reflect.y.internal.j0.d.a.n0.k;
import kotlin.reflect.y.internal.j0.d.a.n0.n;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.d.a.n0.w;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.d.a.o;
import kotlin.reflect.y.internal.j0.d.a.o0.l;
import kotlin.reflect.y.internal.j0.d.a.z;
import kotlin.reflect.y.internal.j0.d.b.v;
import kotlin.reflect.y.internal.j0.l.n1;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends kotlin.reflect.y.internal.j0.d.a.l0.l.j {
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.e n;
    private final kotlin.reflect.y.internal.j0.d.a.n0.g o;
    private final boolean p;
    private final kotlin.reflect.y.internal.j0.k.i<List<kotlin.p002reflect.jvm.internal.impl.descriptors.d>> q;
    private final kotlin.reflect.y.internal.j0.k.i<Set<kotlin.reflect.y.internal.j0.f.f>> r;
    private final kotlin.reflect.y.internal.j0.k.i<Map<kotlin.reflect.y.internal.j0.f.f, n>> s;
    private final kotlin.reflect.y.internal.j0.k.h<kotlin.reflect.y.internal.j0.f.f, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g> t;

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class a extends Lambda implements Function1<q, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23505f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q qVar) {
            m.f(qVar, "it");
            return Boolean.valueOf(!qVar.Q());
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    /* synthetic */ class b extends kotlin.jvm.internal.i implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        b(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(g.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "p0");
            return ((g) this.receiver).I0(fVar);
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    /* synthetic */ class c extends kotlin.jvm.internal.i implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        c(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(g.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "p0");
            return ((g) this.receiver).J0(fVar);
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class d extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "it");
            return g.this.I0(fVar);
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class e extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "it");
            return g.this.J0(fVar);
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class f extends Lambda implements Function0<List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.d>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23509g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
            super(0);
            this.f23509g = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.d> invoke() {
            Collection<k> collectionK = g.this.o.k();
            ArrayList arrayList = new ArrayList(collectionK.size());
            Iterator<k> it = collectionK.iterator();
            while (it.hasNext()) {
                arrayList.add(g.this.G0(it.next()));
            }
            if (g.this.o.t()) {
                kotlin.p002reflect.jvm.internal.impl.descriptors.d dVarE0 = g.this.e0();
                boolean z = false;
                String strC = v.c(dVarE0, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            z = true;
                            break;
                        }
                    } while (!m.a(v.c((kotlin.p002reflect.jvm.internal.impl.descriptors.d) it2.next(), false, false, 2, null), strC));
                } else {
                    z = true;
                    break;
                }
                if (z) {
                    arrayList.add(dVarE0);
                    this.f23509g.a().h().b(g.this.o, dVarE0);
                }
            }
            this.f23509g.a().w().c(g.this.C(), arrayList);
            l lVarR = this.f23509g.a().r();
            kotlin.reflect.y.internal.j0.d.a.l0.g gVar = this.f23509g;
            g gVar2 = g.this;
            boolean zIsEmpty = arrayList.isEmpty();
            List listN = arrayList;
            if (zIsEmpty) {
                listN = u.n(gVar2.d0());
            }
            return c0.E0(lVarR.g(gVar, listN));
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.l0.l.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class C0333g extends Lambda implements Function0<Map<kotlin.reflect.y.internal.j0.f.f, ? extends n>> {
        C0333g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<kotlin.reflect.y.internal.j0.f.f, n> invoke() {
            Collection<n> collectionD = g.this.o.D();
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionD) {
                if (((n) obj).G()) {
                    arrayList.add(obj);
                }
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.l.b(p0.e(kotlin.collections.v.u(arrayList, 10)), 16));
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((n) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class h extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, Collection<? extends y0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y0 f23511f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f23512g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(y0 y0Var, g gVar) {
            super(1);
            this.f23511f = y0Var;
            this.f23512g = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "accessorName");
            return m.a(this.f23511f.getName(), fVar) ? t.e(this.f23511f) : c0.o0(this.f23512g.I0(fVar), this.f23512g.J0(fVar));
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class i extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {
        i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
            return c0.I0(g.this.o.K());
        }
    }

    /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
    static final class j extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.f, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.g f23515g;

        /* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
        static final class a extends Lambda implements Function0<Set<? extends kotlin.reflect.y.internal.j0.f.f>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f23516f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(g gVar) {
                super(0);
                this.f23516f = gVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Set<kotlin.reflect.y.internal.j0.f.f> invoke() {
                return x0.l(this.f23516f.b(), this.f23516f.d());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
            super(1);
            this.f23515g = gVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g invoke(kotlin.reflect.y.internal.j0.f.f fVar) {
            m.f(fVar, "name");
            if (!((Set) g.this.r.invoke()).contains(fVar)) {
                n nVar = (n) ((Map) g.this.s.invoke()).get(fVar);
                if (nVar == null) {
                    return null;
                }
                return kotlin.p002reflect.jvm.internal.impl.descriptors.p1.n.M0(this.f23515g.e(), g.this.C(), fVar, this.f23515g.e().d(new a(g.this)), kotlin.reflect.y.internal.j0.d.a.l0.e.a(this.f23515g, nVar), this.f23515g.a().t().a(nVar));
            }
            o oVarD = this.f23515g.a().d();
            kotlin.reflect.y.internal.j0.f.b bVarG = kotlin.reflect.y.internal.j0.i.t.a.g(g.this.C());
            m.c(bVarG);
            kotlin.reflect.y.internal.j0.f.b bVarD = bVarG.d(fVar);
            m.e(bVarD, "ownerDescriptor.classId!…createNestedClassId(name)");
            kotlin.reflect.y.internal.j0.d.a.n0.g gVarA = oVarD.a(new o.b(bVarD, null, g.this.o, 2, null));
            if (gVarA == null) {
                return null;
            }
            kotlin.reflect.y.internal.j0.d.a.l0.g gVar = this.f23515g;
            kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar2 = new kotlin.reflect.y.internal.j0.d.a.l0.l.f(gVar, g.this.C(), gVarA, null, 8, null);
            gVar.a().e().a(fVar2);
            return fVar2;
        }
    }

    public /* synthetic */ g(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, boolean z, g gVar3, int i2, kotlin.jvm.internal.g gVar4) {
        this(gVar, eVar, gVar2, z, (i2 & 16) != 0 ? null : gVar3);
    }

    private final boolean A0(y0 y0Var, y yVar) {
        String strC = v.c(y0Var, false, false, 2, null);
        y yVarA = yVar.a();
        m.e(yVarA, "builtinWithErasedParameters.original");
        return m.a(strC, v.c(yVarA, false, false, 2, null)) && !o0(y0Var, yVar);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0071  */
    private final boolean B0(y0 y0Var) {
        boolean z;
        boolean z2;
        boolean z3;
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "function.name");
        List<kotlin.reflect.y.internal.j0.f.f> listA = e0.a(name);
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            Iterator<T> it = listA.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z3 = false;
                    break;
                }
                Set<t0> setZ0 = z0((kotlin.reflect.y.internal.j0.f.f) it.next());
                if (!(setZ0 instanceof Collection) || !setZ0.isEmpty()) {
                    Iterator<T> it2 = setZ0.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z2 = false;
                            break;
                        }
                        t0 t0Var = (t0) it2.next();
                        if (n0(t0Var, new h(y0Var, this))) {
                            if (!t0Var.j0()) {
                                String strK = y0Var.getName().k();
                                m.e(strK, "function.name.asString()");
                                if (z.d(strK)) {
                                    z = false;
                                }
                            }
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            z2 = true;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                    break;
                    break;
                }
                if (z2) {
                    z3 = true;
                    break;
                }
            }
        } else {
            z3 = false;
            break;
        }
        return (z3 || p0(y0Var) || K0(y0Var) || r0(y0Var)) ? false : true;
    }

    private final y0 C0(y0 y0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1, Collection<? extends y0> collection) {
        y0 y0VarG0;
        y yVarK = kotlin.reflect.y.internal.j0.d.a.f.k(y0Var);
        if (yVarK == null || (y0VarG0 = g0(yVarK, function1)) == null) {
            return null;
        }
        if (!B0(y0VarG0)) {
            y0VarG0 = null;
        }
        if (y0VarG0 != null) {
            return f0(y0VarG0, yVarK, collection);
        }
        return null;
    }

    private final y0 D0(y0 y0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1, kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends y0> collection) {
        y0 y0Var2 = (y0) kotlin.reflect.y.internal.j0.d.a.g0.d(y0Var);
        if (y0Var2 == null) {
            return null;
        }
        String strB = kotlin.reflect.y.internal.j0.d.a.g0.b(y0Var2);
        m.c(strB);
        kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(strB);
        m.e(fVarX, "identifier(nameInJava)");
        Iterator<? extends y0> it = function1.invoke(fVarX).iterator();
        while (it.hasNext()) {
            y0 y0VarL0 = l0(it.next(), fVar);
            if (q0(y0Var2, y0VarL0)) {
                return f0(y0VarL0, y0Var2, collection);
            }
        }
        return null;
    }

    private final y0 E0(y0 y0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        if (!y0Var.isSuspend()) {
            return null;
        }
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "descriptor.name");
        Iterator<T> it = function1.invoke(name).iterator();
        while (it.hasNext()) {
            y0 y0VarM0 = m0((y0) it.next());
            if (y0VarM0 == null || !o0(y0VarM0, y0Var)) {
                y0VarM0 = null;
            }
            if (y0VarM0 != null) {
                return y0VarM0;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.y.internal.j0.d.a.k0.b G0(k kVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarC = C();
        kotlin.reflect.y.internal.j0.d.a.k0.b bVarU1 = kotlin.reflect.y.internal.j0.d.a.k0.b.u1(eVarC, kotlin.reflect.y.internal.j0.d.a.l0.e.a(w(), kVar), false, w().a().t().a(kVar));
        m.e(bVarU1, "createJavaConstructor(\n …ce(constructor)\n        )");
        kotlin.reflect.y.internal.j0.d.a.l0.g gVarE = kotlin.reflect.y.internal.j0.d.a.l0.a.e(w(), bVarU1, kVar, eVarC.w().size());
        kotlin.f0.y.e.j0.d.a.l0.l.j.b bVarK = K(gVarE, bVarU1, kVar.f());
        List<e1> listW = eVarC.w();
        m.e(listW, "classDescriptor.declaredTypeParameters");
        List<kotlin.reflect.y.internal.j0.d.a.n0.y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            e1 e1VarA = gVarE.f().a((kotlin.reflect.y.internal.j0.d.a.n0.y) it.next());
            m.c(e1VarA);
            arrayList.add(e1VarA);
        }
        bVarU1.s1(bVarK.a(), i0.c(kVar.getVisibility()), c0.o0(listW, arrayList));
        bVarU1.Z0(false);
        bVarU1.a1(bVarK.b());
        bVarU1.h1(eVarC.s());
        gVarE.a().h().b(kVar, bVarU1);
        return bVarU1;
    }

    private final kotlin.reflect.y.internal.j0.d.a.k0.e H0(w wVar) {
        kotlin.reflect.y.internal.j0.d.a.k0.e eVarQ1 = kotlin.reflect.y.internal.j0.d.a.k0.e.q1(C(), kotlin.reflect.y.internal.j0.d.a.l0.e.a(w(), wVar), wVar.getName(), w().a().t().a(wVar), true);
        m.e(eVarQ1, "createJavaMethod(\n      …omponent), true\n        )");
        eVarQ1.p1(null, z(), u.j(), u.j(), u.j(), w().g().o(wVar.getType(), kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 2, null)), d0.f25129f.a(false, false, true), kotlin.p002reflect.jvm.internal.impl.descriptors.t.f25368e, null);
        eVarQ1.t1(false, false);
        w().a().h().e(wVar, eVarQ1);
        return eVarQ1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<y0> I0(kotlin.reflect.y.internal.j0.f.f fVar) {
        Collection<r> collectionF = y().invoke().f(fVar);
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(collectionF, 10));
        Iterator<T> it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add(I((r) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<y0> J0(kotlin.reflect.y.internal.j0.f.f fVar) {
        Set<y0> setX0 = x0(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setX0) {
            y0 y0Var = (y0) obj;
            if (!(kotlin.reflect.y.internal.j0.d.a.g0.a(y0Var) || kotlin.reflect.y.internal.j0.d.a.f.k(y0Var) != null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final boolean K0(y0 y0Var) {
        kotlin.reflect.y.internal.j0.d.a.f fVar = kotlin.reflect.y.internal.j0.d.a.f.n;
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "name");
        if (!fVar.l(name)) {
            return false;
        }
        kotlin.reflect.y.internal.j0.f.f name2 = y0Var.getName();
        m.e(name2, "name");
        Set<y0> setX0 = x0(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setX0.iterator();
        while (it.hasNext()) {
            y yVarK = kotlin.reflect.y.internal.j0.d.a.f.k((y0) it.next());
            if (yVarK != null) {
                arrayList.add(yVarK);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (A0(y0Var, (y) it2.next())) {
                return true;
            }
        }
        return false;
    }

    private final void U(List<i1> list, kotlin.p002reflect.jvm.internal.impl.descriptors.l lVar, int i2, r rVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, kotlin.reflect.y.internal.j0.l.e0 e0Var2) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        kotlin.reflect.y.internal.j0.f.f name = rVar.getName();
        kotlin.reflect.y.internal.j0.l.e0 e0VarN = n1.n(e0Var);
        m.e(e0VarN, "makeNotNullable(returnType)");
        list.add(new l0(lVar, null, i2, gVarB, name, e0VarN, rVar.L(), false, false, e0Var2 != null ? n1.n(e0Var2) : null, w().a().t().a(rVar)));
    }

    private final void V(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends y0> collection2, boolean z) {
        Collection<? extends y0> collectionD = kotlin.reflect.y.internal.j0.d.a.j0.a.d(fVar, collection2, collection, C(), w().a().c(), w().a().k().a());
        m.e(collectionD, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (!z) {
            collection.addAll(collectionD);
            return;
        }
        List listO0 = c0.o0(collection, collectionD);
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(collectionD, 10));
        for (y0 y0VarF0 : collectionD) {
            y0 y0Var = (y0) kotlin.reflect.y.internal.j0.d.a.g0.e(y0VarF0);
            if (y0Var == null) {
                m.e(y0VarF0, "resolvedOverride");
            } else {
                m.e(y0VarF0, "resolvedOverride");
                y0VarF0 = f0(y0VarF0, y0Var, listO0);
            }
            arrayList.add(y0VarF0);
        }
        collection.addAll(arrayList);
    }

    private final void W(kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends y0> collection, Collection<? extends y0> collection2, Collection<y0> collection3, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        for (y0 y0Var : collection2) {
            kotlin.p002reflect.jvm.internal.impl.utils.a.a(collection3, D0(y0Var, function1, fVar, collection));
            kotlin.p002reflect.jvm.internal.impl.utils.a.a(collection3, C0(y0Var, function1, collection));
            kotlin.p002reflect.jvm.internal.impl.utils.a.a(collection3, E0(y0Var, function1));
        }
    }

    private final void X(Set<? extends t0> set, Collection<t0> collection, Set<t0> set2, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        for (t0 t0Var : set) {
            kotlin.reflect.y.internal.j0.d.a.k0.f fVarH0 = h0(t0Var, function1);
            if (fVarH0 != null) {
                collection.add(fVarH0);
                if (set2 != null) {
                    set2.add(t0Var);
                    return;
                }
                return;
            }
        }
    }

    private final void Y(kotlin.reflect.y.internal.j0.f.f fVar, Collection<t0> collection) {
        r rVar = (r) s.t0(y().invoke().f(fVar));
        if (rVar == null) {
            return;
        }
        collection.add(j0(this, rVar, null, d0.FINAL, 2, null));
    }

    private final Collection<kotlin.reflect.y.internal.j0.l.e0> b0() {
        if (!this.p) {
            return w().a().k().c().g(C());
        }
        Collection<kotlin.reflect.y.internal.j0.l.e0> collectionA = C().h().a();
        m.e(collectionA, "ownerDescriptor.typeConstructor.supertypes");
        return collectionA;
    }

    private final List<i1> c0(kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f fVar) {
        Pair pair;
        Collection<r> collectionM = this.o.M();
        ArrayList arrayList = new ArrayList(collectionM.size());
        kotlin.reflect.y.internal.j0.d.a.l0.m.a aVarD = kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : collectionM) {
            if (m.a(((r) obj).getName(), a0.f23325c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair2 = new Pair(arrayList2, arrayList3);
        List list = (List) pair2.a();
        List<r> list2 = (List) pair2.b();
        list.size();
        r rVar = (r) s.W(list);
        if (rVar != null) {
            x returnType = rVar.getReturnType();
            if (returnType instanceof kotlin.reflect.y.internal.j0.d.a.n0.f) {
                kotlin.reflect.y.internal.j0.d.a.n0.f fVar2 = (kotlin.reflect.y.internal.j0.d.a.n0.f) returnType;
                pair = new Pair(w().g().k(fVar2, aVarD, true), w().g().o(fVar2.n(), aVarD));
            } else {
                pair = new Pair(w().g().o(returnType, aVarD), null);
            }
            U(arrayList, fVar, 0, rVar, (kotlin.reflect.y.internal.j0.l.e0) pair.a(), (kotlin.reflect.y.internal.j0.l.e0) pair.b());
        }
        int i2 = 0;
        int i3 = rVar == null ? 0 : 1;
        for (r rVar2 : list2) {
            U(arrayList, fVar, i2 + i3, rVar2, w().g().o(rVar2.getReturnType(), aVarD), null);
            i2++;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.p002reflect.jvm.internal.impl.descriptors.d d0() {
        boolean zR = this.o.r();
        if ((this.o.H() || !this.o.u()) && !zR) {
            return null;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarC = C();
        kotlin.reflect.y.internal.j0.d.a.k0.b bVarU1 = kotlin.reflect.y.internal.j0.d.a.k0.b.u1(eVarC, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), true, w().a().t().a(this.o));
        m.e(bVarU1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<i1> listC0 = zR ? c0(bVarU1) : Collections.emptyList();
        bVarU1.a1(false);
        bVarU1.r1(listC0, v0(eVarC));
        bVarU1.Z0(true);
        bVarU1.h1(eVarC.s());
        w().a().h().b(this.o, bVarU1);
        return bVarU1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.p002reflect.jvm.internal.impl.descriptors.d e0() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarC = C();
        kotlin.reflect.y.internal.j0.d.a.k0.b bVarU1 = kotlin.reflect.y.internal.j0.d.a.k0.b.u1(eVarC, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), true, w().a().t().a(this.o));
        m.e(bVarU1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<i1> listK0 = k0(bVarU1);
        bVarU1.a1(false);
        bVarU1.r1(listK0, v0(eVarC));
        bVarU1.Z0(false);
        bVarU1.h1(eVarC.s());
        return bVarU1;
    }

    private final y0 f0(y0 y0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, Collection<? extends y0> collection) {
        y0 y0Var2;
        boolean z = false;
        if (!(collection instanceof Collection) || !collection.isEmpty()) {
            Iterator<T> it = collection.iterator();
            do {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                y0Var2 = (y0) it.next();
            } while (!(!m.a(y0Var, y0Var2) && y0Var2.d0() == null && o0(y0Var2, aVar)));
        } else {
            z = true;
            break;
        }
        if (z) {
            return y0Var;
        }
        y yVarC = y0Var.u().q().c();
        m.c(yVarC);
        return (y0) yVarC;
    }

    private final y0 g0(y yVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        Object next;
        kotlin.reflect.y.internal.j0.f.f name = yVar.getName();
        m.e(name, "overridden.name");
        Iterator<T> it = function1.invoke(name).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!A0((y0) next, yVar));
        y0 y0Var = (y0) next;
        if (y0Var == null) {
            return null;
        }
        y.a<? extends y0> aVarU = y0Var.u();
        List<i1> listF = yVar.f();
        m.e(listF, "overridden.valueParameters");
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(listF, 10));
        Iterator<T> it2 = listF.iterator();
        while (it2.hasNext()) {
            arrayList.add(((i1) it2.next()).getType());
        }
        List<i1> listF2 = y0Var.f();
        m.e(listF2, "override.valueParameters");
        aVarU.b(kotlin.reflect.y.internal.j0.d.a.k0.h.a(arrayList, listF2, yVar));
        aVarU.u();
        aVarU.f();
        aVarU.n(kotlin.reflect.y.internal.j0.d.a.k0.e.K, Boolean.TRUE);
        return (y0) aVarU.c();
    }

    private final kotlin.reflect.y.internal.j0.d.a.k0.f h0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        y0 y0VarU0;
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0 e0VarL = null;
        if (!n0(t0Var, function1)) {
            return null;
        }
        y0 y0VarT0 = t0(t0Var, function1);
        m.c(y0VarT0);
        if (t0Var.j0()) {
            y0VarU0 = u0(t0Var, function1);
            m.c(y0VarU0);
        } else {
            y0VarU0 = null;
        }
        if (y0VarU0 != null) {
            y0VarU0.j();
            y0VarT0.j();
        }
        kotlin.reflect.y.internal.j0.d.a.k0.d dVar = new kotlin.reflect.y.internal.j0.d.a.k0.d(C(), y0VarT0, y0VarU0, t0Var);
        kotlin.reflect.y.internal.j0.l.e0 returnType = y0VarT0.getReturnType();
        m.c(returnType);
        dVar.c1(returnType, u.j(), z(), null, u.j());
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.d0 d0VarJ = kotlin.reflect.y.internal.j0.i.c.j(dVar, y0VarT0.getAnnotations(), false, false, false, y0VarT0.t());
        d0VarJ.O0(y0VarT0);
        d0VarJ.R0(dVar.getType());
        m.e(d0VarJ, "createGetter(\n          …escriptor.type)\n        }");
        if (y0VarU0 != null) {
            List<i1> listF = y0VarU0.f();
            m.e(listF, "setterMethod.valueParameters");
            i1 i1Var = (i1) s.W(listF);
            if (i1Var == null) {
                throw new AssertionError("No parameter found for " + y0VarU0);
            }
            e0VarL = kotlin.reflect.y.internal.j0.i.c.l(dVar, y0VarU0.getAnnotations(), i1Var.getAnnotations(), false, false, false, y0VarU0.getVisibility(), y0VarU0.t());
            e0VarL.O0(y0VarU0);
        }
        dVar.V0(d0VarJ, e0VarL);
        return dVar;
    }

    private final kotlin.reflect.y.internal.j0.d.a.k0.f i0(r rVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, d0 d0Var) {
        kotlin.reflect.y.internal.j0.d.a.k0.f fVarG1 = kotlin.reflect.y.internal.j0.d.a.k0.f.g1(C(), kotlin.reflect.y.internal.j0.d.a.l0.e.a(w(), rVar), d0Var, i0.c(rVar.getVisibility()), false, rVar.getName(), w().a().t().a(rVar), false);
        m.e(fVarG1, "create(\n            owne…inal = */ false\n        )");
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.d0 d0VarD = kotlin.reflect.y.internal.j0.i.c.d(fVarG1, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b());
        m.e(d0VarD, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        fVarG1.V0(d0VarD, null);
        kotlin.reflect.y.internal.j0.l.e0 e0VarQ = e0Var == null ? q(rVar, kotlin.reflect.y.internal.j0.d.a.l0.a.f(w(), fVarG1, rVar, 0, 4, null)) : e0Var;
        fVarG1.c1(e0VarQ, u.j(), z(), null, u.j());
        d0VarD.R0(e0VarQ);
        return fVarG1;
    }

    static /* synthetic */ kotlin.reflect.y.internal.j0.d.a.k0.f j0(g gVar, r rVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, d0 d0Var, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            e0Var = null;
        }
        return gVar.i0(rVar, e0Var, d0Var);
    }

    private final List<i1> k0(kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f fVar) {
        Collection<w> collectionJ = this.o.j();
        ArrayList arrayList = new ArrayList(collectionJ.size());
        kotlin.reflect.y.internal.j0.l.e0 e0Var = null;
        kotlin.reflect.y.internal.j0.d.a.l0.m.a aVarD = kotlin.reflect.y.internal.j0.d.a.l0.m.d.d(kotlin.reflect.y.internal.j0.d.a.j0.k.COMMON, false, null, 2, null);
        int i2 = 0;
        for (w wVar : collectionJ) {
            int i3 = i2 + 1;
            kotlin.reflect.y.internal.j0.l.e0 e0VarO = w().g().o(wVar.getType(), aVarD);
            arrayList.add(new l0(fVar, null, i2, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), wVar.getName(), e0VarO, false, false, false, wVar.h() ? w().a().m().o().k(e0VarO) : e0Var, w().a().t().a(wVar)));
            i2 = i3;
            e0Var = null;
        }
        return arrayList;
    }

    private final y0 l0(y0 y0Var, kotlin.reflect.y.internal.j0.f.f fVar) {
        y.a<? extends y0> aVarU = y0Var.u();
        aVarU.t(fVar);
        aVarU.u();
        aVarU.f();
        y yVarC = aVarU.c();
        m.c(yVarC);
        return (y0) yVarC;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    private final y0 m0(y0 y0Var) {
        kotlin.reflect.y.internal.j0.f.c cVarL;
        kotlin.reflect.y.internal.j0.f.d dVarI;
        List<i1> listF = y0Var.f();
        m.e(listF, "valueParameters");
        i1 i1Var = (i1) s.i0(listF);
        if (i1Var != null) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = i1Var.getType().O0().w();
            if (hVarW == null || (dVarI = kotlin.reflect.y.internal.j0.i.t.a.i(hVarW)) == null) {
                cVarL = null;
            } else {
                if (!dVarI.f()) {
                    dVarI = null;
                }
                if (dVarI != null) {
                    cVarL = dVarI.l();
                } else {
                    cVarL = null;
                }
            }
            if (!m.a(cVarL, kotlin.reflect.y.internal.j0.b.k.m)) {
                i1Var = null;
            }
            if (i1Var != null) {
                y.a<? extends y0> aVarU = y0Var.u();
                List<i1> listF2 = y0Var.f();
                m.e(listF2, "valueParameters");
                y0 y0Var2 = (y0) aVarU.b(c0.N(listF2, 1)).g(i1Var.getType().M0().get(0).getType()).c();
                kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0 g0Var = (kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0) y0Var2;
                if (g0Var != null) {
                    g0Var.i1(true);
                }
                return y0Var2;
            }
        }
        return null;
    }

    private final boolean n0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        if (kotlin.reflect.y.internal.j0.d.a.l0.l.c.a(t0Var)) {
            return false;
        }
        y0 y0VarT0 = t0(t0Var, function1);
        y0 y0VarU0 = u0(t0Var, function1);
        if (y0VarT0 == null) {
            return false;
        }
        if (t0Var.j0()) {
            return y0VarU0 != null && y0VarU0.j() == y0VarT0.j();
        }
        return true;
    }

    private final boolean o0(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar2) {
        kotlin.f0.y.e.j0.i.j.i.a aVarC = kotlin.reflect.y.internal.j0.i.j.f24327b.F(aVar2, aVar, true).c();
        m.e(aVarC, "DEFAULT.isOverridableByW…iptor, this, true).result");
        return aVarC == kotlin.f0.y.e.j0.i.j.i.a.OVERRIDABLE && !kotlin.reflect.y.internal.j0.d.a.s.a.a(aVar2, aVar);
    }

    private final boolean p0(y0 y0Var) {
        h0.a aVar = h0.a;
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "name");
        kotlin.reflect.y.internal.j0.f.f fVarB = aVar.b(name);
        if (fVarB == null) {
            return false;
        }
        Set<y0> setX0 = x0(fVarB);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setX0) {
            if (kotlin.reflect.y.internal.j0.d.a.g0.a((y0) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        y0 y0VarL0 = l0(y0Var, fVarB);
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (q0((y0) it.next(), y0VarL0)) {
                return true;
            }
        }
        return false;
    }

    private final boolean q0(y0 y0Var, y yVar) {
        if (kotlin.reflect.y.internal.j0.d.a.e.n.k(y0Var)) {
            yVar = yVar.a();
        }
        m.e(yVar, "if (superDescriptor.isRe…iginal else subDescriptor");
        return o0(yVar, y0Var);
    }

    private final boolean r0(y0 y0Var) {
        y0 y0VarM0 = m0(y0Var);
        if (y0VarM0 == null) {
            return false;
        }
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "name");
        Set<y0> setX0 = x0(name);
        if ((setX0 instanceof Collection) && setX0.isEmpty()) {
            return false;
        }
        for (y0 y0Var2 : setX0) {
            if (y0Var2.isSuspend() && o0(y0VarM0, y0Var2)) {
                return true;
            }
        }
        return false;
    }

    private final y0 s0(t0 t0Var, String str, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        y0 y0Var;
        kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(str);
        m.e(fVarX, "identifier(getterName)");
        Iterator<T> it = function1.invoke(fVarX).iterator();
        do {
            y0Var = null;
            if (!it.hasNext()) {
                break;
            }
            y0 y0Var2 = (y0) it.next();
            if (y0Var2.f().size() == 0) {
                kotlin.reflect.y.internal.j0.l.t1.e eVar = kotlin.reflect.y.internal.j0.l.t1.e.a;
                kotlin.reflect.y.internal.j0.l.e0 returnType = y0Var2.getReturnType();
                if (returnType == null ? false : eVar.d(returnType, t0Var.getType())) {
                    y0Var = y0Var2;
                }
            }
        } while (y0Var == null);
        return y0Var;
    }

    private final y0 t0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        u0 getter = t0Var.getGetter();
        u0 u0Var = getter != null ? (u0) kotlin.reflect.y.internal.j0.d.a.g0.d(getter) : null;
        String strA = u0Var != null ? kotlin.reflect.y.internal.j0.d.a.i.a.a(u0Var) : null;
        if (strA != null && !kotlin.reflect.y.internal.j0.d.a.g0.f(C(), u0Var)) {
            return s0(t0Var, strA, function1);
        }
        String strK = t0Var.getName().k();
        m.e(strK, "name.asString()");
        return s0(t0Var, z.b(strK), function1);
    }

    private final y0 u0(t0 t0Var, Function1<? super kotlin.reflect.y.internal.j0.f.f, ? extends Collection<? extends y0>> function1) {
        y0 y0Var;
        kotlin.reflect.y.internal.j0.l.e0 returnType;
        String strK = t0Var.getName().k();
        m.e(strK, "name.asString()");
        kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(z.e(strK));
        m.e(fVarX, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = function1.invoke(fVarX).iterator();
        do {
            y0Var = null;
            if (!it.hasNext()) {
                break;
            }
            y0 y0Var2 = (y0) it.next();
            if (y0Var2.f().size() == 1 && (returnType = y0Var2.getReturnType()) != null && kotlin.reflect.y.internal.j0.b.h.B0(returnType)) {
                kotlin.reflect.y.internal.j0.l.t1.e eVar = kotlin.reflect.y.internal.j0.l.t1.e.a;
                List<i1> listF = y0Var2.f();
                m.e(listF, "descriptor.valueParameters");
                if (eVar.b(((i1) s.s0(listF)).getType(), t0Var.getType())) {
                    y0Var = y0Var2;
                }
            }
        } while (y0Var == null);
        return y0Var;
    }

    private final kotlin.p002reflect.jvm.internal.impl.descriptors.u v0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.u visibility = eVar.getVisibility();
        m.e(visibility, "classDescriptor.visibility");
        if (!m.a(visibility, kotlin.reflect.y.internal.j0.d.a.r.f23685b)) {
            return visibility;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.u uVar = kotlin.reflect.y.internal.j0.d.a.r.f23686c;
        m.e(uVar, "PROTECTED_AND_PACKAGE");
        return uVar;
    }

    private final Set<y0> x0(kotlin.reflect.y.internal.j0.f.f fVar) {
        Collection<kotlin.reflect.y.internal.j0.l.e0> collectionB0 = b0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = collectionB0.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.z(linkedHashSet, ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().a(fVar, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    private final Set<t0> z0(kotlin.reflect.y.internal.j0.f.f fVar) {
        Collection<kotlin.reflect.y.internal.j0.l.e0> collectionB0 = b0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionB0.iterator();
        while (it.hasNext()) {
            Collection<? extends t0> collectionC = ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().c(fVar, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(kotlin.collections.v.u(collectionC, 10));
            Iterator<T> it2 = collectionC.iterator();
            while (it2.hasNext()) {
                arrayList2.add((t0) it2.next());
            }
            kotlin.collections.z.z(arrayList, arrayList2);
        }
        return c0.I0(arrayList);
    }

    public void F0(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        kotlin.reflect.y.internal.j0.c.a.a(w().a().l(), bVar, C(), fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected boolean G(kotlin.reflect.y.internal.j0.d.a.k0.e eVar) {
        m.f(eVar, "<this>");
        if (this.o.r()) {
            return false;
        }
        return B0(eVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected kotlin.f0.y.e.j0.d.a.l0.l.j.a H(r rVar, List<? extends e1> list, kotlin.reflect.y.internal.j0.l.e0 e0Var, List<? extends i1> list2) {
        m.f(rVar, "method");
        m.f(list, "methodTypeParameters");
        m.f(e0Var, "returnType");
        m.f(list2, "valueParameters");
        kotlin.f0.y.e.j0.d.a.j0.j.b bVarA = w().a().s().a(rVar, C(), e0Var, null, list2, list);
        m.e(bVarA, "c.components.signaturePr…dTypeParameters\n        )");
        kotlin.reflect.y.internal.j0.l.e0 e0VarD = bVarA.d();
        m.e(e0VarD, "propagated.returnType");
        kotlin.reflect.y.internal.j0.l.e0 e0VarC = bVarA.c();
        List<i1> listF = bVarA.f();
        m.e(listF, "propagated.valueParameters");
        List<e1> listE = bVarA.e();
        m.e(listE, "propagated.typeParameters");
        boolean zG = bVarA.g();
        List<String> listB = bVarA.b();
        m.e(listB, "propagated.errors");
        return new kotlin.f0.y.e.j0.d.a.l0.l.j.a(e0VarD, e0VarC, listF, listE, zG, listB);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<kotlin.reflect.y.internal.j0.f.f> n(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        Collection<kotlin.reflect.y.internal.j0.l.e0> collectionA = C().h().a();
        m.e(collectionA, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<kotlin.reflect.y.internal.j0.f.f> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.z(linkedHashSet, ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().b());
        }
        linkedHashSet.addAll(y().invoke().a());
        linkedHashSet.addAll(y().invoke().d());
        linkedHashSet.addAll(l(dVar, function1));
        linkedHashSet.addAll(w().a().w().d(C()));
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        F0(fVar, bVar);
        return super.a(fVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.d.a.l0.l.a p() {
        return new kotlin.reflect.y.internal.j0.d.a.l0.l.a(this.o, a.f23505f);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j, kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        F0(fVar, bVar);
        return super.c(fVar, bVar);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public kotlin.p002reflect.jvm.internal.impl.descriptors.h f(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.reflect.y.internal.j0.k.h<kotlin.reflect.y.internal.j0.f.f, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g> hVar;
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g gVarInvoke;
        m.f(fVar, "name");
        m.f(bVar, "location");
        F0(fVar, bVar);
        g gVar = (g) B();
        return (gVar == null || (hVar = gVar.t) == null || (gVarInvoke = hVar.invoke(fVar)) == null) ? this.t.invoke(fVar) : gVarInvoke;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<kotlin.reflect.y.internal.j0.f.f> l(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        return x0.l(this.r.invoke(), this.s.invoke().keySet());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void o(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar) {
        m.f(collection, "result");
        m.f(fVar, "name");
        if (this.o.t() && y().invoke().b(fVar) != null) {
            boolean z = true;
            if (!collection.isEmpty()) {
                Iterator<T> it = collection.iterator();
                while (it.hasNext()) {
                    if (((y0) it.next()).f().isEmpty()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                w wVarB = y().invoke().b(fVar);
                m.c(wVarB);
                collection.add(H0(wVarB));
            }
        }
        w().a().w().b(C(), fVar, collection);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void r(Collection<y0> collection, kotlin.reflect.y.internal.j0.f.f fVar) {
        boolean z;
        m.f(collection, "result");
        m.f(fVar, "name");
        Set<y0> setX0 = x0(fVar);
        if (!h0.a.k(fVar) && !kotlin.reflect.y.internal.j0.d.a.f.n.l(fVar)) {
            if (!(setX0 instanceof Collection) || !setX0.isEmpty()) {
                Iterator<T> it = setX0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((y) it.next()).isSuspend()) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            } else {
                z = true;
                break;
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : setX0) {
                    if (B0((y0) obj)) {
                        arrayList.add(obj);
                    }
                }
                V(collection, fVar, arrayList, false);
                return;
            }
        }
        kotlin.p002reflect.jvm.internal.impl.utils.f fVarA = kotlin.p002reflect.jvm.internal.impl.utils.f.f25524f.a();
        Collection<? extends y0> collectionD = kotlin.reflect.y.internal.j0.d.a.j0.a.d(fVar, setX0, u.j(), C(), kotlin.reflect.y.internal.j0.j.b.r.a, w().a().k().a());
        m.e(collectionD, "resolveOverridesForNonSt….overridingUtil\n        )");
        W(fVar, collection, collectionD, collection, new b(this));
        W(fVar, collection, collectionD, fVarA, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setX0) {
            if (B0((y0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        V(collection, fVar, c0.o0(arrayList2, fVarA), true);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected void s(kotlin.reflect.y.internal.j0.f.f fVar, Collection<t0> collection) {
        m.f(fVar, "name");
        m.f(collection, "result");
        if (this.o.r()) {
            Y(fVar, collection);
        }
        Set<t0> setZ0 = z0(fVar);
        if (setZ0.isEmpty()) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.utils.f.b bVar = kotlin.p002reflect.jvm.internal.impl.utils.f.f25524f;
        kotlin.p002reflect.jvm.internal.impl.utils.f fVarA = bVar.a();
        kotlin.p002reflect.jvm.internal.impl.utils.f fVarA2 = bVar.a();
        X(setZ0, collection, fVarA, new d());
        X(x0.j(setZ0, fVarA), fVarA2, null, new e());
        Collection<? extends t0> collectionD = kotlin.reflect.y.internal.j0.d.a.j0.a.d(fVar, x0.l(setZ0, fVarA2), collection, C(), w().a().c(), w().a().k().a());
        m.e(collectionD, "resolveOverridesForNonSt…rridingUtil\n            )");
        collection.addAll(collectionD);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected Set<kotlin.reflect.y.internal.j0.f.f> t(kotlin.reflect.y.internal.j0.i.w.d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        if (this.o.r()) {
            return b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(y().invoke().e());
        Collection<kotlin.reflect.y.internal.j0.l.e0> collectionA = C().h().a();
        m.e(collectionA, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            kotlin.collections.z.z(linkedHashSet, ((kotlin.reflect.y.internal.j0.l.e0) it.next()).q().d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    public String toString() {
        return "Lazy Java member scope for " + this.o.d();
    }

    public final kotlin.reflect.y.internal.j0.k.i<List<kotlin.p002reflect.jvm.internal.impl.descriptors.d>> w0() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public kotlin.p002reflect.jvm.internal.impl.descriptors.e C() {
        return this.n;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.j
    protected w0 z() {
        return kotlin.reflect.y.internal.j0.i.d.l(C());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.d.a.n0.g gVar2, boolean z, g gVar3) {
        super(gVar, gVar3);
        m.f(gVar, "c");
        m.f(eVar, "ownerDescriptor");
        m.f(gVar2, "jClass");
        this.n = eVar;
        this.o = gVar2;
        this.p = z;
        this.q = gVar.e().d(new f(gVar));
        this.r = gVar.e().d(new i());
        this.s = gVar.e().d(new C0333g());
        this.t = gVar.e().i(new j(gVar));
    }
}
