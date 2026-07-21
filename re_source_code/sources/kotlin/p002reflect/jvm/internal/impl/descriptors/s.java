package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;

/* JADX INFO: compiled from: descriptorUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {
    public static final h a(m mVar) {
        m.f(mVar, "<this>");
        m mVarB = mVar.b();
        if (mVarB == null || (mVar instanceof k0)) {
            return null;
        }
        if (!b(mVarB)) {
            return a(mVarB);
        }
        if (mVarB instanceof h) {
            return (h) mVarB;
        }
        return null;
    }

    public static final boolean b(m mVar) {
        m.f(mVar, "<this>");
        return mVar.b() instanceof k0;
    }

    public static final e c(g0 g0Var, c cVar, b bVar) {
        h hVarF;
        h hVarY0;
        m.f(g0Var, "<this>");
        m.f(cVar, "fqName");
        m.f(bVar, "lookupLocation");
        if (cVar.d()) {
            return null;
        }
        c cVarE = cVar.e();
        m.e(cVarE, "fqName.parent()");
        h hVarQ = g0Var.N(cVarE).q();
        f fVarG = cVar.g();
        m.e(fVarG, "fqName.shortName()");
        h hVarF2 = hVarQ.f(fVarG, bVar);
        e eVar = hVarF2 instanceof e ? (e) hVarF2 : null;
        if (eVar != null) {
            return eVar;
        }
        c cVarE2 = cVar.e();
        m.e(cVarE2, "fqName.parent()");
        e eVarC = c(g0Var, cVarE2, bVar);
        if (eVarC == null || (hVarY0 = eVarC.y0()) == null) {
            hVarF = null;
        } else {
            f fVarG2 = cVar.g();
            m.e(fVarG2, "fqName.shortName()");
            hVarF = hVarY0.f(fVarG2, bVar);
        }
        if (hVarF instanceof e) {
            return (e) hVarF;
        }
        return null;
    }
}
