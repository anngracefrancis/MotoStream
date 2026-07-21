package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.c1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: TypeParameterDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class k0 extends e {
    private final Function1<e0, Void> p;
    private final List<e0> q;
    private boolean r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private k0(m mVar, g gVar, boolean z, r1 r1Var, f fVar, int i2, z0 z0Var, Function1<e0, Void> function1, c1 c1Var, n nVar) {
        super(nVar, mVar, gVar, fVar, r1Var, z, i2, z0Var, c1Var);
        if (mVar == null) {
            v(19);
        }
        if (gVar == null) {
            v(20);
        }
        if (r1Var == null) {
            v(21);
        }
        if (fVar == null) {
            v(22);
        }
        if (z0Var == null) {
            v(23);
        }
        if (c1Var == null) {
            v(24);
        }
        if (nVar == null) {
            v(25);
        }
        this.q = new ArrayList(1);
        this.r = false;
        this.p = function1;
    }

    private void O0() {
        if (this.r) {
            return;
        }
        throw new IllegalStateException("Type parameter descriptor is not initialized: " + V0());
    }

    private void P0() {
        if (this.r) {
            throw new IllegalStateException("Type parameter descriptor is already initialized: " + V0());
        }
    }

    public static k0 Q0(m mVar, g gVar, boolean z, r1 r1Var, f fVar, int i2, z0 z0Var, Function1<e0, Void> function1, c1 c1Var, n nVar) {
        if (mVar == null) {
            v(12);
        }
        if (gVar == null) {
            v(13);
        }
        if (r1Var == null) {
            v(14);
        }
        if (fVar == null) {
            v(15);
        }
        if (z0Var == null) {
            v(16);
        }
        if (c1Var == null) {
            v(17);
        }
        if (nVar == null) {
            v(18);
        }
        return new k0(mVar, gVar, z, r1Var, fVar, i2, z0Var, function1, c1Var, nVar);
    }

    public static k0 R0(m mVar, g gVar, boolean z, r1 r1Var, f fVar, int i2, z0 z0Var, n nVar) {
        if (mVar == null) {
            v(6);
        }
        if (gVar == null) {
            v(7);
        }
        if (r1Var == null) {
            v(8);
        }
        if (fVar == null) {
            v(9);
        }
        if (z0Var == null) {
            v(10);
        }
        if (nVar == null) {
            v(11);
        }
        return Q0(mVar, gVar, z, r1Var, fVar, i2, z0Var, null, c1.a.a, nVar);
    }

    public static e1 S0(m mVar, g gVar, boolean z, r1 r1Var, f fVar, int i2, n nVar) {
        if (mVar == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (r1Var == null) {
            v(2);
        }
        if (fVar == null) {
            v(3);
        }
        if (nVar == null) {
            v(4);
        }
        k0 k0VarR0 = R0(mVar, gVar, z, r1Var, fVar, i2, z0.a, nVar);
        k0VarR0.N0(a.f(mVar).y());
        k0VarR0.W0();
        return k0VarR0;
    }

    private void T0(e0 e0Var) {
        if (g0.a(e0Var)) {
            return;
        }
        this.q.add(e0Var);
    }

    private String V0() {
        return getName() + " declared in " + d.m(b());
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 5 || i2 == 28) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 5 || i2 == 28) ? 2 : 3];
        switch (i2) {
            case 1:
            case 7:
            case 13:
            case 20:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 14:
            case 21:
                objArr[0] = "variance";
                break;
            case 3:
            case 9:
            case 15:
            case 22:
                objArr[0] = "name";
                break;
            case 4:
            case 11:
            case 18:
            case 25:
                objArr[0] = "storageManager";
                break;
            case 5:
            case 28:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 16:
            case 23:
                objArr[0] = "source";
                break;
            case 17:
                objArr[0] = "supertypeLoopsResolver";
                break;
            case 24:
                objArr[0] = "supertypeLoopsChecker";
                break;
            case 26:
                objArr[0] = "bound";
                break;
            case 27:
                objArr[0] = "type";
                break;
        }
        if (i2 == 5) {
            objArr[1] = "createWithDefaultBound";
        } else if (i2 != 28) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/TypeParameterDescriptorImpl";
        } else {
            objArr[1] = "resolveUpperBounds";
        }
        switch (i2) {
            case 5:
            case 28:
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                objArr[2] = "createForFurtherModification";
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                objArr[2] = "<init>";
                break;
            case 26:
                objArr[2] = "addUpperBound";
                break;
            case 27:
                objArr[2] = "reportSupertypeLoopError";
                break;
            default:
                objArr[2] = "createWithDefaultBound";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 5 && i2 != 28) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e
    protected void L0(e0 e0Var) {
        if (e0Var == null) {
            v(27);
        }
        Function1<e0, Void> function1 = this.p;
        if (function1 == null) {
            return;
        }
        function1.invoke(e0Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e
    protected List<e0> M0() {
        O0();
        List<e0> list = this.q;
        if (list == null) {
            v(28);
        }
        return list;
    }

    public void N0(e0 e0Var) {
        if (e0Var == null) {
            v(26);
        }
        P0();
        T0(e0Var);
    }

    public boolean U0() {
        return this.r;
    }

    public void W0() {
        P0();
        this.r = true;
    }
}
