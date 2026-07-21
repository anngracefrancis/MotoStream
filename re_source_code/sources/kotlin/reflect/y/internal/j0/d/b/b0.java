package kotlin.reflect.y.internal.j0.d.b;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.q.c;
import kotlin.reflect.y.internal.j0.d.a.o0.s;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.reflect.y.internal.j0.l.m1;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.n;

/* JADX INFO: compiled from: typeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public static final <T> T a(m<T> mVar, T t, boolean z) {
        m.f(mVar, "<this>");
        m.f(t, "possiblyPrimitiveType");
        return z ? mVar.d(t) : t;
    }

    public static final <T> T b(m1 m1Var, i iVar, m<T> mVar, a0 a0Var) {
        m.f(m1Var, "<this>");
        m.f(iVar, "type");
        m.f(mVar, "typeFactory");
        m.f(a0Var, "mode");
        n nVarW = m1Var.w(iVar);
        if (!m1Var.V(nVarW)) {
            return null;
        }
        kotlin.reflect.y.internal.j0.b.i iVarI0 = m1Var.i0(nVarW);
        boolean z = true;
        if (iVarI0 != null) {
            T tF = mVar.f(iVarI0);
            if (!m1Var.p0(iVar) && !s.c(m1Var, iVar)) {
                z = false;
            }
            return (T) a(mVar, tF, z);
        }
        kotlin.reflect.y.internal.j0.b.i iVarL = m1Var.l(nVarW);
        if (iVarL != null) {
            return mVar.b('[' + e.q(iVarL).u());
        }
        if (m1Var.i(nVarW)) {
            d dVarK = m1Var.K(nVarW);
            b bVarN = dVarK != null ? c.a.n(dVarK) : null;
            if (bVarN != null) {
                if (!a0Var.a()) {
                    List<c.a> listI = c.a.i();
                    if (!(listI instanceof Collection) || !listI.isEmpty()) {
                        Iterator<T> it = listI.iterator();
                        do {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                        } while (!m.a(((c.a) it.next()).d(), bVarN));
                    } else {
                        z = false;
                        break;
                    }
                    if (z) {
                        return null;
                    }
                }
                String strF = kotlin.reflect.y.internal.j0.i.u.d.b(bVarN).f();
                m.e(strF, "byClassId(classId).internalName");
                return mVar.c(strF);
            }
        }
        return null;
    }
}
