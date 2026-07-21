package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.k;
import kotlin.reflect.y.internal.j0.b.q.d;
import kotlin.reflect.y.internal.j0.d.a.a0;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.t1.q;

/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r {
    private static final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f23682b;

    /* JADX INFO: compiled from: typeEnhancement.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.values().length];
            iArr[h.NULLABLE.ordinal()] = 1;
            iArr[h.NOT_NULL.ordinal()] = 2;
            a = iArr;
        }
    }

    static {
        c cVar = a0.u;
        m.e(cVar, "ENHANCED_NULLABILITY_ANNOTATION");
        a = new c(cVar);
        c cVar2 = a0.v;
        m.e(cVar2, "ENHANCED_MUTABILITY_ANNOTATION");
        f23682b = new c(cVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g f(List<? extends g> list) {
        int size = list.size();
        if (size != 0) {
            return size != 1 ? new k((List<? extends g>) c0.E0(list)) : (g) s.s0(list);
        }
        throw new IllegalStateException("At least one Annotations object expected".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final h g(h hVar, e eVar, o oVar) {
        d dVar = d.a;
        if (!p.a(oVar) || !(hVar instanceof e)) {
            return null;
        }
        if (eVar.c() == f.READ_ONLY && oVar == o.FLEXIBLE_LOWER) {
            e eVar2 = (e) hVar;
            if (dVar.c(eVar2)) {
                return dVar.a(eVar2);
            }
        }
        if (eVar.c() != f.MUTABLE || oVar != o.FLEXIBLE_UPPER) {
            return null;
        }
        e eVar3 = (e) hVar;
        if (dVar.d(eVar3)) {
            return dVar.b(eVar3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean h(e eVar, o oVar) {
        if (!p.a(oVar)) {
            return null;
        }
        h hVarD = eVar.d();
        int i2 = hVarD == null ? -1 : a.a[hVarD.ordinal()];
        if (i2 == 1) {
            return Boolean.TRUE;
        }
        if (i2 != 2) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static final boolean i(e0 e0Var) {
        m.f(e0Var, "<this>");
        return s.c(q.a, e0Var);
    }
}
