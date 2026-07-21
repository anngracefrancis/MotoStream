package kotlin.p002reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import java.util.List;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.m0;

/* JADX INFO: compiled from: ClassDescriptor.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e extends g, i {
    boolean A();

    boolean D();

    h D0();

    List<w0> F0();

    Collection<e> J();

    boolean J0();

    w0 K0();

    d R();

    h S();

    e U();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.m
    e a();

    h a0(j1 j1Var);

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.n, kotlin.p002reflect.jvm.internal.impl.descriptors.m
    m b();

    u getVisibility();

    f i();

    boolean isInline();

    d0 j();

    Collection<d> k();

    boolean l();

    @Override // kotlin.p002reflect.jvm.internal.impl.descriptors.h
    m0 s();

    List<e1> w();

    h y0();

    g1<m0> z0();
}
