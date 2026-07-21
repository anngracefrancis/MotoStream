package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.n0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.j;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.v;
import kotlin.reflect.y.internal.j0.l.b1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* JADX INFO: compiled from: functionTypes.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final int a(e0 e0Var) {
        m.f(e0Var, "<this>");
        c cVarL = e0Var.getAnnotations().l(k.a.D);
        if (cVarL == null) {
            return 0;
        }
        kotlin.reflect.y.internal.j0.i.r.g gVar = (kotlin.reflect.y.internal.j0.i.r.g) n0.j(cVarL.a(), k.f23198i);
        m.d(gVar, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.constants.IntValue");
        return ((kotlin.reflect.y.internal.j0.i.r.m) gVar).b().intValue();
    }

    public static final m0 b(h hVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, e0 e0Var, List<? extends e0> list, List<? extends e0> list2, List<f> list3, e0 e0Var2, boolean z) {
        m.f(hVar, "builtIns");
        m.f(gVar, "annotations");
        m.f(list, "contextReceiverTypes");
        m.f(list2, "parameterTypes");
        m.f(e0Var2, "returnType");
        List<g1> listG = g(e0Var, list, list2, list3, e0Var2, hVar);
        e eVarF = f(hVar, list2.size() + list.size() + (e0Var == null ? 0 : 1), z);
        if (e0Var != null) {
            gVar = t(gVar, hVar);
        }
        if (!list.isEmpty()) {
            gVar = s(gVar, hVar, list.size());
        }
        return f0.g(b1.b(gVar), eVarF, listG);
    }

    public static final f d(e0 e0Var) {
        String strB;
        m.f(e0Var, "<this>");
        c cVarL = e0Var.getAnnotations().l(k.a.E);
        if (cVarL == null) {
            return null;
        }
        Object objT0 = s.t0(cVarL.a().values());
        v vVar = objT0 instanceof v ? (v) objT0 : null;
        if (vVar != null && (strB = vVar.b()) != null) {
            if (!f.A(strB)) {
                strB = null;
            }
            if (strB != null) {
                return f.x(strB);
            }
        }
        return null;
    }

    public static final List<e0> e(e0 e0Var) {
        m.f(e0Var, "<this>");
        o(e0Var);
        int iA = a(e0Var);
        if (iA == 0) {
            return u.j();
        }
        List<g1> listSubList = e0Var.M0().subList(0, iA);
        ArrayList arrayList = new ArrayList(kotlin.collections.v.u(listSubList, 10));
        Iterator<T> it = listSubList.iterator();
        while (it.hasNext()) {
            e0 type = ((g1) it.next()).getType();
            m.e(type, "it.type");
            arrayList.add(type);
        }
        return arrayList;
    }

    public static final e f(h hVar, int i2, boolean z) {
        m.f(hVar, "builtIns");
        e eVarX = z ? hVar.X(i2) : hVar.C(i2);
        m.e(eVarX, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return eVarX;
    }

    public static final List<g1> g(e0 e0Var, List<? extends e0> list, List<? extends e0> list2, List<f> list3, e0 e0Var2, h hVar) {
        f fVar;
        m.f(list, "contextReceiverTypes");
        m.f(list2, "parameterTypes");
        m.f(e0Var2, "returnType");
        m.f(hVar, "builtIns");
        int i2 = 0;
        ArrayList arrayList = new ArrayList(list2.size() + list.size() + (e0Var != null ? 1 : 0) + 1);
        ArrayList arrayList2 = new ArrayList(kotlin.collections.v.u(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(a.a((e0) it.next()));
        }
        arrayList.addAll(arrayList2);
        kotlin.p002reflect.jvm.internal.impl.utils.a.a(arrayList, e0Var != null ? a.a(e0Var) : null);
        for (Object obj : list2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                u.t();
            }
            e0 e0VarU = (e0) obj;
            if (list3 == null || (fVar = list3.get(i2)) == null || fVar.y()) {
                fVar = null;
            }
            if (fVar != null) {
                kotlin.reflect.y.internal.j0.f.c cVar = k.a.E;
                f fVarX = f.x("name");
                String strK = fVar.k();
                m.e(strK, "name.asString()");
                e0VarU = a.u(e0VarU, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.a(c0.n0(e0VarU.getAnnotations(), new j(hVar, cVar, p0.f(kotlin.s.a(fVarX, new v(strK)))))));
            }
            arrayList.add(a.a(e0VarU));
            i2 = i3;
        }
        arrayList.add(a.a(e0Var2));
        return arrayList;
    }

    public static final kotlin.reflect.y.internal.j0.b.p.c h(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        if ((mVar instanceof e) && h.A0(mVar)) {
            return i(kotlin.reflect.y.internal.j0.i.t.a.i(mVar));
        }
        return null;
    }

    private static final kotlin.reflect.y.internal.j0.b.p.c i(d dVar) {
        if (!dVar.f() || dVar.e()) {
            return null;
        }
        kotlin.f0.y.e.j0.b.p.c.a aVar = kotlin.reflect.y.internal.j0.b.p.c.f23232f;
        String strK = dVar.i().k();
        m.e(strK, "shortName().asString()");
        kotlin.reflect.y.internal.j0.f.c cVarE = dVar.l().e();
        m.e(cVarE, "toSafe().parent()");
        return aVar.b(strK, cVarE);
    }

    public static final e0 j(e0 e0Var) {
        m.f(e0Var, "<this>");
        o(e0Var);
        if (!r(e0Var)) {
            return null;
        }
        return e0Var.M0().get(a(e0Var)).getType();
    }

    public static final e0 k(e0 e0Var) {
        m.f(e0Var, "<this>");
        o(e0Var);
        e0 type = ((g1) s.g0(e0Var.M0())).getType();
        m.e(type, "arguments.last().type");
        return type;
    }

    public static final List<g1> l(e0 e0Var) {
        m.f(e0Var, "<this>");
        o(e0Var);
        List<g1> listM0 = e0Var.M0();
        return listM0.subList(a(e0Var) + (m(e0Var) ? 1 : 0), listM0.size() - 1);
    }

    public static final boolean m(e0 e0Var) {
        m.f(e0Var, "<this>");
        return o(e0Var) && r(e0Var);
    }

    public static final boolean n(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        kotlin.reflect.y.internal.j0.b.p.c cVarH = h(mVar);
        return cVarH == kotlin.reflect.y.internal.j0.b.p.c.f23233g || cVarH == kotlin.reflect.y.internal.j0.b.p.c.f23234h;
    }

    public static final boolean o(e0 e0Var) {
        m.f(e0Var, "<this>");
        h hVarW = e0Var.O0().w();
        return hVarW != null && n(hVarW);
    }

    public static final boolean p(e0 e0Var) {
        m.f(e0Var, "<this>");
        h hVarW = e0Var.O0().w();
        return (hVarW != null ? h(hVarW) : null) == kotlin.reflect.y.internal.j0.b.p.c.f23233g;
    }

    public static final boolean q(e0 e0Var) {
        m.f(e0Var, "<this>");
        h hVarW = e0Var.O0().w();
        return (hVarW != null ? h(hVarW) : null) == kotlin.reflect.y.internal.j0.b.p.c.f23234h;
    }

    private static final boolean r(e0 e0Var) {
        return e0Var.getAnnotations().l(k.a.C) != null;
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g s(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, h hVar, int i2) {
        m.f(gVar, "<this>");
        m.f(hVar, "builtIns");
        kotlin.reflect.y.internal.j0.f.c cVar = k.a.D;
        return gVar.R0(cVar) ? gVar : kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.a(c0.n0(gVar, new j(hVar, cVar, p0.f(kotlin.s.a(k.f23198i, new kotlin.reflect.y.internal.j0.i.r.m(i2))))));
    }

    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g t(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, h hVar) {
        m.f(gVar, "<this>");
        m.f(hVar, "builtIns");
        kotlin.reflect.y.internal.j0.f.c cVar = k.a.C;
        return gVar.R0(cVar) ? gVar : kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.a(c0.n0(gVar, new j(hVar, cVar, q0.i())));
    }
}
