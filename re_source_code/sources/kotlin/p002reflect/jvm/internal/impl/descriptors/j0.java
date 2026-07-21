package kotlin.p002reflect.jvm.internal.impl.descriptors;

import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.IntIterator;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k0;
import kotlin.ranges.IntRange;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.k.g;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.l;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: NotFoundClasses.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    private final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g0 f25145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g<kotlin.reflect.y.internal.j0.f.c, k0> f25146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g<a, e> f25147d;

    /* JADX INFO: compiled from: NotFoundClasses.kt */
    private static final class a {
        private final kotlin.reflect.y.internal.j0.f.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Integer> f25148b;

        public a(kotlin.reflect.y.internal.j0.f.b bVar, List<Integer> list) {
            m.f(bVar, "classId");
            m.f(list, "typeParametersCount");
            this.a = bVar;
            this.f25148b = list;
        }

        public final kotlin.reflect.y.internal.j0.f.b a() {
            return this.a;
        }

        public final List<Integer> b() {
            return this.f25148b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.a, aVar.a) && m.a(this.f25148b, aVar.f25148b);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.f25148b.hashCode();
        }

        public String toString() {
            return "ClassRequest(classId=" + this.a + ", typeParametersCount=" + this.f25148b + ')';
        }
    }

    /* JADX INFO: compiled from: NotFoundClasses.kt */
    public static final class b extends kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g {
        private final boolean n;
        private final List<e1> o;
        private final l p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(n nVar, m mVar, f fVar, boolean z, int i2) {
            super(nVar, mVar, fVar, z0.a, false);
            m.f(nVar, "storageManager");
            m.f(mVar, "container");
            m.f(fVar, "name");
            this.n = z;
            IntRange intRangeK = kotlin.ranges.l.k(0, i2);
            ArrayList arrayList = new ArrayList(v.u(intRangeK, 10));
            Iterator<Integer> it = intRangeK.iterator();
            while (it.hasNext()) {
                int iB = ((IntIterator) it).b();
                kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVarB = kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
                r1 r1Var = r1.INVARIANT;
                StringBuilder sb = new StringBuilder();
                sb.append('T');
                sb.append(iB);
                arrayList.add(k0.S0(this, gVarB, false, r1Var, f.x(sb.toString()), iB, nVar));
            }
            this.o = arrayList;
            this.p = new l(this, f1.d(this), v0.c(kotlin.reflect.y.internal.j0.i.t.a.l(this).o().i()), nVar);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public boolean A() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public boolean D() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
        public boolean E0() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public Collection<e> J() {
            return u.j();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public boolean J0() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
        public h.b S() {
            return h.b.f24422b;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
        public boolean M() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
        /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
        public l h() {
            return this.p;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
        /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
        public h.b H(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            m.f(gVar, "kotlinTypeRefiner");
            return h.b.f24422b;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public kotlin.p002reflect.jvm.internal.impl.descriptors.d R() {
            return null;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public e U() {
            return null;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
        public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
            return kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
        public u getVisibility() {
            u uVar = t.f25368e;
            m.e(uVar, Store.PUBLIC_ACCESS);
            return uVar;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public f i() {
            return f.CLASS;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public boolean isInline() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
        public d0 j() {
            return d0.FINAL;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> k() {
            return w0.d();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public boolean l() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i
        public boolean m() {
            return this.n;
        }

        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.i
        public List<e1> w() {
            return this.o;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
        public boolean z() {
            return false;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
        public g1<m0> z0() {
            return null;
        }
    }

    /* JADX INFO: compiled from: NotFoundClasses.kt */
    static final class c extends Lambda implements Function1<a, e> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e invoke(a aVar) {
            m mVarD;
            m.f(aVar, "<name for destructuring parameter 0>");
            kotlin.reflect.y.internal.j0.f.b bVarA = aVar.a();
            List<Integer> listB = aVar.b();
            if (bVarA.k()) {
                throw new UnsupportedOperationException("Unresolved local class: " + bVarA);
            }
            kotlin.reflect.y.internal.j0.f.b bVarG = bVarA.g();
            if (bVarG == null || (mVarD = j0.this.d(bVarG, c0.M(listB, 1))) == null) {
                g gVar = j0.this.f25146c;
                kotlin.reflect.y.internal.j0.f.c cVarH = bVarA.h();
                m.e(cVarH, "classId.packageFqName");
                mVarD = (g) gVar.invoke(cVarH);
            }
            m mVar = mVarD;
            boolean zL = bVarA.l();
            n nVar = j0.this.a;
            f fVarJ = bVarA.j();
            m.e(fVarJ, "classId.shortClassName");
            Integer num = (Integer) s.W(listB);
            return new b(nVar, mVar, fVarJ, zL, num != null ? num.intValue() : 0);
        }
    }

    /* JADX INFO: compiled from: NotFoundClasses.kt */
    static final class d extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.c, k0> {
        d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final k0 invoke(kotlin.reflect.y.internal.j0.f.c cVar) {
            m.f(cVar, "fqName");
            return new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.m(j0.this.f25145b, cVar);
        }
    }

    public j0(n nVar, g0 g0Var) {
        m.f(nVar, "storageManager");
        m.f(g0Var, "module");
        this.a = nVar;
        this.f25145b = g0Var;
        this.f25146c = nVar.h(new d());
        this.f25147d = nVar.h(new c());
    }

    public final e d(kotlin.reflect.y.internal.j0.f.b bVar, List<Integer> list) {
        m.f(bVar, "classId");
        m.f(list, "typeParametersCount");
        return this.f25147d.invoke(new a(bVar, list));
    }
}
