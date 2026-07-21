package kotlin.reflect.y.internal.j0.b.p;

import cm.aptoide.pt.dataprovider.model.v7.store.Store;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.IntIterator;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.x;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.ranges.IntRange;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: FunctionClassDescriptor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends kotlin.p002reflect.jvm.internal.impl.descriptors.p1.a {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f23230k = new a(null);
    private static final kotlin.reflect.y.internal.j0.f.b l = new kotlin.reflect.y.internal.j0.f.b(k.r, f.x("Function"));
    private static final kotlin.reflect.y.internal.j0.f.b m = new kotlin.reflect.y.internal.j0.f.b(k.o, f.x("KFunction"));
    private final n n;
    private final k0 o;
    private final c p;
    private final int q;
    private final C0322b r;
    private final d s;
    private final List<e1> t;

    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.b.p.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
    private final class C0322b extends kotlin.reflect.y.internal.j0.l.b {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.b.p.b$b$a */
        /* JADX INFO: compiled from: FunctionClassDescriptor.kt */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[c.values().length];
                iArr[c.f23233g.ordinal()] = 1;
                iArr[c.f23235i.ordinal()] = 2;
                iArr[c.f23234h.ordinal()] = 3;
                iArr[c.f23236j.ordinal()] = 4;
                a = iArr;
            }
        }

        public C0322b() {
            super(b.this.n);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            return b.this.t;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected Collection<e0> l() {
            List<kotlin.reflect.y.internal.j0.f.b> listE;
            int i2 = a.a[b.this.V0().ordinal()];
            if (i2 == 1) {
                listE = t.e(b.l);
            } else if (i2 == 2) {
                listE = u.m(b.m, new kotlin.reflect.y.internal.j0.f.b(k.r, c.f23233g.u(b.this.R0())));
            } else if (i2 == 3) {
                listE = t.e(b.l);
            } else {
                if (i2 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                listE = u.m(b.m, new kotlin.reflect.y.internal.j0.f.b(k.f23199j, c.f23234h.u(b.this.R0())));
            }
            g0 g0VarB = b.this.o.b();
            ArrayList arrayList = new ArrayList(v.u(listE, 10));
            for (kotlin.reflect.y.internal.j0.f.b bVar : listE) {
                e eVarA = x.a(g0VarB, bVar);
                if (eVarA == null) {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
                List listA0 = c0.A0(getParameters(), eVarA.h().getParameters().size());
                ArrayList arrayList2 = new ArrayList(v.u(listA0, 10));
                Iterator it = listA0.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new i1(((e1) it.next()).s()));
                }
                arrayList.add(f0.g(a1.f24676g.h(), eVarA, arrayList2));
            }
            return c0.E0(arrayList);
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected c1 q() {
            return c1.a.a;
        }

        public String toString() {
            return w().toString();
        }

        @Override // kotlin.reflect.y.internal.j0.l.b
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public b w() {
            return b.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(n nVar, k0 k0Var, c cVar, int i2) {
        super(nVar, cVar.u(i2));
        m.f(nVar, "storageManager");
        m.f(k0Var, "containingDeclaration");
        m.f(cVar, "functionKind");
        this.n = nVar;
        this.o = k0Var;
        this.p = cVar;
        this.q = i2;
        this.r = new C0322b();
        this.s = new d(nVar, this);
        ArrayList arrayList = new ArrayList();
        IntRange intRange = new IntRange(1, i2);
        ArrayList arrayList2 = new ArrayList(v.u(intRange, 10));
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            int iB = ((IntIterator) it).b();
            r1 r1Var = r1.IN_VARIANCE;
            StringBuilder sb = new StringBuilder();
            sb.append('P');
            sb.append(iB);
            L0(arrayList, this, r1Var, sb.toString());
            arrayList2.add(kotlin.u.a);
        }
        L0(arrayList, this, r1.OUT_VARIANCE, "R");
        this.t = c0.E0(arrayList);
    }

    private static final void L0(ArrayList<e1> arrayList, b bVar, r1 r1Var, String str) {
        arrayList.add(kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k0.S0(bVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), false, r1Var, f.x(str), arrayList.size(), bVar.n));
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
    public boolean J0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public /* bridge */ /* synthetic */ d R() {
        return (d) Z0();
    }

    public final int R0() {
        return this.q;
    }

    public Void S0() {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: T0, reason: merged with bridge method [inline-methods] */
    public List<d> k() {
        return u.j();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public /* bridge */ /* synthetic */ e U() {
        return (e) S0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.n, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public k0 b() {
        return this.o;
    }

    public final c V0() {
        return this.p;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: W0, reason: merged with bridge method [inline-methods] */
    public List<e> J() {
        return u.j();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public h.b S() {
        return h.b.f24422b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
    /* JADX INFO: renamed from: Y0, reason: merged with bridge method [inline-methods] */
    public d H(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this.s;
    }

    public Void Z0() {
        return null;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        return kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public kotlin.p002reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.u uVar = kotlin.p002reflect.jvm.internal.impl.descriptors.t.f25368e;
        m.e(uVar, Store.PUBLIC_ACCESS);
        return uVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.e1 h() {
        return this.r;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.p002reflect.jvm.internal.impl.descriptors.f i() {
        return kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        return d0.ABSTRACT;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = z0.a;
        m.e(z0Var, "NO_SOURCE");
        return z0Var;
    }

    public String toString() {
        String strK = getName().k();
        m.e(strK, "name.asString()");
        return strK;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public List<e1> w() {
        return this.t;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public g1<m0> z0() {
        return null;
    }
}
