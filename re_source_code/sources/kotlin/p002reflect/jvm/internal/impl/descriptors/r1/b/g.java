package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.a;
import kotlin.reflect.y.internal.j0.d.a.n0.c;
import kotlin.reflect.y.internal.j0.f.f;

/* JADX INFO: compiled from: ReflectJavaAnnotationArguments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends f implements c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Annotation f25343c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, Annotation annotation) {
        super(fVar, null);
        m.f(annotation, "annotation");
        this.f25343c = annotation;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.c
    public a a() {
        return new e(this.f25343c);
    }
}
