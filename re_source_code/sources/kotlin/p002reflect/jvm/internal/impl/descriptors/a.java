package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.y.internal.j0.l.e0;

/* JADX INFO: compiled from: CallableDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a extends n, q, b1<a> {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.descriptors.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CallableDescriptor.java */
    public interface InterfaceC0406a<V> {
    }

    boolean G();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    a a();

    Collection<? extends a> e();

    List<i1> f();

    w0 f0();

    e0 getReturnType();

    List<e1> getTypeParameters();

    <V> V i0(InterfaceC0406a<V> interfaceC0406a);

    w0 m0();

    List<w0> r0();
}
