package kotlin.reflect.y.internal.j0.l;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p1 {
    /* JADX WARN: Multi-variable type inference failed */
    public static final e0 a(e0 e0Var) {
        m.f(e0Var, "<this>");
        if (e0Var instanceof o1) {
            return ((o1) e0Var).H();
        }
        return null;
    }

    public static final q1 b(q1 q1Var, e0 e0Var) {
        m.f(q1Var, "<this>");
        m.f(e0Var, "origin");
        return d(q1Var, a(e0Var));
    }

    public static final q1 c(q1 q1Var, e0 e0Var, Function1<? super e0, ? extends e0> function1) {
        m.f(q1Var, "<this>");
        m.f(e0Var, "origin");
        m.f(function1, "transform");
        e0 e0VarA = a(e0Var);
        return d(q1Var, e0VarA != null ? function1.invoke(e0VarA) : null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final q1 d(q1 q1Var, e0 e0Var) {
        m.f(q1Var, "<this>");
        if (q1Var instanceof o1) {
            return d(((o1) q1Var).v(), e0Var);
        }
        if (e0Var == null || m.a(e0Var, q1Var)) {
            return q1Var;
        }
        if (q1Var instanceof m0) {
            return new p0((m0) q1Var, e0Var);
        }
        if (q1Var instanceof y) {
            return new a0((y) q1Var, e0Var);
        }
        throw new NoWhenBranchMatchedException();
    }
}
