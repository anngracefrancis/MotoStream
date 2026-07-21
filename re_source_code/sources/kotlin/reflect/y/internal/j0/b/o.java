package kotlin.reflect.y.internal.j0.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.s;

/* JADX INFO: compiled from: UnsignedType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final o a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<f> f23223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Set<f> f23224c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap<b, b> f23225d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final HashMap<b, b> f23226e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final HashMap<m, f> f23227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Set<f> f23228g;

    static {
        n[] nVarArrValues = n.values();
        ArrayList arrayList = new ArrayList(nVarArrValues.length);
        for (n nVar : nVarArrValues) {
            arrayList.add(nVar.u());
        }
        f23223b = c0.I0(arrayList);
        m[] mVarArrValues = m.values();
        ArrayList arrayList2 = new ArrayList(mVarArrValues.length);
        for (m mVar : mVarArrValues) {
            arrayList2.add(mVar.k());
        }
        f23224c = c0.I0(arrayList2);
        f23225d = new HashMap<>();
        f23226e = new HashMap<>();
        f23227f = q0.k(s.a(m.f23211f, f.x("ubyteArrayOf")), s.a(m.f23212g, f.x("ushortArrayOf")), s.a(m.f23213h, f.x("uintArrayOf")), s.a(m.f23214i, f.x("ulongArrayOf")));
        n[] nVarArrValues2 = n.values();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar2 : nVarArrValues2) {
            linkedHashSet.add(nVar2.k().j());
        }
        f23228g = linkedHashSet;
        for (n nVar3 : n.values()) {
            f23225d.put(nVar3.k(), nVar3.q());
            f23226e.put(nVar3.q(), nVar3.k());
        }
    }

    private o() {
    }

    public static final boolean d(e0 e0Var) {
        h hVarC;
        m.f(e0Var, "type");
        if (n1.v(e0Var) || (hVarC = e0Var.O0().w()) == null) {
            return false;
        }
        return a.c(hVarC);
    }

    public final b a(b bVar) {
        m.f(bVar, "arrayClassId");
        return f23225d.get(bVar);
    }

    public final boolean b(f fVar) {
        m.f(fVar, "name");
        return f23228g.contains(fVar);
    }

    public final boolean c(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "descriptor");
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = mVar.b();
        return (mVarB instanceof k0) && m.a(((k0) mVarB).d(), k.r) && f23223b.contains(mVar.getName());
    }
}
