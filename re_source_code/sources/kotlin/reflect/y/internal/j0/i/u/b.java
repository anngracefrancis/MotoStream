package kotlin.reflect.y.internal.j0.i.u;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: inlineClassManglingRules.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final boolean a(e eVar) {
        return m.a(a.h(eVar), k.n);
    }

    public static final boolean b(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "<this>");
        return f.b(mVar) && !a((e) mVar);
    }

    public static final boolean c(e0 e0Var) {
        m.f(e0Var, "<this>");
        h hVarW = e0Var.O0().w();
        return hVarW != null && b(hVarW);
    }

    private static final boolean d(e0 e0Var) {
        h hVarW = e0Var.O0().w();
        e1 e1Var = hVarW instanceof e1 ? (e1) hVarW : null;
        if (e1Var == null) {
            return false;
        }
        return e(kotlin.reflect.y.internal.j0.l.x1.a.i(e1Var));
    }

    private static final boolean e(e0 e0Var) {
        return c(e0Var) || d(e0Var);
    }

    public static final boolean f(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        m.f(bVar, "descriptor");
        d dVar = bVar instanceof d ? (d) bVar : null;
        if (dVar == null || t.g(dVar.getVisibility())) {
            return false;
        }
        e eVarC = dVar.C();
        m.e(eVarC, "constructorDescriptor.constructedClass");
        if (f.b(eVarC) || kotlin.reflect.y.internal.j0.i.d.G(dVar.C())) {
            return false;
        }
        List<i1> listF = dVar.f();
        m.e(listF, "constructorDescriptor.valueParameters");
        if ((listF instanceof Collection) && listF.isEmpty()) {
            return false;
        }
        Iterator<T> it = listF.iterator();
        while (it.hasNext()) {
            e0 type = ((i1) it.next()).getType();
            m.e(type, "it.type");
            if (e(type)) {
                return true;
            }
        }
        return false;
    }
}
