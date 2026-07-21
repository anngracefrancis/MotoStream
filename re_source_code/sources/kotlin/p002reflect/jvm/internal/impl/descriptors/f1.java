package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.sequences.Sequence;
import kotlin.sequences.n;

/* JADX INFO: compiled from: typeParameterUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f1 {

    /* JADX INFO: compiled from: typeParameterUtils.kt */
    static final class a extends Lambda implements Function1<m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f25141f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar) {
            m.f(mVar, "it");
            return Boolean.valueOf(mVar instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.a);
        }
    }

    /* JADX INFO: compiled from: typeParameterUtils.kt */
    static final class b extends Lambda implements Function1<m, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25142f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar) {
            m.f(mVar, "it");
            return Boolean.valueOf(!(mVar instanceof l));
        }
    }

    /* JADX INFO: compiled from: typeParameterUtils.kt */
    static final class c extends Lambda implements Function1<m, Sequence<? extends e1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f25143f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Sequence<e1> invoke(m mVar) {
            m.f(mVar, "it");
            List<e1> typeParameters = ((kotlin.p002reflect.jvm.internal.impl.descriptors.a) mVar).getTypeParameters();
            m.e(typeParameters, "it as CallableDescriptor).typeParameters");
            return c0.J(typeParameters);
        }
    }

    public static final r0 a(e0 e0Var) {
        m.f(e0Var, "<this>");
        h hVarW = e0Var.O0().w();
        return b(e0Var, hVarW instanceof i ? (i) hVarW : null, 0);
    }

    private static final r0 b(e0 e0Var, i iVar, int i2) {
        if (iVar == null || k.m(iVar)) {
            return null;
        }
        int size = iVar.w().size() + i2;
        if (iVar.m()) {
            List<g1> listSubList = e0Var.M0().subList(i2, size);
            m mVarB = iVar.b();
            return new r0(iVar, listSubList, b(e0Var, mVarB instanceof i ? (i) mVarB : null, size));
        }
        if (size != e0Var.M0().size()) {
            d.E(iVar);
        }
        return new r0(iVar, e0Var.M0().subList(i2, e0Var.M0().size()), null);
    }

    private static final kotlin.p002reflect.jvm.internal.impl.descriptors.c c(e1 e1Var, m mVar, int i2) {
        return new kotlin.p002reflect.jvm.internal.impl.descriptors.c(e1Var, mVar, i2);
    }

    public static final List<e1> d(i iVar) {
        List<e1> listJ;
        m next;
        e1 e1VarH;
        m.f(iVar, "<this>");
        List<e1> listW = iVar.w();
        m.e(listW, "declaredTypeParameters");
        if (!iVar.m() && !(iVar.b() instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.a)) {
            return listW;
        }
        List listA = n.A(n.p(n.l(n.y(kotlin.reflect.y.internal.j0.i.t.a.m(iVar), a.f25141f), b.f25142f), c.f25143f));
        Iterator<m> it = kotlin.reflect.y.internal.j0.i.t.a.m(iVar).iterator();
        do {
            listJ = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(next instanceof e));
        e eVar = (e) next;
        if (eVar != null && (e1VarH = eVar.h()) != null) {
            listJ = e1VarH.getParameters();
        }
        if (listJ == null) {
            listJ = u.j();
        }
        if (listA.isEmpty() && listJ.isEmpty()) {
            List<e1> listW2 = iVar.w();
            m.e(listW2, "declaredTypeParameters");
            return listW2;
        }
        List<e1> listO0 = c0.o0(listA, listJ);
        ArrayList arrayList = new ArrayList(v.u(listO0, 10));
        for (e1 e1Var : listO0) {
            m.e(e1Var, "it");
            arrayList.add(c(e1Var, iVar, listW.size()));
        }
        return c0.o0(listW, arrayList);
    }
}
