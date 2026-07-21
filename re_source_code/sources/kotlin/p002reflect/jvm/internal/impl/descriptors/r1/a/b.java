package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.a;

import java.lang.annotation.Annotation;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.a1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;

/* JADX INFO: compiled from: ReflectAnnotationSource.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements z0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Annotation f25315b;

    public b(Annotation annotation) {
        m.f(annotation, "annotation");
        this.f25315b = annotation;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.z0
    public a1 a() {
        a1 a1Var = a1.a;
        m.e(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    public final Annotation d() {
        return this.f25315b;
    }
}
