package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: _Sets.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0086\u0002¢\u0006\u0002\u0010\u0004\u001a4\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0002¢\u0006\u0002\u0010\u0007\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0002\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0002\u001a,\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u0002H\u0087\b¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2 = {"minus", HttpUrl.FRAGMENT_ENCODE_SET, "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/SetsKt")
public class x0 extends w0 {
    public static <T> Set<T> j(Set<? extends T> set, Iterable<? extends T> iterable) {
        m.f(set, "<this>");
        m.f(iterable, "elements");
        Collection<?> collectionA = p.a(iterable, set);
        if (collectionA.isEmpty()) {
            return c0.I0(set);
        }
        if (!(collectionA instanceof Set)) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(set);
            linkedHashSet.removeAll(collectionA);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        for (T t : set) {
            if (!collectionA.contains(t)) {
                linkedHashSet2.add(t);
            }
        }
        return linkedHashSet2;
    }

    public static <T> Set<T> k(Set<? extends T> set, T t) {
        m.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(p0.e(set.size()));
        boolean z = false;
        for (T t2 : set) {
            boolean z2 = true;
            if (!z && m.a(t2, t)) {
                z = true;
                z2 = false;
            }
            if (z2) {
                linkedHashSet.add(t2);
            }
        }
        return linkedHashSet;
    }

    public static <T> Set<T> l(Set<? extends T> set, Iterable<? extends T> iterable) {
        int size;
        m.f(set, "<this>");
        m.f(iterable, "elements");
        Integer numV = v.v(iterable);
        if (numV != null) {
            size = set.size() + numV.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(p0.e(size));
        linkedHashSet.addAll(set);
        z.z(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static <T> Set<T> m(Set<? extends T> set, T t) {
        m.f(set, "<this>");
        LinkedHashSet linkedHashSet = new LinkedHashSet(p0.e(set.size() + 1));
        linkedHashSet.addAll(set);
        linkedHashSet.add(t);
        return linkedHashSet;
    }
}
