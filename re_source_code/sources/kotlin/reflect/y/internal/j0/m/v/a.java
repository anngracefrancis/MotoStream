package kotlin.reflect.y.internal.j0.m.v;

import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.utils.e;
import kotlin.reflect.y.internal.j0.i.w.h;

/* JADX INFO: compiled from: scopeUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Collection<T> a(Collection<? extends T> collection, Collection<? extends T> collection2) {
        m.f(collection2, "collection");
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == 0) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    public static final e<h> b(Iterable<? extends h> iterable) {
        m.f(iterable, "scopes");
        e<h> eVar = new e<>();
        for (h hVar : iterable) {
            h hVar2 = hVar;
            if ((hVar2 == null || hVar2 == h.b.f24422b) ? false : true) {
                eVar.add(hVar);
            }
        }
        return eVar;
    }
}
