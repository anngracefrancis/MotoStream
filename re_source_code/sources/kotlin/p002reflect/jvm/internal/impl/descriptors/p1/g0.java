package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.i1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: SimpleFunctionDescriptorImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 extends p implements y0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    protected g0(m mVar, y0 y0Var, g gVar, f fVar, b.a aVar, z0 z0Var) {
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
    }

    public static g0 m1(m mVar, g gVar, f fVar, b.a aVar, z0 z0Var) {
        if (mVar == null) {
            v(5);
        }
        if (gVar == null) {
            v(6);
        }
        if (fVar == null) {
            v(7);
        }
        if (aVar == null) {
            v(8);
        }
        if (z0Var == null) {
            v(9);
        }
        return new g0(mVar, null, gVar, fVar, aVar, z0Var);
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 13 || i2 == 18 || i2 == 23 || i2 == 24 || i2 == 29 || i2 == 30) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 13 || i2 == 18 || i2 == 23 || i2 == 24 || i2 == 29 || i2 == 30) ? 2 : 3];
        switch (i2) {
            case 1:
            case 6:
            case 27:
                objArr[0] = "annotations";
                break;
            case 2:
            case 7:
                objArr[0] = "name";
                break;
            case 3:
            case 8:
            case 26:
                objArr[0] = "kind";
                break;
            case 4:
            case 9:
            case 28:
                objArr[0] = "source";
                break;
            case 5:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 10:
            case 15:
            case 20:
                objArr[0] = "typeParameters";
                break;
            case 11:
            case 16:
            case 21:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 12:
            case 17:
            case 22:
                objArr[0] = "visibility";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
                break;
            case 14:
            case 19:
                objArr[0] = "contextReceiverParameters";
                break;
            case 25:
                objArr[0] = "newOwner";
                break;
        }
        if (i2 == 13 || i2 == 18 || i2 == 23) {
            objArr[1] = "initialize";
        } else if (i2 == 24) {
            objArr[1] = "getOriginal";
        } else if (i2 == 29) {
            objArr[1] = "copy";
        } else if (i2 != 30) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/SimpleFunctionDescriptorImpl";
        } else {
            objArr[1] = "newCopyBuilder";
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                objArr[2] = "create";
                break;
            case 10:
            case 11:
            case 12:
            case 14:
            case 15:
            case 16:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
                objArr[2] = "initialize";
                break;
            case 13:
            case 18:
            case 23:
            case 24:
            case 29:
            case 30:
                break;
            case 25:
            case 26:
            case 27:
            case 28:
                objArr[2] = "createSubstitutedCopy";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 13 && i2 != 18 && i2 != 23 && i2 != 24 && i2 != 29 && i2 != 30) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    protected p M0(m mVar, y yVar, b.a aVar, f fVar, g gVar, z0 z0Var) {
        if (mVar == null) {
            v(25);
        }
        if (aVar == null) {
            v(26);
        }
        if (gVar == null) {
            v(27);
        }
        if (z0Var == null) {
            v(28);
        }
        y0 y0Var = (y0) yVar;
        if (fVar == null) {
            fVar = getName();
        }
        return new g0(mVar, y0Var, gVar, fVar, aVar, z0Var);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.b
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public y0 k0(m mVar, d0 d0Var, u uVar, b.a aVar, boolean z) {
        y0 y0Var = (y0) super.k0(mVar, d0Var, uVar, aVar, z);
        if (y0Var == null) {
            v(29);
        }
        return y0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.k, kotlin.p002reflect.jvm.internal.impl.descriptors.p1.j, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public y0 a() {
        y0 y0Var = (y0) super.a();
        if (y0Var == null) {
            v(24);
        }
        return y0Var;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public g0 S0(w0 w0Var, w0 w0Var2, List<w0> list, List<? extends e1> list2, List<i1> list3, e0 e0Var, d0 d0Var, u uVar) {
        if (list == null) {
            v(14);
        }
        if (list2 == null) {
            v(15);
        }
        if (list3 == null) {
            v(16);
        }
        if (uVar == null) {
            v(17);
        }
        g0 g0VarP1 = p1(w0Var, w0Var2, list, list2, list3, e0Var, d0Var, uVar, null);
        if (g0VarP1 == null) {
            v(18);
        }
        return g0VarP1;
    }

    public g0 p1(w0 w0Var, w0 w0Var2, List<w0> list, List<? extends e1> list2, List<i1> list3, e0 e0Var, d0 d0Var, u uVar, Map<? extends a.InterfaceC0406a<?>, ?> map) {
        if (list == null) {
            v(19);
        }
        if (list2 == null) {
            v(20);
        }
        if (list3 == null) {
            v(21);
        }
        if (uVar == null) {
            v(22);
        }
        super.S0(w0Var, w0Var2, list, list2, list3, e0Var, d0Var, uVar);
        if (map != null && !map.isEmpty()) {
            this.I = new LinkedHashMap(map);
        }
        return this;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.p1.p, kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.y0
    public y.a<? extends y0> u() {
        y.a aVarU = super.u();
        if (aVarU == null) {
            v(30);
        }
        return aVarU;
    }
}
