package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.a;
import kotlin.reflect.y.internal.j0.d.a.n0.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaAnnotation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends p implements a {
    private final Annotation a;

    public e(Annotation annotation) {
        m.f(annotation, "annotation");
        this.a = annotation;
    }

    public final Annotation R() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public l z() {
        return new l(kotlin.jvm.a.b(kotlin.jvm.a.a(this.a)));
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public Collection<b> b() throws IllegalAccessException, InvocationTargetException {
        Method[] declaredMethods = kotlin.jvm.a.b(kotlin.jvm.a.a(this.a)).getDeclaredMethods();
        m.e(declaredMethods, "annotation.annotationClass.java.declaredMethods");
        ArrayList arrayList = new ArrayList(declaredMethods.length);
        for (Method method : declaredMethods) {
            f.a aVar = f.a;
            Object objInvoke = method.invoke(this.a, new Object[0]);
            m.e(objInvoke, "method.invoke(annotation)");
            arrayList.add(aVar.a(objInvoke, f.x(method.getName())));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public kotlin.reflect.y.internal.j0.f.b e() {
        return d.a(kotlin.jvm.a.b(kotlin.jvm.a.a(this.a)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof e) && this.a == ((e) obj).a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public boolean g() {
        return a.C0336a.b(this);
    }

    public int hashCode() {
        return System.identityHashCode(this.a);
    }

    public String toString() {
        return e.class.getName() + ": " + this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.a
    public boolean v() {
        return a.C0336a.a(this);
    }
}
