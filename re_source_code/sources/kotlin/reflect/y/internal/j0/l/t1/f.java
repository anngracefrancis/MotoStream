package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.m;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.y.internal.j0.i.q.a.c;
import kotlin.reflect.y.internal.j0.i.r.p;
import kotlin.reflect.y.internal.j0.l.d0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.h;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.p1;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.y;

/* JADX INFO: compiled from: KotlinTypePreparator.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f extends h {

    /* JADX INFO: compiled from: KotlinTypePreparator.kt */
    public static final class a extends f {
        public static final a a = new a();

        private a() {
        }
    }

    /* JADX INFO: compiled from: KotlinTypePreparator.kt */
    /* synthetic */ class b extends i implements Function1<kotlin.reflect.y.internal.j0.l.w1.i, q1> {
        b(Object obj) {
            super(1, obj);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* JADX INFO: renamed from: getName */
        public final String getM() {
            return "prepareType";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return g0.b(f.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "prepareType(Lorg/jetbrains/kotlin/types/model/KotlinTypeMarker;)Lorg/jetbrains/kotlin/types/UnwrappedType;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public final q1 invoke(kotlin.reflect.y.internal.j0.l.w1.i iVar) {
            m.f(iVar, "p0");
            return ((f) this.receiver).a(iVar);
        }
    }

    private final m0 c(m0 m0Var) {
        e0 type;
        e1 e1VarO0 = m0Var.O0();
        boolean z = false;
        d0 d0VarM = null;
        q1VarR0 = null;
        q1 q1VarR0 = null;
        if (e1VarO0 instanceof c) {
            c cVar = (c) e1VarO0;
            g1 g1VarF = cVar.f();
            if (!(g1VarF.a() == r1.IN_VARIANCE)) {
                g1VarF = null;
            }
            if (g1VarF != null && (type = g1VarF.getType()) != null) {
                q1VarR0 = type.R0();
            }
            q1 q1Var = q1VarR0;
            if (cVar.h() == null) {
                g1 g1VarF2 = cVar.f();
                Collection<e0> collectionA = cVar.a();
                ArrayList arrayList = new ArrayList(v.u(collectionA, 10));
                Iterator<T> it = collectionA.iterator();
                while (it.hasNext()) {
                    arrayList.add(((e0) it.next()).R0());
                }
                cVar.j(new j(g1VarF2, arrayList, null, 4, null));
            }
            kotlin.reflect.y.internal.j0.l.w1.b bVar = kotlin.reflect.y.internal.j0.l.w1.b.FOR_SUBTYPING;
            j jVarH = cVar.h();
            m.c(jVarH);
            return new i(bVar, jVarH, q1Var, m0Var.N0(), m0Var.P0(), false, 32, null);
        }
        if (e1VarO0 instanceof p) {
            Collection<e0> collectionA2 = ((p) e1VarO0).a();
            ArrayList arrayList2 = new ArrayList(v.u(collectionA2, 10));
            Iterator<T> it2 = collectionA2.iterator();
            while (it2.hasNext()) {
                e0 e0VarP = n1.p((e0) it2.next(), m0Var.P0());
                m.e(e0VarP, "makeNullableAsSpecified(it, type.isMarkedNullable)");
                arrayList2.add(e0VarP);
            }
            return f0.j(m0Var.N0(), new d0(arrayList2), u.j(), false, m0Var.q());
        }
        if (!(e1VarO0 instanceof d0) || !m0Var.P0()) {
            return m0Var;
        }
        d0 d0Var = (d0) e1VarO0;
        Collection<e0> collectionA3 = d0Var.a();
        ArrayList arrayList3 = new ArrayList(v.u(collectionA3, 10));
        Iterator<T> it3 = collectionA3.iterator();
        while (it3.hasNext()) {
            arrayList3.add(kotlin.reflect.y.internal.j0.l.x1.a.t((e0) it3.next()));
            z = true;
        }
        if (z) {
            e0 e0VarI = d0Var.i();
            d0VarM = new d0(arrayList3).m(e0VarI != null ? kotlin.reflect.y.internal.j0.l.x1.a.t(e0VarI) : null);
        }
        if (d0VarM != null) {
            d0Var = d0VarM;
        }
        return d0Var.h();
    }

    @Override // kotlin.reflect.y.internal.j0.l.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q1 a(kotlin.reflect.y.internal.j0.l.w1.i iVar) {
        q1 q1VarD;
        m.f(iVar, "type");
        if (!(iVar instanceof e0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        q1 q1VarR0 = ((e0) iVar).R0();
        if (q1VarR0 instanceof m0) {
            q1VarD = c((m0) q1VarR0);
        } else {
            if (!(q1VarR0 instanceof y)) {
                throw new NoWhenBranchMatchedException();
            }
            y yVar = (y) q1VarR0;
            m0 m0VarC = c(yVar.W0());
            m0 m0VarC2 = c(yVar.X0());
            q1VarD = (m0VarC == yVar.W0() && m0VarC2 == yVar.X0()) ? q1VarR0 : f0.d(m0VarC, m0VarC2);
        }
        return p1.c(q1VarD, q1VarR0, new b(this));
    }
}
