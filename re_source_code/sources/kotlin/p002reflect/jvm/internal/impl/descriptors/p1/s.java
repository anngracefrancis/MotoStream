package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.g1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.i.w.m;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.t;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t f25289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final l1 f25290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private l1 f25291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<e1> f25292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<e1> f25293k;
    private kotlin.reflect.y.internal.j0.l.e1 l;

    /* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
    class a implements Function1<e1, Boolean> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(e1 e1Var) {
            return Boolean.valueOf(!e1Var.o0());
        }
    }

    /* JADX INFO: compiled from: LazySubstitutingClassDescriptor.java */
    class b implements Function1<m0, m0> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m0 invoke(m0 m0Var) {
            return s.this.N0(m0Var);
        }
    }

    public s(t tVar, l1 l1Var) {
        this.f25289g = tVar;
        this.f25290h = l1Var;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0051  */
    /* JADX WARN: Code duplicated, block: B:35:0x0056  */
    /* JADX WARN: Code duplicated, block: B:36:0x005b  */
    private static /* synthetic */ void K(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 13 || i2 == 23) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 13 || i2 == 23) ? 3 : 2];
        if (i2 == 2) {
            objArr[0] = "typeArguments";
        } else if (i2 == 3) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i2 == 5) {
            objArr[0] = "typeSubstitution";
        } else if (i2 == 6) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i2 == 8) {
            objArr[0] = "typeArguments";
        } else if (i2 == 10) {
            objArr[0] = "typeSubstitution";
        } else if (i2 == 13) {
            objArr[0] = "kotlinTypeRefiner";
        } else if (i2 != 23) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
        } else {
            objArr[0] = "substitutor";
        }
        switch (i2) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 10:
            case 13:
            case 23:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                break;
            case 4:
            case 7:
            case 9:
            case 11:
                objArr[1] = "getMemberScope";
                break;
            case 12:
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getDefaultType";
                break;
            case 17:
                objArr[1] = "getContextReceivers";
                break;
            case 18:
                objArr[1] = "getConstructors";
                break;
            case 19:
                objArr[1] = "getAnnotations";
                break;
            case 20:
                objArr[1] = "getName";
                break;
            case 21:
                objArr[1] = "getOriginal";
                break;
            case 22:
                objArr[1] = "getContainingDeclaration";
                break;
            case 24:
                objArr[1] = "substitute";
                break;
            case 25:
                objArr[1] = "getKind";
                break;
            case 26:
                objArr[1] = "getModality";
                break;
            case 27:
                objArr[1] = "getVisibility";
                break;
            case 28:
                objArr[1] = "getUnsubstitutedInnerClassesScope";
                break;
            case 29:
                objArr[1] = "getSource";
                break;
            case 30:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 31:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "getTypeConstructor";
                break;
        }
        if (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 8 || i2 == 10) {
            objArr[2] = "getMemberScope";
        } else if (i2 == 13) {
            objArr[2] = "getUnsubstitutedMemberScope";
        } else if (i2 == 23) {
            objArr[2] = "substitute";
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 5 && i2 != 6 && i2 != 8 && i2 != 10 && i2 != 13 && i2 != 23) {
            throw new IllegalStateException(str2);
        }
        throw new IllegalArgumentException(str2);
    }

    private l1 L0() {
        if (this.f25291i == null) {
            if (this.f25290h.k()) {
                this.f25291i = this.f25290h;
            } else {
                List<e1> parameters = this.f25289g.h().getParameters();
                this.f25292j = new ArrayList(parameters.size());
                this.f25291i = t.b(parameters, this.f25290h.j(), this, this.f25292j);
                this.f25293k = c0.Q(this.f25292j, new a());
            }
        }
        return this.f25291i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public m0 N0(m0 m0Var) {
        return (m0Var == null || this.f25290h.k()) ? m0Var : (m0) L0().p(m0Var, r1.INVARIANT);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return this.f25289g.A();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean D() {
        return this.f25289g.D();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public h D0() {
        h hVarH = H(kotlin.reflect.y.internal.j0.i.t.a.k(d.g(this.f25289g)));
        if (hVarH == null) {
            K(12);
        }
        return hVarH;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return this.f25289g.E0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public List<w0> F0() {
        List<w0> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            K(17);
        }
        return listEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
    public h H(g gVar) {
        if (gVar == null) {
            K(13);
        }
        h hVarH = this.f25289g.H(gVar);
        if (!this.f25290h.k()) {
            return new m(hVarH, L0());
        }
        if (hVarH == null) {
            K(14);
        }
        return hVarH;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public Collection<e> J() {
        Collection<e> collectionJ = this.f25289g.J();
        if (collectionJ == null) {
            K(31);
        }
        return collectionJ;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean J0() {
        return this.f25289g.J0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public w0 K0() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return oVar.a(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return this.f25289g.M();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public e c(l1 l1Var) {
        if (l1Var == null) {
            K(23);
        }
        return l1Var.k() ? this : new s(this, l1.h(l1Var.j(), L0().j()));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.p002reflect.jvm.internal.impl.descriptors.d R() {
        return this.f25289g.R();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public h S() {
        h hVarS = this.f25289g.S();
        if (hVarS == null) {
            K(15);
        }
        return hVarS;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public e U() {
        return this.f25289g.U();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public h a0(j1 j1Var) {
        if (j1Var == null) {
            K(10);
        }
        h hVarV = v(j1Var, kotlin.reflect.y.internal.j0.i.t.a.k(d.g(this)));
        if (hVarV == null) {
            K(11);
        }
        return hVarV;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.n, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public kotlin.p002reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.m mVarB = this.f25289g.b();
        if (mVarB == null) {
            K(22);
        }
        return mVarB;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g annotations = this.f25289g.getAnnotations();
        if (annotations == null) {
            K(19);
        }
        return annotations;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i0
    public f getName() {
        f name = this.f25289g.getName();
        if (name == null) {
            K(20);
        }
        return name;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.q, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public u getVisibility() {
        u visibility = this.f25289g.getVisibility();
        if (visibility == null) {
            K(27);
        }
        return visibility;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.e1 h() {
        kotlin.reflect.y.internal.j0.l.e1 e1VarH = this.f25289g.h();
        if (this.f25290h.k()) {
            if (e1VarH == null) {
                K(0);
            }
            return e1VarH;
        }
        if (this.l == null) {
            l1 l1VarL0 = L0();
            Collection<e0> collectionA = e1VarH.a();
            ArrayList arrayList = new ArrayList(collectionA.size());
            Iterator<e0> it = collectionA.iterator();
            while (it.hasNext()) {
                arrayList.add(l1VarL0.p(it.next(), r1.INVARIANT));
            }
            this.l = new l(this, this.f25292j, arrayList, kotlin.reflect.y.internal.j0.k.f.f24650b);
        }
        kotlin.reflect.y.internal.j0.l.e1 e1Var = this.l;
        if (e1Var == null) {
            K(1);
        }
        return e1Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public kotlin.p002reflect.jvm.internal.impl.descriptors.f i() {
        kotlin.p002reflect.jvm.internal.impl.descriptors.f fVarI = this.f25289g.i();
        if (fVarI == null) {
            K(25);
        }
        return fVarI;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return this.f25289g.isInline();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public d0 j() {
        d0 d0VarJ = this.f25289g.j();
        if (d0VarJ == null) {
            K(26);
        }
        return d0VarJ;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> k() {
        Collection<kotlin.p002reflect.jvm.internal.impl.descriptors.d> collectionK = this.f25289g.k();
        ArrayList arrayList = new ArrayList(collectionK.size());
        for (kotlin.p002reflect.jvm.internal.impl.descriptors.d dVar : collectionK) {
            arrayList.add(((kotlin.p002reflect.jvm.internal.impl.descriptors.d) dVar.u().h(dVar.a()).d(dVar.j()).o(dVar.getVisibility()).r(dVar.i()).j(false).c()).c(L0()));
        }
        return arrayList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return this.f25289g.l();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return this.f25289g.m();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public m0 s() {
        m0 m0VarJ = f0.j(kotlin.reflect.y.internal.j0.l.o.a.a(getAnnotations(), null, null), h(), n1.g(h().getParameters()), false, D0());
        if (m0VarJ == null) {
            K(16);
        }
        return m0VarJ;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = z0.a;
        if (z0Var == null) {
            K(29);
        }
        return z0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
    public h v(j1 j1Var, g gVar) {
        if (j1Var == null) {
            K(5);
        }
        if (gVar == null) {
            K(6);
        }
        h hVarV = this.f25289g.v(j1Var, gVar);
        if (!this.f25290h.k()) {
            return new m(hVarV, L0());
        }
        if (hVarV == null) {
            K(7);
        }
        return hVarV;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.i
    public List<e1> w() {
        L0();
        List<e1> list = this.f25293k;
        if (list == null) {
            K(30);
        }
        return list;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public h y0() {
        h hVarY0 = this.f25289g.y0();
        if (hVarY0 == null) {
            K(28);
        }
        return hVarY0;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return this.f25289g.z();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public g1<m0> z0() {
        g1<m0> g1VarZ0 = this.f25289g.z0();
        if (g1VarZ0 == null) {
            return null;
        }
        return g1VarZ0.b(new b());
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public e a() {
        e eVarA = this.f25289g.a();
        if (eVarA == null) {
            K(21);
        }
        return eVarA;
    }
}
