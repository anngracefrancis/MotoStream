package kotlin.reflect.y.internal.j0.b.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.m.q;

/* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends g0 {
    public static final a J = new a(null);

    /* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final i1 b(e eVar, int i2, e1 e1Var) {
            String lowerCase;
            String strK = e1Var.getName().k();
            m.e(strK, "typeParameter.name.asString()");
            if (m.a(strK, "T")) {
                lowerCase = "instance";
            } else if (m.a(strK, "E")) {
                lowerCase = "receiver";
            } else {
                lowerCase = strK.toLowerCase(Locale.ROOT);
                m.e(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
            f fVarX = f.x(lowerCase);
            m.e(fVarX, "identifier(name)");
            m0 m0VarS = e1Var.s();
            m.e(m0VarS, "typeParameter.defaultType");
            z0 z0Var = z0.a;
            m.e(z0Var, "NO_SOURCE");
            return new l0(eVar, null, i2, gVarB, fVarX, m0VarS, false, false, false, null, z0Var);
        }

        public final e a(b bVar, boolean z) {
            m.f(bVar, "functionClass");
            List<e1> listW = bVar.w();
            e eVar = new e(bVar, null, b.a.DECLARATION, z, null);
            w0 w0VarK0 = bVar.K0();
            List<w0> listJ = u.j();
            List<? extends e1> listJ2 = u.j();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listW) {
                if (!(((e1) obj).n() == r1.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<IndexedValue> iterableK0 = c0.K0(arrayList);
            ArrayList arrayList2 = new ArrayList(v.u(iterableK0, 10));
            for (IndexedValue indexedValue : iterableK0) {
                arrayList2.add(e.J.b(eVar, indexedValue.c(), (e1) indexedValue.d()));
            }
            eVar.S0(null, w0VarK0, listJ, listJ2, arrayList2, ((e1) s.g0(listW)).s(), d0.ABSTRACT, t.f25368e);
            eVar.a1(true);
            return eVar;
        }
    }

    private e(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, e eVar, b.a aVar, boolean z) {
        super(mVar, eVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), q.f24924i, aVar, z0.a);
        g1(true);
        i1(z);
        Z0(false);
    }

    public /* synthetic */ e(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, e eVar, b.a aVar, boolean z, g gVar) {
        this(mVar, eVar, aVar, z);
    }

    private final y q1(List<f> list) {
        f fVar;
        boolean z;
        int size = f().size() - list.size();
        boolean z2 = true;
        if (size == 0) {
            List<i1> listF = f();
            m.e(listF, "valueParameters");
            List listL0 = c0.L0(list, listF);
            if (!(listL0 instanceof Collection) || !listL0.isEmpty()) {
                Iterator it = listL0.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    Pair pair = (Pair) it.next();
                    if (!m.a((f) pair.a(), ((i1) pair.b()).getName())) {
                        z = false;
                        break;
                    }
                }
            } else {
                z = true;
                break;
            }
            if (z) {
                return this;
            }
        }
        List<i1> listF2 = f();
        m.e(listF2, "valueParameters");
        ArrayList arrayList = new ArrayList(v.u(listF2, 10));
        for (i1 i1Var : listF2) {
            f name = i1Var.getName();
            m.e(name, "it.name");
            int iG = i1Var.g();
            int i2 = iG - size;
            if (i2 >= 0 && (fVar = list.get(i2)) != null) {
                name = fVar;
            }
            arrayList.add(i1Var.G0(this, name, iG));
        }
        p.c cVarT0 = T0(l1.a);
        if (list.isEmpty()) {
            z2 = false;
        } else {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((f) it2.next()) == null) {
                }
            }
            z2 = false;
        }
        p.c cVarH = cVarT0.H(z2).b(arrayList).h(a());
        m.e(cVarH, "newCopyBuilder(TypeSubst…   .setOriginal(original)");
        y yVarN0 = super.N0(cVarH);
        m.c(yVarN0);
        return yVarN0;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    protected p M0(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, y yVar, b.a aVar, f fVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, z0 z0Var) {
        m.f(mVar, "newOwner");
        m.f(aVar, "kind");
        m.f(gVar, "annotations");
        m.f(z0Var, "source");
        return new e(mVar, (e) yVar, aVar, isSuspend());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    protected y N0(p.c cVar) {
        e0 type;
        m.f(cVar, "configuration");
        e eVar = (e) super.N0(cVar);
        if (eVar == null) {
            return null;
        }
        List<i1> listF = eVar.f();
        m.e(listF, "substituted.valueParameters");
        boolean z = false;
        if (!(listF instanceof Collection) || !listF.isEmpty()) {
            Iterator<T> it = listF.iterator();
            do {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                type = ((i1) it.next()).getType();
                m.e(type, "it.type");
            } while (!(kotlin.reflect.y.internal.j0.b.g.d(type) != null));
        } else {
            z = true;
            break;
        }
        if (z) {
            return eVar;
        }
        List<i1> listF2 = eVar.f();
        m.e(listF2, "substituted.valueParameters");
        ArrayList arrayList = new ArrayList(v.u(listF2, 10));
        Iterator<T> it2 = listF2.iterator();
        while (it2.hasNext()) {
            e0 type2 = ((i1) it2.next()).getType();
            m.e(type2, "it.type");
            arrayList.add(kotlin.reflect.y.internal.j0.b.g.d(type2));
        }
        return eVar.q1(arrayList);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean P() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return false;
    }
}
