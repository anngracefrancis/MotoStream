package kotlin.p002reflect.jvm.internal.impl.descriptors.p1;

import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.p002reflect.jvm.internal.impl.descriptors.t0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.w;

/* JADX INFO: compiled from: FieldDescriptorImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o extends b implements w {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final t0 f25264g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(g gVar, t0 t0Var) {
        super(gVar);
        m.f(gVar, "annotations");
        m.f(t0Var, "correspondingProperty");
        this.f25264g = t0Var;
    }
}
