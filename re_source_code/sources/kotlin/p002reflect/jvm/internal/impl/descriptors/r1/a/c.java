package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.collections.j;
import kotlin.jvm.a;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.d;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.i.r.f;
import kotlin.reflect.y.internal.j0.i.u.e;

/* JADX INFO: compiled from: ReflectKotlinClass.kt */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    public static final c a = new c();

    private c() {
    }

    private final f a(Class<?> cls) {
        int i2 = 0;
        while (cls.isArray()) {
            i2++;
            cls = cls.getComponentType();
            m.e(cls, "currentClass.componentType");
        }
        if (!cls.isPrimitive()) {
            b bVarA = d.a(cls);
            kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
            kotlin.reflect.y.internal.j0.f.c cVarB = bVarA.b();
            m.e(cVarB, "javaClassId.asSingleFqName()");
            b bVarM = cVar.m(cVarB);
            if (bVarM != null) {
                bVarA = bVarM;
            }
            return new f(bVarA, i2);
        }
        if (m.a(cls, Void.TYPE)) {
            b bVarM2 = b.m(k.a.f23205f.l());
            m.e(bVarM2, "topLevel(StandardNames.FqNames.unit.toSafe())");
            return new f(bVarM2, i2);
        }
        i iVarX = e.k(cls.getName()).x();
        m.e(iVarX, "get(currentClass.name).primitiveType");
        if (i2 > 0) {
            b bVarM3 = b.m(iVarX.k());
            m.e(bVarM3, "topLevel(primitiveType.arrayTypeFqName)");
            return new f(bVarM3, i2 - 1);
        }
        b bVarM4 = b.m(iVarX.u());
        m.e(bVarM4, "topLevel(primitiveType.typeFqName)");
        return new f(bVarM4, i2);
    }

    private final void c(Class<?> cls, q.d dVar) throws InvocationTargetException {
        Constructor<?>[] constructorArr;
        int i2;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        m.e(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i3 = 0;
        while (i3 < length) {
            Constructor<?> constructor = declaredConstructors[i3];
            kotlin.reflect.y.internal.j0.f.f fVar = h.f24223i;
            m mVar = m.a;
            m.e(constructor, "constructor");
            q.e eVarB = dVar.b(fVar, mVar.a(constructor));
            if (eVarB == null) {
                constructorArr = declaredConstructors;
                i2 = length;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                m.e(declaredAnnotations, "constructor.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    m.e(annotation, "annotation");
                    f(eVarB, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                m.e(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length2 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length3 = parameterAnnotations.length;
                    for (int i4 = 0; i4 < length3; i4++) {
                        Annotation[] annotationArr = parameterAnnotations[i4];
                        m.e(annotationArr, "annotations");
                        int length4 = annotationArr.length;
                        int i5 = 0;
                        while (i5 < length4) {
                            Annotation annotation2 = annotationArr[i5];
                            Class<?> clsB = a.b(a.a(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            int i6 = length;
                            b bVarA = d.a(clsB);
                            int i7 = length2;
                            m.e(annotation2, "annotation");
                            q.a aVarC = eVarB.c(i4 + length2, bVarA, new b(annotation2));
                            if (aVarC != null) {
                                a.h(aVarC, annotation2, clsB);
                            }
                            i5++;
                            declaredConstructors = constructorArr2;
                            length = i6;
                            length2 = i7;
                        }
                    }
                }
                constructorArr = declaredConstructors;
                i2 = length;
                eVarB.a();
            }
            i3++;
            declaredConstructors = constructorArr;
            length = i2;
        }
    }

    private final void d(Class<?> cls, q.d dVar) throws InvocationTargetException {
        Field[] declaredFields = cls.getDeclaredFields();
        m.e(declaredFields, "klass.declaredFields");
        for (Field field : declaredFields) {
            kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(field.getName());
            m.e(fVarX, "identifier(field.name)");
            m mVar = m.a;
            m.e(field, "field");
            q.c cVarA = dVar.a(fVarX, mVar.b(field), null);
            if (cVarA != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                m.e(declaredAnnotations, "field.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    m.e(annotation, "annotation");
                    f(cVarA, annotation);
                }
                cVarA.a();
            }
        }
    }

    private final void e(Class<?> cls, q.d dVar) throws InvocationTargetException {
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        m.e(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(method.getName());
            m.e(fVarX, "identifier(method.name)");
            m mVar = m.a;
            m.e(method, "method");
            q.e eVarB = dVar.b(fVarX, mVar.c(method));
            if (eVarB == null) {
                methodArr = declaredMethods;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                m.e(declaredAnnotations, "method.declaredAnnotations");
                for (Annotation annotation : declaredAnnotations) {
                    m.e(annotation, "annotation");
                    f(eVarB, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                m.e(parameterAnnotations, "method.parameterAnnotations");
                int length2 = parameterAnnotations.length;
                for (int i3 = 0; i3 < length2; i3++) {
                    Annotation[] annotationArr = parameterAnnotations[i3];
                    m.e(annotationArr, "annotations");
                    int length3 = annotationArr.length;
                    int i4 = 0;
                    while (i4 < length3) {
                        Annotation annotation2 = annotationArr[i4];
                        Class<?> clsB = a.b(a.a(annotation2));
                        b bVarA = d.a(clsB);
                        Method[] methodArr2 = declaredMethods;
                        m.e(annotation2, "annotation");
                        q.a aVarC = eVarB.c(i3, bVarA, new b(annotation2));
                        if (aVarC != null) {
                            a.h(aVarC, annotation2, clsB);
                        }
                        i4++;
                        declaredMethods = methodArr2;
                    }
                }
                methodArr = declaredMethods;
                eVarB.a();
            }
            i2++;
            declaredMethods = methodArr;
        }
    }

    private final void f(q.c cVar, Annotation annotation) throws InvocationTargetException {
        Class<?> clsB = a.b(a.a(annotation));
        q.a aVarB = cVar.b(d.a(clsB), new b(annotation));
        if (aVarB != null) {
            a.h(aVarB, annotation, clsB);
        }
    }

    private final void g(q.a aVar, kotlin.reflect.y.internal.j0.f.f fVar, Object obj) throws InvocationTargetException {
        Class<?> enclosingClass = obj.getClass();
        if (m.a(enclosingClass, Class.class)) {
            m.d(obj, "null cannot be cast to non-null type java.lang.Class<*>");
            aVar.b(fVar, a((Class) obj));
            return;
        }
        if (i.a.contains(enclosingClass)) {
            aVar.c(fVar, obj);
            return;
        }
        if (d.g(enclosingClass)) {
            if (!enclosingClass.isEnum()) {
                enclosingClass = enclosingClass.getEnclosingClass();
            }
            m.e(enclosingClass, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            b bVarA = d.a(enclosingClass);
            m.d(obj, "null cannot be cast to non-null type kotlin.Enum<*>");
            kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(((Enum) obj).name());
            m.e(fVarX, "identifier((value as Enum<*>).name)");
            aVar.d(fVar, bVarA, fVarX);
            return;
        }
        if (Annotation.class.isAssignableFrom(enclosingClass)) {
            Class<?>[] interfaces = enclosingClass.getInterfaces();
            m.e(interfaces, "clazz.interfaces");
            Class<?> cls = (Class) j.N(interfaces);
            m.e(cls, "annotationClass");
            q.a aVarE = aVar.e(fVar, d.a(cls));
            if (aVarE == null) {
                return;
            }
            m.d(obj, "null cannot be cast to non-null type kotlin.Annotation");
            h(aVarE, (Annotation) obj, cls);
            return;
        }
        if (!enclosingClass.isArray()) {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + enclosingClass + "): " + obj);
        }
        q.b bVarF = aVar.f(fVar);
        if (bVarF == null) {
            return;
        }
        Class<?> componentType = enclosingClass.getComponentType();
        int i2 = 0;
        if (componentType.isEnum()) {
            m.e(componentType, "componentType");
            b bVarA2 = d.a(componentType);
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr = (Object[]) obj;
            int length = objArr.length;
            while (i2 < length) {
                Object obj2 = objArr[i2];
                m.d(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                kotlin.reflect.y.internal.j0.f.f fVarX2 = kotlin.reflect.y.internal.j0.f.f.x(((Enum) obj2).name());
                m.e(fVarX2, "identifier((element as Enum<*>).name)");
                bVarF.c(bVarA2, fVarX2);
                i2++;
            }
        } else if (m.a(componentType, Class.class)) {
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr2 = (Object[]) obj;
            int length2 = objArr2.length;
            while (i2 < length2) {
                Object obj3 = objArr2[i2];
                m.d(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                bVarF.e(a((Class) obj3));
                i2++;
            }
        } else if (Annotation.class.isAssignableFrom(componentType)) {
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr3 = (Object[]) obj;
            int length3 = objArr3.length;
            while (i2 < length3) {
                Object obj4 = objArr3[i2];
                m.e(componentType, "componentType");
                q.a aVarD = bVarF.d(d.a(componentType));
                if (aVarD != null) {
                    m.d(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                    h(aVarD, (Annotation) obj4, componentType);
                }
                i2++;
            }
        } else {
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<*>");
            Object[] objArr4 = (Object[]) obj;
            int length4 = objArr4.length;
            while (i2 < length4) {
                bVarF.b(objArr4[i2]);
                i2++;
            }
        }
        bVarF.a();
    }

    private final void h(q.a aVar, Annotation annotation, Class<?> cls) throws InvocationTargetException {
        Method[] declaredMethods = cls.getDeclaredMethods();
        m.e(declaredMethods, "annotationType.declaredMethods");
        for (Method method : declaredMethods) {
            try {
                Object objInvoke = method.invoke(annotation, new Object[0]);
                m.c(objInvoke);
                kotlin.reflect.y.internal.j0.f.f fVarX = kotlin.reflect.y.internal.j0.f.f.x(method.getName());
                m.e(fVarX, "identifier(method.name)");
                g(aVar, fVarX, objInvoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void b(Class<?> cls, q.c cVar) throws InvocationTargetException {
        m.f(cls, "klass");
        m.f(cVar, "visitor");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        m.e(declaredAnnotations, "klass.declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            m.e(annotation, "annotation");
            f(cVar, annotation);
        }
        cVar.a();
    }

    public final void i(Class<?> cls, q.d dVar) throws InvocationTargetException {
        m.f(cls, "klass");
        m.f(dVar, "memberVisitor");
        e(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }
}
