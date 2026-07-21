package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.t1.i;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q0 {
    public static final a a(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof a) {
            return (a) q1VarR0;
        }
        return null;
    }

    public static final m0 b(e0 e0Var) {
        m.f(e0Var, "<this>");
        a aVarA = a(e0Var);
        if (aVarA != null) {
            return aVarA.a1();
        }
        return null;
    }

    public static final boolean c(e0 e0Var) {
        m.f(e0Var, "<this>");
        return e0Var.R0() instanceof p;
    }

    private static final d0 d(d0 d0Var) {
        e0 e0Var;
        Collection<e0> collectionA = d0Var.a();
        ArrayList arrayList = new ArrayList(v.u(collectionA, 10));
        Iterator<T> it = collectionA.iterator();
        boolean z = false;
        while (true) {
            e0Var = null;
            if (!it.hasNext()) {
                break;
            }
            e0 e0VarF = (e0) it.next();
            if (n1.l(e0VarF)) {
                e0VarF = f(e0VarF.R0(), false, 1, null);
                z = true;
            }
            arrayList.add(e0VarF);
        }
        if (!z) {
            return null;
        }
        e0 e0VarI = d0Var.i();
        if (e0VarI != null) {
            if (n1.l(e0VarI)) {
                e0VarI = f(e0VarI.R0(), false, 1, null);
            }
            e0Var = e0VarI;
        }
        return new d0(arrayList).m(e0Var);
    }

    public static final q1 e(q1 q1Var, boolean z) {
        m.f(q1Var, "<this>");
        p pVarB = p.f24771g.b(q1Var, z);
        if (pVarB != null) {
            return pVarB;
        }
        m0 m0VarG = g(q1Var);
        return m0VarG != null ? m0VarG : q1Var.S0(false);
    }

    public static /* synthetic */ q1 f(q1 q1Var, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return e(q1Var, z);
    }

    private static final m0 g(e0 e0Var) {
        d0 d0VarD;
        e1 e1VarO0 = e0Var.O0();
        d0 d0Var = e1VarO0 instanceof d0 ? (d0) e1VarO0 : null;
        if (d0Var == null || (d0VarD = d(d0Var)) == null) {
            return null;
        }
        return d0VarD.h();
    }

    public static final m0 h(m0 m0Var, boolean z) {
        m.f(m0Var, "<this>");
        p pVarB = p.f24771g.b(m0Var, z);
        if (pVarB != null) {
            return pVarB;
        }
        m0 m0VarG = g(m0Var);
        return m0VarG == null ? m0Var.S0(false) : m0VarG;
    }

    public static /* synthetic */ m0 i(m0 m0Var, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return h(m0Var, z);
    }

    public static final m0 j(m0 m0Var, m0 m0Var2) {
        m.f(m0Var, "<this>");
        m.f(m0Var2, "abbreviatedType");
        return g0.a(m0Var) ? m0Var : new a(m0Var, m0Var2);
    }

    public static final i k(i iVar) {
        m.f(iVar, "<this>");
        return new i(iVar.X0(), iVar.O0(), iVar.Z0(), iVar.N0(), iVar.P0(), true);
    }
}
