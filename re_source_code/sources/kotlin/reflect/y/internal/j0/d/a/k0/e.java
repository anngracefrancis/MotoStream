package kotlin.reflect.y.internal.j0.d.a.k0;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.m.p;

/* JADX INFO: compiled from: JavaMethodDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends g0 implements kotlin.reflect.y.internal.j0.d.a.k0.a {
    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<i1> J = new a();
    public static final kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<Boolean> K = new b();
    private c L;
    private final boolean M;

    /* JADX INFO: compiled from: JavaMethodDescriptor.java */
    static class a implements kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<i1> {
        a() {
        }
    }

    /* JADX INFO: compiled from: JavaMethodDescriptor.java */
    static class b implements kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<Boolean> {
        b() {
        }
    }

    /* JADX INFO: compiled from: JavaMethodDescriptor.java */
    private enum c {
        NON_STABLE_DECLARED(false, false),
        STABLE_DECLARED(true, false),
        NON_STABLE_SYNTHESIZED(false, true),
        STABLE_SYNTHESIZED(true, true);


        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f23442k;
        public final boolean l;

        c(boolean z, boolean z2) {
            this.f23442k = z;
            this.l = z2;
        }

        private static /* synthetic */ void g(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor$ParameterNamesStatus", "get"));
        }

        public static c k(boolean z, boolean z2) {
            c cVar;
            if (z) {
                cVar = z2 ? STABLE_SYNTHESIZED : STABLE_DECLARED;
            } else {
                cVar = z2 ? NON_STABLE_SYNTHESIZED : NON_STABLE_DECLARED;
            }
            if (cVar == null) {
                g(0);
            }
            return cVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected e(m mVar, y0 y0Var, g gVar, f fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, z0 z0Var, boolean z) {
        super(mVar, y0Var, gVar, fVar, aVar, z0Var);
        if (mVar == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (fVar == null) {
            v(2);
        }
        if (aVar == null) {
            v(3);
        }
        if (z0Var == null) {
            v(4);
        }
        this.L = null;
        this.M = z;
    }

    public static e q1(m mVar, g gVar, f fVar, z0 z0Var, boolean z) {
        if (mVar == null) {
            v(5);
        }
        if (gVar == null) {
            v(6);
        }
        if (fVar == null) {
            v(7);
        }
        if (z0Var == null) {
            v(8);
        }
        return new e(mVar, null, gVar, fVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a.DECLARATION, z0Var, z);
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 13 || i2 == 18 || i2 == 21) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 13 || i2 == 18 || i2 == 21) ? 2 : 3];
        switch (i2) {
            case 1:
            case 6:
            case 16:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 15:
                objArr[0] = "kind";
                break;
            case 4:
            case 8:
            case 17:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 9:
                objArr[0] = "contextReceiverParameters";
                break;
            case 10:
                objArr[0] = "typeParameters";
                break;
            case 11:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 21:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
                break;
            case 14:
                objArr[0] = "newOwner";
                break;
            case 19:
                objArr[0] = "enhancedValueParameterTypes";
                break;
            case 20:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i2 == 13) {
            objArr[1] = "initialize";
        } else if (i2 == 18) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i2 != 21) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaMethodDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
                objArr[2] = "createJavaMethod";
                break;
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 21:
                break;
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 19:
            case 20:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 13 && i2 != 18 && i2 != 21) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.a
    public boolean G() {
        return this.L.l;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    public boolean R0() {
        return this.L.f23442k;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0
    public g0 p1(w0 w0Var, w0 w0Var2, List<w0> list, List<? extends e1> list2, List<i1> list3, e0 e0Var, d0 d0Var, u uVar, Map<? extends kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, ?> map) {
        if (list == null) {
            v(9);
        }
        if (list2 == null) {
            v(10);
        }
        if (list3 == null) {
            v(11);
        }
        if (uVar == null) {
            v(12);
        }
        g0 g0VarP1 = super.p1(w0Var, w0Var2, list, list2, list3, e0Var, d0Var, uVar, map);
        g1(p.a.a(g0VarP1).a());
        if (g0VarP1 == null) {
            v(13);
        }
        return g0VarP1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    /* JADX INFO: renamed from: r1, reason: merged with bridge method [inline-methods] */
    public e M0(m mVar, y yVar, kotlin.reflect.jvm.internal.impl.descriptors.b.a aVar, f fVar, g gVar, z0 z0Var) {
        if (mVar == null) {
            v(14);
        }
        if (aVar == null) {
            v(15);
        }
        if (gVar == null) {
            v(16);
        }
        if (z0Var == null) {
            v(17);
        }
        y0 y0Var = (y0) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        e eVar = new e(mVar, y0Var, gVar, fVar, aVar, z0Var, this.M);
        eVar.t1(R0(), G());
        return eVar;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.k0.a
    /* JADX INFO: renamed from: s1, reason: merged with bridge method [inline-methods] */
    public e y(e0 e0Var, List<e0> list, e0 e0Var2, Pair<kotlin.p002reflect.jvm.internal.impl.descriptors.a.InterfaceC0406a<?>, ?> pair) {
        if (list == null) {
            v(19);
        }
        if (e0Var2 == null) {
            v(20);
        }
        e eVar = (e) u().b(h.a(list, f(), this)).g(e0Var2).k(e0Var == null ? null : kotlin.reflect.y.internal.j0.i.c.h(this, e0Var, g.f25179c.b())).a().f().c();
        if (pair != null) {
            eVar.V0(pair.c(), pair.d());
        }
        if (eVar == null) {
            v(21);
        }
        return eVar;
    }

    public void t1(boolean z, boolean z2) {
        this.L = c.k(z, z2);
    }
}
