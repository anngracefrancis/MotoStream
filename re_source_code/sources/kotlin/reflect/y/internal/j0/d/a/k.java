package kotlin.reflect.y.internal.j0.d.a;

import kotlin.p002reflect.jvm.internal.impl.descriptors.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.y.internal.j0.b.c;
import kotlin.reflect.y.internal.j0.i.d;

/* JADX INFO: compiled from: DescriptorsJvmAbiUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    private static /* synthetic */ void a(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "companionObject";
        } else if (i2 != 3) {
            objArr[0] = "propertyDescriptor";
        } else {
            objArr[0] = "memberDescriptor";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/DescriptorsJvmAbiUtil";
        if (i2 == 1) {
            objArr[2] = "isClassCompanionObjectWithBackingFieldsInOuter";
        } else if (i2 == 2) {
            objArr[2] = "isMappedIntrinsicCompanionObject";
        } else if (i2 != 3) {
            objArr[2] = "isPropertyWithBackingFieldInOuterClass";
        } else {
            objArr[2] = "hasJvmFieldAnnotation";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public static boolean b(b bVar) {
        w wVarQ0;
        if (bVar == null) {
            a(3);
        }
        if ((bVar instanceof t0) && (wVarQ0 = ((t0) bVar).q0()) != null && wVarQ0.getAnnotations().R0(z.f23705b)) {
            return true;
        }
        return bVar.getAnnotations().R0(z.f23705b);
    }

    public static boolean c(m mVar) {
        if (mVar == null) {
            a(1);
        }
        return d.x(mVar) && d.w(mVar.b()) && !d((e) mVar);
    }

    public static boolean d(e eVar) {
        if (eVar == null) {
            a(2);
        }
        return kotlin.reflect.y.internal.j0.b.d.a(c.a, eVar);
    }

    public static boolean e(t0 t0Var) {
        if (t0Var == null) {
            a(0);
        }
        if (t0Var.i() == b.a.FAKE_OVERRIDE) {
            return false;
        }
        if (c(t0Var.b())) {
            return true;
        }
        return d.x(t0Var.b()) && b(t0Var);
    }
}
