package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import kotlin.reflect.y.internal.j0.d.a.n0.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class q extends f implements m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Enum<?> f25360c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(f fVar, Enum<?> r3) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(r3, "value");
        this.f25360c = r3;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.m
    public b b() {
        Class<?> enclosingClass = this.f25360c.getClass();
        if (!enclosingClass.isEnum()) {
            enclosingClass = enclosingClass.getEnclosingClass();
        }
        kotlin.jvm.internal.m.e(enclosingClass, "enumClass");
        return d.a(enclosingClass);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.m
    public f d() {
        return f.x(this.f25360c.name());
    }
}
