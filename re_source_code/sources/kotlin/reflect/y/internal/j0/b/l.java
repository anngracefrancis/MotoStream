package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* JADX INFO: compiled from: suspendFunctionTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static final y a;

    static {
        m mVar = new m(k.a.i(), k.f23199j);
        f fVar = f.INTERFACE;
        kotlin.reflect.y.internal.j0.f.f fVarG = k.m.g();
        z0 z0Var = z0.a;
        n nVar = kotlin.reflect.y.internal.j0.k.f.f24650b;
        y yVar = new y(mVar, fVar, false, false, fVarG, z0Var, nVar);
        yVar.N0(d0.ABSTRACT);
        yVar.P0(t.f25368e);
        yVar.O0(kotlin.collections.t.e(k0.S0(yVar, g.f25179c.b(), false, r1.IN_VARIANCE, kotlin.reflect.y.internal.j0.f.f.x("T"), 0, nVar)));
        yVar.L0();
        a = yVar;
    }

    public static final m0 a(e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "suspendFunType");
        g.q(e0Var);
        h hVarH = a.h(e0Var);
        g annotations = e0Var.getAnnotations();
        e0 e0VarJ = g.j(e0Var);
        List<e0> listE = g.e(e0Var);
        List<g1> listL = g.l(e0Var);
        ArrayList arrayList = new ArrayList(v.u(listL, 10));
        Iterator<T> it = listL.iterator();
        while (it.hasNext()) {
            arrayList.add(((g1) it.next()).getType());
        }
        a1 a1VarH = a1.f24676g.h();
        e1 e1VarH = a.h();
        kotlin.jvm.internal.m.e(e1VarH, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List listP0 = c0.p0(arrayList, f0.i(a1VarH, e1VarH, kotlin.collections.t.e(a.a(g.k(e0Var))), false, null, 16, null));
        m0 m0VarI = a.h(e0Var).I();
        kotlin.jvm.internal.m.e(m0VarI, "suspendFunType.builtIns.nullableAnyType");
        return g.b(hVarH, annotations, e0VarJ, listE, listP0, null, m0VarI, (128 & 128) != 0 ? false : false).S0(e0Var.P0());
    }
}
