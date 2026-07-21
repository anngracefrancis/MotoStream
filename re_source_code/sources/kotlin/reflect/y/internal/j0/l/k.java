package kotlin.reflect.y.internal.j0.l;

import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: AnnotationsTypeAttribute.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k {
    static final /* synthetic */ KProperty<Object>[] a = {g0.h(new y(g0.d(k.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ReadOnlyProperty f24752b;

    static {
        ReadOnlyProperty readOnlyPropertyC = a1.f24676g.c(g0.b(j.class));
        m.d(readOnlyPropertyC, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        f24752b = readOnlyPropertyC;
    }

    public static final g a(a1 a1Var) {
        g gVarE;
        m.f(a1Var, "<this>");
        j jVarB = b(a1Var);
        return (jVarB == null || (gVarE = jVarB.e()) == null) ? g.f25179c.b() : gVarE;
    }

    public static final j b(a1 a1Var) {
        m.f(a1Var, "<this>");
        return (j) f24752b.a(a1Var, a[0]);
    }
}
