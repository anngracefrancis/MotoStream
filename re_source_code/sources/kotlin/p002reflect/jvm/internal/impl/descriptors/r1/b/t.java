package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m1;
import kotlin.reflect.y.internal.j0.d.a.n0.b0;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.f.h;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class t extends p implements h, v, q {
    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.v
    public int E() {
        return U().getModifiers();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean Q() {
        return v.a.d(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public e l(c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public List<e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.q
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public l P() {
        Class<?> declaringClass = U().getDeclaringClass();
        m.e(declaringClass, "member.declaringClass");
        return new l(declaringClass);
    }

    public abstract Member U();

    protected final List<b0> V(Type[] typeArr, Annotation[][] annotationArr, boolean z) throws IllegalAccessException, InvocationTargetException {
        String str;
        m.f(typeArr, "parameterTypes");
        m.f(annotationArr, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(typeArr.length);
        List<String> listB = c.a.b(U());
        int size = listB != null ? listB.size() - typeArr.length : 0;
        int length = typeArr.length;
        int i2 = 0;
        while (i2 < length) {
            z zVarA = z.a.a(typeArr[i2]);
            if (listB != null) {
                str = (String) s.X(listB, i2 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i2 + '+' + size + " (name=" + getName() + " type=" + zVarA + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new b0(zVarA, annotationArr[i2], str, z && i2 == n.A(typeArr)));
            i2++;
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        return (obj instanceof t) && m.a(U(), ((t) obj).U());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.t
    public f getName() {
        String name = U().getName();
        f fVarX = name != null ? f.x(name) : null;
        return fVarX == null ? h.f24216b : fVarX;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public m1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return U().hashCode();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return h.a.c(this);
    }

    public String toString() {
        return getClass().getName() + ": " + U();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b.h
    public AnnotatedElement w() {
        Member memberU = U();
        m.d(memberU, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) memberU;
    }
}
