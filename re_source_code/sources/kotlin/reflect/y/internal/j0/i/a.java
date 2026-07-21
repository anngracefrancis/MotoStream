package kotlin.reflect.y.internal.j0.i;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.comparisons.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.d;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.i.w.k;

/* JADX INFO: compiled from: SealedClassInheritorsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends o {
    public static final a a = new a();

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Comparisons.kt */
    public static final class C0376a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return b.a(kotlin.reflect.y.internal.j0.i.t.a.h((e) t).b(), kotlin.reflect.y.internal.j0.i.t.a.h((e) t2).b());
        }
    }

    private a() {
    }

    private static final void b(e eVar, LinkedHashSet<e> linkedHashSet, h hVar, boolean z) {
        for (m mVar : k.a.a(hVar, d.r, null, 2, null)) {
            if (mVar instanceof e) {
                e eVarR = (e) mVar;
                if (eVarR.M()) {
                    f name = eVarR.getName();
                    kotlin.jvm.internal.m.e(name, "descriptor.name");
                    kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarF = hVar.f(name, kotlin.reflect.y.internal.j0.c.b.d.WHEN_GET_ALL_DESCRIPTORS);
                    eVarR = hVarF instanceof e ? (e) hVarF : hVarF instanceof d1 ? ((d1) hVarF).r() : null;
                }
                if (eVarR != null) {
                    if (d.z(eVarR, eVar)) {
                        linkedHashSet.add(eVarR);
                    }
                    if (z) {
                        h hVarY0 = eVarR.y0();
                        kotlin.jvm.internal.m.e(hVarY0, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        b(eVar, linkedHashSet, hVarY0, z);
                    }
                }
            }
        }
    }

    public Collection<e> a(e eVar, boolean z) {
        m next;
        m mVarB;
        kotlin.jvm.internal.m.f(eVar, "sealedClass");
        if (eVar.j() != d0.SEALED) {
            return u.j();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (z) {
            Iterator<m> it = kotlin.reflect.y.internal.j0.i.t.a.m(eVar).iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(next instanceof k0));
            mVarB = next;
        } else {
            mVarB = eVar.b();
        }
        if (mVarB instanceof k0) {
            b(eVar, linkedHashSet, ((k0) mVarB).q(), z);
        }
        h hVarY0 = eVar.y0();
        kotlin.jvm.internal.m.e(hVarY0, "sealedClass.unsubstitutedInnerClassesScope");
        b(eVar, linkedHashSet, hVarY0, true);
        return c0.x0(linkedHashSet, new C0376a());
    }
}
