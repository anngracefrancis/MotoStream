package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.x0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.l.m1;
import kotlin.reflect.y.internal.j0.l.w1.i;

/* JADX INFO: compiled from: typeEnhancementUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s {
    /* JADX WARN: Code duplicated, block: B:50:0x00d6  */
    public static final e a(e eVar, Collection<e> collection, boolean z, boolean z2, boolean z3) {
        h hVarE;
        boolean z4;
        boolean z5;
        m.f(eVar, "<this>");
        m.f(collection, "superQualifiers");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            h hVarB = b((e) it.next());
            if (hVarB != null) {
                arrayList.add(hVarB);
            }
        }
        h hVarE2 = e(c0.I0(arrayList), b(eVar), z);
        if (hVarE2 == null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = collection.iterator();
            while (it2.hasNext()) {
                h hVarD = ((e) it2.next()).d();
                if (hVarD != null) {
                    arrayList2.add(hVarD);
                }
            }
            hVarE = e(c0.I0(arrayList2), eVar.d(), z);
        } else {
            hVarE = hVarE2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<T> it3 = collection.iterator();
        while (it3.hasNext()) {
            f fVarC = ((e) it3.next()).c();
            if (fVarC != null) {
                arrayList3.add(fVarC);
            }
        }
        f fVar = (f) d(c0.I0(arrayList3), f.MUTABLE, f.READ_ONLY, eVar.c(), z);
        h hVar = null;
        if (hVarE != null) {
            if (!(z3 || (z2 && hVarE == h.NULLABLE))) {
                hVar = hVarE;
            }
        }
        if (hVar != h.NOT_NULL) {
            z4 = false;
        } else {
            if (!eVar.b()) {
                if (!collection.isEmpty()) {
                    Iterator<T> it4 = collection.iterator();
                    while (true) {
                        if (!it4.hasNext()) {
                            z5 = false;
                            break;
                        }
                        if (((e) it4.next()).b()) {
                            z5 = true;
                            break;
                        }
                    }
                } else {
                    z5 = false;
                    break;
                }
                if (!z5) {
                    z4 = false;
                }
            }
            z4 = true;
        }
        return new e(hVar, fVar, z4, (hVar == null || hVarE2 == hVarE) ? false : true);
    }

    private static final h b(e eVar) {
        if (eVar.e()) {
            return null;
        }
        return eVar.d();
    }

    public static final boolean c(m1 m1Var, i iVar) {
        m.f(m1Var, "<this>");
        m.f(iVar, "type");
        c cVar = a0.u;
        m.e(cVar, "ENHANCED_NULLABILITY_ANNOTATION");
        return m1Var.l0(iVar, cVar);
    }

    private static final <T> T d(Set<? extends T> set, T t, T t2, T t3, boolean z) {
        Set<? extends T> setI0;
        T t4;
        if (!z) {
            if (t3 != null && (setI0 = c0.I0(x0.m(set, t3))) != null) {
                set = setI0;
            }
            return (T) kotlin.collections.s.t0(set);
        }
        if (set.contains(t)) {
            t4 = t;
        } else {
            t4 = set.contains(t2) ? t2 : null;
        }
        if (m.a(t4, t) && m.a(t3, t2)) {
            return null;
        }
        return t3 == null ? t4 : t3;
    }

    private static final h e(Set<? extends h> set, h hVar, boolean z) {
        h hVar2 = h.FORCE_FLEXIBILITY;
        return hVar == hVar2 ? hVar2 : (h) d(set, h.NOT_NULL, h.NULLABLE, hVar, z);
    }
}
