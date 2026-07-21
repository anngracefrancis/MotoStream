package kotlin.reflect.y.internal.j0.b.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.z;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.d.b.u;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.h0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a, kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c {
    static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.b(g.class), "settings", "getSettings()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltIns$Settings;")), g0.h(new y(g0.b(g.class), "cloneableType", "getCloneableType()Lorg/jetbrains/kotlin/types/SimpleType;")), g0.h(new y(g0.b(g.class), "notConsideredDeprecation", "getNotConsideredDeprecation()Lorg/jetbrains/kotlin/descriptors/annotations/Annotations;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.p002reflect.jvm.internal.impl.descriptors.g0 f23279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.b.q.d f23280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e0 f23282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.a<kotlin.reflect.y.internal.j0.f.c, kotlin.p002reflect.jvm.internal.impl.descriptors.e> f23284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23285h;

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    private enum a {
        HIDDEN,
        VISIBLE,
        NOT_CONSIDERED,
        DROP
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.HIDDEN.ordinal()] = 1;
            iArr[a.NOT_CONSIDERED.ordinal()] = 2;
            iArr[a.DROP.ordinal()] = 3;
            iArr[a.VISIBLE.ordinal()] = 4;
            a = iArr;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class c extends Lambda implements Function0<m0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f23292g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(n nVar) {
            super(0);
            this.f23292g = nVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke() {
            return x.c(g.this.s().a(), kotlin.reflect.y.internal.j0.b.q.e.a.a(), new j0(this.f23292g, g.this.s().a())).s();
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final class d extends z {
        d(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, kotlin.reflect.y.internal.j0.f.c cVar) {
            super(g0Var, cVar);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.k0
        /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
        public kotlin.f0.y.e.j0.i.w.h.b q() {
            return kotlin.f0.y.e.j0.i.w.h.b.f24422b;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class e extends Lambda implements Function0<e0> {
        e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            m0 m0VarI = g.this.f23279b.o().i();
            m.e(m0VarI, "moduleDescriptor.builtIns.anyType");
            return m0VarI;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class f extends Lambda implements Function0<kotlin.p002reflect.jvm.internal.impl.descriptors.e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.d.a.l0.l.f f23294f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.p002reflect.jvm.internal.impl.descriptors.e f23295g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
            super(0);
            this.f23294f = fVar;
            this.f23295g = eVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.e invoke() {
            kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar = this.f23294f;
            kotlin.reflect.y.internal.j0.d.a.j0.g gVar = kotlin.reflect.y.internal.j0.d.a.j0.g.a;
            m.e(gVar, "EMPTY");
            return fVar.O0(gVar, this.f23295g);
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.b.q.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class C0325g extends Lambda implements Function1<kotlin.reflect.y.internal.j0.i.w.h, Collection<? extends y0>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.f.f f23296f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0325g(kotlin.reflect.y.internal.j0.f.f fVar) {
            super(1);
            this.f23296f = fVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<y0> invoke(kotlin.reflect.y.internal.j0.i.w.h hVar) {
            m.f(hVar, "it");
            return hVar.a(this.f23296f, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class h<N> implements kotlin.reflect.jvm.internal.impl.utils.b.c {
        h() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.e> a(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
            Collection<e0> collectionA = eVar.h().a();
            m.e(collectionA, "it.typeConstructor.supertypes");
            g gVar = g.this;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = collectionA.iterator();
            while (it.hasNext()) {
                kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = ((e0) it.next()).O0().w();
                kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarA = hVarW != null ? hVarW.a() : null;
                kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar2 = hVarA instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) hVarA : null;
                kotlin.reflect.y.internal.j0.d.a.l0.l.f fVarP = eVar2 != null ? gVar.p(eVar2) : null;
                if (fVarP != null) {
                    arrayList.add(fVarP);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    public static final class i extends kotlin.p002reflect.jvm.internal.impl.utils.b.AbstractC0417b<kotlin.p002reflect.jvm.internal.impl.descriptors.e, a> {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f0<a> f23297b;

        i(String str, f0<a> f0Var) {
            this.a = str;
            this.f23297b = f0Var;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, kotlin.f0.y.e.j0.b.q.g$a] */
        /* JADX WARN: Type inference failed for: r0v5, types: [T, kotlin.f0.y.e.j0.b.q.g$a] */
        /* JADX WARN: Type inference failed for: r0v6, types: [T, kotlin.f0.y.e.j0.b.q.g$a] */
        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean c(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
            m.f(eVar, "javaClassDescriptor");
            String strA = u.a(kotlin.reflect.y.internal.j0.d.b.x.a, eVar, this.a);
            kotlin.reflect.y.internal.j0.b.q.i iVar = kotlin.reflect.y.internal.j0.b.q.i.a;
            if (iVar.e().contains(strA)) {
                this.f23297b.f22943f = a.HIDDEN;
            } else if (iVar.h().contains(strA)) {
                this.f23297b.f22943f = a.VISIBLE;
            } else if (iVar.c().contains(strA)) {
                this.f23297b.f22943f = a.DROP;
            }
            return this.f23297b.f22943f == null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = this.f23297b.f22943f;
            return aVar == null ? a.NOT_CONSIDERED : aVar;
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class j<N> implements kotlin.reflect.jvm.internal.impl.utils.b.c {
        public static final j<N> a = new j<>();

        j() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<kotlin.p002reflect.jvm.internal.impl.descriptors.b> a(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            return bVar.a().e();
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class k extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, Boolean> {
        k() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0021  */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            boolean z;
            if (bVar.i() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION) {
                kotlin.reflect.y.internal.j0.b.q.d dVar = g.this.f23280c;
                kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = bVar.b();
                m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (dVar.c((kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB)) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
    static final class l extends Lambda implements Function0<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g> {
        l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g invoke() {
            return kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.a(t.e(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.f.b(g.this.f23279b.o(), "This member is not fully supported by Kotlin compiler, so it may be absent or have different signature in next major version", null, null, 6, null)));
        }
    }

    public g(kotlin.p002reflect.jvm.internal.impl.descriptors.g0 g0Var, n nVar, Function0<kotlin.f0.y.e.j0.b.q.f.b> function0) {
        m.f(g0Var, "moduleDescriptor");
        m.f(nVar, "storageManager");
        m.f(function0, "settingsComputation");
        this.f23279b = g0Var;
        this.f23280c = kotlin.reflect.y.internal.j0.b.q.d.a;
        this.f23281d = nVar.d(function0);
        this.f23282e = k(nVar);
        this.f23283f = nVar.d(new c(nVar));
        this.f23284g = nVar.b();
        this.f23285h = nVar.d(new l());
    }

    private final y0 j(kotlin.reflect.y.internal.j0.j.b.g0.d dVar, y0 y0Var) {
        kotlin.reflect.jvm.internal.impl.descriptors.y.a<? extends y0> aVarU = y0Var.u();
        aVarU.p(dVar);
        aVarU.o(kotlin.p002reflect.jvm.internal.impl.descriptors.t.f25368e);
        aVarU.g(dVar.s());
        aVarU.e(dVar.K0());
        kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarC = aVarU.c();
        m.c(yVarC);
        return (y0) yVarC;
    }

    private final e0 k(n nVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.h hVar = new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.h(new d(this.f23279b, new kotlin.reflect.y.internal.j0.f.c("java.io")), kotlin.reflect.y.internal.j0.f.f.x("Serializable"), d0.ABSTRACT, kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE, t.e(new h0(nVar, new e())), z0.a, false, nVar);
        hVar.L0(kotlin.f0.y.e.j0.i.w.h.b.f24422b, w0.d(), null);
        m0 m0VarS = hVar.s();
        m.e(m0VarS, "mockSerializableClass.defaultType");
        return m0VarS;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0097  */
    private final Collection<y0> l(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, Function1<? super kotlin.reflect.y.internal.j0.i.w.h, ? extends Collection<? extends y0>> function1) {
        boolean z;
        boolean z2;
        kotlin.reflect.y.internal.j0.d.a.l0.l.f fVarP = p(eVar);
        if (fVarP == null) {
            return kotlin.collections.u.j();
        }
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.e> collectionG = this.f23280c.g(kotlin.reflect.y.internal.j0.i.t.a.h(fVarP), kotlin.reflect.y.internal.j0.b.q.b.f23241h.a());
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar2 = (kotlin.p002reflect.jvm.internal.impl.descriptors.e) s.h0(collectionG);
        if (eVar2 == null) {
            return kotlin.collections.u.j();
        }
        kotlin.reflect.jvm.internal.impl.utils.f.b bVar = kotlin.p002reflect.jvm.internal.impl.utils.f.f25524f;
        ArrayList arrayList = new ArrayList(v.u(collectionG, 10));
        Iterator<T> it = collectionG.iterator();
        while (it.hasNext()) {
            arrayList.add(kotlin.reflect.y.internal.j0.i.t.a.h((kotlin.p002reflect.jvm.internal.impl.descriptors.e) it.next()));
        }
        kotlin.p002reflect.jvm.internal.impl.utils.f fVarB = bVar.b(arrayList);
        boolean zC = this.f23280c.c(eVar);
        kotlin.reflect.y.internal.j0.i.w.h hVarD0 = this.f23284g.b(kotlin.reflect.y.internal.j0.i.t.a.h(fVarP), new f(fVarP, eVar2)).D0();
        m.e(hVarD0, "fakeJavaClassDescriptor.unsubstitutedMemberScope");
        Collection<? extends y0> collectionInvoke = function1.invoke(hVarD0);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionInvoke) {
            y0 y0Var = (y0) obj;
            if (y0Var.i() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION && y0Var.getVisibility().d() && !kotlin.reflect.y.internal.j0.b.h.j0(y0Var)) {
                Collection<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.y> collectionE = y0Var.e();
                m.e(collectionE, "analogueMember.overriddenDescriptors");
                if (!(collectionE instanceof Collection) || !collectionE.isEmpty()) {
                    Iterator<T> it2 = collectionE.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = false;
                            break;
                        }
                        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = ((kotlin.p002reflect.jvm.internal.impl.descriptors.y) it2.next()).b();
                        m.e(mVarB, "it.containingDeclaration");
                        if (fVarB.contains(kotlin.reflect.y.internal.j0.i.t.a.h(mVarB))) {
                            z = true;
                            break;
                        }
                    }
                } else {
                    z = false;
                    break;
                }
                z2 = (z || t(y0Var, zC)) ? false : true;
            }
            if (z2) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final m0 m() {
        return (m0) kotlin.reflect.y.internal.j0.k.m.a(this.f23283f, this, a[1]);
    }

    private static final boolean n(kotlin.p002reflect.jvm.internal.impl.descriptors.l lVar, l1 l1Var, kotlin.p002reflect.jvm.internal.impl.descriptors.l lVar2) {
        return kotlin.reflect.y.internal.j0.i.j.x(lVar, lVar2.c(l1Var)) == kotlin.f0.y.e.j0.i.j.i.a.OVERRIDABLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.y.internal.j0.d.a.l0.l.f p(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.reflect.y.internal.j0.f.b bVarN;
        kotlin.reflect.y.internal.j0.f.c cVarB;
        if (kotlin.reflect.y.internal.j0.b.h.a0(eVar) || !kotlin.reflect.y.internal.j0.b.h.A0(eVar)) {
            return null;
        }
        kotlin.reflect.y.internal.j0.f.d dVarI = kotlin.reflect.y.internal.j0.i.t.a.i(eVar);
        if (!dVarI.f() || (bVarN = kotlin.reflect.y.internal.j0.b.q.c.a.n(dVarI)) == null || (cVarB = bVarN.b()) == null) {
            return null;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarC = kotlin.p002reflect.jvm.internal.impl.descriptors.s.c(s().a(), cVarB, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
        if (eVarC instanceof kotlin.reflect.y.internal.j0.d.a.l0.l.f) {
            return (kotlin.reflect.y.internal.j0.d.a.l0.l.f) eVarC;
        }
        return null;
    }

    private final a q(kotlin.p002reflect.jvm.internal.impl.descriptors.y yVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = yVar.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        Object objB = kotlin.p002reflect.jvm.internal.impl.utils.b.b(t.e((kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB), new h(), new i(kotlin.reflect.y.internal.j0.d.b.v.c(yVar, false, false, 3, null), new f0()));
        m.e(objB, "private fun FunctionDesc…ERED\n            })\n    }");
        return (a) objB;
    }

    private final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g r() {
        return (kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g) kotlin.reflect.y.internal.j0.k.m.a(this.f23285h, this, a[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.f0.y.e.j0.b.q.f.b s() {
        return (kotlin.f0.y.e.j0.b.q.f.b) kotlin.reflect.y.internal.j0.k.m.a(this.f23281d, this, a[0]);
    }

    private final boolean t(y0 y0Var, boolean z) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = y0Var.b();
        m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        String strC = kotlin.reflect.y.internal.j0.d.b.v.c(y0Var, false, false, 3, null);
        if (z ^ kotlin.reflect.y.internal.j0.b.q.i.a.f().contains(u.a(kotlin.reflect.y.internal.j0.d.b.x.a, (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB, strC))) {
            return true;
        }
        Boolean boolE = kotlin.p002reflect.jvm.internal.impl.utils.b.e(t.e(y0Var), j.a, new k());
        m.e(boolE, "private fun SimpleFuncti…scriptor)\n        }\n    }");
        return boolE.booleanValue();
    }

    private final boolean u(kotlin.p002reflect.jvm.internal.impl.descriptors.l lVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        if (lVar.f().size() == 1) {
            List<i1> listF = lVar.f();
            m.e(listF, "valueParameters");
            kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = ((i1) s.s0(listF)).getType().O0().w();
            if (m.a(hVarW != null ? kotlin.reflect.y.internal.j0.i.t.a.i(hVarW) : null, kotlin.reflect.y.internal.j0.i.t.a.i(eVar))) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> a(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarF;
        boolean z;
        m.f(eVar, "classDescriptor");
        if (eVar.i() != kotlin.p002reflect.jvm.internal.impl.descriptors.f.CLASS || !s().b()) {
            return kotlin.collections.u.j();
        }
        kotlin.reflect.y.internal.j0.d.a.l0.l.f fVarP = p(eVar);
        if (fVarP != null && (eVarF = kotlin.reflect.y.internal.j0.b.q.d.f(this.f23280c, kotlin.reflect.y.internal.j0.i.t.a.h(fVarP), kotlin.reflect.y.internal.j0.b.q.b.f23241h.a(), null, 4, null)) != null) {
            l1 l1VarC = kotlin.reflect.y.internal.j0.b.q.j.a(eVarF, fVarP).c();
            List<kotlin.p002reflect.jvm.internal.impl.descriptors.d> listK = fVarP.k();
            ArrayList<kotlin.p002reflect.jvm.internal.impl.descriptors.d> arrayList = new ArrayList();
            Iterator<T> it = listK.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                kotlin.p002reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.d) next;
                if (dVar.getVisibility().d()) {
                    Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> collectionK = eVarF.k();
                    m.e(collectionK, "defaultKotlinVersion.constructors");
                    if (!(collectionK instanceof Collection) || !collectionK.isEmpty()) {
                        Iterator<T> it2 = collectionK.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = true;
                                break;
                            }
                            kotlin.p002reflect.jvm.internal.impl.descriptors.d dVar2 = (kotlin.p002reflect.jvm.internal.impl.descriptors.d) it2.next();
                            m.e(dVar2, "it");
                            if (n(dVar2, l1VarC, dVar)) {
                                z = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    if (z && !u(dVar, eVar) && !kotlin.reflect.y.internal.j0.b.h.j0(dVar) && !kotlin.reflect.y.internal.j0.b.q.i.a.d().contains(u.a(kotlin.reflect.y.internal.j0.d.b.x.a, fVarP, kotlin.reflect.y.internal.j0.d.b.v.c(dVar, false, false, 3, null)))) {
                        z2 = true;
                    }
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(v.u(arrayList, 10));
            for (kotlin.p002reflect.jvm.internal.impl.descriptors.d dVar3 : arrayList) {
                kotlin.reflect.jvm.internal.impl.descriptors.y.a<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.y> aVarU = dVar3.u();
                aVarU.p(eVar);
                aVarU.g(eVar.s());
                aVarU.f();
                aVarU.l(l1VarC.j());
                if (!kotlin.reflect.y.internal.j0.b.q.i.a.g().contains(u.a(kotlin.reflect.y.internal.j0.d.b.x.a, fVarP, kotlin.reflect.y.internal.j0.d.b.v.c(dVar3, false, false, 3, null)))) {
                    aVarU.s(r());
                }
                kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarC = aVarU.c();
                m.d(yVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassConstructorDescriptor");
                arrayList2.add((kotlin.p002reflect.jvm.internal.impl.descriptors.d) yVarC);
            }
            return arrayList2;
        }
        return kotlin.collections.u.j();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
    public Collection<y0> b(kotlin.reflect.y.internal.j0.f.f fVar, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        m.f(fVar, "name");
        m.f(eVar, "classDescriptor");
        boolean z = true;
        if (m.a(fVar, kotlin.reflect.y.internal.j0.b.q.a.f23239e.a()) && (eVar instanceof kotlin.reflect.y.internal.j0.j.b.g0.d) && kotlin.reflect.y.internal.j0.b.h.d0(eVar)) {
            kotlin.reflect.y.internal.j0.j.b.g0.d dVar = (kotlin.reflect.y.internal.j0.j.b.g0.d) eVar;
            List<kotlin.reflect.y.internal.j0.e.i> listI0 = dVar.c1().I0();
            m.e(listI0, "classDescriptor.classProto.functionList");
            if ((listI0 instanceof Collection) && listI0.isEmpty()) {
                z = false;
            } else {
                Iterator<T> it = listI0.iterator();
                while (it.hasNext()) {
                    if (m.a(kotlin.reflect.y.internal.j0.j.b.x.b(dVar.b1().g(), ((kotlin.reflect.y.internal.j0.e.i) it.next()).e0()), kotlin.reflect.y.internal.j0.b.q.a.f23239e.a())) {
                    }
                }
                z = false;
            }
            return z ? kotlin.collections.u.j() : t.e(j(dVar, (y0) s.r0(m().q().a(fVar, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS))));
        }
        if (!s().b()) {
            return kotlin.collections.u.j();
        }
        Collection<y0> collectionL = l(eVar, new C0325g(fVar));
        ArrayList arrayList = new ArrayList();
        for (y0 y0Var : collectionL) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = y0Var.b();
            m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarC = y0Var.c(kotlin.reflect.y.internal.j0.b.q.j.a((kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB, eVar).c());
            m.d(yVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.SimpleFunctionDescriptor");
            kotlin.reflect.jvm.internal.impl.descriptors.y.a<? extends y0> aVarU = ((y0) yVarC).u();
            aVarU.p(eVar);
            aVarU.e(eVar.K0());
            aVarU.f();
            int i2 = b.a[q(y0Var).ordinal()];
            y0 y0Var2 = null;
            if (i2 != 1) {
                if (i2 == 2) {
                    aVarU.s(r());
                } else if (i2 != 3) {
                }
                kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarC2 = aVarU.c();
                m.c(yVarC2);
                y0Var2 = (y0) yVarC2;
            } else if (!kotlin.p002reflect.jvm.internal.impl.descriptors.e0.a(eVar)) {
                aVarU.i();
                kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarC3 = aVarU.c();
                m.c(yVarC3);
                y0Var2 = (y0) yVarC3;
            }
            if (y0Var2 != null) {
                arrayList.add(y0Var2);
            }
        }
        return arrayList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.c
    public boolean c(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, y0 y0Var) {
        m.f(eVar, "classDescriptor");
        m.f(y0Var, "functionDescriptor");
        kotlin.reflect.y.internal.j0.d.a.l0.l.f fVarP = p(eVar);
        if (fVarP == null || !y0Var.getAnnotations().R0(kotlin.p002reflect.jvm.internal.impl.descriptors.o1.d.a())) {
            return true;
        }
        if (!s().b()) {
            return false;
        }
        String strC = kotlin.reflect.y.internal.j0.d.b.v.c(y0Var, false, false, 3, null);
        kotlin.reflect.y.internal.j0.d.a.l0.l.g gVarD0 = fVarP.D0();
        kotlin.reflect.y.internal.j0.f.f name = y0Var.getName();
        m.e(name, "functionDescriptor.name");
        Collection<y0> collectionA = gVarD0.a(name, kotlin.reflect.y.internal.j0.c.b.d.FROM_BUILTINS);
        if (!(collectionA instanceof Collection) || !collectionA.isEmpty()) {
            Iterator<T> it = collectionA.iterator();
            while (it.hasNext()) {
                if (m.a(kotlin.reflect.y.internal.j0.d.b.v.c((y0) it.next(), false, false, 3, null), strC)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
    public Collection<e0> d(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        m.f(eVar, "classDescriptor");
        kotlin.reflect.y.internal.j0.f.d dVarI = kotlin.reflect.y.internal.j0.i.t.a.i(eVar);
        kotlin.reflect.y.internal.j0.b.q.i iVar = kotlin.reflect.y.internal.j0.b.q.i.a;
        if (!iVar.i(dVarI)) {
            return iVar.j(dVarI) ? t.e(this.f23282e) : kotlin.collections.u.j();
        }
        m0 m0VarM = m();
        m.e(m0VarM, "cloneableType");
        return kotlin.collections.u.m(m0VarM, this.f23282e);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.a
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Set<kotlin.reflect.y.internal.j0.f.f> e(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.reflect.y.internal.j0.d.a.l0.l.g gVarD0;
        Set<kotlin.reflect.y.internal.j0.f.f> setB;
        m.f(eVar, "classDescriptor");
        if (!s().b()) {
            return w0.d();
        }
        kotlin.reflect.y.internal.j0.d.a.l0.l.f fVarP = p(eVar);
        return (fVarP == null || (gVarD0 = fVarP.D0()) == null || (setB = gVarD0.b()) == null) ? w0.d() : setB;
    }
}
