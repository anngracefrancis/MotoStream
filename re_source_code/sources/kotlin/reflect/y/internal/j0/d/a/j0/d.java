package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.collections.z;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.n;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.n0.b;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.s;

/* JADX INFO: compiled from: JavaAnnotationMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static final d a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, EnumSet<n>> f23417b = q0.l(s.a("PACKAGE", EnumSet.noneOf(n.class)), s.a("TYPE", EnumSet.of(n.w, n.J)), s.a("ANNOTATION_TYPE", EnumSet.of(n.x)), s.a("TYPE_PARAMETER", EnumSet.of(n.y)), s.a("FIELD", EnumSet.of(n.A)), s.a("LOCAL_VARIABLE", EnumSet.of(n.B)), s.a("PARAMETER", EnumSet.of(n.C)), s.a("CONSTRUCTOR", EnumSet.of(n.D)), s.a("METHOD", EnumSet.of(n.E, n.F, n.G)), s.a("TYPE_USE", EnumSet.of(n.H)));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, m> f23418c = q0.l(s.a("RUNTIME", m.RUNTIME), s.a("CLASS", m.BINARY), s.a("SOURCE", m.SOURCE));

    /* JADX INFO: compiled from: JavaAnnotationMapper.kt */
    static final class a extends Lambda implements Function1<g0, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23419f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            kotlin.jvm.internal.m.f(g0Var, "module");
            i1 i1VarB = kotlin.reflect.y.internal.j0.d.a.j0.a.b(c.a.d(), g0Var.o().o(k.a.H));
            e0 type = i1VarB != null ? i1VarB.getType() : null;
            return type == null ? kotlin.reflect.y.internal.j0.l.u1.k.d(j.G0, new String[0]) : type;
        }
    }

    private d() {
    }

    public final g<?> a(b bVar) {
        kotlin.reflect.y.internal.j0.d.a.n0.m mVar = bVar instanceof kotlin.reflect.y.internal.j0.d.a.n0.m ? (kotlin.reflect.y.internal.j0.d.a.n0.m) bVar : null;
        if (mVar == null) {
            return null;
        }
        Map<String, m> map = f23418c;
        f fVarD = mVar.d();
        m mVar2 = map.get(fVarD != null ? fVarD.k() : null);
        if (mVar2 == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.f.b bVarM = kotlin.reflect.y.internal.j0.f.b.m(k.a.K);
        kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.F…ames.annotationRetention)");
        f fVarX = f.x(mVar2.name());
        kotlin.jvm.internal.m.e(fVarX, "identifier(retention.name)");
        return new kotlin.reflect.y.internal.j0.i.r.j(bVarM, fVarX);
    }

    public final Set<n> b(String str) {
        EnumSet<n> enumSet = f23417b.get(str);
        return enumSet != null ? enumSet : w0.d();
    }

    public final g<?> c(List<? extends b> list) {
        kotlin.jvm.internal.m.f(list, "arguments");
        ArrayList<kotlin.reflect.y.internal.j0.d.a.n0.m> arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof kotlin.reflect.y.internal.j0.d.a.n0.m) {
                arrayList.add(obj);
            }
        }
        ArrayList<n> arrayList2 = new ArrayList();
        for (kotlin.reflect.y.internal.j0.d.a.n0.m mVar : arrayList) {
            d dVar = a;
            f fVarD = mVar.d();
            z.z(arrayList2, dVar.b(fVarD != null ? fVarD.k() : null));
        }
        ArrayList arrayList3 = new ArrayList(v.u(arrayList2, 10));
        for (n nVar : arrayList2) {
            kotlin.reflect.y.internal.j0.f.b bVarM = kotlin.reflect.y.internal.j0.f.b.m(k.a.J);
            kotlin.jvm.internal.m.e(bVarM, "topLevel(StandardNames.FqNames.annotationTarget)");
            f fVarX = f.x(nVar.name());
            kotlin.jvm.internal.m.e(fVarX, "identifier(kotlinTarget.name)");
            arrayList3.add(new kotlin.reflect.y.internal.j0.i.r.j(bVarM, fVarX));
        }
        return new kotlin.reflect.y.internal.j0.i.r.b(arrayList3, a.f23419f);
    }
}
