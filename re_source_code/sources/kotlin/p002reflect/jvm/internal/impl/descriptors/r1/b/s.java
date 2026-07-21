package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.o;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends f implements o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f25361c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(f fVar, Object obj) {
        super(fVar, null);
        m.f(obj, "value");
        this.f25361c = obj;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.o
    public Object getValue() {
        return this.f25361c;
    }
}
