package kotlin.reflect.y.internal.j0.h;

import cm.aptoide.pt.downloadmanager.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.collections.x0;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.f1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.j1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.s0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.v0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.i.r.q;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.q0;
import kotlin.reflect.y.internal.j0.l.q1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.s1;
import kotlin.text.x;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends kotlin.reflect.y.internal.j0.h.c implements kotlin.reflect.y.internal.j0.h.f {
    private final kotlin.reflect.y.internal.j0.h.g l;
    private final Lazy m;

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    private final class a implements o<u, StringBuilder> {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.h.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
        public /* synthetic */ class C0374a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[l.values().length];
                iArr[l.PRETTY.ordinal()] = 1;
                iArr[l.DEBUG.ordinal()] = 2;
                iArr[l.NONE.ordinal()] = 3;
                a = iArr;
            }
        }

        public a() {
        }

        private final void t(s0 s0Var, StringBuilder sb, String str) {
            int i2 = C0374a.a[d.this.m0().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                p(s0Var, sb);
                return;
            }
            d.this.S0(s0Var, sb);
            sb.append(str + " for ");
            d dVar = d.this;
            t0 t0VarB0 = s0Var.B0();
            m.e(t0VarB0, "descriptor.correspondingProperty");
            dVar.B1(t0VarB0, sb);
        }

        public void A(i1 i1Var, StringBuilder sb) {
            m.f(i1Var, "descriptor");
            m.f(sb, "builder");
            d.this.T1(i1Var, true, sb, true);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u a(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb) {
            n(eVar, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u b(u0 u0Var, StringBuilder sb) {
            v(u0Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u c(p0 p0Var, StringBuilder sb) {
            s(p0Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u d(t0 t0Var, StringBuilder sb) {
            u(t0Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u e(d1 d1Var, StringBuilder sb) {
            y(d1Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u f(k0 k0Var, StringBuilder sb) {
            r(k0Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u g(y yVar, StringBuilder sb) {
            p(yVar, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u h(l lVar, StringBuilder sb) {
            o(lVar, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u i(v0 v0Var, StringBuilder sb) {
            w(v0Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u j(g0 g0Var, StringBuilder sb) {
            q(g0Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u k(i1 i1Var, StringBuilder sb) {
            A(i1Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u l(w0 w0Var, StringBuilder sb) {
            x(w0Var, sb);
            return u.a;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.o
        public /* bridge */ /* synthetic */ u m(e1 e1Var, StringBuilder sb) {
            z(e1Var, sb);
            return u.a;
        }

        public void n(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb) {
            m.f(eVar, "descriptor");
            m.f(sb, "builder");
            d.this.Y0(eVar, sb);
        }

        public void o(l lVar, StringBuilder sb) {
            m.f(lVar, "constructorDescriptor");
            m.f(sb, "builder");
            d.this.d1(lVar, sb);
        }

        public void p(y yVar, StringBuilder sb) {
            m.f(yVar, "descriptor");
            m.f(sb, "builder");
            d.this.j1(yVar, sb);
        }

        public void q(g0 g0Var, StringBuilder sb) {
            m.f(g0Var, "descriptor");
            m.f(sb, "builder");
            d.this.t1(g0Var, sb, true);
        }

        public void r(k0 k0Var, StringBuilder sb) {
            m.f(k0Var, "descriptor");
            m.f(sb, "builder");
            d.this.x1(k0Var, sb);
        }

        public void s(p0 p0Var, StringBuilder sb) {
            m.f(p0Var, "descriptor");
            m.f(sb, "builder");
            d.this.z1(p0Var, sb);
        }

        public void u(t0 t0Var, StringBuilder sb) {
            m.f(t0Var, "descriptor");
            m.f(sb, "builder");
            d.this.B1(t0Var, sb);
        }

        public void v(u0 u0Var, StringBuilder sb) {
            m.f(u0Var, "descriptor");
            m.f(sb, "builder");
            t(u0Var, sb, "getter");
        }

        public void w(v0 v0Var, StringBuilder sb) {
            m.f(v0Var, "descriptor");
            m.f(sb, "builder");
            t(v0Var, sb, "setter");
        }

        public void x(w0 w0Var, StringBuilder sb) {
            m.f(w0Var, "descriptor");
            m.f(sb, "builder");
            sb.append(w0Var.getName());
        }

        public void y(d1 d1Var, StringBuilder sb) {
            m.f(d1Var, "descriptor");
            m.f(sb, "builder");
            d.this.J1(d1Var, sb);
        }

        public void z(e1 e1Var, StringBuilder sb) {
            m.f(e1Var, "descriptor");
            m.f(sb, "builder");
            d.this.O1(e1Var, sb, true);
        }
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f24267b;

        static {
            int[] iArr = new int[m.values().length];
            iArr[m.PLAIN.ordinal()] = 1;
            iArr[m.HTML.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[k.values().length];
            iArr2[k.ALL.ordinal()] = 1;
            iArr2[k.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[k.NONE.ordinal()] = 3;
            f24267b = iArr2;
        }
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    static final class c extends Lambda implements Function1<g1, CharSequence> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(g1 g1Var) {
            m.f(g1Var, "it");
            if (g1Var.c()) {
                return "*";
            }
            d dVar = d.this;
            e0 type = g1Var.getType();
            m.e(type, "it.type");
            String strW = dVar.w(type);
            if (g1Var.a() == r1.INVARIANT) {
                return strW;
            }
            return g1Var.a() + ' ' + strW;
        }
    }

    /* JADX INFO: renamed from: kotlin.f0.y.e.j0.h.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    static final class C0375d extends Lambda implements Function0<d> {

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.h.d$d$a */
        /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
        static final class a extends Lambda implements Function1<kotlin.reflect.y.internal.j0.h.f, u> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final a f24270f = new a();

            a() {
                super(1);
            }

            public final void b(kotlin.reflect.y.internal.j0.h.f fVar) {
                m.f(fVar, "$this$withOptions");
                fVar.a(x0.l(fVar.m(), kotlin.collections.u.m(k.a.C, k.a.D)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ u invoke(kotlin.reflect.y.internal.j0.h.f fVar) {
                b(fVar);
                return u.a;
            }
        }

        C0375d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final d invoke() {
            kotlin.reflect.y.internal.j0.h.c cVarY = d.this.y(a.f24270f);
            m.d(cVarY, "null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
            return (d) cVarY;
        }
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    static final class e extends Lambda implements Function1<kotlin.reflect.y.internal.j0.i.r.g<?>, CharSequence> {
        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(kotlin.reflect.y.internal.j0.i.r.g<?> gVar) {
            m.f(gVar, "it");
            return d.this.c1(gVar);
        }
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    static final class f extends Lambda implements Function1<i1, CharSequence> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final f f24272f = new f();

        f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(i1 i1Var) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    static final class g extends Lambda implements Function1<e0, CharSequence> {
        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(e0 e0Var) {
            d dVar = d.this;
            m.e(e0Var, "it");
            return dVar.w(e0Var);
        }
    }

    /* JADX INFO: compiled from: DescriptorRendererImpl.kt */
    static final class h extends Lambda implements Function1<e0, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final h f24274f = new h();

        h() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(e0 e0Var) {
            m.f(e0Var, "it");
            return e0Var instanceof kotlin.reflect.y.internal.j0.l.u0 ? ((kotlin.reflect.y.internal.j0.l.u0) e0Var).X0() : e0Var;
        }
    }

    public d(kotlin.reflect.y.internal.j0.h.g gVar) {
        m.f(gVar, "options");
        this.l = gVar;
        gVar.k0();
        this.m = i.b(new C0375d());
    }

    private final void A1(StringBuilder sb, r0 r0Var) {
        r0 r0VarC = r0Var.c();
        if (r0VarC != null) {
            A1(sb, r0VarC);
            sb.append('.');
            kotlin.reflect.y.internal.j0.f.f name = r0Var.b().getName();
            m.e(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(v(name, false));
        } else {
            kotlin.reflect.y.internal.j0.l.e1 e1VarH = r0Var.b().h();
            m.e(e1VarH, "possiblyInnerType.classi…escriptor.typeConstructor");
            sb.append(L1(e1VarH));
        }
        sb.append(K1(r0Var.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(t0 t0Var, StringBuilder sb) {
        if (!z0()) {
            if (!y0()) {
                C1(t0Var, sb);
                List<w0> listR0 = t0Var.r0();
                m.e(listR0, "property.contextReceiverParameters");
                e1(listR0, sb);
                kotlin.p002reflect.jvm.internal.impl.descriptors.u visibility = t0Var.getVisibility();
                m.e(visibility, "property.visibility");
                W1(visibility, sb);
                boolean z = false;
                s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.CONST) && t0Var.isConst(), "const");
                o1(t0Var, sb);
                r1(t0Var, sb);
                w1(t0Var, sb);
                if (f0().contains(kotlin.reflect.y.internal.j0.h.e.LATEINIT) && t0Var.s0()) {
                    z = true;
                }
                s1(sb, z, "lateinit");
                n1(t0Var, sb);
            }
            S1(this, t0Var, sb, false, 4, null);
            List<e1> typeParameters = t0Var.getTypeParameters();
            m.e(typeParameters, "property.typeParameters");
            Q1(typeParameters, sb, true);
            D1(t0Var, sb);
        }
        t1(t0Var, sb, true);
        sb.append(": ");
        e0 type = t0Var.getType();
        m.e(type, "property.type");
        sb.append(w(type));
        E1(t0Var, sb);
        l1(t0Var, sb);
        List<e1> typeParameters2 = t0Var.getTypeParameters();
        m.e(typeParameters2, "property.typeParameters");
        X1(typeParameters2, sb);
    }

    private final void C1(t0 t0Var, StringBuilder sb) {
        if (f0().contains(kotlin.reflect.y.internal.j0.h.e.ANNOTATIONS)) {
            W0(this, sb, t0Var, null, 2, null);
            w wVarQ0 = t0Var.q0();
            if (wVarQ0 != null) {
                V0(sb, wVarQ0, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e.FIELD);
            }
            w wVarN0 = t0Var.n0();
            if (wVarN0 != null) {
                V0(sb, wVarN0, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e.PROPERTY_DELEGATE_FIELD);
            }
            if (m0() == l.NONE) {
                u0 getter = t0Var.getGetter();
                if (getter != null) {
                    V0(sb, getter, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e.PROPERTY_GETTER);
                }
                v0 setter = t0Var.getSetter();
                if (setter != null) {
                    V0(sb, setter, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e.PROPERTY_SETTER);
                    List<i1> listF = setter.f();
                    m.e(listF, "setter.valueParameters");
                    i1 i1Var = (i1) s.s0(listF);
                    m.e(i1Var, "it");
                    V0(sb, i1Var, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e.SETTER_PARAMETER);
                }
            }
        }
    }

    private final void D1(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb) {
        w0 w0VarM0 = aVar.m0();
        if (w0VarM0 != null) {
            V0(sb, w0VarM0, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e.RECEIVER);
            e0 type = w0VarM0.getType();
            m.e(type, "receiver.type");
            sb.append(h1(type));
            sb.append(".");
        }
    }

    private final void E1(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb) {
        w0 w0VarM0;
        if (n0() && (w0VarM0 = aVar.m0()) != null) {
            sb.append(" on ");
            e0 type = w0VarM0.getType();
            m.e(type, "receiver.type");
            sb.append(w(type));
        }
    }

    private final void F1(StringBuilder sb, m0 m0Var) {
        if (m.a(m0Var, n1.f24766b) || n1.k(m0Var)) {
            sb.append("???");
            return;
        }
        if (kotlin.reflect.y.internal.j0.l.u1.k.o(m0Var)) {
            if (!C0()) {
                sb.append("???");
                return;
            }
            kotlin.reflect.y.internal.j0.l.e1 e1VarO0 = m0Var.O0();
            m.d(e1VarO0, "null cannot be cast to non-null type org.jetbrains.kotlin.types.error.ErrorTypeConstructor");
            sb.append(g1(((kotlin.reflect.y.internal.j0.l.u1.i) e1VarO0).h(0)));
            return;
        }
        if (kotlin.reflect.y.internal.j0.l.g0.a(m0Var)) {
            f1(sb, m0Var);
        } else if (Z1(m0Var)) {
            k1(sb, m0Var);
        } else {
            f1(sb, m0Var);
        }
    }

    private final void G1(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final void H1(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb) {
        if (J0() || kotlin.reflect.y.internal.j0.b.h.m0(eVar.s())) {
            return;
        }
        Collection<e0> collectionA = eVar.h().a();
        m.e(collectionA, "klass.typeConstructor.supertypes");
        if (collectionA.isEmpty()) {
            return;
        }
        if (collectionA.size() == 1 && kotlin.reflect.y.internal.j0.b.h.b0(collectionA.iterator().next())) {
            return;
        }
        G1(sb);
        sb.append(": ");
        c0.c0(collectionA, sb, ", ", null, null, 0, null, new g(), 60, null);
    }

    private final void I1(y yVar, StringBuilder sb) {
        s1(sb, yVar.isSuspend(), "suspend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(d1 d1Var, StringBuilder sb) {
        W0(this, sb, d1Var, null, 2, null);
        kotlin.p002reflect.jvm.internal.impl.descriptors.u visibility = d1Var.getVisibility();
        m.e(visibility, "typeAlias.visibility");
        W1(visibility, sb);
        o1(d1Var, sb);
        sb.append(m1("typealias"));
        sb.append(" ");
        t1(d1Var, sb, true);
        List<e1> listW = d1Var.w();
        m.e(listW, "typeAlias.declaredTypeParameters");
        Q1(listW, sb, false);
        X0(d1Var, sb);
        sb.append(" = ");
        sb.append(w(d1Var.g0()));
    }

    private final void L(StringBuilder sb, kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB;
        String name;
        if ((mVar instanceof k0) || (mVar instanceof p0) || (mVarB = mVar.b()) == null || (mVarB instanceof g0)) {
            return;
        }
        sb.append(" ");
        sb.append(p1("defined in"));
        sb.append(" ");
        kotlin.reflect.y.internal.j0.f.d dVarM = kotlin.reflect.y.internal.j0.i.d.m(mVarB);
        m.e(dVarM, "getFqName(containingDeclaration)");
        sb.append(dVarM.e() ? "root package" : u(dVarM));
        if (H0() && (mVarB instanceof k0) && (mVar instanceof p) && (name = ((p) mVar).t().a().getName()) != null) {
            sb.append(" ");
            sb.append(p1("in file"));
            sb.append(" ");
            sb.append(name);
        }
    }

    private final String L0() {
        return P(">");
    }

    private final void M(StringBuilder sb, List<? extends g1> list) {
        c0.c0(list, sb, ", ", null, null, 0, null, new c(), 60, null);
    }

    private final boolean M0(e0 e0Var) {
        return kotlin.reflect.y.internal.j0.b.g.q(e0Var) || !e0Var.getAnnotations().isEmpty();
    }

    private final void M1(StringBuilder sb, e0 e0Var, kotlin.reflect.y.internal.j0.l.e1 e1Var) {
        r0 r0VarA = f1.a(e0Var);
        if (r0VarA != null) {
            A1(sb, r0VarA);
        } else {
            sb.append(L1(e1Var));
            sb.append(K1(e0Var.M0()));
        }
    }

    private final String N() {
        int i2 = b.a[A0().ordinal()];
        if (i2 == 1) {
            return P("->");
        }
        if (i2 == 2) {
            return "&rarr;";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final d0 N0(kotlin.p002reflect.jvm.internal.impl.descriptors.c0 c0Var) {
        if (c0Var instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) {
            return ((kotlin.p002reflect.jvm.internal.impl.descriptors.e) c0Var).i() == kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE ? d0.ABSTRACT : d0.FINAL;
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = c0Var.b();
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar = mVarB instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? (kotlin.p002reflect.jvm.internal.impl.descriptors.e) mVarB : null;
        if (eVar != null && (c0Var instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.b)) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.p002reflect.jvm.internal.impl.descriptors.b) c0Var;
            Collection<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.b> collectionE = bVar.e();
            m.e(collectionE, "this.overriddenDescriptors");
            if ((!collectionE.isEmpty()) && eVar.j() != d0.FINAL) {
                return d0.OPEN;
            }
            if (eVar.i() != kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE || m.a(bVar.getVisibility(), t.a)) {
                return d0.FINAL;
            }
            d0 d0VarJ = bVar.j();
            d0 d0Var = d0.ABSTRACT;
            return d0VarJ == d0Var ? d0Var : d0.OPEN;
        }
        return d0.FINAL;
    }

    static /* synthetic */ void N1(d dVar, StringBuilder sb, e0 e0Var, kotlin.reflect.y.internal.j0.l.e1 e1Var, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            e1Var = e0Var.O0();
        }
        dVar.M1(sb, e0Var, e1Var);
    }

    /* JADX WARN: Code duplicated, block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0034  */
    /* JADX WARN: Instruction removed from duplicated block: B:8:0x0034, please report this as an issue */
    private final boolean O(String str, String str2) {
        if (!m.a(str, kotlin.text.u.A(str2, "?", HttpUrl.FRAGMENT_ENCODE_SET, false, 4, null))) {
            if (kotlin.text.u.p(str2, "?", false, 2, null)) {
                if (!m.a(str + '?', str2)) {
                    if (m.a('(' + str + ")?", str2)) {
                        return false;
                    }
                }
            } else {
                if (m.a('(' + str + ")?", str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean O0(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVar) {
        return m.a(cVar.d(), k.a.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(e1 e1Var, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(P0());
        }
        if (F0()) {
            sb.append("/*");
            sb.append(e1Var.g());
            sb.append("*/ ");
        }
        s1(sb, e1Var.F(), "reified");
        String strQ = e1Var.n().q();
        boolean z2 = true;
        s1(sb, strQ.length() > 0, strQ);
        W0(this, sb, e1Var, null, 2, null);
        t1(e1Var, sb, z);
        int size = e1Var.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            e0 next = e1Var.getUpperBounds().iterator().next();
            if (!kotlin.reflect.y.internal.j0.b.h.i0(next)) {
                sb.append(" : ");
                m.e(next, "upperBound");
                sb.append(w(next));
            }
        } else if (z) {
            for (e0 e0Var : e1Var.getUpperBounds()) {
                if (!kotlin.reflect.y.internal.j0.b.h.i0(e0Var)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    m.e(e0Var, "upperBound");
                    sb.append(w(e0Var));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(L0());
        }
    }

    private final String P(String str) {
        return A0().k(str);
    }

    private final String P0() {
        return P("<");
    }

    private final void P1(StringBuilder sb, List<? extends e1> list) {
        Iterator<? extends e1> it = list.iterator();
        while (it.hasNext()) {
            O1(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    private final boolean Q0(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar) {
        return !bVar.e().isEmpty();
    }

    private final void Q1(List<? extends e1> list, StringBuilder sb, boolean z) {
        if (!K0() && (!list.isEmpty())) {
            sb.append(P0());
            P1(sb, list);
            sb.append(L0());
            if (z) {
                sb.append(" ");
            }
        }
    }

    private final void R0(StringBuilder sb, kotlin.reflect.y.internal.j0.l.a aVar) {
        m mVarA0 = A0();
        m mVar = m.HTML;
        if (mVarA0 == mVar) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        v1(sb, aVar.W());
        sb.append(" */");
        if (A0() == mVar) {
            sb.append("</i></font>");
        }
    }

    private final void R1(j1 j1Var, StringBuilder sb, boolean z) {
        if (z || !(j1Var instanceof i1)) {
            sb.append(m1(j1Var.j0() ? "var" : "val"));
            sb.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(s0 s0Var, StringBuilder sb) {
        o1(s0Var, sb);
    }

    static /* synthetic */ void S1(d dVar, j1 j1Var, StringBuilder sb, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        dVar.R1(j1Var, sb, z);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x003a  */
    private final void T0(y yVar, StringBuilder sb) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        if (yVar.Q()) {
            Collection<? extends y> collectionE = yVar.e();
            m.e(collectionE, "functionDescriptor.overriddenDescriptors");
            if (!collectionE.isEmpty()) {
                Iterator<T> it = collectionE.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = true;
                        break;
                    } else if (((y) it.next()).Q()) {
                        z3 = false;
                        break;
                    }
                }
            } else {
                z3 = true;
                break;
            }
            if (z3 || R()) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        if (yVar.H0()) {
            Collection<? extends y> collectionE2 = yVar.e();
            m.e(collectionE2, "functionDescriptor.overriddenDescriptors");
            if (!collectionE2.isEmpty()) {
                Iterator<T> it2 = collectionE2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    } else if (((y) it2.next()).H0()) {
                        z2 = false;
                        break;
                    }
                }
            } else {
                z2 = true;
                break;
            }
            if (z2 || R()) {
                z4 = true;
            }
        }
        s1(sb, yVar.P(), "tailrec");
        I1(yVar, sb);
        s1(sb, yVar.isInline(), "inline");
        s1(sb, z4, "infix");
        s1(sb, z, "operator");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:20:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0091  */
    public final void T1(i1 i1Var, boolean z, StringBuilder sb, boolean z2) {
        boolean z3;
        boolean z4;
        if (z2) {
            sb.append(m1("value-parameter"));
            sb.append(" ");
        }
        if (F0()) {
            sb.append("/*");
            sb.append(i1Var.g());
            sb.append("*/ ");
        }
        W0(this, sb, i1Var, null, 2, null);
        s1(sb, i1Var.b0(), "crossinline");
        s1(sb, i1Var.Y(), "noinline");
        if (u0()) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.a aVarB = i1Var.b();
            kotlin.p002reflect.jvm.internal.impl.descriptors.d dVar = aVarB instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.d ? (kotlin.p002reflect.jvm.internal.impl.descriptors.d) aVarB : null;
            if (dVar != null && dVar.B()) {
                z3 = true;
            } else {
                z3 = false;
            }
        } else {
            z3 = false;
        }
        if (z3) {
            s1(sb, Q(), "actual");
        }
        V1(i1Var, z, sb, z2, z3);
        if (W() != null) {
            z4 = n() ? i1Var.u0() : kotlin.reflect.y.internal.j0.i.t.a.a(i1Var);
        }
        if (z4) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" = ");
            Function1<i1, String> function1W = W();
            m.c(function1W);
            sb2.append(function1W.invoke(i1Var));
            sb.append(sb2.toString());
        }
    }

    private final List<String> U0(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVar) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.d dVarR;
        List<i1> listF;
        Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> mapA = cVar.a();
        List listJ = null;
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarE = r0() ? kotlin.reflect.y.internal.j0.i.t.a.e(cVar) : null;
        if (eVarE != null && (dVarR = eVarE.R()) != null && (listF = dVarR.f()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF) {
                if (((i1) obj).u0()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(v.u(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((i1) it.next()).getName());
            }
            listJ = arrayList2;
        }
        if (listJ == null) {
            listJ = kotlin.collections.u.j();
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : listJ) {
            kotlin.reflect.y.internal.j0.f.f fVar = (kotlin.reflect.y.internal.j0.f.f) obj2;
            m.e(fVar, "it");
            if (!mapA.containsKey(fVar)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(v.u(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((kotlin.reflect.y.internal.j0.f.f) it2.next()).k() + " = ...");
        }
        Set<Map.Entry<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>>> setEntrySet = mapA.entrySet();
        ArrayList arrayList5 = new ArrayList(v.u(setEntrySet, 10));
        Iterator<T> it3 = setEntrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            kotlin.reflect.y.internal.j0.f.f fVar2 = (kotlin.reflect.y.internal.j0.f.f) entry.getKey();
            kotlin.reflect.y.internal.j0.i.r.g<?> gVar = (kotlin.reflect.y.internal.j0.i.r.g) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(fVar2.k());
            sb.append(" = ");
            sb.append(!listJ.contains(fVar2) ? c1(gVar) : "...");
            arrayList5.add(sb.toString());
        }
        return c0.w0(c0.o0(arrayList4, arrayList5));
    }

    private final void U1(Collection<? extends i1> collection, boolean z, StringBuilder sb) {
        boolean zA2 = a2(z);
        int size = collection.size();
        E0().b(size, sb);
        int i2 = 0;
        for (i1 i1Var : collection) {
            E0().a(i1Var, i2, size, sb);
            T1(i1Var, zA2, sb, false);
            E0().d(i1Var, i2, size, sb);
            i2++;
        }
        E0().c(size, sb);
    }

    private final void V0(StringBuilder sb, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e eVar) {
        if (f0().contains(kotlin.reflect.y.internal.j0.h.e.ANNOTATIONS)) {
            Set<kotlin.reflect.y.internal.j0.f.c> setM = aVar instanceof e0 ? m() : Y();
            Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c, Boolean> function1S = S();
            for (kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVar : aVar.getAnnotations()) {
                if (!c0.K(setM, cVar.d()) && !O0(cVar) && (function1S == null || function1S.invoke(cVar).booleanValue())) {
                    sb.append(r(cVar, eVar));
                    if (X()) {
                        sb.append('\n');
                        m.e(sb, "append('\\n')");
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    private final void V1(j1 j1Var, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        e0 type = j1Var.getType();
        m.e(type, "variable.type");
        i1 i1Var = j1Var instanceof i1 ? (i1) j1Var : null;
        e0 e0VarL0 = i1Var != null ? i1Var.l0() : null;
        e0 e0Var = e0VarL0 == null ? type : e0VarL0;
        s1(sb, e0VarL0 != null, "vararg");
        if (z3 || (z2 && !z0())) {
            R1(j1Var, sb, z3);
        }
        if (z) {
            t1(j1Var, sb, z2);
            sb.append(": ");
        }
        sb.append(w(e0Var));
        l1(j1Var, sb);
        if (!F0() || e0VarL0 == null) {
            return;
        }
        sb.append(" /*");
        sb.append(w(type));
        sb.append("*/");
    }

    static /* synthetic */ void W0(d dVar, StringBuilder sb, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e eVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            eVar = null;
        }
        dVar.V0(sb, aVar, eVar);
    }

    private final boolean W1(kotlin.p002reflect.jvm.internal.impl.descriptors.u uVar, StringBuilder sb) {
        if (!f0().contains(kotlin.reflect.y.internal.j0.h.e.VISIBILITY)) {
            return false;
        }
        if (g0()) {
            uVar = uVar.f();
        }
        if (!t0() && m.a(uVar, t.l)) {
            return false;
        }
        sb.append(m1(uVar.c()));
        sb.append(" ");
        return true;
    }

    private final void X0(kotlin.p002reflect.jvm.internal.impl.descriptors.i iVar, StringBuilder sb) {
        List<e1> listW = iVar.w();
        m.e(listW, "classifier.declaredTypeParameters");
        List<e1> parameters = iVar.h().getParameters();
        m.e(parameters, "classifier.typeConstructor.parameters");
        if (F0() && iVar.m() && parameters.size() > listW.size()) {
            sb.append(" /*captured type parameters: ");
            P1(sb, parameters.subList(listW.size(), parameters.size()));
            sb.append("*/");
        }
    }

    private final void X1(List<? extends e1> list, StringBuilder sb) {
        if (K0()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (e1 e1Var : list) {
            List<e0> upperBounds = e1Var.getUpperBounds();
            m.e(upperBounds, "typeParameter.upperBounds");
            for (e0 e0Var : c0.M(upperBounds, 1)) {
                StringBuilder sb2 = new StringBuilder();
                kotlin.reflect.y.internal.j0.f.f name = e1Var.getName();
                m.e(name, "typeParameter.name");
                sb2.append(v(name, false));
                sb2.append(" : ");
                m.e(e0Var, "it");
                sb2.append(w(e0Var));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(m1("where"));
            sb.append(" ");
            c0.c0(arrayList, sb, ", ", null, null, 0, null, null, 124, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb) {
        kotlin.p002reflect.jvm.internal.impl.descriptors.d dVarR;
        boolean z = eVar.i() == kotlin.p002reflect.jvm.internal.impl.descriptors.f.ENUM_ENTRY;
        if (!z0()) {
            W0(this, sb, eVar, null, 2, null);
            List<w0> listF0 = eVar.F0();
            m.e(listF0, "klass.contextReceivers");
            e1(listF0, sb);
            if (!z) {
                kotlin.p002reflect.jvm.internal.impl.descriptors.u visibility = eVar.getVisibility();
                m.e(visibility, "klass.visibility");
                W1(visibility, sb);
            }
            if ((eVar.i() != kotlin.p002reflect.jvm.internal.impl.descriptors.f.INTERFACE || eVar.j() != d0.ABSTRACT) && (!eVar.i().k() || eVar.j() != d0.FINAL)) {
                d0 d0VarJ = eVar.j();
                m.e(d0VarJ, "klass.modality");
                q1(d0VarJ, sb, N0(eVar));
            }
            o1(eVar, sb);
            s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.INNER) && eVar.m(), "inner");
            s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.DATA) && eVar.J0(), "data");
            s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.INLINE) && eVar.isInline(), "inline");
            s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.VALUE) && eVar.l(), "value");
            s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.FUN) && eVar.D(), "fun");
            Z0(eVar, sb);
        }
        if (kotlin.reflect.y.internal.j0.i.d.x(eVar)) {
            b1(eVar, sb);
        } else {
            if (!z0()) {
                G1(sb);
            }
            t1(eVar, sb, true);
        }
        if (z) {
            return;
        }
        List<e1> listW = eVar.w();
        m.e(listW, "klass.declaredTypeParameters");
        Q1(listW, sb, false);
        X0(eVar, sb);
        if (!eVar.i().k() && U() && (dVarR = eVar.R()) != null) {
            sb.append(" ");
            W0(this, sb, dVarR, null, 2, null);
            kotlin.p002reflect.jvm.internal.impl.descriptors.u visibility2 = dVarR.getVisibility();
            m.e(visibility2, "primaryConstructor.visibility");
            W1(visibility2, sb);
            sb.append(m1("constructor"));
            List<i1> listF = dVarR.f();
            m.e(listF, "primaryConstructor.valueParameters");
            U1(listF, dVarR.G(), sb);
        }
        H1(eVar, sb);
        X1(listW, sb);
    }

    private final String Y1(String str, String str2, String str3, String str4, String str5) {
        if (kotlin.text.u.E(str, str2, false, 2, null) && kotlin.text.u.E(str3, str4, false, 2, null)) {
            String strSubstring = str.substring(str2.length());
            m.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            String strSubstring2 = str3.substring(str4.length());
            m.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
            String str6 = str5 + strSubstring;
            if (m.a(strSubstring, strSubstring2)) {
                return str6;
            }
            if (O(strSubstring, strSubstring2)) {
                return str6 + '!';
            }
        }
        return null;
    }

    private final d Z() {
        return (d) this.m.getValue();
    }

    private final void Z0(kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar, StringBuilder sb) {
        sb.append(m1(kotlin.reflect.y.internal.j0.h.c.a.a(eVar)));
    }

    private final boolean Z1(e0 e0Var) {
        boolean z;
        if (!kotlin.reflect.y.internal.j0.b.g.o(e0Var)) {
            return false;
        }
        List<g1> listM0 = e0Var.M0();
        if ((listM0 instanceof Collection) && listM0.isEmpty()) {
            z = true;
        } else {
            Iterator<T> it = listM0.iterator();
            while (it.hasNext()) {
                if (((g1) it.next()).c()) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private final boolean a2(boolean z) {
        int i2 = b.f24267b[j0().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            }
            if (z) {
                return false;
            }
        }
        return true;
    }

    private final void b1(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, StringBuilder sb) {
        if (o0()) {
            if (z0()) {
                sb.append("companion object");
            }
            G1(sb);
            kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = mVar.b();
            if (mVarB != null) {
                sb.append("of ");
                kotlin.reflect.y.internal.j0.f.f name = mVarB.getName();
                m.e(name, "containingDeclaration.name");
                sb.append(v(name, false));
            }
        }
        if (F0() || !m.a(mVar.getName(), kotlin.reflect.y.internal.j0.f.h.f24218d)) {
            if (!z0()) {
                G1(sb);
            }
            kotlin.reflect.y.internal.j0.f.f name2 = mVar.getName();
            m.e(name2, "descriptor.name");
            sb.append(v(name2, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c1(kotlin.reflect.y.internal.j0.i.r.g<?> gVar) {
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.b) {
            return c0.e0(((kotlin.reflect.y.internal.j0.i.r.b) gVar).b(), ", ", "{", "}", 0, null, new e(), 24, null);
        }
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.a) {
            return kotlin.text.v.m0(kotlin.reflect.y.internal.j0.h.c.s(this, ((kotlin.reflect.y.internal.j0.i.r.a) gVar).b(), null, 2, null), "@");
        }
        if (!(gVar instanceof q)) {
            return gVar.toString();
        }
        q.b bVarB = ((q) gVar).b();
        if (bVarB instanceof q.b.a) {
            return ((q.b.a) bVarB).a() + "::class";
        }
        if (!(bVarB instanceof q.b.C0379b)) {
            throw new NoWhenBranchMatchedException();
        }
        q.b.C0379b c0379b = (q.b.C0379b) bVarB;
        String strB = c0379b.b().b().b();
        m.e(strB, "classValue.classId.asSingleFqName().asString()");
        for (int i2 = 0; i2 < c0379b.a(); i2++) {
            strB = "kotlin.Array<" + strB + '>';
        }
        return strB + "::class";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x0037  */
    public final void d1(l lVar, StringBuilder sb) {
        boolean z;
        kotlin.p002reflect.jvm.internal.impl.descriptors.d dVarR;
        W0(this, sb, lVar, null, 2, null);
        if (this.l.S() || lVar.C().j() != d0.SEALED) {
            kotlin.p002reflect.jvm.internal.impl.descriptors.u visibility = lVar.getVisibility();
            m.e(visibility, "constructor.visibility");
            if (W1(visibility, sb)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        n1(lVar, sb);
        boolean z2 = q0() || !lVar.B() || z;
        if (z2) {
            sb.append(m1("constructor"));
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.i iVarB = lVar.b();
        m.e(iVarB, "constructor.containingDeclaration");
        if (x0()) {
            if (z2) {
                sb.append(" ");
            }
            t1(iVarB, sb, true);
            List<e1> typeParameters = lVar.getTypeParameters();
            m.e(typeParameters, "constructor.typeParameters");
            Q1(typeParameters, sb, false);
        }
        List<i1> listF = lVar.f();
        m.e(listF, "constructor.valueParameters");
        U1(listF, lVar.G(), sb);
        if (p0() && !lVar.B() && (iVarB instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e) && (dVarR = ((kotlin.p002reflect.jvm.internal.impl.descriptors.e) iVarB).R()) != null) {
            List<i1> listF2 = dVarR.f();
            m.e(listF2, "primaryConstructor.valueParameters");
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF2) {
                i1 i1Var = (i1) obj;
                if (!i1Var.u0() && i1Var.l0() == null) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                sb.append(" : ");
                sb.append(m1("this"));
                sb.append(c0.e0(arrayList, ", ", "(", ")", 0, null, f.f24272f, 24, null));
            }
        }
        if (x0()) {
            List<e1> typeParameters2 = lVar.getTypeParameters();
            m.e(typeParameters2, "constructor.typeParameters");
            X1(typeParameters2, sb);
        }
    }

    private final void e1(List<? extends w0> list, StringBuilder sb) {
        if (!list.isEmpty()) {
            sb.append("context(");
            int i2 = 0;
            for (w0 w0Var : list) {
                int i3 = i2 + 1;
                V0(sb, w0Var, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e.RECEIVER);
                e0 type = w0Var.getType();
                m.e(type, "contextReceiver.type");
                sb.append(h1(type));
                if (i2 == kotlin.collections.u.l(list)) {
                    sb.append(") ");
                } else {
                    sb.append(", ");
                }
                i2 = i3;
            }
        }
    }

    private final void f1(StringBuilder sb, e0 e0Var) {
        W0(this, sb, e0Var, null, 2, null);
        kotlin.reflect.y.internal.j0.l.p pVar = e0Var instanceof kotlin.reflect.y.internal.j0.l.p ? (kotlin.reflect.y.internal.j0.l.p) e0Var : null;
        m0 m0VarA1 = pVar != null ? pVar.a1() : null;
        if (kotlin.reflect.y.internal.j0.l.g0.a(e0Var)) {
            if (kotlin.reflect.y.internal.j0.l.x1.a.r(e0Var) && l0()) {
                sb.append(((kotlin.reflect.y.internal.j0.l.u1.h) e0Var).X0());
            } else if (!(e0Var instanceof kotlin.reflect.y.internal.j0.l.u1.h) || e0()) {
                sb.append(e0Var.O0().toString());
            } else {
                sb.append(((kotlin.reflect.y.internal.j0.l.u1.h) e0Var).X0());
            }
            sb.append(K1(e0Var.M0()));
        } else if (e0Var instanceof kotlin.reflect.y.internal.j0.l.u0) {
            sb.append(((kotlin.reflect.y.internal.j0.l.u0) e0Var).X0().toString());
        } else if (m0VarA1 instanceof kotlin.reflect.y.internal.j0.l.u0) {
            sb.append(((kotlin.reflect.y.internal.j0.l.u0) m0VarA1).X0().toString());
        } else {
            N1(this, sb, e0Var, null, 2, null);
        }
        if (e0Var.P0()) {
            sb.append("?");
        }
        if (q0.c(e0Var)) {
            sb.append(" & Any");
        }
    }

    private final String g1(String str) {
        int i2 = b.a[A0().ordinal()];
        if (i2 == 1) {
            return str;
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "<font color=red><b>" + str + "</b></font>";
    }

    private final String h1(e0 e0Var) {
        String strW = w(e0Var);
        if (!Z1(e0Var) || n1.l(e0Var)) {
            return strW;
        }
        return '(' + strW + ')';
    }

    private final String i1(List<kotlin.reflect.y.internal.j0.f.f> list) {
        return P(n.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(y yVar, StringBuilder sb) {
        if (!z0()) {
            if (!y0()) {
                W0(this, sb, yVar, null, 2, null);
                List<w0> listR0 = yVar.r0();
                m.e(listR0, "function.contextReceiverParameters");
                e1(listR0, sb);
                kotlin.p002reflect.jvm.internal.impl.descriptors.u visibility = yVar.getVisibility();
                m.e(visibility, "function.visibility");
                W1(visibility, sb);
                r1(yVar, sb);
                if (a0()) {
                    o1(yVar, sb);
                }
                w1(yVar, sb);
                if (a0()) {
                    T0(yVar, sb);
                } else {
                    I1(yVar, sb);
                }
                n1(yVar, sb);
                if (F0()) {
                    if (yVar.w0()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (yVar.C0()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(m1("fun"));
            sb.append(" ");
            List<e1> typeParameters = yVar.getTypeParameters();
            m.e(typeParameters, "function.typeParameters");
            Q1(typeParameters, sb, true);
            D1(yVar, sb);
        }
        t1(yVar, sb, true);
        List<i1> listF = yVar.f();
        m.e(listF, "function.valueParameters");
        U1(listF, yVar.G(), sb);
        E1(yVar, sb);
        e0 returnType = yVar.getReturnType();
        if (!I0() && (D0() || returnType == null || !kotlin.reflect.y.internal.j0.b.h.B0(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : w(returnType));
        }
        List<e1> typeParameters2 = yVar.getTypeParameters();
        m.e(typeParameters2, "function.typeParameters");
        X1(typeParameters2, sb);
    }

    private final void k1(StringBuilder sb, e0 e0Var) {
        kotlin.reflect.y.internal.j0.f.f fVarD;
        int length = sb.length();
        W0(Z(), sb, e0Var, null, 2, null);
        boolean z = sb.length() != length;
        e0 e0VarJ = kotlin.reflect.y.internal.j0.b.g.j(e0Var);
        List<e0> listE = kotlin.reflect.y.internal.j0.b.g.e(e0Var);
        if (!listE.isEmpty()) {
            sb.append("context(");
            Iterator<e0> it = listE.subList(0, kotlin.collections.u.l(listE)).iterator();
            while (it.hasNext()) {
                u1(sb, it.next());
                sb.append(", ");
            }
            u1(sb, (e0) s.g0(listE));
            sb.append(") ");
        }
        boolean zQ = kotlin.reflect.y.internal.j0.b.g.q(e0Var);
        boolean zP0 = e0Var.P0();
        boolean z2 = zP0 || (z && e0VarJ != null);
        if (z2) {
            if (zQ) {
                sb.insert(length, '(');
            } else {
                if (z) {
                    kotlin.text.b.c(x.Q0(sb));
                    if (sb.charAt(kotlin.text.v.Q(sb) - 1) != ')') {
                        sb.insert(kotlin.text.v.Q(sb), "()");
                    }
                }
                sb.append("(");
            }
        }
        s1(sb, zQ, "suspend");
        if (e0VarJ != null) {
            boolean z3 = (Z1(e0VarJ) && !e0VarJ.P0()) || M0(e0VarJ);
            if (z3) {
                sb.append("(");
            }
            u1(sb, e0VarJ);
            if (z3) {
                sb.append(")");
            }
            sb.append(".");
        }
        sb.append("(");
        if (!kotlin.reflect.y.internal.j0.b.g.m(e0Var) || e0Var.M0().size() > 1) {
            int i2 = 0;
            for (g1 g1Var : kotlin.reflect.y.internal.j0.b.g.l(e0Var)) {
                int i3 = i2 + 1;
                if (i2 > 0) {
                    sb.append(", ");
                }
                if (k0()) {
                    e0 type = g1Var.getType();
                    m.e(type, "typeProjection.type");
                    fVarD = kotlin.reflect.y.internal.j0.b.g.d(type);
                } else {
                    fVarD = null;
                }
                if (fVarD != null) {
                    sb.append(v(fVarD, false));
                    sb.append(": ");
                }
                sb.append(x(g1Var));
                i2 = i3;
            }
        } else {
            sb.append("???");
        }
        sb.append(") ");
        sb.append(N());
        sb.append(" ");
        u1(sb, kotlin.reflect.y.internal.j0.b.g.k(e0Var));
        if (z2) {
            sb.append(")");
        }
        if (zP0) {
            sb.append("?");
        }
    }

    private final void l1(j1 j1Var, StringBuilder sb) {
        kotlin.reflect.y.internal.j0.i.r.g<?> gVarX;
        if (!d0() || (gVarX = j1Var.X()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(P(c1(gVarX)));
    }

    private final String m1(String str) {
        int i2 = b.a[A0().ordinal()];
        if (i2 == 1) {
            return str;
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        if (T()) {
            return str;
        }
        return "<b>" + str + "</b>";
    }

    private final void n1(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, StringBuilder sb) {
        if (f0().contains(kotlin.reflect.y.internal.j0.h.e.MEMBER_KIND) && F0() && bVar.i() != kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION) {
            sb.append("/*");
            sb.append(kotlin.reflect.y.internal.j0.m.u.a.f(bVar.i().name()));
            sb.append("*/ ");
        }
    }

    private final void o1(kotlin.p002reflect.jvm.internal.impl.descriptors.c0 c0Var, StringBuilder sb) {
        s1(sb, c0Var.z(), "external");
        s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.EXPECT) && c0Var.M(), "expect");
        s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.ACTUAL) && c0Var.E0(), "actual");
    }

    private final void q1(d0 d0Var, StringBuilder sb, d0 d0Var2) {
        if (s0() || d0Var != d0Var2) {
            s1(sb, f0().contains(kotlin.reflect.y.internal.j0.h.e.MODALITY), kotlin.reflect.y.internal.j0.m.u.a.f(d0Var.name()));
        }
    }

    private final void r1(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, StringBuilder sb) {
        if (kotlin.reflect.y.internal.j0.i.d.J(bVar) && bVar.j() == d0.FINAL) {
            return;
        }
        if (i0() == j.RENDER_OVERRIDE && bVar.j() == d0.OPEN && Q0(bVar)) {
            return;
        }
        d0 d0VarJ = bVar.j();
        m.e(d0VarJ, "callable.modality");
        q1(d0VarJ, sb, N0(bVar));
    }

    private final void s1(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(m1(str));
            sb.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar, StringBuilder sb, boolean z) {
        kotlin.reflect.y.internal.j0.f.f name = mVar.getName();
        m.e(name, "descriptor.name");
        sb.append(v(name, z));
    }

    private final void u1(StringBuilder sb, e0 e0Var) {
        q1 q1VarR0 = e0Var.R0();
        kotlin.reflect.y.internal.j0.l.a aVar = q1VarR0 instanceof kotlin.reflect.y.internal.j0.l.a ? (kotlin.reflect.y.internal.j0.l.a) q1VarR0 : null;
        if (aVar == null) {
            v1(sb, e0Var);
            return;
        }
        if (v0()) {
            v1(sb, aVar.W());
            return;
        }
        v1(sb, aVar.a1());
        if (w0()) {
            R0(sb, aVar);
        }
    }

    private final void v1(StringBuilder sb, e0 e0Var) {
        if ((e0Var instanceof s1) && n() && !((s1) e0Var).T0()) {
            sb.append("<Not computed yet>");
            return;
        }
        q1 q1VarR0 = e0Var.R0();
        if (q1VarR0 instanceof kotlin.reflect.y.internal.j0.l.y) {
            sb.append(((kotlin.reflect.y.internal.j0.l.y) q1VarR0).Y0(this, this));
        } else if (q1VarR0 instanceof m0) {
            F1(sb, (m0) q1VarR0);
        }
    }

    private final void w1(kotlin.p002reflect.jvm.internal.impl.descriptors.b bVar, StringBuilder sb) {
        if (f0().contains(kotlin.reflect.y.internal.j0.h.e.OVERRIDE) && Q0(bVar) && i0() != j.RENDER_OPEN) {
            s1(sb, true, "override");
            if (F0()) {
                sb.append("/*");
                sb.append(bVar.e().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(k0 k0Var, StringBuilder sb) {
        y1(k0Var.d(), "package-fragment", sb);
        if (n()) {
            sb.append(" in ");
            t1(k0Var.b(), sb, false);
        }
    }

    private final void y1(kotlin.reflect.y.internal.j0.f.c cVar, String str, StringBuilder sb) {
        sb.append(m1(str));
        kotlin.reflect.y.internal.j0.f.d dVarJ = cVar.j();
        m.e(dVarJ, "fqName.toUnsafe()");
        String strU = u(dVarJ);
        if (strU.length() > 0) {
            sb.append(" ");
            sb.append(strU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(p0 p0Var, StringBuilder sb) {
        y1(p0Var.d(), Constants.PACKAGE, sb);
        if (n()) {
            sb.append(" in context of ");
            t1(p0Var.v0(), sb, false);
        }
    }

    public m A0() {
        return this.l.Z();
    }

    public Function1<e0, e0> B0() {
        return this.l.a0();
    }

    public boolean C0() {
        return this.l.b0();
    }

    public boolean D0() {
        return this.l.c0();
    }

    public kotlin.f0.y.e.j0.h.c.l E0() {
        return this.l.d0();
    }

    public boolean F0() {
        return this.l.e0();
    }

    public boolean G0() {
        return this.l.f0();
    }

    public boolean H0() {
        return this.l.g0();
    }

    public boolean I0() {
        return this.l.h0();
    }

    public boolean J0() {
        return this.l.i0();
    }

    public boolean K0() {
        return this.l.j0();
    }

    public String K1(List<? extends g1> list) {
        m.f(list, "typeArguments");
        if (list.isEmpty()) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(P0());
        M(sb, list);
        sb.append(L0());
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public String L1(kotlin.reflect.y.internal.j0.l.e1 e1Var) {
        m.f(e1Var, "typeConstructor");
        kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarW = e1Var.w();
        if (hVarW instanceof e1 ? true : hVarW instanceof kotlin.p002reflect.jvm.internal.impl.descriptors.e ? true : hVarW instanceof d1) {
            return a1(hVarW);
        }
        if (hVarW == null) {
            return e1Var instanceof kotlin.reflect.y.internal.j0.l.d0 ? ((kotlin.reflect.y.internal.j0.l.d0) e1Var).j(h.f24274f) : e1Var.toString();
        }
        throw new IllegalStateException(("Unexpected classifier: " + hVarW.getClass()).toString());
    }

    public boolean Q() {
        return this.l.r();
    }

    public boolean R() {
        return this.l.s();
    }

    public Function1<kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c, Boolean> S() {
        return this.l.t();
    }

    public boolean T() {
        return this.l.u();
    }

    public boolean U() {
        return this.l.v();
    }

    public kotlin.reflect.y.internal.j0.h.b V() {
        return this.l.w();
    }

    public Function1<i1, String> W() {
        return this.l.x();
    }

    public boolean X() {
        return this.l.y();
    }

    public Set<kotlin.reflect.y.internal.j0.f.c> Y() {
        return this.l.z();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void a(Set<kotlin.reflect.y.internal.j0.f.c> set) {
        m.f(set, "<set-?>");
        this.l.a(set);
    }

    public boolean a0() {
        return this.l.A();
    }

    public String a1(kotlin.p002reflect.jvm.internal.impl.descriptors.h hVar) {
        m.f(hVar, "klass");
        return kotlin.reflect.y.internal.j0.l.u1.k.m(hVar) ? hVar.h().toString() : V().a(hVar, this);
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void b(boolean z) {
        this.l.b(z);
    }

    public boolean b0() {
        return this.l.B();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void c(Set<? extends kotlin.reflect.y.internal.j0.h.e> set) {
        m.f(set, "<set-?>");
        this.l.c(set);
    }

    public boolean c0() {
        return this.l.C();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void d(k kVar) {
        m.f(kVar, "<set-?>");
        this.l.d(kVar);
    }

    public boolean d0() {
        return this.l.D();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void e(boolean z) {
        this.l.e(z);
    }

    public boolean e0() {
        return this.l.E();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public boolean f() {
        return this.l.f();
    }

    public Set<kotlin.reflect.y.internal.j0.h.e> f0() {
        return this.l.F();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void g(kotlin.reflect.y.internal.j0.h.b bVar) {
        m.f(bVar, "<set-?>");
        this.l.g(bVar);
    }

    public boolean g0() {
        return this.l.G();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void h(boolean z) {
        this.l.h(z);
    }

    public final kotlin.reflect.y.internal.j0.h.g h0() {
        return this.l;
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void i(boolean z) {
        this.l.i(z);
    }

    public j i0() {
        return this.l.H();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void j(boolean z) {
        this.l.j(z);
    }

    public k j0() {
        return this.l.I();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void k(boolean z) {
        this.l.k(z);
    }

    public boolean k0() {
        return this.l.J();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void l(m mVar) {
        m.f(mVar, "<set-?>");
        this.l.l(mVar);
    }

    public boolean l0() {
        return this.l.K();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public Set<kotlin.reflect.y.internal.j0.f.c> m() {
        return this.l.m();
    }

    public l m0() {
        return this.l.L();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public boolean n() {
        return this.l.n();
    }

    public boolean n0() {
        return this.l.M();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public kotlin.reflect.y.internal.j0.h.a o() {
        return this.l.o();
    }

    public boolean o0() {
        return this.l.N();
    }

    @Override // kotlin.reflect.y.internal.j0.h.f
    public void p(boolean z) {
        this.l.p(z);
    }

    public boolean p0() {
        return this.l.O();
    }

    public String p1(String str) {
        m.f(str, "message");
        int i2 = b.a[A0().ordinal()];
        if (i2 == 1) {
            return str;
        }
        if (i2 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return "<i>" + str + "</i>";
    }

    @Override // kotlin.reflect.y.internal.j0.h.c
    public String q(kotlin.p002reflect.jvm.internal.impl.descriptors.m mVar) {
        m.f(mVar, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        mVar.L(new a(), sb);
        if (G0()) {
            L(sb, mVar);
        }
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean q0() {
        return this.l.P();
    }

    @Override // kotlin.reflect.y.internal.j0.h.c
    public String r(kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c cVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.e eVar) {
        m.f(cVar, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (eVar != null) {
            sb.append(eVar.k() + ':');
        }
        e0 type = cVar.getType();
        sb.append(w(type));
        if (b0()) {
            List<String> listU0 = U0(cVar);
            if (c0() || (!listU0.isEmpty())) {
                c0.c0(listU0, sb, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (F0() && (kotlin.reflect.y.internal.j0.l.g0.a(type) || (type.O0().w() instanceof j0.b))) {
            sb.append(" /* annotation class not found */");
        }
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean r0() {
        return this.l.Q();
    }

    public boolean s0() {
        return this.l.R();
    }

    @Override // kotlin.reflect.y.internal.j0.h.c
    public String t(String str, String str2, kotlin.reflect.y.internal.j0.b.h hVar) {
        m.f(str, "lowerRendered");
        m.f(str2, "upperRendered");
        m.f(hVar, "builtIns");
        if (O(str, str2)) {
            if (!kotlin.text.u.E(str2, "(", false, 2, null)) {
                return str + '!';
            }
            return '(' + str + ")!";
        }
        kotlin.reflect.y.internal.j0.h.b bVarV = V();
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarW = hVar.w();
        m.e(eVarW, "builtIns.collection");
        String strM0 = kotlin.text.v.M0(bVarV.a(eVarW, this), "Collection", null, 2, null);
        String strY1 = Y1(str, strM0 + "Mutable", str2, strM0, strM0 + "(Mutable)");
        if (strY1 != null) {
            return strY1;
        }
        String strY2 = Y1(str, strM0 + "MutableMap.MutableEntry", str2, strM0 + "Map.Entry", strM0 + "(Mutable)Map.(Mutable)Entry");
        if (strY2 != null) {
            return strY2;
        }
        kotlin.reflect.y.internal.j0.h.b bVarV2 = V();
        kotlin.p002reflect.jvm.internal.impl.descriptors.e eVarJ = hVar.j();
        m.e(eVarJ, "builtIns.array");
        String strM1 = kotlin.text.v.M0(bVarV2.a(eVarJ, this), "Array", null, 2, null);
        String strY3 = Y1(str, strM1 + P("Array<"), str2, strM1 + P("Array<out "), strM1 + P("Array<(out) "));
        if (strY3 != null) {
            return strY3;
        }
        return '(' + str + ".." + str2 + ')';
    }

    public boolean t0() {
        return this.l.S();
    }

    @Override // kotlin.reflect.y.internal.j0.h.c
    public String u(kotlin.reflect.y.internal.j0.f.d dVar) {
        m.f(dVar, "fqName");
        List<kotlin.reflect.y.internal.j0.f.f> listH = dVar.h();
        m.e(listH, "fqName.pathSegments()");
        return i1(listH);
    }

    public boolean u0() {
        return this.l.T();
    }

    @Override // kotlin.reflect.y.internal.j0.h.c
    public String v(kotlin.reflect.y.internal.j0.f.f fVar, boolean z) {
        m.f(fVar, "name");
        String strP = P(n.b(fVar));
        if (!T() || A0() != m.HTML || !z) {
            return strP;
        }
        return "<b>" + strP + "</b>";
    }

    public boolean v0() {
        return this.l.U();
    }

    @Override // kotlin.reflect.y.internal.j0.h.c
    public String w(e0 e0Var) {
        m.f(e0Var, "type");
        StringBuilder sb = new StringBuilder();
        u1(sb, B0().invoke(e0Var));
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean w0() {
        return this.l.V();
    }

    @Override // kotlin.reflect.y.internal.j0.h.c
    public String x(g1 g1Var) {
        m.f(g1Var, "typeProjection");
        StringBuilder sb = new StringBuilder();
        M(sb, kotlin.collections.t.e(g1Var));
        String string = sb.toString();
        m.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public boolean x0() {
        return this.l.W();
    }

    public boolean y0() {
        return this.l.X();
    }

    public boolean z0() {
        return this.l.Y();
    }
}
