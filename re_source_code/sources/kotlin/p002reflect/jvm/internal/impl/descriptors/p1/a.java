package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.i.w.m;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: AbstractClassDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends t {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f25202g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final i<m0> f25203h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final i<h> f25204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final i<w0> f25205j;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.p1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    class C0409a implements Function0<m0> {

        /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.p1.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AbstractClassDescriptor.java */
        class C0410a implements Function1<g, m0> {
            C0410a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public m0 invoke(g gVar) {
                kotlin.p002reflect.jvm.internal.impl.descriptors.h hVarF = gVar.f(a.this);
                if (hVarF == null) {
                    return a.this.f25203h.invoke();
                }
                if (hVarF instanceof d1) {
                    return f0.b((d1) hVarF, n1.g(hVarF.h().getParameters()));
                }
                return hVarF instanceof t ? n1.u(hVarF.h().b(gVar), ((t) hVarF).H(gVar), this) : hVarF.s();
            }
        }

        C0409a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m0 invoke() {
            a aVar = a.this;
            return n1.t(aVar, aVar.D0(), new C0410a());
        }
    }

    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    class b implements Function0<h> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h invoke() {
            return new kotlin.reflect.y.internal.j0.i.w.f(a.this.D0());
        }
    }

    /* JADX INFO: compiled from: AbstractClassDescriptor.java */
    class c implements Function0<w0> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public w0 invoke() {
            return new q(a.this);
        }
    }

    public a(n nVar, f fVar) {
        if (nVar == null) {
            K(0);
        }
        if (fVar == null) {
            K(1);
        }
        this.f25202g = fVar;
        this.f25203h = nVar.d(new C0409a());
        this.f25204i = nVar.d(new b());
        this.f25205j = nVar.d(new c());
    }

    private static /* synthetic */ void K(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16 || i2 == 17 || i2 == 19 || i2 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16 || i2 == 17 || i2 == 19 || i2 == 20) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i2 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i2 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i2 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i2 == 19) {
            objArr[1] = "substitute";
        } else if (i2 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 6 && i2 != 9 && i2 != 12 && i2 != 14 && i2 != 16 && i2 != 17 && i2 != 19 && i2 != 20) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public e c(l1 l1Var) {
        if (l1Var == null) {
            K(18);
        }
        return l1Var.k() ? this : new s(this, l1Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public h D0() {
        h hVarH = H(kotlin.reflect.y.internal.j0.i.t.a.k(d.g(this)));
        if (hVarH == null) {
            K(17);
        }
        return hVarH;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public List<w0> F0() {
        List<w0> listEmptyList = Collections.emptyList();
        if (listEmptyList == null) {
            K(6);
        }
        return listEmptyList;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public w0 K0() {
        w0 w0VarInvoke = this.f25205j.invoke();
        if (w0VarInvoke == null) {
            K(5);
        }
        return w0VarInvoke;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return oVar.a(this, d2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public e a() {
        return this;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public h a0(j1 j1Var) {
        if (j1Var == null) {
            K(15);
        }
        h hVarV = v(j1Var, kotlin.reflect.y.internal.j0.i.t.a.k(d.g(this)));
        if (hVarV == null) {
            K(16);
        }
        return hVarV;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.i0
    public f getName() {
        f fVar = this.f25202g;
        if (fVar == null) {
            K(2);
        }
        return fVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e, kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public m0 s() {
        m0 m0VarInvoke = this.f25203h.invoke();
        if (m0VarInvoke == null) {
            K(20);
        }
        return m0VarInvoke;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.t
    public h v(j1 j1Var, g gVar) {
        if (j1Var == null) {
            K(10);
        }
        if (gVar == null) {
            K(11);
        }
        if (!j1Var.f()) {
            return new m(H(gVar), l1.g(j1Var));
        }
        h hVarH = H(gVar);
        if (hVarH == null) {
            K(12);
        }
        return hVarH;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e
    public h y0() {
        h hVarInvoke = this.f25204i.invoke();
        if (hVarInvoke == null) {
            K(4);
        }
        return hVarInvoke;
    }
}
