package kotlin.reflect.y.internal.j0.l;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.l;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k1 {
    public static final m0 a(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 q1VarR0 = e0Var.R0();
        m0 m0Var = q1VarR0 instanceof m0 ? (m0) q1VarR0 : null;
        if (m0Var != null) {
            return m0Var;
        }
        throw new IllegalStateException(("This is should be simple type: " + e0Var).toString());
    }

    public static final e0 b(e0 e0Var, List<? extends g1> list, g gVar) {
        m.f(e0Var, "<this>");
        m.f(list, "newArguments");
        m.f(gVar, "newAnnotations");
        return e(e0Var, list, gVar, null, 4, null);
    }

    public static final e0 c(e0 e0Var, List<? extends g1> list, g gVar, List<? extends g1> list2) {
        m.f(e0Var, "<this>");
        m.f(list, "newArguments");
        m.f(gVar, "newAnnotations");
        m.f(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == e0Var.M0()) && gVar == e0Var.getAnnotations()) {
            return e0Var;
        }
        a1 a1VarN0 = e0Var.N0();
        if ((gVar instanceof l) && gVar.isEmpty()) {
            gVar = g.f25179c.b();
        }
        a1 a1VarA = b1.a(a1VarN0, gVar);
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof y) {
            y yVar = (y) q1VarR0;
            return f0.d(d(yVar.W0(), list, a1VarA), d(yVar.X0(), list2, a1VarA));
        }
        if (q1VarR0 instanceof m0) {
            return d((m0) q1VarR0, list, a1VarA);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final m0 d(m0 m0Var, List<? extends g1> list, a1 a1Var) {
        m.f(m0Var, "<this>");
        m.f(list, "newArguments");
        m.f(a1Var, "newAttributes");
        if (list.isEmpty() && a1Var == m0Var.N0()) {
            return m0Var;
        }
        return list.isEmpty() ? m0Var.U0(a1Var) : f0.i(a1Var, m0Var.O0(), list, m0Var.P0(), null, 16, null);
    }

    public static /* synthetic */ e0 e(e0 e0Var, List list, g gVar, List list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = e0Var.M0();
        }
        if ((i2 & 2) != 0) {
            gVar = e0Var.getAnnotations();
        }
        if ((i2 & 4) != 0) {
            list2 = list;
        }
        return c(e0Var, list, gVar, list2);
    }

    public static /* synthetic */ m0 f(m0 m0Var, List list, a1 a1Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = m0Var.M0();
        }
        if ((i2 & 2) != 0) {
            a1Var = m0Var.N0();
        }
        return d(m0Var, list, a1Var);
    }
}
