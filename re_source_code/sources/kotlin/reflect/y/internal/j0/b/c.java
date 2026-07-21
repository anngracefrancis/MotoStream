package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;

/* JADX INFO: compiled from: CompanionObjectMapping.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<b> f23156b;

    static {
        Set<i> set = i.f23173g;
        ArrayList arrayList = new ArrayList(v.u(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(k.c((i) it.next()));
        }
        kotlin.reflect.y.internal.j0.f.c cVarL = k.a.f23207h.l();
        m.e(cVarL, "string.toSafe()");
        List listP0 = c0.p0(arrayList, cVarL);
        kotlin.reflect.y.internal.j0.f.c cVarL2 = k.a.f23209j.l();
        m.e(cVarL2, "_boolean.toSafe()");
        List listP1 = c0.p0(listP0, cVarL2);
        kotlin.reflect.y.internal.j0.f.c cVarL3 = k.a.s.l();
        m.e(cVarL3, "_enum.toSafe()");
        List listP2 = c0.p0(listP1, cVarL3);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = listP2.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(b.m((kotlin.reflect.y.internal.j0.f.c) it2.next()));
        }
        f23156b = linkedHashSet;
    }

    private c() {
    }

    public final Set<b> a() {
        return f23156b;
    }

    public final Set<b> b() {
        return f23156b;
    }
}
