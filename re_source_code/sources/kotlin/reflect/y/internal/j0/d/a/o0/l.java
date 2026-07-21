package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.d.a.i0;
import kotlin.reflect.y.internal.j0.d.a.j;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.b.u;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.q1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {
    private final kotlin.reflect.y.internal.j0.d.a.o0.d a;

    /* JADX INFO: compiled from: signatureEnhancement.kt */
    static final class a extends Lambda implements Function1<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f23665f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            h hVarW = q1Var.O0().w();
            if (hVarW == null) {
                return Boolean.FALSE;
            }
            f name = hVarW.getName();
            kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
            return Boolean.valueOf(m.a(name, cVar.h().g()) && m.a(kotlin.reflect.y.internal.j0.i.t.a.d(hVarW), cVar.h()));
        }
    }

    /* JADX INFO: compiled from: signatureEnhancement.kt */
    static final class b extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f23666f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            w0 w0VarM0 = bVar.m0();
            m.c(w0VarM0);
            e0 type = w0VarM0.getType();
            m.e(type, "it.extensionReceiverParameter!!.type");
            return type;
        }
    }

    /* JADX INFO: compiled from: signatureEnhancement.kt */
    static final class c extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f23667f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            e0 returnType = bVar.getReturnType();
            m.c(returnType);
            return returnType;
        }
    }

    /* JADX INFO: compiled from: signatureEnhancement.kt */
    static final class d extends Lambda implements Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.b, e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ i1 f23668f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(i1 i1Var) {
            super(1);
            this.f23668f = i1Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            e0 type = bVar.f().get(this.f23668f.g()).getType();
            m.e(type, "it.valueParameters[p.index].type");
            return type;
        }
    }

    /* JADX INFO: compiled from: signatureEnhancement.kt */
    static final class e extends Lambda implements Function1<q1, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f23669f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            m.f(q1Var, "it");
            return Boolean.valueOf(q1Var instanceof l0);
        }
    }

    public l(kotlin.reflect.y.internal.j0.d.a.o0.d dVar) {
        m.f(dVar, "typeEnhancement");
        this.a = dVar;
    }

    private final boolean a(e0 e0Var) {
        return n1.c(e0Var, a.f23665f);
    }

    private final e0 b(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a aVar, boolean z, g gVar, kotlin.reflect.y.internal.j0.d.a.b bVar2, q qVar, boolean z2, Function1<? super kotlin.p002reflect.jvm.internal.impl.descriptors.b, ? extends e0> function1) {
        n nVar = new n(aVar, z, gVar, bVar2, false, 16, null);
        e0 e0VarInvoke = function1.invoke(bVar);
        Collection<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> collectionE = bVar.e();
        m.e(collectionE, "overriddenDescriptors");
        ArrayList arrayList = new ArrayList(v.u(collectionE, 10));
        for (kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar3 : collectionE) {
            m.e(bVar3, "it");
            arrayList.add(function1.invoke(bVar3));
        }
        return c(nVar, e0VarInvoke, arrayList, qVar, z2);
    }

    private final e0 c(n nVar, e0 e0Var, List<? extends e0> list, q qVar, boolean z) {
        return this.a.a(e0Var, nVar.b(e0Var, list, qVar, z), nVar.u());
    }

    static /* synthetic */ e0 d(l lVar, kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a aVar, boolean z, g gVar, kotlin.reflect.y.internal.j0.d.a.b bVar2, q qVar, boolean z2, Function1 function1, int i2, Object obj) {
        return lVar.b(bVar, aVar, z, gVar, bVar2, qVar, (i2 & 32) != 0 ? false : z2, function1);
    }

    static /* synthetic */ e0 e(l lVar, n nVar, e0 e0Var, List list, q qVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            qVar = null;
        }
        return lVar.c(nVar, e0Var, list, qVar, (i2 & 8) != 0 ? false : z);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:20:0x0050  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b0  */
    private final <D extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> D f(D d2, g gVar) {
        D d3;
        e0 e0VarJ;
        k kVar;
        boolean z;
        e0 type;
        boolean z2;
        e0 type2;
        List<q> listA;
        if (!(d2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.a)) {
            return d2;
        }
        kotlin.reflect.y.internal.j0.d.a.k0.a aVar = (kotlin.reflect.y.internal.j0.d.a.k0.a) d2;
        boolean z3 = true;
        if (aVar.i() == kotlin.reflect.jvm.internal.impl.descriptors.b.a.FAKE_OVERRIDE && aVar.a().e().size() == 1) {
            return d2;
        }
        g gVarH = kotlin.reflect.y.internal.j0.d.a.l0.a.h(gVar, k(d2, gVar));
        if (d2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.f) {
            kotlin.reflect.y.internal.j0.d.a.k0.f fVar = (kotlin.reflect.y.internal.j0.d.a.k0.f) d2;
            d0 getter = fVar.getGetter();
            if ((getter == null || getter.V()) ? false : true) {
                d0 getter2 = fVar.getGetter();
                m.c(getter2);
                d3 = getter2;
            } else {
                d3 = d2;
            }
        } else {
            d3 = d2;
        }
        if (aVar.m0() != null) {
            y yVar = (y) (!(d3 instanceof y) ? null : d3);
            e0VarJ = j(d2, yVar != null ? (i1) yVar.i0(kotlin.reflect.y.internal.j0.d.a.k0.e.J) : null, gVarH, null, false, b.f23666f);
        } else {
            e0VarJ = null;
        }
        kotlin.reflect.y.internal.j0.d.a.k0.e eVar = d2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.e ? (kotlin.reflect.y.internal.j0.d.a.k0.e) d2 : null;
        if (eVar != null) {
            x xVar = x.a;
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = eVar.b();
            m.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            String strA = u.a(xVar, (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB, kotlin.reflect.y.internal.j0.d.b.v.c(eVar, false, false, 3, null));
            if (strA != null) {
                kVar = j.d().get(strA);
            } else {
                kVar = null;
            }
        } else {
            kVar = null;
        }
        if (kVar != null) {
            kVar.a().size();
            aVar.f().size();
        }
        boolean z4 = (i0.b(gVar.a().i()) || gVarH.a().q().b()) && i0.a(d2);
        List<i1> listF = d3.f();
        m.e(listF, "annotationOwnerForMember.valueParameters");
        ArrayList arrayList = new ArrayList(v.u(listF, 10));
        for (i1 i1Var : listF) {
            ArrayList arrayList2 = arrayList;
            arrayList2.add(j(d2, i1Var, gVarH, (kVar == null || (listA = kVar.a()) == null) ? null : (q) s.X(listA, i1Var.g()), z4, new d(i1Var)));
            arrayList = arrayList2;
        }
        ArrayList arrayList3 = arrayList;
        t0 t0Var = (t0) (!(d2 instanceof t0) ? null : d2);
        e0 e0VarD = d(this, d2, d3, true, gVarH, t0Var != null && kotlin.reflect.y.internal.j0.d.a.l0.l.c.a(t0Var) ? kotlin.reflect.y.internal.j0.d.a.b.FIELD : kotlin.reflect.y.internal.j0.d.a.b.METHOD_RETURN_TYPE, kVar != null ? kVar.b() : null, false, c.f23667f, 32, null);
        e0 returnType = aVar.getReturnType();
        m.c(returnType);
        if (a(returnType)) {
            z = true;
        } else {
            w0 w0VarM0 = aVar.m0();
            if ((w0VarM0 == null || (type2 = w0VarM0.getType()) == null) ? false : a(type2)) {
                z = true;
            } else {
                List<i1> listF2 = aVar.f();
                m.e(listF2, "valueParameters");
                if (!(listF2 instanceof Collection) || !listF2.isEmpty()) {
                    Iterator<T> it = listF2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z2 = false;
                            break;
                        }
                        e0 type3 = ((i1) it.next()).getType();
                        m.e(type3, "it.type");
                        if (a(type3)) {
                            z2 = true;
                            break;
                        }
                    }
                } else {
                    z2 = false;
                    break;
                }
                if (z2) {
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        Pair<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, ?> pairA = z ? kotlin.s.a(kotlin.reflect.y.internal.j0.i.s.d.a(), new j(d2)) : null;
        if (e0VarJ == null && e0VarD == null) {
            if (arrayList3.isEmpty()) {
                z3 = false;
                break;
            }
            Iterator it2 = arrayList3.iterator();
            do {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                }
            } while (!(((e0) it2.next()) != null));
            if (!z3 && pairA == null) {
                return d2;
            }
        }
        if (e0VarJ == null) {
            w0 w0VarM1 = aVar.m0();
            type = w0VarM1 != null ? w0VarM1.getType() : null;
        } else {
            type = e0VarJ;
        }
        ArrayList arrayList4 = new ArrayList(v.u(arrayList3, 10));
        int i2 = 0;
        for (Object obj : arrayList3) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.u.t();
            }
            e0 type4 = (e0) obj;
            if (type4 == null) {
                type4 = aVar.f().get(i2).getType();
                m.e(type4, "valueParameters[index].type");
            }
            arrayList4.add(type4);
            i2 = i3;
        }
        if (e0VarD == null) {
            e0VarD = aVar.getReturnType();
            m.c(e0VarD);
        }
        kotlin.reflect.y.internal.j0.d.a.k0.a aVarY = aVar.y(type, arrayList4, e0VarD, pairA);
        m.d(aVarY, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return aVarY;
    }

    private final e0 j(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, i1 i1Var, g gVar, q qVar, boolean z, Function1<? super kotlin.p002reflect.jvm.internal.impl.descriptors.b, ? extends e0> function1) {
        g gVarH;
        return b(bVar, i1Var, false, (i1Var == null || (gVarH = kotlin.reflect.y.internal.j0.d.a.l0.a.h(gVar, i1Var.getAnnotations())) == null) ? gVar : gVarH, kotlin.reflect.y.internal.j0.d.a.b.VALUE_PARAMETER, qVar, z, function1);
    }

    private final <D extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g k(D d2, g gVar) {
        h hVarA = kotlin.p002reflect.jvm.internal.impl.descriptors.s.a(d2);
        if (hVarA == null) {
            return d2.getAnnotations();
        }
        kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar = hVarA instanceof kotlin.reflect.y.internal.j0.d.a.l0.l.f ? (kotlin.reflect.y.internal.j0.d.a.l0.l.f) hVarA : null;
        List<kotlin.reflect.y.internal.j0.d.a.n0.a> listR0 = fVar != null ? fVar.R0() : null;
        if (listR0 == null || listR0.isEmpty()) {
            return d2.getAnnotations();
        }
        ArrayList arrayList = new ArrayList(v.u(listR0, 10));
        Iterator<T> it = listR0.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.y.internal.j0.d.a.l0.l.e(gVar, (kotlin.reflect.y.internal.j0.d.a.n0.a) it.next(), true));
        }
        return kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.a(c0.m0(d2.getAnnotations(), arrayList));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> Collection<D> g(g gVar, Collection<? extends D> collection) {
        m.f(gVar, "c");
        m.f(collection, "platformSignatures");
        ArrayList arrayList = new ArrayList(v.u(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(f((kotlin.p002reflect.jvm.internal.impl.descriptors.b) it.next(), gVar));
        }
        return arrayList;
    }

    public final e0 h(e0 e0Var, g gVar) {
        m.f(e0Var, "type");
        m.f(gVar, "context");
        e0 e0VarE = e(this, new n(null, false, gVar, kotlin.reflect.y.internal.j0.d.a.b.TYPE_USE, true), e0Var, kotlin.collections.u.j(), null, false, 12, null);
        return e0VarE == null ? e0Var : e0VarE;
    }

    public final List<e0> i(e1 e1Var, List<? extends e0> list, g gVar) {
        e0 e0VarE;
        m.f(e1Var, "typeParameter");
        m.f(list, "bounds");
        m.f(gVar, "context");
        ArrayList arrayList = new ArrayList(v.u(list, 10));
        for (e0 e0Var : list) {
            if (!kotlin.reflect.y.internal.j0.l.x1.a.b(e0Var, e.f23669f) && (e0VarE = e(this, new n(e1Var, false, gVar, kotlin.reflect.y.internal.j0.d.a.b.TYPE_PARAMETER_BOUNDS, false, 16, null), e0Var, kotlin.collections.u.j(), null, false, 12, null)) != null) {
                e0Var = e0VarE;
            }
            arrayList.add(e0Var);
        }
        return arrayList;
    }
}
