package kotlin.reflect.y.internal.j0.l.t1;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.w1.b;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    private static final List<g1> a(q1 q1Var, b bVar) {
        if (q1Var.M0().size() != q1Var.O0().getParameters().size()) {
            return null;
        }
        List<g1> listM0 = q1Var.M0();
        boolean z = true;
        if (!(listM0 instanceof Collection) || !listM0.isEmpty()) {
            Iterator<T> it = listM0.iterator();
            while (it.hasNext()) {
                if (!(((g1) it.next()).a() == r1.INVARIANT)) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return null;
        }
        List<e1> parameters = q1Var.O0().getParameters();
        m.e(parameters, "type.constructor.parameters");
        List<Pair> listL0 = c0.L0(listM0, parameters);
        ArrayList arrayList = new ArrayList(v.u(listL0, 10));
        for (Pair pair : listL0) {
            g1 g1VarA = (g1) pair.a();
            e1 e1Var = (e1) pair.b();
            if (g1VarA.a() != r1.INVARIANT) {
                q1 q1VarR0 = (g1VarA.c() || g1VarA.a() != r1.IN_VARIANCE) ? null : g1VarA.getType().R0();
                m.e(e1Var, MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD);
                g1VarA = a.a(new i(bVar, q1VarR0, g1VarA, e1Var));
            }
            arrayList.add(g1VarA);
        }
        l1 l1VarC = f1.f24727c.b(q1Var.O0(), arrayList).c();
        int size = listM0.size();
        for (int i2 = 0; i2 < size; i2++) {
            g1 g1Var = listM0.get(i2);
            g1 g1Var2 = (g1) arrayList.get(i2);
            if (g1Var.a() != r1.INVARIANT) {
                List<e0> upperBounds = q1Var.O0().getParameters().get(i2).getUpperBounds();
                m.e(upperBounds, "type.constructor.parameters[index].upperBounds");
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it2 = upperBounds.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(f.a.a.a(l1VarC.n((e0) it2.next(), r1.INVARIANT).R0()));
                }
                if (!g1Var.c() && g1Var.a() == r1.OUT_VARIANCE) {
                    arrayList2.add(f.a.a.a(g1Var.getType().R0()));
                }
                e0 type = g1Var2.getType();
                m.d(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                ((i) type).O0().j(arrayList2);
            }
        }
        return arrayList;
    }

    public static final m0 b(m0 m0Var, b bVar) {
        m.f(m0Var, "type");
        m.f(bVar, "status");
        List<g1> listA = a(m0Var, bVar);
        if (listA != null) {
            return c(m0Var, listA);
        }
        return null;
    }

    private static final m0 c(q1 q1Var, List<? extends g1> list) {
        return f0.i(q1Var.N0(), q1Var.O0(), list, q1Var.P0(), null, 16, null);
    }
}
