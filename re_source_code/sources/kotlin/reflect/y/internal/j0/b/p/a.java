package kotlin.reflect.y.internal.j0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.s;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.text.u;
import kotlin.text.v;

/* JADX INFO: compiled from: BuiltInFictitiousFunctionClassFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {
    private final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f23229b;

    public a(n nVar, g0 g0Var) {
        m.f(nVar, "storageManager");
        m.f(g0Var, "module");
        this.a = nVar;
        this.f23229b = g0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b
    public Collection<e> a(c cVar) {
        m.f(cVar, "packageFqName");
        return w0.d();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b
    public boolean b(c cVar, f fVar) {
        m.f(cVar, "packageFqName");
        m.f(fVar, "name");
        String strK = fVar.k();
        m.e(strK, "name.asString()");
        return (u.E(strK, "Function", false, 2, null) || u.E(strK, "KFunction", false, 2, null) || u.E(strK, "SuspendFunction", false, 2, null) || u.E(strK, "KSuspendFunction", false, 2, null)) && c.f23232f.c(strK, cVar) != null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b
    public e c(kotlin.reflect.y.internal.j0.f.b bVar) {
        m.f(bVar, "classId");
        if (bVar.k() || bVar.l()) {
            return null;
        }
        String strB = bVar.i().b();
        m.e(strB, "classId.relativeClassName.asString()");
        if (!v.J(strB, "Function", false, 2, null)) {
            return null;
        }
        c cVarH = bVar.h();
        m.e(cVarH, "classId.packageFqName");
        c.a.C0323a c0323aC = c.f23232f.c(strB, cVarH);
        if (c0323aC == null) {
            return null;
        }
        c cVarA = c0323aC.a();
        int iB = c0323aC.b();
        List<k0> listI = this.f23229b.N(cVarH).I();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listI) {
            if (obj instanceof kotlin.reflect.y.internal.j0.b.b) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (obj2 instanceof kotlin.reflect.y.internal.j0.b.f) {
                arrayList2.add(obj2);
            }
        }
        k0 k0Var = (kotlin.reflect.y.internal.j0.b.f) s.W(arrayList2);
        if (k0Var == null) {
            k0Var = (kotlin.reflect.y.internal.j0.b.b) s.U(arrayList);
        }
        return new b(this.a, k0Var, cVarA, iB);
    }
}
