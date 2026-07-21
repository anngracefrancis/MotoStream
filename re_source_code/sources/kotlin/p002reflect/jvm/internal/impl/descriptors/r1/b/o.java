package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.b0;
import kotlin.reflect.y.internal.j0.d.a.n0.k;

/* JADX INFO: compiled from: ReflectJavaConstructor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends t implements k {
    private final Constructor<?> a;

    public o(Constructor<?> constructor) {
        m.f(constructor, "member");
        this.a = constructor;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.t
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public Constructor<?> U() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.k
    public List<b0> f() {
        Type[] genericParameterTypes = U().getGenericParameterTypes();
        m.e(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return u.j();
        }
        Class<?> declaringClass = U().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) j.i(genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = U().getParameterAnnotations();
        if (parameterAnnotations.length < genericParameterTypes.length) {
            throw new IllegalStateException("Illegal generic signature: " + U());
        }
        if (parameterAnnotations.length > genericParameterTypes.length) {
            m.e(parameterAnnotations, "annotations");
            parameterAnnotations = (Annotation[][]) j.i(parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
        }
        m.e(genericParameterTypes, "realTypes");
        m.e(parameterAnnotations, "realAnnotations");
        return V(genericParameterTypes, parameterAnnotations, U().isVarArgs());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.z
    public List<a0> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = U().getTypeParameters();
        m.e(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable<Constructor<?>> typeVariable : typeParameters) {
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }
}
