package kotlin.reflect.y.internal.j0.f;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.p0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.s;

/* JADX INFO: compiled from: StandardClassIds.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    private static final c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f24236b;

    static {
        c cVar = new c("java.lang");
        a = cVar;
        c cVarC = cVar.c(f.x("annotation"));
        m.e(cVarC, "JAVA_LANG_PACKAGE.child(…identifier(\"annotation\"))");
        f24236b = cVarC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b j(String str) {
        return new b(i.a.b(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b k(String str) {
        return new b(i.a.e(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b l(String str) {
        return new b(i.a.c(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b m(String str) {
        return new b(i.a.d(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<V, K> n(Map<K, ? extends V> map) {
        Set<Map.Entry<K, ? extends V>> setEntrySet = map.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(l.b(p0.e(v.u(setEntrySet, 10)), 16));
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pairA = s.a(entry.getValue(), entry.getKey());
            linkedHashMap.put(pairA.c(), pairA.d());
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b o(f fVar) {
        i iVar = i.a;
        return new b(iVar.a().h(), f.x(fVar.u() + iVar.a().j().u()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b p(String str) {
        return new b(i.a.f(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b q(String str) {
        return new b(i.a.g(), f.x(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b r(b bVar) {
        return new b(i.a.e(), f.x('U' + bVar.j().u()));
    }
}
