package kotlin.reflect.y.internal.j0.l;

import kotlin.reflect.y.internal.j0.l.w1.g;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.k;
import kotlin.reflect.y.internal.j0.l.w1.m;
import kotlin.reflect.y.internal.j0.l.w1.p;

/* JADX INFO: compiled from: AbstractStrictEqualityTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final d a = new d();

    private d() {
    }

    private final boolean a(p pVar, k kVar, k kVar2) {
        if (pVar.j(kVar) == pVar.j(kVar2) && pVar.W(kVar) == pVar.W(kVar2)) {
            if ((pVar.s0(kVar) == null) == (pVar.s0(kVar2) == null) && pVar.A0(pVar.c(kVar), pVar.c(kVar2))) {
                if (pVar.t0(kVar, kVar2)) {
                    return true;
                }
                int iJ = pVar.j(kVar);
                for (int i2 = 0; i2 < iJ; i2++) {
                    m mVarG0 = pVar.g0(kVar, i2);
                    m mVarG1 = pVar.g0(kVar2, i2);
                    if (pVar.L(mVarG0) != pVar.L(mVarG1)) {
                        return false;
                    }
                    if (!pVar.L(mVarG0) && (pVar.j0(mVarG0) != pVar.j0(mVarG1) || !c(pVar, pVar.x0(mVarG0), pVar.x0(mVarG1)))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean c(p pVar, i iVar, i iVar2) {
        if (iVar == iVar2) {
            return true;
        }
        k kVarA = pVar.a(iVar);
        k kVarA2 = pVar.a(iVar2);
        if (kVarA != null && kVarA2 != null) {
            return a(pVar, kVarA, kVarA2);
        }
        g gVarM = pVar.M(iVar);
        g gVarM2 = pVar.M(iVar2);
        return gVarM != null && gVarM2 != null && a(pVar, pVar.g(gVarM), pVar.g(gVarM2)) && a(pVar, pVar.e(gVarM), pVar.e(gVarM2));
    }

    public final boolean b(p pVar, i iVar, i iVar2) {
        kotlin.jvm.internal.m.f(pVar, "context");
        kotlin.jvm.internal.m.f(iVar, "a");
        kotlin.jvm.internal.m.f(iVar2, "b");
        return c(pVar, iVar, iVar2);
    }
}
