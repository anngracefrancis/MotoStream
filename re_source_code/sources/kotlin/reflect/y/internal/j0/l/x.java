package kotlin.reflect.y.internal.j0.l;

import java.util.HashSet;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.n;
import kotlin.reflect.y.internal.j0.l.w1.o;

/* JADX INFO: compiled from: expandedTypeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x {
    public static final i a(m1 m1Var, i iVar) {
        m.f(m1Var, "<this>");
        m.f(iVar, "inlineClassType");
        return b(m1Var, iVar, new HashSet());
    }

    private static final i b(m1 m1Var, i iVar, HashSet<n> hashSet) {
        i iVarB;
        i iVarC0;
        n nVarW = m1Var.w(iVar);
        if (!hashSet.add(nVarW)) {
            return null;
        }
        o oVarF = m1Var.F(nVarW);
        if (oVarF != null) {
            i iVarM = m1Var.m(oVarF);
            iVarB = b(m1Var, iVarM, hashSet);
            if (iVarB == null) {
                return null;
            }
            boolean z = m1Var.a0(m1Var.w(iVarM)) || ((iVarM instanceof k) && m1Var.E0((k) iVarM));
            if ((iVarB instanceof k) && m1Var.E0((k) iVarB) && m1Var.p0(iVar) && z) {
                iVarC0 = m1Var.C0(iVarM);
            } else if (!m1Var.p0(iVarB) && m1Var.o0(iVar)) {
                iVarC0 = m1Var.C0(iVarB);
            }
            return iVarC0;
        }
        if (!m1Var.a0(nVarW)) {
            return iVar;
        }
        i iVarB0 = m1Var.b0(iVar);
        if (iVarB0 == null || (iVarB = b(m1Var, iVarB0, hashSet)) == null) {
            return null;
        }
        if (m1Var.p0(iVar)) {
            if (m1Var.p0(iVarB)) {
                return iVar;
            }
            return ((iVarB instanceof k) && m1Var.E0((k) iVarB)) ? iVar : m1Var.C0(iVarB);
        }
        return iVarB;
    }
}
