package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.w;
import kotlin.reflect.y.internal.j0.d.a.n0.x;

/* JADX INFO: compiled from: ReflectJavaRecordComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class y extends t implements w {
    private final Object a;

    public y(Object obj) {
        m.f(obj, "recordComponent");
        this.a = obj;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.t
    public Member U() throws IllegalAccessException, InvocationTargetException {
        Method methodC = a.a.c(this.a);
        if (methodC != null) {
            return methodC;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.w
    public x getType() throws IllegalAccessException, InvocationTargetException {
        Class<?> clsD = a.a.d(this.a);
        if (clsD != null) {
            return new n(clsD);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.w
    public boolean h() {
        return false;
    }
}
