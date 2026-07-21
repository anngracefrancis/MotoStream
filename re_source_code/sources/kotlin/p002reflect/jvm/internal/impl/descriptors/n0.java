package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: PackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 {
    public static final void a(l0 l0Var, c cVar, Collection<k0> collection) {
        m.f(l0Var, "<this>");
        m.f(cVar, "fqName");
        m.f(collection, "packageFragments");
        if (l0Var instanceof o0) {
            ((o0) l0Var).b(cVar, collection);
        } else {
            collection.addAll(l0Var.a(cVar));
        }
    }

    public static final boolean b(l0 l0Var, c cVar) {
        m.f(l0Var, "<this>");
        m.f(cVar, "fqName");
        return l0Var instanceof o0 ? ((o0) l0Var).c(cVar) : c(l0Var, cVar).isEmpty();
    }

    public static final List<k0> c(l0 l0Var, c cVar) {
        m.f(l0Var, "<this>");
        m.f(cVar, "fqName");
        ArrayList arrayList = new ArrayList();
        a(l0Var, cVar, arrayList);
        return arrayList;
    }
}
