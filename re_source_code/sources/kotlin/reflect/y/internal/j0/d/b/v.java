package kotlin.reflect.y.internal.j0.d.b;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.b.q.c;
import kotlin.reflect.y.internal.j0.d.a.f;
import kotlin.reflect.y.internal.j0.d.a.g0;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    private static final void a(StringBuilder sb, e0 e0Var) {
        sb.append(g(e0Var));
    }

    public static final String b(y yVar, boolean z, boolean z2) {
        String strK;
        m.f(yVar, "<this>");
        StringBuilder sb = new StringBuilder();
        if (z2) {
            if (yVar instanceof l) {
                strK = "<init>";
            } else {
                strK = yVar.getName().k();
                m.e(strK, "name.asString()");
            }
            sb.append(strK);
        }
        sb.append("(");
        w0 w0VarM0 = yVar.m0();
        if (w0VarM0 != null) {
            e0 type = w0VarM0.getType();
            m.e(type, "it.type");
            a(sb, type);
        }
        Iterator<i1> it = yVar.f().iterator();
        while (it.hasNext()) {
            e0 type2 = it.next().getType();
            m.e(type2, "parameter.type");
            a(sb, type2);
        }
        sb.append(")");
        if (z) {
            if (d.c(yVar)) {
                sb.append("V");
            } else {
                e0 returnType = yVar.getReturnType();
                m.c(returnType);
                a(sb, returnType);
            }
        }
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String c(y yVar, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        return b(yVar, z, z2);
    }

    public static final String d(a aVar) {
        m.f(aVar, "<this>");
        x xVar = x.a;
        if (d.E(aVar)) {
            return null;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = aVar.b();
        e eVar = mVarB instanceof e ? (e) mVarB : null;
        if (eVar == null || eVar.getName().y()) {
            return null;
        }
        a aVarA = aVar.a();
        y0 y0Var = aVarA instanceof y0 ? (y0) aVarA : null;
        if (y0Var == null) {
            return null;
        }
        return u.a(xVar, eVar, c(y0Var, false, false, 3, null));
    }

    public static final boolean e(a aVar) {
        y yVarK;
        m.f(aVar, "f");
        if (!(aVar instanceof y)) {
            return false;
        }
        y yVar = (y) aVar;
        if (!m.a(yVar.getName().k(), "remove") || yVar.f().size() != 1 || g0.h((b) aVar)) {
            return false;
        }
        List<i1> listF = yVar.a().f();
        m.e(listF, "f.original.valueParameters");
        e0 type = ((i1) s.s0(listF)).getType();
        m.e(type, "f.original.valueParameters.single().type");
        l lVarG = g(type);
        l.d dVar = lVarG instanceof l.d ? (l.d) lVarG : null;
        if ((dVar != null ? dVar.i() : null) != kotlin.reflect.y.internal.j0.i.u.e.INT || (yVarK = f.k(yVar)) == null) {
            return false;
        }
        List<i1> listF2 = yVarK.a().f();
        m.e(listF2, "overridden.original.valueParameters");
        e0 type2 = ((i1) s.s0(listF2)).getType();
        m.e(type2, "overridden.original.valueParameters.single().type");
        l lVarG2 = g(type2);
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = yVarK.b();
        m.e(mVarB, "overridden.containingDeclaration");
        return m.a(kotlin.reflect.y.internal.j0.i.t.a.i(mVarB), k.a.c0.j()) && (lVarG2 instanceof l.c) && m.a(((l.c) lVarG2).i(), "java/lang/Object");
    }

    public static final String f(e eVar) {
        m.f(eVar, "<this>");
        c cVar = c.a;
        kotlin.reflect.y.internal.j0.f.d dVarJ = kotlin.reflect.y.internal.j0.i.t.a.h(eVar).j();
        m.e(dVarJ, "fqNameSafe.toUnsafe()");
        kotlin.reflect.y.internal.j0.f.b bVarN = cVar.n(dVarJ);
        if (bVarN == null) {
            return d.b(eVar, null, 2, null);
        }
        String strF = kotlin.reflect.y.internal.j0.i.u.d.b(bVarN).f();
        m.e(strF, "byClassId(it).internalName");
        return strF;
    }

    public static final l g(e0 e0Var) {
        m.f(e0Var, "<this>");
        return (l) d.e(e0Var, n.a, a0.f23725e, z.a, null, null, 32, null);
    }
}
