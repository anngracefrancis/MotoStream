package kotlin.reflect.y.internal.j0.l;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: flexibleTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public static final y a(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 q1VarR0 = e0Var.R0();
        m.d(q1VarR0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return (y) q1VarR0;
    }

    public static final boolean b(e0 e0Var) {
        m.f(e0Var, "<this>");
        return e0Var.R0() instanceof y;
    }

    public static final m0 c(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof y) {
            return ((y) q1VarR0).W0();
        }
        if (q1VarR0 instanceof m0) {
            return (m0) q1VarR0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final m0 d(e0 e0Var) {
        m.f(e0Var, "<this>");
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof y) {
            return ((y) q1VarR0).X0();
        }
        if (q1VarR0 instanceof m0) {
            return (m0) q1VarR0;
        }
        throw new NoWhenBranchMatchedException();
    }
}
