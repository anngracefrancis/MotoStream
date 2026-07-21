package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.i;
import kotlin.s;

/* JADX INFO: compiled from: FakePureImplementationsProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final m a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<b, b> f23595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<c, c> f23596c;

    static {
        m mVar = new m();
        a = mVar;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        f23595b = linkedHashMap;
        i iVar = i.a;
        mVar.c(iVar.j(), mVar.a("java.util.ArrayList", "java.util.LinkedList"));
        mVar.c(iVar.l(), mVar.a("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        mVar.c(iVar.k(), mVar.a("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        b bVarM = b.m(new c("java.util.function.Function"));
        kotlin.jvm.internal.m.e(bVarM, "topLevel(FqName(\"java.util.function.Function\"))");
        mVar.c(bVarM, mVar.a("java.util.function.UnaryOperator"));
        b bVarM2 = b.m(new c("java.util.function.BiFunction"));
        kotlin.jvm.internal.m.e(bVarM2, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        mVar.c(bVarM2, mVar.a("java.util.function.BinaryOperator"));
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(s.a(((b) entry.getKey()).b(), ((b) entry.getValue()).b()));
        }
        f23596c = q0.q(arrayList);
    }

    private m() {
    }

    private final List<b> a(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(b.m(new c(str)));
        }
        return arrayList;
    }

    private final void c(b bVar, List<b> list) {
        Map<b, b> map = f23595b;
        for (Object obj : list) {
            map.put((b) obj, bVar);
        }
    }

    public final c b(c cVar) {
        kotlin.jvm.internal.m.f(cVar, "classFqName");
        return f23596c.get(cVar);
    }
}
