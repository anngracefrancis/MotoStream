package kotlin.reflect.y.internal.j0.i.r;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.k1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements e1 {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f24366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g0 f24367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<e0> f24368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final m0 f24369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f24370f;

    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class a {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.i.r.n$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
        private enum EnumC0378a {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
        public /* synthetic */ class b {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[EnumC0378a.values().length];
                iArr[EnumC0378a.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[EnumC0378a.INTERSECTION_TYPE.ordinal()] = 2;
                a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final m0 a(Collection<? extends m0> collection, EnumC0378a enumC0378a) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator<T> it = collection.iterator();
            if (!it.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it.next();
            while (it.hasNext()) {
                m0 m0Var = (m0) it.next();
                next = n.a.e((m0) next, m0Var, enumC0378a);
            }
            return (m0) next;
        }

        private final m0 c(n nVar, n nVar2, EnumC0378a enumC0378a) {
            Set setA0;
            int i2 = b.a[enumC0378a.ordinal()];
            if (i2 == 1) {
                setA0 = c0.a0(nVar.k(), nVar2.k());
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                setA0 = c0.J0(nVar.k(), nVar2.k());
            }
            return f0.e(a1.f24676g.h(), new n(nVar.f24366b, nVar.f24367c, setA0, null), false);
        }

        private final m0 d(n nVar, m0 m0Var) {
            if (nVar.k().contains(m0Var)) {
                return m0Var;
            }
            return null;
        }

        private final m0 e(m0 m0Var, m0 m0Var2, EnumC0378a enumC0378a) {
            if (m0Var == null || m0Var2 == null) {
                return null;
            }
            e1 e1VarO0 = m0Var.O0();
            e1 e1VarO1 = m0Var2.O0();
            boolean z = e1VarO0 instanceof n;
            if (z && (e1VarO1 instanceof n)) {
                return c((n) e1VarO0, (n) e1VarO1, enumC0378a);
            }
            if (z) {
                return d((n) e1VarO0, m0Var2);
            }
            if (e1VarO1 instanceof n) {
                return d((n) e1VarO1, m0Var);
            }
            return null;
        }

        public final m0 b(Collection<? extends m0> collection) {
            m.f(collection, "types");
            return a(collection, EnumC0378a.INTERSECTION_TYPE);
        }
    }

    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    static final class b extends Lambda implements Function0<List<m0>> {
        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<m0> invoke() {
            m0 m0VarS = n.this.o().x().s();
            m.e(m0VarS, "builtIns.comparable.defaultType");
            List<m0> listP = u.p(k1.f(m0VarS, t.e(new i1(r1.IN_VARIANCE, n.this.f24369e)), null, 2, null));
            if (!n.this.m()) {
                listP.add(n.this.o().L());
            }
            return listP;
        }
    }

    /* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
    static final class c extends Lambda implements Function1<e0, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f24375f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(e0 e0Var) {
            m.f(e0Var, "it");
            return e0Var.toString();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private n(long j2, g0 g0Var, Set<? extends e0> set) {
        this.f24369e = f0.e(a1.f24676g.h(), this, false);
        this.f24370f = i.b(new b());
        this.f24366b = j2;
        this.f24367c = g0Var;
        this.f24368d = set;
    }

    public /* synthetic */ n(long j2, g0 g0Var, Set set, g gVar) {
        this(j2, g0Var, set);
    }

    private final List<e0> l() {
        return (List) this.f24370f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m() {
        Collection<e0> collectionA = t.a(this.f24367c);
        if ((collectionA instanceof Collection) && collectionA.isEmpty()) {
            return true;
        }
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            if (!(!this.f24368d.contains((e0) it.next()))) {
                return false;
            }
        }
        return true;
    }

    private final String n() {
        return '[' + c0.e0(this.f24368d, ",", null, null, 0, null, c.f24375f, 30, null) + ']';
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public Collection<e0> a() {
        return l();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public e1 b(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: c */
    public h w() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<kotlin.p002reflect.jvm.internal.impl.descriptors.e1> getParameters() {
        return u.j();
    }

    public final Set<e0> k() {
        return this.f24368d;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        return this.f24367c.o();
    }

    public String toString() {
        return "IntegerLiteralType" + n();
    }
}
