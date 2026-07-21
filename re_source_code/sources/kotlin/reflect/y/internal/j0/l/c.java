package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.w1.d;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.n;
import kotlin.reflect.y.internal.j0.l.w1.p;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c a = new c();

    private c() {
    }

    private final boolean c(d1 d1Var, k kVar, n nVar) {
        p pVarJ = d1Var.j();
        if (pVarJ.f0(kVar)) {
            return true;
        }
        if (pVarJ.W(kVar)) {
            return false;
        }
        if (d1Var.n() && pVarJ.n0(kVar)) {
            return true;
        }
        return pVarJ.A0(pVarJ.c(kVar), nVar);
    }

    private final boolean e(d1 d1Var, k kVar, k kVar2) {
        p pVarJ = d1Var.j();
        if (f.f24705b) {
            if (!pVarJ.b(kVar) && !pVarJ.Z(pVarJ.c(kVar))) {
                d1Var.l(kVar);
            }
            if (!pVarJ.b(kVar2)) {
                d1Var.l(kVar2);
            }
        }
        if (pVarJ.W(kVar2) || pVarJ.C(kVar) || pVarJ.I(kVar)) {
            return true;
        }
        if ((kVar instanceof d) && pVarJ.k((d) kVar)) {
            return true;
        }
        c cVar = a;
        if (cVar.a(d1Var, kVar, d1.c.b.a)) {
            return true;
        }
        if (pVarJ.C(kVar2) || cVar.a(d1Var, kVar2, d1.c.d.a) || pVarJ.v0(kVar)) {
            return false;
        }
        return cVar.b(d1Var, kVar, pVarJ.c(kVar2));
    }

    public final boolean a(d1 d1Var, k kVar, d1.c cVar) {
        m.f(d1Var, "<this>");
        m.f(kVar, "type");
        m.f(cVar, "supertypesPolicy");
        p pVarJ = d1Var.j();
        if (!((pVarJ.v0(kVar) && !pVarJ.W(kVar)) || pVarJ.C(kVar))) {
            d1Var.k();
            ArrayDeque<k> arrayDequeH = d1Var.h();
            m.c(arrayDequeH);
            Set<k> setI = d1Var.i();
            m.c(setI);
            arrayDequeH.push(kVar);
            while (!arrayDequeH.isEmpty()) {
                if (setI.size() > 1000) {
                    throw new IllegalStateException(("Too many supertypes for type: " + kVar + ". Supertypes = " + c0.e0(setI, null, null, null, 0, null, null, 63, null)).toString());
                }
                k kVarPop = arrayDequeH.pop();
                m.e(kVarPop, "current");
                if (setI.add(kVarPop)) {
                    d1.c cVar2 = pVarJ.W(kVarPop) ? d1.c.C0394c.a : cVar;
                    if (!(!m.a(cVar2, d1.c.C0394c.a))) {
                        cVar2 = null;
                    }
                    if (cVar2 == null) {
                        continue;
                    } else {
                        p pVarJ2 = d1Var.j();
                        Iterator<i> it = pVarJ2.t(pVarJ2.c(kVarPop)).iterator();
                        while (it.hasNext()) {
                            k kVarA = cVar2.a(d1Var, it.next());
                            if ((pVarJ.v0(kVarA) && !pVarJ.W(kVarA)) || pVarJ.C(kVarA)) {
                                d1Var.e();
                            } else {
                                arrayDequeH.add(kVarA);
                            }
                        }
                    }
                }
            }
            d1Var.e();
            return false;
        }
        return true;
    }

    public final boolean b(d1 d1Var, k kVar, n nVar) {
        m.f(d1Var, "state");
        m.f(kVar, "start");
        m.f(nVar, "end");
        p pVarJ = d1Var.j();
        if (a.c(d1Var, kVar, nVar)) {
            return true;
        }
        d1Var.k();
        ArrayDeque<k> arrayDequeH = d1Var.h();
        m.c(arrayDequeH);
        Set<k> setI = d1Var.i();
        m.c(setI);
        arrayDequeH.push(kVar);
        while (!arrayDequeH.isEmpty()) {
            if (setI.size() > 1000) {
                throw new IllegalStateException(("Too many supertypes for type: " + kVar + ". Supertypes = " + c0.e0(setI, null, null, null, 0, null, null, 63, null)).toString());
            }
            k kVarPop = arrayDequeH.pop();
            m.e(kVarPop, "current");
            if (setI.add(kVarPop)) {
                d1.c cVar = pVarJ.W(kVarPop) ? d1.c.C0394c.a : d1.c.b.a;
                if (!(!m.a(cVar, d1.c.C0394c.a))) {
                    cVar = null;
                }
                if (cVar == null) {
                    continue;
                } else {
                    p pVarJ2 = d1Var.j();
                    Iterator<i> it = pVarJ2.t(pVarJ2.c(kVarPop)).iterator();
                    while (it.hasNext()) {
                        k kVarA = cVar.a(d1Var, it.next());
                        if (a.c(d1Var, kVarA, nVar)) {
                            d1Var.e();
                            return true;
                        }
                        arrayDequeH.add(kVarA);
                    }
                }
            }
        }
        d1Var.e();
        return false;
    }

    public final boolean d(d1 d1Var, k kVar, k kVar2) {
        m.f(d1Var, "state");
        m.f(kVar, "subType");
        m.f(kVar2, "superType");
        return e(d1Var, kVar, kVar2);
    }
}
