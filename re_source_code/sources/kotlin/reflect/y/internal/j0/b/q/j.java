package kotlin.reflect.y.internal.j0.b.q;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.l.f1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* JADX INFO: compiled from: mappingUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    public static final f1 a(e eVar, e eVar2) {
        m.f(eVar, "from");
        m.f(eVar2, "to");
        eVar.w().size();
        eVar2.w().size();
        f1.a aVar = f1.f24727c;
        List<e1> listW = eVar.w();
        m.e(listW, "from.declaredTypeParameters");
        ArrayList arrayList = new ArrayList(v.u(listW, 10));
        Iterator<T> it = listW.iterator();
        while (it.hasNext()) {
            arrayList.add(((e1) it.next()).h());
        }
        List<e1> listW2 = eVar2.w();
        m.e(listW2, "to.declaredTypeParameters");
        ArrayList arrayList2 = new ArrayList(v.u(listW2, 10));
        Iterator<T> it2 = listW2.iterator();
        while (it2.hasNext()) {
            m0 m0VarS = ((e1) it2.next()).s();
            m.e(m0VarS, "it.defaultType");
            arrayList2.add(a.a(m0VarS));
        }
        return f1.a.e(aVar, q0.q(c0.L0(arrayList, arrayList2)), false, 2, null);
    }
}
