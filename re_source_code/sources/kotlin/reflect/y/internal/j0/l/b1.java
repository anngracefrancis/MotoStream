package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;

/* JADX INFO: compiled from: TypeAttributes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b1 {
    public static final a1 a(a1 a1Var, g gVar) {
        a1 a1VarS;
        m.f(a1Var, "<this>");
        m.f(gVar, "newAnnotations");
        if (k.a(a1Var) == gVar) {
            return a1Var;
        }
        j jVarB = k.b(a1Var);
        if (jVarB != null && (a1VarS = a1Var.s(jVarB)) != null) {
            a1Var = a1VarS;
        }
        return (gVar.iterator().hasNext() || !gVar.isEmpty()) ? a1Var.r(new j(gVar)) : a1Var;
    }

    public static final a1 b(g gVar) {
        m.f(gVar, "<this>");
        return z0.a.a(o.a, gVar, null, null, 6, null);
    }
}
