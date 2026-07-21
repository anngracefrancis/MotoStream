package kotlin.reflect.y.internal.j0.l.y1;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.i.q.a.d;
import kotlin.reflect.y.internal.j0.l.b0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.k1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.p1;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: compiled from: CapturedTypeApproximation.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.values().length];
            iArr[r1.INVARIANT.ordinal()] = 1;
            iArr[r1.IN_VARIANCE.ordinal()] = 2;
            iArr[r1.OUT_VARIANCE.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.l.y1.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CapturedTypeApproximation.kt */
    static final class C0400b extends Lambda implements Function1<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0400b f24881f = new C0400b();

        C0400b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            m.e(q1Var, "it");
            return Boolean.valueOf(d.d(q1Var));
        }
    }

    /* JADX INFO: compiled from: CapturedTypeApproximation.kt */
    public static final class c extends f1 {
        c() {
        }

        @Override // kotlin.reflect.y.internal.j0.l.f1
        public g1 k(e1 e1Var) {
            m.f(e1Var, RoomNotification.KEY);
            kotlin.reflect.y.internal.j0.i.q.a.b bVar = e1Var instanceof kotlin.reflect.y.internal.j0.i.q.a.b ? (kotlin.reflect.y.internal.j0.i.q.a.b) e1Var : null;
            if (bVar == null) {
                return null;
            }
            return bVar.f().c() ? new i1(r1.OUT_VARIANCE, bVar.f().getType()) : bVar.f();
        }
    }

    public static final kotlin.reflect.y.internal.j0.l.y1.a<e0> a(e0 e0Var) {
        Object objE;
        m.f(e0Var, "type");
        if (b0.b(e0Var)) {
            kotlin.reflect.y.internal.j0.l.y1.a<e0> aVarA = a(b0.c(e0Var));
            kotlin.reflect.y.internal.j0.l.y1.a<e0> aVarA2 = a(b0.d(e0Var));
            return new kotlin.reflect.y.internal.j0.l.y1.a<>(p1.b(f0.d(b0.c(aVarA.c()), b0.d(aVarA2.c())), e0Var), p1.b(f0.d(b0.c(aVarA.d()), b0.d(aVarA2.d())), e0Var));
        }
        e1 e1VarO0 = e0Var.O0();
        if (d.d(e0Var)) {
            m.d(e1VarO0, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.calls.inference.CapturedTypeConstructor");
            g1 g1VarF = ((kotlin.reflect.y.internal.j0.i.q.a.b) e1VarO0).f();
            e0 type = g1VarF.getType();
            m.e(type, "typeProjection.type");
            e0 e0VarB = b(type, e0Var);
            int i2 = a.a[g1VarF.a().ordinal()];
            if (i2 == 2) {
                m0 m0VarI = kotlin.reflect.y.internal.j0.l.x1.a.h(e0Var).I();
                m.e(m0VarI, "type.builtIns.nullableAnyType");
                return new kotlin.reflect.y.internal.j0.l.y1.a<>(e0VarB, m0VarI);
            }
            if (i2 == 3) {
                m0 m0VarH = kotlin.reflect.y.internal.j0.l.x1.a.h(e0Var).H();
                m.e(m0VarH, "type.builtIns.nothingType");
                return new kotlin.reflect.y.internal.j0.l.y1.a<>(b(m0VarH, e0Var), e0VarB);
            }
            throw new AssertionError("Only nontrivial projections should have been captured, not: " + g1VarF);
        }
        if (e0Var.M0().isEmpty() || e0Var.M0().size() != e1VarO0.getParameters().size()) {
            return new kotlin.reflect.y.internal.j0.l.y1.a<>(e0Var, e0Var);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<g1> listM0 = e0Var.M0();
        List<kotlin.p002reflect.jvm.internal.impl.descriptors.e1> parameters = e1VarO0.getParameters();
        m.e(parameters, "typeConstructor.parameters");
        for (Pair pair : c0.L0(listM0, parameters)) {
            g1 g1Var = (g1) pair.a();
            kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var = (kotlin.p002reflect.jvm.internal.impl.descriptors.e1) pair.b();
            m.e(e1Var, "typeParameter");
            kotlin.reflect.y.internal.j0.l.y1.c cVarG = g(g1Var, e1Var);
            if (g1Var.c()) {
                arrayList.add(cVarG);
                arrayList2.add(cVarG);
            } else {
                kotlin.reflect.y.internal.j0.l.y1.a<kotlin.reflect.y.internal.j0.l.y1.c> aVarD = d(cVarG);
                kotlin.reflect.y.internal.j0.l.y1.c cVarA = aVarD.a();
                kotlin.reflect.y.internal.j0.l.y1.c cVarB = aVarD.b();
                arrayList.add(cVarA);
                arrayList2.add(cVarB);
            }
        }
        boolean z = true;
        if (arrayList.isEmpty()) {
            z = false;
            break;
        }
        Iterator it = arrayList.iterator();
        do {
            if (!it.hasNext()) {
                z = false;
                break;
            }
        } while (!(!((kotlin.reflect.y.internal.j0.l.y1.c) it.next()).d()));
        if (z) {
            objE = kotlin.reflect.y.internal.j0.l.x1.a.h(e0Var).H();
            m.e(objE, "type.builtIns.nothingType");
        } else {
            objE = e(e0Var, arrayList);
        }
        return new kotlin.reflect.y.internal.j0.l.y1.a<>(objE, e(e0Var, arrayList2));
    }

    private static final e0 b(e0 e0Var, e0 e0Var2) {
        e0 e0VarQ = n1.q(e0Var, e0Var2.P0());
        m.e(e0VarQ, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return e0VarQ;
    }

    public static final g1 c(g1 g1Var, boolean z) {
        if (g1Var == null) {
            return null;
        }
        if (g1Var.c()) {
            return g1Var;
        }
        e0 type = g1Var.getType();
        m.e(type, "typeProjection.type");
        if (!n1.c(type, C0400b.f24881f)) {
            return g1Var;
        }
        r1 r1VarA = g1Var.a();
        m.e(r1VarA, "typeProjection.projectionKind");
        if (r1VarA == r1.OUT_VARIANCE) {
            return new i1(r1VarA, a(type).d());
        }
        return z ? new i1(r1VarA, a(type).c()) : f(g1Var);
    }

    private static final kotlin.reflect.y.internal.j0.l.y1.a<kotlin.reflect.y.internal.j0.l.y1.c> d(kotlin.reflect.y.internal.j0.l.y1.c cVar) {
        kotlin.reflect.y.internal.j0.l.y1.a<e0> aVarA = a(cVar.a());
        e0 e0VarA = aVarA.a();
        e0 e0VarB = aVarA.b();
        kotlin.reflect.y.internal.j0.l.y1.a<e0> aVarA2 = a(cVar.b());
        return new kotlin.reflect.y.internal.j0.l.y1.a<>(new kotlin.reflect.y.internal.j0.l.y1.c(cVar.c(), e0VarB, aVarA2.a()), new kotlin.reflect.y.internal.j0.l.y1.c(cVar.c(), e0VarA, aVarA2.b()));
    }

    private static final e0 e(e0 e0Var, List<kotlin.reflect.y.internal.j0.l.y1.c> list) {
        e0Var.M0().size();
        list.size();
        ArrayList arrayList = new ArrayList(v.u(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(h((kotlin.reflect.y.internal.j0.l.y1.c) it.next()));
        }
        return k1.e(e0Var, arrayList, null, null, 6, null);
    }

    private static final g1 f(g1 g1Var) {
        l1 l1VarG = l1.g(new c());
        m.e(l1VarG, "create(object : TypeCons…ojection\n        }\n    })");
        return l1VarG.t(g1Var);
    }

    private static final kotlin.reflect.y.internal.j0.l.y1.c g(g1 g1Var, kotlin.p002reflect.jvm.internal.impl.descriptors.e1 e1Var) {
        int i2 = a.a[l1.c(e1Var.n(), g1Var).ordinal()];
        if (i2 == 1) {
            e0 type = g1Var.getType();
            m.e(type, "type");
            e0 type2 = g1Var.getType();
            m.e(type2, "type");
            return new kotlin.reflect.y.internal.j0.l.y1.c(e1Var, type, type2);
        }
        if (i2 == 2) {
            e0 type3 = g1Var.getType();
            m.e(type3, "type");
            m0 m0VarI = kotlin.reflect.y.internal.j0.i.t.a.f(e1Var).I();
            m.e(m0VarI, "typeParameter.builtIns.nullableAnyType");
            return new kotlin.reflect.y.internal.j0.l.y1.c(e1Var, type3, m0VarI);
        }
        if (i2 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        m0 m0VarH = kotlin.reflect.y.internal.j0.i.t.a.f(e1Var).H();
        m.e(m0VarH, "typeParameter.builtIns.nothingType");
        e0 type4 = g1Var.getType();
        m.e(type4, "type");
        return new kotlin.reflect.y.internal.j0.l.y1.c(e1Var, m0VarH, type4);
    }

    private static final g1 h(kotlin.reflect.y.internal.j0.l.y1.c cVar) {
        cVar.d();
        if (!m.a(cVar.a(), cVar.b())) {
            r1 r1VarN = cVar.c().n();
            r1 r1Var = r1.IN_VARIANCE;
            if (r1VarN != r1Var) {
                if (!h.m0(cVar.a()) || cVar.c().n() == r1Var) {
                    return h.o0(cVar.b()) ? new i1(i(cVar, r1Var), cVar.a()) : new i1(i(cVar, r1.OUT_VARIANCE), cVar.b());
                }
                return new i1(i(cVar, r1.OUT_VARIANCE), cVar.b());
            }
        }
        return new i1(cVar.a());
    }

    private static final r1 i(kotlin.reflect.y.internal.j0.l.y1.c cVar, r1 r1Var) {
        return r1Var == cVar.c().n() ? r1.INVARIANT : r1Var;
    }
}
