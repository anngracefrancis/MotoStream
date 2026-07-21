package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.q;
import kotlin.reflect.y.internal.j0.d.a.x;
import kotlin.reflect.y.internal.j0.l.w1.g;
import kotlin.reflect.y.internal.j0.l.w1.i;
import kotlin.reflect.y.internal.j0.l.w1.o;
import kotlin.reflect.y.internal.j0.l.w1.p;
import kotlin.reflect.y.internal.j0.l.w1.u;

/* JADX INFO: compiled from: AbstractSignatureParts.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<TAnnotation> {

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.d.a.o0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractSignatureParts.kt */
    private static final class C0337a {
        private final i a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final x f23602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final o f23603c;

        public C0337a(i iVar, x xVar, o oVar) {
            this.a = iVar;
            this.f23602b = xVar;
            this.f23603c = oVar;
        }

        public final x a() {
            return this.f23602b;
        }

        public final i b() {
            return this.a;
        }

        public final o c() {
            return this.f23603c;
        }
    }

    /* JADX INFO: compiled from: AbstractSignatureParts.kt */
    static final class b extends Lambda implements Function1<Integer, e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ q f23604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ e[] f23605g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(q qVar, e[] eVarArr) {
            super(1);
            this.f23604f = qVar;
            this.f23605g = eVarArr;
        }

        public final e b(int i2) {
            Map<Integer, e> mapA;
            e eVar;
            q qVar = this.f23604f;
            if (qVar != null && (mapA = qVar.a()) != null && (eVar = mapA.get(Integer.valueOf(i2))) != null) {
                return eVar;
            }
            e[] eVarArr = this.f23605g;
            return (i2 < 0 || i2 > n.A(eVarArr)) ? e.a.a() : eVarArr[i2];
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ e invoke(Integer num) {
            return b(num.intValue());
        }
    }

    /* JADX INFO: compiled from: AbstractSignatureParts.kt */
    static final class c extends Lambda implements Function1<TAnnotation, Boolean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<TAnnotation> f23606f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(a<TAnnotation> aVar) {
            super(1);
            this.f23606f = aVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(TAnnotation tannotation) {
            m.f(tannotation, "$this$extractNullability");
            return Boolean.valueOf(this.f23606f.r(tannotation));
        }
    }

    /* JADX INFO: compiled from: AbstractSignatureParts.kt */
    static final class d extends Lambda implements Function1<C0337a, Iterable<? extends C0337a>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a<TAnnotation> f23607f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f23608g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(a<TAnnotation> aVar, p pVar) {
            super(1);
            this.f23607f = aVar;
            this.f23608g = pVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<C0337a> invoke(C0337a c0337a) {
            kotlin.reflect.y.internal.j0.l.w1.n nVarW;
            List<o> listE0;
            C0337a c0337a2;
            g gVarM;
            m.f(c0337a, "it");
            if (this.f23607f.u()) {
                i iVarB = c0337a.b();
                if (((iVarB == null || (gVarM = this.f23608g.M(iVarB)) == null) ? null : this.f23608g.y(gVarM)) != null) {
                    return null;
                }
            }
            i iVarB2 = c0337a.b();
            if (iVarB2 == null || (nVarW = this.f23608g.w(iVarB2)) == null || (listE0 = this.f23608g.e0(nVarW)) == null) {
                return null;
            }
            List<kotlin.reflect.y.internal.j0.l.w1.m> listX = this.f23608g.X(c0337a.b());
            p pVar = this.f23608g;
            a<TAnnotation> aVar = this.f23607f;
            Iterator<T> it = listE0.iterator();
            Iterator<T> it2 = listX.iterator();
            ArrayList arrayList = new ArrayList(Math.min(v.u(listE0, 10), v.u(listX, 10)));
            while (it.hasNext() && it2.hasNext()) {
                Object next = it.next();
                kotlin.reflect.y.internal.j0.l.w1.m mVar = (kotlin.reflect.y.internal.j0.l.w1.m) it2.next();
                o oVar = (o) next;
                if (pVar.L(mVar)) {
                    c0337a2 = new C0337a(null, c0337a.a(), oVar);
                } else {
                    i iVarX0 = pVar.x0(mVar);
                    c0337a2 = new C0337a(iVarX0, aVar.c(iVarX0, c0337a.a()), oVar);
                }
                arrayList.add(c0337a2);
            }
            return arrayList;
        }
    }

    private final i B(i iVar, i iVar2) {
        if (iVar == null) {
            return iVar2;
        }
        if (iVar2 == null) {
            return iVar;
        }
        if (iVar.d() && !iVar2.d()) {
            return iVar2;
        }
        if (iVar.d() || !iVar2.d()) {
            return (iVar.c().compareTo(iVar2.c()) >= 0 && iVar.c().compareTo(iVar2.c()) > 0) ? iVar : iVar2;
        }
        return iVar;
    }

    private final List<C0337a> C(i iVar) {
        return f(new C0337a(iVar, c(iVar, m()), null), new d(this, v()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x c(i iVar, x xVar) {
        return h().c(xVar, i(iVar));
    }

    private final e d(i iVar) {
        h hVarT;
        h hVarT2 = t(iVar);
        f fVar = null;
        if (hVarT2 == null) {
            i iVarP = p(iVar);
            hVarT = iVarP != null ? t(iVarP) : null;
        } else {
            hVarT = hVarT2;
        }
        p pVarV = v();
        kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
        if (cVar.l(s(pVarV.h0(iVar)))) {
            fVar = f.READ_ONLY;
        } else if (cVar.k(s(pVarV.T(iVar)))) {
            fVar = f.MUTABLE;
        }
        return new e(hVarT, fVar, v().C(iVar) || A(iVar), hVarT != hVarT2);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:93:0x012f  */
    private final e e(C0337a c0337a) {
        Iterable<? extends TAnnotation> iterableJ;
        i iVarD;
        boolean z;
        i iVarJ;
        kotlin.reflect.y.internal.j0.l.w1.n nVarW;
        if (c0337a.b() == null) {
            p pVarV = v();
            o oVarC = c0337a.c();
            if ((oVarC != null ? pVarV.N(oVarC) : null) == u.IN) {
                return e.a.a();
            }
        }
        boolean z2 = c0337a.c() == null;
        i iVarB = c0337a.b();
        if (iVarB == null || (iterableJ = i(iVarB)) == null) {
            iterableJ = kotlin.collections.u.j();
        }
        p pVarV2 = v();
        i iVarB2 = c0337a.b();
        o oVarF = (iVarB2 == null || (nVarW = pVarV2.w(iVarB2)) == null) ? null : pVarV2.F(nVarW);
        boolean z3 = l() == kotlin.reflect.y.internal.j0.d.a.b.TYPE_PARAMETER_BOUNDS;
        if (z2) {
            if (z3 || !o()) {
                iterableJ = c0.m0(k(), iterableJ);
            } else {
                i iVarB3 = c0337a.b();
                if (iVarB3 != null && w(iVarB3)) {
                    Iterable<TAnnotation> iterableK = k();
                    ArrayList arrayList = new ArrayList();
                    for (TAnnotation tannotation : iterableK) {
                        if (!h().m(tannotation)) {
                            arrayList.add(tannotation);
                        }
                    }
                    iterableJ = c0.o0(arrayList, iterableJ);
                } else {
                    iterableJ = c0.m0(k(), iterableJ);
                }
            }
        }
        f fVarE = h().e(iterableJ);
        i iVarF = h().f(iterableJ, new c(this));
        if (iVarF != null) {
            return new e(iVarF.c(), fVarE, iVarF.c() == h.NOT_NULL && oVarF != null, iVarF.d());
        }
        kotlin.reflect.y.internal.j0.d.a.b bVarL = (z2 || z3) ? l() : kotlin.reflect.y.internal.j0.d.a.b.TYPE_USE;
        x xVarA = c0337a.a();
        q qVarA = xVarA != null ? xVarA.a(bVarL) : null;
        i iVarJ2 = oVarF != null ? j(oVarF) : null;
        if (iVarJ2 == null || (iVarD = i.b(iVarJ2, h.NOT_NULL, false, 2, null)) == null) {
            iVarD = qVarA != null ? qVarA.d() : null;
        }
        if ((iVarJ2 != null ? iVarJ2.c() : null) != h.NOT_NULL) {
            if (oVarF != null) {
                z = qVarA != null && qVarA.c();
            }
        }
        o oVarC2 = c0337a.c();
        if (oVarC2 == null || (iVarJ = j(oVarC2)) == null) {
            iVarJ = null;
        } else if (iVarJ.c() == h.NULLABLE) {
            iVarJ = i.b(iVarJ, h.FORCE_FLEXIBILITY, false, 2, null);
        }
        i iVarB4 = B(iVarJ, iVarD);
        return new e(iVarB4 != null ? iVarB4.c() : null, fVarE, z, iVarB4 != null && iVarB4.d());
    }

    private final <T> List<T> f(T t, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        ArrayList arrayList = new ArrayList(1);
        g(t, arrayList, function1);
        return arrayList;
    }

    private final <T> void g(T t, List<T> list, Function1<? super T, ? extends Iterable<? extends T>> function1) {
        list.add(t);
        Iterable<? extends T> iterableInvoke = function1.invoke(t);
        if (iterableInvoke != null) {
            Iterator<? extends T> it = iterableInvoke.iterator();
            while (it.hasNext()) {
                g(it.next(), list, function1);
            }
        }
    }

    private final i j(o oVar) {
        boolean z;
        boolean z2;
        boolean z3;
        List<i> arrayList;
        boolean z4;
        p pVarV = v();
        i iVar = null;
        if (!z(oVar)) {
            return null;
        }
        List<i> listB0 = pVarV.B0(oVar);
        boolean z5 = listB0 instanceof Collection;
        if (!z5 || !listB0.isEmpty()) {
            Iterator<T> it = listB0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                if (!pVarV.Y((i) it.next())) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
            break;
        }
        if (z) {
            return null;
        }
        if (!z5 || !listB0.isEmpty()) {
            Iterator<T> it2 = listB0.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z2 = false;
                    break;
                }
                if (t((i) it2.next()) != null) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (!z2) {
            if (!z5 || !listB0.isEmpty()) {
                Iterator<T> it3 = listB0.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z3 = false;
                        break;
                    }
                    if (p((i) it3.next()) != null) {
                        z3 = true;
                        break;
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3) {
                arrayList = new ArrayList<>();
                Iterator<T> it4 = listB0.iterator();
                while (it4.hasNext()) {
                    i iVarP = p((i) it4.next());
                    if (iVarP != null) {
                        arrayList.add(iVarP);
                    }
                }
            }
            return iVar;
        }
        arrayList = listB0;
        if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
            Iterator<T> it5 = arrayList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z4 = true;
                    break;
                }
                if (!pVarV.p0((i) it5.next())) {
                    z4 = false;
                    break;
                }
            }
        } else {
            z4 = true;
            break;
        }
        iVar = new i(z4 ? h.NULLABLE : h.NOT_NULL, arrayList != listB0);
        return iVar;
    }

    private final h t(i iVar) {
        p pVarV = v();
        if (pVarV.W(pVarV.h0(iVar))) {
            return h.NULLABLE;
        }
        if (pVarV.W(pVarV.T(iVar))) {
            return null;
        }
        return h.NOT_NULL;
    }

    public abstract boolean A(i iVar);

    /* JADX WARN: Code duplicated, block: B:24:0x006b  */
    public final Function1<Integer, e> b(i iVar, Iterable<? extends i> iterable, q qVar, boolean z) {
        boolean z2;
        i iVarB;
        boolean z3;
        m.f(iVar, "<this>");
        m.f(iterable, "overrides");
        List<C0337a> listC = C(iVar);
        ArrayList arrayList = new ArrayList(v.u(iterable, 10));
        Iterator<? extends i> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(C(it.next()));
        }
        if (!q()) {
            if (x()) {
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    Iterator<? extends i> it2 = iterable.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z3 = false;
                            break;
                        }
                        if (!y(iVar, it2.next())) {
                            z3 = true;
                            break;
                        }
                    }
                } else {
                    z3 = false;
                    break;
                }
                z2 = z3;
            }
        }
        int size = z2 ? 1 : listC.size();
        e[] eVarArr = new e[size];
        int i2 = 0;
        while (i2 < size) {
            e eVarE = e(listC.get(i2));
            ArrayList arrayList2 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                C0337a c0337a = (C0337a) s.X((List) it3.next(), i2);
                e eVarD = (c0337a == null || (iVarB = c0337a.b()) == null) ? null : d(iVarB);
                if (eVarD != null) {
                    arrayList2.add(eVarD);
                }
            }
            eVarArr[i2] = s.a(eVarE, arrayList2, i2 == 0 && x(), i2 == 0 && n(), z);
            i2++;
        }
        return new b(qVar, eVarArr);
    }

    public abstract kotlin.reflect.y.internal.j0.d.a.a<TAnnotation> h();

    public abstract Iterable<TAnnotation> i(i iVar);

    public abstract Iterable<TAnnotation> k();

    public abstract kotlin.reflect.y.internal.j0.d.a.b l();

    public abstract x m();

    public abstract boolean n();

    public abstract boolean o();

    public abstract i p(i iVar);

    public boolean q() {
        return false;
    }

    public abstract boolean r(TAnnotation tannotation);

    public abstract kotlin.reflect.y.internal.j0.f.d s(i iVar);

    public abstract boolean u();

    public abstract p v();

    public abstract boolean w(i iVar);

    public abstract boolean x();

    public abstract boolean y(i iVar, i iVar2);

    public abstract boolean z(o oVar);
}
