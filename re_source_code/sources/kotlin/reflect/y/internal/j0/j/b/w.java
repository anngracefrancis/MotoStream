package kotlin.reflect.y.internal.j0.j.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.p002reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.r;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.x;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.j.b.g0.k;
import kotlin.reflect.y.internal.j0.j.b.g0.l;
import kotlin.reflect.y.internal.j0.k.j;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: MemberDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    private final m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.j.b.e f24607b;

    /* JADX INFO: compiled from: MemberDeserializer.kt */
    static final class a extends Lambda implements Function0<List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ o f24609g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.j.b.b f24610h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
            super(0);
            this.f24609g = oVar;
            this.f24610h = bVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> invoke() {
            List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> listE0;
            w wVar = w.this;
            z zVarC = wVar.c(wVar.a.e());
            if (zVarC != null) {
                listE0 = c0.E0(w.this.a.c().d().j(zVarC, this.f24609g, this.f24610h));
            } else {
                listE0 = null;
            }
            return listE0 == null ? u.j() : listE0;
        }
    }

    /* JADX INFO: compiled from: MemberDeserializer.kt */
    static final class b extends Lambda implements Function0<List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f24612g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ n f24613h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z, n nVar) {
            super(0);
            this.f24612g = z;
            this.f24613h = nVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> invoke() {
            List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> listE0;
            w wVar = w.this;
            z zVarC = wVar.c(wVar.a.e());
            if (zVarC != null) {
                boolean z = this.f24612g;
                w wVar2 = w.this;
                n nVar = this.f24613h;
                listE0 = z ? c0.E0(wVar2.a.c().d().i(zVarC, nVar)) : c0.E0(wVar2.a.c().d().g(zVarC, nVar));
            } else {
                listE0 = null;
            }
            return listE0 == null ? u.j() : listE0;
        }
    }

    /* JADX INFO: compiled from: MemberDeserializer.kt */
    static final class c extends Lambda implements Function0<List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ o f24615g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.j.b.b f24616h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
            super(0);
            this.f24615g = oVar;
            this.f24616h = bVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> invoke() {
            List<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> listH;
            w wVar = w.this;
            z zVarC = wVar.c(wVar.a.e());
            if (zVarC != null) {
                listH = w.this.a.c().d().h(zVarC, this.f24615g, this.f24616h);
            } else {
                listH = null;
            }
            return listH == null ? u.j() : listH;
        }
    }

    /* JADX INFO: compiled from: MemberDeserializer.kt */
    static final class d extends Lambda implements Function0<j<? extends g<?>>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f24618g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.j.b.g0.j f24619h;

        /* JADX INFO: compiled from: MemberDeserializer.kt */
        static final class a extends Lambda implements Function0<g<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ w f24620f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ n f24621g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.y.internal.j0.j.b.g0.j f24622h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(w wVar, n nVar, kotlin.reflect.y.internal.j0.j.b.g0.j jVar) {
                super(0);
                this.f24620f = wVar;
                this.f24621g = nVar;
                this.f24622h = jVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final g<?> invoke() {
                w wVar = this.f24620f;
                z zVarC = wVar.c(wVar.a.e());
                m.c(zVarC);
                kotlin.reflect.y.internal.j0.j.b.c<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c, g<?>> cVarD = this.f24620f.a.c().d();
                n nVar = this.f24621g;
                e0 returnType = this.f24622h.getReturnType();
                m.e(returnType, "property.returnType");
                return cVarD.e(zVarC, nVar, returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(n nVar, kotlin.reflect.y.internal.j0.j.b.g0.j jVar) {
            super(0);
            this.f24618g = nVar;
            this.f24619h = jVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final j<g<?>> invoke() {
            return w.this.a.h().f(new a(w.this, this.f24618g, this.f24619h));
        }
    }

    /* JADX INFO: compiled from: MemberDeserializer.kt */
    static final class e extends Lambda implements Function0<j<? extends g<?>>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f24624g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.j.b.g0.j f24625h;

        /* JADX INFO: compiled from: MemberDeserializer.kt */
        static final class a extends Lambda implements Function0<g<?>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ w f24626f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ n f24627g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.y.internal.j0.j.b.g0.j f24628h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(w wVar, n nVar, kotlin.reflect.y.internal.j0.j.b.g0.j jVar) {
                super(0);
                this.f24626f = wVar;
                this.f24627g = nVar;
                this.f24628h = jVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final g<?> invoke() {
                w wVar = this.f24626f;
                z zVarC = wVar.c(wVar.a.e());
                m.c(zVarC);
                kotlin.reflect.y.internal.j0.j.b.c<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c, g<?>> cVarD = this.f24626f.a.c().d();
                n nVar = this.f24627g;
                e0 returnType = this.f24628h.getReturnType();
                m.e(returnType, "property.returnType");
                return cVarD.k(zVarC, nVar, returnType);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(n nVar, kotlin.reflect.y.internal.j0.j.b.g0.j jVar) {
            super(0);
            this.f24624g = nVar;
            this.f24625h = jVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final j<g<?>> invoke() {
            return w.this.a.h().f(new a(w.this, this.f24624g, this.f24625h));
        }
    }

    /* JADX INFO: compiled from: MemberDeserializer.kt */
    static final class f extends Lambda implements Function0<List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ z f24630g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ o f24631h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.j.b.b f24632i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ int f24633j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.e.u f24634k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(z zVar, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar, int i2, kotlin.reflect.y.internal.j0.e.u uVar) {
            super(0);
            this.f24630g = zVar;
            this.f24631h = oVar;
            this.f24632i = bVar;
            this.f24633j = i2;
            this.f24634k = uVar;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c> invoke() {
            return c0.E0(w.this.a.c().d().b(this.f24630g, this.f24631h, this.f24632i, this.f24633j, this.f24634k));
        }
    }

    public w(m mVar) {
        m.f(mVar, "c");
        this.a = mVar;
        this.f24607b = new kotlin.reflect.y.internal.j0.j.b.e(mVar.c().p(), mVar.c().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final z c(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        if (mVar instanceof k0) {
            return new z.b(((k0) mVar).d(), this.a.g(), this.a.j(), this.a.d());
        }
        if (mVar instanceof kotlin.reflect.y.internal.j0.j.b.g0.d) {
            return ((kotlin.reflect.y.internal.j0.j.b.g0.d) mVar).g1();
        }
        return null;
    }

    private final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g d(o oVar, int i2, kotlin.reflect.y.internal.j0.j.b.b bVar) {
        return !kotlin.reflect.y.internal.j0.e.z.b.f24183c.d(i2).booleanValue() ? kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b() : new kotlin.reflect.y.internal.j0.j.b.g0.n(this.a.h(), new a(oVar, bVar));
    }

    private final w0 e() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarE = this.a.e();
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = mVarE instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarE : null;
        if (eVar != null) {
            return eVar.K0();
        }
        return null;
    }

    private final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g f(n nVar, boolean z) {
        return !kotlin.reflect.y.internal.j0.e.z.b.f24183c.d(nVar.b0()).booleanValue() ? kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b() : new kotlin.reflect.y.internal.j0.j.b.g0.n(this.a.h(), new b(z, nVar));
    }

    private final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g g(o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
        return new kotlin.reflect.y.internal.j0.j.b.g0.a(this.a.h(), new c(oVar, bVar));
    }

    private final void h(k kVar, w0 w0Var, w0 w0Var2, List<? extends w0> list, List<? extends e1> list2, List<? extends i1> list3, e0 e0Var, d0 d0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.u uVar, Map<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, ?> map) {
        kVar.p1(w0Var, w0Var2, list, list2, list3, e0Var, d0Var, uVar, map);
    }

    private final int k(int i2) {
        return (i2 & 63) + ((i2 >> 8) << 6);
    }

    private final w0 n(q qVar, m mVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar) {
        return kotlin.reflect.y.internal.j0.i.c.b(aVar, mVar.i().q(qVar), kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b());
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0083  */
    private final List<i1> o(List<kotlin.reflect.y.internal.j0.e.u> list, o oVar, kotlin.reflect.y.internal.j0.j.b.b bVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarB;
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarE = this.a.e();
        m.d(mVarE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.a) mVarE;
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = aVar.b();
        m.e(mVarB, "callableDescriptor.containingDeclaration");
        z zVarC = c(mVarB);
        ArrayList arrayList = new ArrayList(v.u(list, 10));
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                u.t();
            }
            kotlin.reflect.y.internal.j0.e.u uVar = (kotlin.reflect.y.internal.j0.e.u) obj;
            int iK = uVar.Q() ? uVar.K() : 0;
            if (zVarC != null) {
                Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.f24183c.d(iK);
                m.e(boolD, "HAS_ANNOTATIONS.get(flags)");
                if (boolD.booleanValue()) {
                    gVarB = new kotlin.reflect.y.internal.j0.j.b.g0.n(this.a.h(), new f(zVarC, oVar, bVar, i2, uVar));
                } else {
                    gVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
                }
            } else {
                gVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
            }
            kotlin.reflect.y.internal.j0.f.f fVarB = x.b(this.a.g(), uVar.L());
            e0 e0VarQ = this.a.i().q(kotlin.reflect.y.internal.j0.e.z.f.n(uVar, this.a.j()));
            Boolean boolD2 = kotlin.reflect.y.internal.j0.e.z.b.G.d(iK);
            m.e(boolD2, "DECLARES_DEFAULT_VALUE.get(flags)");
            boolean zBooleanValue = boolD2.booleanValue();
            Boolean boolD3 = kotlin.reflect.y.internal.j0.e.z.b.H.d(iK);
            m.e(boolD3, "IS_CROSSINLINE.get(flags)");
            boolean zBooleanValue2 = boolD3.booleanValue();
            Boolean boolD4 = kotlin.reflect.y.internal.j0.e.z.b.I.d(iK);
            m.e(boolD4, "IS_NOINLINE.get(flags)");
            boolean zBooleanValue3 = boolD4.booleanValue();
            q qVarQ = kotlin.reflect.y.internal.j0.e.z.f.q(uVar, this.a.j());
            e0 e0VarQ2 = qVarQ != null ? this.a.i().q(qVarQ) : null;
            z0 z0Var = z0.a;
            m.e(z0Var, "NO_SOURCE");
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new l0(aVar, null, i2, gVarB, fVarB, e0VarQ, zBooleanValue, zBooleanValue2, zBooleanValue3, e0VarQ2, z0Var));
            arrayList = arrayList2;
            i2 = i3;
        }
        return c0.E0(arrayList);
    }

    public final kotlin.p002reflect.jvm.internal.impl.descriptors.d i(kotlin.reflect.y.internal.j0.e.d dVar, boolean z) {
        m.f(dVar, "proto");
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarE = this.a.e();
        m.d(mVarE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarE;
        int iJ = dVar.J();
        kotlin.reflect.y.internal.j0.j.b.b bVar = kotlin.reflect.y.internal.j0.j.b.b.FUNCTION;
        kotlin.reflect.y.internal.j0.j.b.g0.c cVar = new kotlin.reflect.y.internal.j0.j.b.g0.c(eVar, null, d(dVar, iJ, bVar), z, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, dVar, this.a.g(), this.a.j(), this.a.k(), this.a.d(), null, 1024, null);
        w wVarF = m.b(this.a, cVar, u.j(), null, null, null, null, 60, null).f();
        List<kotlin.reflect.y.internal.j0.e.u> listM = dVar.M();
        m.e(listM, "proto.valueParameterList");
        cVar.r1(wVarF.o(listM, dVar, bVar), b0.a(a0.a, kotlin.reflect.y.internal.j0.e.z.b.f24184d.d(dVar.J())));
        cVar.h1(eVar.s());
        cVar.X0(eVar.M());
        cVar.Z0(!kotlin.reflect.y.internal.j0.e.z.b.n.d(dVar.J()).booleanValue());
        return cVar;
    }

    public final y0 j(i iVar) {
        e0 e0VarQ;
        m.f(iVar, "proto");
        int iD0 = iVar.t0() ? iVar.d0() : k(iVar.f0());
        kotlin.reflect.y.internal.j0.j.b.b bVar = kotlin.reflect.y.internal.j0.j.b.b.FUNCTION;
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarD = d(iVar, iD0, bVar);
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarG = kotlin.reflect.y.internal.j0.e.z.f.d(iVar) ? g(iVar, bVar) : kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        k kVar = new k(this.a.e(), null, gVarD, x.b(this.a.g(), iVar.e0()), b0.b(a0.a, kotlin.reflect.y.internal.j0.e.z.b.o.d(iD0)), iVar, this.a.g(), this.a.j(), m.a(kotlin.reflect.y.internal.j0.i.t.a.h(this.a.e()).c(x.b(this.a.g(), iVar.e0())), c0.a) ? h.a.b() : this.a.k(), this.a.d(), null, 1024, null);
        m mVar = this.a;
        List<s> listM0 = iVar.m0();
        m.e(listM0, "proto.typeParameterList");
        m mVarB = m.b(mVar, kVar, listM0, null, null, null, null, 60, null);
        q qVarH = kotlin.reflect.y.internal.j0.e.z.f.h(iVar, this.a.j());
        w0 w0VarH = (qVarH == null || (e0VarQ = mVarB.i().q(qVarH)) == null) ? null : kotlin.reflect.y.internal.j0.i.c.h(kVar, e0VarQ, gVarG);
        w0 w0VarE = e();
        List<q> listZ = iVar.Z();
        m.e(listZ, "proto.contextReceiverTypeList");
        List<? extends w0> arrayList = new ArrayList<>();
        for (q qVar : listZ) {
            m.e(qVar, "it");
            w0 w0VarN = n(qVar, mVarB, kVar);
            if (w0VarN != null) {
                arrayList.add(w0VarN);
            }
        }
        List<e1> listJ = mVarB.i().j();
        w wVarF = mVarB.f();
        List<kotlin.reflect.y.internal.j0.e.u> listQ0 = iVar.q0();
        m.e(listQ0, "proto.valueParameterList");
        List<i1> listO = wVarF.o(listQ0, iVar, kotlin.reflect.y.internal.j0.j.b.b.FUNCTION);
        e0 e0VarQ2 = mVarB.i().q(kotlin.reflect.y.internal.j0.e.z.f.j(iVar, this.a.j()));
        a0 a0Var = a0.a;
        h(kVar, w0VarH, w0VarE, arrayList, listJ, listO, e0VarQ2, a0Var.b(kotlin.reflect.y.internal.j0.e.z.b.f24185e.d(iD0)), b0.a(a0Var, kotlin.reflect.y.internal.j0.e.z.b.f24184d.d(iD0)), q0.i());
        Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.p.d(iD0);
        m.e(boolD, "IS_OPERATOR.get(flags)");
        kVar.g1(boolD.booleanValue());
        Boolean boolD2 = kotlin.reflect.y.internal.j0.e.z.b.q.d(iD0);
        m.e(boolD2, "IS_INFIX.get(flags)");
        kVar.d1(boolD2.booleanValue());
        Boolean boolD3 = kotlin.reflect.y.internal.j0.e.z.b.t.d(iD0);
        m.e(boolD3, "IS_EXTERNAL_FUNCTION.get(flags)");
        kVar.Y0(boolD3.booleanValue());
        Boolean boolD4 = kotlin.reflect.y.internal.j0.e.z.b.r.d(iD0);
        m.e(boolD4, "IS_INLINE.get(flags)");
        kVar.f1(boolD4.booleanValue());
        Boolean boolD5 = kotlin.reflect.y.internal.j0.e.z.b.s.d(iD0);
        m.e(boolD5, "IS_TAILREC.get(flags)");
        kVar.j1(boolD5.booleanValue());
        Boolean boolD6 = kotlin.reflect.y.internal.j0.e.z.b.u.d(iD0);
        m.e(boolD6, "IS_SUSPEND.get(flags)");
        kVar.i1(boolD6.booleanValue());
        Boolean boolD7 = kotlin.reflect.y.internal.j0.e.z.b.v.d(iD0);
        m.e(boolD7, "IS_EXPECT_FUNCTION.get(flags)");
        kVar.X0(boolD7.booleanValue());
        kVar.Z0(!kotlin.reflect.y.internal.j0.e.z.b.w.d(iD0).booleanValue());
        Pair<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, Object> pairA = this.a.c().h().a(iVar, kVar, this.a.j(), mVarB.i());
        if (pairA != null) {
            kVar.V0(pairA.c(), pairA.d());
        }
        return kVar;
    }

    public final t0 l(n nVar) {
        n nVar2;
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarB;
        kotlin.reflect.y.internal.j0.j.b.g0.j jVar;
        w0 w0VarH;
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.d0 d0Var;
        kotlin.reflect.y.internal.j0.j.b.g0.j jVar2;
        n nVar3;
        boolean z;
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0 e0VarE;
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.d0 d0VarD;
        e0 e0VarQ;
        m.f(nVar, "proto");
        int iB0 = nVar.p0() ? nVar.b0() : k(nVar.e0());
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarE = this.a.e();
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarD = d(nVar, iB0, kotlin.reflect.y.internal.j0.j.b.b.PROPERTY);
        a0 a0Var = a0.a;
        d0 d0VarB = a0Var.b(kotlin.reflect.y.internal.j0.e.z.b.f24185e.d(iB0));
        kotlin.p002reflect.jvm.internal.impl.descriptors.u uVarA = b0.a(a0Var, kotlin.reflect.y.internal.j0.e.z.b.f24184d.d(iB0));
        Boolean boolD = kotlin.reflect.y.internal.j0.e.z.b.x.d(iB0);
        m.e(boolD, "IS_VAR.get(flags)");
        boolean zBooleanValue = boolD.booleanValue();
        kotlin.reflect.y.internal.j0.f.f fVarB = x.b(this.a.g(), nVar.d0());
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVarB = b0.b(a0Var, kotlin.reflect.y.internal.j0.e.z.b.o.d(iB0));
        Boolean boolD2 = kotlin.reflect.y.internal.j0.e.z.b.B.d(iB0);
        m.e(boolD2, "IS_LATEINIT.get(flags)");
        boolean zBooleanValue2 = boolD2.booleanValue();
        Boolean boolD3 = kotlin.reflect.y.internal.j0.e.z.b.A.d(iB0);
        m.e(boolD3, "IS_CONST.get(flags)");
        boolean zBooleanValue3 = boolD3.booleanValue();
        Boolean boolD4 = kotlin.reflect.y.internal.j0.e.z.b.D.d(iB0);
        m.e(boolD4, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean zBooleanValue4 = boolD4.booleanValue();
        Boolean boolD5 = kotlin.reflect.y.internal.j0.e.z.b.E.d(iB0);
        m.e(boolD5, "IS_DELEGATED.get(flags)");
        boolean zBooleanValue5 = boolD5.booleanValue();
        Boolean boolD6 = kotlin.reflect.y.internal.j0.e.z.b.F.d(iB0);
        m.e(boolD6, "IS_EXPECT_PROPERTY.get(flags)");
        kotlin.reflect.y.internal.j0.j.b.g0.j jVar3 = new kotlin.reflect.y.internal.j0.j.b.g0.j(mVarE, null, gVarD, d0VarB, uVarA, zBooleanValue, fVarB, aVarB, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, boolD6.booleanValue(), nVar, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        m mVar = this.a;
        List<s> listN0 = nVar.n0();
        m.e(listN0, "proto.typeParameterList");
        m mVarB = m.b(mVar, jVar3, listN0, null, null, null, null, 60, null);
        Boolean boolD7 = kotlin.reflect.y.internal.j0.e.z.b.y.d(iB0);
        m.e(boolD7, "HAS_GETTER.get(flags)");
        boolean zBooleanValue6 = boolD7.booleanValue();
        if (zBooleanValue6 && kotlin.reflect.y.internal.j0.e.z.f.e(nVar)) {
            nVar2 = nVar;
            gVarB = g(nVar2, kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_GETTER);
        } else {
            nVar2 = nVar;
            gVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        }
        e0 e0VarQ2 = mVarB.i().q(kotlin.reflect.y.internal.j0.e.z.f.k(nVar2, this.a.j()));
        List<e1> listJ = mVarB.i().j();
        w0 w0VarE = e();
        q qVarI = kotlin.reflect.y.internal.j0.e.z.f.i(nVar2, this.a.j());
        if (qVarI == null || (e0VarQ = mVarB.i().q(qVarI)) == null) {
            jVar = jVar3;
            w0VarH = null;
        } else {
            jVar = jVar3;
            w0VarH = kotlin.reflect.y.internal.j0.i.c.h(jVar, e0VarQ, gVarB);
        }
        List<q> listY = nVar.Y();
        m.e(listY, "proto.contextReceiverTypeList");
        ArrayList arrayList = new ArrayList(v.u(listY, 10));
        for (q qVar : listY) {
            m.e(qVar, "it");
            arrayList.add(n(qVar, mVarB, jVar));
        }
        jVar.c1(e0VarQ2, listJ, w0VarE, w0VarH, arrayList);
        Boolean boolD8 = kotlin.reflect.y.internal.j0.e.z.b.f24183c.d(iB0);
        m.e(boolD8, "HAS_ANNOTATIONS.get(flags)");
        boolean zBooleanValue7 = boolD8.booleanValue();
        kotlin.f0.y.e.j0.e.z.b.d<x> dVar = kotlin.reflect.y.internal.j0.e.z.b.f24184d;
        x xVarD = dVar.d(iB0);
        kotlin.f0.y.e.j0.e.z.b.d<kotlin.reflect.y.internal.j0.e.k> dVar2 = kotlin.reflect.y.internal.j0.e.z.b.f24185e;
        int iB = kotlin.reflect.y.internal.j0.e.z.b.b(zBooleanValue7, xVarD, dVar2.d(iB0), false, false, false);
        if (zBooleanValue6) {
            int iC0 = nVar.q0() ? nVar.c0() : iB;
            Boolean boolD9 = kotlin.reflect.y.internal.j0.e.z.b.J.d(iC0);
            m.e(boolD9, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean zBooleanValue8 = boolD9.booleanValue();
            Boolean boolD10 = kotlin.reflect.y.internal.j0.e.z.b.K.d(iC0);
            m.e(boolD10, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean zBooleanValue9 = boolD10.booleanValue();
            Boolean boolD11 = kotlin.reflect.y.internal.j0.e.z.b.L.d(iC0);
            m.e(boolD11, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean zBooleanValue10 = boolD11.booleanValue();
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarD2 = d(nVar2, iC0, kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_GETTER);
            if (zBooleanValue8) {
                a0 a0Var2 = a0.a;
                d0VarD = new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.d0(jVar, gVarD2, a0Var2.b(dVar2.d(iC0)), b0.a(a0Var2, dVar.d(iC0)), !zBooleanValue8, zBooleanValue9, zBooleanValue10, jVar.i(), null, z0.a);
            } else {
                d0VarD = kotlin.reflect.y.internal.j0.i.c.d(jVar, gVarD2);
                m.e(d0VarD, "{\n                Descri…nnotations)\n            }");
            }
            d0VarD.R0(jVar.getReturnType());
            d0Var = d0VarD;
        } else {
            dVar = dVar;
            mVarB = mVarB;
            dVar2 = dVar2;
            d0Var = null;
        }
        Boolean boolD12 = kotlin.reflect.y.internal.j0.e.z.b.z.d(iB0);
        m.e(boolD12, "HAS_SETTER.get(flags)");
        if (boolD12.booleanValue()) {
            if (nVar.x0()) {
                iB = nVar.j0();
            }
            int i2 = iB;
            Boolean boolD13 = kotlin.reflect.y.internal.j0.e.z.b.J.d(i2);
            m.e(boolD13, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean zBooleanValue11 = boolD13.booleanValue();
            Boolean boolD14 = kotlin.reflect.y.internal.j0.e.z.b.K.d(i2);
            m.e(boolD14, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean zBooleanValue12 = boolD14.booleanValue();
            Boolean boolD15 = kotlin.reflect.y.internal.j0.e.z.b.L.d(i2);
            m.e(boolD15, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean zBooleanValue13 = boolD15.booleanValue();
            kotlin.reflect.y.internal.j0.j.b.b bVar = kotlin.reflect.y.internal.j0.j.b.b.PROPERTY_SETTER;
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarD3 = d(nVar2, i2, bVar);
            if (zBooleanValue11) {
                a0 a0Var3 = a0.a;
                kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0 e0Var = new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0(jVar, gVarD3, a0Var3.b(dVar2.d(i2)), b0.a(a0Var3, dVar.d(i2)), !zBooleanValue11, zBooleanValue12, zBooleanValue13, jVar.i(), null, z0.a);
                z = true;
                jVar2 = jVar;
                nVar3 = nVar2;
                e0Var.S0((i1) kotlin.collections.s.s0(m.b(mVarB, e0Var, u.j(), null, null, null, null, 60, null).f().o(t.e(nVar.k0()), nVar3, bVar)));
                e0VarE = e0Var;
            } else {
                jVar2 = jVar;
                nVar3 = nVar2;
                z = true;
                e0VarE = kotlin.reflect.y.internal.j0.i.c.e(jVar2, gVarD3, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b());
                m.e(e0VarE, "{\n                Descri…          )\n            }");
            }
        } else {
            jVar2 = jVar;
            nVar3 = nVar2;
            z = true;
            e0VarE = null;
        }
        Boolean boolD16 = kotlin.reflect.y.internal.j0.e.z.b.C.d(iB0);
        m.e(boolD16, "HAS_CONSTANT.get(flags)");
        if (boolD16.booleanValue()) {
            jVar2.M0(new d(nVar3, jVar2));
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarE2 = this.a.e();
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = mVarE2 instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarE2 : null;
        if ((eVar != null ? eVar.i() : null) == kotlin.p002reflect.jvm.internal.impl.descriptors.f.ANNOTATION_CLASS) {
            jVar2.M0(new e(nVar3, jVar2));
        }
        jVar2.W0(d0Var, e0VarE, new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.o(f(nVar3, false), jVar2), new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.o(f(nVar3, z), jVar2));
        return jVar2;
    }

    public final d1 m(r rVar) {
        m.f(rVar, "proto");
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g.a aVar = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
        List<kotlin.reflect.y.internal.j0.e.b> listQ = rVar.Q();
        m.e(listQ, "proto.annotationList");
        ArrayList arrayList = new ArrayList(v.u(listQ, 10));
        for (kotlin.reflect.y.internal.j0.e.b bVar : listQ) {
            kotlin.reflect.y.internal.j0.j.b.e eVar = this.f24607b;
            m.e(bVar, "it");
            arrayList.add(eVar.a(bVar, this.a.g()));
        }
        l lVar = new l(this.a.h(), this.a.e(), aVar.a(arrayList), x.b(this.a.g(), rVar.X()), b0.a(a0.a, kotlin.reflect.y.internal.j0.e.z.b.f24184d.d(rVar.V())), rVar, this.a.g(), this.a.j(), this.a.k(), this.a.d());
        m mVar = this.a;
        List<s> listA0 = rVar.a0();
        m.e(listA0, "proto.typeParameterList");
        m mVarB = m.b(mVar, lVar, listA0, null, null, null, null, 60, null);
        lVar.R0(mVarB.i().j(), mVarB.i().l(kotlin.reflect.y.internal.j0.e.z.f.o(rVar, this.a.j()), false), mVarB.i().l(kotlin.reflect.y.internal.j0.e.z.f.b(rVar, this.a.j()), false));
        return lVar;
    }
}
