package kotlin.reflect.y.internal.j0.i;

import java.util.Collections;
import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.d0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.f0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.g0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.p1.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.u;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.i.w.o.d;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.r1;

/* JADX INFO: compiled from: DescriptorFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {

    /* JADX INFO: compiled from: DescriptorFactory.java */
    private static class a extends f {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, z0 z0Var, boolean z) {
            super(eVar, null, g.f25179c.b(), true, b.a.DECLARATION, z0Var);
            if (eVar == null) {
                v(0);
            }
            if (z0Var == null) {
                v(1);
            }
            r1(Collections.emptyList(), d.k(eVar, z));
        }

        private static /* synthetic */ void v(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "containingClass";
            } else {
                objArr[0] = "source";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }
    }

    private static /* synthetic */ void a(int i2) {
        String str = (i2 == 12 || i2 == 23 || i2 == 25) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 12 || i2 == 23 || i2 == 25) ? 2 : 3];
        switch (i2) {
            case 1:
            case 4:
            case 8:
            case 14:
            case 16:
            case 18:
            case 30:
            case 32:
            case 34:
                objArr[0] = "annotations";
                break;
            case 2:
            case 5:
            case 9:
                objArr[0] = "parameterAnnotations";
                break;
            case 3:
            case 7:
            case 13:
            case 15:
            case 17:
            default:
                objArr[0] = "propertyDescriptor";
                break;
            case 6:
            case 11:
            case 19:
                objArr[0] = "sourceElement";
                break;
            case 10:
                objArr[0] = "visibility";
                break;
            case 12:
            case 23:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
                break;
            case 20:
                objArr[0] = "containingClass";
                break;
            case 21:
                objArr[0] = "source";
                break;
            case 22:
            case 24:
                objArr[0] = "enumClass";
                break;
            case 26:
            case 27:
            case 28:
                objArr[0] = "descriptor";
                break;
            case 29:
            case 31:
            case 33:
                objArr[0] = "owner";
                break;
        }
        if (i2 == 12) {
            objArr[1] = "createSetter";
        } else if (i2 == 23) {
            objArr[1] = "createEnumValuesMethod";
        } else if (i2 != 25) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        } else {
            objArr[1] = "createEnumValueOfMethod";
        }
        switch (i2) {
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "createSetter";
                break;
            case 12:
            case 23:
            case 25:
                break;
            case 13:
            case 14:
                objArr[2] = "createDefaultGetter";
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
                objArr[2] = "createGetter";
                break;
            case 20:
            case 21:
                objArr[2] = "createPrimaryConstructorForObject";
                break;
            case 22:
                objArr[2] = "createEnumValuesMethod";
                break;
            case 24:
                objArr[2] = "createEnumValueOfMethod";
                break;
            case 26:
                objArr[2] = "isEnumValuesMethod";
                break;
            case 27:
                objArr[2] = "isEnumValueOfMethod";
                break;
            case 28:
                objArr[2] = "isEnumSpecialMethod";
                break;
            case 29:
            case 30:
                objArr[2] = "createExtensionReceiverParameterForCallable";
                break;
            case 31:
            case 32:
                objArr[2] = "createContextReceiverParameterForCallable";
                break;
            case 33:
            case 34:
                objArr[2] = "createContextReceiverParameterForClass";
                break;
            default:
                objArr[2] = "createDefaultSetter";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 != 12 && i2 != 23 && i2 != 25) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static w0 b(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, e0 e0Var, g gVar) {
        if (aVar == null) {
            a(31);
        }
        if (gVar == null) {
            a(32);
        }
        if (e0Var == null) {
            return null;
        }
        return new f0(aVar, new kotlin.reflect.y.internal.j0.i.w.o.c(aVar, e0Var, null), gVar);
    }

    public static w0 c(e eVar, e0 e0Var, g gVar) {
        if (eVar == null) {
            a(33);
        }
        if (gVar == null) {
            a(34);
        }
        if (e0Var == null) {
            return null;
        }
        return new f0(eVar, new kotlin.reflect.y.internal.j0.i.w.o.b(eVar, e0Var, null), gVar);
    }

    public static d0 d(t0 t0Var, g gVar) {
        if (t0Var == null) {
            a(13);
        }
        if (gVar == null) {
            a(14);
        }
        return i(t0Var, gVar, true, false, false);
    }

    public static kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0 e(t0 t0Var, g gVar, g gVar2) {
        if (t0Var == null) {
            a(0);
        }
        if (gVar == null) {
            a(1);
        }
        if (gVar2 == null) {
            a(2);
        }
        return m(t0Var, gVar, gVar2, true, false, false, t0Var.t());
    }

    public static y0 f(e eVar) {
        if (eVar == null) {
            a(24);
        }
        g.a aVar = g.f25179c;
        g0 g0VarM1 = g0.m1(eVar, aVar.b(), k.f23194e, b.a.SYNTHESIZED, eVar.t());
        g0 g0VarO1 = g0VarM1.S0(null, null, Collections.emptyList(), Collections.emptyList(), Collections.singletonList(new l0(g0VarM1, null, 0, aVar.b(), kotlin.reflect.y.internal.j0.f.f.x("value"), kotlin.reflect.y.internal.j0.i.t.a.f(eVar).W(), false, false, false, null, eVar.t())), eVar.s(), kotlin.p002reflect.jvm.internal.impl.descriptors.d0.FINAL, t.f25368e);
        if (g0VarO1 == null) {
            a(25);
        }
        return g0VarO1;
    }

    public static y0 g(e eVar) {
        if (eVar == null) {
            a(22);
        }
        g0 g0VarO1 = g0.m1(eVar, g.f25179c.b(), k.f23193d, b.a.SYNTHESIZED, eVar.t()).S0(null, null, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), kotlin.reflect.y.internal.j0.i.t.a.f(eVar).l(r1.INVARIANT, eVar.s()), kotlin.p002reflect.jvm.internal.impl.descriptors.d0.FINAL, t.f25368e);
        if (g0VarO1 == null) {
            a(23);
        }
        return g0VarO1;
    }

    public static w0 h(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, e0 e0Var, g gVar) {
        if (aVar == null) {
            a(29);
        }
        if (gVar == null) {
            a(30);
        }
        if (e0Var == null) {
            return null;
        }
        return new f0(aVar, new d(aVar, e0Var, null), gVar);
    }

    public static d0 i(t0 t0Var, g gVar, boolean z, boolean z2, boolean z3) {
        if (t0Var == null) {
            a(15);
        }
        if (gVar == null) {
            a(16);
        }
        return j(t0Var, gVar, z, z2, z3, t0Var.t());
    }

    public static d0 j(t0 t0Var, g gVar, boolean z, boolean z2, boolean z3, z0 z0Var) {
        if (t0Var == null) {
            a(17);
        }
        if (gVar == null) {
            a(18);
        }
        if (z0Var == null) {
            a(19);
        }
        return new d0(t0Var, gVar, t0Var.j(), t0Var.getVisibility(), z, z2, z3, b.a.DECLARATION, null, z0Var);
    }

    public static f k(e eVar, z0 z0Var) {
        if (eVar == null) {
            a(20);
        }
        if (z0Var == null) {
            a(21);
        }
        return new a(eVar, z0Var, false);
    }

    public static kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0 l(t0 t0Var, g gVar, g gVar2, boolean z, boolean z2, boolean z3, u uVar, z0 z0Var) {
        if (t0Var == null) {
            a(7);
        }
        if (gVar == null) {
            a(8);
        }
        if (gVar2 == null) {
            a(9);
        }
        if (uVar == null) {
            a(10);
        }
        if (z0Var == null) {
            a(11);
        }
        kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0 e0Var = new kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0(t0Var, gVar, t0Var.j(), uVar, z, z2, z3, b.a.DECLARATION, null, z0Var);
        e0Var.S0(kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0.Q0(e0Var, t0Var.getType(), gVar2));
        return e0Var;
    }

    public static kotlin.p002reflect.jvm.internal.impl.descriptors.p1.e0 m(t0 t0Var, g gVar, g gVar2, boolean z, boolean z2, boolean z3, z0 z0Var) {
        if (t0Var == null) {
            a(3);
        }
        if (gVar == null) {
            a(4);
        }
        if (gVar2 == null) {
            a(5);
        }
        if (z0Var == null) {
            a(6);
        }
        return l(t0Var, gVar, gVar2, z, z2, z3, t0Var.getVisibility(), z0Var);
    }

    private static boolean n(y yVar) {
        if (yVar == null) {
            a(28);
        }
        return yVar.i() == b.a.SYNTHESIZED && d.A(yVar.b());
    }

    public static boolean o(y yVar) {
        if (yVar == null) {
            a(27);
        }
        return yVar.getName().equals(k.f23194e) && n(yVar);
    }

    public static boolean p(y yVar) {
        if (yVar == null) {
            a(26);
        }
        return yVar.getName().equals(k.f23193d) && n(yVar);
    }
}
