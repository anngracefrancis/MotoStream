package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a;

/* JADX INFO: compiled from: TypeCapabilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c1 {
    public static final n a(e0 e0Var) {
        m.f(e0Var, "<this>");
        a aVarR0 = e0Var.R0();
        n nVar = aVarR0 instanceof n ? (n) aVarR0 : null;
        if (nVar == null || !nVar.A0()) {
            return null;
        }
        return nVar;
    }

    public static final boolean b(e0 e0Var) {
        m.f(e0Var, "<this>");
        a aVarR0 = e0Var.R0();
        n nVar = aVarR0 instanceof n ? (n) aVarR0 : null;
        if (nVar != null) {
            return nVar.A0();
        }
        return false;
    }
}
