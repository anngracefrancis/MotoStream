package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.i.c;
import kotlin.reflect.y.internal.j0.k.j;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.q0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 extends p implements i0 {
    private final n L;
    private final d1 M;
    private final j N;
    private d O;
    static final /* synthetic */ KProperty<Object>[] K = {g0.h(new y(g0.b(j0.class), "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;"))};
    public static final a J = new a(null);

    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final l1 c(d1 d1Var) {
            if (d1Var.r() == null) {
                return null;
            }
            return l1.f(d1Var.W());
        }

        public final i0 b(n nVar, d1 d1Var, d dVar) {
            d dVarC;
            List<w0> listJ;
            m.f(nVar, "storageManager");
            m.f(d1Var, "typeAliasDescriptor");
            m.f(dVar, "constructor");
            l1 l1VarC = c(d1Var);
            if (l1VarC == null || (dVarC = dVar.c(l1VarC)) == null) {
                return null;
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations = dVar.getAnnotations();
            kotlin.reflect.jvm.internal.impl.descriptors.b.a aVarI = dVar.i();
            m.e(aVarI, "constructor.kind");
            z0 z0VarT = d1Var.t();
            m.e(z0VarT, "typeAliasDescriptor.source");
            j0 j0Var = new j0(nVar, d1Var, dVarC, null, annotations, aVarI, z0VarT, null);
            List<i1> listP0 = p.P0(j0Var, dVar.f(), l1VarC);
            if (listP0 == null) {
                return null;
            }
            m0 m0VarC = b0.c(dVarC.getReturnType().R0());
            m0 m0VarS = d1Var.s();
            m.e(m0VarS, "typeAliasDescriptor.defaultType");
            m0 m0VarJ = q0.j(m0VarC, m0VarS);
            w0 w0VarF0 = dVar.f0();
            w0 w0VarH = w0VarF0 != null ? c.h(j0Var, l1VarC.n(w0VarF0.getType(), r1.INVARIANT), kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b()) : null;
            e eVarR = d1Var.r();
            if (eVarR != null) {
                List<w0> listR0 = dVar.r0();
                m.e(listR0, "constructor.contextReceiverParameters");
                listJ = new ArrayList<>(v.u(listR0, 10));
                Iterator<T> it = listR0.iterator();
                while (it.hasNext()) {
                    listJ.add(c.c(eVarR, l1VarC.n(((w0) it.next()).getType(), r1.INVARIANT), kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b()));
                }
            } else {
                listJ = u.j();
            }
            j0Var.S0(w0VarH, null, listJ, d1Var.w(), listP0, m0VarJ, d0.FINAL, d1Var.getVisibility());
            return j0Var;
        }
    }

    /* JADX INFO: compiled from: TypeAliasConstructorDescriptor.kt */
    static final class b extends Lambda implements Function0<j0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f25246g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d dVar) {
            super(0);
            this.f25246g = dVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final j0 invoke() {
            n nVarH0 = j0.this.h0();
            d1 d1VarP1 = j0.this.p1();
            d dVar = this.f25246g;
            j0 j0Var = j0.this;
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations = dVar.getAnnotations();
            kotlin.reflect.jvm.internal.impl.descriptors.b.a aVarI = this.f25246g.i();
            m.e(aVarI, "underlyingConstructorDescriptor.kind");
            z0 z0VarT = j0.this.p1().t();
            m.e(z0VarT, "typeAliasDescriptor.source");
            j0 j0Var2 = new j0(nVarH0, d1VarP1, dVar, j0Var, annotations, aVarI, z0VarT, null);
            j0 j0Var3 = j0.this;
            d dVar2 = this.f25246g;
            l1 l1VarC = j0.J.c(j0Var3.p1());
            if (l1VarC == null) {
                return null;
            }
            w0 w0VarF0 = dVar2.f0();
            w0 w0VarC = w0VarF0 != null ? w0VarF0.c(l1VarC) : null;
            List<w0> listR0 = dVar2.r0();
            m.e(listR0, "underlyingConstructorDes…contextReceiverParameters");
            ArrayList arrayList = new ArrayList(v.u(listR0, 10));
            Iterator<T> it = listR0.iterator();
            while (it.hasNext()) {
                arrayList.add(((w0) it.next()).c(l1VarC));
            }
            j0Var2.S0(null, w0VarC, arrayList, j0Var3.p1().w(), j0Var3.f(), j0Var3.getReturnType(), d0.FINAL, j0Var3.p1().getVisibility());
            return j0Var2;
        }
    }

    private j0(n nVar, d1 d1Var, d dVar, i0 i0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, z0 z0Var) {
        super(d1Var, i0Var, gVar, h.f24223i, aVar, z0Var);
        this.L = nVar;
        this.M = d1Var;
        W0(p1().E0());
        this.N = nVar.f(new b(dVar));
        this.O = dVar;
    }

    public /* synthetic */ j0(n nVar, d1 d1Var, d dVar, i0 i0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, z0 z0Var, g gVar2) {
        this(nVar, d1Var, dVar, i0Var, gVar, aVar, z0Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l
    public boolean B() {
        return p0().B();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.l
    public e C() {
        e eVarC = p0().C();
        m.e(eVarC, "underlyingConstructorDescriptor.constructedClass");
        return eVarC;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public e0 getReturnType() {
        e0 returnType = super.getReturnType();
        m.c(returnType);
        return returnType;
    }

    public final n h0() {
        return this.L;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public i0 k0(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, d0 d0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.u uVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, boolean z) {
        m.f(mVar, "newOwner");
        m.f(d0Var, "modality");
        m.f(uVar, "visibility");
        m.f(aVar, "kind");
        kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarC = u().p(mVar).d(d0Var).o(uVar).r(aVar).j(z).c();
        m.d(yVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) yVarC;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public j0 M0(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, kotlin.p002reflect.jvm.internal.impl.descriptors.y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, f fVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, z0 z0Var) {
        m.f(mVar, "newOwner");
        m.f(aVar, "kind");
        m.f(gVar, "annotations");
        m.f(z0Var, "source");
        kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar2 = kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION;
        if (aVar != aVar2) {
            kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar3 = kotlin.reflect.jvm.internal.impl.descriptors.b.a.SYNTHESIZED;
        }
        return new j0(this.L, p1(), p0(), this, gVar, aVar2, z0Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public d1 b() {
        return p1();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public i0 a() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarA = super.a();
        m.d(yVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (i0) yVarA;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.i0
    public d p0() {
        return this.O;
    }

    public d1 p1() {
        return this.M;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public i0 c(l1 l1Var) {
        m.f(l1Var, "substitutor");
        kotlin.p002reflect.jvm.internal.impl.descriptors.y yVarC = super.c(l1Var);
        m.d(yVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        j0 j0Var = (j0) yVarC;
        l1 l1VarF = l1.f(j0Var.getReturnType());
        m.e(l1VarF, "create(substitutedTypeAliasConstructor.returnType)");
        d dVarC = p0().a().c(l1VarF);
        if (dVarC == null) {
            return null;
        }
        j0Var.O = dVarC;
        return j0Var;
    }
}
