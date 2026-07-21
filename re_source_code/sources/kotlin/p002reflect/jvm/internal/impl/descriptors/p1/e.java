package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.o;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.g;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.f0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends k implements e1 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final r1 f25228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f25229k;
    private final int l;
    private final i<kotlin.reflect.y.internal.j0.l.e1> m;
    private final i<m0> n;
    private final n o;

    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    class a implements Function0<kotlin.reflect.y.internal.j0.l.e1> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ n f25230f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c1 f25231g;

        a(n nVar, c1 c1Var) {
            this.f25230f = nVar;
            this.f25231g = c1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.y.internal.j0.l.e1 invoke() {
            return new c(e.this, this.f25230f, this.f25231g);
        }
    }

    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    class b implements Function0<m0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f25233f;

        /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
        class a implements Function0<h> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h invoke() {
                return kotlin.reflect.y.internal.j0.i.w.n.j("Scope for type parameter " + b.this.f25233f.k(), e.this.getUpperBounds());
            }
        }

        b(f fVar) {
            this.f25233f = fVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m0 invoke() {
            return f0.j(a1.f24676g.h(), e.this.h(), Collections.emptyList(), false, new g(new a()));
        }
    }

    /* JADX INFO: compiled from: AbstractTypeParameterDescriptor.java */
    private class c extends kotlin.reflect.y.internal.j0.l.g {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final c1 f25236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f25237e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, n nVar, c1 c1Var) {
            super(nVar);
            if (nVar == null) {
                v(0);
            }
            this.f25237e = eVar;
            this.f25236d = c1Var;
        }

        private static /* synthetic */ void v(int i2) {
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? 2 : 3];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i2 == 2) {
                objArr[1] = "getParameters";
            } else if (i2 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i2 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i2 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i2 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // kotlin.reflect.y.internal.j0.l.m, kotlin.reflect.y.internal.j0.l.e1
        public kotlin.p002reflect.jvm.internal.impl.descriptors.h c() {
            e eVar = this.f25237e;
            if (eVar == null) {
                v(3);
            }
            return eVar;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            List<e1> listEmptyList = Collections.emptyList();
            if (listEmptyList == null) {
                v(2);
            }
            return listEmptyList;
        }

        @Override // kotlin.reflect.y.internal.j0.l.m
        protected boolean i(kotlin.p002reflect.jvm.internal.impl.descriptors.h hVar) {
            if (hVar == null) {
                v(9);
            }
            return (hVar instanceof e1) && kotlin.reflect.y.internal.j0.i.b.a.f(this.f25237e, (e1) hVar, true);
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected Collection<e0> l() {
            List<e0> listM0 = this.f25237e.M0();
            if (listM0 == null) {
                v(1);
            }
            return listM0;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected e0 m() {
            return k.d(j.x, new String[0]);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.y.internal.j0.b.h o() {
            kotlin.reflect.y.internal.j0.b.h hVarF = kotlin.reflect.y.internal.j0.i.t.a.f(this.f25237e);
            if (hVarF == null) {
                v(4);
            }
            return hVarF;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected c1 q() {
            c1 c1Var = this.f25236d;
            if (c1Var == null) {
                v(5);
            }
            return c1Var;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected List<e0> s(List<e0> list) {
            if (list == null) {
                v(7);
            }
            List<e0> listA0 = this.f25237e.A0(list);
            if (listA0 == null) {
                v(8);
            }
            return listA0;
        }

        public String toString() {
            return this.f25237e.getName().toString();
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected void u(e0 e0Var) {
            if (e0Var == null) {
                v(6);
            }
            this.f25237e.L0(e0Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected e(n nVar, m mVar, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g gVar, f fVar, r1 r1Var, boolean z, int i2, z0 z0Var, c1 c1Var) {
        super(mVar, gVar, fVar, z0Var);
        if (nVar == null) {
            v(0);
        }
        if (mVar == null) {
            v(1);
        }
        if (gVar == null) {
            v(2);
        }
        if (fVar == null) {
            v(3);
        }
        if (r1Var == null) {
            v(4);
        }
        if (z0Var == null) {
            v(5);
        }
        if (c1Var == null) {
            v(6);
        }
        this.f25228j = r1Var;
        this.f25229k = z;
        this.l = i2;
        this.m = nVar.d(new a(nVar, c1Var));
        this.n = nVar.d(new b(fVar));
        this.o = nVar;
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(str2);
            case 12:
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    protected List<e0> A0(List<e0> list) {
        if (list == null) {
            v(12);
        }
        if (list == null) {
            v(13);
        }
        return list;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public boolean F() {
        return this.f25229k;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(o<R, D> oVar, D d2) {
        return oVar.m(this, d2);
    }

    protected abstract void L0(e0 e0Var);

    protected abstract List<e0> M0();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public int g() {
        return this.l;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public List<e0> getUpperBounds() {
        List<e0> listA = ((c) h()).a();
        if (listA == null) {
            v(8);
        }
        return listA;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1, kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public final kotlin.reflect.y.internal.j0.l.e1 h() {
        kotlin.reflect.y.internal.j0.l.e1 e1VarInvoke = this.m.invoke();
        if (e1VarInvoke == null) {
            v(9);
        }
        return e1VarInvoke;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public n h0() {
        n nVar = this.o;
        if (nVar == null) {
            v(14);
        }
        return nVar;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public r1 n() {
        r1 r1Var = this.f25228j;
        if (r1Var == null) {
            v(7);
        }
        return r1Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.e1
    public boolean o0() {
        return false;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    public m0 s() {
        m0 m0VarInvoke = this.n.invoke();
        if (m0VarInvoke == null) {
            v(10);
        }
        return m0VarInvoke;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    public e1 a() {
        e1 e1Var = (e1) super.a();
        if (e1Var == null) {
            v(11);
        }
        return e1Var;
    }
}
