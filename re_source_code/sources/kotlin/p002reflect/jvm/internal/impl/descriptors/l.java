package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l1;

/* JADX INFO: compiled from: ConstructorDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l extends y {
    boolean B();

    e C();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.n, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    i b();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.y, kotlin.p002reflect.jvm.internal.impl.descriptors.b1
    l c(l1 l1Var);

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    e0 getReturnType();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.a
    List<e1> getTypeParameters();
}
