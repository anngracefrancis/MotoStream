package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.b;
import kotlin.reflect.y.internal.j0.d.a.n0.b0;
import kotlin.reflect.y.internal.j0.d.a.n0.r;

/* JADX INFO: compiled from: ReflectJavaMethod.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends t implements r {
    private final Method a;

    public u(Method method) {
        m.f(method, "member");
        this.a = method;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.r
    public boolean L() {
        return r.a.a(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.t
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public Method U() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.r
    /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
    public z getReturnType() {
        z.a aVar = z.a;
        Type genericReturnType = U().getGenericReturnType();
        m.e(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.r
    public List<b0> f() {
        Type[] genericParameterTypes = U().getGenericParameterTypes();
        m.e(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = U().getParameterAnnotations();
        m.e(parameterAnnotations, "member.parameterAnnotations");
        return V(genericParameterTypes, parameterAnnotations, U().isVarArgs());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.z
    public List<a0> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = U().getTypeParameters();
        m.e(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Method> typeVariable : typeParameters) {
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.r
    public b s() {
        Object defaultValue = U().getDefaultValue();
        if (defaultValue != null) {
            return f.a.a(defaultValue, null);
        }
        return null;
    }
}
