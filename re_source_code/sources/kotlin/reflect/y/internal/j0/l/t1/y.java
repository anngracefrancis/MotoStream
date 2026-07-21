package kotlin.reflect.y.internal.j0.l.t1;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.h.c;
import kotlin.reflect.y.internal.j0.i.q.a.d;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.y1.b;

/* JADX INFO: compiled from: utils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    private static final e0 a(e0 e0Var) {
        return b.a(e0Var).d();
    }

    private static final String b(e1 e1Var) {
        StringBuilder sb = new StringBuilder();
        c("type: " + e1Var, sb);
        c("hashCode: " + e1Var.hashCode(), sb);
        c("javaClass: " + e1Var.getClass().getCanonicalName(), sb);
        for (m mVarC = e1Var.c(); mVarC != null; mVarC = mVarC.b()) {
            c("fqName: " + c.f24252g.q(mVarC), sb);
            c("javaClass: " + mVarC.getClass().getCanonicalName(), sb);
        }
        String string = sb.toString();
        kotlin.jvm.internal.m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private static final StringBuilder c(String str, StringBuilder sb) {
        kotlin.jvm.internal.m.f(str, "<this>");
        sb.append(str);
        kotlin.jvm.internal.m.e(sb, "append(value)");
        sb.append('\n');
        kotlin.jvm.internal.m.e(sb, "append('\\n')");
        return sb;
    }

    public static final e0 d(e0 e0Var, e0 e0Var2, v vVar) {
        boolean z;
        kotlin.jvm.internal.m.f(e0Var, "subtype");
        kotlin.jvm.internal.m.f(e0Var2, "supertype");
        kotlin.jvm.internal.m.f(vVar, "typeCheckingProcedureCallbacks");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(new s(e0Var, null));
        e1 e1VarO0 = e0Var2.O0();
        while (!arrayDeque.isEmpty()) {
            s sVar = (s) arrayDeque.poll();
            e0 e0VarB = sVar.b();
            e1 e1VarO1 = e0VarB.O0();
            if (vVar.a(e1VarO1, e1VarO0)) {
                boolean zP0 = e0VarB.P0();
                for (s sVarA = sVar.a(); sVarA != null; sVarA = sVarA.a()) {
                    e0 e0VarB2 = sVarA.b();
                    List<g1> listM0 = e0VarB2.M0();
                    if (!(listM0 instanceof Collection) || !listM0.isEmpty()) {
                        Iterator<T> it = listM0.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            if (((g1) it.next()).a() != r1.INVARIANT) {
                                z = true;
                                break;
                            }
                        }
                    } else {
                        z = false;
                        break;
                    }
                    if (z) {
                        e0 e0VarN = d.f(f1.f24727c.a(e0VarB2), false, 1, null).c().n(e0VarB, r1.INVARIANT);
                        kotlin.jvm.internal.m.e(e0VarN, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
                        e0VarB = a(e0VarN);
                    } else {
                        e0VarB = f1.f24727c.a(e0VarB2).c().n(e0VarB, r1.INVARIANT);
                        kotlin.jvm.internal.m.e(e0VarB, "{\n                    Ty…ARIANT)\n                }");
                    }
                    zP0 = zP0 || e0VarB2.P0();
                }
                e1 e1VarO2 = e0VarB.O0();
                if (vVar.a(e1VarO2, e1VarO0)) {
                    return n1.p(e0VarB, zP0);
                }
                throw new AssertionError("Type constructors should be equals!\nsubstitutedSuperType: " + b(e1VarO2) + ", \n\nsupertype: " + b(e1VarO0) + " \n" + vVar.a(e1VarO2, e1VarO0));
            }
            for (e0 e0Var3 : e1VarO1.a()) {
                kotlin.jvm.internal.m.e(e0Var3, "immediateSupertype");
                arrayDeque.add(new s(e0Var3, sVar));
            }
        }
        return null;
    }
}
