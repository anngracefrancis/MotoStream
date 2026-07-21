package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import kotlin.reflect.y.internal.j0.d.a.n0.h;
import kotlin.reflect.y.internal.j0.d.a.n0.x;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends f implements h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class<?> f25357c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(f fVar, Class<?> cls) {
        super(fVar, null);
        kotlin.jvm.internal.m.f(cls, "klass");
        this.f25357c = cls;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.h
    public x c() {
        return z.a.a(this.f25357c);
    }
}
