package kotlin.reflect.y.internal.j0.e.z;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.t;

/* JADX INFO: compiled from: TypeTable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final List<q> a;

    public g(t tVar) {
        m.f(tVar, "typeTable");
        List<q> listA = tVar.A();
        if (tVar.B()) {
            int iX = tVar.x();
            List<q> listA2 = tVar.A();
            m.e(listA2, "typeTable.typeList");
            ArrayList arrayList = new ArrayList(v.u(listA2, 10));
            int i2 = 0;
            for (Object obj : listA2) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    u.t();
                }
                q qVarT = (q) obj;
                if (i2 >= iX) {
                    qVarT = qVarT.d().M(true).c();
                }
                arrayList.add(qVarT);
                i2 = i3;
            }
            listA = arrayList;
        }
        m.e(listA, "run {\n        val origin… else originalTypes\n    }");
        this.a = listA;
    }

    public final q a(int i2) {
        return this.a.get(i2);
    }
}
